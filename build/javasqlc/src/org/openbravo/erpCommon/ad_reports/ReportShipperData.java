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

class ReportShipperData implements FieldProvider {
static Logger log4j = Logger.getLogger(ReportShipperData.class);
  private String InitRecordNumber="0";
  public String shipment;
  public String shipmentid;
  public String category;
  public String shipper;
  public String origin;
  public String destination;
  public String qty;
  public String freightamt;
  public String movementdate;
  public String line;
  public String qtyline;
  public String product;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("SHIPMENT"))
      return shipment;
    else if (fieldName.equalsIgnoreCase("SHIPMENTID"))
      return shipmentid;
    else if (fieldName.equalsIgnoreCase("CATEGORY"))
      return category;
    else if (fieldName.equalsIgnoreCase("SHIPPER"))
      return shipper;
    else if (fieldName.equalsIgnoreCase("ORIGIN"))
      return origin;
    else if (fieldName.equalsIgnoreCase("DESTINATION"))
      return destination;
    else if (fieldName.equalsIgnoreCase("QTY"))
      return qty;
    else if (fieldName.equalsIgnoreCase("FREIGHTAMT"))
      return freightamt;
    else if (fieldName.equalsIgnoreCase("MOVEMENTDATE"))
      return movementdate;
    else if (fieldName.equalsIgnoreCase("LINE"))
      return line;
    else if (fieldName.equalsIgnoreCase("QTYLINE"))
      return qtyline;
    else if (fieldName.equalsIgnoreCase("PRODUCT"))
      return product;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ReportShipperData[] select(ConnectionProvider connectionProvider, String language, String cCurrencyConv, String cCurrencyBase, String from, String to, String shipper, String issotrx)    throws ServletException {
    return select(connectionProvider, language, cCurrencyConv, cCurrencyBase, from, to, shipper, issotrx, 0, 0);
  }

  public static ReportShipperData[] select(ConnectionProvider connectionProvider, String language, String cCurrencyConv, String cCurrencyBase, String from, String to, String shipper, String issotrx, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT i.DOCUMENTNO AS SHIPMENT, i.M_Inout_id AS shipmentid, AD_COLUMN_IDENTIFIER('M_Freightcategory', to_char(i.M_FREIGHTCATEGORY_ID), ?) AS CATEGORY," +
      "        AD_COLUMN_IDENTIFIER('M_Shipper', to_char(i.M_SHIPPER_ID), ?) AS SHIPPER," +
      "        CASE i.IsSOTrx WHEN 'Y' THEN AD_COLUMN_IDENTIFIER('C_Region', to_char(wl.C_REGION_ID), ?)" +
      "                       WHEN 'N' THEN AD_COLUMN_IDENTIFIER('C_Region', to_char(COALESCE(dl.C_REGION_ID, l.C_REGION_ID)), ?) END AS ORIGIN, " +
      "        CASE i.IsSOTrx WHEN 'Y' THEN AD_COLUMN_IDENTIFIER('C_Region', to_char(COALESCE(dl.C_REGION_ID, l.C_REGION_ID)), ?) " +
      "                       WHEN 'N' THEN AD_COLUMN_IDENTIFIER('C_Region', to_char(wl.C_REGION_ID), ?) END AS DESTINATION," +
      "        i.NOPACKAGES AS QTY, " +
      "	    (CASE WHEN i.FREIGHT_CURRENCY_ID IS NOT NULL" +
      "	    	THEN C_CURRENCY_CONVERT(i.FREIGHTAMT, i.FREIGHT_CURRENCY_ID, ?, TO_DATE(i.MOVEMENTDATE), NULL, i.AD_CLIENT_ID, i.AD_ORG_ID)" +
      "	    	ELSE C_CURRENCY_CONVERT(i.FREIGHTAMT, ?, ?, TO_DATE(i.MOVEMENTDATE), NULL, i.AD_CLIENT_ID, i.AD_ORG_ID) END) AS FREIGHTAMT, " +
      "	    i.MOVEMENTDATE, '' AS line, '' AS qtyline, '' AS product" +
      "        FROM M_InOut i LEFT JOIN C_BPartner_Location dbl ON dbl.C_BPARTNER_LOCATION_ID = i.DELIVERY_LOCATION_ID" +
      "                       LEFT JOIN C_location dl ON dbl.C_LOCATION_ID = dl.C_LOCATION_ID," +
      "        C_BPartner_Location bl, C_location l, M_Warehouse w, C_Location wl" +
      "      WHERE i.C_BPARTNER_LOCATION_ID = bl.C_BPARTNER_LOCATION_ID" +
      "        AND bl.C_LOCATION_ID = l.C_LOCATION_ID" +
      "        AND i.M_WAREHOUSE_ID = w.M_WAREHOUSE_ID" +
      "        AND w.C_LOCATION_ID = wl.C_LOCATION_ID " +
      "        AND i.FREIGHTCOSTRULE = 'C'" +
      "        AND i.M_FREIGHTCATEGORY_ID IS NOT NULL" +
      "        AND i.MOVEMENTDATE >= TO_DATE(?)" +
      "        AND i.MOVEMENTDATE < TO_DATE(?) +1" +
      "        AND 1=1";
    strSql = strSql + ((shipper==null || shipper.equals(""))?"":"  AND i.M_SHIPPER_ID = ?  ");
    strSql = strSql + ((issotrx==null || issotrx.equals(""))?"":"  AND i.IsSOTrx = ?  ");
    strSql = strSql + 
      "      ORDER BY SHIPPER, MOVEMENTDATE";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyBase);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, from);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, to);
      if (shipper != null && !(shipper.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, shipper);
      }
      if (issotrx != null && !(issotrx.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, issotrx);
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
        ReportShipperData objectReportShipperData = new ReportShipperData();
        objectReportShipperData.shipment = UtilSql.getValue(result, "SHIPMENT");
        objectReportShipperData.shipmentid = UtilSql.getValue(result, "SHIPMENTID");
        objectReportShipperData.category = UtilSql.getValue(result, "CATEGORY");
        objectReportShipperData.shipper = UtilSql.getValue(result, "SHIPPER");
        objectReportShipperData.origin = UtilSql.getValue(result, "ORIGIN");
        objectReportShipperData.destination = UtilSql.getValue(result, "DESTINATION");
        objectReportShipperData.qty = UtilSql.getValue(result, "QTY");
        objectReportShipperData.freightamt = UtilSql.getValue(result, "FREIGHTAMT");
        objectReportShipperData.movementdate = UtilSql.getDateValue(result, "MOVEMENTDATE", "dd-MM-yyyy");
        objectReportShipperData.line = UtilSql.getValue(result, "LINE");
        objectReportShipperData.qtyline = UtilSql.getValue(result, "QTYLINE");
        objectReportShipperData.product = UtilSql.getValue(result, "PRODUCT");
        objectReportShipperData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportShipperData);
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
    ReportShipperData objectReportShipperData[] = new ReportShipperData[vector.size()];
    vector.copyInto(objectReportShipperData);
    return(objectReportShipperData);
  }

  public static ReportShipperData[] selectLine(ConnectionProvider connectionProvider, String language, String shipment)    throws ServletException {
    return selectLine(connectionProvider, language, shipment, 0, 0);
  }

  public static ReportShipperData[] selectLine(ConnectionProvider connectionProvider, String language, String shipment, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT AD_COLUMN_IDENTIFIER('M_Product', to_char(il.M_PRODUCT_ID), ?) AS PRODUCT, il.LINE, " +
      "        CASE f.LINE_ROUND WHEN 'N' THEN CASE f.FREIGHT_UNIT WHEN 'P' THEN il.MOVEMENTQTY/p.UNITSPERPALLET WHEN 'U' THEN il.MOVEMENTQTY END " +
      "                          WHEN 'I' THEN trunc(CASE f.FREIGHT_UNIT WHEN 'P' THEN il.MOVEMENTQTY/p.UNITSPERPALLET WHEN 'U' THEN il.MOVEMENTQTY END)" +
      "                          WHEN 'U' THEN CEIL(CASE f.FREIGHT_UNIT WHEN 'P' THEN il.MOVEMENTQTY/p.UNITSPERPALLET WHEN 'U' THEN il.MOVEMENTQTY END)" +
      "                          WHEN 'R' THEN ROUND(CASE f.FREIGHT_UNIT WHEN 'P' THEN il.MOVEMENTQTY/p.UNITSPERPALLET WHEN 'U' THEN il.MOVEMENTQTY END)" +
      "        END AS qtyline" +
      "      FROM M_InOut i, M_InoutLine il, M_Product p, M_FreightCategory f" +
      "      WHERE i.M_InOut_ID = il.M_InOut_ID" +
      "        AND i.M_Inout_ID = ?" +
      "        AND il.M_PRODUCT_ID = p.M_PRODUCT_ID" +
      "        AND i.M_FREIGHTCATEGORY_ID = f.M_FREIGHTCATEGORY_ID" +
      "      ORDER BY line";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, shipment);

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
        ReportShipperData objectReportShipperData = new ReportShipperData();
        objectReportShipperData.product = UtilSql.getValue(result, "PRODUCT");
        objectReportShipperData.line = UtilSql.getValue(result, "LINE");
        objectReportShipperData.qtyline = UtilSql.getValue(result, "QTYLINE");
        objectReportShipperData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportShipperData);
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
    ReportShipperData objectReportShipperData[] = new ReportShipperData[vector.size()];
    vector.copyInto(objectReportShipperData);
    return(objectReportShipperData);
  }
}
