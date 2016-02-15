//Sqlc generated V1.O00-1
package org.openbravo.erpReports;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

class RptCProposalJrData implements FieldProvider {
static Logger log4j = Logger.getLogger(RptCProposalJrData.class);
  private String InitRecordNumber="0";
  public String headernote;
  public String cProjectproposalId;
  public String cBpartnerId;
  public String address1;
  public String address2;
  public String proposal;
  public String reference;
  public String address;
  public String city;
  public String fecha;
  public String fax;
  public String phone;
  public String name;
  public String bpname;
  public String namecontacto;
  public String contacto;
  public String cursymbol;
  public String lineDesc;
  public String mProductIdD;
  public String description;
  public String price;
  public String quantity;
  public String uomname;
  public String footnote;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("HEADERNOTE"))
      return headernote;
    else if (fieldName.equalsIgnoreCase("C_PROJECTPROPOSAL_ID") || fieldName.equals("cProjectproposalId"))
      return cProjectproposalId;
    else if (fieldName.equalsIgnoreCase("C_BPARTNER_ID") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
    else if (fieldName.equalsIgnoreCase("ADDRESS1"))
      return address1;
    else if (fieldName.equalsIgnoreCase("ADDRESS2"))
      return address2;
    else if (fieldName.equalsIgnoreCase("PROPOSAL"))
      return proposal;
    else if (fieldName.equalsIgnoreCase("REFERENCE"))
      return reference;
    else if (fieldName.equalsIgnoreCase("ADDRESS"))
      return address;
    else if (fieldName.equalsIgnoreCase("CITY"))
      return city;
    else if (fieldName.equalsIgnoreCase("FECHA"))
      return fecha;
    else if (fieldName.equalsIgnoreCase("FAX"))
      return fax;
    else if (fieldName.equalsIgnoreCase("PHONE"))
      return phone;
    else if (fieldName.equalsIgnoreCase("NAME"))
      return name;
    else if (fieldName.equalsIgnoreCase("BPNAME"))
      return bpname;
    else if (fieldName.equalsIgnoreCase("NAMECONTACTO"))
      return namecontacto;
    else if (fieldName.equalsIgnoreCase("CONTACTO"))
      return contacto;
    else if (fieldName.equalsIgnoreCase("CURSYMBOL"))
      return cursymbol;
    else if (fieldName.equalsIgnoreCase("LINE_DESC") || fieldName.equals("lineDesc"))
      return lineDesc;
    else if (fieldName.equalsIgnoreCase("M_PRODUCT_ID_D") || fieldName.equals("mProductIdD"))
      return mProductIdD;
    else if (fieldName.equalsIgnoreCase("DESCRIPTION"))
      return description;
    else if (fieldName.equalsIgnoreCase("PRICE"))
      return price;
    else if (fieldName.equalsIgnoreCase("QUANTITY"))
      return quantity;
    else if (fieldName.equalsIgnoreCase("UOMNAME"))
      return uomname;
    else if (fieldName.equalsIgnoreCase("FOOTNOTE"))
      return footnote;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static RptCProposalJrData[] select(ConnectionProvider connectionProvider, String cProjectProposalId, String adUserClient, String adOrgClient)    throws ServletException {
    return select(connectionProvider, cProjectProposalId, adUserClient, adOrgClient, 0, 0);
  }

  public static RptCProposalJrData[] select(ConnectionProvider connectionProvider, String cProjectProposalId, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "SELECT DISTINCT REPLACE(table3.HEADERNOTE, CHR(10), '') AS headernote, table3.C_PROJECTPROPOSAL_ID," +
      "		table7.C_BPARTNER_ID, TO_CHAR(table8.address1) AS address1, to_char(table8.address2) as address2," +
      "        TO_CHAR(table5.DESCRIPTION )  AS proposal, table5.VALUE AS reference," +
      "        TO_CHAR(table8.ADDRESS1)|| ', '||TO_CHAR(table8.POSTAL)||' '|| TO_CHAR(table8.CITY)||' ('||TO_CHAR(table9.description)||')' AS ADDRESS, " +
      "        table8.CITY as CITY," +
      "        to_date (table3.DATESEND) AS fecha, table7.FAX as FAX, table7.PHONE as PHONE,table5.NAME as NAME," +
      "        TO_CHAR(table10.NAME) AS BPname, table11.FIRSTNAME AS namecontacto, table11.LASTNAME AS contacto, " +
      "        table15.CURSYMBOL as CURSYMBOL, " +
      "        '' as line_desc,'' as M_Product_ID_D, '' as description, '' as price,'' as quantity, '' as UOMNAME, table3.FOOTNOTE as FOOTNOTE" +
      "        FROM  C_PROJECTPROPOSAL table3 left join AD_USER table11 on table3.AD_USER_ID = table11.AD_USER_ID" +
      "                                       left join C_GREETING on table11.C_GREETING_ID = C_GREETING.C_GREETING_ID,       " +
      "        C_BPARTNER_LOCATION table7, C_LOCATION table8, C_REGION table9, C_BPARTNER table10," +
      "        C_BPARTNER table4, C_PROJECT table5, AD_ORGINFO table13," +
      "        C_CURRENCY table15 " +
      "        WHERE  table3.C_Projectproposal_ID = ";
    strSql = strSql + ((cProjectProposalId==null || cProjectProposalId.equals(""))?"":cProjectProposalId);
    strSql = strSql + 
      "        AND table3.C_BPARTNER_LOCATION_ID = table7.C_BPARTNER_LOCATION_ID" +
      "        AND table7.C_LOCATION_ID = table8.C_LOCATION_ID" +
      "        AND table8.C_REGION_ID = table9.C_REGION_ID" +
      "        AND table10.C_BPARTNER_ID = table7.C_BPARTNER_ID" +
      "        AND table3.C_BPartner_ID = table4.C_BPartner_ID " +
      "        AND table3.C_Project_ID = table5.C_Project_ID " +
      "        AND table5.C_CURRENCY_ID = table15.C_CURRENCY_ID" +
      "	AND table3.AD_CLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "        AND table3.AD_ORG_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ")" +
      "	AND 1=1";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (cProjectProposalId != null && !(cProjectProposalId.equals(""))) {
        }
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
        RptCProposalJrData objectRptCProposalJrData = new RptCProposalJrData();
        objectRptCProposalJrData.headernote = UtilSql.getValue(result, "HEADERNOTE");
        objectRptCProposalJrData.cProjectproposalId = UtilSql.getValue(result, "C_PROJECTPROPOSAL_ID");
        objectRptCProposalJrData.cBpartnerId = UtilSql.getValue(result, "C_BPARTNER_ID");
        objectRptCProposalJrData.address1 = UtilSql.getValue(result, "ADDRESS1");
        objectRptCProposalJrData.address2 = UtilSql.getValue(result, "ADDRESS2");
        objectRptCProposalJrData.proposal = UtilSql.getValue(result, "PROPOSAL");
        objectRptCProposalJrData.reference = UtilSql.getValue(result, "REFERENCE");
        objectRptCProposalJrData.address = UtilSql.getValue(result, "ADDRESS");
        objectRptCProposalJrData.city = UtilSql.getValue(result, "CITY");
        objectRptCProposalJrData.fecha = UtilSql.getDateValue(result, "FECHA", "dd-MM-yyyy");
        objectRptCProposalJrData.fax = UtilSql.getValue(result, "FAX");
        objectRptCProposalJrData.phone = UtilSql.getValue(result, "PHONE");
        objectRptCProposalJrData.name = UtilSql.getValue(result, "NAME");
        objectRptCProposalJrData.bpname = UtilSql.getValue(result, "BPNAME");
        objectRptCProposalJrData.namecontacto = UtilSql.getValue(result, "NAMECONTACTO");
        objectRptCProposalJrData.contacto = UtilSql.getValue(result, "CONTACTO");
        objectRptCProposalJrData.cursymbol = UtilSql.getValue(result, "CURSYMBOL");
        objectRptCProposalJrData.lineDesc = UtilSql.getValue(result, "LINE_DESC");
        objectRptCProposalJrData.mProductIdD = UtilSql.getValue(result, "M_PRODUCT_ID_D");
        objectRptCProposalJrData.description = UtilSql.getValue(result, "DESCRIPTION");
        objectRptCProposalJrData.price = UtilSql.getValue(result, "PRICE");
        objectRptCProposalJrData.quantity = UtilSql.getValue(result, "QUANTITY");
        objectRptCProposalJrData.uomname = UtilSql.getValue(result, "UOMNAME");
        objectRptCProposalJrData.footnote = UtilSql.getValue(result, "FOOTNOTE");
        objectRptCProposalJrData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectRptCProposalJrData);
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
    RptCProposalJrData objectRptCProposalJrData[] = new RptCProposalJrData[vector.size()];
    vector.copyInto(objectRptCProposalJrData);
    return(objectRptCProposalJrData);
  }
}