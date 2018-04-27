import scala.math.BigDecimal

class Country(val name: String, val countryTag: String, var counter: Int = 0, var total: Double = 0){

  def  calcAvgContractValue(): BigDecimal ={
    if(counter>0){
     BigDecimal(total/counter).setScale(2, BigDecimal.RoundingMode.HALF_UP)
    } else {
      0
    }
  }

  override def toString: String = name + " " + countryTag + " contracts count: " + Console.BLUE  + counter + Console.RESET + " avg. contract value: " + Console.YELLOW + calcAvgContractValue().toString + Console.RESET

}
