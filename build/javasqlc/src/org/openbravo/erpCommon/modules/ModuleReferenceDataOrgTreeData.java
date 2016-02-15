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

public class ModuleReferenceDataOrgTreeData implements FieldProvider {
static Logger log4j = Logger.getLogger(ModuleReferenceDataOrgTreeData.class);
  private String InitRecordNumber="0";
  public String type;
  public String nodeId;
  public String name;
  public String display;
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
  public String updatelabel;

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
    else if (fieldName.equalsIgnoreCase("UPDATELABEL"))
      return updatelabel;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ModuleReferenceDataOrgTreeData[] select(ConnectionProvider connectionProvider, String lang, String client)    throws ServletException {
    return select(connectionProvider, lang, client, 0, 0);
  }

  public static ModuleReferenceDataOrgTreeData[] select(ConnectionProvider connectionProvider, String lang, String client, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "           SELECT M.Type, M.AD_Module_ID as Node_ID, RPAD(AD_MODULE_IDENTIFIER(M.AD_Module_ID, ?), 90) as Name," +
      "                 (SELECT CASE WHEN COUNT(*)>0 THEN 'block' ELSE 'none' END" +
      "                    FROM AD_Module_Dependency" +
      "                   WHERE AD_Module_ID = M.AD_Module_ID" +
      "                     AND IsIncluded = 'Y')                as display," +
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
      "                     '' as position," +
      "                     '' as updatelabel" +
      "            FROM AD_Module M" +
      "			WHERE M.TYPE = 'M'" +
      "			AND M.ISACTIVE = 'Y'" +
      "			AND 1=1" +
      "			AND ((EXISTS (SELECT 1 FROM ad_dataset" +
      "							WHERE M.ad_module_id = AD_DATASET.ad_module_id" +
      "							AND AD_DATASET.ACCESSLEVEL IN ('3','1')" +
      "							AND AD_DATASET.EXPORTALLOWED = 'Y'" +
      "							AND ISACTIVE = 'Y')" +
      "						AND M.HASREFERENCEDATA = 'Y')" +
      "						OR M.haschartofaccounts = 'Y')" +
      "			AND NOT EXISTS (SELECT 1 FROM AD_CLIENTMODULE CM" +
      "				    WHERE CM.ad_module_id = M.ad_module_id" +
      "				    AND AD_CLIENT_ID = ?)" +
      "			ORDER BY M.SeqNo";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lang);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);

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
        ModuleReferenceDataOrgTreeData objectModuleReferenceDataOrgTreeData = new ModuleReferenceDataOrgTreeData();
        objectModuleReferenceDataOrgTreeData.type = UtilSql.getValue(result, "TYPE");
        objectModuleReferenceDataOrgTreeData.nodeId = UtilSql.getValue(result, "NODE_ID");
        objectModuleReferenceDataOrgTreeData.name = UtilSql.getValue(result, "NAME");
        objectModuleReferenceDataOrgTreeData.display = UtilSql.getValue(result, "DISPLAY");
        objectModuleReferenceDataOrgTreeData.linkclick = UtilSql.getValue(result, "LINKCLICK");
        objectModuleReferenceDataOrgTreeData.linkname = UtilSql.getValue(result, "LINKNAME");
        objectModuleReferenceDataOrgTreeData.description = UtilSql.getValue(result, "DESCRIPTION");
        objectModuleReferenceDataOrgTreeData.version = UtilSql.getValue(result, "VERSION");
        objectModuleReferenceDataOrgTreeData.statusName = UtilSql.getValue(result, "STATUS_NAME");
        objectModuleReferenceDataOrgTreeData.status = UtilSql.getValue(result, "STATUS");
        objectModuleReferenceDataOrgTreeData.updateAvailable = UtilSql.getValue(result, "UPDATE_AVAILABLE");
        objectModuleReferenceDataOrgTreeData.help = UtilSql.getValue(result, "HELP");
        objectModuleReferenceDataOrgTreeData.author = UtilSql.getValue(result, "AUTHOR");
        objectModuleReferenceDataOrgTreeData.url = UtilSql.getValue(result, "URL");
        objectModuleReferenceDataOrgTreeData.seqno = UtilSql.getValue(result, "SEQNO");
        objectModuleReferenceDataOrgTreeData.levelno = UtilSql.getValue(result, "LEVELNO");
        objectModuleReferenceDataOrgTreeData.leveltree = UtilSql.getValue(result, "LEVELTREE");
        objectModuleReferenceDataOrgTreeData.icon = UtilSql.getValue(result, "ICON");
        objectModuleReferenceDataOrgTreeData.icon2 = UtilSql.getValue(result, "ICON2");
        objectModuleReferenceDataOrgTreeData.endline = UtilSql.getValue(result, "ENDLINE");
        objectModuleReferenceDataOrgTreeData.updateversion = UtilSql.getValue(result, "UPDATEVERSION");
        objectModuleReferenceDataOrgTreeData.updatedescription = UtilSql.getValue(result, "UPDATEDESCRIPTION");
        objectModuleReferenceDataOrgTreeData.position = UtilSql.getValue(result, "POSITION");
        objectModuleReferenceDataOrgTreeData.updatelabel = UtilSql.getValue(result, "UPDATELABEL");
        objectModuleReferenceDataOrgTreeData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectModuleReferenceDataOrgTreeData);
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
    ModuleReferenceDataOrgTreeData objectModuleReferenceDataOrgTreeData[] = new ModuleReferenceDataOrgTreeData[vector.size()];
    vector.copyInto(objectModuleReferenceDataOrgTreeData);
    return(objectModuleReferenceDataOrgTreeData);
  }

  public static ModuleReferenceDataOrgTreeData[] selectOrg(ConnectionProvider connectionProvider, String lang, String client, String org)    throws ServletException {
    return selectOrg(connectionProvider, lang, client, org, 0, 0);
  }

  public static ModuleReferenceDataOrgTreeData[] selectOrg(ConnectionProvider connectionProvider, String lang, String client, String org, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "             select distinct A.type, A.node_id, A.name, A.display, A.status, A.help, A.author, A.url, A.update_available, A.seqno from(" +
      "               SELECT m.Type, m.AD_Module_ID as Node_ID, AD_Column_Identifier('AD_Module',m.AD_Module_ID, ?) as Name," +
      "                 (SELECT CASE WHEN COUNT(*)>0 THEN 'block' ELSE 'none' END" +
      "                    FROM AD_Module_Dependency" +
      "                   WHERE AD_Module_ID = M.AD_Module_ID" +
      "                     AND IsIncluded = 'Y')                as display, m.Status, m.help, m.author, m.url," +
      "                     CASE WHEN AD_ORGMODULE.CHECKSUM NOT LIKE '%'|| AD_DATASET.CHECKSUM  ||'%' THEN 'Y' ELSE '' END AS Update_Available," +
      "                     m.seqno" +
      "           FROM AD_Module M left join AD_DATASET on M.ad_module_id = AD_DATASET.ad_module_id" +
      "			    LEFT JOIN AD_ORGMODULE ON (M.AD_MODULE_ID = AD_ORGMODULE.AD_MODULE_ID AND AD_ORGMODULE.AD_Client_ID = ? AND AD_ORGMODULE.AD_ORG_ID = ? )" +
      "          WHERE M.TYPE = 'M'" +
      "            AND M.ISACTIVE = 'Y'" +
      "            AND AD_DATASET.ISACTIVE = 'Y'" +
      "            AND 1=1" +
      "            AND M.HASREFERENCEDATA = 'Y'" +
      "            AND EXPORTALLOWED = 'Y'" +
      "            AND M.HASCHARTOFACCOUNTS = 'N'" +
      "            AND NOT EXISTS (SELECT 1 FROM AD_CLIENTMODULE CM" +
      "                            WHERE CM.ad_module_id = M.ad_module_id" +
      "                            AND CM.AD_CLIENT_ID = ?" +
      "                            AND CM.VERSION = M.VERSION)" +
      "            AND NOT EXISTS (SELECT 1 FROM AD_ORGMODULE OM" +
      "                            WHERE OM.ad_module_id = M.ad_module_id" +
      "                            AND OM.AD_CLIENT_ID = ?" +
      "                            AND (AD_IsOrgIncluded(?, OM.AD_Org_ID, OM.AD_Client_ID)<>-1" +
      "                            OR AD_IsOrgIncluded(OM.AD_Org_ID, ?, OM.AD_Client_ID)<>-1)" +
      "                            AND OM.CHECKSUM LIKE '%'|| AD_DATASET.CHECKSUM  ||'%')" +
      "            AND NOT EXISTS (SELECT 1 FROM AD_ORGMODULE OM" +
      "                            WHERE OM.ad_module_id = M.ad_module_id" +
      "                            AND OM.AD_CLIENT_ID = ?" +
      "                            AND (AD_IsOrgIncluded(OM.AD_Org_ID, ?, OM.AD_Client_ID)<>-1" +
      "                            OR AD_IsOrgIncluded(?, OM.AD_Org_ID, OM.AD_Client_ID)<>-1)" +
      "                            AND OM.ad_org_id <> ?)                            " +
      "            AND (((? <> '0') AND AD_DATASET.ACCESSLEVEL IN ('1', '3'))" +
      "                OR ((? = '0') AND AD_DATASET.ACCESSLEVEL IN ('3', '6')))) A" +
      "          ORDER BY A.SeqNo";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lang);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, org);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, org);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, org);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, org);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, org);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, org);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, org);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, org);

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
        ModuleReferenceDataOrgTreeData objectModuleReferenceDataOrgTreeData = new ModuleReferenceDataOrgTreeData();
        objectModuleReferenceDataOrgTreeData.type = UtilSql.getValue(result, "TYPE");
        objectModuleReferenceDataOrgTreeData.nodeId = UtilSql.getValue(result, "NODE_ID");
        objectModuleReferenceDataOrgTreeData.name = UtilSql.getValue(result, "NAME");
        objectModuleReferenceDataOrgTreeData.display = UtilSql.getValue(result, "DISPLAY");
        objectModuleReferenceDataOrgTreeData.status = UtilSql.getValue(result, "STATUS");
        objectModuleReferenceDataOrgTreeData.help = UtilSql.getValue(result, "HELP");
        objectModuleReferenceDataOrgTreeData.author = UtilSql.getValue(result, "AUTHOR");
        objectModuleReferenceDataOrgTreeData.url = UtilSql.getValue(result, "URL");
        objectModuleReferenceDataOrgTreeData.updateAvailable = UtilSql.getValue(result, "UPDATE_AVAILABLE");
        objectModuleReferenceDataOrgTreeData.seqno = UtilSql.getValue(result, "SEQNO");
        objectModuleReferenceDataOrgTreeData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectModuleReferenceDataOrgTreeData);
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
    ModuleReferenceDataOrgTreeData objectModuleReferenceDataOrgTreeData[] = new ModuleReferenceDataOrgTreeData[vector.size()];
    vector.copyInto(objectModuleReferenceDataOrgTreeData);
    return(objectModuleReferenceDataOrgTreeData);
  }

  public static ModuleReferenceDataOrgTreeData[] selectSubTree(ConnectionProvider connectionProvider, String lang, String rootNode)    throws ServletException {
    return selectSubTree(connectionProvider, lang, rootNode, 0, 0);
  }

  public static ModuleReferenceDataOrgTreeData[] selectSubTree(ConnectionProvider connectionProvider, String lang, String rootNode, int firstRegister, int numberRegisters)    throws ServletException {
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
      "            WHERE EXISTS (SELECT 1" +
      "                           FROM AD_Module_Dependency" +
      "                          WHERE AD_Module_ID = ?" +
      "                            AND AD_Dependent_Module_ID = M.AD_Module_ID" +
      "                            AND IsIncluded = 'Y')" +
      "            AND EXISTS (SELECT 1 FROM AD_DATASET" +
      "                        WHERE AD_DATASET.AD_MODULE_ID = M.AD_MODULE_ID" +
      "                        AND EXPORTALLOWED = 'Y'" +
      "                        AND ISACTIVE = 'Y')" +
      "             AND ISACTIVE = 'Y'";

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
        ModuleReferenceDataOrgTreeData objectModuleReferenceDataOrgTreeData = new ModuleReferenceDataOrgTreeData();
        objectModuleReferenceDataOrgTreeData.type = UtilSql.getValue(result, "TYPE");
        objectModuleReferenceDataOrgTreeData.nodeId = UtilSql.getValue(result, "NODE_ID");
        objectModuleReferenceDataOrgTreeData.name = UtilSql.getValue(result, "NAME");
        objectModuleReferenceDataOrgTreeData.display = UtilSql.getValue(result, "DISPLAY");
        objectModuleReferenceDataOrgTreeData.status = UtilSql.getValue(result, "STATUS");
        objectModuleReferenceDataOrgTreeData.updateAvailable = UtilSql.getValue(result, "UPDATE_AVAILABLE");
        objectModuleReferenceDataOrgTreeData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectModuleReferenceDataOrgTreeData);
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
    ModuleReferenceDataOrgTreeData objectModuleReferenceDataOrgTreeData[] = new ModuleReferenceDataOrgTreeData[vector.size()];
    vector.copyInto(objectModuleReferenceDataOrgTreeData);
    return(objectModuleReferenceDataOrgTreeData);
  }

  public static ModuleReferenceDataOrgTreeData[] selectDescription(ConnectionProvider connectionProvider, String lang, String node)    throws ServletException {
    return selectDescription(connectionProvider, lang, node, 0, 0);
  }

  public static ModuleReferenceDataOrgTreeData[] selectDescription(ConnectionProvider connectionProvider, String lang, String node, int firstRegister, int numberRegisters)    throws ServletException {
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
        ModuleReferenceDataOrgTreeData objectModuleReferenceDataOrgTreeData = new ModuleReferenceDataOrgTreeData();
        objectModuleReferenceDataOrgTreeData.name = UtilSql.getValue(result, "NAME");
        objectModuleReferenceDataOrgTreeData.version = UtilSql.getValue(result, "VERSION");
        objectModuleReferenceDataOrgTreeData.description = UtilSql.getValue(result, "DESCRIPTION");
        objectModuleReferenceDataOrgTreeData.help = UtilSql.getValue(result, "HELP");
        objectModuleReferenceDataOrgTreeData.author = UtilSql.getValue(result, "AUTHOR");
        objectModuleReferenceDataOrgTreeData.url = UtilSql.getValue(result, "URL");
        objectModuleReferenceDataOrgTreeData.status = UtilSql.getValue(result, "STATUS");
        objectModuleReferenceDataOrgTreeData.updateAvailable = UtilSql.getValue(result, "UPDATE_AVAILABLE");
        objectModuleReferenceDataOrgTreeData.nodeId = UtilSql.getValue(result, "NODE_ID");
        objectModuleReferenceDataOrgTreeData.statusName = UtilSql.getValue(result, "STATUS_NAME");
        objectModuleReferenceDataOrgTreeData.updatedescription = UtilSql.getValue(result, "UPDATEDESCRIPTION");
        objectModuleReferenceDataOrgTreeData.updateversion = UtilSql.getValue(result, "UPDATEVERSION");
        objectModuleReferenceDataOrgTreeData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectModuleReferenceDataOrgTreeData);
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
    ModuleReferenceDataOrgTreeData objectModuleReferenceDataOrgTreeData[] = new ModuleReferenceDataOrgTreeData[vector.size()];
    vector.copyInto(objectModuleReferenceDataOrgTreeData);
    return(objectModuleReferenceDataOrgTreeData);
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
