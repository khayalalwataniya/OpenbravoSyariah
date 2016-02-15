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

class LocationSearchData implements FieldProvider {
static Logger log4j = Logger.getLogger(LocationSearchData.class);
  private String InitRecordNumber="0";
  public String cLocationId;
  public String adClientId;
  public String adOrgId;
  public String createdby;
  public String updatedby;
  public String cCountryId;
  public String cRegionId;
  public String name;
  public String address1;
  public String address2;
  public String postal;
  public String city;
  public String region;
  public String country;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("C_LOCATION_ID") || fieldName.equals("cLocationId"))
      return cLocationId;
    else if (fieldName.equalsIgnoreCase("AD_CLIENT_ID") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("AD_ORG_ID") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("CREATEDBY"))
      return createdby;
    else if (fieldName.equalsIgnoreCase("UPDATEDBY"))
      return updatedby;
    else if (fieldName.equalsIgnoreCase("C_COUNTRY_ID") || fieldName.equals("cCountryId"))
      return cCountryId;
    else if (fieldName.equalsIgnoreCase("C_REGION_ID") || fieldName.equals("cRegionId"))
      return cRegionId;
    else if (fieldName.equalsIgnoreCase("NAME"))
      return name;
    else if (fieldName.equalsIgnoreCase("ADDRESS1"))
      return address1;
    else if (fieldName.equalsIgnoreCase("ADDRESS2"))
      return address2;
    else if (fieldName.equalsIgnoreCase("POSTAL"))
      return postal;
    else if (fieldName.equalsIgnoreCase("CITY"))
      return city;
    else if (fieldName.equalsIgnoreCase("REGION"))
      return region;
    else if (fieldName.equalsIgnoreCase("COUNTRY"))
      return country;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static LocationSearchData[] select(ConnectionProvider connectionProvider, String language, String cLocationId)    throws ServletException {
    return select(connectionProvider, language, cLocationId, 0, 0);
  }

  public static LocationSearchData[] select(ConnectionProvider connectionProvider, String language, String cLocationId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT L.C_LOCATION_ID, L.AD_CLIENT_ID, L.AD_ORG_ID, L.CREATEDBY, L.UPDATEDBY, L.C_COUNTRY_ID, L.C_REGION_ID," +
      "        AD_COLUMN_IDENTIFIER(TO_CHAR('C_Location'), TO_CHAR(L.C_LOCATION_ID), ?) AS NAME," +
      "        L.ADDRESS1, L.ADDRESS2, L.POSTAL, L.CITY, R.DESCRIPTION AS REGION, C.NAME AS COUNTRY" +
      "        FROM C_LOCATION L left join C_REGION R on  L.C_REGION_ID = R.C_REGION_ID, " +
      "             C_COUNTRY C " +
      "        WHERE L.C_COUNTRY_ID = C.C_COUNTRY_ID" +
      "        AND L.ISACTIVE = 'Y'" +
      "        AND L.C_LOCATION_ID = ?";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cLocationId);

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
        LocationSearchData objectLocationSearchData = new LocationSearchData();
        objectLocationSearchData.cLocationId = UtilSql.getValue(result, "C_LOCATION_ID");
        objectLocationSearchData.adClientId = UtilSql.getValue(result, "AD_CLIENT_ID");
        objectLocationSearchData.adOrgId = UtilSql.getValue(result, "AD_ORG_ID");
        objectLocationSearchData.createdby = UtilSql.getValue(result, "CREATEDBY");
        objectLocationSearchData.updatedby = UtilSql.getValue(result, "UPDATEDBY");
        objectLocationSearchData.cCountryId = UtilSql.getValue(result, "C_COUNTRY_ID");
        objectLocationSearchData.cRegionId = UtilSql.getValue(result, "C_REGION_ID");
        objectLocationSearchData.name = UtilSql.getValue(result, "NAME");
        objectLocationSearchData.address1 = UtilSql.getValue(result, "ADDRESS1");
        objectLocationSearchData.address2 = UtilSql.getValue(result, "ADDRESS2");
        objectLocationSearchData.postal = UtilSql.getValue(result, "POSTAL");
        objectLocationSearchData.city = UtilSql.getValue(result, "CITY");
        objectLocationSearchData.region = UtilSql.getValue(result, "REGION");
        objectLocationSearchData.country = UtilSql.getValue(result, "COUNTRY");
        objectLocationSearchData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectLocationSearchData);
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
    LocationSearchData objectLocationSearchData[] = new LocationSearchData[vector.size()];
    vector.copyInto(objectLocationSearchData);
    return(objectLocationSearchData);
  }

  public static LocationSearchData[] set(String cCountryId)    throws ServletException {
    LocationSearchData objectLocationSearchData[] = new LocationSearchData[1];
    objectLocationSearchData[0] = new LocationSearchData();
    objectLocationSearchData[0].cLocationId = "";
    objectLocationSearchData[0].adClientId = "";
    objectLocationSearchData[0].adOrgId = "";
    objectLocationSearchData[0].createdby = "";
    objectLocationSearchData[0].updatedby = "";
    objectLocationSearchData[0].cCountryId = cCountryId;
    objectLocationSearchData[0].cRegionId = "";
    objectLocationSearchData[0].name = "";
    objectLocationSearchData[0].address1 = "";
    objectLocationSearchData[0].address2 = "";
    objectLocationSearchData[0].postal = "";
    objectLocationSearchData[0].city = "";
    objectLocationSearchData[0].region = "";
    objectLocationSearchData[0].country = "";
    return objectLocationSearchData;
  }

  public static String locationAddress(ConnectionProvider connectionProvider, String language, String cLocationId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT AD_COLUMN_IDENTIFIER(TO_CHAR('C_Location'), TO_CHAR(L.C_LOCATION_ID), ?) AS NAME " +
      "        FROM C_LOCATION L left join  C_REGION R on L.C_REGION_ID = R.C_REGION_ID, " +
      "             C_COUNTRY C" +
      "        WHERE L.C_COUNTRY_ID = C.C_COUNTRY_ID" +
      "        AND L.ISACTIVE = 'Y'" +
      "        AND L.C_LOCATION_ID = ?";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cLocationId);

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

  public int update(ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      UPDATE C_LOCATION SET UPDATED = now(), UPDATEDBY = ?, ADDRESS1 = ?, ADDRESS2 = ?, CITY = ?, POSTAL = ?, C_COUNTRY_ID = ?, C_REGION_ID = ?" +
      "      WHERE C_LOCATION_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, address1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, address2);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, city);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, postal);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCountryId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cRegionId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cLocationId);

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

  public int insert(ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      INSERT INTO C_LOCATION (C_LOCATION_ID, AD_CLIENT_ID, AD_ORG_ID, ISACTIVE, CREATED, CREATEDBY, UPDATED, UPDATEDBY, ADDRESS1, ADDRESS2, CITY, POSTAL, C_COUNTRY_ID, C_REGION_ID) VALUES (?, ?, ?, 'Y', now(), ?, now(), ?, ?, ?, ?, ?, ?, ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, createdby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, address1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, address2);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, city);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, postal);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCountryId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cRegionId);

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
Select Organization
 */
  public static String selectDefaultCountry(ConnectionProvider connectionProvider, String adOrgId, String adUserClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "    SELECT MIN(l.C_COUNTRY_ID) FROM AD_ORG o" +
      "                left join AD_ORGINFO oinf on oinf.AD_ORG_ID = o.AD_ORG_ID" +
      "                left join C_LOCATION l on oinf.C_LOCATION_ID = l.C_LOCATION_ID" +
      "    WHERE" +
      "     ? IN (o.AD_ORG_ID, '0')" +
      "    AND o.ISACTIVE = 'Y'                     " +
      "    AND o.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "MIN(L.C_COUNTRY_ID)");
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
