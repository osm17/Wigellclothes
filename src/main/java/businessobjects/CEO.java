package businessobjects;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class CEO implements PropertyChangeListener {
    private String name;
    private PropertyChangeSupport support;

    public CEO(String name) {
        this.name = name;
        this.support = new PropertyChangeSupport(this);
    }


    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        System.out.println("Notification to CEO " + name + ": Property '" + evt.getPropertyName() + "' changed from " + evt.getOldValue() + " to " + evt.getNewValue() + ".");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void notifyChange(String propertyName, Object oldValue, Object newValue) {
        support.firePropertyChange(propertyName, oldValue, newValue);
    }


    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }


}
