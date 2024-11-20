package zoo;

import zoo.actions.IEater;
import zoo.models.Animal;

import java.util.function.Consumer;

public class ZooKipaSmart {
    /**
     * а тут чтоб заработало по-умному надо заменить IEater на абстрактный класс Animal
     */
//    public void toFeedEater(IEater eater) {
//        eater.eats();
//    }
    public void toFeedEater(Animal animal, Consumer<Animal> callback) {
        callback.accept(animal);
    }
}
