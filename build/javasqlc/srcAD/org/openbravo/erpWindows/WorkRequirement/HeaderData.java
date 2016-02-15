//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.WorkRequirement;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

/**
WAD Generated class
 */
class HeaderData implements FieldProvider {
static Logger log4j = Logger.getLogger(HeaderData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String adOrgId;
  public String adOrgIdr;
  public String cDoctypeId;
  public String cDoctypeIdr;
  public String documentno;
  public String maProcessplanId;
  public String maProcessplanIdr;
  public String quantity;
  public String launchdate;
  public String startdate;
  public String enddate;
  public String conversionrate;
  public String secondaryqty;
  public String explodephases;
  public String secondaryunit;
  public String estimatedtime;
  public String runtime;
  public String processed;
  public String explote;
  public String closed;
  public String createworkrequirement;
  public String maWorkrequirementId;
  public String name;
  public String isactive;
  public String adClientId;
  public String language;
  public String adUserClient;
  public String adOrgClient;
  public String createdby;
  public String trBgcolor;
  public String totalCount;
  public String dateTimeFormat;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("CREATED"))
      return created;
    else if (fieldName.equalsIgnoreCase("CREATEDBYR"))
      return createdbyr;
    else if (fieldName.equalsIgnoreCase("UPDATED"))
      return updated;
    else if (fieldName.equalsIgnoreCase("UPDATED_TIME_STAMP") || fieldName.equals("updatedTimeStamp"))
      return updatedTimeStamp;
    else if (fieldName.equalsIgnoreCase("UPDATEDBY"))
      return updatedby;
    else if (fieldName.equalsIgnoreCase("UPDATEDBYR"))
      return updatedbyr;
    else if (fieldName.equalsIgnoreCase("AD_ORG_ID") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("AD_ORG_IDR") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("C_DOCTYPE_ID") || fieldName.equals("cDoctypeId"))
      return cDoctypeId;
    else if (fieldName.equalsIgnoreCase("C_DOCTYPE_IDR") || fieldName.equals("cDoctypeIdr"))
      return cDoctypeIdr;
    else if (fieldName.equalsIgnoreCase("DOCUMENTNO"))
      return documentno;
    else if (fieldName.equalsIgnoreCase("MA_PROCESSPLAN_ID") || fieldName.equals("maProcessplanId"))
      return maProcessplanId;
    else if (fieldName.equalsIgnoreCase("MA_PROCESSPLAN_IDR") || fieldName.equals("maProcessplanIdr"))
      return maProcessplanIdr;
    else if (fieldName.equalsIgnoreCase("QUANTITY"))
      return quantity;
    else if (fieldName.equalsIgnoreCase("LAUNCHDATE"))
      return launchdate;
    else if (fieldName.equalsIgnoreCase("STARTDATE"))
      return startdate;
    else if (fieldName.equalsIgnoreCase("ENDDATE"))
      return enddate;
    else if (fieldName.equalsIgnoreCase("CONVERSIONRATE"))
      return conversionrate;
    else if (fieldName.equalsIgnoreCase("SECONDARYQTY"))
      return secondaryqty;
    else if (fieldName.equalsIgnoreCase("EXPLODEPHASES"))
      return explodephases;
    else if (fieldName.equalsIgnoreCase("SECONDARYUNIT"))
      return secondaryunit;
    else if (fieldName.equalsIgnoreCase("ESTIMATEDTIME"))
      return estimatedtime;
    else if (fieldName.equalsIgnoreCase("RUNTIME"))
      return runtime;
    else if (fieldName.equalsIgnoreCase("PROCESSED"))
      return processed;
    else if (fieldName.equalsIgnoreCase("EXPLOTE"))
      return explote;
    else if (fieldName.equalsIgnoreCase("CLOSED"))
      return closed;
    else if (fieldName.equalsIgnoreCase("CREATEWORKREQUIREMENT"))
      return createworkrequirement;
    else if (fieldName.equalsIgnoreCase("MA_WORKREQUIREMENT_ID") || fieldName.equals("maWorkrequirementId"))
      return maWorkrequirementId;
    else if (fieldName.equalsIgnoreCase("NAME"))
      return name;
    else if (fieldName.equalsIgnoreCase("ISACTIVE"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("AD_CLIENT_ID") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("LANGUAGE"))
      return language;
    else if (fieldName.equals("adUserClient"))
      return adUserClient;
    else if (fieldName.equals("adOrgClient"))
      return adOrgClient;
    else if (fieldName.equals("createdby"))
      return createdby;
    else if (fieldName.equals("trBgcolor"))
      return trBgcolor;
    else if (fieldName.equals("totalCount"))
      return totalCount;
    else if (fieldName.equals("dateTimeFormat"))
      return dateTimeFormat;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

/**
Select for edit
 */
  public static HeaderData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static HeaderData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(MA_WorkRequirement.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = MA_WorkRequirement.CreatedBy) as CreatedByR, " +
      "        to_char(MA_WorkRequirement.Updated, ?) as updated, " +
      "        to_char(MA_WorkRequirement.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        MA_WorkRequirement.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = MA_WorkRequirement.UpdatedBy) as UpdatedByR," +
      "        MA_WorkRequirement.AD_Org_ID, " +
      "(CASE WHEN MA_WorkRequirement.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Value), ''))),'') ) END) AS AD_Org_IDR, " +
      "MA_WorkRequirement.C_Doctype_ID, " +
      "(CASE WHEN MA_WorkRequirement.C_Doctype_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL2.Name IS NULL THEN TO_CHAR(table2.Name) ELSE TO_CHAR(tableTRL2.Name) END)), ''))),'') ) END) AS C_Doctype_IDR, " +
      "MA_WorkRequirement.DocumentNo, " +
      "MA_WorkRequirement.MA_Processplan_ID, " +
      "(CASE WHEN MA_WorkRequirement.MA_Processplan_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Name), ''))),'') ) END) AS MA_Processplan_IDR, " +
      "MA_WorkRequirement.Quantity, " +
      "MA_WorkRequirement.Launchdate, " +
      "MA_WorkRequirement.StartDate, " +
      "MA_WorkRequirement.EndDate, " +
      "MA_WorkRequirement.Conversionrate, " +
      "MA_WorkRequirement.Secondaryqty, " +
      "COALESCE(MA_WorkRequirement.Explodephases, 'N') AS Explodephases, " +
      "MA_WorkRequirement.Secondaryunit, " +
      "MA_WorkRequirement.Estimatedtime, " +
      "MA_WorkRequirement.Runtime, " +
      "COALESCE(MA_WorkRequirement.Processed, 'N') AS Processed, " +
      "MA_WorkRequirement.Explote, " +
      "MA_WorkRequirement.Closed, " +
      "MA_WorkRequirement.Createworkrequirement, " +
      "MA_WorkRequirement.MA_Workrequirement_ID, " +
      "MA_WorkRequirement.Name, " +
      "COALESCE(MA_WorkRequirement.IsActive, 'N') AS IsActive, " +
      "MA_WorkRequirement.AD_Client_ID, " +
      "        ? AS LANGUAGE " +
      "        FROM MA_WorkRequirement left join (select AD_Org_ID, Value from AD_Org) table1 on (MA_WorkRequirement.AD_Org_ID = table1.AD_Org_ID) left join (select C_Doctype_ID, Name from C_Doctype) table2 on (MA_WorkRequirement.C_Doctype_ID = table2.C_Doctype_ID) left join (select C_DocType_ID,AD_Language, Name from C_DocType_TRL) tableTRL2 on (table2.C_DocType_ID = tableTRL2.C_DocType_ID and tableTRL2.AD_Language = ?)  left join (select MA_Processplan_ID, Name from MA_Processplan) table4 on (MA_WorkRequirement.MA_Processplan_ID = table4.MA_Processplan_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 " +
      "        AND MA_WorkRequirement.MA_Workrequirement_ID = ? " +
      "        AND MA_WorkRequirement.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND MA_WorkRequirement.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateTimeFormat);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateTimeFormat);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, key);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
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
        HeaderData objectHeaderData = new HeaderData();
        objectHeaderData.created = UtilSql.getValue(result, "CREATED");
        objectHeaderData.createdbyr = UtilSql.getValue(result, "CREATEDBYR");
        objectHeaderData.updated = UtilSql.getValue(result, "UPDATED");
        objectHeaderData.updatedTimeStamp = UtilSql.getValue(result, "UPDATED_TIME_STAMP");
        objectHeaderData.updatedby = UtilSql.getValue(result, "UPDATEDBY");
        objectHeaderData.updatedbyr = UtilSql.getValue(result, "UPDATEDBYR");
        objectHeaderData.adOrgId = UtilSql.getValue(result, "AD_ORG_ID");
        objectHeaderData.adOrgIdr = UtilSql.getValue(result, "AD_ORG_IDR");
        objectHeaderData.cDoctypeId = UtilSql.getValue(result, "C_DOCTYPE_ID");
        objectHeaderData.cDoctypeIdr = UtilSql.getValue(result, "C_DOCTYPE_IDR");
        objectHeaderData.documentno = UtilSql.getValue(result, "DOCUMENTNO");
        objectHeaderData.maProcessplanId = UtilSql.getValue(result, "MA_PROCESSPLAN_ID");
        objectHeaderData.maProcessplanIdr = UtilSql.getValue(result, "MA_PROCESSPLAN_IDR");
        objectHeaderData.quantity = UtilSql.getValue(result, "QUANTITY");
        objectHeaderData.launchdate = UtilSql.getDateValue(result, "LAUNCHDATE", "dd-MM-yyyy");
        objectHeaderData.startdate = UtilSql.getDateValue(result, "STARTDATE", "dd-MM-yyyy");
        objectHeaderData.enddate = UtilSql.getDateValue(result, "ENDDATE", "dd-MM-yyyy");
        objectHeaderData.conversionrate = UtilSql.getValue(result, "CONVERSIONRATE");
        objectHeaderData.secondaryqty = UtilSql.getValue(result, "SECONDARYQTY");
        objectHeaderData.explodephases = UtilSql.getValue(result, "EXPLODEPHASES");
        objectHeaderData.secondaryunit = UtilSql.getValue(result, "SECONDARYUNIT");
        objectHeaderData.estimatedtime = UtilSql.getValue(result, "ESTIMATEDTIME");
        objectHeaderData.runtime = UtilSql.getValue(result, "RUNTIME");
        objectHeaderData.processed = UtilSql.getValue(result, "PROCESSED");
        objectHeaderData.explote = UtilSql.getValue(result, "EXPLOTE");
        objectHeaderData.closed = UtilSql.getValue(result, "CLOSED");
        objectHeaderData.createworkrequirement = UtilSql.getValue(result, "CREATEWORKREQUIREMENT");
        objectHeaderData.maWorkrequirementId = UtilSql.getValue(result, "MA_WORKREQUIREMENT_ID");
        objectHeaderData.name = UtilSql.getValue(result, "NAME");
        objectHeaderData.isactive = UtilSql.getValue(result, "ISACTIVE");
        objectHeaderData.adClientId = UtilSql.getValue(result, "AD_CLIENT_ID");
        objectHeaderData.language = UtilSql.getValue(result, "LANGUAGE");
        objectHeaderData.adUserClient = "";
        objectHeaderData.adOrgClient = "";
        objectHeaderData.createdby = "";
        objectHeaderData.trBgcolor = "";
        objectHeaderData.totalCount = "";
        objectHeaderData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectHeaderData);
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
    HeaderData objectHeaderData[] = new HeaderData[vector.size()];
    vector.copyInto(objectHeaderData);
    return(objectHeaderData);
  }

/**
Create a registry
 */
  public static HeaderData[] set(String cDoctypeId, String maWorkrequirementId, String adClientId, String adOrgId, String isactive, String createdby, String createdbyr, String updatedby, String updatedbyr, String name, String maProcessplanId, String quantity, String launchdate, String startdate, String enddate, String closed, String explote, String processed, String documentno, String explodephases, String secondaryqty, String secondaryunit, String conversionrate, String runtime, String createworkrequirement, String estimatedtime)    throws ServletException {
    HeaderData objectHeaderData[] = new HeaderData[1];
    objectHeaderData[0] = new HeaderData();
    objectHeaderData[0].created = "";
    objectHeaderData[0].createdbyr = createdbyr;
    objectHeaderData[0].updated = "";
    objectHeaderData[0].updatedTimeStamp = "";
    objectHeaderData[0].updatedby = updatedby;
    objectHeaderData[0].updatedbyr = updatedbyr;
    objectHeaderData[0].adOrgId = adOrgId;
    objectHeaderData[0].adOrgIdr = "";
    objectHeaderData[0].cDoctypeId = cDoctypeId;
    objectHeaderData[0].cDoctypeIdr = "";
    objectHeaderData[0].documentno = documentno;
    objectHeaderData[0].maProcessplanId = maProcessplanId;
    objectHeaderData[0].maProcessplanIdr = "";
    objectHeaderData[0].quantity = quantity;
    objectHeaderData[0].launchdate = launchdate;
    objectHeaderData[0].startdate = startdate;
    objectHeaderData[0].enddate = enddate;
    objectHeaderData[0].conversionrate = conversionrate;
    objectHeaderData[0].secondaryqty = secondaryqty;
    objectHeaderData[0].explodephases = explodephases;
    objectHeaderData[0].secondaryunit = secondaryunit;
    objectHeaderData[0].estimatedtime = estimatedtime;
    objectHeaderData[0].runtime = runtime;
    objectHeaderData[0].processed = processed;
    objectHeaderData[0].explote = explote;
    objectHeaderData[0].closed = closed;
    objectHeaderData[0].createworkrequirement = createworkrequirement;
    objectHeaderData[0].maWorkrequirementId = maWorkrequirementId;
    objectHeaderData[0].name = name;
    objectHeaderData[0].isactive = isactive;
    objectHeaderData[0].adClientId = adClientId;
    objectHeaderData[0].language = "";
    return objectHeaderData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef55356831DB104AF0BE1319D15BBBF6FE(ConnectionProvider connectionProvider, String AD_Org_ID, String AD_Client_ID)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT C_DocType_ID from C_DocType WHERE AD_ISORGINCLUDED(?,C_DocType.AD_Org_ID, ?) <> -1 AND C_DocType.DocBaseType = 'WRE'ORDER BY C_DocType.isdefault DESC ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, AD_Org_ID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, AD_Client_ID);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "C_DOCTYPE_ID");
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
Select for auxiliar field
 */
  public static String selectDef801554_0(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))), '') ) as Createdby FROM AD_User left join (select AD_User_ID, Name from AD_User) table2 on (AD_User.AD_User_ID = table2.AD_User_ID) WHERE AD_User.isActive='Y' AND AD_User.AD_User_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, CreatedbyR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "CREATEDBY");
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
Select for auxiliar field
 */
  public static String selectDef801556_1(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))), '') ) as Updatedby FROM AD_User left join (select AD_User_ID, Name from AD_User) table2 on (AD_User.AD_User_ID = table2.AD_User_ID) WHERE AD_User.isActive='Y' AND AD_User.AD_User_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, UpdatedbyR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "UPDATEDBY");
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

  public int update(Connection conn, ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE MA_WorkRequirement" +
      "        SET AD_Org_ID = (?) , C_Doctype_ID = (?) , DocumentNo = (?) , MA_Processplan_ID = (?) , Quantity = TO_NUMBER(?) , Launchdate = TO_DATE(?) , StartDate = TO_DATE(?) , EndDate = TO_DATE(?) , Conversionrate = TO_NUMBER(?) , Secondaryqty = TO_NUMBER(?) , Explodephases = (?) , Secondaryunit = (?) , Estimatedtime = TO_NUMBER(?) , Runtime = TO_NUMBER(?) , Processed = (?) , Explote = (?) , Closed = (?) , Createworkrequirement = (?) , MA_Workrequirement_ID = (?) , Name = (?) , IsActive = (?) , AD_Client_ID = (?) , updated = now(), updatedby = ? " +
      "        WHERE MA_WorkRequirement.MA_Workrequirement_ID = ? " +
      "        AND MA_WorkRequirement.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND MA_WorkRequirement.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDoctypeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, documentno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maProcessplanId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, quantity);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, launchdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, startdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, enddate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, conversionrate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, secondaryqty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, explodephases);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, secondaryunit);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, estimatedtime);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, runtime);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, explote);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, closed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, createworkrequirement);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maWorkrequirementId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maWorkrequirementId);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adOrgClient != null && !(adOrgClient.equals(""))) {
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

  public int insert(Connection conn, ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        INSERT INTO MA_WorkRequirement " +
      "        (AD_Org_ID, C_Doctype_ID, DocumentNo, MA_Processplan_ID, Quantity, Launchdate, StartDate, EndDate, Conversionrate, Secondaryqty, Explodephases, Secondaryunit, Estimatedtime, Runtime, Processed, Explote, Closed, Createworkrequirement, MA_Workrequirement_ID, Name, IsActive, AD_Client_ID, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), TO_NUMBER(?), TO_DATE(?), TO_DATE(?), TO_DATE(?), TO_NUMBER(?), TO_NUMBER(?), (?), (?), TO_NUMBER(?), TO_NUMBER(?), (?), (?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDoctypeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, documentno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maProcessplanId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, quantity);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, launchdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, startdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, enddate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, conversionrate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, secondaryqty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, explodephases);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, secondaryunit);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, estimatedtime);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, runtime);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, explote);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, closed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, createworkrequirement);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maWorkrequirementId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, createdby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);

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

  public static int delete(ConnectionProvider connectionProvider, String param1, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM MA_WorkRequirement" +
      "        WHERE MA_WorkRequirement.MA_Workrequirement_ID = ? " +
      "        AND MA_WorkRequirement.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND MA_WorkRequirement.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adOrgClient != null && !(adOrgClient.equals(""))) {
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
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(updateCount);
  }

/**
Select for relation
 */
  public static String selectOrg(ConnectionProvider connectionProvider, String id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT AD_ORG_ID" +
      "          FROM MA_WorkRequirement" +
      "         WHERE MA_WorkRequirement.MA_Workrequirement_ID = ? ";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, id);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "AD_ORG_ID");
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

  public static String getCurrentDBTimestamp(ConnectionProvider connectionProvider, String id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp" +
      "          FROM MA_WorkRequirement" +
      "         WHERE MA_WorkRequirement.MA_Workrequirement_ID = ? ";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, id);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "UPDATED_TIME_STAMP");
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
