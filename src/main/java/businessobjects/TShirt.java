package businessobjects;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class TShirt {
    private double price;

    private String material;
    private String color;
    private int sleeves;
    private int neck;
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    public TShirt() {
        // Constructor logic if needed
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

    public String getColor() {
        return color;
    }

    public double getPrice() {
        return price;
    }

    public void setColor(String color) {
        String oldColor = this.color;
        this.color = color;
        changeSupport.firePropertyChange("color", oldColor, color);
    }

    public int getSleeves() {
        return sleeves;
    }

    public void setSleeves(int sleeves) {
        int oldSleeves = this.sleeves;
        this.sleeves = sleeves;
        changeSupport.firePropertyChange("sleeves", oldSleeves, sleeves);
    }

    public int getNeck() {
        return neck;
    }

    public void setNeck(int neck) {
        int oldNeck = this.neck;
        this.neck = neck;
        changeSupport.firePropertyChange("neck", oldNeck, neck);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    @Override
    public String toString() {
        return "TShirt{" +
                "material='" + material + '\'' +
                ", sleeves=" + sleeves +
                ", neck=" + neck +
                ", color='" + color + '\'' +
                ", price=" + price +
                '}';
    }


}
