import scala.io._
import scala.xml.{Source => Source2, _}
import scala.actors._
import Actor._

def getWeatherInfo(woeid: String) = {
    val url = "http://weather.yahooapis.com/forecastrss?w=" + woeid
    val response = Source.fromURL(url).mkString
    val xmlResponse = XML.loadString(response)
    println(xmlResponse \\ "location" \\ "@city",
        xmlResponse \\ "condition" \\ "@temp")
}

val caller = self

for(id <- 2391271 to 2391279) {
    actor{ getWeatherInfo(id.toString) }
}

for(id <- 2391271 to 2391279) {
    receiveWithin(5000) {
        case msg => println(msg)
    }
}