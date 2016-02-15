/*
 *************************************************************************
 * The contents of this file are subject to the Openbravo  Public  License
 * Version  1.1  (the  "License"),  being   the  Mozilla   Public  License
 * Version 1.1  with a permitted attribution clause; you may not  use this
 * file except in compliance with the License. You  may  obtain  a copy of
 * the License at http://www.openbravo.com/legal/license.html
 * Software distributed under the License  is  distributed  on  an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific  language  governing  rights  and  limitations
 * under the License.
 * The Original Code is Openbravo ERP.
 * The Initial Developer of the Original Code is Openbravo SLU
 * All portions are Copyright (C) 2014 Openbravo SLU
 * All Rights Reserved.
 * Contributor(s):  ______________________________________.
 ************************************************************************
 */
package org.openbravo.advpaymentmngt.filterexpression;

import java.math.BigDecimal;
import java.util.Map;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.openbravo.advpaymentmngt.utility.APRMConstants;
import org.openbravo.client.kernel.ComponentProvider;
import org.openbravo.dal.service.OBDal;
import org.openbravo.erpCommon.utility.OBDateUtils;
import org.openbravo.model.financialmgmt.payment.FIN_Payment;

@ComponentProvider.Qualifier(APRMConstants.PAYMENT_OUT_WINDOW_ID)
public class PaymentOutAddPaymentDefaultValues extends AddPaymentDefaultValuesHandler {

  private static final long SEQUENCE = 100l;

  protected long getSeq() {
    return SEQUENCE;
  }

  @Override
  String getDefaultExpectedAmount(Map<String, String> requestMap) throws JSONException {
    // Expected amount is the amount on the editing payment
    BigDecimal pendingAmt = getPayment(requestMap).getAmount();
    return pendingAmt.toPlainString();
  }

  @Override
  String getDefaultActualAmount(Map<String, String> requestMap) throws JSONException {
    // Actual amount is the amount on the editing payment
    BigDecimal pendingAmt = getPayment(requestMap).getAmount();
    return pendingAmt.toPlainString();
  }

  @Override
  String getDefaultGeneratedCredit(Map<String, String> requestMap) throws JSONException {
    // Generated Credit of the current Payment
    BigDecimal generateCredit = getPayment(requestMap).getGeneratedCredit();
    if (generateCredit == null) {
      return (BigDecimal.ZERO).toPlainString();
    } else {
      return generateCredit.toPlainString();
    }
  }

  @Override
  String getDefaultIsSOTrx(Map<String, String> requestMap) {
    return "N";
  }

  @Override
  String getDefaultTransactionType(Map<String, String> requestMap) {
    return "I";
  }

  @Override
  String getDefaultPaymentType(Map<String, String> requestMap) throws JSONException {
    JSONObject context = new JSONObject(requestMap.get("context"));
    return context.getString("inpfinPaymentId");
  }

  @Override
  String getDefaultOrderType(Map<String, String> requestMap) throws JSONException {
    return "";
  }

  @Override
  String getDefaultInvoiceType(Map<String, String> requestMap) throws JSONException {
    return "";
  }

  @Override
  String getDefaultDocumentNo(Map<String, String> requestMap) throws JSONException {
    // Document Number of the current Payment
    FIN_Payment payment = getPayment(requestMap);
    return payment.getDocumentNo();
  }

  private FIN_Payment getPayment(Map<String, String> requestMap) throws JSONException {
    // Current Payment
    JSONObject context = new JSONObject(requestMap.get("context"));
    String strFinPaymentId = "";
    if (context.has("inpfinPaymentId") && !context.isNull("inpfinPaymentId")) {
      strFinPaymentId = context.getString("inpfinPaymentId");
    }
    if (context.has("Fin_Payment_ID") && !context.isNull("Fin_Payment_ID")) {
      strFinPaymentId = context.getString("Fin_Payment_ID");
    }
    FIN_Payment payment = OBDal.getInstance().get(FIN_Payment.class, strFinPaymentId);
    return payment;
  }

  @Override
  String getDefaultConversionRate(Map<String, String> requestMap) throws JSONException {
    // Conversion Rate of the current Payment
    FIN_Payment payment = getPayment(requestMap);
    return payment.getFinancialTransactionConvertRate().toPlainString();
  }

  @Override
  String getDefaultConvertedAmount(Map<String, String> requestMap) throws JSONException {
    // Converted Amount of the current Payment
    FIN_Payment payment = getPayment(requestMap);
    return payment.getFinancialTransactionAmount().toPlainString();
  }

  @Override
  String getDefaultReceivedFrom(Map<String, String> requestMap) throws JSONException {
    // Business Partner of the current Payment
    FIN_Payment payment = getPayment(requestMap);
    if (payment.getBusinessPartner() != null) {
      return payment.getBusinessPartner().getId();
    } else {
      return "";
    }
  }

  @Override
  String getDefaultStandardPrecision(Map<String, String> requestMap) throws JSONException {
    // Standard Precision of the currency
    FIN_Payment payment = getPayment(requestMap);
    return payment.getCurrency().getStandardPrecision().toString();
  }

  @Override
  String getDefaultCurrency(Map<String, String> requestMap) throws JSONException {
    // Currency of the current Payment
    FIN_Payment payment = getPayment(requestMap);
    return payment.getCurrency().getId();
  }

  @Override
  String getOrganization(Map<String, String> requestMap) throws JSONException {
    // Organization of the current Payment
    return getPayment(requestMap).getOrganization().getId();
  }

  @Override
  String getDefaultPaymentDate(Map<String, String> requestMap) throws JSONException {
    // Payment Date of the current payment
    return OBDateUtils.formatDate(getPayment(requestMap).getPaymentDate());
  }

}
