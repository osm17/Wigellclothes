package commands;

import businessobjects.Pants;
import businessobjects.Skirt;
import businessobjects.TShirt;

public class SetColorCommand implements ProductCommand {
    private final Object product;
    private final String color;

    public SetColorCommand(Object product, String color) {
        this.product = product;
        this.color = color;
    }

    @Override
    public void execute() {
        if (product instanceof Pants) {
            ((Pants) product).setColor(color);
        } else if (product instanceof Skirt) {
            ((Skirt) product).setColor(color);
        } else if (product instanceof TShirt) {
            ((TShirt) product).setColor(color);
        }
    }
}
