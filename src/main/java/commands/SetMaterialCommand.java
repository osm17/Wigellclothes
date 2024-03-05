package commands;

import businessobjects.Pants;
import businessobjects.Skirt;
import businessobjects.TShirt;

public class SetMaterialCommand implements ProductCommand {
    private final Object product;
    private final String material;

    public SetMaterialCommand(Object product, String material) {
        this.product = product;
        this.material = material;
    }

    @Override
    public void execute() {
        if (product instanceof Pants) {
            ((Pants) product).setMaterial(material);
        } else if (product instanceof Skirt) {
            ((Skirt) product).setMaterial(material);
        } else if (product instanceof TShirt) {
            ((TShirt) product).setMaterial(material);
        }
    }
}
