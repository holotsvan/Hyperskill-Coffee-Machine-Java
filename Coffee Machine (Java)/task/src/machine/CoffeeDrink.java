package machine;

public interface CoffeeDrink {
     void makeCoffee(CoffeeMachine coffeeMachine);
     boolean isEnoughWater(CoffeeMachine coffeeMachine);
     boolean isEnoughCups(CoffeeMachine coffeeMachine);
     boolean isEnoughCoffeeBeans(CoffeeMachine coffeeMachine);
     boolean isEnoughMilk(CoffeeMachine coffeeMachine);

}
