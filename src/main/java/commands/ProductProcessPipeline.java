package commands;

import java.util.ArrayList;
import java.util.List;

public class ProductProcessPipeline {
    private final List<ProductCommand> commands = new ArrayList<>();

    public void addCommand(ProductCommand command) {
        commands.add(command);
    }

    public void executeCommands() {
        for (ProductCommand command : commands) {
            command.execute();
        }
        commands.clear();
    }
}
