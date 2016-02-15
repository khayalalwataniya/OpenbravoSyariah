/*
 *************************************************************************
 * The contents of this file are subject to the Openbravo  Public  License
 * Version  1.0  (the  "License"),  being   the  Mozilla   Public  License
 * Version 1.1  with a permitted attribution clause; you may not  use this
 * file except in compliance with the License. You  may  obtain  a copy of
 * the License at http://www.openbravo.com/legal/license.html
 * Software distributed under the License  is  distributed  on  an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific  language  governing  rights  and  limitations
 * under the License.
 * The Original Code is Openbravo ERP.
 * The Initial Developer of the Original Code is Openbravo SLU
 * All portions are Copyright (C) 2010-2014 Openbravo SLU
 * All Rights Reserved.
 * Contributor(s):  ______________________________________.
 *************************************************************************
 */
package org.openbravo.advpaymentmngt.process;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openbravo.advpaymentmngt.dao.AdvPaymentMngtDao;
import org.openbravo.advpaymentmngt.dao.TransactionsDao;
import org.openbravo.advpaymentmngt.exception.NoExecutionProcessFoundException;
import org.openbravo.advpaymentmngt.utility.FIN_PaymentExecutionProcess;
import org.openbravo.advpaymentmngt.utility.FIN_Utility;
import org.openbravo.advpaymentmngt.utility.Value;
import org.openbravo.base.secureApp.VariablesSecureApp;
import org.openbravo.client.kernel.RequestContext;
import org.openbravo.dal.core.OBContext;
import org.openbravo.dal.service.OBDal;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.erpCommon.utility.OBError;
import org.openbravo.erpCommon.utility.OBMessageUtils;
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.financialmgmt.payment.FIN_FinaccTransaction;
import org.openbravo.model.financialmgmt.payment.FIN_Payment;
import org.openbravo.model.financialmgmt.payment.FIN_PaymentDetail;
import org.openbravo.model.financialmgmt.payment.FIN_PaymentPropDetailV;
import org.openbravo.model.financialmgmt.payment.FIN_PaymentProposal;
import org.openbravo.model.financialmgmt.payment.FIN_PaymentScheduleDetail;
import org.openbravo.model.financialmgmt.payment.PaymentExecutionProcess;
import org.openbravo.model.financialmgmt.payment.PaymentExecutionProcessParameter;
import org.openbravo.model.financialmgmt.payment.PaymentRun;
import org.openbravo.model.financialmgmt.payment.PaymentRunPayment;
import org.openbravo.scheduling.ProcessBundle;
import org.openbravo.service.db.DalConnectionProvider;

public class FIN_ExecutePayment {
  private AdvPaymentMngtDao dao;
  private FIN_PaymentExecutionProcess paymentExecutionProcess = null;
  private PaymentExecutionProcess executionProcess;
  private HashMap<String, String> constantParameters;
  private HashMap<String, String> parameters;
  private PaymentRun paymentRun;

  public void init(String sourceType, PaymentExecutionProcess _executionProcess,
      List<FIN_Payment> payments, HashMap<String, String> _parameters, Organization organization)
      throws NoExecutionProcessFoundException {

    this.dao = new AdvPaymentMngtDao();
    this.executionProcess = _executionProcess;
    setConstantParameters();
    if (_parameters == null)
      setDefaultParameters();
    else
      this.parameters = _parameters;
    this.paymentRun = dao.getNewPaymentRun(sourceType, executionProcess, organization);
    Set<FIN_Payment> paymentSet = new HashSet<FIN_Payment>(payments);
    for (FIN_Payment payment : paymentSet)
      dao.getNewPaymentRunPayment(paymentRun, payment);
    final List<PaymentExecutionProcessParameter> allParameters = executionProcess
        .getFinancialMgmtPaymentExecutionProcessParameterList();
    for (PaymentExecutionProcessParameter parameter : allParameters)
      if ("IN".equals(parameter.getParameterType()))
        dao.getNewPaymentRunParameter(paymentRun, parameter,
            parameters.get(parameter.getSearchKey()));
      else if ("CONSTANT".equals(parameter.getParameterType()))
        dao.getNewPaymentRunParameter(paymentRun, parameter, parameter.getDefaultTextValue());
    try {
      this.paymentExecutionProcess = (FIN_PaymentExecutionProcess) Class.forName(
          executionProcess.getJavaClassName()).newInstance();
    } catch (InstantiationException e) {
      throw new NoExecutionProcessFoundException(e);
    } catch (IllegalAccessException e) {
      throw new NoExecutionProcessFoundException(e);
    } catch (ClassNotFoundException e) {
      throw new NoExecutionProcessFoundException(e);
    }

  }

  public OBError execute() {
    try {
      String strmessage1 = OBMessageUtils.messageBD("ThebusinessPartner");
      String strmessage2 = OBMessageUtils.messageBD("BusinessPartnerBlocked");
      for (PaymentRunPayment payRunPayment : paymentRun.getFinancialMgmtPaymentRunPaymentList()) {
        FIN_Payment payment = payRunPayment.getPayment();
        if (payment.getBusinessPartner() != null) {
          if (FIN_Utility.isBlockedBusinessPartner(payment.getBusinessPartner().getId(),
              payment.isReceipt(), 4)) {
            // If the Business Partner is blocked, the Payment can not be completed.
            OBError error = new OBError();
            error.setType("Error");
            error.setMessage(strmessage1 + " " + payment.getBusinessPartner().getIdentifier() + " "
                + strmessage2);
            OBDal.getInstance().rollbackAndClose();
            return error;
          }
        } else {
          OBContext.setAdminMode(true);
          try {
            for (FIN_PaymentDetail pd : payment.getFINPaymentDetailList()) {
              for (FIN_PaymentScheduleDetail psd : pd.getFINPaymentScheduleDetailList()) {
                BusinessPartner bPartner = null;
                if (psd.getInvoicePaymentSchedule() != null) {
                  bPartner = psd.getInvoicePaymentSchedule().getInvoice().getBusinessPartner();
                } else if (psd.getOrderPaymentSchedule() != null) {
                  bPartner = psd.getOrderPaymentSchedule().getOrder().getBusinessPartner();
                }
                if (bPartner != null
                    && FIN_Utility.isBlockedBusinessPartner(bPartner.getId(), payment.isReceipt(),
                        4)) {
                  // If the Business Partner is blocked for Payments, the Payment will not be
                  // completed.
                  OBError error = new OBError();
                  error.setType("Error");
                  error
                      .setMessage(strmessage1 + " " + bPartner.getIdentifier() + " " + strmessage2);
                  OBDal.getInstance().rollbackAndClose();
                  return error;
                }
              }
            }
          } finally {
            OBContext.restorePreviousMode();
          }
        }
      }

      if (paymentExecutionProcess != null) {
        for (PaymentRunPayment paymentRunPayment : paymentRun
            .getFinancialMgmtPaymentRunPaymentList()) {
          if (dao.isPaymentBeingExecuted(paymentRunPayment.getPayment())) {
            paymentRunPayment.setResult("E");
            paymentRunPayment.setMessage("@APRM_PaymentInExecution@");
            OBDal.getInstance().save(paymentRunPayment);
            OBDal.getInstance().flush();
          } else
            dao.setPaymentExecuting(paymentRunPayment.getPayment(), true);
        }

        OBError result = paymentExecutionProcess.execute(paymentRun);

        for (PaymentRunPayment paymentRunPayment : paymentRun
            .getFinancialMgmtPaymentRunPaymentList()) {
          if (dao.isPaymentBeingExecuted(paymentRunPayment.getPayment())) {
            dao.setPaymentExecuting(paymentRunPayment.getPayment(), false);
            if ("S".equals(paymentRunPayment.getResult()))
              dao.removeFromExecutionPending(paymentRunPayment.getPayment());
          }

          FIN_Payment payment = paymentRunPayment.getPayment();
          if ((FIN_Utility.invoicePaymentStatus(payment).equals(payment.getStatus()))) {
            for (FIN_PaymentDetail pd : payment.getFINPaymentDetailList()) {
              for (FIN_PaymentScheduleDetail psd : pd.getFINPaymentScheduleDetailList()) {
                psd.setInvoicePaid(true);
              }
            }
          }

          if ("S".equals(paymentRunPayment.getResult())) {
            if ("PPW".equals(paymentRun.getSourceOfTheExecution())) {
              FIN_PaymentProposal pp = getPaymentProposalFromPayment(paymentRunPayment.getPayment());
              pp.setStatus("PPM");
              OBDal.getInstance().save(pp);
              OBDal.getInstance().flush();
            }
            paymentRunPayment.getPayment().setPosted("N");
            try {
              OBContext.setAdminMode(true);
              for (FIN_PaymentDetail pd : payment.getFINPaymentDetailList()) {
                for (FIN_PaymentScheduleDetail psd : pd.getFINPaymentScheduleDetailList()) {
                  if (pd.getGLItem() != null || psd.isInvoicePaid()) {
                    if (FIN_Utility.isAutomaticDepositWithdrawn(paymentRunPayment.getPayment())
                        && paymentRunPayment.getPayment().getAmount().compareTo(BigDecimal.ZERO) != 0) {
                      FIN_FinaccTransaction transaction = TransactionsDao
                          .createFinAccTransaction(paymentRunPayment.getPayment());
                      VariablesSecureApp vars = new VariablesSecureApp(RequestContext.get()
                          .getRequest());
                      OBError processTransactionError = processTransaction(vars,
                          new DalConnectionProvider(), "P", transaction);
                      if (processTransactionError != null
                          && "Error".equals(processTransactionError.getType())) {
                        return processTransactionError;
                      }
                    }
                    updatePaymentAmounts(paymentRunPayment.getPayment());
                  }
                }
                break;
              }
            } finally {
              OBContext.restorePreviousMode();
            }
          }
          OBDal.getInstance().save(paymentRunPayment.getPayment());

        }
        OBDal.getInstance().flush();
        return result;
      } else {
        OBError error = new OBError();
        error.setType("Error");
        error.setMessage("@NoExecutionProcessFound@");
        return error;
      }
    } catch (final Exception e) {
      OBDal.getInstance().rollbackAndClose();
      e.printStackTrace(System.err);
      OBError error = new OBError();
      error.setType("Error");
      error.setMessage(e.getMessage());
      return error;
    }
  }

  FIN_PaymentProposal getPaymentProposalFromPayment(FIN_Payment payment) {
    FIN_PaymentPropDetailV ppv = FIN_Utility.getOneInstance(FIN_PaymentPropDetailV.class,
        new Value(FIN_PaymentPropDetailV.PROPERTY_PAYMENT, payment));
    return ppv.getPaymentProposal();
  }

  private void setDefaultParameters() {
    final List<PaymentExecutionProcessParameter> allParameters = executionProcess
        .getFinancialMgmtPaymentExecutionProcessParameterList();
    for (PaymentExecutionProcessParameter parameter : allParameters)
      if ("IN".equals(parameter.getInputType()))
        if ("CHECK".equals(parameter.getParameterType()))
          constantParameters.put(parameter.getSearchKey(), parameter.getDefaultValueForFlag());
        else if ("TEXT".equals(parameter.getParameterType()))
          constantParameters.put(parameter.getSearchKey(), parameter.getDefaultTextValue());
  }

  private void setConstantParameters() {
    final List<PaymentExecutionProcessParameter> allParameters = executionProcess
        .getFinancialMgmtPaymentExecutionProcessParameterList();
    for (PaymentExecutionProcessParameter parameter : allParameters)
      if ("CONSTANT".equals(parameter.getInputType()))
        constantParameters.put(parameter.getSearchKey(), parameter.getDefaultTextValue());
  }

  private static void updatePaymentAmounts(FIN_Payment payment) {
    for (FIN_PaymentDetail pDetail : payment.getFINPaymentDetailList()) {
      for (FIN_PaymentScheduleDetail psd : pDetail.getFINPaymentScheduleDetailList()) {
        if (psd.getInvoicePaymentSchedule() != null) {
          BusinessPartner bPartner = psd.getInvoicePaymentSchedule().getInvoice()
              .getBusinessPartner();
          BigDecimal creditUsed = bPartner.getCreditUsed();
          BigDecimal amountWithSign = psd.getInvoicePaymentSchedule().getInvoice()
              .isSalesTransaction() ? psd.getAmount() : psd.getAmount().negate();
          creditUsed = creditUsed.subtract(amountWithSign);
          bPartner.setCreditUsed(creditUsed);
          OBDal.getInstance().save(bPartner);
          FIN_AddPayment.updatePaymentScheduleAmounts(pDetail, psd.getInvoicePaymentSchedule(),
              psd.getAmount(), psd.getWriteoffAmount());
        }
        if (psd.getOrderPaymentSchedule() != null) {
          FIN_AddPayment.updatePaymentScheduleAmounts(pDetail, psd.getOrderPaymentSchedule(),
              psd.getAmount(), psd.getWriteoffAmount());
        }
        if (pDetail.isPrepayment() && psd.getOrderPaymentSchedule() == null
            && psd.getInvoicePaymentSchedule() == null) {
          // This PSD is credit
          BusinessPartner bPartner = psd.getPaymentDetails().getFinPayment().getBusinessPartner();
          BigDecimal creditUsed = bPartner.getCreditUsed();
          BigDecimal amountWithSign = psd.getPaymentDetails().getFinPayment().isReceipt() ? psd
              .getAmount() : psd.getAmount().negate();
          creditUsed = creditUsed.subtract(amountWithSign);
          bPartner.setCreditUsed(creditUsed);
          OBDal.getInstance().save(bPartner);
        }
      }
    }
    // When credit is used (consumed) we compensate so_creditused as this amount is already
    // included in the payment details. Credit consumed should not affect to so_creditused
    if (payment.getGeneratedCredit().compareTo(BigDecimal.ZERO) == 0
        && payment.getUsedCredit().compareTo(BigDecimal.ZERO) != 0) {
      BusinessPartner bp = payment.getBusinessPartner();
      if (payment.isReceipt()) {
        bp.setCreditUsed(bp.getCreditUsed().add(payment.getUsedCredit()));
      } else {
        bp.setCreditUsed(bp.getCreditUsed().subtract(payment.getUsedCredit()));
      }
      OBDal.getInstance().save(bp);
    }
  }

  /**
   * It calls the Transaction Process for the given transaction and action.
   * 
   * @param vars
   *          VariablesSecureApp with the session data.
   * @param conn
   *          ConnectionProvider with the connection being used.
   * @param strAction
   *          String with the action of the process. {P, D, R}
   * @param transaction
   *          FIN_FinaccTransaction that needs to be processed.
   * @return a OBError with the result message of the process.
   * @throws Exception
   */
  private OBError processTransaction(VariablesSecureApp vars, ConnectionProvider conn,
      String strAction, FIN_FinaccTransaction transaction) throws Exception {
    ProcessBundle pb = new ProcessBundle("F68F2890E96D4D85A1DEF0274D105BCE", vars).init(conn);
    HashMap<String, Object> parameters = new HashMap<String, Object>();
    parameters.put("action", strAction);
    parameters.put("Fin_FinAcc_Transaction_ID", transaction.getId());
    pb.setParams(parameters);
    OBError myMessage = null;
    new FIN_TransactionProcess().execute(pb);
    myMessage = (OBError) pb.getResult();
    return myMessage;
  }

}
