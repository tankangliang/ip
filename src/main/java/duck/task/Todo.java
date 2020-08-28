package duck.task;

import duck.ui.Colour;

/**
 * Todo class for representing the todo type.
 */
public class Todo extends Task {
    public Todo(String description) {
        super(description);
    }

    @Override
    public String getStatus() {
        return Colour.Yellow("[T]") + super.getStatus();
    }
}
