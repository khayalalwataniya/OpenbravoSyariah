//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.ad_forms;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

class FileImportData implements FieldProvider {
static Logger log4j = Logger.getLogger(FileImportData.class);
  private String InitRecordNumber="0";
  public String seqno;
  public String columnname;
  public String startno;
  public String endno;
  public String datatype;
  public String fieldlength;
  public String dataformat;
  public String decimalpoint;
  public String divideby100;
  public String constantvalue;
  public String callout;
  public String name;
  public String referencename;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("SEQNO"))
      return seqno;
    else if (fieldName.equalsIgnoreCase("COLUMNNAME"))
      return columnname;
    else if (fieldName.equalsIgnoreCase("STARTNO"))
      return startno;
    else if (fieldName.equalsIgnoreCase("ENDNO"))
      return endno;
    else if (fieldName.equalsIgnoreCase("DATATYPE"))
      return datatype;
    else if (fieldName.equalsIgnoreCase("FIELDLENGTH"))
      return fieldlength;
    else if (fieldName.equalsIgnoreCase("DATAFORMAT"))
      return dataformat;
    else if (fieldName.equalsIgnoreCase("DECIMALPOINT"))
      return decimalpoint;
    else if (fieldName.equalsIgnoreCase("DIVIDEBY100"))
      return divideby100;
    else if (fieldName.equalsIgnoreCase("CONSTANTVALUE"))
      return constantvalue;
    else if (fieldName.equalsIgnoreCase("CALLOUT"))
      return callout;
    else if (fieldName.equalsIgnoreCase("NAME"))
      return name;
    else if (fieldName.equalsIgnoreCase("REFERENCENAME"))
      return referencename;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static FileImportData[] select(ConnectionProvider connectionProvider, String adImpformatId)    throws ServletException {
    return select(connectionProvider, adImpformatId, 0, 0);
  }

  public static FileImportData[] select(ConnectionProvider connectionProvider, String adImpformatId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT f.SeqNo,c.ColumnName,f.StartNo,f.EndNo,f.DataType,c.FieldLength," +
      "        f.DataFormat,f.DecimalPoint,f.DivideBy100,f.ConstantValue,f.Callout, f.Name, r.name AS referenceName" +
      "        FROM AD_ImpFormat_Row f,AD_Column c, AD_Reference r" +
      "        WHERE AD_ImpFormat_ID = ?" +
      "        AND f.AD_Column_ID=c.AD_Column_ID" +
      "        AND r.AD_Reference_ID=c.AD_Reference_ID" +
      "        ORDER BY SeqNo";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adImpformatId);

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
        FileImportData objectFileImportData = new FileImportData();
        objectFileImportData.seqno = UtilSql.getValue(result, "SEQNO");
        objectFileImportData.columnname = UtilSql.getValue(result, "COLUMNNAME");
        objectFileImportData.startno = UtilSql.getValue(result, "STARTNO");
        objectFileImportData.endno = UtilSql.getValue(result, "ENDNO");
        objectFileImportData.datatype = UtilSql.getValue(result, "DATATYPE");
        objectFileImportData.fieldlength = UtilSql.getValue(result, "FIELDLENGTH");
        objectFileImportData.dataformat = UtilSql.getValue(result, "DATAFORMAT");
        objectFileImportData.decimalpoint = UtilSql.getValue(result, "DECIMALPOINT");
        objectFileImportData.divideby100 = UtilSql.getValue(result, "DIVIDEBY100");
        objectFileImportData.constantvalue = UtilSql.getValue(result, "CONSTANTVALUE");
        objectFileImportData.callout = UtilSql.getValue(result, "CALLOUT");
        objectFileImportData.name = UtilSql.getValue(result, "NAME");
        objectFileImportData.referencename = UtilSql.getValue(result, "REFERENCENAME");
        objectFileImportData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectFileImportData);
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
    FileImportData objectFileImportData[] = new FileImportData[vector.size()];
    vector.copyInto(objectFileImportData);
    return(objectFileImportData);
  }

  public static FileImportData[] set()    throws ServletException {
    FileImportData objectFileImportData[] = new FileImportData[1];
    objectFileImportData[0] = new FileImportData();
    objectFileImportData[0].seqno = "";
    objectFileImportData[0].columnname = "";
    objectFileImportData[0].startno = "";
    objectFileImportData[0].endno = "";
    objectFileImportData[0].datatype = "";
    objectFileImportData[0].fieldlength = "";
    objectFileImportData[0].dataformat = "";
    objectFileImportData[0].decimalpoint = "";
    objectFileImportData[0].divideby100 = "";
    objectFileImportData[0].constantvalue = "";
    objectFileImportData[0].callout = "";
    objectFileImportData[0].name = "";
    objectFileImportData[0].referencename = "";
    return objectFileImportData;
  }

  public static int insert(Connection conn, ConnectionProvider connectionProvider, String tableName, String fieldId, String valueId, String client, String org, String user)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        INSERT INTO ";
    strSql = strSql + ((tableName==null || tableName.equals(""))?"":tableName);
    strSql = strSql + 
      " (";
    strSql = strSql + ((fieldId==null || fieldId.equals(""))?"":fieldId);
    strSql = strSql + 
      ", ad_client_id, ad_org_id, created, createdby, updated, updatedby)" +
      "        VALUES(?, ?, ?, now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (tableName != null && !(tableName.equals(""))) {
        }
      if (fieldId != null && !(fieldId.equals(""))) {
        }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, valueId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, org);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user);

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

  public static int update(Connection conn, ConnectionProvider connectionProvider, String tableName, String fields, String values)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE ";
    strSql = strSql + ((tableName==null || tableName.equals(""))?"":tableName);
    strSql = strSql + 
      " SET ";
    strSql = strSql + ((fields==null || fields.equals(""))?"":fields);
    strSql = strSql + 
      "        WHERE ";
    strSql = strSql + ((values==null || values.equals(""))?"":values);

    int updateCount = 0;
    Statement st = null;

    try {
    st = connectionProvider.getStatement(conn);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (tableName != null && !(tableName.equals(""))) {
        }
      if (fields != null && !(fields.equals(""))) {
        }
      if (values != null && !(values.equals(""))) {
        }

      updateCount = st.executeUpdate(strSql);
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releaseTransactionalStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(updateCount);
  }

  public static String table(ConnectionProvider connectionProvider, String adImpformatId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT t.TableName" +
      "      FROM AD_Table t" +
      "      WHERE t.AD_Table_ID in (SELECT ad_table_id FROM AD_ImpFormat WHERE ad_impformat_id = ?)";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adImpformatId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "TABLENAME");
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

  public static String parseDate(ConnectionProvider connectionProvider, String text, String format)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      select to_char(to_date(?, 'dd/mm/yyyy hh24:mi:ss'), ?) AS FIELD from dual";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, text);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, format);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "FIELD");
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

  public static String selectSeparator(ConnectionProvider connectionProvider, String impFormat)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT FORMATTYPE FROM AD_IMPFORMAT" +
      "      WHERE AD_IMPFORMAT_ID = ? ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, impFormat);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "FORMATTYPE");
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
