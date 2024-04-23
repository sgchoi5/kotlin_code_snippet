fun getCurrentSec(time: String) : Int {
    var sec : Int = 0
    
    if (time.length == 0)
    	return -1
    
    var timeWithoutSpace = time.replace(" ", "")
    println("timeWithoutSpace: $timeWithoutSpace")
    
    // Input must be HH:MM:SS or HHMMSS
    // HH Will be dropped
    
    if (timeWithoutSpace.contains(":")) {
        // HH:MM:SS  =>  MM:SS
        val splitList: List<String> = timeWithoutSpace.split(":")
        val minutes: String = splitList.get(splitList.size - 2)
        val seconds: String = splitList.get(splitList.size - 1)

        when (minutes.length) {
            2 -> {
                val firstMin : Int = Character.getNumericValue(minutes[0])
                sec += firstMin * 60 * 10
                println("Current sec: $sec")
                
                val secondMin : Int = Character.getNumericValue(minutes[1])
                sec += secondMin * 60
                println("Current sec: $sec")
            }
            1 -> {
                val firstMin : Int = Character.getNumericValue(minutes[0])
                sec += firstMin * 60
                println("Current sec: $sec")
            }
        }
        
        when (seconds.length) {
            2 -> {
                val firstSec : Int = Character.getNumericValue(seconds[0])
                sec += firstSec * 10
                println("Current sec: $sec")
                
                val secondSec : Int = Character.getNumericValue(seconds[1])
                sec += secondSec
                println("Current sec: $sec")
            }
            1 -> {
                val firstSec : Int = Character.getNumericValue(seconds[0])
                sec += firstSec
                println("Current sec: $sec")
            }
        }
    
    } else {
        // HHMMSS
        var len : Int = timeWithoutSpace.length
        if (len > 4) {
            timeWithoutSpace = timeWithoutSpace.takeLast(4)
            println("timeWithoutSpace: $timeWithoutSpace")
            len = 4
        }
        
        when (len) {
            4 -> {
                // MMSS
                val firstMin : Int = Character.getNumericValue(timeWithoutSpace[0])
                sec += firstMin * 60 * 10
                println("Current sec: $sec")
                
                val secondMin : Int = Character.getNumericValue(timeWithoutSpace[1])
                sec += secondMin * 60
                println("Current sec: $sec")
                
                val firstSec : Int = Character.getNumericValue(timeWithoutSpace[2])
                sec += firstSec * 10
                println("Current sec: $sec")
                
                val secondSec : Int = Character.getNumericValue(timeWithoutSpace[3])
                sec += secondSec
                println("Current sec: $sec")
            } 
            3 -> {
                // MSS
                val firstMin : Int = Character.getNumericValue(timeWithoutSpace[0])
                sec += firstMin * 60
                println("Current sec: $sec")
                
                val firstSec : Int = Character.getNumericValue(timeWithoutSpace[1])
                sec += firstSec * 10
                println("Current sec: $sec")
                
                val secondSec : Int = Character.getNumericValue(timeWithoutSpace[2])
                sec += secondSec
                println("Current sec: $sec")
            }
            2 -> {
                // SS
                val firstSec : Int = Character.getNumericValue(timeWithoutSpace[0])
                sec += firstSec * 10
                println("Current sec: $sec")
                
                val secondSec : Int = Character.getNumericValue(timeWithoutSpace[1])
                sec += secondSec
                println("Current sec: $sec")
            }
            1 -> {
                // S
                val firstSec : Int = Character.getNumericValue(timeWithoutSpace[0])
                sec += firstSec
                println("Current sec: $sec")
            }
        }
    }
    return sec
}

fun main() {
	val test1 = ""
    val sec = getSec(test1)
    println("Time: $sec")
}
