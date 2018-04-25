import scala.xml._



val doc = XML.loadFile("C:\\Users\\ibm\\Desktop\\projects\\scalatest\\data\\173193_2018.xml")



  var total = BigDecimal(0).setScale(2, scala.math.BigDecimal.RoundingMode.HALF_UP)
  var counter = 0



for {//popraw ta petle
  objectDescr  <- doc \\ "OBJECT_DESCR"
  price <- objectDescr \ "VAL_OBJECT"
} yield {

  total += price.text.toDouble //zostawiam double bo nie jestem pewny czy wszystkie ceny sa całowite
  println("contract price: " + price.text + " subtotal:"  +total)
  counter += 1
}

  println(s"Grand total " + total)
println(counter)
println(total/counter)


val uriList = doc \ "CODED_DATA_SECTION" \ "NOTICE_DATA" \ "URI_LIST"

for {
  uriDoc  <- uriList \ "URI_DOC"
} yield {
  println(uriDoc \@ "LG")
}