package coffeemachine;

import java.util.Scanner;

public class CoffeeMachine {

	private static final Scanner sc = new Scanner(System.in);

	private static final int waterRequiredFor1Espresso = 250;
	private static final int milkRequiredFor1Espresso = 0;
	private static final int beansRequiredFor1Espresso = 16;
	private static final int costOf1Espresso = 4;

	private static final int waterRequiredFor1Latte = 350;
	private static final int milkRequiredFor1Latte = 75;
	private static final int beansRequiredFor1Latte = 20;
	private static final int costOf1Latte = 7;

	private static final int waterRequiredFor1Cappuccino = 200;
	private static final int milkRequiredFor1Cappuccino = 100;
	private static final int beansRequiredFor1Cappuccino = 12;
	private static final int costOf1Cappuccino = 6;

	private int currentWater, currentMilk, currentBeans, currentCups, currentMoney;

	public CoffeeMachine() {
		currentWater = 400;
		currentMilk = 540;
		currentBeans = 120;
		currentCups = 9;
		currentMoney = 550;
	}

	void showCurrentStatus() {
		System.out.printf("\nThe coffee machine has:\r\n"
				+ "%d ml of water\r\n"
				+ "%d ml of milk\r\n"
				+ "%d g of coffee beans\r\n"
				+ "%d disposable cups\r\n"
				+ "$%d of money\n", currentWater, currentMilk, currentBeans, currentCups, currentMoney);
	
	}

	void startMenu() {
		while (true) {
			System.out.println("\nWrite action (buy, fill, take, remaining, exit): ");
			String action = sc.nextLine();
			switch (action) {
			case "buy" :
				buyCoffee(); break;
			case "fill" :
				fillIngredients(); sc.nextLine(); break;
			case "take" :
				takeOutMoney(); break;
			case "remaining" :
				showCurrentStatus(); break;
			case "exit" :
				return;
			default :
				System.out.println("Wrong input"); break;
			}
		}
	}

	private void buyCoffee() {
	
		System.out.println("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
		String choice = sc.nextLine();
		if (choice.equals("back")) {
			startMenu();
		}
		else {
			calculateIngredient(Integer.parseInt(choice));
		}

	}


	private void fillIngredients() {
		System.out.println("\nWrite how many ml of water you want to add:");
		int waterAmount = sc.nextInt();
		System.out.println("Write how many ml of milk you want to add:");
		int milkAmount = sc.nextInt();
		System.out.println("Write how many grams of coffee beans you want to add:");
		int beansAmount = sc.nextInt();
		System.out.println("Write how many disposable cups you want to add:");
		int cupsAmount = sc.nextInt();

		currentWater += waterAmount;
		currentMilk += milkAmount;
		currentBeans += beansAmount;
		currentCups += cupsAmount;

	}

	private void takeOutMoney() {
		System.out.println("I gave you $" + currentMoney + "\n");
		currentMoney = 0;
	}

	private void checkForEnoughResources(int coffeType) {

		int requiredWater = 0, requiredMilk = 0, requiredBeans = 0, coffeePrice = 0;
		
		switch(coffeType) {
		
		case 1 : //espresso
			requiredWater = waterRequiredFor1Espresso;
			requiredMilk = milkRequiredFor1Espresso;
			requiredBeans = beansRequiredFor1Espresso;
			coffeePrice = costOf1Espresso;
			break;
		case 2 : //latte
			requiredWater = waterRequiredFor1Latte;
			requiredMilk = milkRequiredFor1Latte;
			requiredBeans = beansRequiredFor1Latte;
			coffeePrice = costOf1Latte;
			break;
		case 3 : //cappuccino
			requiredWater = waterRequiredFor1Cappuccino;
			requiredMilk = milkRequiredFor1Cappuccino;
			requiredBeans = beansRequiredFor1Cappuccino;
			coffeePrice = costOf1Cappuccino;
			break;

		}

		if (currentWater < requiredWater) {
			System.out.println("Sorry, not enough water!");
			return;
		}
		if (currentMilk < requiredMilk) {
			System.out.println("Sorry, not enough milk!");
			return;
		}
		if (currentBeans < requiredBeans) {
			System.out.println("Sorry, not enough coffee beans!");
			return;
		}
		if (currentCups < 1) {
			System.out.println("Sorry, not enough cups!");
			return;
		}

		currentWater -= requiredWater;
		currentMilk -= requiredMilk;
		currentBeans -= requiredBeans;
		currentMoney += coffeePrice;
		currentCups -= 1;
		System.out.println("I have enough resources, making you a coffee!");
	
	}

	void calculateIngredient(int choice) {

		switch (choice) {
		case 1 :
			checkForEnoughResources(choice);
			break;

		case 2 :
			checkForEnoughResources(choice);
			break;

		case 3 :
			checkForEnoughResources(choice);
			break;
		}
		
	}

}
