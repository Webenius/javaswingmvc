package com.sambi.mvc.controller;

import java.util.regex.Pattern;
/**
 * @author sam-bi.com
 */
public class InvoicesSearchController extends AbstractController {
    /**
     * properties constants called by the GUI event listeners of the view.
     */
    public static final String CUSTOMERID_PROPERTY   = "CustomerId";
    public static final String CUSTOMERNAME_PROPERTY = "CustomerName";
    public static final String NBINVOICES_PROPERTY   = "NbInvoices";
    /**
     * methods called by the GUI event listeners of the view.
     */
    public void changeCustomerId(String newCustomerId) {
        setModelProperty(CUSTOMERID_PROPERTY, newCustomerId);
    }
    public void changeCustomerName(String newCustomerName) {
        setModelProperty(CUSTOMERNAME_PROPERTY, newCustomerName);
    }
    public void changeNbInvoices(int newNbInvoices) {
        setModelProperty(NBINVOICES_PROPERTY, newNbInvoices);
    }
    public boolean validateParameters(String customerId, String nbInvoices){
        return this.validateCustomerId(customerId) && this.validateNbInvoices(nbInvoices);
    }
    public boolean validateCustomerId(String customerId){
        //customerId: alphanumeric
        return Pattern.matches("[a-zA-Z0-9]+", customerId) && (customerId.length() <= 11);
    }
    public boolean validateNbInvoices(String nbInvoices){
        // 0 <= nbInvoices <= 99 999
        return Pattern.matches("\\d+", nbInvoices) && (nbInvoices.length() <= 5);
    }
}