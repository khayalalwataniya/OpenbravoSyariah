//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.ad_actionButton;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

class CopyFromPOOrderData implements FieldProvider {
static Logger log4j = Logger.getLogger(CopyFromPOOrderData.class);
  private String InitRecordNumber="0";
  public String cBpartnerId;
  public String cBpartnerLocationId;
  public String mWarehouseId;
  public String cCurrencyId;
  public String cProjectId;
  public String mPricelistId;
  public String line;
  public String adOrgId;
  public String adClientId;
  public String cUomId;
  public String mProductId;
  public String qtyordered;
  public String quantityorder;
  public String mProductUomId;
  public String stdprecision;
  public String priceprecision;
  public String enforcepricelimit;
  public String pricelist;
  public String pricelimit;
  public String validfrom;
  public String description;
  public String pricestd;
  public String mOfferId;
  public String orderline;
  public String datepromised;
  public String dateordered;
  public String issotrx;
  public String mAttributesetinstanceId;
  public String user1Id;
  public String user2Id;
  public String cCostcenterId;
  public String aAssetId;
  public String explode;
  public String bomParentId;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("C_BPARTNER_ID") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
    else if (fieldName.equalsIgnoreCase("C_BPARTNER_LOCATION_ID") || fieldName.equals("cBpartnerLocationId"))
      return cBpartnerLocationId;
    else if (fieldName.equalsIgnoreCase("M_WAREHOUSE_ID") || fieldName.equals("mWarehouseId"))
      return mWarehouseId;
    else if (fieldName.equalsIgnoreCase("C_CURRENCY_ID") || fieldName.equals("cCurrencyId"))
      return cCurrencyId;
    else if (fieldName.equalsIgnoreCase("C_PROJECT_ID") || fieldName.equals("cProjectId"))
      return cProjectId;
    else if (fieldName.equalsIgnoreCase("M_PRICELIST_ID") || fieldName.equals("mPricelistId"))
      return mPricelistId;
    else if (fieldName.equalsIgnoreCase("LINE"))
      return line;
    else if (fieldName.equalsIgnoreCase("AD_ORG_ID") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("AD_CLIENT_ID") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("C_UOM_ID") || fieldName.equals("cUomId"))
      return cUomId;
    else if (fieldName.equalsIgnoreCase("M_PRODUCT_ID") || fieldName.equals("mProductId"))
      return mProductId;
    else if (fieldName.equalsIgnoreCase("QTYORDERED"))
      return qtyordered;
    else if (fieldName.equalsIgnoreCase("QUANTITYORDER"))
      return quantityorder;
    else if (fieldName.equalsIgnoreCase("M_PRODUCT_UOM_ID") || fieldName.equals("mProductUomId"))
      return mProductUomId;
    else if (fieldName.equalsIgnoreCase("STDPRECISION"))
      return stdprecision;
    else if (fieldName.equalsIgnoreCase("PRICEPRECISION"))
      return priceprecision;
    else if (fieldName.equalsIgnoreCase("ENFORCEPRICELIMIT"))
      return enforcepricelimit;
    else if (fieldName.equalsIgnoreCase("PRICELIST"))
      return pricelist;
    else if (fieldName.equalsIgnoreCase("PRICELIMIT"))
      return pricelimit;
    else if (fieldName.equalsIgnoreCase("VALIDFROM"))
      return validfrom;
    else if (fieldName.equalsIgnoreCase("DESCRIPTION"))
      return description;
    else if (fieldName.equalsIgnoreCase("PRICESTD"))
      return pricestd;
    else if (fieldName.equalsIgnoreCase("M_OFFER_ID") || fieldName.equals("mOfferId"))
      return mOfferId;
    else if (fieldName.equalsIgnoreCase("ORDERLINE"))
      return orderline;
    else if (fieldName.equalsIgnoreCase("DATEPROMISED"))
      return datepromised;
    else if (fieldName.equalsIgnoreCase("DATEORDERED"))
      return dateordered;
    else if (fieldName.equalsIgnoreCase("ISSOTRX"))
      return issotrx;
    else if (fieldName.equalsIgnoreCase("M_ATTRIBUTESETINSTANCE_ID") || fieldName.equals("mAttributesetinstanceId"))
      return mAttributesetinstanceId;
    else if (fieldName.equalsIgnoreCase("USER1_ID") || fieldName.equals("user1Id"))
      return user1Id;
    else if (fieldName.equalsIgnoreCase("USER2_ID") || fieldName.equals("user2Id"))
      return user2Id;
    else if (fieldName.equalsIgnoreCase("C_COSTCENTER_ID") || fieldName.equals("cCostcenterId"))
      return cCostcenterId;
    else if (fieldName.equalsIgnoreCase("A_ASSET_ID") || fieldName.equals("aAssetId"))
      return aAssetId;
    else if (fieldName.equalsIgnoreCase("EXPLODE"))
      return explode;
    else if (fieldName.equalsIgnoreCase("BOM_PARENT_ID") || fieldName.equals("bomParentId"))
      return bomParentId;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

/**
Principal select
 */
  public static CopyFromPOOrderData[] select(ConnectionProvider connectionProvider, String cOrderId)    throws ServletException {
    return select(connectionProvider, cOrderId, 0, 0);
  }

/**
Principal select
 */
  public static CopyFromPOOrderData[] select(ConnectionProvider connectionProvider, String cOrderId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT O.C_BPARTNER_ID, O.C_BPARTNER_LOCATION_ID, O.M_WAREHOUSE_ID, O.C_CURRENCY_ID, O.C_PROJECT_ID," +
      "        O.M_PRICELIST_ID, COALESCE(MAX(OL.LINE),0) AS LINE, O.AD_ORG_ID, O.AD_CLIENT_ID, '' AS C_UOM_ID, '' AS M_PRODUCT_ID," +
      "        '' AS QTYORDERED, '' AS QUANTITYORDER, '' AS M_PRODUCT_UOM_ID," +
      "        '' as stdprecision, '' as priceprecision, '' as enforcepricelimit, '' as pricelist, '' as pricelimit, '' as validfrom," +
      "        '' AS DESCRIPTION, '' AS PRICESTD, '' AS M_OFFER_ID, '' as orderline, O.DATEPROMISED AS DATEPROMISED, O.DATEORDERED AS DATEORDERED," +
      "        O.ISSOTRX AS ISSOTRX, '' AS M_ATTRIBUTESETINSTANCE_ID, '' as USER1_ID, '' as USER2_ID," +
      "        '' as C_COSTCENTER_ID, '' as A_ASSET_ID, '' AS EXPLODE, '' AS BOM_PARENT_ID" +
      "        FROM C_ORDER O LEFT JOIN C_ORDERLINE OL ON O.C_ORDER_ID = OL.C_ORDER_ID" +
      "        WHERE O.C_ORDER_ID = ?" +
      "        GROUP BY O.C_BPARTNER_ID, O.C_BPARTNER_LOCATION_ID, O.M_WAREHOUSE_ID, O.C_CURRENCY_ID, O.C_PROJECT_ID," +
      "        O.M_PRICELIST_ID, O.AD_ORG_ID, O.AD_CLIENT_ID, O.DATEPROMISED, O.DATEORDERED, O.ISSOTRX";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderId);

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
        CopyFromPOOrderData objectCopyFromPOOrderData = new CopyFromPOOrderData();
        objectCopyFromPOOrderData.cBpartnerId = UtilSql.getValue(result, "C_BPARTNER_ID");
        objectCopyFromPOOrderData.cBpartnerLocationId = UtilSql.getValue(result, "C_BPARTNER_LOCATION_ID");
        objectCopyFromPOOrderData.mWarehouseId = UtilSql.getValue(result, "M_WAREHOUSE_ID");
        objectCopyFromPOOrderData.cCurrencyId = UtilSql.getValue(result, "C_CURRENCY_ID");
        objectCopyFromPOOrderData.cProjectId = UtilSql.getValue(result, "C_PROJECT_ID");
        objectCopyFromPOOrderData.mPricelistId = UtilSql.getValue(result, "M_PRICELIST_ID");
        objectCopyFromPOOrderData.line = UtilSql.getValue(result, "LINE");
        objectCopyFromPOOrderData.adOrgId = UtilSql.getValue(result, "AD_ORG_ID");
        objectCopyFromPOOrderData.adClientId = UtilSql.getValue(result, "AD_CLIENT_ID");
        objectCopyFromPOOrderData.cUomId = UtilSql.getValue(result, "C_UOM_ID");
        objectCopyFromPOOrderData.mProductId = UtilSql.getValue(result, "M_PRODUCT_ID");
        objectCopyFromPOOrderData.qtyordered = UtilSql.getValue(result, "QTYORDERED");
        objectCopyFromPOOrderData.quantityorder = UtilSql.getValue(result, "QUANTITYORDER");
        objectCopyFromPOOrderData.mProductUomId = UtilSql.getValue(result, "M_PRODUCT_UOM_ID");
        objectCopyFromPOOrderData.stdprecision = UtilSql.getValue(result, "STDPRECISION");
        objectCopyFromPOOrderData.priceprecision = UtilSql.getValue(result, "PRICEPRECISION");
        objectCopyFromPOOrderData.enforcepricelimit = UtilSql.getValue(result, "ENFORCEPRICELIMIT");
        objectCopyFromPOOrderData.pricelist = UtilSql.getValue(result, "PRICELIST");
        objectCopyFromPOOrderData.pricelimit = UtilSql.getValue(result, "PRICELIMIT");
        objectCopyFromPOOrderData.validfrom = UtilSql.getValue(result, "VALIDFROM");
        objectCopyFromPOOrderData.description = UtilSql.getValue(result, "DESCRIPTION");
        objectCopyFromPOOrderData.pricestd = UtilSql.getValue(result, "PRICESTD");
        objectCopyFromPOOrderData.mOfferId = UtilSql.getValue(result, "M_OFFER_ID");
        objectCopyFromPOOrderData.orderline = UtilSql.getValue(result, "ORDERLINE");
        objectCopyFromPOOrderData.datepromised = UtilSql.getDateValue(result, "DATEPROMISED", "dd-MM-yyyy");
        objectCopyFromPOOrderData.dateordered = UtilSql.getDateValue(result, "DATEORDERED", "dd-MM-yyyy");
        objectCopyFromPOOrderData.issotrx = UtilSql.getValue(result, "ISSOTRX");
        objectCopyFromPOOrderData.mAttributesetinstanceId = UtilSql.getValue(result, "M_ATTRIBUTESETINSTANCE_ID");
        objectCopyFromPOOrderData.user1Id = UtilSql.getValue(result, "USER1_ID");
        objectCopyFromPOOrderData.user2Id = UtilSql.getValue(result, "USER2_ID");
        objectCopyFromPOOrderData.cCostcenterId = UtilSql.getValue(result, "C_COSTCENTER_ID");
        objectCopyFromPOOrderData.aAssetId = UtilSql.getValue(result, "A_ASSET_ID");
        objectCopyFromPOOrderData.explode = UtilSql.getValue(result, "EXPLODE");
        objectCopyFromPOOrderData.bomParentId = UtilSql.getValue(result, "BOM_PARENT_ID");
        objectCopyFromPOOrderData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCopyFromPOOrderData);
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
    CopyFromPOOrderData objectCopyFromPOOrderData[] = new CopyFromPOOrderData[vector.size()];
    vector.copyInto(objectCopyFromPOOrderData);
    return(objectCopyFromPOOrderData);
  }

/**
select de las lineas
 */
  public static CopyFromPOOrderData[] selectLines(ConnectionProvider connectionProvider, String cOrderLineId)    throws ServletException {
    return selectLines(connectionProvider, cOrderLineId, 0, 0);
  }

/**
select de las lineas
 */
  public static CopyFromPOOrderData[] selectLines(ConnectionProvider connectionProvider, String cOrderLineId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT OL.C_ORDERLINE_ID as orderline, OL.C_UOM_ID, OL.M_PRODUCT_ID, OL.QTYORDERED, OL.QUANTITYORDER," +
      "        OL.M_PRODUCT_UOM_ID, OL.DESCRIPTION, OL.C_CURRENCY_ID, OL.M_ATTRIBUTESETINSTANCE_ID," +
      "        OL.AD_ORG_ID," +
      "        COALESCE(OL.C_PROJECT_ID, O.C_PROJECT_ID) AS C_PROJECT_ID," +
      "        COALESCE(OL.USER1_ID, O.USER1_ID) AS USER1_ID," +
      "        COALESCE(OL.USER2_ID, O.USER2_ID) AS USER2_ID," +
      "        COALESCE(OL.C_COSTCENTER_ID, O.C_COSTCENTER_ID) AS C_COSTCENTER_ID," +
      "        COALESCE(OL.A_ASSET_ID, O.A_ASSET_ID) AS A_ASSET_ID, OL.EXPLODE, OL.BOM_PARENT_ID" +
      "        FROM C_ORDERLINE OL, C_ORDER O" +
      "        WHERE OL.C_ORDER_ID = ?" +
      "              AND OL.C_ORDER_ID = O.C_ORDER_ID" +
      "        ORDER BY OL.LINE ASC";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderLineId);

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
        CopyFromPOOrderData objectCopyFromPOOrderData = new CopyFromPOOrderData();
        objectCopyFromPOOrderData.orderline = UtilSql.getValue(result, "ORDERLINE");
        objectCopyFromPOOrderData.cUomId = UtilSql.getValue(result, "C_UOM_ID");
        objectCopyFromPOOrderData.mProductId = UtilSql.getValue(result, "M_PRODUCT_ID");
        objectCopyFromPOOrderData.qtyordered = UtilSql.getValue(result, "QTYORDERED");
        objectCopyFromPOOrderData.quantityorder = UtilSql.getValue(result, "QUANTITYORDER");
        objectCopyFromPOOrderData.mProductUomId = UtilSql.getValue(result, "M_PRODUCT_UOM_ID");
        objectCopyFromPOOrderData.description = UtilSql.getValue(result, "DESCRIPTION");
        objectCopyFromPOOrderData.cCurrencyId = UtilSql.getValue(result, "C_CURRENCY_ID");
        objectCopyFromPOOrderData.mAttributesetinstanceId = UtilSql.getValue(result, "M_ATTRIBUTESETINSTANCE_ID");
        objectCopyFromPOOrderData.adOrgId = UtilSql.getValue(result, "AD_ORG_ID");
        objectCopyFromPOOrderData.cProjectId = UtilSql.getValue(result, "C_PROJECT_ID");
        objectCopyFromPOOrderData.user1Id = UtilSql.getValue(result, "USER1_ID");
        objectCopyFromPOOrderData.user2Id = UtilSql.getValue(result, "USER2_ID");
        objectCopyFromPOOrderData.cCostcenterId = UtilSql.getValue(result, "C_COSTCENTER_ID");
        objectCopyFromPOOrderData.aAssetId = UtilSql.getValue(result, "A_ASSET_ID");
        objectCopyFromPOOrderData.explode = UtilSql.getValue(result, "EXPLODE");
        objectCopyFromPOOrderData.bomParentId = UtilSql.getValue(result, "BOM_PARENT_ID");
        objectCopyFromPOOrderData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCopyFromPOOrderData);
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
    CopyFromPOOrderData objectCopyFromPOOrderData[] = new CopyFromPOOrderData[vector.size()];
    vector.copyInto(objectCopyFromPOOrderData);
    return(objectCopyFromPOOrderData);
  }

/**
Principal select
 */
  public static int insertCOrderline(Connection conn, ConnectionProvider connectionProvider, String cOrderlineId, String adClientId, String adOrgId, String user, String cOrderId, String line, String cBpartnerId, String cBpartnerLocationId, String dateordered, String datepromised, String description, String mProductId, String mWarehouseId, String cUomId, String qtyordered, String quantityorder, String cCurrencyId, String pricelist, String priceactual, String pricelimit, String cTaxId, String discount, String mProductUomId, String refOrdeline, String mAttributeSetInstanceId, String grosslistprice, String grossprice, String grossAmount, String grossBaseUnitPrice, String cProjectId, String user1Id, String user2Id, String cCostcenterId, String aAssetId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        INSERT INTO C_ORDERLINE " +
      "          (C_ORDERLINE_ID, AD_CLIENT_ID, AD_ORG_ID, CREATED, CREATEDBY, UPDATED, UPDATEDBY," +
      "        C_ORDER_ID, LINE, C_BPARTNER_ID, C_BPARTNER_LOCATION_ID, " +
      "        DATEORDERED, DATEPROMISED, DESCRIPTION, M_PRODUCT_ID, " +
      "        M_WAREHOUSE_ID, C_UOM_ID, QTYORDERED, QUANTITYORDER, QTYINVOICED, QTYDELIVERED, QTYRESERVED, " +
      "        C_CURRENCY_ID, PRICELIST, PRICEACTUAL, " +
      "        PRICELIMIT, C_TAX_ID, DISCOUNT, M_PRODUCT_UOM_ID, PRICESTD, M_OFFER_ID, REF_ORDERLINE_ID, M_ATTRIBUTESETINSTANCE_ID," +
      "          GROSSPRICELIST, GROSS_UNIT_PRICE, LINE_GROSS_AMOUNT, grosspricestd," +
      "          C_PROJECT_ID, USER1_ID, USER2_ID, C_COSTCENTER_ID, A_ASSET_ID) " +
      "        VALUES " +
      "          (?,?,?,TO_DATE(NOW()),?,TO_DATE(NOW()),?," +
      "           ?,TO_NUMBER(?),?,?," +
      "           TO_DATE(?),TO_DATE(?),?,?," +
      "           ?,?,TO_NUMBER(?),TO_NUMBER(?),0,0,0," +
      "           ?,TO_NUMBER(?),M_GET_OFFERS_PRICE(TO_DATE(now()), ?, ?, TO_NUMBER(?), TO_NUMBER(?), ?)," +
      "           TO_NUMBER(?),?,TO_NUMBER(?),?,TO_NUMBER(?),M_GET_OFFER(TO_DATE(now()), ?, ?),?,?," +
      "           TO_NUMBER(?),TO_NUMBER(?),TO_NUMBER(?), TO_NUMBER(?)," +
      "           ?, ?, ?, ?, ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, line);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateordered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datepromised);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mWarehouseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cUomId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyordered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, quantityorder);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pricelist);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, priceactual);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyordered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pricelist);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pricelimit);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cTaxId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, discount);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductUomId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, priceactual);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, refOrdeline);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mAttributeSetInstanceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, grosslistprice);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, grossprice);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, grossAmount);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, grossBaseUnitPrice);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user1Id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user2Id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCostcenterId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aAssetId);

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

/**
Names of the columns of the fields of a tab
 */
  public static String cBPartnerLocationId(ConnectionProvider connectionProvider, String cBpartnerId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT MAX(C_BPARTNER_LOCATION_ID) AS C_BPARTNER_LOCATION_ID " +
      "        FROM C_BPARTNER_LOCATION" +
      "        WHERE C_BPARTNER_ID = ?" +
      "        AND C_BPartner_Location.IsActive='Y'";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "C_BPARTNER_LOCATION_ID");
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
priceList por defecto
 */
  public static String defaultPriceList(ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT M_PRICELIST_ID FROM M_PRICELIST" +
      "        WHERE ISDEFAULT = 'Y'" +
      "        AND ISSOPRICELIST = 'N'";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "M_PRICELIST_ID");
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

  public static CopyFromPOOrderData[] selectPriceForProduct(ConnectionProvider connectionProvider, String MProductID, String MPriceListID)    throws ServletException {
    return selectPriceForProduct(connectionProvider, MProductID, MPriceListID, 0, 0);
  }

  public static CopyFromPOOrderData[] selectPriceForProduct(ConnectionProvider connectionProvider, String MProductID, String MPriceListID, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT M_BOM_PriceStd(p.M_Product_ID,pv.M_PriceList_Version_ID) AS PriceStd," +
      "        M_BOM_PriceList(p.M_Product_ID,pv.M_PriceList_Version_ID) AS PriceList," +
      "        M_BOM_PriceLimit(p.M_Product_ID,pv.M_PriceList_Version_ID) AS PriceLimit," +
      "        p.C_UOM_ID,pv.ValidFrom,pl.C_Currency_ID " +
      "        FROM M_Product p, M_ProductPrice pp, M_Pricelist pl, M_PriceList_Version pv " +
      "        WHERE p.M_Product_ID=pp.M_Product_ID" +
      "        AND pp.M_PriceList_Version_ID=pv.M_PriceList_Version_ID" +
      "        AND pv.M_PriceList_ID=pl.M_PriceList_ID" +
      "        AND pv.IsActive='Y'" +
      "        AND p.M_Product_ID = ?" +
      "        AND pl.M_PriceList_ID = ?" +
      "        ORDER BY pv.ValidFrom DESC";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, MProductID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, MPriceListID);

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
        CopyFromPOOrderData objectCopyFromPOOrderData = new CopyFromPOOrderData();
        objectCopyFromPOOrderData.pricestd = UtilSql.getValue(result, "PRICESTD");
        objectCopyFromPOOrderData.pricelist = UtilSql.getValue(result, "PRICELIST");
        objectCopyFromPOOrderData.pricelimit = UtilSql.getValue(result, "PRICELIMIT");
        objectCopyFromPOOrderData.cUomId = UtilSql.getValue(result, "C_UOM_ID");
        objectCopyFromPOOrderData.validfrom = UtilSql.getDateValue(result, "VALIDFROM", "dd-MM-yyyy");
        objectCopyFromPOOrderData.cCurrencyId = UtilSql.getValue(result, "C_CURRENCY_ID");
        objectCopyFromPOOrderData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCopyFromPOOrderData);
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
    CopyFromPOOrderData objectCopyFromPOOrderData[] = new CopyFromPOOrderData[vector.size()];
    vector.copyInto(objectCopyFromPOOrderData);
    return(objectCopyFromPOOrderData);
  }

  public static int copyAttributes(Connection conn, ConnectionProvider connectionProvider, String mAttributesetinstanceIdNew, String createdBy, String updatedBy, String mAttributesetinstanceIdOld)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "     INSERT INTO M_ATTRIBUTESETINSTANCE " +
      "       (M_ATTRIBUTESETINSTANCE_ID, AD_CLIENT_ID, AD_ORG_ID, ISACTIVE," +
      "       CREATED, CREATEDBY, UPDATED, UPDATEDBY, M_ATTRIBUTESET_ID, SERNO, " +
      "       LOT, GUARANTEEDATE, DESCRIPTION, M_LOT_ID, ISLOCKED, LOCK_DESCRIPTION) " +
      "     SELECT ?, AD_CLIENT_ID, AD_ORG_ID, ISACTIVE, NOW(), ?, NOW(), " +
      "       ?, M_ATTRIBUTESET_ID, SERNO, LOT, GUARANTEEDATE, DESCRIPTION, " +
      "       M_LOT_ID, ISLOCKED, LOCK_DESCRIPTION FROM M_ATTRIBUTESETINSTANCE " +
      "       WHERE M_ATTRIBUTESETINSTANCE_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mAttributesetinstanceIdNew);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, createdBy);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedBy);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mAttributesetinstanceIdOld);

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

  public static int copyInstances(Connection conn, ConnectionProvider connectionProvider, String mAttributesetinstanceIdNew, String createdBy, String updatedBy, String mAttributesetinstanceIdOld)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "     INSERT INTO M_ATTRIBUTEINSTANCE" +
      "       (M_ATTRIBUTEINSTANCE_ID, M_ATTRIBUTESETINSTANCE_ID, M_ATTRIBUTE_ID," +
      "       AD_CLIENT_ID, AD_ORG_ID, ISACTIVE, CREATED, CREATEDBY, UPDATED, UPDATEDBY," +
      "       M_ATTRIBUTEVALUE_ID, VALUE)" +
      "     SELECT GET_UUID(), ?, M_ATTRIBUTE_ID, AD_CLIENT_ID, AD_ORG_ID, ISACTIVE, " +
      "       NOW(), ?, NOW(), ?, M_ATTRIBUTEVALUE_ID, VALUE FROM " +
      "       M_ATTRIBUTEINSTANCE WHERE M_ATTRIBUTESETINSTANCE_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mAttributesetinstanceIdNew);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, createdBy);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedBy);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mAttributesetinstanceIdOld);

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

  public static String getIsInstanceValue(Connection conn, ConnectionProvider connectionProvider, String mAttributesetinstanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "		SELECT CASE WHEN M_ATTRIBUTESET.ISLOT = 'Y'" +
      "		    OR M_ATTRIBUTESET.ISSERNO = 'Y'" +
      "		    OR M_ATTRIBUTESET.ISGUARANTEEDATE = 'Y'" +
      "		    OR (SELECT COUNT(*) FROM M_ATTRIBUTE, M_ATTRIBUTEINSTANCE" +
      "		          WHERE M_ATTRIBUTEINSTANCE.M_ATTRIBUTE_ID = M_ATTRIBUTE.M_ATTRIBUTE_ID" +
      "		          AND M_ATTRIBUTE.ISINSTANCEATTRIBUTE='Y'" +
      "		          AND M_ATTRIBUTEINSTANCE.M_ATTRIBUTESETINSTANCE_ID = ?) > 0" +
      "		    THEN 'Y' ELSE 'N' END AS ISINSTANCEATTRIBUTE" +
      "		FROM M_ATTRIBUTESETINSTANCE, M_ATTRIBUTESET" +
      "		WHERE M_ATTRIBUTESETINSTANCE.M_ATTRIBUTESET_ID = M_ATTRIBUTESET.M_ATTRIBUTESET_ID" +
      "		AND  M_ATTRIBUTESETINSTANCE.M_ATTRIBUTESETINSTANCE_ID = ?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mAttributesetinstanceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mAttributesetinstanceId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "ISINSTANCEATTRIBUTE");
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
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(strReturn);
  }
}
