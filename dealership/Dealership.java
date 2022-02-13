package dealership;

import java.util.ArrayList;
import java.util.List;

public class Dealership {
    private String name;
    private int capacity;
    private List<Car> data;

    public Dealership(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Car car) {
        if (capacity > 0) {
            this.data.add(car);
            capacity--;
        }
    }

    public boolean buy(String manufacturer, String model) {
        Car carToRemove = null;
        for (Car car : data) {
            if (car.getModel().equals(model) && car.getManufacturer().equals(manufacturer)) {
                carToRemove = car;
            }
        }
        if (carToRemove == null) {
            return false;
        } else {
            data.remove(carToRemove);
            return true;
        }
    }

    public Car getLatestCar() {
        int latestCarByYear = 0;
        Car oldestCar = null;
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getYear() > latestCarByYear) {
                latestCarByYear = data.get(i).getYear();
                oldestCar = data.get(i);
            }
        }
        return oldestCar;
    }

    public Car getCar(String manufacturer, String model) {
        for (Car car : data) {
            if (car.getModel().equals(model) && car.getManufacturer().equals(manufacturer)) {
                return car;
            }
        }
        return null;
    }

    public int getCount() {
        return data.size();
    }

    public String getStatistics() {
        StringBuilder builder = new StringBuilder();
        builder.append(" The cars are in a car dealership " + name + ":").append(System.lineSeparator());
        for (Car car : data) {
            builder.append(car.toString()).append(System.lineSeparator());
        }
        return builder.toString();
    }
}
