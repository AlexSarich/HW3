fun main() {
    agoToText(55)
    agoToText(155)
    agoToText(63)
    agoToText(1000)
    agoToText(5000)
    agoToText(11000)
    agoToText(20000)
    agoToText(135000)
    agoToText(235000)
    agoToText(300000)
}

fun agoToText(seconds: Int) {
    val min = seconds/60
    val hour = seconds/3600
    val day = 24*60*60
    when {
        seconds in 0..60 -> println("был(а) только что")
        seconds in 61..60*60 -> println("был(а) ${min.toInt()} ${minutes(min.toInt())} назад")
        seconds in 60*60+1..day -> println("был(а) в сети ${hour.toInt()} ${hours(hour.toInt())} назад")
        seconds in day+1..2*day -> println("был(а) в сети сегодня")
        seconds in (2*day)+1..3*day -> println("был(а) в сети вчера")
        seconds > (3*day) -> println("был(а) давно")
    }
}

fun minutes(min: Int): String {
    when {
        min % 10 == 1 -> return ("минуту")
        min % 10 == 2 || min % 10 == 3 || min % 10 == 4 -> return ("минуты")
        else -> return ("минут")
    }
}

fun hours(hour: Int): String {
    when {
        hour % 10 == 1 -> return ("час")
        hour % 10 == 2 || hour % 10 == 3 || hour % 10 == 4 -> return ("часа")
        else -> return ("часов")
    }
}