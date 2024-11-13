package zoo;

import zoo.animals.Lion;
import zoo.animals.Slon;
import zoo.animals.Zebra;
import zoo.models.Animal;

import java.util.ArrayList;

public class Main {
//    public static void main(String[] args) {
//        Lion lion1 = new Lion();
//        Slon slon1 = new Slon();
//        Zebra zebra1 = new Zebra();
//        Zebra zebra2 = new Zebra();
//        Zebra zebra3 = new Zebra();
//        ArrayList<IEater> eaters = new ArrayList<>();
//        eaters.add(lion1);
//        eaters.add(zebra1);
//        eaters.add(zebra2);
//        eaters.add(zebra3);
//        eaters.add(slon1);
//        ZooKipaSmart zooKipa = new ZooKipaSmart();
//        for (IEater e: eaters ) {
//            zooKipa.toFeedEater(e);
//        }
//    }

    public static void main(String[] args) {
        Animal zebra = new Zebra();
        Animal lion = new Lion();
        Animal slon = new Slon();

        ArrayList<Animal> animals = new ArrayList<>();
        animals.add(zebra);
        animals.add(lion);
        animals.add(slon);
        ZooKipaSmart zooKipaSmart = new ZooKipaSmart();
        for (Animal a : animals) {
            zooKipaSmart.toFeedEater(a);
        }
    }
}
