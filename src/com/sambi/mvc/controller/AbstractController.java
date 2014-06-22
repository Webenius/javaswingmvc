package com.sambi.mvc.controller;

import com.sambi.mvc.model.AbstractModel;
import com.sambi.mvc.view.AbstractFrame;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
/**
 * @author sam-bi.com
 */
public abstract class AbstractController implements PropertyChangeListener {
    private ArrayList registeredViews;
    private ArrayList registeredModels;
    public AbstractController() {
        registeredViews = new ArrayList<>();
        registeredModels = new ArrayList<>();
    }
    public void addModel(AbstractModel model) {
        registeredModels.add(model);
        model.addPropertyChangeListener(this);
    }
    public void removeModel(AbstractModel model) {
        registeredModels.remove(model);
        model.removePropertyChangeListener(this);
    }
    public void addView(AbstractFrame view) {
        registeredViews.add(view);
    }
    public void removeView(AbstractFrame view) {
        registeredViews.remove(view);
    }
    @Override
    public void propertyChange(PropertyChangeEvent event) {
        for (AbstractFrame view: registeredViews) {
            view.modelPropertyChange(event);
        }
    }
    protected void setModelProperty(String propertyName, Object newValue) {
        for (AbstractModel model: registeredModels) {
            try {
                Method method = model.getClass().getMethod("set" + propertyName, new Class[] { newValue.getClass() });
                method.invoke(model, newValue);
            } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                System.err.println(ex.getMessage());
            }
        }
    }
}