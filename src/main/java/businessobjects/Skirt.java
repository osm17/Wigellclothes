package businessobjects;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Skirt {
    private double price;

    private String material;
    private String color;
    private String pattern;
    private int waistline;
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    public Skirt() {

    }


    public String getMaterial() {
        return material;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    public void setMaterial(String material) {
        String oldMaterial = this.material;
        this.material = material;
        changeSupport.firePropertyChange("material", oldMaterial, material);
    }

    public double getPrice() {
        return price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        String oldColor = this.color;
        this.color = color;
        changeSupport.firePropertyChange("color", oldColor, color);
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        String oldPattern = this.pattern;
        this.pattern = pattern;
        changeSupport.firePropertyChange("pattern", oldPattern, pattern);
    }

    public int getWaistline() {
        return waistline;
    }

    public void setWaistline(int waistline) {
        int oldWaistline = this.waistline;
        this.waistline = waistline;
        changeSupport.firePropertyChange("waistline", oldWaistline, waistline);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    @Override
    public String toString() {
        return "Skirt{" +
                "material='" + material + '\'' +
                ", pattern='" + pattern + '\'' +
                ", waistline=" + waistline +
                ", color='" + color + '\'' +
                ", price=" + price +
                '}';
    }



}
