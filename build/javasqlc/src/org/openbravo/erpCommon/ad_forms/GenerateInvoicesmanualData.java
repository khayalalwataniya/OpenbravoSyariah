//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.ad_forms;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;
import org.openbravo.database.RDBMSIndependent;
import org.openbravo.exception.*;

class GenerateInvoicesmanualData implements FieldProvider {
static Logger log4j = Logger.getLogger(GenerateInvoicesmanualData.class);
  private String InitRecordNumber="0";
  public String cOrderId;
  public String adorgname;
  public String cdoctypename;
  public String documentno;
  public String cbpartnername;
  public String dateordered;
  public String amountlines;
  public String notinvoicedlines;
  public String termname;
  public String termvalue;
  public String pendinglines;
  public String amountlinesgross;
  public String notinvoicedlinesgross;
  public String pendinglinesgross;
  public String qtyordered;
  public String qtydelivered;
  public String linesinvoiced;
  public String totalgross;
  public String rownum;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("C_ORDER_ID") || fieldName.equals("cOrderId"))
      return cOrderId;
    else if (fieldName.equalsIgnoreCase("ADORGNAME"))
      return adorgname;
    else if (fieldName.equalsIgnoreCase("CDOCTYPENAME"))
      return cdoctypename;
    else if (fieldName.equalsIgnoreCase("DOCUMENTNO"))
      return documentno;
    else if (fieldName.equalsIgnoreCase("CBPARTNERNAME"))
      return cbpartnername;
    else if (fieldName.equalsIgnoreCase("DATEORDERED"))
      return dateordered;
    else if (fieldName.equalsIgnoreCase("AMOUNTLINES"))
      return amountlines;
    else if (fieldName.equalsIgnoreCase("NOTINVOICEDLINES"))
      return notinvoicedlines;
    else if (fieldName.equalsIgnoreCase("TERMNAME"))
      return termname;
    else if (fieldName.equalsIgnoreCase("TERMVALUE"))
      return termvalue;
    else if (fieldName.equalsIgnoreCase("PENDINGLINES"))
      return pendinglines;
    else if (fieldName.equalsIgnoreCase("AMOUNTLINESGROSS"))
      return amountlinesgross;
    else if (fieldName.equalsIgnoreCase("NOTINVOICEDLINESGROSS"))
      return notinvoicedlinesgross;
    else if (fieldName.equalsIgnoreCase("PENDINGLINESGROSS"))
      return pendinglinesgross;
    else if (fieldName.equalsIgnoreCase("QTYORDERED"))
      return qtyordered;
    else if (fieldName.equalsIgnoreCase("QTYDELIVERED"))
      return qtydelivered;
    else if (fieldName.equalsIgnoreCase("LINESINVOICED"))
      return linesinvoiced;
    else if (fieldName.equalsIgnoreCase("TOTALGROSS"))
      return totalgross;
    else if (fieldName.equals("rownum"))
      return rownum;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static GenerateInvoicesmanualData[] select(ConnectionProvider connectionProvider, String language, String adUserClient, String adUserOrg, String parBPartner, String parDateFrom, String parDateTo, String adOrgId)    throws ServletException {
    return select(connectionProvider, language, adUserClient, adUserOrg, parBPartner, parDateFrom, parDateTo, adOrgId, 0, 0);
  }

  public static GenerateInvoicesmanualData[] select(ConnectionProvider connectionProvider, String language, String adUserClient, String adUserOrg, String parBPartner, String parDateFrom, String parDateTo, String adOrgId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT ic.C_Order_ID, o.Name as adorgname, COALESCE(dttrl.Name, dt.Name) as cdoctypename, ic.DocumentNo, bp.Name as cbpartnername, ic.DateOrdered," +
      "      amountlines, notinvoicedlines, l.Name as TermName, l.Value as TermValue, pendinglines as pendinglines, '' as amountlinesgross, '' as notinvoicedlinesgross," +
      "      '' as pendinglinesgross, ic.qtyordered as qtyordered, ic.qtydelivered as qtydelivered, (amountlines-notinvoicedlines) as linesinvoiced, amountlinesgross as totalgross" +
      "      FROM C_Invoice_Candidate_v ic, C_ORDER ord, AD_Org o, C_BPartner bp, AD_Ref_List l left join AD_Ref_List_trl ltrl on l.AD_Ref_List_ID=ltrl.AD_Ref_List_ID and ltrl.ad_language=?, " +
      "      C_DocType dt left join C_DocType_trl dttrl on dt.C_DocType_ID=dttrl.C_DocType_ID AND dttrl.ad_language=?" +
      "      WHERE ic.AD_Org_ID=o.AD_Org_ID" +
      "      AND ic.C_BPartner_ID=bp.C_BPartner_ID" +
      "      AND ic.C_DocType_ID=dt.C_DocType_ID" +
      "      AND dt.isreturn='N'" +
      "      AND l.value = ic.term" +
      "      AND ord.C_ORDER_ID=ic.C_ORDER_ID" +
      "      AND ((ic.term = 'D' AND ic.qtydelivered <>0) OR (ic.term = 'I' AND exists (SELECT 1 FROM C_ORDERLINE ol WHERE ol.C_ORDER_ID = ord.C_ORDER_ID AND ol.QTYORDERED-ol.QTYINVOICED <> 0)) OR (ic.term <> 'N' AND (ic.term IN ('O','S') AND (ic.qtyordered = ic.qtydelivered) )) )" +
      "      AND AD_Reference_ID='150'" +
      "      AND ic.ad_client_id in (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "      AND ic.ad_org_id in (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ")" +
      "      AND 1=1";
    strSql = strSql + ((parBPartner==null || parBPartner.equals(""))?"":" AND ic.C_BPartner_ID= ? ");
    strSql = strSql + ((parDateFrom==null || parDateFrom.equals(""))?"":"  AND ic.DateOrdered >= TO_DATE(?) ");
    strSql = strSql + ((parDateTo==null || parDateTo.equals(""))?"":"  AND ic.DateOrdered < TO_DATE(?) ");
    strSql = strSql + 
      "      AND 2=2 AND ic.ad_org_id in (";
    strSql = strSql + ((adOrgId==null || adOrgId.equals(""))?"":adOrgId);
    strSql = strSql + 
      ")" +
      "      ORDER BY o.Name,bp.Name,DateOrdered";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }
      if (parBPartner != null && !(parBPartner.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parBPartner);
      }
      if (parDateFrom != null && !(parDateFrom.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parDateFrom);
      }
      if (parDateTo != null && !(parDateTo.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parDateTo);
      }
      if (adOrgId != null && !(adOrgId.equals(""))) {
        }

      result = st.executeQuery();
      long countRecord = 0;
      long countRecordSkip = 1;
      boolean continueResult = true;
      while(countRecordSkip < firstRegister && continueResult) {
        continueResult = result.next();
        countRecordSkip++;
      }
      while(continueResult && result.next()) {
        countRecord++;
        GenerateInvoicesmanualData objectGenerateInvoicesmanualData = new GenerateInvoicesmanualData();
        objectGenerateInvoicesmanualData.cOrderId = UtilSql.getValue(result, "C_ORDER_ID");
        objectGenerateInvoicesmanualData.adorgname = UtilSql.getValue(result, "ADORGNAME");
        objectGenerateInvoicesmanualData.cdoctypename = UtilSql.getValue(result, "CDOCTYPENAME");
        objectGenerateInvoicesmanualData.documentno = UtilSql.getValue(result, "DOCUMENTNO");
        objectGenerateInvoicesmanualData.cbpartnername = UtilSql.getValue(result, "CBPARTNERNAME");
        objectGenerateInvoicesmanualData.dateordered = UtilSql.getDateValue(result, "DATEORDERED", "dd-MM-yyyy");
        objectGenerateInvoicesmanualData.amountlines = UtilSql.getValue(result, "AMOUNTLINES");
        objectGenerateInvoicesmanualData.notinvoicedlines = UtilSql.getValue(result, "NOTINVOICEDLINES");
        objectGenerateInvoicesmanualData.termname = UtilSql.getValue(result, "TERMNAME");
        objectGenerateInvoicesmanualData.termvalue = UtilSql.getValue(result, "TERMVALUE");
        objectGenerateInvoicesmanualData.pendinglines = UtilSql.getValue(result, "PENDINGLINES");
        objectGenerateInvoicesmanualData.amountlinesgross = UtilSql.getValue(result, "AMOUNTLINESGROSS");
        objectGenerateInvoicesmanualData.notinvoicedlinesgross = UtilSql.getValue(result, "NOTINVOICEDLINESGROSS");
        objectGenerateInvoicesmanualData.pendinglinesgross = UtilSql.getValue(result, "PENDINGLINESGROSS");
        objectGenerateInvoicesmanualData.qtyordered = UtilSql.getValue(result, "QTYORDERED");
        objectGenerateInvoicesmanualData.qtydelivered = UtilSql.getValue(result, "QTYDELIVERED");
        objectGenerateInvoicesmanualData.linesinvoiced = UtilSql.getValue(result, "LINESINVOICED");
        objectGenerateInvoicesmanualData.totalgross = UtilSql.getValue(result, "TOTALGROSS");
        objectGenerateInvoicesmanualData.rownum = Long.toString(countRecord);
        objectGenerateInvoicesmanualData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectGenerateInvoicesmanualData);
        if (countRecord >= numberRegisters && numberRegisters != 0) {
          continueResult = false;
        }
      }
      result.close();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    GenerateInvoicesmanualData objectGenerateInvoicesmanualData[] = new GenerateInvoicesmanualData[vector.size()];
    vector.copyInto(objectGenerateInvoicesmanualData);
    return(objectGenerateInvoicesmanualData);
  }

  public static GenerateInvoicesmanualData[] selectGross(ConnectionProvider connectionProvider, String language, String adUserClient, String adUserOrg, String parBPartner, String parDateFrom, String parDateTo, String adOrgId)    throws ServletException {
    return selectGross(connectionProvider, language, adUserClient, adUserOrg, parBPartner, parDateFrom, parDateTo, adOrgId, 0, 0);
  }

  public static GenerateInvoicesmanualData[] selectGross(ConnectionProvider connectionProvider, String language, String adUserClient, String adUserOrg, String parBPartner, String parDateFrom, String parDateTo, String adOrgId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT ic.C_Order_ID, o.Name as adorgname, COALESCE(dttrl.Name, dt.Name) as cdoctypename, ic.DocumentNo, bp.Name as cbpartnername, ic.DateOrdered," +
      "      amountlinesgross as amountlines, notinvoicedlinesgross as notinvoicedlines, l.Name as TermName, l.Value as TermValue, pendinglinesgross as pendinglines," +
      "      ic.qtyordered as qtyordered, ic.qtydelivered as qtydelivered, (amountlinesgross-notinvoicedlinesgross) as linesinvoiced, amountlinesgross as totalgross" +
      "      FROM C_Invoice_Candidate_v ic, C_ORDER ord, AD_Org o, C_BPartner bp, AD_Ref_List l left join AD_Ref_List_trl ltrl on l.AD_Ref_List_ID=ltrl.AD_Ref_List_ID and ltrl.ad_language=?, " +
      "      C_DocType dt left join C_DocType_trl dttrl on dt.C_DocType_ID=dttrl.C_DocType_ID AND dttrl.ad_language=?" +
      "      WHERE ic.AD_Org_ID=o.AD_Org_ID" +
      "      AND ic.C_BPartner_ID=bp.C_BPartner_ID" +
      "      AND ic.C_DocType_ID=dt.C_DocType_ID" +
      "      AND dt.isReturn='N'" +
      "      AND l.value = ic.term" +
      "      AND ord.C_ORDER_ID=ic.C_ORDER_ID" +
      "      AND ((ic.term = 'D' AND ic.qtydelivered <>0) OR (ic.term = 'I' AND exists (SELECT 1 FROM C_ORDERLINE ol WHERE ol.C_ORDER_ID = ord.C_ORDER_ID AND ol.QTYORDERED-ol.QTYINVOICED <> 0)) OR (ic.term <> 'N' AND (ic.term IN ('O','S') AND (ic.qtyordered = ic.qtydelivered) )) )" +
      "      AND AD_Reference_ID='150'" +
      "      AND ic.ad_client_id in (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "      AND ic.ad_org_id in (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ")" +
      "      AND 1=1";
    strSql = strSql + ((parBPartner==null || parBPartner.equals(""))?"":" AND ic.C_BPartner_ID = ? ");
    strSql = strSql + ((parDateFrom==null || parDateFrom.equals(""))?"":"  AND ic.DateOrdered >= TO_DATE(?) ");
    strSql = strSql + ((parDateTo==null || parDateTo.equals(""))?"":"  AND ic.DateOrdered < TO_DATE(?) ");
    strSql = strSql + 
      "      AND 2=2 AND ic.ad_org_id in (";
    strSql = strSql + ((adOrgId==null || adOrgId.equals(""))?"":adOrgId);
    strSql = strSql + 
      ")" +
      "      ORDER BY o.Name,bp.Name,DateOrdered";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }
      if (parBPartner != null && !(parBPartner.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parBPartner);
      }
      if (parDateFrom != null && !(parDateFrom.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parDateFrom);
      }
      if (parDateTo != null && !(parDateTo.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parDateTo);
      }
      if (adOrgId != null && !(adOrgId.equals(""))) {
        }

      result = st.executeQuery();
      long countRecord = 0;
      long countRecordSkip = 1;
      boolean continueResult = true;
      while(countRecordSkip < firstRegister && continueResult) {
        continueResult = result.next();
        countRecordSkip++;
      }
      while(continueResult && result.next()) {
        countRecord++;
        GenerateInvoicesmanualData objectGenerateInvoicesmanualData = new GenerateInvoicesmanualData();
        objectGenerateInvoicesmanualData.cOrderId = UtilSql.getValue(result, "C_ORDER_ID");
        objectGenerateInvoicesmanualData.adorgname = UtilSql.getValue(result, "ADORGNAME");
        objectGenerateInvoicesmanualData.cdoctypename = UtilSql.getValue(result, "CDOCTYPENAME");
        objectGenerateInvoicesmanualData.documentno = UtilSql.getValue(result, "DOCUMENTNO");
        objectGenerateInvoicesmanualData.cbpartnername = UtilSql.getValue(result, "CBPARTNERNAME");
        objectGenerateInvoicesmanualData.dateordered = UtilSql.getDateValue(result, "DATEORDERED", "dd-MM-yyyy");
        objectGenerateInvoicesmanualData.amountlines = UtilSql.getValue(result, "AMOUNTLINES");
        objectGenerateInvoicesmanualData.notinvoicedlines = UtilSql.getValue(result, "NOTINVOICEDLINES");
        objectGenerateInvoicesmanualData.termname = UtilSql.getValue(result, "TERMNAME");
        objectGenerateInvoicesmanualData.termvalue = UtilSql.getValue(result, "TERMVALUE");
        objectGenerateInvoicesmanualData.pendinglines = UtilSql.getValue(result, "PENDINGLINES");
        objectGenerateInvoicesmanualData.qtyordered = UtilSql.getValue(result, "QTYORDERED");
        objectGenerateInvoicesmanualData.qtydelivered = UtilSql.getValue(result, "QTYDELIVERED");
        objectGenerateInvoicesmanualData.linesinvoiced = UtilSql.getValue(result, "LINESINVOICED");
        objectGenerateInvoicesmanualData.totalgross = UtilSql.getValue(result, "TOTALGROSS");
        objectGenerateInvoicesmanualData.rownum = Long.toString(countRecord);
        objectGenerateInvoicesmanualData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectGenerateInvoicesmanualData);
        if (countRecord >= numberRegisters && numberRegisters != 0) {
          continueResult = false;
        }
      }
      result.close();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    GenerateInvoicesmanualData objectGenerateInvoicesmanualData[] = new GenerateInvoicesmanualData[vector.size()];
    vector.copyInto(objectGenerateInvoicesmanualData);
    return(objectGenerateInvoicesmanualData);
  }

  public static GenerateInvoicesmanualData[] set()    throws ServletException {
    GenerateInvoicesmanualData objectGenerateInvoicesmanualData[] = new GenerateInvoicesmanualData[1];
    objectGenerateInvoicesmanualData[0] = new GenerateInvoicesmanualData();
    objectGenerateInvoicesmanualData[0].cOrderId = "";
    objectGenerateInvoicesmanualData[0].adorgname = "";
    objectGenerateInvoicesmanualData[0].cdoctypename = "";
    objectGenerateInvoicesmanualData[0].documentno = "";
    objectGenerateInvoicesmanualData[0].cbpartnername = "";
    objectGenerateInvoicesmanualData[0].dateordered = "";
    objectGenerateInvoicesmanualData[0].amountlines = "";
    objectGenerateInvoicesmanualData[0].notinvoicedlines = "";
    objectGenerateInvoicesmanualData[0].termname = "";
    objectGenerateInvoicesmanualData[0].termvalue = "";
    objectGenerateInvoicesmanualData[0].pendinglines = "";
    objectGenerateInvoicesmanualData[0].qtyordered = "";
    objectGenerateInvoicesmanualData[0].qtydelivered = "";
    objectGenerateInvoicesmanualData[0].linesinvoiced = "";
    objectGenerateInvoicesmanualData[0].totalgross = "";
    return objectGenerateInvoicesmanualData;
  }

  public static int initUpdate(Connection conn, ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      UPDATE C_Order SET IsSelected = 'N'" +
      "      WHERE IsSelected='Y'";

    int updateCount = 0;
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());

      updateCount = st.executeUpdate();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(updateCount);
  }

  public static int updateSelection(Connection conn, ConnectionProvider connectionProvider, String parcOrdersId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      UPDATE C_Order SET IsSelected='Y' " +
      "      WHERE 1=1";
    strSql = strSql + ((parcOrdersId==null || parcOrdersId.equals(""))?"":" AND C_Order_ID IN" + parcOrdersId);

    int updateCount = 0;
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (parcOrdersId != null && !(parcOrdersId.equals(""))) {
        }

      updateCount = st.executeUpdate();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(updateCount);
  }

  public static int resetSelection(Connection conn, ConnectionProvider connectionProvider, String parcOrdersId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      UPDATE C_Order SET IsSelected='N' " +
      "      WHERE 1=1";
    strSql = strSql + ((parcOrdersId==null || parcOrdersId.equals(""))?"":" AND C_Order_ID IN" + parcOrdersId);

    int updateCount = 0;
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (parcOrdersId != null && !(parcOrdersId.equals(""))) {
        }

      updateCount = st.executeUpdate();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(updateCount);
  }

  public static String bPartnerDescription(ConnectionProvider connectionProvider, String cBpartnerId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "    SELECT NAME FROM C_BPARTNER " +
      "    WHERE C_BPARTNER_ID = ?";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "NAME");
      }
      result.close();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(strReturn);
  }

/**
procedure C_Invoice_Create0
 */
  public static GenerateInvoicesmanualData process134(Connection conn, ConnectionProvider connectionProvider, String adPinstanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        CALL C_Invoice_Create0(?)";

    GenerateInvoicesmanualData objectGenerateInvoicesmanualData = new GenerateInvoicesmanualData();
    CallableStatement st = null;
    if (connectionProvider.getRDBMS().equalsIgnoreCase("ORACLE")) {

    int iParameter = 0;
    try {
      st = connectionProvider.getCallableStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adPinstanceId);

      st.execute();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    }
    else {
      Vector<String> parametersData = new Vector<String>();
      Vector<String> parametersTypes = new Vector<String>();
      parametersData.addElement(adPinstanceId);
      parametersTypes.addElement("in");
      try {
      RDBMSIndependent.getCallableResult(conn, connectionProvider, strSql, parametersData, parametersTypes, 0);
      } catch(SQLException e){
        log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
        throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
      } catch(NoConnectionAvailableException ec){
        log4j.error("Connection error in query: " + strSql + "Exception:"+ ec);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(PoolNotFoundException ep){
        log4j.error("Pool error in query: " + strSql + "Exception:"+ ep);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(Exception ex){
        log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
        throw new ServletException("@CODE=@" + ex.getMessage());
      }
    }
    return(objectGenerateInvoicesmanualData);
  }
}
