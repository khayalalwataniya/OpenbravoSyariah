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
 * All portions are Copyright (C) 2001-2014 Openbravo SLU
 * All Rights Reserved.
 * Contributor(s):  ______________________________________.
 ************************************************************************
 */
package com.gai.generalledgerrpt.erpCommon.ad_reports;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.openbravo.base.filter.IsIDFilter;
import org.openbravo.base.secureApp.HttpSecureAppServlet;
import org.openbravo.base.secureApp.VariablesSecureApp;
import org.openbravo.data.FieldProvider;
import org.openbravo.data.ScrollableFieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.erpCommon.businessUtility.AccountingSchemaMiscData;
import org.openbravo.erpCommon.businessUtility.Tree;
import org.openbravo.erpCommon.businessUtility.TreeData;
import org.openbravo.erpCommon.businessUtility.WindowTabs;
import org.openbravo.erpCommon.info.SelectorUtilityData;
import org.openbravo.erpCommon.utility.AbstractScrollableFieldProviderFilter;
import org.openbravo.erpCommon.utility.ComboTableData;
import org.openbravo.erpCommon.utility.DateTimeData;
import org.openbravo.erpCommon.utility.LeftTabsBar;
import org.openbravo.erpCommon.utility.LimitRowsScrollableFieldProviderFilter;
import org.openbravo.erpCommon.utility.NavigationBar;
import org.openbravo.erpCommon.utility.OBError;
import org.openbravo.erpCommon.utility.ToolBar;
import org.openbravo.erpCommon.utility.Utility;
import org.openbravo.xmlEngine.XmlDocument;

public class ReportGeneralLedger extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
    VariablesSecureApp vars = new VariablesSecureApp(request);

    if (vars.commandIn("DEFAULT")) {
      String strcAcctSchemaId = vars.getGlobalVariable("inpcAcctSchemaId",
          "ReportGeneralLedger|cAcctSchemaId", "");
      String strDateFrom = vars
          .getGlobalVariable("inpDateFrom", "ReportGeneralLedger|DateFrom", "");
      String strDateTo = vars.getGlobalVariable("inpDateTo", "ReportGeneralLedger|DateTo", "");
      String strPageNo = vars.getGlobalVariable("inpPageNo", "ReportGeneralLedger|PageNo", "1");
      String strAmtFrom = vars.getNumericGlobalVariable("inpAmtFrom",
          "ReportGeneralLedger|AmtFrom", "");
      String strAmtTo = vars.getNumericGlobalVariable("inpAmtTo", "ReportGeneralLedger|AmtTo", "");
      String strcelementvaluefrom = vars.getGlobalVariable("inpcElementValueIdFrom",
          "ReportGeneralLedger|C_ElementValue_IDFROM", "");
      String strcelementvalueto = vars.getGlobalVariable("inpcElementValueIdTo",
          "ReportGeneralLedger|C_ElementValue_IDTO", "");
      String strcelementvaluefromdes = "", strcelementvaluetodes = "";
      if (!strcelementvaluefrom.equals(""))
        strcelementvaluefromdes = ReportGeneralLedgerData.selectSubaccountDescription(this,
            strcelementvaluefrom);
      if (!strcelementvalueto.equals(""))
        strcelementvaluetodes = ReportGeneralLedgerData.selectSubaccountDescription(this,
            strcelementvalueto);
      strcelementvaluefromdes = (strcelementvaluefromdes.equals("null")) ? ""
          : strcelementvaluefromdes;
      strcelementvaluetodes = (strcelementvaluetodes.equals("null")) ? "" : strcelementvaluetodes;
      vars.setSessionValue("inpElementValueIdFrom_DES", strcelementvaluefromdes);
      vars.setSessionValue("inpElementValueIdTo_DES", strcelementvaluetodes);
      String strOrg = vars.getGlobalVariable("inpOrg", "ReportGeneralLedger|Org", "0");
      String strcBpartnerId = vars.getInGlobalVariable("inpcBPartnerId_IN",
          "ReportGeneralLedger|cBpartnerId", "", IsIDFilter.instance);
      String strmProductId = vars.getInGlobalVariable("inpmProductId_IN",
          "ReportGeneralLedger|mProductId", "", IsIDFilter.instance);
      String strcProjectId = vars.getInGlobalVariable("inpcProjectId_IN",
          "ReportGeneralLedger|cProjectId", "", IsIDFilter.instance);
      String strGroupBy = vars.getGlobalVariable("inpGroupBy", "ReportGeneralLedger|GroupBy", "");
      String strShowOpenBalances = vars.getGlobalVariable("inpShowOpenBalances",
          "ReportGeneralLedger|showOpenBalances", "");
      printPageDataSheet(response, vars, strDateFrom, strDateTo, strPageNo, strAmtFrom, strAmtTo,
          strcelementvaluefrom, strcelementvalueto, strOrg, strcBpartnerId, strmProductId,
          strcProjectId, strGroupBy, strcAcctSchemaId, strcelementvaluefromdes,
          strcelementvaluetodes, strShowOpenBalances);
    } else if (vars.commandIn("FIND")) {
      String strcAcctSchemaId = vars.getRequestGlobalVariable("inpcAcctSchemaId",
          "ReportGeneralLedger|cAcctSchemaId");
      String strDateFrom = vars.getRequestGlobalVariable("inpDateFrom",
          "ReportGeneralLedger|DateFrom");
      String strDateTo = vars.getRequestGlobalVariable("inpDateTo", "ReportGeneralLedger|DateTo");
      String strPageNo = vars.getRequestGlobalVariable("inpPageNo", "ReportGeneralLedger|PageNo");
      String strAmtFrom = vars.getNumericParameter("inpAmtFrom");
      vars.setSessionValue("ReportGeneralLedger|AmtFrom", strAmtFrom);
      String strAmtTo = vars.getNumericParameter("inpAmtTo");
      vars.setSessionValue("ReportGeneralLedger|AmtTo", strAmtTo);
      String strcelementvaluefrom = vars.getRequestGlobalVariable("inpcElementValueIdFrom",
          "ReportGeneralLedger|C_ElementValue_IDFROM");
      String strcelementvalueto = vars.getRequestGlobalVariable("inpcElementValueIdTo",
          "ReportGeneralLedger|C_ElementValue_IDTO");
      String strcelementvaluefromdes = "", strcelementvaluetodes = "";
      if (!strcelementvaluefrom.equals(""))
        strcelementvaluefromdes = ReportGeneralLedgerData.selectSubaccountDescription(this,
            strcelementvaluefrom);
      if (!strcelementvalueto.equals(""))
        strcelementvaluetodes = ReportGeneralLedgerData.selectSubaccountDescription(this,
            strcelementvalueto);
      vars.setSessionValue("inpElementValueIdFrom_DES", strcelementvaluefromdes);
      vars.setSessionValue("inpElementValueIdTo_DES", strcelementvaluetodes);
      String strShowOpenBalances = vars.getRequestGlobalVariable("inpShowOpenBalances",
          "ReportGeneralLedger|showOpenBalances");
      String strOrg = vars.getGlobalVariable("inpOrg", "ReportGeneralLedger|Org", "0");
      String strcBpartnerId = vars.getRequestInGlobalVariable("inpcBPartnerId_IN",
          "ReportGeneralLedger|cBpartnerId", IsIDFilter.instance);
      String strmProductId = vars.getRequestInGlobalVariable("inpmProductId_IN",
          "ReportGeneralLedger|mProductId", IsIDFilter.instance);
      String strcProjectId = vars.getRequestInGlobalVariable("inpcProjectId_IN",
          "ReportGeneralLedger|cProjectId", IsIDFilter.instance);
      String strGroupBy = vars
          .getRequestGlobalVariable("inpGroupBy", "ReportGeneralLedger|GroupBy");
      log4j.debug("##################### DoPost - Find - strcBpartnerId= " + strcBpartnerId);
      log4j.debug("##################### DoPost - XLS - strcelementvaluefrom= "
          + strcelementvaluefrom);
      log4j.debug("##################### DoPost - XLS - strcelementvalueto= " + strcelementvalueto);
      vars.setSessionValue("ReportGeneralLedger.initRecordNumber", "0");
      printPageDataSheet(response, vars, strDateFrom, strDateTo, strPageNo, strAmtFrom, strAmtTo,
          strcelementvaluefrom, strcelementvalueto, strOrg, strcBpartnerId, strmProductId,
          strcProjectId, strGroupBy, strcAcctSchemaId, strcelementvaluefromdes,
          strcelementvaluetodes, strShowOpenBalances);
    } else if (vars.commandIn("PREVIOUS_RELATION")) {
      String strInitRecord = vars.getSessionValue("ReportGeneralLedger.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", "ReportGeneralLedger");
      int intRecordRange = strRecordRange.equals("") ? 0 : Integer.parseInt(strRecordRange);
      if (strInitRecord.equals("") || strInitRecord.equals("0"))
        vars.setSessionValue("ReportGeneralLedger.initRecordNumber", "0");
      else {
        int initRecord = (strInitRecord.equals("") ? 0 : Integer.parseInt(strInitRecord));
        initRecord -= intRecordRange;
        strInitRecord = ((initRecord < 0) ? "0" : Integer.toString(initRecord));
        vars.setSessionValue("ReportGeneralLedger.initRecordNumber", strInitRecord);
      }
      response.sendRedirect(strDireccion + request.getServletPath());
    } else if (vars.commandIn("NEXT_RELATION")) {
      String strInitRecord = vars.getSessionValue("ReportGeneralLedger.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", "ReportGeneralLedger");
      int intRecordRange = strRecordRange.equals("") ? 0 : Integer.parseInt(strRecordRange);
      int initRecord = (strInitRecord.equals("") ? 0 : Integer.parseInt(strInitRecord));
      // if (initRecord == 0)
      // initRecord = 1; Removed by DAL 30/4/09
      initRecord += intRecordRange;
      strInitRecord = ((initRecord < 0) ? "0" : Integer.toString(initRecord));
      vars.setSessionValue("ReportGeneralLedger.initRecordNumber", strInitRecord);
      response.sendRedirect(strDireccion + request.getServletPath());
    } else if (vars.commandIn("PDF", "XLS")) {
      String strcAcctSchemaId = vars.getRequestGlobalVariable("inpcAcctSchemaId",
          "ReportGeneralLedger|cAcctSchemaId");
      String strDateFrom = vars.getRequestGlobalVariable("inpDateFrom",
          "ReportGeneralLedger|DateFrom");
      String strDateTo = vars.getRequestGlobalVariable("inpDateTo", "ReportGeneralLedger|DateTo");
      String strAmtFrom = vars.getNumericParameter("inpAmtFrom");
      vars.setSessionValue("ReportGeneralLedger|AmtFrom", strAmtFrom);
      String strAmtTo = vars.getNumericParameter("inpAmtTo");
      vars.setSessionValue("ReportGeneralLedger|AmtTo", strAmtTo);
      String strcelementvaluefrom = vars.getRequestGlobalVariable("inpcElementValueIdFrom",
          "ReportGeneralLedger|C_ElementValue_IDFROM");
      String strcelementvalueto = vars.getRequestGlobalVariable("inpcElementValueIdTo",
          "ReportGeneralLedger|C_ElementValue_IDTO");
      String strOrg = vars.getGlobalVariable("inpOrg", "ReportGeneralLedger|Org", "0");
      String strcBpartnerId = vars.getRequestInGlobalVariable("inpcBPartnerId_IN",
          "ReportGeneralLedger|cBpartnerId", IsIDFilter.instance);
      String strmProductId = vars.getInGlobalVariable("inpmProductId_IN",
          "ReportGeneralLedger|mProductId", "", IsIDFilter.instance);
      String strcProjectId = vars.getInGlobalVariable("inpcProjectId_IN",
          "ReportGeneralLedger|cProjectId", "", IsIDFilter.instance);
      String strShowOpenBalances = vars.getRequestGlobalVariable("inpShowOpenBalances",
          "ReportGeneralLedger|showOpenBalances");
      String strGroupBy = vars
          .getRequestGlobalVariable("inpGroupBy", "ReportGeneralLedger|GroupBy");
      String strPageNo = vars.getGlobalVariable("inpPageNo", "ReportGeneralLedger|PageNo", "1");
      if (vars.commandIn("PDF"))
        printPageDataPDF(request, response, vars, strDateFrom, strDateTo, strAmtFrom, strAmtTo,
            strcelementvaluefrom, strcelementvalueto, strOrg, strcBpartnerId, strmProductId,
            strcProjectId, strGroupBy, strcAcctSchemaId, strPageNo, strShowOpenBalances);
      else
        printPageDataXLS(request, response, vars, strDateFrom, strDateTo, strAmtFrom, strAmtTo,
            strcelementvaluefrom, strcelementvalueto, strOrg, strcBpartnerId, strmProductId,
            strcProjectId, strGroupBy, strcAcctSchemaId, strShowOpenBalances);
    } else
      pageError(response);
  }

  private void printPageDataSheet(HttpServletResponse response, VariablesSecureApp vars,
      String strDateFrom, String strDateTo, String strPageNo, String strAmtFrom, String strAmtTo,
      String strcelementvaluefrom, String strcelementvalueto, String strOrg, String strcBpartnerId,
      String strmProductId, String strcProjectId, String strGroupBy, String strcAcctSchemaId,
      String strcelementvaluefromdes, String strcelementvaluetodes, String strShowOpenBalances)
      throws IOException, ServletException {
    String strRecordRange = Utility.getContext(this, vars, "#RecordRange", "ReportGeneralLedger");
    int intRecordRange = (strRecordRange.equals("") ? 0 : Integer.parseInt(strRecordRange));
    String strInitRecord = vars.getSessionValue("ReportGeneralLedger.initRecordNumber");
    int initRecordNumber = (strInitRecord.equals("") ? 0 : Integer.parseInt(strInitRecord));
    // built limit/offset parameters for oracle/postgres
    String rowNum = "0";
    String oraLimit1 = null;
    String oraLimit2 = null;
    String pgLimit = null;
    if (intRecordRange != 0) {
      if (this.myPool.getRDBMS().equalsIgnoreCase("ORACLE")) {
        rowNum = "ROWNUM";
        oraLimit1 = String.valueOf(initRecordNumber + intRecordRange);
        oraLimit2 = (initRecordNumber + 1) + " AND " + oraLimit1;
      } else {
        rowNum = "0";
        pgLimit = intRecordRange + " OFFSET " + initRecordNumber;
      }
    }
    log4j.debug("offset= " + initRecordNumber + " pageSize= " + intRecordRange);
    log4j.debug("Output: dataSheet");
    log4j.debug("Date From:" + strDateFrom + "- To:" + strDateTo + " - Schema:" + strcAcctSchemaId);
    response.setContentType("text/html; charset=UTF-8");
    PrintWriter out = response.getWriter();
    XmlDocument xmlDocument = null;
    ReportGeneralLedgerData[] data = null;
    String strTreeOrg = TreeData.getTreeOrg(this, vars.getClient());
    String strOrgFamily = getFamily(strTreeOrg, strOrg);
    String toDatePlusOne = DateTimeData.nDaysAfter(this, strDateTo, "1");

    String strGroupByText = (strGroupBy.equals("BPartner") ? Utility.messageBD(this, "BusPartner",
        vars.getLanguage()) : (strGroupBy.equals("Product") ? Utility.messageBD(this, "Product",
        vars.getLanguage()) : (strGroupBy.equals("Project") ? Utility.messageBD(this, "Project",
        vars.getLanguage()) : "")));

    ToolBar toolbar = new ToolBar(this, vars.getLanguage(), "ReportGeneralLedger", true, "", "",
        "imprimir();return false;", false, "ad_reports", strReplaceWith, false, true);
    String strcBpartnerIdAux = strcBpartnerId;
    String strmProductIdAux = strmProductId;
    String strcProjectIdAux = strcProjectId;
    if (strDateFrom.equals("") && strDateTo.equals("")) {
      String discard[] = { "sectionAmount", "sectionPartner" };
      xmlDocument = xmlEngine.readXmlTemplate(
          "com/gai/generalledgerrpt/erpCommon/ad_reports/ReportGeneralLedger", discard).createXmlDocument();
      toolbar
          .prepareRelationBarTemplate(false, false,
              "submitCommandForm('XLS', false, frmMain, 'ReportGeneralLedgerExcel.xls', 'EXCEL');return false;");
      data = ReportGeneralLedgerData.set();
    } else {
      String[] discard = { "discard" };
      if (strGroupBy.equals(""))
        discard[0] = "sectionPartner";
      else
        discard[0] = "sectionAmount";
      BigDecimal previousDebit = BigDecimal.ZERO;
      BigDecimal previousCredit = BigDecimal.ZERO;
      BigDecimal saldoawal = BigDecimal.ZERO;
      String strAllaccounts = "Y";
      if (strcelementvaluefrom != null && !strcelementvaluefrom.equals("")) {
        if (strcelementvalueto.equals("")) {
          strcelementvalueto = strcelementvaluefrom;
          strcelementvaluetodes = ReportGeneralLedgerData.selectSubaccountDescription(this,
              strcelementvalueto);
          vars.setSessionValue("inpElementValueIdTo_DES", strcelementvaluetodes);

        }
        strAllaccounts = "N";
        log4j.debug("##################### strcelementvaluefrom= " + strcelementvaluefrom);
        log4j.debug("##################### strcelementvalueto= " + strcelementvalueto);
      } else {
        strcelementvalueto = "";
        strcelementvaluetodes = "";
        vars.setSessionValue("inpElementValueIdTo_DES", strcelementvaluetodes);
      }
      Long initMainSelect = System.currentTimeMillis();
      ReportGeneralLedgerData scroll = null;
      try {
        scroll = ReportGeneralLedgerData.select2(this, rowNum, strGroupByText, strGroupBy,
            strAllaccounts, strcelementvaluefrom, strcelementvalueto,
            Utility.getContext(this, vars, "#AccessibleOrgTree", "ReportGeneralLedger"),
            Utility.getContext(this, vars, "#User_Client", "ReportGeneralLedger"),
            "Y".equals(strShowOpenBalances) ? strDateTo : null, strcAcctSchemaId, strDateFrom,
            toDatePlusOne, strOrgFamily, strcBpartnerId, strmProductId, strcProjectId, strAmtFrom,
            strAmtTo, null, null, pgLimit, oraLimit1, oraLimit2, null);
        Vector<ReportGeneralLedgerData> res = new Vector<ReportGeneralLedgerData>();
        while (scroll.next()) {
          res.add(scroll.get());
        }
        data = new ReportGeneralLedgerData[res.size()];
        res.copyInto(data);
      } finally {
        if (scroll != null) {
          scroll.close();
        }
      }

      log4j.debug("Select2. Time in mils: " + (System.currentTimeMillis() - initMainSelect));
      log4j.debug("RecordNo: " + initRecordNumber);

      ReportGeneralLedgerData[] dataTotal = null;
      ReportGeneralLedgerData[] dataSubtotal = null;
      String strOld = "";
      // boolean firstPagBlock = false;
      ReportGeneralLedgerData[] subreportElement = new ReportGeneralLedgerData[1];
      for (int i = 0; data != null && i < data.length; i++) {
        if (!strOld.equals(data[i].groupbyid + data[i].id)) {
          subreportElement = new ReportGeneralLedgerData[1];
          // firstPagBlock = false;
          if (i == 0 && initRecordNumber > 0) {
            // firstPagBlock = true;
            Long init = System.currentTimeMillis();
            dataTotal = ReportGeneralLedgerData.select2Total(this, rowNum, strGroupByText,
                strGroupBy, strAllaccounts, strcelementvaluefrom, strcelementvalueto,
                Utility.getContext(this, vars, "#AccessibleOrgTree", "ReportGeneralLedger"),
                Utility.getContext(this, vars, "#User_Client", "ReportGeneralLedger"),
                strcAcctSchemaId, "", DateTimeData.nDaysAfter(this, data[0].dateacct, "1"),
                strOrgFamily, strcBpartnerId, strmProductId, strcProjectId, strAmtFrom, strAmtTo,
                data[0].id, data[0].groupbyid, null, null, null, data[0].dateacctnumber
                    + data[0].factaccttype + data[0].factAcctGroupId + data[0].factAcctId);
            dataSubtotal = ReportGeneralLedgerData.select2sum(this, rowNum, strGroupByText,
                strGroupBy, strAllaccounts, strcelementvaluefrom, strcelementvalueto,
                Utility.getContext(this, vars, "#AccessibleOrgTree", "ReportGeneralLedger"),
                Utility.getContext(this, vars, "#User_Client", "ReportGeneralLedger"),
                strcAcctSchemaId, strDateFrom, toDatePlusOne, strOrgFamily,
                (strGroupBy.equals("BPartner") ? "('" + data[i].groupbyid + "')" : strcBpartnerId),
                (strGroupBy.equals("Product") ? "('" + data[i].groupbyid + "')" : strmProductId),
                (strGroupBy.equals("Project") ? "('" + data[i].groupbyid + "')" : strcProjectId),
                strAmtFrom, strAmtTo, null, null, null, null, null, data[0].dateacctnumber
                    + data[0].factaccttype + data[0].factAcctGroupId + data[0].factAcctId,
                data[0].id);

            log4j.debug("Select2Total. Time in mils: " + (System.currentTimeMillis() - init));
            // Now dataTotal is covered adding debit and credit amounts
            for (int j = 0; dataTotal != null && j < dataTotal.length; j++) {
              previousDebit = previousDebit.add(new BigDecimal(dataTotal[j].amtacctdr));
              previousCredit = previousCredit.add(new BigDecimal(dataTotal[j].amtacctcr));
            }
            subreportElement = new ReportGeneralLedgerData[1];
            subreportElement[0] = new ReportGeneralLedgerData();
            subreportElement[0].totalacctdr = previousDebit.toPlainString();
            subreportElement[0].totalacctcr = previousCredit.toPlainString();
            data[0].amtacctdrprevsum = (dataSubtotal != null) ? dataSubtotal[0].amtacctdr
                : data[0].amtacctdrprevsum;
            data[0].amtacctcrprevsum = (dataSubtotal != null) ? dataSubtotal[0].amtacctcr
                : data[0].amtacctcrprevsum;
            subreportElement[0].total = previousDebit.subtract(previousCredit).toPlainString();
          } else {
            if ("".equals(data[i].groupbyid)) {
              // The argument " " is used to simulate one value and put the optional parameter-->
              // AND FACT_ACCT.C_PROJECT_ID IS NULL for example
              Long init = System.currentTimeMillis();
              subreportElement = ReportGeneralLedgerData.selectTotal2(this, strcBpartnerId,
                  (strGroupBy.equals("BPartner") ? " " : null), strmProductId,
                  (strGroupBy.equals("Product") ? " " : null), strcProjectId,
                  (strGroupBy.equals("Project") ? " " : null), strcAcctSchemaId, data[i].id, "",
                  strDateFrom, strOrgFamily);
              log4j.debug("SelectTotalNew. Time in mils: " + (System.currentTimeMillis() - init));
            } else {
              Long init = System.currentTimeMillis();
              subreportElement = ReportGeneralLedgerData
                  .selectTotal2(this, (strGroupBy.equals("BPartner") ? "('" + data[i].groupbyid
                      + "')" : strcBpartnerId), null, (strGroupBy.equals("Product") ? "('"
                      + data[i].groupbyid + "')" : strmProductId), null, (strGroupBy
                      .equals("Project") ? "('" + data[i].groupbyid + "')" : strcProjectId), null,
                      strcAcctSchemaId, data[i].id, "", strDateFrom, strOrgFamily);
              log4j.debug("SelectTotalNew. Time in mils: " + (System.currentTimeMillis() - init));
            }
          }
          data[i].totalacctdr = subreportElement[0].totalacctdr;
          data[i].totalacctcr = subreportElement[0].totalacctcr;
        }

        data[i].totalacctsub = subreportElement[0].total;

        data[i].previousdebit = subreportElement[0].totalacctdr;
        data[i].previouscredit = subreportElement[0].totalacctcr;
        data[i].previoustotal = subreportElement[0].total;
        strOld = data[i].groupbyid + data[i].id;
      }
      // TODO: What is strTotal?? is this the proper variable name?
      String strTotal = "";
      subreportElement = new ReportGeneralLedgerData[1];
      for (int i = 0; data != null && i < data.length; i++) {
        if (!strTotal.equals(data[i].groupbyid + data[i].id)) {
          subreportElement = new ReportGeneralLedgerData[1];
          if ("".equals(data[i].groupbyid)) {
            // The argument " " is used to simulate one value and put the optional parameter--> AND
            // FACT_ACCT.C_PROJECT_ID IS NULL for example
            Long init = System.currentTimeMillis();
            subreportElement = ReportGeneralLedgerData.selectTotal2(this, strcBpartnerId,
                (strGroupBy.equals("BPartner") ? " " : null), strmProductId,
                (strGroupBy.equals("Product") ? " " : null), strcProjectId,
                (strGroupBy.equals("Project") ? " " : null), strcAcctSchemaId, data[i].id, "",
                toDatePlusOne, strOrgFamily);
            log4j.debug("SelectTotal2. Time in mils: " + (System.currentTimeMillis() - init));
          } else {
            Long init = System.currentTimeMillis();
            subreportElement = ReportGeneralLedgerData.selectTotal2(this, (strGroupBy
                .equals("BPartner") ? "('" + data[i].groupbyid + "')" : strcBpartnerId), null,
                (strGroupBy.equals("Product") ? "('" + data[i].groupbyid + "')" : strmProductId),
                null, (strGroupBy.equals("Project") ? "('" + data[i].groupbyid + "')"
                    : strcProjectId), null, strcAcctSchemaId, data[i].id, "", toDatePlusOne,
                strOrgFamily);
            log4j.debug("SelectTotal2. Time in mils: " + (System.currentTimeMillis() - init));
          }
        }

        data[i].finaldebit = subreportElement[0].totalacctdr;
        data[i].finalcredit = subreportElement[0].totalacctcr;
        data[i].finaltotal = subreportElement[0].total;
        strTotal = data[i].groupbyid + data[i].id;
      }

      boolean hasPrevious = !(data == null || data.length == 0 || initRecordNumber <= 1);
      boolean hasNext = !(data == null || data.length == 0 || data.length < intRecordRange);
      toolbar
          .prepareRelationBarTemplate(hasPrevious, hasNext,
              "submitCommandForm('XLS', true, frmMain, 'ReportGeneralLedgerExcel.xls', 'EXCEL');return false;");
      xmlDocument = xmlEngine.readXmlTemplate(
          "com/gai/generalledgerrpt/erpCommon/ad_reports/ReportGeneralLedger", discard).createXmlDocument();
    }
    xmlDocument.setParameter("toolbar", toolbar.toString());

    try {
      WindowTabs tabs = new WindowTabs(this, vars,
          "org.openbravo.erpCommon.ad_reports.ReportGeneralLedger");
      xmlDocument.setParameter("parentTabContainer", tabs.parentTabs());
      xmlDocument.setParameter("mainTabContainer", tabs.mainTabs());
      xmlDocument.setParameter("childTabContainer", tabs.childTabs());
      xmlDocument.setParameter("theme", vars.getTheme());
      NavigationBar nav = new NavigationBar(this, vars.getLanguage(), "ReportGeneralLedger.html",
          classInfo.id, classInfo.type, strReplaceWith, tabs.breadcrumb());
      xmlDocument.setParameter("navigationBar", nav.toString());
      LeftTabsBar lBar = new LeftTabsBar(this, vars.getLanguage(), "ReportGeneralLedger.html",
          strReplaceWith);
      xmlDocument.setParameter("leftTabs", lBar.manualTemplate());
    } catch (Exception ex) {
      throw new ServletException(ex);
    }
    {
      OBError myMessage = vars.getMessage("ReportGeneralLedger");
      vars.removeMessage("ReportGeneralLedger");
      if (myMessage != null) {
        xmlDocument.setParameter("messageType", myMessage.getType());
        xmlDocument.setParameter("messageTitle", myMessage.getTitle());
        xmlDocument.setParameter("messageMessage", myMessage.getMessage());
      }
    }

    xmlDocument.setParameter("calendar", vars.getLanguage().substring(0, 2));

    try {
      ComboTableData comboTableData = new ComboTableData(vars, this, "TABLEDIR", "AD_ORG_ID", "",
          "", Utility.getContext(this, vars, "#AccessibleOrgTree", "ReportGeneralLedger"),
          Utility.getContext(this, vars, "#User_Client", "ReportGeneralLedger"), '*');
      comboTableData.fillParameters(null, "ReportGeneralLedger", "");
      xmlDocument.setData("reportAD_ORGID", "liststructure", comboTableData.select(false));
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

    xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
    xmlDocument.setParameter("paramLanguage", "defaultLang=\"" + vars.getLanguage() + "\";");
    xmlDocument.setParameter("dateFrom", strDateFrom);
    xmlDocument.setParameter("dateFromdisplayFormat", vars.getSessionValue("#AD_SqlDateFormat"));
    xmlDocument.setParameter("dateFromsaveFormat", vars.getSessionValue("#AD_SqlDateFormat"));
    xmlDocument.setParameter("dateTo", strDateTo);
    xmlDocument.setParameter("PageNo", strPageNo);
    xmlDocument.setParameter("dateTodisplayFormat", vars.getSessionValue("#AD_SqlDateFormat"));
    xmlDocument.setParameter("dateTosaveFormat", vars.getSessionValue("#AD_SqlDateFormat"));
    xmlDocument.setParameter("amtFrom", strAmtFrom);
    xmlDocument.setParameter("amtTo", strAmtTo);
    xmlDocument.setParameter("adOrgId", strOrg);
    xmlDocument.setParameter("cAcctschemaId", strcAcctSchemaId);
    xmlDocument.setParameter("paramElementvalueIdTo", strcelementvalueto);
    xmlDocument.setParameter("paramElementvalueIdFrom", strcelementvaluefrom);
    xmlDocument.setParameter("inpElementValueIdTo_DES", strcelementvaluetodes);
    xmlDocument.setParameter("inpElementValueIdFrom_DES", strcelementvaluefromdes);
    xmlDocument.setParameter("groupbyselected", strGroupBy);
    xmlDocument.setParameter("showOpenBalances", strShowOpenBalances);
    xmlDocument.setData(
        "reportCBPartnerId_IN",
        "liststructure",
        SelectorUtilityData.selectBpartner(this,
            Utility.getContext(this, vars, "#AccessibleOrgTree", ""),
            Utility.getContext(this, vars, "#User_Client", ""), strcBpartnerIdAux));
    xmlDocument.setData(
        "reportMProductId_IN",
        "liststructure",
        SelectorUtilityData.selectMproduct(this,
            Utility.getContext(this, vars, "#AccessibleOrgTree", ""),
            Utility.getContext(this, vars, "#User_Client", ""), strmProductIdAux));
    xmlDocument.setData(
        "reportCProjectId_IN",
        "liststructure",
        SelectorUtilityData.selectProject(this,
            Utility.getContext(this, vars, "#AccessibleOrgTree", ""),
            Utility.getContext(this, vars, "#User_Client", ""), strcProjectIdAux));
    xmlDocument
        .setData("reportC_ACCTSCHEMA_ID", "liststructure", AccountingSchemaMiscData
            .selectC_ACCTSCHEMA_ID(this,
                Utility.getContext(this, vars, "#AccessibleOrgTree", "ReportGeneralLedger"),
                Utility.getContext(this, vars, "#User_Client", "ReportGeneralLedger"),
                strcAcctSchemaId));

    log4j.debug("data.length: " + data.length);

    if (data != null && data.length > 0) {
      if (strGroupBy.equals(""))
        xmlDocument.setData("structure1", data);
      else
        xmlDocument.setData("structure2", data);
    } else {
      if (vars.commandIn("FIND")) {
        // No data has been found. Show warning message.
        xmlDocument.setParameter("messageType", "WARNING");
        xmlDocument.setParameter("messageTitle",
            Utility.messageBD(this, "ProcessStatus-W", vars.getLanguage()));
        xmlDocument.setParameter("messageMessage",
            Utility.messageBD(this, "NoDataFound", vars.getLanguage()));
      }
    }

    out.println(xmlDocument.print());
    out.close();
  }

  private void printPageDataPDF(HttpServletRequest request, HttpServletResponse response,
      VariablesSecureApp vars, String strDateFrom, String strDateTo, String strAmtFrom,
      String strAmtTo, String strcelementvaluefrom, String strcelementvalueto, String strOrg,
      String strcBpartnerId, String strmProductId, String strcProjectId, String strGroupBy,
      String strcAcctSchemaId, String strPageNo, String strShowOpenBalances) throws IOException,
      ServletException {
    log4j.debug("Output: PDF");
    response.setContentType("text/html; charset=UTF-8");
    ReportGeneralLedgerData[] subreport = null;
    String strTreeOrg = TreeData.getTreeOrg(this, vars.getClient());
    String strOrgFamily = getFamily(strTreeOrg, strOrg);
    String toDatePlusOne = DateTimeData.nDaysAfter(this, strDateTo, "1");

    String strGroupByText = (strGroupBy.equals("BPartner") ? Utility.messageBD(this, "BusPartner",
        vars.getLanguage()) : (strGroupBy.equals("Product") ? Utility.messageBD(this, "Product",
        vars.getLanguage()) : (strGroupBy.equals("Project") ? Utility.messageBD(this, "Project",
        vars.getLanguage()) : "")));
    String strAllaccounts = "Y";

    if (strDateFrom.equals("") || strDateTo.equals("")) {
      advisePopUp(request, response, "WARNING",
          Utility.messageBD(this, "ProcessStatus-W", vars.getLanguage()),
          Utility.messageBD(this, "NoDataFound", vars.getLanguage()));
      return;
    }

    if (strcelementvaluefrom != null && !strcelementvaluefrom.equals("")) {
      if (strcelementvalueto.equals(""))
        strcelementvalueto = strcelementvaluefrom;
      strAllaccounts = "N";
    }

    ReportGeneralLedgerData data = null;
    try {
      data = ReportGeneralLedgerData.select2(this, "0", strGroupByText, strGroupBy, strAllaccounts,
          strcelementvaluefrom, strcelementvalueto,
          Utility.getContext(this, vars, "#AccessibleOrgTree", "ReportGeneralLedger"),
          Utility.getContext(this, vars, "#User_Client", "ReportGeneralLedger"),
          "Y".equals(strShowOpenBalances) ? strDateTo : null, strcAcctSchemaId, strDateFrom,
          toDatePlusOne, strOrgFamily, strcBpartnerId, strmProductId, strcProjectId, strAmtFrom,
          strAmtTo, null, null, null, null, null, null);

      if (!data.hasData()) {
        advisePopUp(request, response, "WARNING",
            Utility.messageBD(this, "ProcessStatus-W", vars.getLanguage()),
            Utility.messageBD(this, "NoDataFound", vars.getLanguage()));
        return;
      }

      // augment data with totals
      AddTotals dataWithTotals = new AddTotals(data, strGroupByText, strcBpartnerId, strmProductId,
          strcProjectId, strcAcctSchemaId, strDateFrom, strOrgFamily, this);

      String strReportName = "@basedesign@/com/gai/generalledgerrpt/erpCommon/ad_reports/ReportGeneralLedger.jrxml";
      response.setHeader("Content-disposition", "inline; filename=ReportGeneralLedgerPDF.pdf");

      HashMap<String, Object> parameters = new HashMap<String, Object>();

      String strLanguage = vars.getLanguage();

      parameters.put("ShowGrouping", new Boolean(!strGroupBy.equals("")));
      StringBuilder strSubTitle = new StringBuilder();
      strSubTitle.append(Utility.messageBD(this, "DateFrom", strLanguage) + ": " + strDateFrom
          + " - " + Utility.messageBD(this, "DateTo", strLanguage) + ": " + strDateTo + " (");
      strSubTitle.append(ReportGeneralLedgerData.selectCompany(this, vars.getClient()) + " - ");
      strSubTitle.append(ReportGeneralLedgerData.selectOrganization(this, strOrg) + ")");
      parameters.put("REPORT_SUBTITLE", strSubTitle.toString());
      parameters.put("Previous", Utility.messageBD(this, "Initial Balance", strLanguage));
      parameters.put("Total", Utility.messageBD(this, "Total", strLanguage));
      parameters.put("PageNo", strPageNo);
      String strDateFormat;
      strDateFormat = vars.getJavaDateFormat();
      parameters.put("strDateFormat", strDateFormat);

      renderJR(vars, response, strReportName, null, "pdf", parameters, dataWithTotals, null);
    } finally {
      if (data != null) {
        data.close();
      }
    }
  }

  private void printPageDataXLS(HttpServletRequest request, HttpServletResponse response,
      VariablesSecureApp vars, String strDateFrom, String strDateTo, String strAmtFrom,
      String strAmtTo, String strcelementvaluefrom, String strcelementvalueto, String strOrg,
      String strcBpartnerId, String strmProductId, String strcProjectId, String strGroupBy,
      String strcAcctSchemaId, String strShowOpenBalances) throws IOException, ServletException {
    log4j.debug("Output: XLS");
    response.setContentType("text/html; charset=UTF-8");
    String strTreeOrg = TreeData.getTreeOrg(this, vars.getClient());
    String strOrgFamily = "";
    strOrgFamily = getFamily(strTreeOrg, strOrg);
    String toDatePlusOne = DateTimeData.nDaysAfter(this, strDateTo, "1");

    String strAllaccounts = "Y";

    if (strDateFrom.equals("") || strDateTo.equals("")) {
      advisePopUp(request, response, "WARNING",
          Utility.messageBD(this, "ProcessStatus-W", vars.getLanguage()),
          Utility.messageBD(this, "NoDataFound", vars.getLanguage()));
      return;
    }

    if (strcelementvaluefrom != null && !strcelementvaluefrom.equals("")) {
      if (strcelementvalueto.equals(""))
        strcelementvalueto = strcelementvaluefrom;
      strAllaccounts = "N";
    }

    ReportGeneralLedgerData data = null;
    try {
      data = ReportGeneralLedgerData.selectXLS2(this, strAllaccounts, strcelementvaluefrom,
          strcelementvalueto,
          Utility.getContext(this, vars, "#AccessibleOrgTree", "ReportGeneralLedger"),
          Utility.getContext(this, vars, "#User_Client", "ReportGeneralLedger"),
          "Y".equals(strShowOpenBalances) ? strDateTo : null, strcAcctSchemaId, strDateFrom,
          toDatePlusOne, strOrgFamily, strcBpartnerId, strmProductId, strcProjectId, strAmtFrom,
          strAmtTo);

      if (!data.hasData()) {
        advisePopUp(request, response, "WARNING",
            Utility.messageBD(this, "ProcessStatus-W", vars.getLanguage()),
            Utility.messageBD(this, "NoDataFound", vars.getLanguage()));
        return;
      }

      ScrollableFieldProvider limitedData = new LimitRowsScrollableFieldProviderFilter(data, 65532);

      String strReportName = "@basedesign@/com/gai/generalledgerrpt/erpCommon/ad_reports/ReportGeneralLedgerExcel.jrxml";

      HashMap<String, Object> parameters = new HashMap<String, Object>();

      String strLanguage = vars.getLanguage();

      StringBuilder strSubTitle = new StringBuilder();
      strSubTitle.append(Utility.messageBD(this, "DateFrom", strLanguage) + ": " + strDateFrom
          + " - " + Utility.messageBD(this, "DateTo", strLanguage) + ": " + strDateTo + " (");
      strSubTitle.append(ReportGeneralLedgerData.selectCompany(this, vars.getClient()) + " - ");
      strSubTitle.append(ReportGeneralLedgerData.selectOrganization(this, strOrg) + ")");
      parameters.put("REPORT_SUBTITLE", strSubTitle.toString());
      String strDateFormat;
      strDateFormat = vars.getJavaDateFormat();
      parameters.put("strDateFormat", strDateFormat);

      renderJR(vars, response, strReportName, null, "xls", parameters, limitedData, null);
    } finally {
      if (data != null) {
        data.close();
      }
    }
  }

  private static class AddTotals extends AbstractScrollableFieldProviderFilter {
    public AddTotals(ScrollableFieldProvider input, String strGroupBy, String strcBpartnerId,
        String strmProductId, String strcProjectId, String strcAcctSchemaId, String strDateFrom,
        String strOrgFamily, ConnectionProvider conn) {
      super(input);
      this.strGroupBy = strGroupBy;
      this.strcBpartnerId = strcBpartnerId;
      this.strmProductId = strmProductId;
      this.strcProjectId = strcProjectId;
      this.strcAcctSchemaId = strcAcctSchemaId;
      this.strDateFrom = strDateFrom;
      this.strOrgFamily = strOrgFamily;
      this.conn = conn;
    }

    String strGroupBy;
    String strcBpartnerId;
    String strmProductId;
    String strcProjectId;
    String strcAcctSchemaId;
    String strDateFrom;
    String strOrgFamily;
    ConnectionProvider conn;
    String strOld = "";
    BigDecimal totalDebit = BigDecimal.ZERO;
    BigDecimal totalCredit = BigDecimal.ZERO;
    BigDecimal subTotal = BigDecimal.ZERO;
    ReportGeneralLedgerData subreport[] = new ReportGeneralLedgerData[1];

    @Override
    public FieldProvider get() throws ServletException {

      FieldProvider data = input.get();

      ReportGeneralLedgerData cur = (ReportGeneralLedgerData) data;

      // adjust data as needed
      if (!strOld.equals(cur.groupbyid + cur.id)) {
        if ("".equals(cur.groupbyid)) {
          // The argument " " is used to simulate one value and put the optional parameter--> AND
          // FACT_ACCT.C_PROJECT_ID IS NULL for example
          subreport = ReportGeneralLedgerData.selectTotal2(conn, strcBpartnerId,
              (strGroupBy.equals("BPartner") ? " " : null), strmProductId,
              (strGroupBy.equals("Product") ? " " : null), strcProjectId,
              (strGroupBy.equals("Project") ? " " : null), strcAcctSchemaId, cur.id, "",
              strDateFrom, strOrgFamily);
        } else {
          subreport = ReportGeneralLedgerData.selectTotal2(conn,
              (strGroupBy.equals("BPartner") ? "('" + cur.groupbyid + "')" : strcBpartnerId), null,
              (strGroupBy.equals("Product") ? "('" + cur.groupbyid + "')" : strmProductId), null,
              (strGroupBy.equals("Project") ? "('" + cur.groupbyid + "')" : strcProjectId), null,
              strcAcctSchemaId, cur.id, "", strDateFrom, strOrgFamily);
        }
        totalDebit = BigDecimal.ZERO;
        totalCredit = BigDecimal.ZERO;
        subTotal = BigDecimal.ZERO;
      }
      totalDebit = totalDebit.add(new BigDecimal(cur.amtacctdr));
      cur.totalacctdr = new BigDecimal(subreport[0].totalacctdr).add(totalDebit).toString();
      totalCredit = totalCredit.add(new BigDecimal(cur.amtacctcr));
      cur.totalacctcr = new BigDecimal(subreport[0].totalacctcr).add(totalCredit).toString();
      subTotal = subTotal.add(new BigDecimal(cur.total));
      cur.totalacctsub = new BigDecimal(subreport[0].total).add(subTotal).toString();
      cur.previousdebit = subreport[0].totalacctdr;
      cur.previouscredit = subreport[0].totalacctcr;
      cur.previoustotal = subreport[0].total;
      strOld = cur.groupbyid + cur.id;

      return data;
    }

  }

  private String getFamily(String strTree, String strChild) throws IOException, ServletException {
    return Tree.getMembers(this, strTree, strChild);
  }

  @Override
  public String getServletInfo() {
    return "Servlet ReportGeneralLedger. This Servlet was made by Pablo Sarobe";
  } // end of getServletInfo() method
}