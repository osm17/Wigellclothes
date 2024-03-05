package builders;

import businessobjects.Pants;
import java.beans.PropertyChangeListener;

public class PantsBuilder {
    private Pants pants = new Pants();

    public PantsBuilder() {}

    public PantsBuilder(PropertyChangeListener listener) {
        if (listener != null) {
            pants.addPropertyChangeListener(listener);
        }
    }



    public PantsBuilder addMaterial(String material) {
        pants.setMaterial(material);
        return this;
    }

    public PantsBuilder addPrice(double price) {
        pants.setPrice(price);
        return this;
    }
    public PantsBuilder addType(String type) {
        pants.setType(type);
        return this;
    }

    public PantsBuilder addFit(String fit) {
        pants.setFit(fit);
        return this;
    }

    public Pants build() {
        return pants;
    }
}
