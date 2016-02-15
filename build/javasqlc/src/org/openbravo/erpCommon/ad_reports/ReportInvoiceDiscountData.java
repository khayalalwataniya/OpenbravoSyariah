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

class ReportInvoiceDiscountData implements FieldProvider {
static Logger log4j = Logger.getLogger(ReportInvoiceDiscountData.class);
  private String InitRecordNumber="0";
  public String id;
  public String name;
  public String productname;
  public String qty;
  public String uom;
  public String priceactual;
  public String totalline;
  public String realprice;
  public String totallinediscount;
  public String discount;
  public String classDesign;
  public String weight;
  public String transcurrencyid;
  public String transdate;
  public String transclientid;
  public String transorgid;
  public String convsym;
  public String convisosym;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("ID"))
      return id;
    else if (fieldName.equalsIgnoreCase("NAME"))
      return name;
    else if (fieldName.equalsIgnoreCase("PRODUCTNAME"))
      return productname;
    else if (fieldName.equalsIgnoreCase("QTY"))
      return qty;
    else if (fieldName.equalsIgnoreCase("UOM"))
      return uom;
    else if (fieldName.equalsIgnoreCase("PRICEACTUAL"))
      return priceactual;
    else if (fieldName.equalsIgnoreCase("TOTALLINE"))
      return totalline;
    else if (fieldName.equalsIgnoreCase("REALPRICE"))
      return realprice;
    else if (fieldName.equalsIgnoreCase("TOTALLINEDISCOUNT"))
      return totallinediscount;
    else if (fieldName.equalsIgnoreCase("DISCOUNT"))
      return discount;
    else if (fieldName.equalsIgnoreCase("CLASS_DESIGN") || fieldName.equals("classDesign"))
      return classDesign;
    else if (fieldName.equalsIgnoreCase("WEIGHT"))
      return weight;
    else if (fieldName.equalsIgnoreCase("TRANSCURRENCYID"))
      return transcurrencyid;
    else if (fieldName.equalsIgnoreCase("TRANSDATE"))
      return transdate;
    else if (fieldName.equalsIgnoreCase("TRANSCLIENTID"))
      return transclientid;
    else if (fieldName.equalsIgnoreCase("TRANSORGID"))
      return transorgid;
    else if (fieldName.equalsIgnoreCase("CONVSYM"))
      return convsym;
    else if (fieldName.equalsIgnoreCase("CONVISOSYM"))
      return convisosym;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ReportInvoiceDiscountData[] select(ConnectionProvider connectionProvider, String cCurrencyConv, String adUserClient, String adUserOrg, String datefrom, String dateto, String parBPartnerId, String discount)    throws ServletException {
    return select(connectionProvider, cCurrencyConv, adUserClient, adUserOrg, datefrom, dateto, parBPartnerId, discount, 0, 0);
  }

  public static ReportInvoiceDiscountData[] select(ConnectionProvider connectionProvider, String cCurrencyConv, String adUserClient, String adUserOrg, String datefrom, String dateto, String parBPartnerId, String discount, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "	SELECT C_BPARTNER_ID as ID, NAME, PRODUCTNAME, QTY,UOM, ROUND(C_DIVIDE(TOTALLINE,QTY),3) AS PRICEACTUAL, TOTALLINE, " +
      "	ROUND(C_DIVIDE(TOTALLINEDISCOUNT,QTY),3) AS REALPRICE, TOTALLINEDISCOUNT,        " +
      "	(ROUND(C_DIVIDE((ROUND(C_DIVIDE(TOTALLINE,QTY),3)-ROUND(C_DIVIDE(TOTALLINEDISCOUNT,QTY),3)),ROUND(C_DIVIDE(TOTALLINE,QTY),3)),2))*100 AS DISCOUNT,        " +
      "	(CASE (ROUND(C_DIVIDE((ROUND(C_DIVIDE(TOTALLINE,QTY),3)-ROUND(C_DIVIDE(TOTALLINEDISCOUNT,QTY),3)),ROUND(C_DIVIDE(TOTALLINE,QTY),3)),2))*100 WHEN 0 THEN '' ELSE '' END)  AS CLASS_DESIGN,        " +
      "	WEIGHT,	TRCURRENCYID AS TRANSCURRENCYID, TRDATE AS TRANSDATE,	TRCLIENTID AS TRANSCLIENTID, TRORGID AS TRANSORGID," +
      "	C_CURRENCY_SYMBOL(?, 0, 'Y') AS CONVSYM, C_CURRENCY_ISOSYM(?) AS CONVISOSYM" +
      "	FROM (SELECT C_DOCTYPE.DOCBASETYPE,C_BPARTNER.C_BPARTNER_ID, C_BPARTNER.NAME, M_PRODUCT.NAME AS PRODUCTNAME, C_UOM.UOMSYMBOL AS UOM, CASE WHEN C_DOCTYPE.DOCBASETYPE='ARC' THEN SUM(C_INVOICELINE.QTYINVOICED)*-1 ELSE SUM(C_INVOICELINE.QTYINVOICED) END AS QTY, " +
      "	C_CURRENCY_CONVERT(ROUND(CASE WHEN C_DOCTYPE.DOCBASETYPE='ARC' THEN SUM(LINENETAMT)*-1 ELSE SUM(LINENETAMT) END,2), C_INVOICE.C_CURRENCY_ID, ?,  TO_DATE(COALESCE(C_INVOICE.DATEINVOICED, NOW())), NULL, C_INVOICELINE.AD_CLIENT_ID, C_INVOICELINE.AD_ORG_ID) AS TOTALLINE,         " +
      "	C_CURRENCY_CONVERT(ROUND(SUM(CASE WHEN C_DOCTYPE.DOCBASETYPE='ARC' THEN LINENETAMT*-1*(1-COALESCE(DISCOUNTPERUNIT,0)) ELSE LINENETAMT*(1-COALESCE(DISCOUNTPERUNIT,0)) END),2), C_INVOICE.C_CURRENCY_ID, ?,  TO_DATE(COALESCE(C_INVOICE.DATEINVOICED, NOW())), NULL, C_INVOICELINE.AD_CLIENT_ID, C_INVOICELINE.AD_ORG_ID) AS TOTALLINEDISCOUNT, " +
      "	SUM(C_INVOICELINE.QTYINVOICED)*COALESCE(M_PRODUCT.WEIGHT,0) AS WEIGHT," +
      "	C_INVOICE.C_CURRENCY_ID AS TRCURRENCYID," +
      "	TO_DATE(COALESCE(C_INVOICE.DATEINVOICED, NOW())) AS TRDATE," +
      "	C_INVOICELINE.AD_CLIENT_ID AS TRCLIENTID, " +
      "	C_INVOICELINE.AD_ORG_ID AS TRORGID      " +
      "	FROM C_INVOICELINE left join          " +
      "	(SELECT C_INVOICE_ID, DISCOUNTLINES/(TOTALLINES+DISCOUNTLINES) AS DISCOUNTPERUNIT           " +
      "	FROM (SELECT I.C_INVOICE_ID, " +
      "	C_CURRENCY_CONVERT(I.TOTALLINES, I.C_CURRENCY_ID, ?,  TO_DATE(COALESCE(I.DATEINVOICED, NOW())), NULL, I.AD_CLIENT_ID, I.AD_ORG_ID) AS TOTALLINES, " +
      "	C_CURRENCY_CONVERT(-SUM(LINENETAMT), I.C_CURRENCY_ID, ?,  TO_DATE(COALESCE(I.DATEINVOICED, NOW())), NULL, IL.AD_CLIENT_ID, IL.AD_ORG_ID) AS DISCOUNTLINES" +
      "	FROM C_INVOICE I, C_INVOICELINE IL           " +
      "	WHERE I.C_INVOICE_ID = IL.C_INVOICE_ID AND IL.C_INVOICE_DISCOUNT_ID IS NOT NULL AND I.AD_CLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") AND I.AD_ORG_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ")                 " +
      "	GROUP BY I.C_INVOICE_ID, I.TOTALLINES, I.C_CURRENCY_ID, I.DATEINVOICED, I.AD_CLIENT_ID, I.AD_ORG_ID, IL.AD_CLIENT_ID, IL.AD_ORG_ID) BB) A on C_INVOICELINE.C_INVOICE_ID = A.C_INVOICE_ID" +
      "    left join C_INVOICE on C_INVOICELINE.C_INVOICE_ID = C_INVOICE.C_INVOICE_ID" +
      "    LEFT Join C_DOCTYPE on C_INVOICE.C_DOCTYPE_ID=C_DOCTYPE.C_DOCTYPE_ID," +
      "    M_PRODUCT, C_BPARTNER,  C_UOM" +
      "    WHERE  C_INVOICELINE.C_INVOICE_DISCOUNT_ID IS NULL" +
      "    AND C_INVOICELINE.M_PRODUCT_ID = M_PRODUCT.M_PRODUCT_ID" +
      "    AND M_PRODUCT.C_UOM_ID = C_UOM.C_UOM_ID" +
      "    AND C_INVOICE.C_BPARTNER_ID = C_BPARTNER.C_BPARTNER_ID" +
      "    AND C_INVOICE.ISSOTRX='Y'" +
      "    AND C_INVOICE.AD_CLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "    AND C_INVOICE.AD_ORG_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ")" +
      "    AND PRICEACTUAL<>0" +
      "    AND C_INVOICE.DATEINVOICED >= to_date(?)" +
      "    AND C_INVOICE.DATEINVOICED <= to_date(?)" +
      "    AND 1=1";
    strSql = strSql + ((parBPartnerId==null || parBPartnerId.equals(""))?"":"  AND C_BPARTNER.C_BPARTNER_ID IN" + parBPartnerId);
    strSql = strSql + 
      "    GROUP BY C_BPARTNER.C_BPARTNER_ID, C_BPARTNER.NAME, M_PRODUCT.NAME, C_UOM.UOMSYMBOL, M_PRODUCT.WEIGHT, " +
      "    C_INVOICE.C_CURRENCY_ID, C_INVOICE.DATEINVOICED, C_INVOICELINE.AD_CLIENT_ID, C_INVOICELINE.AD_ORG_ID,C_DOCTYPE.DOCBASETYPE) AA" +
      "    WHERE QTY<>0" +
      "    AND 2=2";
    strSql = strSql + ((discount.equals("discount"))?"  AND (ROUND((ROUND(TOTALLINE/QTY,3)-ROUND(TOTALLINEDISCOUNT/QTY,3))/ROUND(TOTALLINE/QTY,3),2))*100 <>0 ":"");
    strSql = strSql + 
      "    ORDER BY NAME";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyConv);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datefrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateto);
      if (parBPartnerId != null && !(parBPartnerId.equals(""))) {
        }
      if (discount != null && !(discount.equals(""))) {
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
        ReportInvoiceDiscountData objectReportInvoiceDiscountData = new ReportInvoiceDiscountData();
        objectReportInvoiceDiscountData.id = UtilSql.getValue(result, "ID");
        objectReportInvoiceDiscountData.name = UtilSql.getValue(result, "NAME");
        objectReportInvoiceDiscountData.productname = UtilSql.getValue(result, "PRODUCTNAME");
        objectReportInvoiceDiscountData.qty = UtilSql.getValue(result, "QTY");
        objectReportInvoiceDiscountData.uom = UtilSql.getValue(result, "UOM");
        objectReportInvoiceDiscountData.priceactual = UtilSql.getValue(result, "PRICEACTUAL");
        objectReportInvoiceDiscountData.totalline = UtilSql.getValue(result, "TOTALLINE");
        objectReportInvoiceDiscountData.realprice = UtilSql.getValue(result, "REALPRICE");
        objectReportInvoiceDiscountData.totallinediscount = UtilSql.getValue(result, "TOTALLINEDISCOUNT");
        objectReportInvoiceDiscountData.discount = UtilSql.getValue(result, "DISCOUNT");
        objectReportInvoiceDiscountData.classDesign = UtilSql.getValue(result, "CLASS_DESIGN");
        objectReportInvoiceDiscountData.weight = UtilSql.getValue(result, "WEIGHT");
        objectReportInvoiceDiscountData.transcurrencyid = UtilSql.getValue(result, "TRANSCURRENCYID");
        objectReportInvoiceDiscountData.transdate = UtilSql.getDateValue(result, "TRANSDATE", "dd-MM-yyyy");
        objectReportInvoiceDiscountData.transclientid = UtilSql.getValue(result, "TRANSCLIENTID");
        objectReportInvoiceDiscountData.transorgid = UtilSql.getValue(result, "TRANSORGID");
        objectReportInvoiceDiscountData.convsym = UtilSql.getValue(result, "CONVSYM");
        objectReportInvoiceDiscountData.convisosym = UtilSql.getValue(result, "CONVISOSYM");
        objectReportInvoiceDiscountData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportInvoiceDiscountData);
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
    ReportInvoiceDiscountData objectReportInvoiceDiscountData[] = new ReportInvoiceDiscountData[vector.size()];
    vector.copyInto(objectReportInvoiceDiscountData);
    return(objectReportInvoiceDiscountData);
  }
}
