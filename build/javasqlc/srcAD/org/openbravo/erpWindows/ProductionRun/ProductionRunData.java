//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.ProductionRun;

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
class ProductionRunData implements FieldProvider {
static Logger log4j = Logger.getLogger(ProductionRunData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String mProductionId;
  public String productionplandate;
  public String line;
  public String maWrphaseId;
  public String maWrphaseIdr;
  public String starttime;
  public String endtime;
  public String maCostcenterVersionId;
  public String maCostcenterVersionIdr;
  public String calccost;
  public String neededquantity;
  public String productionqty;
  public String secondaryunit;
  public String conversionrate;
  public String secondaryqty;
  public String rejectedquantity;
  public String maCostcenteruse;
  public String usedmaterial;
  public String outsourced;
  public String processed;
  public String estimatedtime;
  public String runtime;
  public String closephase;
  public String validating;
  public String adOrgId;
  public String mProductionplanId;
  public String description;
  public String isactive;
  public String adClientId;
  public String mProductId;
  public String mLocatorId;
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
    else if (fieldName.equalsIgnoreCase("M_PRODUCTION_ID") || fieldName.equals("mProductionId"))
      return mProductionId;
    else if (fieldName.equalsIgnoreCase("PRODUCTIONPLANDATE"))
      return productionplandate;
    else if (fieldName.equalsIgnoreCase("LINE"))
      return line;
    else if (fieldName.equalsIgnoreCase("MA_WRPHASE_ID") || fieldName.equals("maWrphaseId"))
      return maWrphaseId;
    else if (fieldName.equalsIgnoreCase("MA_WRPHASE_IDR") || fieldName.equals("maWrphaseIdr"))
      return maWrphaseIdr;
    else if (fieldName.equalsIgnoreCase("STARTTIME"))
      return starttime;
    else if (fieldName.equalsIgnoreCase("ENDTIME"))
      return endtime;
    else if (fieldName.equalsIgnoreCase("MA_COSTCENTER_VERSION_ID") || fieldName.equals("maCostcenterVersionId"))
      return maCostcenterVersionId;
    else if (fieldName.equalsIgnoreCase("MA_COSTCENTER_VERSION_IDR") || fieldName.equals("maCostcenterVersionIdr"))
      return maCostcenterVersionIdr;
    else if (fieldName.equalsIgnoreCase("CALCCOST"))
      return calccost;
    else if (fieldName.equalsIgnoreCase("NEEDEDQUANTITY"))
      return neededquantity;
    else if (fieldName.equalsIgnoreCase("PRODUCTIONQTY"))
      return productionqty;
    else if (fieldName.equalsIgnoreCase("SECONDARYUNIT"))
      return secondaryunit;
    else if (fieldName.equalsIgnoreCase("CONVERSIONRATE"))
      return conversionrate;
    else if (fieldName.equalsIgnoreCase("SECONDARYQTY"))
      return secondaryqty;
    else if (fieldName.equalsIgnoreCase("REJECTEDQUANTITY"))
      return rejectedquantity;
    else if (fieldName.equalsIgnoreCase("MA_COSTCENTERUSE") || fieldName.equals("maCostcenteruse"))
      return maCostcenteruse;
    else if (fieldName.equalsIgnoreCase("USEDMATERIAL"))
      return usedmaterial;
    else if (fieldName.equalsIgnoreCase("OUTSOURCED"))
      return outsourced;
    else if (fieldName.equalsIgnoreCase("PROCESSED"))
      return processed;
    else if (fieldName.equalsIgnoreCase("ESTIMATEDTIME"))
      return estimatedtime;
    else if (fieldName.equalsIgnoreCase("RUNTIME"))
      return runtime;
    else if (fieldName.equalsIgnoreCase("CLOSEPHASE"))
      return closephase;
    else if (fieldName.equalsIgnoreCase("VALIDATING"))
      return validating;
    else if (fieldName.equalsIgnoreCase("AD_ORG_ID") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("M_PRODUCTIONPLAN_ID") || fieldName.equals("mProductionplanId"))
      return mProductionplanId;
    else if (fieldName.equalsIgnoreCase("DESCRIPTION"))
      return description;
    else if (fieldName.equalsIgnoreCase("ISACTIVE"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("AD_CLIENT_ID") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("M_PRODUCT_ID") || fieldName.equals("mProductId"))
      return mProductId;
    else if (fieldName.equalsIgnoreCase("M_LOCATOR_ID") || fieldName.equals("mLocatorId"))
      return mLocatorId;
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
  public static ProductionRunData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static ProductionRunData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(M_ProductionPlan.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = M_ProductionPlan.CreatedBy) as CreatedByR, " +
      "        to_char(M_ProductionPlan.Updated, ?) as updated, " +
      "        to_char(M_ProductionPlan.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        M_ProductionPlan.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = M_ProductionPlan.UpdatedBy) as UpdatedByR," +
      "        M_ProductionPlan.M_Production_ID, " +
      "M_ProductionPlan.Productionplandate, " +
      "M_ProductionPlan.Line, " +
      "M_ProductionPlan.MA_Wrphase_ID, " +
      "(CASE WHEN M_ProductionPlan.MA_Wrphase_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.DocumentNo), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(table2.StartDate, 'DD-MM-YYYY')),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.SeqNo), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))),'') ) END) AS MA_Wrphase_IDR, " +
      "TO_CHAR(M_ProductionPlan.Starttime, ?) AS Starttime, " +
      "TO_CHAR(M_ProductionPlan.Endtime, ?) AS Endtime, " +
      "M_ProductionPlan.MA_Costcenter_Version_ID, " +
      "(CASE WHEN M_ProductionPlan.MA_Costcenter_Version_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.DocumentNo), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(table4.ValidFrom, 'DD-MM-YYYY')),'') ) END) AS MA_Costcenter_Version_IDR, " +
      "M_ProductionPlan.Calccost, " +
      "M_ProductionPlan.Neededquantity, " +
      "M_ProductionPlan.ProductionQty, " +
      "M_ProductionPlan.Secondaryunit, " +
      "M_ProductionPlan.Conversionrate, " +
      "M_ProductionPlan.Secondaryqty, " +
      "M_ProductionPlan.Rejectedquantity, " +
      "M_ProductionPlan.MA_Costcenteruse, " +
      "M_ProductionPlan.Usedmaterial, " +
      "COALESCE(M_ProductionPlan.Outsourced, 'N') AS Outsourced, " +
      "COALESCE(M_ProductionPlan.Processed, 'N') AS Processed, " +
      "M_ProductionPlan.Estimatedtime, " +
      "M_ProductionPlan.Runtime, " +
      "COALESCE(M_ProductionPlan.Closephase, 'N') AS Closephase, " +
      "M_ProductionPlan.Validating, " +
      "M_ProductionPlan.AD_Org_ID, " +
      "M_ProductionPlan.M_ProductionPlan_ID, " +
      "M_ProductionPlan.Description, " +
      "COALESCE(M_ProductionPlan.IsActive, 'N') AS IsActive, " +
      "M_ProductionPlan.AD_Client_ID, " +
      "M_ProductionPlan.M_Product_ID, " +
      "M_ProductionPlan.M_Locator_ID, " +
      "        ? AS LANGUAGE " +
      "        FROM M_ProductionPlan left join (select MA_Wrphase_ID, MA_Workrequirement_ID, SeqNo, MA_Process_ID from MA_Wrphase) table1 on (M_ProductionPlan.MA_Wrphase_ID = table1.MA_Wrphase_ID) left join (select MA_Workrequirement_ID, DocumentNo, StartDate from MA_Workrequirement) table2 on (table1.MA_Workrequirement_ID = table2.MA_Workrequirement_ID) left join (select MA_Process_ID, Name from MA_Process) table3 on (table1.MA_Process_ID = table3.MA_Process_ID) left join (select MA_Costcenter_Version_ID, DocumentNo, MA_Costcenter_ID, ValidFrom from MA_Costcenter_Version) table4 on (M_ProductionPlan.MA_Costcenter_Version_ID = table4.MA_Costcenter_Version_ID) left join (select MA_Costcenter_ID, Name from MA_Costcenter) table5 on (table4.MA_Costcenter_ID = table5.MA_Costcenter_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 " +
      "        AND M_ProductionPlan.M_ProductionPlan_ID = ? " +
      "        AND M_ProductionPlan.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND M_ProductionPlan.AD_Org_ID IN (";
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateTimeFormat);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateTimeFormat);
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
        ProductionRunData objectProductionRunData = new ProductionRunData();
        objectProductionRunData.created = UtilSql.getValue(result, "CREATED");
        objectProductionRunData.createdbyr = UtilSql.getValue(result, "CREATEDBYR");
        objectProductionRunData.updated = UtilSql.getValue(result, "UPDATED");
        objectProductionRunData.updatedTimeStamp = UtilSql.getValue(result, "UPDATED_TIME_STAMP");
        objectProductionRunData.updatedby = UtilSql.getValue(result, "UPDATEDBY");
        objectProductionRunData.updatedbyr = UtilSql.getValue(result, "UPDATEDBYR");
        objectProductionRunData.mProductionId = UtilSql.getValue(result, "M_PRODUCTION_ID");
        objectProductionRunData.productionplandate = UtilSql.getDateValue(result, "PRODUCTIONPLANDATE", "dd-MM-yyyy");
        objectProductionRunData.line = UtilSql.getValue(result, "LINE");
        objectProductionRunData.maWrphaseId = UtilSql.getValue(result, "MA_WRPHASE_ID");
        objectProductionRunData.maWrphaseIdr = UtilSql.getValue(result, "MA_WRPHASE_IDR");
        objectProductionRunData.starttime = UtilSql.getValue(result, "STARTTIME");
        objectProductionRunData.endtime = UtilSql.getValue(result, "ENDTIME");
        objectProductionRunData.maCostcenterVersionId = UtilSql.getValue(result, "MA_COSTCENTER_VERSION_ID");
        objectProductionRunData.maCostcenterVersionIdr = UtilSql.getValue(result, "MA_COSTCENTER_VERSION_IDR");
        objectProductionRunData.calccost = UtilSql.getValue(result, "CALCCOST");
        objectProductionRunData.neededquantity = UtilSql.getValue(result, "NEEDEDQUANTITY");
        objectProductionRunData.productionqty = UtilSql.getValue(result, "PRODUCTIONQTY");
        objectProductionRunData.secondaryunit = UtilSql.getValue(result, "SECONDARYUNIT");
        objectProductionRunData.conversionrate = UtilSql.getValue(result, "CONVERSIONRATE");
        objectProductionRunData.secondaryqty = UtilSql.getValue(result, "SECONDARYQTY");
        objectProductionRunData.rejectedquantity = UtilSql.getValue(result, "REJECTEDQUANTITY");
        objectProductionRunData.maCostcenteruse = UtilSql.getValue(result, "MA_COSTCENTERUSE");
        objectProductionRunData.usedmaterial = UtilSql.getValue(result, "USEDMATERIAL");
        objectProductionRunData.outsourced = UtilSql.getValue(result, "OUTSOURCED");
        objectProductionRunData.processed = UtilSql.getValue(result, "PROCESSED");
        objectProductionRunData.estimatedtime = UtilSql.getValue(result, "ESTIMATEDTIME");
        objectProductionRunData.runtime = UtilSql.getValue(result, "RUNTIME");
        objectProductionRunData.closephase = UtilSql.getValue(result, "CLOSEPHASE");
        objectProductionRunData.validating = UtilSql.getValue(result, "VALIDATING");
        objectProductionRunData.adOrgId = UtilSql.getValue(result, "AD_ORG_ID");
        objectProductionRunData.mProductionplanId = UtilSql.getValue(result, "M_PRODUCTIONPLAN_ID");
        objectProductionRunData.description = UtilSql.getValue(result, "DESCRIPTION");
        objectProductionRunData.isactive = UtilSql.getValue(result, "ISACTIVE");
        objectProductionRunData.adClientId = UtilSql.getValue(result, "AD_CLIENT_ID");
        objectProductionRunData.mProductId = UtilSql.getValue(result, "M_PRODUCT_ID");
        objectProductionRunData.mLocatorId = UtilSql.getValue(result, "M_LOCATOR_ID");
        objectProductionRunData.language = UtilSql.getValue(result, "LANGUAGE");
        objectProductionRunData.adUserClient = "";
        objectProductionRunData.adOrgClient = "";
        objectProductionRunData.createdby = "";
        objectProductionRunData.trBgcolor = "";
        objectProductionRunData.totalCount = "";
        objectProductionRunData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectProductionRunData);
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
    ProductionRunData objectProductionRunData[] = new ProductionRunData[vector.size()];
    vector.copyInto(objectProductionRunData);
    return(objectProductionRunData);
  }

/**
Create a registry
 */
  public static ProductionRunData[] set(String mProductionplanId, String adClientId, String adOrgId, String isactive, String createdby, String createdbyr, String updatedby, String updatedbyr, String mProductionId, String mProductId, String productionqty, String mLocatorId, String description, String line, String productionplandate, String calccost, String validating, String closephase, String neededquantity, String rejectedquantity, String usedmaterial, String processed, String maWrphaseId, String maCostcenteruse, String secondaryunit, String secondaryqty, String conversionrate, String outsourced, String maCostcenterVersionId, String starttime, String estimatedtime, String runtime, String endtime)    throws ServletException {
    ProductionRunData objectProductionRunData[] = new ProductionRunData[1];
    objectProductionRunData[0] = new ProductionRunData();
    objectProductionRunData[0].created = "";
    objectProductionRunData[0].createdbyr = createdbyr;
    objectProductionRunData[0].updated = "";
    objectProductionRunData[0].updatedTimeStamp = "";
    objectProductionRunData[0].updatedby = updatedby;
    objectProductionRunData[0].updatedbyr = updatedbyr;
    objectProductionRunData[0].mProductionId = mProductionId;
    objectProductionRunData[0].productionplandate = productionplandate;
    objectProductionRunData[0].line = line;
    objectProductionRunData[0].maWrphaseId = maWrphaseId;
    objectProductionRunData[0].maWrphaseIdr = "";
    objectProductionRunData[0].starttime = starttime;
    objectProductionRunData[0].endtime = endtime;
    objectProductionRunData[0].maCostcenterVersionId = maCostcenterVersionId;
    objectProductionRunData[0].maCostcenterVersionIdr = "";
    objectProductionRunData[0].calccost = calccost;
    objectProductionRunData[0].neededquantity = neededquantity;
    objectProductionRunData[0].productionqty = productionqty;
    objectProductionRunData[0].secondaryunit = secondaryunit;
    objectProductionRunData[0].conversionrate = conversionrate;
    objectProductionRunData[0].secondaryqty = secondaryqty;
    objectProductionRunData[0].rejectedquantity = rejectedquantity;
    objectProductionRunData[0].maCostcenteruse = maCostcenteruse;
    objectProductionRunData[0].usedmaterial = usedmaterial;
    objectProductionRunData[0].outsourced = outsourced;
    objectProductionRunData[0].processed = processed;
    objectProductionRunData[0].estimatedtime = estimatedtime;
    objectProductionRunData[0].runtime = runtime;
    objectProductionRunData[0].closephase = closephase;
    objectProductionRunData[0].validating = validating;
    objectProductionRunData[0].adOrgId = adOrgId;
    objectProductionRunData[0].mProductionplanId = mProductionplanId;
    objectProductionRunData[0].description = description;
    objectProductionRunData[0].isactive = isactive;
    objectProductionRunData[0].adClientId = adClientId;
    objectProductionRunData[0].mProductId = mProductId;
    objectProductionRunData[0].mLocatorId = mLocatorId;
    objectProductionRunData[0].language = "";
    return objectProductionRunData;
  }

/**
Select for auxiliar field
 */
  public static String selectAuxFF808181323F83E801323F959F07002C(ConnectionProvider connectionProvider, String M_PRODUCTION_ID)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT AD_ORG_ID FROM M_PRODUCTION WHERE M_PRODUCTION_ID = ? ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, M_PRODUCTION_ID);

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

/**
Select for auxiliar field
 */
  public static String selectAuxFF80818132916D6E013291C49E7E00E6(ConnectionProvider connectionProvider, String M_PRODUCTION_ID)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT M_PRODUCTION.PROCESSED FROM M_PRODUCTION WHERE M_PRODUCTION.M_PRODUCTION_ID =  ? ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, M_PRODUCTION_ID);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "PROCESSED");
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
  public static String selectDef4759_0(ConnectionProvider connectionProvider, String CreatedByR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))), '') ) as CreatedBy FROM AD_User left join (select AD_User_ID, Name from AD_User) table2 on (AD_User.AD_User_ID = table2.AD_User_ID) WHERE AD_User.isActive='Y' AND AD_User.AD_User_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, CreatedByR);

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
  public static String selectDef4761_1(ConnectionProvider connectionProvider, String UpdatedByR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))), '') ) as UpdatedBy FROM AD_User left join (select AD_User_ID, Name from AD_User) table2 on (AD_User.AD_User_ID = table2.AD_User_ID) WHERE AD_User.isActive='Y' AND AD_User.AD_User_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, UpdatedByR);

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

/**
Select for auxiliar field
 */
  public static String selectDef4769(ConnectionProvider connectionProvider, String M_Production_ID)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT COALESCE(MAX(Line),0)+10 AS DefaultValue FROM M_ProductionPlan WHERE M_Production_ID=? ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, M_Production_ID);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "DEFAULTVALUE");
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
  public static String selectDef802026(ConnectionProvider connectionProvider, String MA_WRPhase_ID)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (QUANTITY - DONEQUANTITY) AS DefaultValue FROM MA_WRPhase WHERE MA_WRPhase_ID = ? ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, MA_WRPhase_ID);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "DEFAULTVALUE");
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
      "        UPDATE M_ProductionPlan" +
      "        SET M_Production_ID = (?) , Productionplandate = TO_DATE(?) , Line = TO_NUMBER(?) , MA_Wrphase_ID = (?) , Starttime = TO_TIMESTAMP(?, ?) , Endtime = TO_TIMESTAMP(?, ?) , MA_Costcenter_Version_ID = (?) , Calccost = TO_NUMBER(?) , Neededquantity = TO_NUMBER(?) , ProductionQty = TO_NUMBER(?) , Secondaryunit = (?) , Conversionrate = TO_NUMBER(?) , Secondaryqty = TO_NUMBER(?) , Rejectedquantity = TO_NUMBER(?) , MA_Costcenteruse = TO_NUMBER(?) , Usedmaterial = (?) , Outsourced = (?) , Processed = (?) , Estimatedtime = TO_NUMBER(?) , Runtime = TO_NUMBER(?) , Closephase = (?) , Validating = (?) , AD_Org_ID = (?) , M_ProductionPlan_ID = (?) , Description = (?) , IsActive = (?) , AD_Client_ID = (?) , M_Product_ID = (?) , M_Locator_ID = (?) , updated = now(), updatedby = ? " +
      "        WHERE M_ProductionPlan.M_ProductionPlan_ID = ? " +
      "        AND M_ProductionPlan.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND M_ProductionPlan.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductionId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, productionplandate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, line);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maWrphaseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, starttime);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateTimeFormat);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, endtime);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateTimeFormat);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maCostcenterVersionId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, calccost);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, neededquantity);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, productionqty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, secondaryunit);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, conversionrate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, secondaryqty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, rejectedquantity);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maCostcenteruse);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, usedmaterial);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, outsourced);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, estimatedtime);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, runtime);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, closephase);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, validating);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductionplanId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mLocatorId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductionplanId);
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
      "        INSERT INTO M_ProductionPlan " +
      "        (M_Production_ID, Productionplandate, Line, MA_Wrphase_ID, Starttime, Endtime, MA_Costcenter_Version_ID, Calccost, Neededquantity, ProductionQty, Secondaryunit, Conversionrate, Secondaryqty, Rejectedquantity, MA_Costcenteruse, Usedmaterial, Outsourced, Processed, Estimatedtime, Runtime, Closephase, Validating, AD_Org_ID, M_ProductionPlan_ID, Description, IsActive, AD_Client_ID, M_Product_ID, M_Locator_ID, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), TO_DATE(?), TO_NUMBER(?), (?), TO_TIMESTAMP(?, ?), TO_TIMESTAMP(?, ?), (?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), (?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), (?), (?), (?), TO_NUMBER(?), TO_NUMBER(?), (?), (?), (?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductionId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, productionplandate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, line);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maWrphaseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, starttime);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateTimeFormat);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, endtime);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateTimeFormat);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maCostcenterVersionId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, calccost);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, neededquantity);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, productionqty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, secondaryunit);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, conversionrate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, secondaryqty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, rejectedquantity);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maCostcenteruse);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, usedmaterial);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, outsourced);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, estimatedtime);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, runtime);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, closephase);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, validating);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductionplanId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mLocatorId);
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
      "        DELETE FROM M_ProductionPlan" +
      "        WHERE M_ProductionPlan.M_ProductionPlan_ID = ? " +
      "        AND M_ProductionPlan.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND M_ProductionPlan.AD_Org_ID IN (";
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
      "          FROM M_ProductionPlan" +
      "         WHERE M_ProductionPlan.M_ProductionPlan_ID = ? ";

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
      "          FROM M_ProductionPlan" +
      "         WHERE M_ProductionPlan.M_ProductionPlan_ID = ? ";

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
