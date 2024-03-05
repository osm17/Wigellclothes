package builders;

import businessobjects.Skirt;
import java.beans.PropertyChangeListener;

public class SkirtBuilder {
    private Skirt skirt = new Skirt();

    public SkirtBuilder() {}

    public SkirtBuilder(PropertyChangeListener listener) {
        if (listener != null) {
            skirt.addPropertyChangeListener(listener);
        }
    }

    public SkirtBuilder addMaterial(String material) {
        skirt.setMaterial(material);
        return this;
    }

    public SkirtBuilder addPrice(double price) {
        skirt.setPrice(price);
        return this;
    }

    public SkirtBuilder addColor(String color) {
        skirt.setColor(color);
        return this;
    }

    public SkirtBuilder addPattern(String pattern) {
        skirt.setPattern(pattern);
        return this;
    }

    public SkirtBuilder addWaistline(int waistline) {
        skirt.setWaistline(waistline);
        return this;
    }

    public Skirt build() {
        return skirt;
    }
}
