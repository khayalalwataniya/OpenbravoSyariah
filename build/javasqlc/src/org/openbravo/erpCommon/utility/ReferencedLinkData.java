//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.utility;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

class ReferencedLinkData implements FieldProvider {
static Logger log4j = Logger.getLogger(ReferencedLinkData.class);
  private String InitRecordNumber="0";
  public String adWindowId;
  public String poWindowId;
  public String windowname;
  public String tabname;
  public String name;
  public String adTabId;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("AD_WINDOW_ID") || fieldName.equals("adWindowId"))
      return adWindowId;
    else if (fieldName.equalsIgnoreCase("PO_WINDOW_ID") || fieldName.equals("poWindowId"))
      return poWindowId;
    else if (fieldName.equalsIgnoreCase("WINDOWNAME"))
      return windowname;
    else if (fieldName.equalsIgnoreCase("TABNAME"))
      return tabname;
    else if (fieldName.equalsIgnoreCase("NAME"))
      return name;
    else if (fieldName.equalsIgnoreCase("AD_TAB_ID") || fieldName.equals("adTabId"))
      return adTabId;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ReferencedLinkData[] select(ConnectionProvider connectionProvider, String adWindowId, String adTableId)    throws ServletException {
    return select(connectionProvider, adWindowId, adTableId, 0, 0);
  }

  public static ReferencedLinkData[] select(ConnectionProvider connectionProvider, String adWindowId, String adTableId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT W.AD_WINDOW_ID, '' AS PO_WINDOW_ID, W.NAME AS WINDOWNAME, T.NAME AS TABNAME, '' as NAME, t.AD_TAB_ID" +
      "      FROM AD_WINDOW W, AD_TAB T " +
      "      WHERE W.AD_WINDOW_ID = T.AD_WINDOW_ID " +
      "      AND W.ISACTIVE = 'Y' " +
      "      AND T.ISACTIVE = 'Y' " +
      "      AND W.AD_WINDOW_ID = ? " +
      "      AND T.AD_TABLE_ID = ? " +
      "      ORDER BY T.TABLEVEL";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adWindowId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTableId);

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
        ReferencedLinkData objectReferencedLinkData = new ReferencedLinkData();
        objectReferencedLinkData.adWindowId = UtilSql.getValue(result, "AD_WINDOW_ID");
        objectReferencedLinkData.poWindowId = UtilSql.getValue(result, "PO_WINDOW_ID");
        objectReferencedLinkData.windowname = UtilSql.getValue(result, "WINDOWNAME");
        objectReferencedLinkData.tabname = UtilSql.getValue(result, "TABNAME");
        objectReferencedLinkData.name = UtilSql.getValue(result, "NAME");
        objectReferencedLinkData.adTabId = UtilSql.getValue(result, "AD_TAB_ID");
        objectReferencedLinkData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReferencedLinkData);
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
    ReferencedLinkData objectReferencedLinkData[] = new ReferencedLinkData[vector.size()];
    vector.copyInto(objectReferencedLinkData);
    return(objectReferencedLinkData);
  }

  public static ReferencedLinkData[] selectWindows(ConnectionProvider connectionProvider, String adTableId)    throws ServletException {
    return selectWindows(connectionProvider, adTableId, 0, 0);
  }

  public static ReferencedLinkData[] selectWindows(ConnectionProvider connectionProvider, String adTableId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT AD_WINDOW_ID, PO_WINDOW_ID" +
      "        FROM AD_TABLE " +
      "        WHERE AD_TABLE_ID = ?";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTableId);

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
        ReferencedLinkData objectReferencedLinkData = new ReferencedLinkData();
        objectReferencedLinkData.adWindowId = UtilSql.getValue(result, "AD_WINDOW_ID");
        objectReferencedLinkData.poWindowId = UtilSql.getValue(result, "PO_WINDOW_ID");
        objectReferencedLinkData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReferencedLinkData);
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
    ReferencedLinkData objectReferencedLinkData[] = new ReferencedLinkData[vector.size()];
    vector.copyInto(objectReferencedLinkData);
    return(objectReferencedLinkData);
  }

  public static ReferencedLinkData[] selectParent(ConnectionProvider connectionProvider, String adWindowId)    throws ServletException {
    return selectParent(connectionProvider, adWindowId, 0, 0);
  }

  public static ReferencedLinkData[] selectParent(ConnectionProvider connectionProvider, String adWindowId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT W.AD_WINDOW_ID, '' AS PO_WINDOW_ID, W.NAME AS WINDOWNAME, T.NAME AS TABNAME, t.ad_tab_id " +
      "      FROM AD_WINDOW W, AD_TAB T " +
      "      WHERE W.AD_WINDOW_ID = T.AD_WINDOW_ID " +
      "      AND W.ISACTIVE = 'Y' " +
      "      AND T.ISACTIVE = 'Y' " +
      "      AND T.tablevel = 0 " +
      "      AND W.AD_WINDOW_ID = ?" +
      "      ORDER BY T.SEQNO ";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adWindowId);

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
        ReferencedLinkData objectReferencedLinkData = new ReferencedLinkData();
        objectReferencedLinkData.adWindowId = UtilSql.getValue(result, "AD_WINDOW_ID");
        objectReferencedLinkData.poWindowId = UtilSql.getValue(result, "PO_WINDOW_ID");
        objectReferencedLinkData.windowname = UtilSql.getValue(result, "WINDOWNAME");
        objectReferencedLinkData.tabname = UtilSql.getValue(result, "TABNAME");
        objectReferencedLinkData.adTabId = UtilSql.getValue(result, "AD_TAB_ID");
        objectReferencedLinkData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReferencedLinkData);
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
    ReferencedLinkData objectReferencedLinkData[] = new ReferencedLinkData[vector.size()];
    vector.copyInto(objectReferencedLinkData);
    return(objectReferencedLinkData);
  }

  public static String selectTableName(ConnectionProvider connectionProvider, String adTableId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT TABLENAME" +
      "        FROM AD_TABLE " +
      "        WHERE AD_TABLE_ID = ?";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTableId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "TABLENAME");
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
