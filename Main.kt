package machine

import java.util.Scanner

var water = 400
var milk = 540
var coffeeBeans = 120
var cup = 9
var money = 550
val scanner = Scanner(System.`in`)

fun main() {
    menu()
}


fun remaining() {
    println("The coffee machine has:\n" +
            "$water ml of water\n" +
            "$milk ml of milk\n" +
            "$coffeeBeans g of coffee beans\n" +
            "$cup disposable cups\n" +
            "\$$money of money\n" + "")
}

fun buyEspresso() {
    when {
        water - 250 < 0 -> println("Sorry, not enough water!")
        coffeeBeans - 16 < 0 -> println("Sorry, not enough coffee beans!")
        cup - 1 < 0 -> println("Sorry, not enough cups!")
        else -> {
            println("I have enough resources, making you a coffee!")
            water -= 250
            coffeeBeans -= 16
            money += 4
            cup -= 1
        }
    }
}

fun buyCappuccino() {
    when {
        water - 200 < 0 -> println("Sorry, not enough water!")
        coffeeBeans - 12 < 0 -> println("Sorry, not enough coffee beans!")
        milk - 100 < 0 -> println("Sorry, not enough coffee milk!")
        cup - 1 < 0 -> println("Sorry, not enough cups!")
        else -> {
            println("I have enough resources, making you a coffee!")
            water -= 200
            milk -= 100
            coffeeBeans -= 12
            money += 6
            cup -= 1
        }
    }
}

fun buyLatte() {
    when {
        water - 350 < 0 -> println("Sorry, not enough water!")
        coffeeBeans - 20 < 0 -> println("Sorry, not enough coffee beans!")
        milk - 75 < 0 -> println("Sorry, not enough coffee milk!")
        cup - 1 < 0 -> println("Sorry, not enough cups!")
        else -> {
            println("I have enough resources, making you a coffee!")
            water -= 350
            milk -= 75
            coffeeBeans -= 20
            money += 7
            cup -= 1
        }
    }
}

fun purchaseMenu() {
    println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:")
    when (readln()) {
        "1" -> buyEspresso()
        "2" -> buyLatte()
        "3" -> buyCappuccino()
        "back" -> menu()
    }

}

fun fill() {
    println("Write how many ml of water you want to add:")
    water += readln().toInt()
    println("Write how many ml of milk you want to add:")
    milk += readln().toInt()
    println("Write how many grams of coffee beans you want to add:")
    coffeeBeans += readln().toInt()
    println("Write how many disposable cups you want to add:")
    cup += readln().toInt()


}

fun take() {
    println("I gave you $$money")
    money = 0
}

fun menu() {
    while (scanner.hasNext()){
        when(scanner.nextLine()) {
            "buy" -> purchaseMenu()
            "fill" -> fill()
            "take" -> take()
            "remaining" -> remaining()
            "exit" -> break
            else -> println("Invalid Input!")
        }
        print("Write action (buy, fill, take, remaining, exit): ")
    }
}