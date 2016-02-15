//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.ad_reports;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

class ReportOfferData implements FieldProvider {
static Logger log4j = Logger.getLogger(ReportOfferData.class);
  private String InitRecordNumber="0";
  public String cBpartnerId;
  public String mOfferId;
  public String cBpartnerName;
  public String datefrom;
  public String dateto;
  public String addamt;
  public String discount;
  public String fixed;
  public String id;
  public String name;
  public String mOfferName;
  public String classTree;
  public String mOfferIdCBpartnerId;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("C_BPARTNER_ID") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
    else if (fieldName.equalsIgnoreCase("M_OFFER_ID") || fieldName.equals("mOfferId"))
      return mOfferId;
    else if (fieldName.equalsIgnoreCase("C_BPARTNER_NAME") || fieldName.equals("cBpartnerName"))
      return cBpartnerName;
    else if (fieldName.equalsIgnoreCase("DATEFROM"))
      return datefrom;
    else if (fieldName.equalsIgnoreCase("DATETO"))
      return dateto;
    else if (fieldName.equalsIgnoreCase("ADDAMT"))
      return addamt;
    else if (fieldName.equalsIgnoreCase("DISCOUNT"))
      return discount;
    else if (fieldName.equalsIgnoreCase("FIXED"))
      return fixed;
    else if (fieldName.equalsIgnoreCase("ID"))
      return id;
    else if (fieldName.equalsIgnoreCase("NAME"))
      return name;
    else if (fieldName.equalsIgnoreCase("M_OFFER_NAME") || fieldName.equals("mOfferName"))
      return mOfferName;
    else if (fieldName.equalsIgnoreCase("CLASS_TREE") || fieldName.equals("classTree"))
      return classTree;
    else if (fieldName.equalsIgnoreCase("M_OFFER_ID_C_BPARTNER_ID") || fieldName.equals("mOfferIdCBpartnerId"))
      return mOfferIdCBpartnerId;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ReportOfferData[] select(ConnectionProvider connectionProvider, String adUserClient, String adUserOrg, String datefrom, String dateto, String parBPartnerId)    throws ServletException {
    return select(connectionProvider, adUserClient, adUserOrg, datefrom, dateto, parBPartnerId, 0, 0);
  }

  public static ReportOfferData[] select(ConnectionProvider connectionProvider, String adUserClient, String adUserOrg, String datefrom, String dateto, String parBPartnerId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT C_BPARTNER_ID, M_OFFER_ID, C_BPARTNER_NAME, DATEFROM, DATETO," +
      "        ADDAMT, DISCOUNT, FIXED, C_BPARTNER_ID AS ID, C_BPARTNER_NAME AS NAME," +
      "        M_OFFER_NAME, 'datawarehouseclose' AS CLASS_TREE," +
      "        M_OFFER_ID ||':'||C_BPARTNER_ID AS M_OFFER_ID_C_BPARTNER_ID" +
      "        FROM(SELECT M_OFFER_BPARTNER.C_BPARTNER_ID, M_OFFER.M_OFFER_ID, M_OFFER.NAME AS M_OFFER_NAME," +
      "             C_BPARTNER.NAME AS C_BPARTNER_NAME, M_OFFER.DATEFROM, M_OFFER.DATETO," +
      "             M_OFFER.AD_CLIENT_ID, M_OFFER.AD_ORG_ID, M_OFFER.ADDAMT," +
      "             M_OFFER.DISCOUNT, M_OFFER.FIXED" +
      "             FROM M_OFFER, M_OFFER_BPARTNER, C_BPARTNER" +
      "             WHERE M_OFFER.BPARTNER_SELECTION = 'N'" +
      "             AND M_OFFER.M_OFFER_ID = M_OFFER_BPARTNER.M_OFFER_ID" +
      "             AND M_OFFER_BPARTNER.C_BPARTNER_ID = C_BPARTNER.C_BPARTNER_ID" +
      "             UNION" +
      "             SELECT C_BPARTNER.C_BPARTNER_ID, M_OFFER.M_OFFER_ID, M_OFFER.NAME AS M_OFFER_NAME," +
      "             C_BPARTNER.NAME AS C_BPARTNER_NAME, M_OFFER.DATEFROM, M_OFFER.DATETO," +
      "             M_OFFER.AD_CLIENT_ID, M_OFFER.AD_ORG_ID, M_OFFER.ADDAMT," +
      "             M_OFFER.DISCOUNT, M_OFFER.FIXED" +
      "             FROM M_OFFER, C_BPARTNER" +
      "             WHERE M_OFFER.BPARTNER_SELECTION = 'Y'" +
      "             AND C_BPARTNER.C_BPARTNER_ID NOT IN (SELECT C_BPARTNER_ID FROM M_OFFER_BPARTNER WHERE M_OFFER_ID = M_OFFER.M_OFFER_ID)) A" +
      "        WHERE A.AD_CLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "        AND A.AD_ORG_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ")" +
      "        AND DATEFROM >= TO_DATE(?)" +
      "        AND (DATETO IS NULL OR DATETO <= TO_DATE(?))" +
      "        AND 1=1";
    strSql = strSql + ((parBPartnerId==null || parBPartnerId.equals(""))?"":"  AND A.C_BPARTNER_ID IN" + parBPartnerId);
    strSql = strSql + 
      "        ORDER BY C_BPARTNER_NAME, M_OFFER_NAME";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datefrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateto);
      if (parBPartnerId != null && !(parBPartnerId.equals(""))) {
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
        ReportOfferData objectReportOfferData = new ReportOfferData();
        objectReportOfferData.cBpartnerId = UtilSql.getValue(result, "C_BPARTNER_ID");
        objectReportOfferData.mOfferId = UtilSql.getValue(result, "M_OFFER_ID");
        objectReportOfferData.cBpartnerName = UtilSql.getValue(result, "C_BPARTNER_NAME");
        objectReportOfferData.datefrom = UtilSql.getDateValue(result, "DATEFROM", "dd-MM-yyyy");
        objectReportOfferData.dateto = UtilSql.getDateValue(result, "DATETO", "dd-MM-yyyy");
        objectReportOfferData.addamt = UtilSql.getValue(result, "ADDAMT");
        objectReportOfferData.discount = UtilSql.getValue(result, "DISCOUNT");
        objectReportOfferData.fixed = UtilSql.getValue(result, "FIXED");
        objectReportOfferData.id = UtilSql.getValue(result, "ID");
        objectReportOfferData.name = UtilSql.getValue(result, "NAME");
        objectReportOfferData.mOfferName = UtilSql.getValue(result, "M_OFFER_NAME");
        objectReportOfferData.classTree = UtilSql.getValue(result, "CLASS_TREE");
        objectReportOfferData.mOfferIdCBpartnerId = UtilSql.getValue(result, "M_OFFER_ID_C_BPARTNER_ID");
        objectReportOfferData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportOfferData);
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
    ReportOfferData objectReportOfferData[] = new ReportOfferData[vector.size()];
    vector.copyInto(objectReportOfferData);
    return(objectReportOfferData);
  }
}
