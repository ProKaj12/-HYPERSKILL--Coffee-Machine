package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Machine coffeeMachine = new Machine(400, 540, 120, 9, 550);
        String action;
        while(true) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            action = scanner.next();

            if (action.equals("take"))
                coffeeMachine.takeMoney();
            else if (action.equals("buy")) {
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappucino");
                System.out.println(coffeeMachine.buyCoffee(scanner.next()));
            }
            else if (action.equals("fill")) {
                System.out.println("Write how many ml of water do you want to add:");
                int water = scanner.nextInt();
                System.out.println("Write how many ml of milk do you want to add:");
                int milk = scanner.nextInt();
                System.out.println("Write how many grams of coffee beans do you want to add:");
                int beans = scanner.nextInt();
                System.out.println("Write how many disposable cups of coffee do you want to add:");
                int cups = scanner.nextInt();
                coffeeMachine.fillMachine(water, milk, beans, cups);
            }
            else if (action.equals("remaining"))
                coffeeMachine.getWhole();
            else if (action.equals("exit"))
                break;
        }
    }
}

class Machine {

    protected int waterMl;
    protected int milkMl;
    protected int beansGrams;
    protected int disposableCups;
    protected int money;

        public Machine(int water, int milk, int beans, int cups, int money) {
            this.waterMl = water;
            this.milkMl = milk;
            this.beansGrams = beans;
            this.disposableCups = cups;
            this.money = money;
        }

        // mechanics
        public void takeMoney() {
            System.out.println("I gave you $" + money);
            money = 0;
        }

        public String buyCoffee(String choice) {
            int waterSubstract = 0;
            int milkSubstract = 0;
            int beansSubstract = 0;
            int moneyEarned = 0;

            switch(choice) {
                case "1":
                    waterSubstract = 250;
                    milkSubstract = 0;
                    beansSubstract = 16;
                    moneyEarned = 4;
                    break;
                case "2":
                    waterSubstract = 350;
                    milkSubstract = 75;
                    beansSubstract = 20;
                    moneyEarned = 7;
                    break;
                case "3":
                    waterSubstract = 200;
                    milkSubstract = 100;
                    beansSubstract = 12;
                    moneyEarned = 6;
                    break;
                case "back":
                    return "";
                default:
                    break;
            }

            if(waterMl - waterSubstract < 0)
                return "Sorry, not enough water!\n";
            else
                waterMl = waterMl - waterSubstract;

            if(milkMl - milkSubstract < 0)
                return "Sorry, not enough milk!\n";
            else
                milkMl = milkMl - milkSubstract;

            if(beansGrams - beansSubstract < 0)
                return "Sorry, not enough coffee beans!\n";
            else
                beansGrams = beansGrams - beansSubstract;

            if(disposableCups - 1 < 0)
                return "Sorry, not enough disposable cups!\n";
            else
                disposableCups = disposableCups - 1;

            money = money + moneyEarned;
            return "I have enough resources, making you a coffee!\n";
        }

        public void fillMachine(int water, int milk, int beans, int cups) {
            waterMl = waterMl + water;
            milkMl = milkMl + milk;
            beansGrams = beansGrams + beans;
            disposableCups = disposableCups + cups;
        }

        // getters
        public String getWater() {
            return waterMl + " of water";
        }

        public String getMilk() {
            return milkMl + " of milk";
        }

        public String getBeans() {
            return beansGrams + " of coffee beans";
        }

        public String getCups() {
            return disposableCups + " of disposable cups";
        }

        public String getMoney() {
            return money + " of money";
        }

        public void getWhole() {
            System.out.println("The coffee machine has:");
            System.out.println(getWater());
            System.out.println(getMilk());
            System.out.println(getBeans());
            System.out.println(getCups());
            System.out.println(getMoney());
            System.out.println("\n");
        }
}