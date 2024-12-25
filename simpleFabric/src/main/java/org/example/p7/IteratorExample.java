package org.example.p7;

interface Iterator<T> {

    boolean hasNext();

    T next();
}

class DinerMenuIterator implements Iterator<String> {

    private final String[] items;
    private int position = 0;

    public DinerMenuIterator(String[] items) {
        this.items = items;
    }

    @Override
    public boolean hasNext() {
        return position < items.length && items[position] != null;
    }

    @Override
    public String next() {
        return items[position++];
    }
}

class PancakeHouseMenuIterator implements Iterator<String> {

    private final java.util.List<String> items;
    private int position = 0;

    public PancakeHouseMenuIterator(java.util.List<String> items) {
        this.items = items;
    }

    @Override
    public boolean hasNext() {
        return position < items.size();
    }

    @Override
    public String next() {
        return items.get(position++);
    }
}

interface Menu {

    Iterator<String> createIterator();
}

class DinerMenu implements Menu {

    private static final int MAX_ITEMS = 6;
    private final String[] menuItems;
    private int numberOfItems = 0;

    public DinerMenu() {
        menuItems = new String[MAX_ITEMS];
        addItem("Vegetarian BLT");
        addItem("BLT");
        addItem("Soup of the day");
        addItem("Hotdog");
    }

    public void addItem(String item) {
        if (numberOfItems < MAX_ITEMS) {
            menuItems[numberOfItems++] = item;
        }
    }

    @Override
    public Iterator<String> createIterator() {
        return new DinerMenuIterator(menuItems);
    }
}

class PancakeHouseMenu implements Menu {

    private final java.util.List<String> menuItems;

    public PancakeHouseMenu() {
        menuItems = new java.util.ArrayList<>();
        addItem("K&B’s Pancake Breakfast");
        addItem("Regular Pancake Breakfast");
        addItem("Blueberry Pancakes");
        addItem("Waffles");
    }

    public void addItem(String item) {
        menuItems.add(item);
    }

    @Override
    public Iterator<String> createIterator() {
        return new PancakeHouseMenuIterator(menuItems);
    }
}

class Waitress {

    private final Menu pancakeHouseMenu;
    private final Menu dinerMenu;

    public Waitress(Menu pancakeHouseMenu, Menu dinerMenu) {
        this.pancakeHouseMenu = pancakeHouseMenu;
        this.dinerMenu = dinerMenu;
    }

    public void printMenu() {
        Iterator<String> pancakeIterator = pancakeHouseMenu.createIterator();
        Iterator<String> dinerIterator = dinerMenu.createIterator();

        System.out.println("MENU\n----\nBREAKFAST");
        printMenu(pancakeIterator);
        System.out.println("\nLUNCH");
        printMenu(dinerIterator);
    }

    private void printMenu(Iterator<String> iterator) {
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}

public class IteratorExample {

    public static void main(String[] args) {
        PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu();
        DinerMenu dinerMenu = new DinerMenu();

        Waitress waitress = new Waitress(pancakeHouseMenu, dinerMenu);
        waitress.printMenu();
    }
}