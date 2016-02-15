//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.modules;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

public class ModuleReferenceDataClientTreeData implements FieldProvider {
static Logger log4j = Logger.getLogger(ModuleReferenceDataClientTreeData.class);
  private String InitRecordNumber="0";
  public String type;
  public String nodeId;
  public String name;
  public String display;
  public String defaultchecked;
  public String linkclick;
  public String linkname;
  public String description;
  public String version;
  public String statusName;
  public String status;
  public String updateAvailable;
  public String help;
  public String author;
  public String url;
  public String seqno;
  public String levelno;
  public String leveltree;
  public String icon;
  public String icon2;
  public String endline;
  public String updateversion;
  public String updatedescription;
  public String position;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("TYPE"))
      return type;
    else if (fieldName.equalsIgnoreCase("NODE_ID") || fieldName.equals("nodeId"))
      return nodeId;
    else if (fieldName.equalsIgnoreCase("NAME"))
      return name;
    else if (fieldName.equalsIgnoreCase("DISPLAY"))
      return display;
    else if (fieldName.equalsIgnoreCase("DEFAULTCHECKED"))
      return defaultchecked;
    else if (fieldName.equalsIgnoreCase("LINKCLICK"))
      return linkclick;
    else if (fieldName.equalsIgnoreCase("LINKNAME"))
      return linkname;
    else if (fieldName.equalsIgnoreCase("DESCRIPTION"))
      return description;
    else if (fieldName.equalsIgnoreCase("VERSION"))
      return version;
    else if (fieldName.equalsIgnoreCase("STATUS_NAME") || fieldName.equals("statusName"))
      return statusName;
    else if (fieldName.equalsIgnoreCase("STATUS"))
      return status;
    else if (fieldName.equalsIgnoreCase("UPDATE_AVAILABLE") || fieldName.equals("updateAvailable"))
      return updateAvailable;
    else if (fieldName.equalsIgnoreCase("HELP"))
      return help;
    else if (fieldName.equalsIgnoreCase("AUTHOR"))
      return author;
    else if (fieldName.equalsIgnoreCase("URL"))
      return url;
    else if (fieldName.equalsIgnoreCase("SEQNO"))
      return seqno;
    else if (fieldName.equalsIgnoreCase("LEVELNO"))
      return levelno;
    else if (fieldName.equalsIgnoreCase("LEVELTREE"))
      return leveltree;
    else if (fieldName.equalsIgnoreCase("ICON"))
      return icon;
    else if (fieldName.equalsIgnoreCase("ICON2"))
      return icon2;
    else if (fieldName.equalsIgnoreCase("ENDLINE"))
      return endline;
    else if (fieldName.equalsIgnoreCase("UPDATEVERSION"))
      return updateversion;
    else if (fieldName.equalsIgnoreCase("UPDATEDESCRIPTION"))
      return updatedescription;
    else if (fieldName.equalsIgnoreCase("POSITION"))
      return position;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ModuleReferenceDataClientTreeData[] select(ConnectionProvider connectionProvider, String lang)    throws ServletException {
    return select(connectionProvider, lang, 0, 0);
  }

  public static ModuleReferenceDataClientTreeData[] select(ConnectionProvider connectionProvider, String lang, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "         SELECT Type, M.AD_Module_ID as Node_ID, RPAD(AD_MODULE_IDENTIFIER(M.AD_Module_ID, ?), 90)  as Name," +
      "                 (SELECT CASE WHEN COUNT(*)>0 THEN 'block' ELSE 'none' END" +
      "                    FROM AD_Module_Dependency" +
      "                   WHERE AD_Module_ID = M.AD_Module_ID" +
      "                     AND IsIncluded = 'Y')                as display," +
      "                     AD_MODULE_CHECKED(M.AD_Module_ID)    as defaultchecked," +
      "                     '' as linkClick," +
      "                     '' as linkName," +
      "                     '' as Description," +
      "                     '' as Version," +
      "                     '' as Status_Name," +
      "                     Status," +
      "                     Update_Available," +
      "                     help," +
      "                     author," +
      "                     url," +
      "                     M.SeqNo," +
      "                     '' as levelno," +
      "                     '' as leveltree," +
      "                     '' as icon," +
      "                     '' as icon2," +
      "                     '' as endline," +
      "                     '' as updateversion," +
      "                     '' as updatedescription," +
      "                     '' as position" +
      "           FROM AD_Module M" +
      "          WHERE M.TYPE = 'M'" +
      "            AND M.ISACTIVE = 'Y'" +
      "            AND 1=1" +
      "            AND ((EXISTS (SELECT 1 FROM ad_dataset" +
      "						WHERE M.ad_module_id = AD_DATASET.ad_module_id" +
      "						AND AD_DATASET.ACCESSLEVEL IN ('3','6')" +
      "						AND AD_DATASET.EXPORTALLOWED = 'Y')" +
      "					AND M.HASREFERENCEDATA = 'Y')" +
      "					OR M.haschartofaccounts = 'Y')" +
      "          ORDER BY M.SeqNo";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lang);

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
        ModuleReferenceDataClientTreeData objectModuleReferenceDataClientTreeData = new ModuleReferenceDataClientTreeData();
        objectModuleReferenceDataClientTreeData.type = UtilSql.getValue(result, "TYPE");
        objectModuleReferenceDataClientTreeData.nodeId = UtilSql.getValue(result, "NODE_ID");
        objectModuleReferenceDataClientTreeData.name = UtilSql.getValue(result, "NAME");
        objectModuleReferenceDataClientTreeData.display = UtilSql.getValue(result, "DISPLAY");
        objectModuleReferenceDataClientTreeData.defaultchecked = UtilSql.getValue(result, "DEFAULTCHECKED");
        objectModuleReferenceDataClientTreeData.linkclick = UtilSql.getValue(result, "LINKCLICK");
        objectModuleReferenceDataClientTreeData.linkname = UtilSql.getValue(result, "LINKNAME");
        objectModuleReferenceDataClientTreeData.description = UtilSql.getValue(result, "DESCRIPTION");
        objectModuleReferenceDataClientTreeData.version = UtilSql.getValue(result, "VERSION");
        objectModuleReferenceDataClientTreeData.statusName = UtilSql.getValue(result, "STATUS_NAME");
        objectModuleReferenceDataClientTreeData.status = UtilSql.getValue(result, "STATUS");
        objectModuleReferenceDataClientTreeData.updateAvailable = UtilSql.getValue(result, "UPDATE_AVAILABLE");
        objectModuleReferenceDataClientTreeData.help = UtilSql.getValue(result, "HELP");
        objectModuleReferenceDataClientTreeData.author = UtilSql.getValue(result, "AUTHOR");
        objectModuleReferenceDataClientTreeData.url = UtilSql.getValue(result, "URL");
        objectModuleReferenceDataClientTreeData.seqno = UtilSql.getValue(result, "SEQNO");
        objectModuleReferenceDataClientTreeData.levelno = UtilSql.getValue(result, "LEVELNO");
        objectModuleReferenceDataClientTreeData.leveltree = UtilSql.getValue(result, "LEVELTREE");
        objectModuleReferenceDataClientTreeData.icon = UtilSql.getValue(result, "ICON");
        objectModuleReferenceDataClientTreeData.icon2 = UtilSql.getValue(result, "ICON2");
        objectModuleReferenceDataClientTreeData.endline = UtilSql.getValue(result, "ENDLINE");
        objectModuleReferenceDataClientTreeData.updateversion = UtilSql.getValue(result, "UPDATEVERSION");
        objectModuleReferenceDataClientTreeData.updatedescription = UtilSql.getValue(result, "UPDATEDESCRIPTION");
        objectModuleReferenceDataClientTreeData.position = UtilSql.getValue(result, "POSITION");
        objectModuleReferenceDataClientTreeData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectModuleReferenceDataClientTreeData);
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
    ModuleReferenceDataClientTreeData objectModuleReferenceDataClientTreeData[] = new ModuleReferenceDataClientTreeData[vector.size()];
    vector.copyInto(objectModuleReferenceDataClientTreeData);
    return(objectModuleReferenceDataClientTreeData);
  }

  public static ModuleReferenceDataClientTreeData[] selectSubTree(ConnectionProvider connectionProvider, String lang, String rootNode)    throws ServletException {
    return selectSubTree(connectionProvider, lang, rootNode, 0, 0);
  }

  public static ModuleReferenceDataClientTreeData[] selectSubTree(ConnectionProvider connectionProvider, String lang, String rootNode, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "          SELECT Type, AD_Module_ID as Node_ID, AD_Column_Identifier('AD_Module',AD_Module_ID, ?) as Name," +
      "                 (SELECT CASE WHEN COUNT(*)>0 THEN 'block' ELSE 'none' END" +
      "                    FROM AD_Module_Dependency" +
      "                   WHERE AD_Module_ID = M.AD_Module_ID" +
      "                     AND IsIncluded = 'Y')                as display," +
      "                     Status," +
      "                     Update_Available" +
      "            FROM AD_MODULE M" +
      "           WHERE EXISTS (SELECT 1" +
      "                           FROM AD_Module_Dependency" +
      "                          WHERE AD_Module_ID = ?" +
      "                            AND AD_Dependent_Module_ID = M.AD_Module_ID" +
      "                            AND IsIncluded = 'Y')" +
      "            AND ISACTIVE = 'Y'" +
      "            AND EXISTS (SELECT 1 FROM AD_DATASET" +
      "                        WHERE AD_DATASET.AD_MODULE_ID = M.AD_MODULE_ID" +
      "                        AND EXPORTALLOWED = 'Y')";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lang);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, rootNode);

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
        ModuleReferenceDataClientTreeData objectModuleReferenceDataClientTreeData = new ModuleReferenceDataClientTreeData();
        objectModuleReferenceDataClientTreeData.type = UtilSql.getValue(result, "TYPE");
        objectModuleReferenceDataClientTreeData.nodeId = UtilSql.getValue(result, "NODE_ID");
        objectModuleReferenceDataClientTreeData.name = UtilSql.getValue(result, "NAME");
        objectModuleReferenceDataClientTreeData.display = UtilSql.getValue(result, "DISPLAY");
        objectModuleReferenceDataClientTreeData.status = UtilSql.getValue(result, "STATUS");
        objectModuleReferenceDataClientTreeData.updateAvailable = UtilSql.getValue(result, "UPDATE_AVAILABLE");
        objectModuleReferenceDataClientTreeData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectModuleReferenceDataClientTreeData);
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
    ModuleReferenceDataClientTreeData objectModuleReferenceDataClientTreeData[] = new ModuleReferenceDataClientTreeData[vector.size()];
    vector.copyInto(objectModuleReferenceDataClientTreeData);
    return(objectModuleReferenceDataClientTreeData);
  }

  public static ModuleReferenceDataClientTreeData[] selectDescription(ConnectionProvider connectionProvider, String lang, String node)    throws ServletException {
    return selectDescription(connectionProvider, lang, node, 0, 0);
  }

  public static ModuleReferenceDataClientTreeData[] selectDescription(ConnectionProvider connectionProvider, String lang, String node, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "          SELECT M.Name," +
      "                 M.Version," +
      "                 COALESCE(T.ReferenceDataInfo, M.ReferenceDataInfo) as Description," +
      "                 COALESCE(T.help, M.Help) as Help," +
      "                 M.author," +
      "                 M.url," +
      "                 M.status," +
      "                 M.Update_Available," +
      "                 M.AD_Module_ID as Node_ID," +
      "                 COALESCE(RT.Name, R.Name) as Status_Name," +
      "                 COALESCE(T.UpdateInfo, M.UpdateInfo) as UpdateDescription," +
      "                 M.Update_Available as UpdateVersion" +
      "            FROM AD_MODULE M LEFT JOIN AD_MODULE_TRL T" +
      "                                     ON T.AD_Module_ID = M.AD_Module_ID" +
      "                                    AND T.AD_Language = ?," +
      "                 AD_REF_LIST R LEFT JOIN AD_REF_LIST_TRL RT" +
      "                                     ON RT.AD_Ref_List_ID = R.AD_Ref_list_ID" +
      "                                     AND RT.AD_Language = ?" +
      "           WHERE M.AD_Module_ID = ?" +
      "             AND R.AD_REFERENCE_ID = '725CD8C6882C40AFB4D1C27B1AEF8BB4'" +
      "             AND R.Value = M.Status";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lang);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lang);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, node);

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
        ModuleReferenceDataClientTreeData objectModuleReferenceDataClientTreeData = new ModuleReferenceDataClientTreeData();
        objectModuleReferenceDataClientTreeData.name = UtilSql.getValue(result, "NAME");
        objectModuleReferenceDataClientTreeData.version = UtilSql.getValue(result, "VERSION");
        objectModuleReferenceDataClientTreeData.description = UtilSql.getValue(result, "DESCRIPTION");
        objectModuleReferenceDataClientTreeData.help = UtilSql.getValue(result, "HELP");
        objectModuleReferenceDataClientTreeData.author = UtilSql.getValue(result, "AUTHOR");
        objectModuleReferenceDataClientTreeData.url = UtilSql.getValue(result, "URL");
        objectModuleReferenceDataClientTreeData.status = UtilSql.getValue(result, "STATUS");
        objectModuleReferenceDataClientTreeData.updateAvailable = UtilSql.getValue(result, "UPDATE_AVAILABLE");
        objectModuleReferenceDataClientTreeData.nodeId = UtilSql.getValue(result, "NODE_ID");
        objectModuleReferenceDataClientTreeData.statusName = UtilSql.getValue(result, "STATUS_NAME");
        objectModuleReferenceDataClientTreeData.updatedescription = UtilSql.getValue(result, "UPDATEDESCRIPTION");
        objectModuleReferenceDataClientTreeData.updateversion = UtilSql.getValue(result, "UPDATEVERSION");
        objectModuleReferenceDataClientTreeData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectModuleReferenceDataClientTreeData);
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
    ModuleReferenceDataClientTreeData objectModuleReferenceDataClientTreeData[] = new ModuleReferenceDataClientTreeData[vector.size()];
    vector.copyInto(objectModuleReferenceDataClientTreeData);
    return(objectModuleReferenceDataClientTreeData);
  }

  public static String selectParent(ConnectionProvider connectionProvider, String node)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "          SELECT MAX(AD_Module_ID) as Node_ID" +
      "            FROM AD_MODULE_DEPENDENCY" +
      "           WHERE AD_Dependent_Module_ID = ?" +
      "             AND IsIncluded = 'Y'";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, node);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "NODE_ID");
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
