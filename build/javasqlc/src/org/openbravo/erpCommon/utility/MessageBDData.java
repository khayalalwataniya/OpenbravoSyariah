//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.utility;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

class MessageBDData implements FieldProvider {
static Logger log4j = Logger.getLogger(MessageBDData.class);
  private String InitRecordNumber="0";
  public String msgtype;
  public String msgtip;
  public String msgtext;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("MSGTYPE"))
      return msgtype;
    else if (fieldName.equalsIgnoreCase("MSGTIP"))
      return msgtip;
    else if (fieldName.equalsIgnoreCase("MSGTEXT"))
      return msgtext;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static MessageBDData[] messageInfo(ConnectionProvider connectionProvider, String language, String value)    throws ServletException {
    return messageInfo(connectionProvider, language, value, 0, 0);
  }

  public static MessageBDData[] messageInfo(ConnectionProvider connectionProvider, String language, String value, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT AD_MESSAGE.MSGTYPE, COALESCE(AD_MESSAGE_TRL.MSGTIP, AD_MESSAGE.MSGTIP) AS MSGTIP, " +
      "      COALESCE(AD_MESSAGE_TRL.MSGTEXT, AD_MESSAGE.MSGTEXT) AS MSGTEXT " +
      "      FROM AD_MESSAGE left join AD_MESSAGE_TRL on AD_MESSAGE.AD_MESSAGE_ID = AD_MESSAGE_TRL.AD_MESSAGE_ID " +
      "                                              AND AD_MESSAGE_TRL.AD_LANGUAGE = ?" +
      "      WHERE UPPER(AD_MESSAGE.VALUE)=UPPER(?) " +
      "      AND AD_MESSAGE.IsActive = 'Y'";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, value);

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
        MessageBDData objectMessageBDData = new MessageBDData();
        objectMessageBDData.msgtype = UtilSql.getValue(result, "MSGTYPE");
        objectMessageBDData.msgtip = UtilSql.getValue(result, "MSGTIP");
        objectMessageBDData.msgtext = UtilSql.getValue(result, "MSGTEXT");
        objectMessageBDData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectMessageBDData);
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
    MessageBDData objectMessageBDData[] = new MessageBDData[vector.size()];
    vector.copyInto(objectMessageBDData);
    return(objectMessageBDData);
  }

  public static String message(ConnectionProvider connectionProvider, String language, String value)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "         SELECT coalesce(t.MSGTEXT, m.MSGTEXT) AS MSGTEXT " +
      "           FROM AD_MESSAGE m left join AD_MESSAGE_TRL t on m.AD_MESSAGE_ID = t.AD_MESSAGE_ID " +
      "                                   and t.AD_LANGUAGE = ?" +
      "          WHERE m.VALUE=?";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, value);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "MSGTEXT");
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

  public static String columnname(ConnectionProvider connectionProvider, String language, String value)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "     SELECT coalesce(E_TRL.NAME, E.NAME) AS NAME " +
      "      FROM AD_ELEMENT E left join AD_ELEMENT_TRL E_TRL on E.AD_ELEMENT_ID = E_TRL.AD_ELEMENT_ID " +
      "                                                      and E_TRL.AD_LANGUAGE = ?" +
      "      where E.COLUMNNAME=?";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, value);

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
}
