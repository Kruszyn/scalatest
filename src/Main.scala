import java.io.File

import scala.xml.XML


object Main {

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

  def main(args: Array[String]): Unit = {

    //Jeszcze aktualna lista krajow UE


    //TODO podawanie ścieżki przez użytkownika
    val path = "C:/Data"
    val filesHomeDir = new File(path).listFiles
    var fileCount = 0
    var contractCount = 0
    // Pętla przechodząca po wszystkich folderach
    for(fileFolder <- filesHomeDir){
      println("Loading folder:" + fileFolder)

      val filesList = fileFolder.listFiles

      // Iteracja po wszystkich plikach w folderze
      for(file <- filesList){
        processFile(file.toString)
        fileCount+=1
      }
    }

    //println(list.toString)
    for(x <- list){
      println(x.toString)
    }

    println("Contracts found: " + list.map(_.counter).sum)
    println("Files scanned: " + fileCount)

  }

  def processFile(xmlFilePath: String): Unit = {

    val xml = XML.loadFile(xmlFilePath)
    //FIND COUNTRY TAG IN XML STRUCTURE
    val contractCountryTag = xml \ "CODED_DATA_SECTION" \ "NOTICE_DATA" \ "ISO_COUNTRY" \@ "VALUE"
    val contractValue = xml \ "CODED_DATA_SECTION" \ "NOTICE_DATA" \ "VALUES" \ "VALUE"


    if(contractCountryTag.nonEmpty && contractValue.nonEmpty) {
      val index = list.indexWhere{x => x.countryTag == contractCountryTag}

      if(index>=0){
        list(index).counter+=1
        list(index).total+=contractValue.text.toDouble
      }
    }

  }


}
