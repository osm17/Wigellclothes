package commands;

import businessobjects.Pants;
import businessobjects.Skirt;
import businessobjects.TShirt;

public class SetPriceCommand implements ProductCommand {
    private final Object product;
    private final double price;

    public SetPriceCommand(Object product, double price) {
        this.product = product;
        this.price = price;
    }

    @Override
    public void execute() {
        if (product instanceof Pants) {
            ((Pants) product).setPrice(price);
        } else if (product instanceof Skirt) {
            ((Skirt) product).setPrice(price);
        } else if (product instanceof TShirt) {
            ((TShirt) product).setPrice(price);
        }
    }
}
