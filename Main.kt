package machine

import kotlin.system.exitProcess

fun main() {
    val coffeeMaker = CoffeeMaker()
    coffeeMaker.menu()
}

enum class Coffee(val water: Int, val milk: Int, val coffeeBeans: Int, val money: Int) {
    ESPRESSO(250, 0, 16, 4),
    LATTE(350, 75, 20, 7),
    CAPPUCCINO(200, 100, 12, 6)

}
class CoffeeMaker(private var water: Int = 400, private var milk: Int = 540, private var coffeeBeans: Int = 120, private var cup: Int = 9, private var money: Int = 550) {
    private fun getStatus() {
        println("The coffee machine has:\n" +
                "$water ml of water\n" +
                "$milk ml of milk\n" +
                "$coffeeBeans g of coffee beans\n" +
                "$cup disposable cups\n" +
                "\$$money of money\n" + "")
    }
    private fun purchaseMenu() {
        println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:")
        when (readln()) {
            "1" -> buyCoffee(Coffee.ESPRESSO)
            "2" -> buyCoffee(Coffee.LATTE)
            "3" -> buyCoffee(Coffee.CAPPUCCINO)
            "back" -> menu()
        }

    }
    private fun fill() {
        println("Write how many ml of water you want to add:")
        water += readln().toInt()
        println("Write how many ml of milk you want to add:")
        milk += readln().toInt()
        println("Write how many grams of coffee beans you want to add:")
        coffeeBeans += readln().toInt()
        println("Write how many disposable cups you want to add:")
        cup += readln().toInt()


    }
    private fun take() {
        println("I gave you $$money")
        money = 0
    }

    private fun buyCoffee(coffee: Coffee) {
        when {
            milk < coffee.milk -> println("Sorry, not enough milk!")
            water < coffee.water -> println("Sorry, not enough water!")
            coffeeBeans < coffee.coffeeBeans -> println("Sorry, not enough coffee beans!")
            cup < 1 -> println("Sorry, not enough cups!")
            else -> {
                println("I have enough resources, making you a coffee!")
                water -= coffee.water
                milk -= coffee.milk
                coffeeBeans -= coffee.coffeeBeans
                cup--
                money += coffee.money

            }
        }
    }
    fun menu() {
        while (true) {
            print("Write action (buy, fill, take, remaining, exit): ")
            when(readln()) {
                "buy" -> purchaseMenu()
                "fill" -> fill()
                "take" -> take()
                "remaining" -> getStatus()
                "exit" -> exitProcess(0)
                else -> println("Invalid Input!")
            }
        }
    }

}




