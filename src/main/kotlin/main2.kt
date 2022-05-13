fun main() {
    val a = commCalc(amount = 1000_00)
    val b = commCalc("Mastercard", 100, 1000_00)
    val c = commCalc("Maestro", 75001_00, 1000_00)
    val d = commCalc(card = "Visa", amount = 1000_00)

    message(a)
    message(b)
    message(c)
    message(d)
}

fun commCalc(card: String = "VK pay", prevTrans: Int = 0, amount: Int): Int {
    return when (card) {
        "Mastercard", "Maestro" -> calcForM(prevTrans, amount)
        "Visa", "Мир" -> calcForVisa(amount)
        else -> 0
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

fun message(result: Int) = println("Комиссия составит ${result} руб.")