package web.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService{
    private List<Car> cars;

    {
        cars = new ArrayList<>();
        cars.add(new Car(1, "BMW", 55000));
        cars.add(new Car(2, "Mercedes", 57000));
        cars.add(new Car(3, "Tesla", 105000));
        cars.add(new Car(4, "Porsche", 75000));
        cars.add(new Car(5, "Lexus", 42000));
    }

    @Override
    public List<Car> index() {
        return cars;
    }

    public List<Car> show(int count) {
        return cars.stream().limit(count).collect(Collectors.toList());
    }
}
