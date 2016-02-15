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

class EditCCPMeasureValuesValuesData implements FieldProvider {
static Logger log4j = Logger.getLogger(EditCCPMeasureValuesValuesData.class);
  private String InitRecordNumber="0";
  public String measurehour;
  public String name;
  public String value;
  public String identific;
  public String seqno;
  public String valueid;
  public String type;
  public String valuec;
  public String validatetype;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("MEASUREHOUR"))
      return measurehour;
    else if (fieldName.equalsIgnoreCase("NAME"))
      return name;
    else if (fieldName.equalsIgnoreCase("VALUE"))
      return value;
    else if (fieldName.equalsIgnoreCase("IDENTIFIC"))
      return identific;
    else if (fieldName.equalsIgnoreCase("SEQNO"))
      return seqno;
    else if (fieldName.equalsIgnoreCase("VALUEID"))
      return valueid;
    else if (fieldName.equalsIgnoreCase("TYPE"))
      return type;
    else if (fieldName.equalsIgnoreCase("VALUEC"))
      return valuec;
    else if (fieldName.equalsIgnoreCase("VALIDATETYPE"))
      return validatetype;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static EditCCPMeasureValuesValuesData[] select(ConnectionProvider connectionProvider, String maMeasureGroupId)    throws ServletException {
    return select(connectionProvider, maMeasureGroupId, 0, 0);
  }

  public static EditCCPMeasureValuesValuesData[] select(ConnectionProvider connectionProvider, String maMeasureGroupId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        select measurehour, name, max(value) as value, identific, seqno, valueid, type, valuec, validatetype" +
      "        from (" +
      "            select t.MEASUREHOUR, v.seqno, c.name || (CASE c.CRITICAL WHEN 'Y' THEN ' (PC)' ELSE '' END) AS name, COALESCE((CASE v.VALUETYPE WHEN 'N' THEN TO_CHAR(v_number) WHEN " +
      "                'C' THEN 'Y' ELSE TO_CHAR(v_string) END),' ') AS value, 0 as identific, v.MA_Measure_Values_ID as valueid, (CASE v.VALUETYPE WHEN 'C' THEN 'checkbox' ELSE 'text' END) as type, (CASE v.VALUETYPE WHEN 'N' THEN 'number' ELSE '' END) as validatetype, v_char as valuec" +
      "            from MA_MEASURE_TIME t, MA_MEASURE_VALUES v, MA_CCP c" +
      "            where t.MA_MEASURE_TIME_ID = v.MA_MEASURE_TIME_ID" +
      "              and v.MA_CCP_ID = c.MA_CCP_ID " +
      "              and t.MA_MEASURE_GROUP_ID = ?" +
      "            union all" +
      "              select to_date('31/12/9999'), v.seqno, c.name || (CASE c.CRITICAL WHEN 'Y' THEN ' (PC)' ELSE '' END) AS name, ' ' as value, identific, '0' as valueid, 'hidden' as type,  'hidden' as validatetype, 'N' as valuec" +
      "              from ma_measure_time t, ma_measure_values v, ma_ccp c, " +
      "                (select VALUE-1 as identific from ad_INTEGER " +
      "                 where VALUE<=(" +
      "                   select 10-count(*) from MA_Measure_time" +
      "                   where ma_measure_group_id=?)) AAA" +
      "              where t.ma_measure_group_id = ?" +
      "                and t.MA_MEASURE_TIME_ID = v.MA_MEASURE_TIME_ID" +
      "                and v.MA_CCP_ID = c.MA_CCP_ID" +
      "        ) AA" +
      "        group by  seqno,measurehour, name, identific, valueid, type, valuec, validatetype" +
      "        order by seqno, name, measurehour";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMeasureGroupId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMeasureGroupId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMeasureGroupId);

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
        EditCCPMeasureValuesValuesData objectEditCCPMeasureValuesValuesData = new EditCCPMeasureValuesValuesData();
        objectEditCCPMeasureValuesValuesData.measurehour = UtilSql.getDateValue(result, "MEASUREHOUR", "dd-MM-yyyy");
        objectEditCCPMeasureValuesValuesData.name = UtilSql.getValue(result, "NAME");
        objectEditCCPMeasureValuesValuesData.value = UtilSql.getValue(result, "VALUE");
        objectEditCCPMeasureValuesValuesData.identific = UtilSql.getValue(result, "IDENTIFIC");
        objectEditCCPMeasureValuesValuesData.seqno = UtilSql.getValue(result, "SEQNO");
        objectEditCCPMeasureValuesValuesData.valueid = UtilSql.getValue(result, "VALUEID");
        objectEditCCPMeasureValuesValuesData.type = UtilSql.getValue(result, "TYPE");
        objectEditCCPMeasureValuesValuesData.valuec = UtilSql.getValue(result, "VALUEC");
        objectEditCCPMeasureValuesValuesData.validatetype = UtilSql.getValue(result, "VALIDATETYPE");
        objectEditCCPMeasureValuesValuesData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectEditCCPMeasureValuesValuesData);
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
    EditCCPMeasureValuesValuesData objectEditCCPMeasureValuesValuesData[] = new EditCCPMeasureValuesValuesData[vector.size()];
    vector.copyInto(objectEditCCPMeasureValuesValuesData);
    return(objectEditCCPMeasureValuesValuesData);
  }
}