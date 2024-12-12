package com.example.p5.bad;

import lombok.Getter;
import lombok.Setter;

public class DecoratorPatternBad {
    public static void main(String[] args) {
        DarkRoast beverage = new DarkRoast();
        beverage.setMilkCost(11.34);
        beverage.setMochaCost(4.77);
        beverage.setSoyCost(26.22);
        beverage.setWhipCost(50.55);

        System.out.print(beverage.description + " " + beverage.cost() + "\n");
        System.out.print(beverage.description + " " + beverage.milkCost + "\n");
        System.out.print(beverage.description + " " + beverage.mochaCost + "\n");
    }

    @Getter
    @Setter
    public static class Beverage {
        String description;
        boolean milk;
        boolean soy;
        boolean mocha;
        boolean whip;

        double milkCost, soyCost, mochaCost, whipCost;

        public double cost() {
            double condimentCost = 0.0;
            if (isMilk()) {
                condimentCost += milkCost;
            }
            if (isSoy()) {
                condimentCost += soyCost;
            }
            if (isMocha()) {
                condimentCost += mochaCost;
            }
            if (isWhip()) {
                condimentCost += whipCost;
            }
            return condimentCost;
        }
    }

    public static class DarkRoast extends Beverage {
        public DarkRoast() {
            description = "Dark as my soul";
        }

        @Override
        public double cost() {
            return super.cost() + 1.99;
        }
    }
}
