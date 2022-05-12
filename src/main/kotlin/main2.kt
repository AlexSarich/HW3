fun main() {
    commCalc(amount = 1000_00)
    commCalc("Mastercard", 100, 1000_00)
    commCalc("Maestro", 75001_00, 1000_00)
    commCalc(card = "Visa", amount = 1000_00)
}

fun commCalc(card: String = "VK pay", prevTrans: Int = 0, amount: Int) {
    when (card) {
        "Mastercard", "Maestro" -> println("Комиссия ${calcForM(prevTrans, amount)} руб.")
        "Visa", "Мир" -> println("Комиссия ${calcForVisa(amount)} руб." )
        else -> println("Комиссия 0 руб.")
    }
}

fun calcForM(prevTrans: Int, amount: Int): Int {
    val comm = (amount * (0.6 / 100)) + 2000
    return if (prevTrans > 7500000) {
        comm.toInt()
    } else {
        0
    }
}

fun calcForVisa(amount: Int): Int {
    val minComm = 3500
    val comm = amount * (0.75 / 100)
    return if (comm < minComm) {
        minComm
    } else {
        comm.toInt()
    }
}