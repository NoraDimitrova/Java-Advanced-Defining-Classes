package christmas;

import java.util.ArrayList;
import java.util.List;

public class Bag {
    private String color;
    private int capacity;
    private List<Present> data;

    public Bag(String color, int capacity) {
        this.color = color;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getColor() {
        return color;
    }

    public int getCapacity() {
        return capacity;
    }

    public int count() {
        return data.size();
    }

    public void add(Present present) {
        if (capacity > 0) {
            this.data.add(present);
            capacity--;
        }
    }

    public boolean remove(String name) {
        Present removePresent = null;
        for (Present datum : data) {
            if (datum.getName().equals(name)) {
                removePresent = datum;
            }
        }
        if (removePresent == null) {
            return false;
        } else {
            data.remove(removePresent);
            return true;
        }
    }

    public Present heaviestPresent() {
        double weightOfPresent = 0;
        Present heaviestPresent = null;

        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getWeight() > weightOfPresent) {
                weightOfPresent = data.get(i).getWeight();
                heaviestPresent = data.get(i);
            }
        }
        return heaviestPresent;
    }

    public Present getPresent(String name){
        for (Present present : data) {
            if(present.getName().equals(name)){
                return present;
            }
        }
        return null;
    }

    public String report(){
        StringBuilder builder=new StringBuilder();
        builder.append(this.color+" bag contains:").append(System.lineSeparator());
        for (Present present : data) {
            builder.append(present.toString()).append(System.lineSeparator());
        }
        return builder.toString();
    }
}
