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
 * All portions are Copyright (C) 2008-2014 Openbravo SLU
 * All Rights Reserved.
 * Contributor(s):  ______________________________________.
 ************************************************************************
*/
package com.gai.journal.imp.data;

import java.math.BigDecimal;
import java.util.Date;

import org.openbravo.base.structure.ActiveEnabled;
import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.base.structure.OrganizationEnabled;
import org.openbravo.base.structure.Traceable;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.financialmgmt.accounting.coa.Element;
import org.openbravo.model.financialmgmt.accounting.coa.ElementValue;
import org.openbravo.model.financialmgmt.calendar.Period;
import org.openbravo.model.financialmgmt.calendar.Year;
/**
 * Entity class for entity GJI_FactAcct (stored in table GJI_FACTACCT).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class GJImportFactAcct extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "GJI_FACTACCT";
    public static final String ENTITY_NAME = "GJI_FactAcct";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_ACCOUNTTREE = "accountTree";
    public static final String PROPERTY_DATEACCT = "dateacct";
    public static final String PROPERTY_PERIOD = "period";
    public static final String PROPERTY_YEAR = "year";
    public static final String PROPERTY_DOCUMENTNO = "documentNo";
    public static final String PROPERTY_ACCOUNTELEMENT = "accountElement";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_DEBETAMT = "debetAmt";
    public static final String PROPERTY_CREDITAMT = "creditAmt";
    public static final String PROPERTY_PROCESSED = "processed";
    public static final String PROPERTY_JOURNALCODE = "journalCode";
    public static final String PROPERTY_ACCOUNTNO = "accountno";

    public GJImportFactAcct() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_CREATIONDATE, new Date());
        setDefaultValue(PROPERTY_UPDATED, new Date());
        setDefaultValue(PROPERTY_DATEACCT, new Date());
        setDefaultValue(PROPERTY_DEBETAMT, new BigDecimal(0));
        setDefaultValue(PROPERTY_CREDITAMT, new BigDecimal(0));
        setDefaultValue(PROPERTY_PROCESSED, false);
    }

    @Override
    public String getEntityName() {
        return ENTITY_NAME;
    }

    public String getId() {
        return (String) get(PROPERTY_ID);
    }

    public void setId(String id) {
        set(PROPERTY_ID, id);
    }

    public Client getClient() {
        return (Client) get(PROPERTY_CLIENT);
    }

    public void setClient(Client client) {
        set(PROPERTY_CLIENT, client);
    }

    public Organization getOrganization() {
        return (Organization) get(PROPERTY_ORGANIZATION);
    }

    public void setOrganization(Organization organization) {
        set(PROPERTY_ORGANIZATION, organization);
    }

    public Boolean isActive() {
        return (Boolean) get(PROPERTY_ACTIVE);
    }

    public void setActive(Boolean active) {
        set(PROPERTY_ACTIVE, active);
    }

    public Date getCreationDate() {
        return (Date) get(PROPERTY_CREATIONDATE);
    }

    public void setCreationDate(Date creationDate) {
        set(PROPERTY_CREATIONDATE, creationDate);
    }

    public User getCreatedBy() {
        return (User) get(PROPERTY_CREATEDBY);
    }

    public void setCreatedBy(User createdBy) {
        set(PROPERTY_CREATEDBY, createdBy);
    }

    public Date getUpdated() {
        return (Date) get(PROPERTY_UPDATED);
    }

    public void setUpdated(Date updated) {
        set(PROPERTY_UPDATED, updated);
    }

    public User getUpdatedBy() {
        return (User) get(PROPERTY_UPDATEDBY);
    }

    public void setUpdatedBy(User updatedBy) {
        set(PROPERTY_UPDATEDBY, updatedBy);
    }

    public Element getAccountTree() {
        return (Element) get(PROPERTY_ACCOUNTTREE);
    }

    public void setAccountTree(Element accountTree) {
        set(PROPERTY_ACCOUNTTREE, accountTree);
    }

    public Date getDateacct() {
        return (Date) get(PROPERTY_DATEACCT);
    }

    public void setDateacct(Date dateacct) {
        set(PROPERTY_DATEACCT, dateacct);
    }

    public Period getPeriod() {
        return (Period) get(PROPERTY_PERIOD);
    }

    public void setPeriod(Period period) {
        set(PROPERTY_PERIOD, period);
    }

    public Year getYear() {
        return (Year) get(PROPERTY_YEAR);
    }

    public void setYear(Year year) {
        set(PROPERTY_YEAR, year);
    }

    public String getDocumentNo() {
        return (String) get(PROPERTY_DOCUMENTNO);
    }

    public void setDocumentNo(String documentNo) {
        set(PROPERTY_DOCUMENTNO, documentNo);
    }

    public ElementValue getAccountElement() {
        return (ElementValue) get(PROPERTY_ACCOUNTELEMENT);
    }

    public void setAccountElement(ElementValue accountElement) {
        set(PROPERTY_ACCOUNTELEMENT, accountElement);
    }

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public BigDecimal getDebetAmt() {
        return (BigDecimal) get(PROPERTY_DEBETAMT);
    }

    public void setDebetAmt(BigDecimal debetAmt) {
        set(PROPERTY_DEBETAMT, debetAmt);
    }

    public BigDecimal getCreditAmt() {
        return (BigDecimal) get(PROPERTY_CREDITAMT);
    }

    public void setCreditAmt(BigDecimal creditAmt) {
        set(PROPERTY_CREDITAMT, creditAmt);
    }

    public Boolean isProcessed() {
        return (Boolean) get(PROPERTY_PROCESSED);
    }

    public void setProcessed(Boolean processed) {
        set(PROPERTY_PROCESSED, processed);
    }

    public String getJournalCode() {
        return (String) get(PROPERTY_JOURNALCODE);
    }

    public void setJournalCode(String journalCode) {
        set(PROPERTY_JOURNALCODE, journalCode);
    }

    public String getAccountno() {
        return (String) get(PROPERTY_ACCOUNTNO);
    }

    public void setAccountno(String accountno) {
        set(PROPERTY_ACCOUNTNO, accountno);
    }

}
