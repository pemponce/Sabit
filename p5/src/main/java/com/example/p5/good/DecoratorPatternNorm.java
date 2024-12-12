package com.example.p5.good;

public class DecoratorPatternNorm {
    public static void main(String[] args) {
        Beverage b = new Espresso();
        b = new Mocha(b);
        b = new Mocha(b);

        System.out.println(b.getDescription() + " $" + b.cost());

        Beverage b2 = new DarkRoast();
        b2 = new Mocha(b2);
        b2 = new Mocha(b2);
        b2 = new Whip(b2);

        System.out.println(b2.getDescription() + " $" + b2.cost());
    }

    abstract static class Beverage {
        String description = "Unknown beverage";

        public String getDescription() {
            return description;
        }

        public abstract double cost();
    }

    abstract static class CondimentDecorator extends Beverage {
        Beverage beverage;

        public abstract String getDescription();
    }

    static class Espresso extends Beverage {
        public Espresso() {
            description = "Espresso Coffee";
        }

        @Override
        public double cost() {
            return 1.99;
        }
    }

    static class HouseBlend extends Beverage {
        public HouseBlend() {
            description = "House Blend Coffee";
        }

        @Override
        public double cost() {
            return .89;
        }
    }

    static class DarkRoast extends Beverage {
        public DarkRoast() {
            description = "Dark Roast Coffee";
        }

        @Override
        public double cost() {
            return .99;
        }
    }

    static class Decaf extends Beverage {
        public Decaf() {
            description = "Decaf Coffee";
        }

        @Override
        public double cost() {
            return 1.05;
        }
    }

    static class Mocha extends CondimentDecorator {
        public Mocha(Beverage beverage) {
            this.beverage = beverage;
        }

        @Override
        public String getDescription() {
            return beverage.getDescription() + ", Mocha";
        }

        @Override
        public double cost() {
            return beverage.cost() + .20;
        }
    }

    static class Whip extends CondimentDecorator {
        public Whip(Beverage beverage) {
            this.beverage = beverage;
        }

        @Override
        public String getDescription() {
            return beverage.getDescription() + ", Whip";
        }

        @Override
        public double cost() {
            return beverage.cost() + .10;
        }
    }
}
