//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.info;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

class LocatorData implements FieldProvider {
static Logger log4j = Logger.getLogger(LocatorData.class);
  private String InitRecordNumber="0";
  public String rn1;
  public String mLocatorId;
  public String name;
  public String value;
  public String priorityno;
  public String isdefault;
  public String aisle;
  public String bin;
  public String nivel;
  public String rowkey;
  public String position;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("RN1"))
      return rn1;
    else if (fieldName.equalsIgnoreCase("M_LOCATOR_ID") || fieldName.equals("mLocatorId"))
      return mLocatorId;
    else if (fieldName.equalsIgnoreCase("NAME"))
      return name;
    else if (fieldName.equalsIgnoreCase("VALUE"))
      return value;
    else if (fieldName.equalsIgnoreCase("PRIORITYNO"))
      return priorityno;
    else if (fieldName.equalsIgnoreCase("ISDEFAULT"))
      return isdefault;
    else if (fieldName.equalsIgnoreCase("AISLE"))
      return aisle;
    else if (fieldName.equalsIgnoreCase("BIN"))
      return bin;
    else if (fieldName.equalsIgnoreCase("NIVEL"))
      return nivel;
    else if (fieldName.equalsIgnoreCase("ROWKEY"))
      return rowkey;
    else if (fieldName.equals("position"))
      return position;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static LocatorData[] select(ConnectionProvider connectionProvider, String rownum, String adUserClient, String adUserOrg, String key, String warehouse, String aisle, String bin, String level, String orderBy, String oraLimit, String pgLimit)    throws ServletException {
    return select(connectionProvider, rownum, adUserClient, adUserOrg, key, warehouse, aisle, bin, level, orderBy, oraLimit, pgLimit, 0, 0);
  }

  public static LocatorData[] select(ConnectionProvider connectionProvider, String rownum, String adUserClient, String adUserOrg, String key, String warehouse, String aisle, String bin, String level, String orderBy, String oraLimit, String pgLimit, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT * FROM ( SELECT ";
    strSql = strSql + ((rownum==null || rownum.equals(""))?"":rownum);
    strSql = strSql + 
      " AS RN1, A.* FROM (      				   " +
      "        SELECT m.M_LOCATOR_ID, mw.NAME, m.VALUE, m.PRIORITYNO, " +
      "        m.ISDEFAULT, m.X AS aisle, m.Y AS bin, m.Z AS nivel," +
      "        m.M_LOCATOR_ID || '@_##_@' || m.value  AS rowKey" +
      "        FROM M_LOCATOR m, M_WAREHOUSE mw,Ad_Org ao" +
      "        WHERE m.M_WAREHOUSE_ID = mw.M_WAREHOUSE_ID" +
      "        AND mw.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND mw.AD_Org_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ") " +
      "        AND mw.ISACTIVE = 'Y'" +
      "        AND m.ISACTIVE = 'Y'";
    strSql = strSql + ((key==null || key.equals("") || key.equals("%") )?"":"  AND UPPER(m.VALUE) LIKE UPPER(?)  ");
    strSql = strSql + ((warehouse==null || warehouse.equals("") || warehouse.equals("%") )?"":"  AND UPPER(mw.NAME) LIKE UPPER(?)  ");
    strSql = strSql + ((aisle==null || aisle.equals("") || aisle.equals("%") )?"":"  AND UPPER(m.X) LIKE UPPER(?)  ");
    strSql = strSql + ((bin==null || bin.equals("") || bin.equals("%") )?"":"  AND UPPER(m.Y) LIKE UPPER(?)  ");
    strSql = strSql + ((level==null || level.equals("") || level.equals("%") )?"":"  AND UPPER(m.Z) LIKE UPPER(?)  ");
    strSql = strSql + 
      "        AND ao.AD_Org_ID = m.AD_Org_ID" +
      "        AND ao.ISACTIVE='Y'" +
      "        ORDER BY ";
    strSql = strSql + ((orderBy==null || orderBy.equals(""))?"":orderBy);
    strSql = strSql + 
      "		) A ) B" +
      "		WHERE 1=1";
    strSql = strSql + ((oraLimit==null || oraLimit.equals(""))?"":" AND RN1 BETWEEN " + oraLimit);
    strSql = strSql + ((pgLimit==null || pgLimit.equals(""))?"":" LIMIT " + pgLimit);

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (rownum != null && !(rownum.equals(""))) {
        }
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }
      if (key != null && !(key.equals("")) && !(key.equals("%"))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, key);
      }
      if (warehouse != null && !(warehouse.equals("")) && !(warehouse.equals("%"))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, warehouse);
      }
      if (aisle != null && !(aisle.equals("")) && !(aisle.equals("%"))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, aisle);
      }
      if (bin != null && !(bin.equals("")) && !(bin.equals("%"))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, bin);
      }
      if (level != null && !(level.equals("")) && !(level.equals("%"))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, level);
      }
      if (orderBy != null && !(orderBy.equals(""))) {
        }
      if (oraLimit != null && !(oraLimit.equals(""))) {
        }
      if (pgLimit != null && !(pgLimit.equals(""))) {
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
        LocatorData objectLocatorData = new LocatorData();
        objectLocatorData.rn1 = UtilSql.getValue(result, "RN1");
        objectLocatorData.mLocatorId = UtilSql.getValue(result, "M_LOCATOR_ID");
        objectLocatorData.name = UtilSql.getValue(result, "NAME");
        objectLocatorData.value = UtilSql.getValue(result, "VALUE");
        objectLocatorData.priorityno = UtilSql.getValue(result, "PRIORITYNO");
        objectLocatorData.isdefault = UtilSql.getValue(result, "ISDEFAULT");
        objectLocatorData.aisle = UtilSql.getValue(result, "AISLE");
        objectLocatorData.bin = UtilSql.getValue(result, "BIN");
        objectLocatorData.nivel = UtilSql.getValue(result, "NIVEL");
        objectLocatorData.rowkey = UtilSql.getValue(result, "ROWKEY");
        objectLocatorData.position = Long.toString(countRecord);
        objectLocatorData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectLocatorData);
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
    LocatorData objectLocatorData[] = new LocatorData[vector.size()];
    vector.copyInto(objectLocatorData);
    return(objectLocatorData);
  }

  public static String countRows(ConnectionProvider connectionProvider, String rownum, String adUserClient, String adUserOrg, String key, String warehouse, String aisle, String bin, String level, String pgLimit, String oraLimit1, String oraLimit2)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT COUNT(*) AS VALUE FROM ( SELECT ";
    strSql = strSql + ((rownum==null || rownum.equals(""))?"":rownum);
    strSql = strSql + 
      " AS RN1, B.* FROM ( SELECT 1" +
      "        FROM M_LOCATOR m, M_WAREHOUSE mw" +
      "        WHERE m.M_WAREHOUSE_ID = mw.M_WAREHOUSE_ID" +
      "        AND mw.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND mw.AD_Org_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ") " +
      "        AND mw.ISACTIVE = 'Y'" +
      "        AND m.ISACTIVE = 'Y'";
    strSql = strSql + ((key==null || key.equals("") || key.equals("%") )?"":"  AND UPPER(m.VALUE) LIKE UPPER(?)  ");
    strSql = strSql + ((warehouse==null || warehouse.equals("") || warehouse.equals("%") )?"":"  AND UPPER(mw.NAME) LIKE UPPER(?)  ");
    strSql = strSql + ((aisle==null || aisle.equals("") || aisle.equals("%") )?"":"  AND UPPER(m.X) LIKE UPPER(?)  ");
    strSql = strSql + ((bin==null || bin.equals("") || bin.equals("%") )?"":"  AND UPPER(m.Y) LIKE UPPER(?)  ");
    strSql = strSql + ((level==null || level.equals("") || level.equals("%") )?"":"  AND UPPER(m.Z) LIKE UPPER(?)  ");
    strSql = strSql + 
      "		AND 1=1";
    strSql = strSql + ((pgLimit==null || pgLimit.equals(""))?"":" LIMIT " + pgLimit);
    strSql = strSql + 
      "		) B";
    strSql = strSql + ((oraLimit1==null || oraLimit1.equals(""))?"":"  WHERE ROWNUM <= " + oraLimit1);
    strSql = strSql + 
      "		) A ";
    strSql = strSql + ((oraLimit2==null || oraLimit2.equals(""))?"":" WHERE RN1 BETWEEN " + oraLimit2);

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (rownum != null && !(rownum.equals(""))) {
        }
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }
      if (key != null && !(key.equals("")) && !(key.equals("%"))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, key);
      }
      if (warehouse != null && !(warehouse.equals("")) && !(warehouse.equals("%"))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, warehouse);
      }
      if (aisle != null && !(aisle.equals("")) && !(aisle.equals("%"))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, aisle);
      }
      if (bin != null && !(bin.equals("")) && !(bin.equals("%"))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, bin);
      }
      if (level != null && !(level.equals("")) && !(level.equals("%"))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, level);
      }
      if (pgLimit != null && !(pgLimit.equals(""))) {
        }
      if (oraLimit1 != null && !(oraLimit1.equals(""))) {
        }
      if (oraLimit2 != null && !(oraLimit2.equals(""))) {
        }

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "VALUE");
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

  public static LocatorData[] selectKey(ConnectionProvider connectionProvider, String adUserClient, String adUserOrg, String warehouse, String key)    throws ServletException {
    return selectKey(connectionProvider, adUserClient, adUserOrg, warehouse, key, 0, 0);
  }

  public static LocatorData[] selectKey(ConnectionProvider connectionProvider, String adUserClient, String adUserOrg, String warehouse, String key, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT m.M_LOCATOR_ID, mw.NAME, m.VALUE, m.PRIORITYNO, m.ISDEFAULT, m.X AS aisle, m.Y AS bin, m.Z AS nivel" +
      "        FROM M_LOCATOR m, M_WAREHOUSE mw" +
      "        WHERE m.M_WAREHOUSE_ID = mw.M_WAREHOUSE_ID" +
      "        AND mw.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND mw.AD_Org_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ") " +
      "        AND mw.ISACTIVE = 'Y'" +
      "        AND m.ISACTIVE = 'Y'";
    strSql = strSql + ((warehouse==null || warehouse.equals("") || warehouse.equals("%") )?"":"  AND UPPER(mw.NAME) LIKE UPPER(?)  ");
    strSql = strSql + 
      "        AND UPPER(m.VALUE) LIKE UPPER(?)";

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
      if (warehouse != null && !(warehouse.equals("")) && !(warehouse.equals("%"))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, warehouse);
      }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, key);

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
        LocatorData objectLocatorData = new LocatorData();
        objectLocatorData.mLocatorId = UtilSql.getValue(result, "M_LOCATOR_ID");
        objectLocatorData.name = UtilSql.getValue(result, "NAME");
        objectLocatorData.value = UtilSql.getValue(result, "VALUE");
        objectLocatorData.priorityno = UtilSql.getValue(result, "PRIORITYNO");
        objectLocatorData.isdefault = UtilSql.getValue(result, "ISDEFAULT");
        objectLocatorData.aisle = UtilSql.getValue(result, "AISLE");
        objectLocatorData.bin = UtilSql.getValue(result, "BIN");
        objectLocatorData.nivel = UtilSql.getValue(result, "NIVEL");
        objectLocatorData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectLocatorData);
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
    LocatorData objectLocatorData[] = new LocatorData[vector.size()];
    vector.copyInto(objectLocatorData);
    return(objectLocatorData);
  }

  public static String selectname(ConnectionProvider connectionProvider, String mWarehouseId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT mw.name" +
      "        FROM M_WAREHOUSE mw" +
      "        WHERE mw.M_WAREHOUSE_ID = ?";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mWarehouseId);

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
}
