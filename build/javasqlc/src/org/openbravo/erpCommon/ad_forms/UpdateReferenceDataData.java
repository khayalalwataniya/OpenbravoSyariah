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

class UpdateReferenceDataData implements FieldProvider {
static Logger log4j = Logger.getLogger(UpdateReferenceDataData.class);
  private String InitRecordNumber="0";
  public String id;
  public String name;
  public String haschartofaccounts;
  public String istranslationmodule;
  public String adModuleId;
  public String path;
  public String javapackage;
  public String datasetname;
  public String version;
  public String checksum;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("ID"))
      return id;
    else if (fieldName.equalsIgnoreCase("NAME"))
      return name;
    else if (fieldName.equalsIgnoreCase("HASCHARTOFACCOUNTS"))
      return haschartofaccounts;
    else if (fieldName.equalsIgnoreCase("ISTRANSLATIONMODULE"))
      return istranslationmodule;
    else if (fieldName.equalsIgnoreCase("AD_MODULE_ID") || fieldName.equals("adModuleId"))
      return adModuleId;
    else if (fieldName.equalsIgnoreCase("PATH"))
      return path;
    else if (fieldName.equalsIgnoreCase("JAVAPACKAGE"))
      return javapackage;
    else if (fieldName.equalsIgnoreCase("DATASETNAME"))
      return datasetname;
    else if (fieldName.equalsIgnoreCase("VERSION"))
      return version;
    else if (fieldName.equalsIgnoreCase("CHECKSUM"))
      return checksum;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static UpdateReferenceDataData[] select(ConnectionProvider connectionProvider)    throws ServletException {
    return select(connectionProvider, 0, 0);
  }

  public static UpdateReferenceDataData[] select(ConnectionProvider connectionProvider, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT '' as id, '' as NAME, '' AS HASCHARTOFACCOUNTS, '' AS  ISTRANSLATIONMODULE," +
      "      '' AS AD_MODULE_ID, '' AS PATH, '' AS  JAVAPACKAGE, '' AS DATASETNAME, '' AS VERSION, '' AS CHECKSUM" +
      "      FROM DUAL";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());

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
        UpdateReferenceDataData objectUpdateReferenceDataData = new UpdateReferenceDataData();
        objectUpdateReferenceDataData.id = UtilSql.getValue(result, "ID");
        objectUpdateReferenceDataData.name = UtilSql.getValue(result, "NAME");
        objectUpdateReferenceDataData.haschartofaccounts = UtilSql.getValue(result, "HASCHARTOFACCOUNTS");
        objectUpdateReferenceDataData.istranslationmodule = UtilSql.getValue(result, "ISTRANSLATIONMODULE");
        objectUpdateReferenceDataData.adModuleId = UtilSql.getValue(result, "AD_MODULE_ID");
        objectUpdateReferenceDataData.path = UtilSql.getValue(result, "PATH");
        objectUpdateReferenceDataData.javapackage = UtilSql.getValue(result, "JAVAPACKAGE");
        objectUpdateReferenceDataData.datasetname = UtilSql.getValue(result, "DATASETNAME");
        objectUpdateReferenceDataData.version = UtilSql.getValue(result, "VERSION");
        objectUpdateReferenceDataData.checksum = UtilSql.getValue(result, "CHECKSUM");
        objectUpdateReferenceDataData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectUpdateReferenceDataData);
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
    UpdateReferenceDataData objectUpdateReferenceDataData[] = new UpdateReferenceDataData[vector.size()];
    vector.copyInto(objectUpdateReferenceDataData);
    return(objectUpdateReferenceDataData);
  }

  public static UpdateReferenceDataData[] selectOrganization(ConnectionProvider connectionProvider, String rol, String adOrgClient)    throws ServletException {
    return selectOrganization(connectionProvider, rol, adOrgClient, 0, 0);
  }

  public static UpdateReferenceDataData[] selectOrganization(ConnectionProvider connectionProvider, String rol, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "       SELECT A_O.AD_ORG_ID AS ID, A_O.NAME " +
      "       FROM AD_ORG A_O, AD_ROLE_ORGACCESS A_R_O, AD_ROLE R " +
      "       WHERE A_R_O.AD_ORG_ID = A_O.AD_ORG_ID " +
      "       AND A_R_O.ISACTIVE = 'Y' " +
      "       AND A_R_O.AD_ROLE_ID = R.AD_ROLE_ID " +
      "       AND R.ISACTIVE = 'Y'" +
      "       AND A_R_O.AD_ROLE_ID = ? " +
      "       AND A_O.AD_Org_ID IN(";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ")" +
      "       ORDER BY A_O.NAME";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, rol);
      if (adOrgClient != null && !(adOrgClient.equals(""))) {
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
        UpdateReferenceDataData objectUpdateReferenceDataData = new UpdateReferenceDataData();
        objectUpdateReferenceDataData.id = UtilSql.getValue(result, "ID");
        objectUpdateReferenceDataData.name = UtilSql.getValue(result, "NAME");
        objectUpdateReferenceDataData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectUpdateReferenceDataData);
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
    UpdateReferenceDataData objectUpdateReferenceDataData[] = new UpdateReferenceDataData[vector.size()];
    vector.copyInto(objectUpdateReferenceDataData);
    return(objectUpdateReferenceDataData);
  }

  public static UpdateReferenceDataData[] selectModules(ConnectionProvider connectionProvider, String modules, String organization)    throws ServletException {
    return selectModules(connectionProvider, modules, organization, 0, 0);
  }

  public static UpdateReferenceDataData[] selectModules(ConnectionProvider connectionProvider, String modules, String organization, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT AD_MODULE.NAME, AD_MODULE.HASCHARTOFACCOUNTS, AD_MODULE.ISTRANSLATIONMODULE, " +
      "      AD_MODULE.AD_MODULE_ID , AD_MODULE.JAVAPACKAGE, AD_DATASET.NAME AS DATASETNAME, AD_MODULE.VERSION, AD_DATASET.CHECKSUM" +
      "      FROM AD_MODULE, AD_DATASET" +
      "      WHERE AD_MODULE.AD_MODULE_ID = AD_DATASET.AD_MODULE_ID      " +
      "      AND AD_MODULE.AD_MODULE_ID IN ";
    strSql = strSql + ((modules==null || modules.equals(""))?"":modules);
    strSql = strSql + 
      "      AND AD_DATASET.ISACTIVE='Y'" +
      "      AND ((? <> '0' AND AD_DATASET.ACCESSLEVEL IN ('3','1')) OR (? = '0' AND AD_DATASET.ACCESSLEVEL IN ('3','6')))" +
      "      ORDER BY AD_MODULE.AD_MODULE_ID, AD_DATASET.SEQNO, AD_DATASET.AD_DATASET_ID";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (modules != null && !(modules.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, organization);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, organization);

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
        UpdateReferenceDataData objectUpdateReferenceDataData = new UpdateReferenceDataData();
        objectUpdateReferenceDataData.name = UtilSql.getValue(result, "NAME");
        objectUpdateReferenceDataData.haschartofaccounts = UtilSql.getValue(result, "HASCHARTOFACCOUNTS");
        objectUpdateReferenceDataData.istranslationmodule = UtilSql.getValue(result, "ISTRANSLATIONMODULE");
        objectUpdateReferenceDataData.adModuleId = UtilSql.getValue(result, "AD_MODULE_ID");
        objectUpdateReferenceDataData.javapackage = UtilSql.getValue(result, "JAVAPACKAGE");
        objectUpdateReferenceDataData.datasetname = UtilSql.getValue(result, "DATASETNAME");
        objectUpdateReferenceDataData.version = UtilSql.getValue(result, "VERSION");
        objectUpdateReferenceDataData.checksum = UtilSql.getValue(result, "CHECKSUM");
        objectUpdateReferenceDataData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectUpdateReferenceDataData);
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
    UpdateReferenceDataData objectUpdateReferenceDataData[] = new UpdateReferenceDataData[vector.size()];
    vector.copyInto(objectUpdateReferenceDataData);
    return(objectUpdateReferenceDataData);
  }

  public static String selectRegister(ConnectionProvider connectionProvider, String AD_Module_ID, String AD_Org_ID, String AD_Client_ID)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT COUNT(*) " +
      "      FROM AD_ORGMODULE" +
      "      WHERE AD_MODULE_ID = ?" +
      "      AND AD_ORG_ID = ?" +
      "      AND AD_CLIENT_ID = ?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, AD_Module_ID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, AD_Org_ID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, AD_Client_ID);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "COUNT(*)");
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

  public static String existsOrgModule(ConnectionProvider connectionProvider, String AD_Client_ID, String AD_Org_ID, String AD_Module_ID, String version)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT COUNT(*)" +
      "      FROM AD_ORGMODULE" +
      "      WHERE AD_CLIENT_ID = ?" +
      "      AND AD_ORG_ID = ?" +
      "      AND AD_MODULE_ID = ?" +
      "      AND VERSION = ?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, AD_Client_ID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, AD_Org_ID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, AD_Module_ID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, version);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "COUNT(*)");
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

  public static int updateOrgModule(ConnectionProvider connectionProvider, String version, String AD_User_ID, String AD_Client_ID, String AD_Org_ID, String AD_Module_ID)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      UPDATE AD_ORGMODULE SET VERSION = ?, UPDATED=NOW(), UPDATEDBY=?" +
      "      WHERE AD_CLIENT_ID = ?" +
      "      AND AD_ORG_ID = ?" +
      "      AND AD_MODULE_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, version);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, AD_User_ID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, AD_Client_ID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, AD_Org_ID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, AD_Module_ID);

      updateCount = st.executeUpdate();
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
    return(updateCount);
  }

  public static int updateOrgModuleChecksum(ConnectionProvider connectionProvider, String checksum, String AD_User_ID, String AD_Client_ID, String AD_Org_ID, String AD_Module_ID)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      UPDATE AD_ORGMODULE SET CHECKSUM = ?, UPDATED=NOW(), UPDATEDBY=?" +
      "      WHERE AD_CLIENT_ID = ?" +
      "      AND AD_ORG_ID = ?" +
      "      AND AD_MODULE_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, checksum);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, AD_User_ID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, AD_Client_ID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, AD_Org_ID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, AD_Module_ID);

      updateCount = st.executeUpdate();
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
    return(updateCount);
  }
}
