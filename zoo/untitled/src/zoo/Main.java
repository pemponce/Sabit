package zoo;

import zoo.animals.Lion;
import zoo.animals.Slon;
import zoo.animals.Zebra;
import zoo.models.Animal;

import java.util.ArrayList;
import java.util.function.Consumer;

public class Main {

    public static void main(String[] args) {
        Animal zebra = new Zebra();
        Animal lion = new Lion();
        Animal slon = new Slon();

        ArrayList<Animal> animals = new ArrayList<>();
        animals.add(zebra);
        animals.add(lion);
        animals.add(slon);
        ZooKipaSmart zooKipaSmart = new ZooKipaSmart();

        Consumer<Animal> feedCallback = animal -> {
            System.out.println("Кормим животное: ");
            animal.eats();
        };

        for (Animal a : animals) {
            zooKipaSmart.toFeedEater(a, feedCallback);
        }
    }
}
