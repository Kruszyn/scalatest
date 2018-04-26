import scala.xml.XML

/**
  * Created by ibm on 2018-04-25.
  */
object XMLfun {


  def main(args: Array[String]): Unit = {
    val doc = XML.loadFile("C:\\Users\\ibm\\Desktop\\projects\\scalatest\\data\\173277_2018.xml")

    var total = BigDecimal(0)
    var counter = 0

    for {//popraw ta petle
      objectDescr <- doc \\ "OBJECT_DESCR"
      price <- objectDescr \ "VAL_OBJECT"
    } yield {

      total += price.text.toDouble //zostawiam double bo nie jestem pewny czy wszystkie ceny sa całowite
      println("contract price: " + price.text + " subtotal:" + total)
      counter += 1
    }

    println(s"Grand total " + total)
    if (counter > 0) {
      println(counter)
      println(total / counter)
    } else {

    }
    val contract = doc \ "FORM_SECTION" \ "F03_2014" \ "AWARD_CONTRACT"
    for {
      awContract <- contract \ "AWARDED_CONTRACT"
      low <- awContract \ "VAL_RANGE_TOTAL" \ "LOW"
      high <- awContract \ "VAL_RANGE_TOTAL" \ "HIGH"
    } yield {
      println("LOW:" + low.text + " HIGH:" + high.text)
    }


    val uriList = doc \ "CODED_DATA_SECTION" \ "NOTICE_DATA" \ "URI_LIST"
    for {
      uriDoc <- uriList \ "URI_DOC"
    } yield {
      println(uriDoc \@ "LG")

    }
  }
}
