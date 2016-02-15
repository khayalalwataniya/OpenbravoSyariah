//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.Journal;

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
class LinesData implements FieldProvider {
static Logger log4j = Logger.getLogger(LinesData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String adOrgId;
  public String adOrgIdr;
  public String line;
  public String cValidcombinationId;
  public String description;
  public String cCurrencyId;
  public String amtsourcedr;
  public String amtsourcecr;
  public String isgenerated;
  public String amtacctdr;
  public String amtacctcr;
  public String currencyratetype;
  public String currencyrate;
  public String openItems;
  public String finFinancialAccountId;
  public String finFinancialAccountIdr;
  public String finPaymentmethodId;
  public String finPaymentmethodIdr;
  public String cGlitemId;
  public String cGlitemIdr;
  public String paymentdate;
  public String finPaymentId;
  public String cUomId;
  public String qty;
  public String cDebtPaymentId;
  public String cWithholdingId;
  public String isactive;
  public String cTaxId;
  public String emAprmAddpayment;
  public String cBpartnerId;
  public String cBpartnerIdr;
  public String mProductId;
  public String cProjectId;
  public String cProjectIdr;
  public String cActivityId;
  public String cCampaignId;
  public String cSalesregionId;
  public String cSalesregionIdr;
  public String user1Id;
  public String user2Id;
  public String aAssetId;
  public String cCostcenterId;
  public String dateacct;
  public String glJournalId;
  public String adClientId;
  public String glJournallineId;
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
    else if (fieldName.equalsIgnoreCase("LINE"))
      return line;
    else if (fieldName.equalsIgnoreCase("C_VALIDCOMBINATION_ID") || fieldName.equals("cValidcombinationId"))
      return cValidcombinationId;
    else if (fieldName.equalsIgnoreCase("DESCRIPTION"))
      return description;
    else if (fieldName.equalsIgnoreCase("C_CURRENCY_ID") || fieldName.equals("cCurrencyId"))
      return cCurrencyId;
    else if (fieldName.equalsIgnoreCase("AMTSOURCEDR"))
      return amtsourcedr;
    else if (fieldName.equalsIgnoreCase("AMTSOURCECR"))
      return amtsourcecr;
    else if (fieldName.equalsIgnoreCase("ISGENERATED"))
      return isgenerated;
    else if (fieldName.equalsIgnoreCase("AMTACCTDR"))
      return amtacctdr;
    else if (fieldName.equalsIgnoreCase("AMTACCTCR"))
      return amtacctcr;
    else if (fieldName.equalsIgnoreCase("CURRENCYRATETYPE"))
      return currencyratetype;
    else if (fieldName.equalsIgnoreCase("CURRENCYRATE"))
      return currencyrate;
    else if (fieldName.equalsIgnoreCase("OPEN_ITEMS") || fieldName.equals("openItems"))
      return openItems;
    else if (fieldName.equalsIgnoreCase("FIN_FINANCIAL_ACCOUNT_ID") || fieldName.equals("finFinancialAccountId"))
      return finFinancialAccountId;
    else if (fieldName.equalsIgnoreCase("FIN_FINANCIAL_ACCOUNT_IDR") || fieldName.equals("finFinancialAccountIdr"))
      return finFinancialAccountIdr;
    else if (fieldName.equalsIgnoreCase("FIN_PAYMENTMETHOD_ID") || fieldName.equals("finPaymentmethodId"))
      return finPaymentmethodId;
    else if (fieldName.equalsIgnoreCase("FIN_PAYMENTMETHOD_IDR") || fieldName.equals("finPaymentmethodIdr"))
      return finPaymentmethodIdr;
    else if (fieldName.equalsIgnoreCase("C_GLITEM_ID") || fieldName.equals("cGlitemId"))
      return cGlitemId;
    else if (fieldName.equalsIgnoreCase("C_GLITEM_IDR") || fieldName.equals("cGlitemIdr"))
      return cGlitemIdr;
    else if (fieldName.equalsIgnoreCase("PAYMENTDATE"))
      return paymentdate;
    else if (fieldName.equalsIgnoreCase("FIN_PAYMENT_ID") || fieldName.equals("finPaymentId"))
      return finPaymentId;
    else if (fieldName.equalsIgnoreCase("C_UOM_ID") || fieldName.equals("cUomId"))
      return cUomId;
    else if (fieldName.equalsIgnoreCase("QTY"))
      return qty;
    else if (fieldName.equalsIgnoreCase("C_DEBT_PAYMENT_ID") || fieldName.equals("cDebtPaymentId"))
      return cDebtPaymentId;
    else if (fieldName.equalsIgnoreCase("C_WITHHOLDING_ID") || fieldName.equals("cWithholdingId"))
      return cWithholdingId;
    else if (fieldName.equalsIgnoreCase("ISACTIVE"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("C_TAX_ID") || fieldName.equals("cTaxId"))
      return cTaxId;
    else if (fieldName.equalsIgnoreCase("EM_APRM_ADDPAYMENT") || fieldName.equals("emAprmAddpayment"))
      return emAprmAddpayment;
    else if (fieldName.equalsIgnoreCase("C_BPARTNER_ID") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
    else if (fieldName.equalsIgnoreCase("C_BPARTNER_IDR") || fieldName.equals("cBpartnerIdr"))
      return cBpartnerIdr;
    else if (fieldName.equalsIgnoreCase("M_PRODUCT_ID") || fieldName.equals("mProductId"))
      return mProductId;
    else if (fieldName.equalsIgnoreCase("C_PROJECT_ID") || fieldName.equals("cProjectId"))
      return cProjectId;
    else if (fieldName.equalsIgnoreCase("C_PROJECT_IDR") || fieldName.equals("cProjectIdr"))
      return cProjectIdr;
    else if (fieldName.equalsIgnoreCase("C_ACTIVITY_ID") || fieldName.equals("cActivityId"))
      return cActivityId;
    else if (fieldName.equalsIgnoreCase("C_CAMPAIGN_ID") || fieldName.equals("cCampaignId"))
      return cCampaignId;
    else if (fieldName.equalsIgnoreCase("C_SALESREGION_ID") || fieldName.equals("cSalesregionId"))
      return cSalesregionId;
    else if (fieldName.equalsIgnoreCase("C_SALESREGION_IDR") || fieldName.equals("cSalesregionIdr"))
      return cSalesregionIdr;
    else if (fieldName.equalsIgnoreCase("USER1_ID") || fieldName.equals("user1Id"))
      return user1Id;
    else if (fieldName.equalsIgnoreCase("USER2_ID") || fieldName.equals("user2Id"))
      return user2Id;
    else if (fieldName.equalsIgnoreCase("A_ASSET_ID") || fieldName.equals("aAssetId"))
      return aAssetId;
    else if (fieldName.equalsIgnoreCase("C_COSTCENTER_ID") || fieldName.equals("cCostcenterId"))
      return cCostcenterId;
    else if (fieldName.equalsIgnoreCase("DATEACCT"))
      return dateacct;
    else if (fieldName.equalsIgnoreCase("GL_JOURNAL_ID") || fieldName.equals("glJournalId"))
      return glJournalId;
    else if (fieldName.equalsIgnoreCase("AD_CLIENT_ID") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("GL_JOURNALLINE_ID") || fieldName.equals("glJournallineId"))
      return glJournallineId;
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
  public static LinesData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String glJournalId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, glJournalId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static LinesData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String glJournalId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(GL_JournalLine.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = GL_JournalLine.CreatedBy) as CreatedByR, " +
      "        to_char(GL_JournalLine.Updated, ?) as updated, " +
      "        to_char(GL_JournalLine.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        GL_JournalLine.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = GL_JournalLine.UpdatedBy) as UpdatedByR," +
      "        GL_JournalLine.AD_Org_ID, " +
      "(CASE WHEN GL_JournalLine.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Value), ''))),'') ) END) AS AD_Org_IDR, " +
      "GL_JournalLine.Line, " +
      "GL_JournalLine.C_ValidCombination_ID, " +
      "GL_JournalLine.Description, " +
      "GL_JournalLine.C_Currency_ID, " +
      "GL_JournalLine.AmtSourceDr, " +
      "GL_JournalLine.AmtSourceCr, " +
      "COALESCE(GL_JournalLine.IsGenerated, 'N') AS IsGenerated, " +
      "GL_JournalLine.AmtAcctDr, " +
      "GL_JournalLine.AmtAcctCr, " +
      "GL_JournalLine.CurrencyRateType, " +
      "GL_JournalLine.CurrencyRate, " +
      "COALESCE(GL_JournalLine.Open_Items, 'N') AS Open_Items, " +
      "GL_JournalLine.FIN_Financial_Account_ID, " +
      "(CASE WHEN GL_JournalLine.FIN_Financial_Account_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.ISO_Code), ''))),'') ) END) AS FIN_Financial_Account_IDR, " +
      "GL_JournalLine.FIN_Paymentmethod_ID, " +
      "(CASE WHEN GL_JournalLine.FIN_Paymentmethod_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Name), ''))),'') ) END) AS FIN_Paymentmethod_IDR, " +
      "GL_JournalLine.C_Glitem_ID, " +
      "(CASE WHEN GL_JournalLine.C_Glitem_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.Name), ''))),'') ) END) AS C_Glitem_IDR, " +
      "GL_JournalLine.Paymentdate, " +
      "GL_JournalLine.FIN_Payment_ID, " +
      "GL_JournalLine.C_UOM_ID, " +
      "GL_JournalLine.Qty, " +
      "GL_JournalLine.C_Debt_Payment_ID, " +
      "GL_JournalLine.C_Withholding_ID, " +
      "COALESCE(GL_JournalLine.IsActive, 'N') AS IsActive, " +
      "GL_JournalLine.C_Tax_ID, " +
      "GL_JournalLine.EM_Aprm_Addpayment, " +
      "GL_JournalLine.C_Bpartner_ID, " +
      "(CASE WHEN GL_JournalLine.C_Bpartner_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table6.Name), ''))),'') ) END) AS C_Bpartner_IDR, " +
      "GL_JournalLine.M_Product_ID, " +
      "GL_JournalLine.C_Project_ID, " +
      "(CASE WHEN GL_JournalLine.C_Project_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table7.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table7.Name), ''))),'') ) END) AS C_Project_IDR, " +
      "GL_JournalLine.C_Activity_ID, " +
      "GL_JournalLine.C_Campaign_ID, " +
      "GL_JournalLine.C_Salesregion_ID, " +
      "(CASE WHEN GL_JournalLine.C_Salesregion_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table8.Name), ''))),'') ) END) AS C_Salesregion_IDR, " +
      "GL_JournalLine.User1_ID, " +
      "GL_JournalLine.User2_ID, " +
      "GL_JournalLine.A_Asset_ID, " +
      "GL_JournalLine.C_Costcenter_ID, " +
      "GL_JournalLine.DateAcct, " +
      "GL_JournalLine.GL_Journal_ID, " +
      "GL_JournalLine.AD_Client_ID, " +
      "GL_JournalLine.GL_JournalLine_ID, " +
      "        ? AS LANGUAGE " +
      "        FROM GL_JournalLine left join (select AD_Org_ID, Value from AD_Org) table1 on (GL_JournalLine.AD_Org_ID = table1.AD_Org_ID) left join (select FIN_Financial_Account_ID, Name, C_Currency_ID from FIN_Financial_Account) table2 on (GL_JournalLine.FIN_Financial_Account_ID = table2.FIN_Financial_Account_ID) left join (select C_Currency_ID, ISO_Code from C_Currency) table3 on (table2.C_Currency_ID = table3.C_Currency_ID) left join (select FIN_Paymentmethod_ID, Name from FIN_Paymentmethod) table4 on (GL_JournalLine.FIN_Paymentmethod_ID = table4.FIN_Paymentmethod_ID) left join (select C_Glitem_ID, Name from C_Glitem) table5 on (GL_JournalLine.C_Glitem_ID = table5.C_Glitem_ID) left join (select C_BPartner_ID, Name from C_BPartner) table6 on (GL_JournalLine.C_Bpartner_ID = table6.C_BPartner_ID) left join (select C_Project_ID, Value, Name from C_Project) table7 on (GL_JournalLine.C_Project_ID = table7.C_Project_ID) left join (select C_Salesregion_ID, Name from C_Salesregion) table8 on (GL_JournalLine.C_Salesregion_ID = table8.C_Salesregion_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((glJournalId==null || glJournalId.equals(""))?"":"  AND GL_JournalLine.GL_Journal_ID = ?  ");
    strSql = strSql + 
      "        AND GL_JournalLine.GL_JournalLine_ID = ? " +
      "        AND GL_JournalLine.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND GL_JournalLine.AD_Org_ID IN (";
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
      if (glJournalId != null && !(glJournalId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, glJournalId);
      }
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
        LinesData objectLinesData = new LinesData();
        objectLinesData.created = UtilSql.getValue(result, "CREATED");
        objectLinesData.createdbyr = UtilSql.getValue(result, "CREATEDBYR");
        objectLinesData.updated = UtilSql.getValue(result, "UPDATED");
        objectLinesData.updatedTimeStamp = UtilSql.getValue(result, "UPDATED_TIME_STAMP");
        objectLinesData.updatedby = UtilSql.getValue(result, "UPDATEDBY");
        objectLinesData.updatedbyr = UtilSql.getValue(result, "UPDATEDBYR");
        objectLinesData.adOrgId = UtilSql.getValue(result, "AD_ORG_ID");
        objectLinesData.adOrgIdr = UtilSql.getValue(result, "AD_ORG_IDR");
        objectLinesData.line = UtilSql.getValue(result, "LINE");
        objectLinesData.cValidcombinationId = UtilSql.getValue(result, "C_VALIDCOMBINATION_ID");
        objectLinesData.description = UtilSql.getValue(result, "DESCRIPTION");
        objectLinesData.cCurrencyId = UtilSql.getValue(result, "C_CURRENCY_ID");
        objectLinesData.amtsourcedr = UtilSql.getValue(result, "AMTSOURCEDR");
        objectLinesData.amtsourcecr = UtilSql.getValue(result, "AMTSOURCECR");
        objectLinesData.isgenerated = UtilSql.getValue(result, "ISGENERATED");
        objectLinesData.amtacctdr = UtilSql.getValue(result, "AMTACCTDR");
        objectLinesData.amtacctcr = UtilSql.getValue(result, "AMTACCTCR");
        objectLinesData.currencyratetype = UtilSql.getValue(result, "CURRENCYRATETYPE");
        objectLinesData.currencyrate = UtilSql.getValue(result, "CURRENCYRATE");
        objectLinesData.openItems = UtilSql.getValue(result, "OPEN_ITEMS");
        objectLinesData.finFinancialAccountId = UtilSql.getValue(result, "FIN_FINANCIAL_ACCOUNT_ID");
        objectLinesData.finFinancialAccountIdr = UtilSql.getValue(result, "FIN_FINANCIAL_ACCOUNT_IDR");
        objectLinesData.finPaymentmethodId = UtilSql.getValue(result, "FIN_PAYMENTMETHOD_ID");
        objectLinesData.finPaymentmethodIdr = UtilSql.getValue(result, "FIN_PAYMENTMETHOD_IDR");
        objectLinesData.cGlitemId = UtilSql.getValue(result, "C_GLITEM_ID");
        objectLinesData.cGlitemIdr = UtilSql.getValue(result, "C_GLITEM_IDR");
        objectLinesData.paymentdate = UtilSql.getDateValue(result, "PAYMENTDATE", "dd-MM-yyyy");
        objectLinesData.finPaymentId = UtilSql.getValue(result, "FIN_PAYMENT_ID");
        objectLinesData.cUomId = UtilSql.getValue(result, "C_UOM_ID");
        objectLinesData.qty = UtilSql.getValue(result, "QTY");
        objectLinesData.cDebtPaymentId = UtilSql.getValue(result, "C_DEBT_PAYMENT_ID");
        objectLinesData.cWithholdingId = UtilSql.getValue(result, "C_WITHHOLDING_ID");
        objectLinesData.isactive = UtilSql.getValue(result, "ISACTIVE");
        objectLinesData.cTaxId = UtilSql.getValue(result, "C_TAX_ID");
        objectLinesData.emAprmAddpayment = UtilSql.getValue(result, "EM_APRM_ADDPAYMENT");
        objectLinesData.cBpartnerId = UtilSql.getValue(result, "C_BPARTNER_ID");
        objectLinesData.cBpartnerIdr = UtilSql.getValue(result, "C_BPARTNER_IDR");
        objectLinesData.mProductId = UtilSql.getValue(result, "M_PRODUCT_ID");
        objectLinesData.cProjectId = UtilSql.getValue(result, "C_PROJECT_ID");
        objectLinesData.cProjectIdr = UtilSql.getValue(result, "C_PROJECT_IDR");
        objectLinesData.cActivityId = UtilSql.getValue(result, "C_ACTIVITY_ID");
        objectLinesData.cCampaignId = UtilSql.getValue(result, "C_CAMPAIGN_ID");
        objectLinesData.cSalesregionId = UtilSql.getValue(result, "C_SALESREGION_ID");
        objectLinesData.cSalesregionIdr = UtilSql.getValue(result, "C_SALESREGION_IDR");
        objectLinesData.user1Id = UtilSql.getValue(result, "USER1_ID");
        objectLinesData.user2Id = UtilSql.getValue(result, "USER2_ID");
        objectLinesData.aAssetId = UtilSql.getValue(result, "A_ASSET_ID");
        objectLinesData.cCostcenterId = UtilSql.getValue(result, "C_COSTCENTER_ID");
        objectLinesData.dateacct = UtilSql.getDateValue(result, "DATEACCT", "dd-MM-yyyy");
        objectLinesData.glJournalId = UtilSql.getValue(result, "GL_JOURNAL_ID");
        objectLinesData.adClientId = UtilSql.getValue(result, "AD_CLIENT_ID");
        objectLinesData.glJournallineId = UtilSql.getValue(result, "GL_JOURNALLINE_ID");
        objectLinesData.language = UtilSql.getValue(result, "LANGUAGE");
        objectLinesData.adUserClient = "";
        objectLinesData.adOrgClient = "";
        objectLinesData.createdby = "";
        objectLinesData.trBgcolor = "";
        objectLinesData.totalCount = "";
        objectLinesData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectLinesData);
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
    LinesData objectLinesData[] = new LinesData[vector.size()];
    vector.copyInto(objectLinesData);
    return(objectLinesData);
  }

/**
Create a registry
 */
  public static LinesData[] set(String glJournalId, String glJournallineId, String adClientId, String adOrgId, String isactive, String createdby, String createdbyr, String updatedby, String updatedbyr, String line, String description, String cCurrencyId, String amtsourcedr, String amtsourcecr, String amtacctdr, String amtacctcr, String isgenerated, String cWithholdingId, String cTaxId, String currencyrate, String cCostcenterId, String currencyratetype, String dateacct, String cUomId, String qty, String cDebtPaymentId, String cValidcombinationId, String openItems, String cGlitemId, String user1Id, String user2Id, String cCampaignId, String cProjectId, String cProjectIdr, String cActivityId, String cSalesregionId, String mProductId, String cBpartnerId, String cBpartnerIdr, String finPaymentId, String paymentdate, String emAprmAddpayment, String finFinancialAccountId, String aAssetId, String finPaymentmethodId)    throws ServletException {
    LinesData objectLinesData[] = new LinesData[1];
    objectLinesData[0] = new LinesData();
    objectLinesData[0].created = "";
    objectLinesData[0].createdbyr = createdbyr;
    objectLinesData[0].updated = "";
    objectLinesData[0].updatedTimeStamp = "";
    objectLinesData[0].updatedby = updatedby;
    objectLinesData[0].updatedbyr = updatedbyr;
    objectLinesData[0].adOrgId = adOrgId;
    objectLinesData[0].adOrgIdr = "";
    objectLinesData[0].line = line;
    objectLinesData[0].cValidcombinationId = cValidcombinationId;
    objectLinesData[0].description = description;
    objectLinesData[0].cCurrencyId = cCurrencyId;
    objectLinesData[0].amtsourcedr = amtsourcedr;
    objectLinesData[0].amtsourcecr = amtsourcecr;
    objectLinesData[0].isgenerated = isgenerated;
    objectLinesData[0].amtacctdr = amtacctdr;
    objectLinesData[0].amtacctcr = amtacctcr;
    objectLinesData[0].currencyratetype = currencyratetype;
    objectLinesData[0].currencyrate = currencyrate;
    objectLinesData[0].openItems = openItems;
    objectLinesData[0].finFinancialAccountId = finFinancialAccountId;
    objectLinesData[0].finFinancialAccountIdr = "";
    objectLinesData[0].finPaymentmethodId = finPaymentmethodId;
    objectLinesData[0].finPaymentmethodIdr = "";
    objectLinesData[0].cGlitemId = cGlitemId;
    objectLinesData[0].cGlitemIdr = "";
    objectLinesData[0].paymentdate = paymentdate;
    objectLinesData[0].finPaymentId = finPaymentId;
    objectLinesData[0].cUomId = cUomId;
    objectLinesData[0].qty = qty;
    objectLinesData[0].cDebtPaymentId = cDebtPaymentId;
    objectLinesData[0].cWithholdingId = cWithholdingId;
    objectLinesData[0].isactive = isactive;
    objectLinesData[0].cTaxId = cTaxId;
    objectLinesData[0].emAprmAddpayment = emAprmAddpayment;
    objectLinesData[0].cBpartnerId = cBpartnerId;
    objectLinesData[0].cBpartnerIdr = cBpartnerIdr;
    objectLinesData[0].mProductId = mProductId;
    objectLinesData[0].cProjectId = cProjectId;
    objectLinesData[0].cProjectIdr = cProjectIdr;
    objectLinesData[0].cActivityId = cActivityId;
    objectLinesData[0].cCampaignId = cCampaignId;
    objectLinesData[0].cSalesregionId = cSalesregionId;
    objectLinesData[0].cSalesregionIdr = "";
    objectLinesData[0].user1Id = user1Id;
    objectLinesData[0].user2Id = user2Id;
    objectLinesData[0].aAssetId = aAssetId;
    objectLinesData[0].cCostcenterId = cCostcenterId;
    objectLinesData[0].dateacct = dateacct;
    objectLinesData[0].glJournalId = glJournalId;
    objectLinesData[0].adClientId = adClientId;
    objectLinesData[0].glJournallineId = glJournallineId;
    objectLinesData[0].language = "";
    return objectLinesData;
  }

/**
Select for auxiliar field
 */
  public static String selectAux5BAAD3A90DD249B1ACCFAD81E03144C3(ConnectionProvider connectionProvider, String GL_JOURNAL_ID)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT PROCESSED FROM GL_JOURNAL WHERE GL_JOURNAL_ID = ? ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, GL_JOURNAL_ID);

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
  public static String selectAux67A43C8696ED48EEA6A36426DC073193(ConnectionProvider connectionProvider, String GL_JOURNAL_ID)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT POSTED FROM GL_JOURNAL WHERE GL_JOURNAL_ID = ? ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, GL_JOURNAL_ID);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "POSTED");
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
  public static String selectAux8482E2A2C9D74EA592CE8AF25AA9364C(ConnectionProvider connectionProvider, String AD_ORG_ID)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT COUNT(DISTINCT(C_ACCTSCHEMA_ID))" +
      "FROM AD_ORG" +
      "WHERE AD_ISORGINCLUDED(?, AD_ORG_ID, AD_CLIENT_ID) <> -1" +
      "AND C_ACCTSCHEMA_ID IS NOT NULL ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, AD_ORG_ID);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "COUNT(DISTINCT(C_ACCTSCHEMA_ID))");
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
  public static String selectAux800044(ConnectionProvider connectionProvider, String GL_JOURNAL_ID)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT DESCRIPTION FROM GL_JOURNAL WHERE GL_JOURNAL_ID=? ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, GL_JOURNAL_ID);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "DESCRIPTION");
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
  public static String selectAux3398FFC56C9D48689C928F45C7A3745A(ConnectionProvider connectionProvider, String gl_journal_id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        select c_currency_id from gl_journal where gl_journal_id=? ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, gl_journal_id);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "C_CURRENCY_ID");
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
  public static String selectDef1664_0(ConnectionProvider connectionProvider, String CreatedByR)    throws ServletException {
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
  public static String selectDef1666_1(ConnectionProvider connectionProvider, String UpdatedByR)    throws ServletException {
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
  public static String selectDef1675(ConnectionProvider connectionProvider, String GL_Journal_ID)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT COALESCE(MAX(Line),0)+10 AS DefaultValue FROM GL_JournalLine WHERE GL_Journal_ID=? ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, GL_Journal_ID);

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
  public static String selectDefA7E134B04D5ED632E040007F010037B3_2(ConnectionProvider connectionProvider, String C_Project_IDR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Value), ''))), '')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))), '') ) as C_Project_ID FROM C_Project left join (select C_Project_ID, Value, Name from C_Project) table2 on (C_Project.C_Project_ID = table2.C_Project_ID) WHERE C_Project.isActive='Y' AND C_Project.C_Project_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_Project_IDR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "C_PROJECT_ID");
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
  public static String selectDefA7F1531510454244E040007F010064A6_3(ConnectionProvider connectionProvider, String C_Bpartner_IDR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))), '') ) as C_Bpartner_ID FROM C_BPartner left join (select C_BPartner_ID, Name from C_BPartner) table2 on (C_BPartner.C_BPartner_ID = table2.C_BPartner_ID) WHERE C_BPartner.isActive='Y' AND C_BPartner.C_BPartner_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_Bpartner_IDR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "C_BPARTNER_ID");
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
return the parent ID
 */
  public static String selectParentID(ConnectionProvider connectionProvider, String key)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT GL_JournalLine.GL_Journal_ID AS NAME" +
      "        FROM GL_JournalLine" +
      "        WHERE GL_JournalLine.GL_JournalLine_ID = ?";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, key);

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

/**
Select for parent field
 */
  public static String selectParent(ConnectionProvider connectionProvider, String glJournalId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.DocumentNo), ''))) AS NAME FROM GL_Journal left join (select GL_Journal_ID, DocumentNo from GL_Journal) table1 on (GL_Journal.GL_Journal_ID = table1.GL_Journal_ID) WHERE GL_Journal.GL_Journal_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, glJournalId);

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

/**
Select for parent field
 */
  public static String selectParentTrl(ConnectionProvider connectionProvider, String glJournalId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.DocumentNo), ''))) AS NAME FROM GL_Journal left join (select GL_Journal_ID, DocumentNo from GL_Journal) table1 on (GL_Journal.GL_Journal_ID = table1.GL_Journal_ID) WHERE GL_Journal.GL_Journal_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, glJournalId);

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

  public int update(Connection conn, ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE GL_JournalLine" +
      "        SET AD_Org_ID = (?) , Line = TO_NUMBER(?) , C_ValidCombination_ID = (?) , Description = (?) , C_Currency_ID = (?) , AmtSourceDr = TO_NUMBER(?) , AmtSourceCr = TO_NUMBER(?) , IsGenerated = (?) , AmtAcctDr = TO_NUMBER(?) , AmtAcctCr = TO_NUMBER(?) , CurrencyRateType = (?) , CurrencyRate = TO_NUMBER(?) , Open_Items = (?) , FIN_Financial_Account_ID = (?) , FIN_Paymentmethod_ID = (?) , C_Glitem_ID = (?) , Paymentdate = TO_DATE(?) , FIN_Payment_ID = (?) , C_UOM_ID = (?) , Qty = TO_NUMBER(?) , C_Debt_Payment_ID = (?) , C_Withholding_ID = (?) , IsActive = (?) , C_Tax_ID = (?) , EM_Aprm_Addpayment = (?) , C_Bpartner_ID = (?) , M_Product_ID = (?) , C_Project_ID = (?) , C_Activity_ID = (?) , C_Campaign_ID = (?) , C_Salesregion_ID = (?) , User1_ID = (?) , User2_ID = (?) , A_Asset_ID = (?) , C_Costcenter_ID = (?) , DateAcct = TO_DATE(?) , GL_Journal_ID = (?) , AD_Client_ID = (?) , GL_JournalLine_ID = (?) , updated = now(), updatedby = ? " +
      "        WHERE GL_JournalLine.GL_JournalLine_ID = ? " +
      "                 AND GL_JournalLine.GL_Journal_ID = ? " +
      "        AND GL_JournalLine.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND GL_JournalLine.AD_Org_ID IN (";
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, line);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cValidcombinationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, amtsourcedr);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, amtsourcecr);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isgenerated);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, amtacctdr);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, amtacctcr);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, currencyratetype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, currencyrate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, openItems);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, finFinancialAccountId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, finPaymentmethodId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cGlitemId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paymentdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, finPaymentId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cUomId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDebtPaymentId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cWithholdingId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cTaxId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, emAprmAddpayment);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cActivityId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCampaignId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cSalesregionId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user1Id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user2Id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aAssetId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCostcenterId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateacct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, glJournalId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, glJournallineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, glJournallineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, glJournalId);
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
      "        INSERT INTO GL_JournalLine " +
      "        (AD_Org_ID, Line, C_ValidCombination_ID, Description, C_Currency_ID, AmtSourceDr, AmtSourceCr, IsGenerated, AmtAcctDr, AmtAcctCr, CurrencyRateType, CurrencyRate, Open_Items, FIN_Financial_Account_ID, FIN_Paymentmethod_ID, C_Glitem_ID, Paymentdate, FIN_Payment_ID, C_UOM_ID, Qty, C_Debt_Payment_ID, C_Withholding_ID, IsActive, C_Tax_ID, EM_Aprm_Addpayment, C_Bpartner_ID, M_Product_ID, C_Project_ID, C_Activity_ID, C_Campaign_ID, C_Salesregion_ID, User1_ID, User2_ID, A_Asset_ID, C_Costcenter_ID, DateAcct, GL_Journal_ID, AD_Client_ID, GL_JournalLine_ID, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), TO_NUMBER(?), (?), (?), (?), TO_NUMBER(?), TO_NUMBER(?), (?), TO_NUMBER(?), TO_NUMBER(?), (?), TO_NUMBER(?), (?), (?), (?), (?), TO_DATE(?), (?), (?), TO_NUMBER(?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), TO_DATE(?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, line);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cValidcombinationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, amtsourcedr);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, amtsourcecr);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isgenerated);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, amtacctdr);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, amtacctcr);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, currencyratetype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, currencyrate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, openItems);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, finFinancialAccountId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, finPaymentmethodId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cGlitemId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paymentdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, finPaymentId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cUomId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDebtPaymentId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cWithholdingId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cTaxId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, emAprmAddpayment);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cActivityId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCampaignId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cSalesregionId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user1Id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user2Id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aAssetId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCostcenterId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateacct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, glJournalId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, glJournallineId);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String glJournalId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM GL_JournalLine" +
      "        WHERE GL_JournalLine.GL_JournalLine_ID = ? " +
      "                 AND GL_JournalLine.GL_Journal_ID = ? " +
      "        AND GL_JournalLine.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND GL_JournalLine.AD_Org_ID IN (";
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, glJournalId);
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
      "          FROM GL_JournalLine" +
      "         WHERE GL_JournalLine.GL_JournalLine_ID = ? ";

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
      "          FROM GL_JournalLine" +
      "         WHERE GL_JournalLine.GL_JournalLine_ID = ? ";

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
