fun main() {
    val now = agoToText(55)
    val min2 = agoToText(155)
    val min1 = agoToText(63)
    val min16 = agoToText(1000)
    val h1 = agoToText(5000)
    val h3 = agoToText(11000)
    val h5 = agoToText(20000)
    val today = agoToText(135000)
    val yesterday = agoToText(235000)
    val wayback = agoToText(300000)

    message(now)
    message(min1)
    message(min2)
    message(min16)
    message(h1)
    message(h3)
    message(h5)
    message(today)
    message(yesterday)
    message(wayback)
}

fun agoToText(seconds: Int): String {
    val min = seconds/60
    val hour = seconds/3600
    val day = 24*60*60
    return when (seconds) {
        in 0..60 -> ("только что")
        in 61..60*60 -> ("${min} ${minutes(min)} назад")
        in 60*60+1..day -> ("${hour} ${hours(hour)} назад")
        in day+1..2*day -> ("сегодня")
        in (2*day)+1..3*day -> ("вчера")
        else -> ("давно")
    }
}

fun minutes(min: Int): String {
    return when {
        min % 10 == 1 -> ("минуту")
        min % 10 == 2 || min % 10 == 3 || min % 10 == 4 -> ("минуты")
        else -> ("минут")
    }
}

fun hours(hour: Int): String {
    return when {
        hour % 10 == 1 -> ("час")
        hour % 10 == 2 || hour % 10 == 3 || hour % 10 == 4 -> ("часа")
        else -> ("часов")
    }
}

fun message(text: String) = println("был(а) в сети ${text}")