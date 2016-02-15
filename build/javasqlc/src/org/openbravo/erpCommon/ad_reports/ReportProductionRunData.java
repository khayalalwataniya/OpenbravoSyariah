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

class ReportProductionRunData implements FieldProvider {
static Logger log4j = Logger.getLogger(ReportProductionRunData.class);
  private String InitRecordNumber="0";
  public String wrname;
  public String wrclosed;
  public String wrlaunch;
  public String wrstart;
  public String wrend;
  public String wrpname;
  public String wrpqty;
  public String wrpdone;
  public String wrpleft;
  public String pname;
  public String wrpph;
  public String wrppt;
  public String wrpclosed;
  public String prname;
  public String wename;
  public String prneeded;
  public String prdone;
  public String prrej;
  public String wrpseq;
  public String wedate;
  public String wrid;
  public String wrpid;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("WRNAME"))
      return wrname;
    else if (fieldName.equalsIgnoreCase("WRCLOSED"))
      return wrclosed;
    else if (fieldName.equalsIgnoreCase("WRLAUNCH"))
      return wrlaunch;
    else if (fieldName.equalsIgnoreCase("WRSTART"))
      return wrstart;
    else if (fieldName.equalsIgnoreCase("WREND"))
      return wrend;
    else if (fieldName.equalsIgnoreCase("WRPNAME"))
      return wrpname;
    else if (fieldName.equalsIgnoreCase("WRPQTY"))
      return wrpqty;
    else if (fieldName.equalsIgnoreCase("WRPDONE"))
      return wrpdone;
    else if (fieldName.equalsIgnoreCase("WRPLEFT"))
      return wrpleft;
    else if (fieldName.equalsIgnoreCase("PNAME"))
      return pname;
    else if (fieldName.equalsIgnoreCase("WRPPH"))
      return wrpph;
    else if (fieldName.equalsIgnoreCase("WRPPT"))
      return wrppt;
    else if (fieldName.equalsIgnoreCase("WRPCLOSED"))
      return wrpclosed;
    else if (fieldName.equalsIgnoreCase("PRNAME"))
      return prname;
    else if (fieldName.equalsIgnoreCase("WENAME"))
      return wename;
    else if (fieldName.equalsIgnoreCase("PRNEEDED"))
      return prneeded;
    else if (fieldName.equalsIgnoreCase("PRDONE"))
      return prdone;
    else if (fieldName.equalsIgnoreCase("PRREJ"))
      return prrej;
    else if (fieldName.equalsIgnoreCase("WRPSEQ"))
      return wrpseq;
    else if (fieldName.equalsIgnoreCase("WEDATE"))
      return wedate;
    else if (fieldName.equalsIgnoreCase("WRID"))
      return wrid;
    else if (fieldName.equalsIgnoreCase("WRPID"))
      return wrpid;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ReportProductionRunData[] select(ConnectionProvider connectionProvider, String language, String adUserClient, String adUserOrg, String parLaunchDateFrom, String parLaunchDateTo, String parStartDateFrom, String parStartDateTo, String parEndDateFrom, String parEndDateTo, String parWorkRequirement)    throws ServletException {
    return select(connectionProvider, language, adUserClient, adUserOrg, parLaunchDateFrom, parLaunchDateTo, parStartDateFrom, parStartDateTo, parEndDateFrom, parEndDateTo, parWorkRequirement, 0, 0);
  }

  public static ReportProductionRunData[] select(ConnectionProvider connectionProvider, String language, String adUserClient, String adUserOrg, String parLaunchDateFrom, String parLaunchDateTo, String parStartDateFrom, String parStartDateTo, String parEndDateFrom, String parEndDateTo, String parWorkRequirement, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT wr.DocumentNo AS wrname, AD_MESSAGE_GET2(wr.CLOSED, to_char(?)) AS wrclosed, wr.LAUNCHDATE AS wrlaunch, wr.STARTDATE AS wrstart, wr.ENDDATE AS wrend," +
      "        wrp.SeqNo AS wrpname, wrp.QUANTITY AS wrpqty, wrp.DONEQUANTITY AS wrpdone, (CASE WHEN pr.closephase = 'N' THEN (wrp.QUANTITY - wrp.DONEQUANTITY ) ELSE 0 END) AS wrpleft," +
      "        p.NAME AS pname, wrp.COSTCENTERUSE AS wrpph, wrp.PREPTIME AS wrppt, AD_MESSAGE_GET2(wrp.CLOSED, to_char(?)) AS wrpclosed," +
      "        pr.LINE AS prname, we.DocumentNo AS wename, pr.NEEDEDQUANTITY AS prneeded, pr.PRODUCTIONQTY AS prdone, pr.REJECTEDQUANTITY As prrej," +
      "        wrp.SEQNO AS wrpseq, we.MOVEMENTDATE AS wedate, wr.MA_WorkRequirement_ID AS wrid, wrp.MA_WRPhase_ID AS wrpid" +
      "      FROM MA_WorkRequirement wr, MA_WRPhase wrp, M_ProductionPlan pr, M_Production we, MA_Process p" +
      "      WHERE wr.MA_WORKREQUIREMENT_ID = wrp.MA_WORKREQUIREMENT_ID" +
      "        AND wrp.MA_PROCESS_ID = p.MA_PROCESS_ID" +
      "        AND pr.MA_WRPHASE_ID = wrp.MA_WRPHASE_ID" +
      "        AND pr.M_PRODUCTION_ID = we.M_PRODUCTION_ID" +
      "        AND pr.AD_CLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "        AND pr.AD_ORG_ID IN (";
    strSql = strSql + ((adUserOrg==null || adUserOrg.equals(""))?"":adUserOrg);
    strSql = strSql + 
      ")" +
      "        AND 1=1";
    strSql = strSql + ((parLaunchDateFrom==null || parLaunchDateFrom.equals(""))?"":" AND wr.LAUNCHDATE > to_date(?) ");
    strSql = strSql + ((parLaunchDateTo==null || parLaunchDateTo.equals(""))?"":" AND wr.LAUNCHDATE < to_date(?) ");
    strSql = strSql + ((parStartDateFrom==null || parStartDateFrom.equals(""))?"":" AND wr.STARTDATE > to_date(?) ");
    strSql = strSql + ((parStartDateTo==null || parStartDateTo.equals(""))?"":" AND wr.STARTDATE < to_date(?) ");
    strSql = strSql + ((parEndDateFrom==null || parEndDateFrom.equals(""))?"":" AND wr.ENDDATE > to_date(?) ");
    strSql = strSql + ((parEndDateTo==null || parEndDateTo.equals(""))?"":" AND wr.ENDDATE < to_date(?) ");
    strSql = strSql + ((parWorkRequirement==null || parWorkRequirement.equals(""))?"":" AND wr.MA_WORKREQUIREMENT_ID = ? ");
    strSql = strSql + 
      "      ORDER BY wrlaunch, wr.MA_WorkRequirement_ID, wrpseq, wename, prname ";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adUserOrg != null && !(adUserOrg.equals(""))) {
        }
      if (parLaunchDateFrom != null && !(parLaunchDateFrom.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parLaunchDateFrom);
      }
      if (parLaunchDateTo != null && !(parLaunchDateTo.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parLaunchDateTo);
      }
      if (parStartDateFrom != null && !(parStartDateFrom.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parStartDateFrom);
      }
      if (parStartDateTo != null && !(parStartDateTo.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parStartDateTo);
      }
      if (parEndDateFrom != null && !(parEndDateFrom.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parEndDateFrom);
      }
      if (parEndDateTo != null && !(parEndDateTo.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parEndDateTo);
      }
      if (parWorkRequirement != null && !(parWorkRequirement.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parWorkRequirement);
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
        ReportProductionRunData objectReportProductionRunData = new ReportProductionRunData();
        objectReportProductionRunData.wrname = UtilSql.getValue(result, "WRNAME");
        objectReportProductionRunData.wrclosed = UtilSql.getValue(result, "WRCLOSED");
        objectReportProductionRunData.wrlaunch = UtilSql.getDateValue(result, "WRLAUNCH", "dd-MM-yyyy");
        objectReportProductionRunData.wrstart = UtilSql.getDateValue(result, "WRSTART", "dd-MM-yyyy");
        objectReportProductionRunData.wrend = UtilSql.getDateValue(result, "WREND", "dd-MM-yyyy");
        objectReportProductionRunData.wrpname = UtilSql.getValue(result, "WRPNAME");
        objectReportProductionRunData.wrpqty = UtilSql.getValue(result, "WRPQTY");
        objectReportProductionRunData.wrpdone = UtilSql.getValue(result, "WRPDONE");
        objectReportProductionRunData.wrpleft = UtilSql.getValue(result, "WRPLEFT");
        objectReportProductionRunData.pname = UtilSql.getValue(result, "PNAME");
        objectReportProductionRunData.wrpph = UtilSql.getValue(result, "WRPPH");
        objectReportProductionRunData.wrppt = UtilSql.getValue(result, "WRPPT");
        objectReportProductionRunData.wrpclosed = UtilSql.getValue(result, "WRPCLOSED");
        objectReportProductionRunData.prname = UtilSql.getValue(result, "PRNAME");
        objectReportProductionRunData.wename = UtilSql.getValue(result, "WENAME");
        objectReportProductionRunData.prneeded = UtilSql.getValue(result, "PRNEEDED");
        objectReportProductionRunData.prdone = UtilSql.getValue(result, "PRDONE");
        objectReportProductionRunData.prrej = UtilSql.getValue(result, "PRREJ");
        objectReportProductionRunData.wrpseq = UtilSql.getValue(result, "WRPSEQ");
        objectReportProductionRunData.wedate = UtilSql.getDateValue(result, "WEDATE", "dd-MM-yyyy");
        objectReportProductionRunData.wrid = UtilSql.getValue(result, "WRID");
        objectReportProductionRunData.wrpid = UtilSql.getValue(result, "WRPID");
        objectReportProductionRunData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportProductionRunData);
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
    ReportProductionRunData objectReportProductionRunData[] = new ReportProductionRunData[vector.size()];
    vector.copyInto(objectReportProductionRunData);
    return(objectReportProductionRunData);
  }
}
