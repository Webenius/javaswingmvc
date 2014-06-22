package com.sambi.mvc.model;

import com.sambi.mvc.controller.InvoicesSearchController;
/**
 * @author sam-bi.com
 */
public class InvoicesSearchModel extends AbstractModel {
    private String customerId;
    private String customerName;
    private int nbInvoices;
    public void initDefault() {
        this.setCustomerId("");
        this.setCustomerName("");
        this.setNbInvoices(100);
    }
    public String getCustomerId() {
        return customerId;
    }
    public void setCustomerId(String customerId) {
        String oldCustomerId = this.customerId;
        this.customerId = customerId;
        firePropertyChange(InvoicesSearchController.CUSTOMERID_PROPERTY, oldCustomerId, customerId);
    }
    public String getCustomerName() {
        return this.customerName;
    }
    public void setCustomerName(String customerName) {
        String oldCustomerName = this.customerName;
        this.customerName = customerName;
        firePropertyChange(InvoicesSearchController.CUSTOMERNAME_PROPERTY, oldCustomerName, customerName);
    }
    public int getNbInvoices() {
        return nbInvoices;
    }
    public void setNbInvoices(int nbInvoices) {
        int oldNbInvoices = this.nbInvoices;
        this.nbInvoices = nbInvoices;
        firePropertyChange(InvoicesSearchController.NBINVOICES_PROPERTY, oldNbInvoices, nbInvoices);
    }
}