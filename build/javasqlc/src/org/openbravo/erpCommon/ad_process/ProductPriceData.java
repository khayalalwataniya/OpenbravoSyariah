//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.ad_process;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

class ProductPriceData implements FieldProvider {
static Logger log4j = Logger.getLogger(ProductPriceData.class);
  private String InitRecordNumber="0";
  public String mProductId;
  public String mPricelistVersionId;
  public String mPricelistId;
  public String pricelist;
  public String pricestd;
  public String pricelimit;
  public String cUomId;
  public String validfrom;
  public String cCurrencyId;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("M_PRODUCT_ID") || fieldName.equals("mProductId"))
      return mProductId;
    else if (fieldName.equalsIgnoreCase("M_PRICELIST_VERSION_ID") || fieldName.equals("mPricelistVersionId"))
      return mPricelistVersionId;
    else if (fieldName.equalsIgnoreCase("M_PRICELIST_ID") || fieldName.equals("mPricelistId"))
      return mPricelistId;
    else if (fieldName.equalsIgnoreCase("PRICELIST"))
      return pricelist;
    else if (fieldName.equalsIgnoreCase("PRICESTD"))
      return pricestd;
    else if (fieldName.equalsIgnoreCase("PRICELIMIT"))
      return pricelimit;
    else if (fieldName.equalsIgnoreCase("C_UOM_ID") || fieldName.equals("cUomId"))
      return cUomId;
    else if (fieldName.equalsIgnoreCase("VALIDFROM"))
      return validfrom;
    else if (fieldName.equalsIgnoreCase("C_CURRENCY_ID") || fieldName.equals("cCurrencyId"))
      return cCurrencyId;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ProductPriceData[] select(ConnectionProvider connectionProvider, String mProductId, String mPricelistVersionId)    throws ServletException {
    return select(connectionProvider, mProductId, mPricelistVersionId, 0, 0);
  }

  public static ProductPriceData[] select(ConnectionProvider connectionProvider, String mProductId, String mPricelistVersionId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "				SELECT pp.M_Product_ID, pv.M_PriceList_Version_ID, pv.M_PriceList_ID, pp.PriceList, pp.PriceStd, pp.PriceLimit, p.C_UOM_ID," +
      "				pv.ValidFrom, pl.C_Currency_ID" +
      "				FROM M_Product p" +
      "				INNER JOIN M_ProductPrice pp ON (p.M_Product_ID=pp.M_Product_ID)" +
      "				INNER JOIN  M_PriceList_Version pv ON (pp.M_PriceList_Version_ID=pv.M_PriceList_Version_ID)" +
      "				INNER JOIN M_Pricelist pl ON (pv.M_PriceList_ID=pl.M_PriceList_ID)" +
      "				WHERE pv.IsActive='Y'" +
      "				AND p.M_Product_ID=?" +
      "				AND pv.M_PriceList_Version_ID=?";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mPricelistVersionId);

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
        ProductPriceData objectProductPriceData = new ProductPriceData();
        objectProductPriceData.mProductId = UtilSql.getValue(result, "M_PRODUCT_ID");
        objectProductPriceData.mPricelistVersionId = UtilSql.getValue(result, "M_PRICELIST_VERSION_ID");
        objectProductPriceData.mPricelistId = UtilSql.getValue(result, "M_PRICELIST_ID");
        objectProductPriceData.pricelist = UtilSql.getValue(result, "PRICELIST");
        objectProductPriceData.pricestd = UtilSql.getValue(result, "PRICESTD");
        objectProductPriceData.pricelimit = UtilSql.getValue(result, "PRICELIMIT");
        objectProductPriceData.cUomId = UtilSql.getValue(result, "C_UOM_ID");
        objectProductPriceData.validfrom = UtilSql.getDateValue(result, "VALIDFROM", "dd-MM-yyyy");
        objectProductPriceData.cCurrencyId = UtilSql.getValue(result, "C_CURRENCY_ID");
        objectProductPriceData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectProductPriceData);
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
    ProductPriceData objectProductPriceData[] = new ProductPriceData[vector.size()];
    vector.copyInto(objectProductPriceData);
    return(objectProductPriceData);
  }

  public static ProductPriceData[] selectPL(ConnectionProvider connectionProvider, String mProductId, String mPricelistId)    throws ServletException {
    return selectPL(connectionProvider, mProductId, mPricelistId, 0, 0);
  }

  public static ProductPriceData[] selectPL(ConnectionProvider connectionProvider, String mProductId, String mPricelistId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "				SELECT M_BOM_PriceStd(p.M_Product_ID,pv.M_PriceList_Version_ID) AS PriceStd," +
      "				M_BOM_PriceList(p.M_Product_ID,pv.M_PriceList_Version_ID) AS PriceList," +
      "				M_BOM_PriceLimit(p.M_Product_ID,pv.M_PriceList_Version_ID) AS PriceLimit," +
      "				p.C_UOM_ID,pv.ValidFrom,pl.C_Currency_ID" +
      "				FROM M_Product p" +
      "				INNER JOIN M_ProductPrice pp ON (p.M_Product_ID=pp.M_Product_ID)" +
      "				INNER JOIN  M_PriceList_Version pv ON (pp.M_PriceList_Version_ID=pv.M_PriceList_Version_ID)" +
      "				INNER JOIN M_Pricelist pl ON (pv.M_PriceList_ID=pl.M_PriceList_ID)" +
      "				WHERE pv.IsActive='Y'" +
      "				AND p.M_Product_ID=?" +
      "				AND pv.M_PriceList_ID=?" +
      "				ORDER BY pv.ValidFrom DESC";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mPricelistId);

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
        ProductPriceData objectProductPriceData = new ProductPriceData();
        objectProductPriceData.pricestd = UtilSql.getValue(result, "PRICESTD");
        objectProductPriceData.pricelist = UtilSql.getValue(result, "PRICELIST");
        objectProductPriceData.pricelimit = UtilSql.getValue(result, "PRICELIMIT");
        objectProductPriceData.cUomId = UtilSql.getValue(result, "C_UOM_ID");
        objectProductPriceData.validfrom = UtilSql.getDateValue(result, "VALIDFROM", "dd-MM-yyyy");
        objectProductPriceData.cCurrencyId = UtilSql.getValue(result, "C_CURRENCY_ID");
        objectProductPriceData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectProductPriceData);
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
    ProductPriceData objectProductPriceData[] = new ProductPriceData[vector.size()];
    vector.copyInto(objectProductPriceData);
    return(objectProductPriceData);
  }

  public static String selectCTaxId(ConnectionProvider connectionProvider, String adClientId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "				select max(c_tax_id)" +
      "				from c_tax" +
      "				where ad_client_id = ?" +
      "				and isdefault = 'Y'";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "MAX(C_TAX_ID)");
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

  public static String selectCUomIdDefault(ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "				select max(c_uom_id)" +
      "				from c_uom" +
      "				where isdefault='Y'";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "MAX(C_UOM_ID)");
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

  public static String selectCUomIdByProduct(ConnectionProvider connectionProvider, String mProductId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "				SELECT C_UOM_ID" +
      "				FROM M_Product" +
      "				WHERE M_Product_ID=?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "C_UOM_ID");
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
