package org.example.old;

public class Parishioner implements Observer {
    private String name;

    public Parishioner(String name, Observable o) {
        this.name = name;
        o.registerObserver(this);
    }

    public void removeParishioner(String name, Observable o) {
        this.name = name;
        o.removeObserver(this);
    }

    @Override
    public void update(String news) {
        System.out.println(name + " узнал новость: " + news);
    }
}