package lab0;

import java.util.ArrayList;
import java.util.List;

public class ToDoList {
    private List<String> items = new ArrayList<>();

    public void addItem(String task) {
        items.add(task);
    }

    public List<String> getItems() {
        return items;
    }

    public void removeItem(int index) throws Exception{
        if (index < 0 || index >= this.items.size()) {
            throw new Exception("Index out of range");
        }
        this.items.remove(index);
    }
}

