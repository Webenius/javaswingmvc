package com.sambi.mvc.view;

import com.sambi.mvc.controller.InvoicesSearchController;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.beans.PropertyChangeEvent;
import javax.swing.*;
/**
 * @author sam-bi.com
 */
public class InvoicesSearchFrame extends AbstractFrame {
    private InvoicesSearchController controller;
    private JPanel jPanel;
    private JLabel jLCustomerId;
    private JTextField jTCustomerId;
    private JLabel jLCustomerName;
    private JTextField jTCustomerName;
    private JLabel jLNbInvoices;
    private JTextField jTNbInvoices;
    private JButton jBSearch;
    private JButton jBCancel;
    /**
     * Creates new form PropertiesViewPanel
     * @param controller the controller used by this view to process GUI actions
     */
    public InvoicesSearchFrame(InvoicesSearchController controller) {
        this.controller = controller;
        initComponents();
    }
    /**
     * @param event The property change event
     */
    @Override
    public void modelPropertyChange(final PropertyChangeEvent event) {
        switch (event.getPropertyName()) {
            case InvoicesSearchController.CUSTOMERID_PROPERTY: {
                String newStringValue = event.getNewValue().toString();
                if (!jTCustomerId.getText().equals(newStringValue)) {
                    jTCustomerId.setText(newStringValue);
                }
                break;
            }
            case InvoicesSearchController.CUSTOMERNAME_PROPERTY: {
                String newStringValue = event.getNewValue().toString();
                if (!jTCustomerName.getText().equals(newStringValue)) {
                    jTCustomerName.setText(newStringValue);
                }
                break;
            }
            case InvoicesSearchController.NBINVOICES_PROPERTY: {
                int newIntegerValue = (Integer) event.getNewValue();
                if (Integer.parseInt(jTNbInvoices.getText()) != newIntegerValue) {
                    jTNbInvoices.setText(newIntegerValue + "");
                }
                break;
            }
            default:
                break;
        }
    }
    private void initComponents() {
        jPanel         = new JPanel();
        jLCustomerId   = new JLabel("Kundennummer:");
        jTCustomerId   = new JTextField("");
        jLCustomerName = new JLabel("Kundenname: ");
        jTCustomerName = new JTextField("");
        jLNbInvoices   = new JLabel("Anzahl der Rechnungen:");
        jTNbInvoices   = new JTextField("100");
        jBSearch       = new JButton("Suchen");
        jBCancel       = new JButton("Abbrechen");
        jTCustomerId.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                jTCustomerIdActionPerformed(event);
            }
        });
        jTCustomerId.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusLost(FocusEvent event) {
                jTCustomerIdFocusLost(event);
            }
            @Override
            public void focusGained(FocusEvent event) {
                jTCustomerIdFocusGained(event);
            }
        });
        jTCustomerName.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                jTCustomerNameActionPerformed(event);
            }
        });
        jTCustomerName.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusLost(FocusEvent event) {
                jTCustomerNameFocusLost(event);
            }
        });
        jTNbInvoices.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                jTNbInvoicesActionPerformed(event);
            }
        });
        jTNbInvoices.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusLost(FocusEvent event) {
                jTNbInvoicesFocusLost(event);
            }
            @Override
            public void focusGained(FocusEvent event) {
                jTNbInvoicesFocusGained(event);
            }
        });
        jBSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                jBSearchActionPerformed(event);
            }
        });
        jBCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                jBCancelActionPerformed(event);
            }
        });
        jPanel.setLayout(null);
        Insets insets = jPanel.getInsets();
        // Label Customer Id
        Dimension size = jLCustomerId.getPreferredSize();
        jLCustomerId.setBounds(25 + insets.left, 55 + insets.top, size.width, size.height);
        jPanel.add(jLCustomerId);
        //--TextField Customer Id
        size = jTCustomerId.getPreferredSize();
        jTCustomerId.setBounds(170, 55 + insets.top, 100, size.height);
        jPanel.add(jTCustomerId);
        //--Label Customer Name
        size = jLCustomerName.getPreferredSize();
        jLCustomerName.setBounds(25 + insets.left, 90 + insets.top, size.width, size.height);
        jPanel.add(jLCustomerName);
        //--Textfield Customer Name
        size = jTCustomerName.getPreferredSize();
        jTCustomerName.setBounds(170, 90 + insets.top, 200, size.height);
        jPanel.add(jTCustomerName);
        //--Label Nb Invoices
        size = jLNbInvoices.getPreferredSize();
        jLNbInvoices.setBounds(25 + insets.left, 125 + insets.top, size.width, size.height);
        jPanel.add(jLNbInvoices);
        //--Textfield Nb Invoices
        size = jTNbInvoices.getPreferredSize();
        jTNbInvoices.setBounds(170, 125 + insets.top, 100, size.height);
        jPanel.add(jTNbInvoices);
        //--Button "Search"
        size = jBSearch.getPreferredSize();
        jBSearch.setBounds(100 + insets.left, 200 + insets.top, size.width, size.height);
        jPanel.add(jBSearch);
        //--Button "Cancel"
        size = jBCancel.getPreferredSize();
        jBCancel.setBounds(200 + insets.left, 200 + insets.top, size.width, size.height);
        jPanel.add(jBCancel);
        this.setTitle("Rechnungen Suche");
        this.getContentPane().add(jPanel);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.pack();
        this.setSize(400, 300);
        this.setLocation(200, 200);
        this.setVisible(true);
    }
    //----Customer ID
    private void jTCustomerIdFocusLost(FocusEvent event) {
        System.out.println("Kundennummer: " + jTCustomerId.getText());
        this.repaint(); // refresh the frame
        controller.changeCustomerId(jTCustomerId.getText());
    }
    private void jTCustomerIdFocusGained(FocusEvent event) {
        if(controller.validateCustomerId(jTCustomerId.getText())){
            jTCustomerId.setForeground(new Color(0, 0, 0));
        }
    }
    private void jTCustomerIdActionPerformed(ActionEvent event) {
        controller.changeCustomerId(jTCustomerId.getText());
    }
    //----Customer Name
    private void jTCustomerNameFocusLost(FocusEvent event) {
        System.out.println("Kunden Name: " + jTCustomerName.getText());
        this.repaint(); // refresh the frame
        controller.changeCustomerName(jTCustomerName.getText());
    }
    private void jTCustomerNameActionPerformed(ActionEvent event) {
        controller.changeCustomerName(jTCustomerName.getText());
    }
    //----NbInvoices
    private void jTNbInvoicesFocusLost(FocusEvent event) {
        controller.changeNbInvoices(Integer.parseInt(jTNbInvoices.getText()));
    }
    private void jTNbInvoicesFocusGained(FocusEvent event) {
        if(controller.validateNbInvoices(jTNbInvoices.getText())){
            jTNbInvoices.setForeground(new Color(0, 0, 0));
        }
    }
    private void jTNbInvoicesActionPerformed(ActionEvent event) {
        controller.changeNbInvoices(Integer.parseInt(jTNbInvoices.getText()));
    }
    private void jBSearchActionPerformed(ActionEvent event) {
        boolean valid = controller.validateParameters(jTCustomerId.getText(), jTNbInvoices.getText());
        System.out.println("valid: " + valid);
        if (valid) {
            this.setVisible(false);
            dispose(); // destroy the JFrame object
            System.exit(0);
        } else {
            if (!controller.validateCustomerId(jTCustomerId.getText())) {
                jTCustomerId.setForeground(new Color(255, 0, 0));
                System.out.println("Kundennummer ist falsch");
            }
            if (!controller.validateNbInvoices(jTNbInvoices.getText())) {
                jTNbInvoices.setForeground(new Color(255, 0, 0));
                System.out.println("Anzahl der Rechnungen ist falsch");
            }
        }
    }
    private void jBCancelActionPerformed(ActionEvent event) {
        this.setVisible(false);
        dispose(); // destroy the JFrame object
        System.exit(0);
    }
}