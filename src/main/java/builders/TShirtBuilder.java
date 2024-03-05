package builders;

import businessobjects.TShirt;
import java.beans.PropertyChangeListener;

public class TShirtBuilder {
    private TShirt tShirt = new TShirt();

    public TShirtBuilder(PropertyChangeListener listener) {
        if (listener != null) {
            tShirt.addPropertyChangeListener(listener);
        }
    }

    public TShirtBuilder addMaterial(String material) {
        tShirt.setMaterial(material);
        return this;
    }

    public TShirtBuilder addColor(String color) {
        tShirt.setColor(color);
        return this;
    }

    public TShirtBuilder addPrice(double price) {
        tShirt.setPrice(price);
        return this;
    }

    public TShirtBuilder addSleeve(int sleeves) {
        tShirt.setSleeves(sleeves);
        return this;
    }

    public TShirtBuilder addNeck(int neck) {
        tShirt.setNeck(neck);
        return this;
    }

    public TShirt build() {
        return tShirt;
    }
}
