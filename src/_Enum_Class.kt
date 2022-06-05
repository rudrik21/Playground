fun main(){

    var counter: Int = 0
    for(day in DayOfWeek.values()){
        println("Day ${counter++}: $day")
    }

    println("Index of Monday: ${DayOfWeek.valueOf("Monday").ordinal}")  //  1
    println(""+DayOfWeek.values()[4] + " is on Index 4.")  //  Thursday

    println("Is Saturday a weekend? -> ${DayOfWeekend.Saturday.isWeekend}") //  true
}

//  for enum class
//      provide functions like: values, valueOf, ordinal(index of type in the class),name
enum class DayOfWeek{
    Sunday,
    Monday,
    Tuesday,
    Wednesday,
    Thursday,
    Friday,
    Saturday
}

//  for enum class with preDefined values
enum class DayOfWeekend(val isWeekend: Boolean = false){    //  for default is false
    Sunday(true),   //  to update value on Sunday
    Monday,
    Tuesday,
    Wednesday,
    Thursday,
    Friday,
    Saturday(true)  //  to update value on Saturday
}