package optional;

import java.util.Optional;


/**
 * @author hum
 */
public class Person {

    private Optional<Car> car;

    public Optional<Car> getCar() {
        return this.car;
    }
}
