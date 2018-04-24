import scala.xml._



val doc = XML.loadFile("C:\\Users\\ibm\\Desktop\\projects\\scalatest\\data\\173193_2018.xml")


var total = BigDecimal(0).setScale(2, scala.math.BigDecimal.RoundingMode.HALF_UP)

for {
  objectDescr  <- doc \\ "OBJECT_DESCR"
  price <- objectDescr \ "VAL_OBJECT"
} yield {

  total += price.text.toDouble //zostawiam double bo nie jestem pewny czy wszystkie ceny sa całowite
  println("contract price: " + price.text + " subtotal:"  +total)
}
println(s"Grand total " + total)




