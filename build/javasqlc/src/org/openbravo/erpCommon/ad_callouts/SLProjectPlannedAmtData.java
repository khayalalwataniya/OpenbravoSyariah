//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.ad_callouts;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

class SLProjectPlannedAmtData implements FieldProvider {
static Logger log4j = Logger.getLogger(SLProjectPlannedAmtData.class);
  private String InitRecordNumber="0";
  public String stdprecision;
  public String priceprecision;
  public String enforcepricelimit;
  public String mPricelistId;
  public String updatedby;
  public String updated;
  public String cProjectlineId;
  public String plannedamt;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("STDPRECISION"))
      return stdprecision;
    else if (fieldName.equalsIgnoreCase("PRICEPRECISION"))
      return priceprecision;
    else if (fieldName.equalsIgnoreCase("ENFORCEPRICELIMIT"))
      return enforcepricelimit;
    else if (fieldName.equalsIgnoreCase("M_PRICELIST_ID") || fieldName.equals("mPricelistId"))
      return mPricelistId;
    else if (fieldName.equalsIgnoreCase("UPDATEDBY"))
      return updatedby;
    else if (fieldName.equalsIgnoreCase("UPDATED"))
      return updated;
    else if (fieldName.equalsIgnoreCase("C_PROJECTLINE_ID") || fieldName.equals("cProjectlineId"))
      return cProjectlineId;
    else if (fieldName.equalsIgnoreCase("PLANNEDAMT"))
      return plannedamt;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static SLProjectPlannedAmtData[] select(ConnectionProvider connectionProvider, String cProjectId)    throws ServletException {
    return select(connectionProvider, cProjectId, 0, 0);
  }

  public static SLProjectPlannedAmtData[] select(ConnectionProvider connectionProvider, String cProjectId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT C_Currency.StdPrecision, C_Currency.PricePrecision, M_PriceList.EnforcePriceLimit, M_PriceList.M_PriceList_ID, C_Projectline.updatedby, C_Projectline.Updated, C_Projectline.C_Projectline_ID, C_Projectline.plannedAmt" +
      "      FROM C_Projectline, C_Project, M_PriceList, C_Currency " +
      "      WHERE C_Projectline.C_Project_ID = C_Project.C_Project_ID" +
      "      AND C_Project.M_PriceList_ID = M_PriceList.M_PriceList_ID" +
      "      AND M_PriceList.C_Currency_ID = C_Currency.C_Currency_ID" +
      "      AND C_Projectline.C_Projectline_ID = ?";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);

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
        SLProjectPlannedAmtData objectSLProjectPlannedAmtData = new SLProjectPlannedAmtData();
        objectSLProjectPlannedAmtData.stdprecision = UtilSql.getValue(result, "STDPRECISION");
        objectSLProjectPlannedAmtData.priceprecision = UtilSql.getValue(result, "PRICEPRECISION");
        objectSLProjectPlannedAmtData.enforcepricelimit = UtilSql.getValue(result, "ENFORCEPRICELIMIT");
        objectSLProjectPlannedAmtData.mPricelistId = UtilSql.getValue(result, "M_PRICELIST_ID");
        objectSLProjectPlannedAmtData.updatedby = UtilSql.getValue(result, "UPDATEDBY");
        objectSLProjectPlannedAmtData.updated = UtilSql.getDateValue(result, "UPDATED", "dd-MM-yyyy");
        objectSLProjectPlannedAmtData.cProjectlineId = UtilSql.getValue(result, "C_PROJECTLINE_ID");
        objectSLProjectPlannedAmtData.plannedamt = UtilSql.getValue(result, "PLANNEDAMT");
        objectSLProjectPlannedAmtData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectSLProjectPlannedAmtData);
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
    SLProjectPlannedAmtData objectSLProjectPlannedAmtData[] = new SLProjectPlannedAmtData[vector.size()];
    vector.copyInto(objectSLProjectPlannedAmtData);
    return(objectSLProjectPlannedAmtData);
  }

  public static String selectPrecision(ConnectionProvider connectionProvider, String cCurrencyId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT PRICEPRECISION " +
      "        FROM C_CURRENCY C" +
      "        WHERE C.C_CURRENCY_ID = ?";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "PRICEPRECISION");
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
}