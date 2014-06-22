package com.sambi.mvc.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
/**
 * @author sam-bi.com
 */
public abstract class AbstractModel {
    /**
     * The PropertyChangeSupport class is used to register, deregister,
     * and notify interested listeners of changes to the model.
     */
    protected PropertyChangeSupport propertyChangeSupport;
    public AbstractModel() {
        propertyChangeSupport = new PropertyChangeSupport(this);
    }
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }
    protected void firePropertyChange(String propertyName, Object oldValue, Object newValue) {
        propertyChangeSupport.firePropertyChange(propertyName, oldValue, newValue);
    }
}