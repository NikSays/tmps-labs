package lab0;

import java.util.ArrayList;
import java.util.List;

public class ToDoList {
    private final List<String> items = new ArrayList<>();

    public void addItem(String task) {
        this.items.add(task);
    }

    public List<String> getItems() {
        return this.items;
    }

    public void removeItem(int index) throws Exception {
        if (index < 0 || index >= this.items.size()) {
            throw new Exception("Index out of range");
        }
        this.items.remove(index);
    }
}

