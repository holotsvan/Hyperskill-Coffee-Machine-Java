package machine;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CoffeeMachine {
    int water = 400;
    private int milk = 540;
    private int coffeeBeans = 120;
    private int cups = 9;
    private int money=550;
    private final static Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        coffeeMachine.menu();
    }

    private static void coffeeCalculator() {
        try {
            System.out.println("Write how many cups of coffee you will need:");
            int cupsOfCoffee = SCANNER.nextInt();
            System.out.format("For %s cups of coffee you will need:%n", cupsOfCoffee);
            System.out.format("%d ml of water%n", cupsOfCoffee * 200);
            System.out.format("%d ml of milk%n", cupsOfCoffee * 50);
            System.out.format("%d g of coffee beans%n", cupsOfCoffee * 15);
        } catch (InputMismatchException e) {
            System.err.println("Invalid number of cups!");
        }
    }

    public void initializeCoffeeMachine() {
        System.out.println("Write how many ml of water the coffee machine has:");
        this.water = SCANNER.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has:");
        this.milk = SCANNER.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        this.coffeeBeans = SCANNER.nextInt();
    }

    public void makeCoffee() {
        System.out.println("Write how many cups of coffee you will need:");
        int cupsOfCoffee = SCANNER.nextInt();
        String msg;
        if(isEnoughResources(cupsOfCoffee)){
            if(howMuchCupsCouldMake()==cupsOfCoffee){
                msg = "Yes, I can make that amount of coffee";
            }else{
                msg = String.format("Yes, I can make that amount of coffee (and even %d more than that)",howMuchCupsCouldMake()-cupsOfCoffee);
            }
        }else{
            msg = String.format("No, I can make only %s cup(s) of coffee",howMuchCupsCouldMake());
        }
        System.out.println(msg);
    }

    private int howMuchCupsCouldMake() {
        int numOfCupsByWater = this.water / 200;
        int numOfCupsByMilk = this.milk / 50;
        int numOfCupsByBeans = this.coffeeBeans / 15;
        return Math.min(numOfCupsByBeans, Math.min(numOfCupsByWater, numOfCupsByMilk));
    }

    private boolean isEnoughResources(int cups) {
        return isEnoughWater(cups) && isEnoughMilk(cups) && isEnoughBeans(cups);
    }

    private boolean isEnoughWater(int cups) {
        return cups * 200 < this.water;
    }

    private boolean isEnoughMilk(int cups) {
        return cups * 50 < this.milk;
    }

    private boolean isEnoughBeans(int cups) {
        return cups * 15 < this.coffeeBeans;
    }

    public void menu(){
        boolean isRunning=true;
        do {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            switch(SCANNER.nextLine().toLowerCase()){
                case "buy"->buy();
                case "fill"->fill();
                case "take"->take();
                case "remaining"->printSuppliers();
                case "exit"-> isRunning=false;
                default -> System.out.println("Invalid action");
            }
        }while(isRunning);


    }
    private void buy(){
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        switch (SCANNER.nextLine()){
            case "1" -> new Espresso().makeCoffee(this);
            case "2" -> new Latte().makeCoffee(this);
            case "3" -> new Cappuccino().makeCoffee(this);
            case "back" -> {break;}
            default -> System.out.println("Invalid input!");
        }
    }
    private void fill(){
        try {
            System.out.println("Write how many ml of water you want to add:");
            this.water += SCANNER.nextInt();
            System.out.println("Write how many ml of milk you want to add:");
            this.milk += SCANNER.nextInt();
            System.out.println("Write how many grams of coffee beans you want to add:");
            this.coffeeBeans+= SCANNER.nextInt();
            System.out.println("Write how many disposable cups you want to add:");
            this.cups += SCANNER.nextInt();
        }catch (NoSuchElementException | IllegalStateException e){
            System.err.println(e.getMessage());
        }

    }
    private void take(){
        System.out.format("I gave you $%d%n",this.money);
        this.money=0;
    }
    private void printSuppliers(){
        System.out.format("""
                The coffee machine has:
                %d ml of water
                %d ml of milk
                %d g of coffee beans
                %d disposable cups
                $%d of money%n
                """,this.water,this.milk,this.coffeeBeans,this.cups,this.money);
    }

    public int getWater() {
        return water;
    }

    public void setWater(int water) {
        this.water = water;
    }

    public int getMilk() {
        return milk;
    }

    public void setMilk(int milk) {
        this.milk = milk;
    }

    public int getCoffeeBeans() {
        return coffeeBeans;
    }

    public void setCoffeeBeans(int coffeeBeans) {
        this.coffeeBeans = coffeeBeans;
    }

    public int getCups() {
        return cups;
    }

    public void setCups(int cups) {
        this.cups = cups;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
