import java.io.File

import scala.xml.XML

object Main {
  def main(args: Array[String]): Unit = {

    //Jeszcze aktualna lista krajow UE
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

    //TODO podawanie ścieżki przez użytkownika
    val path = "C:/Data"
    val filesHomeDir = new File(path).listFiles

    // Pętla przechodząca po wszystkich folderach
    for(fileFolder <- filesHomeDir){
      println(fileFolder)

      val filesList = fileFolder.listFiles

      // Iteracja po wszystkich plikach w folderze
      for(file <- filesList){
        processFile(file.toString)
      }

    }
  }

  def processFile(xmlFilePath: String): Unit = {

    val xml = XML.loadFile(xmlFilePath)



  }


}
