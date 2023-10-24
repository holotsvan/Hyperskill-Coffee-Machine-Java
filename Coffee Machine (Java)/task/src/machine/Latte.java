package machine;

public class Latte implements CoffeeDrink {
    private final static int waterConsumption = 350;
    private final static int milkConsumption = 75;
    private final static int coffeeBeansConsumption = 20;
    private final static int price = 7;

    @Override
    public void makeCoffee(CoffeeMachine coffeeMachine) {
        if (isEnoughCups(coffeeMachine) && isEnoughWater(coffeeMachine) && isEnoughCoffeeBeans(coffeeMachine) && isEnoughMilk(coffeeMachine)) {
            System.out.println("I have enough resources, making you a coffee!");
            coffeeMachine.setWater(coffeeMachine.getWater() - waterConsumption);
            coffeeMachine.setMilk(coffeeMachine.getMilk() - milkConsumption);
            coffeeMachine.setCoffeeBeans(coffeeMachine.getCoffeeBeans() - coffeeBeansConsumption);
            coffeeMachine.setMoney(coffeeMachine.getMoney() + price);
            coffeeMachine.setCups(coffeeMachine.getCups() - 1);
        } else if (!isEnoughWater(coffeeMachine)) {
            System.out.println("Sorry, not enough water!");
        } else if (!isEnoughCups(coffeeMachine)) {
            System.out.println("Sorry, not enough cups!");
        } else if (!isEnoughCoffeeBeans(coffeeMachine)) {
            System.out.println("Sorry, not enough coffee beans!");
        } else if (!isEnoughMilk(coffeeMachine)) {
            System.out.println("Sorry, not enough milk!");
        }
    }

    @Override
    public boolean isEnoughWater(CoffeeMachine coffeeMachine) {
        return coffeeMachine.water > waterConsumption;
    }

    @Override
    public boolean isEnoughCups(CoffeeMachine coffeeMachine) {
        return coffeeMachine.getCups() > 0;
    }

    @Override
    public boolean isEnoughCoffeeBeans(CoffeeMachine coffeeMachine) {
        return coffeeMachine.getCoffeeBeans() > coffeeBeansConsumption;
    }

    @Override
    public boolean isEnoughMilk(CoffeeMachine coffeeMachine) {
        return coffeeMachine.getMilk() > milkConsumption;
    }

}
