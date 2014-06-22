package com.sambi.mvc;

import com.sambi.mvc.controller.InvoicesSearchController;
import com.sambi.mvc.model.InvoicesSearchModel;
import com.sambi.mvc.view.InvoicesSearchFrame;
/**
 * @author sam-bi.com
 */
public class MainFrame {
    public MainFrame() {
        InvoicesSearchModel invoicesSearchModel = new InvoicesSearchModel();
        InvoicesSearchController controller = new InvoicesSearchController();
        InvoicesSearchFrame propertiesViewPanel = new InvoicesSearchFrame(controller);

        controller.addView(propertiesViewPanel);
        controller.addModel(invoicesSearchModel);
        invoicesSearchModel.initDefault();
    }
    public static void main(String[] args) {
        new MainFrame();
    }
}