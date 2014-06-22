package com.sambi.mvc.view;

import java.beans.PropertyChangeEvent;
import javax.swing.JFrame;
/**
 * @author sam-bi.com
 */
public abstract class AbstractFrame extends JFrame {
    public abstract void modelPropertyChange(PropertyChangeEvent event);
}