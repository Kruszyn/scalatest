import scala.xml._
import java.io.File


val doc = XML.loadFile("C:/Users/ibm/Downloads/XML_Samples_R209/F02_019493_2015.xml")

val uriList = doc \ "CODED_DATA_SECTION" \ "NOTICE_DATA" \ "VALUES" \ "VALUkEk"
if(doc.isEmpty){ val res = uriList.text.toDouble}


val list = List(
  new Country("Belgium","BE"),
  new Country("Bulgaria","BG"),
  new Country("Czech Republic","CZ"),
  new Country("Denmark","DK"),
  new Country("Germany", "DE"),
  new Country("Estonia","EE"),
  new Country("Ireland","IE"),
  new Country("Greece","EL"),
  new Country("Spain","ES"),
  new Country("France","FR"),
  new Country("Croatia","HR"),
  new Country("Italy","IT"),
  new Country("Cyprus","CY"),
  new Country("Latvia","LV"),
  new Country("Lithuania","LT"),
  new Country("Luxembourg","LU"),
  new Country("Hungary","HU"),
  new Country("Malta","MT"),
  new Country("Netherlands","NL"),
  new Country("Austria","AT"),
  new Country("Poland", "PL"),
  new Country("Portugal","PT"),
  new Country("Romania","RO"),
  new Country("Slovenia","SI"),
  new Country("Slovakia","SK"),
  new Country("Finland","FI"),
  new Country("Sweden","SE"),
  new Country("United Kingdom","UK")
)
val contractCountryTag = "DE"
//val temp = list.find(x => x.countryTag == contractCountryTag)

list.indexWhere{x => x.countryTag == contractCountryTag}

list(4).total+=500
print(list(4).total)