/*
 *************************************************************************
 * The contents of this file are subject to the Openbravo  Public  License
 * Version  1.1  (the  "License"),  being   the  Mozilla   Public  License
 * Version 1.1  with a permitted attribution clause; you may not  use this
 * file except in compliance with the License. You  may  obtain  a copy of
 * the License at http://www.openbravo.com/legal/license.html 
 * Software distributed under the License  is  distributed  on  an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific  language  governing  rights  and  limitations
 * under the License. 
 * The Original Code is Openbravo ERP. 
 * The Initial Developer of the Original Code is Openbravo SLU 
 * All portions are Copyright (C) 2001-2010 Openbravo SLU 
 * All Rights Reserved. 
 * Contributor(s):  ______________________________________.
 ************************************************************************
 */
package com.gai.procurement.erpCommon.ad_reports;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

import org.openbravo.base.secureApp.HttpSecureAppServlet;
import org.openbravo.base.secureApp.VariablesSecureApp;

public class Rpt_Memorandum extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;

  public void init(ServletConfig config) {
    super.init(config);
    boolHist = false;
  }
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
    VariablesSecureApp vars = new VariablesSecureApp(request);

    if (vars.commandIn("DEFAULT")) {
      String strmRequisitionId = vars.getSessionValue("Rpt_Memorandum.inpmRequisitionId_R");
      //String strDocStatus = vars.getStringParameter("inpDocstatus", ""); //tambahan
      if (strmRequisitionId.equals("")){
        strmRequisitionId = vars.getSessionValue("Rpt_Memorandum.inpmRequisitionId");
       	//strDocStatus = vars.getStringParameter("inpDocstatus", ""); //tambahan
      }
      if (log4j.isDebugEnabled())
        log4j.debug("+***********************: " + strmRequisitionId);
      printPagePartePDF(response, vars, strmRequisitionId);
    } else
      pageError(response);
  }

  private void printPagePartePDF(HttpServletResponse response, VariablesSecureApp vars,
      String strmRequisitionId) throws IOException, ServletException {
    if (log4j.isDebugEnabled())
      log4j.debug("Output: pdf");
    String strBaseDesign = getBaseDesignPath(vars.getLanguage());
    
    String strReportPath = null;
    //ubah disini
    	//strReportPath = "/com/gai/procurement/erpCommon/ad_reports/Rpt_Memorandum.jrxml"; //ubah ini
    HashMap<String, Object> parameters = new HashMap<String, Object>();
    JasperReport jasperReport;
    try {
      JasperDesign jasperDesign = JRXmlLoader.load(strBaseDesign
          + "/com/gai/procurement/erpCommon/ad_reports/Rpt_Memorandum.jrxml");
      jasperReport = JasperCompileManager.compileReport(jasperDesign);
    } catch (JRException e) {
      e.printStackTrace();
      throw new ServletException(e.getMessage());
    }

    //parameters.put("SR_LINES", jasperReportLines);
    parameters.put("REQUISITION_ID", strmRequisitionId);
    renderJR(vars, response, null, "pdf", parameters, null, null);
  }

  public String getServletInfo() {
    return "Servlet that presents the RptMRequisitions seeker";
  } // End of getServletInfo() method
}
