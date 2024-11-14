package zoo;

import zoo.actions.IEater;
import zoo.models.Animal;

import java.util.function.Consumer;

public class ZooKipaSmart {
    /**
     * а тут чтоб заработало надо заменить IEater на абстрактный класс Animal
     */
    public void toFeedEater(Animal animal, Consumer<Animal> callback) {
        callback.accept(animal);
    }
}
