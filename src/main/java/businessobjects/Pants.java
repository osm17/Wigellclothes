package businessobjects;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Pants {
    private double price;
    private String color;
    private String material;
    private String type;
    private String fit;
    private PropertyChangeSupport changeSupport;

    public Pants() {
        this.changeSupport = new PropertyChangeSupport(this);
    }


    public String getMaterial() {
        return material;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setMaterial(String material) {
        this.material = material;
        changeSupport.firePropertyChange("material", null, material);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFit() {
        return fit;
    }

    public double getPrice() {
        return price;
    }

    public void setFit(String fit) {
        this.fit = fit;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    @Override
    public String toString() {
        return "Pants{" +
                "material='" + material + '\'' +
                ", type='" + type + '\'' +
                ", fit='" + fit + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                '}';
    }


}
