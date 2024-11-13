package zoo;

import zoo.actions.IEater;
import zoo.models.Animal;

public class ZooKipaSmart {
    /**
     * а тут чтоб заработало по-умному надо заменить IEater на абстрактный класс Animal
     */
//    public void toFeedEater(IEater eater) {
//        eater.eats();
//    }

    public void toFeedEater(Animal animal) {
        animal.eats();
    }
}
