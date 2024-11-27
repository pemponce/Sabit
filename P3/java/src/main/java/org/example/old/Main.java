package org.example.old;

public class Main {
    public static void main(String[] args) {
        var catholicChurch = new CatholicChurch();

        Parishioner parishioner = new Parishioner("Мартин Лютер", catholicChurch);

        parishioner.removeParishioner("Мартин Лютер", catholicChurch);

        new Parishioner("Жан Кальвин", catholicChurch);


        catholicChurch.setNewsChurch("ASDASF");
    }
}