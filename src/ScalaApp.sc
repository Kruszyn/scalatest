import scala.xml._
import java.io.File

val doc = XML.loadFile("C:/Users/ibm/Downloads/XML_Samples_R209/F01_019492_2015.xml")

val uriList = doc \ "CODED_DATA_SECTION" \ "NOTICE_DATA"

