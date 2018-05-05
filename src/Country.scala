import java.math.RoundingMode

import scala.math.BigDecimal

class Country(val name: String, val countryTag: String, var counter: Int = 0, var total: BigDecimal = 0){

  def  calcAvgContractValue(): BigDecimal ={
    if(counter>0){
      total/counter
    } else {
      0
    }
  }

  override def toString: String = {
    val scaled = calcAvgContractValue().setScale(2, BigDecimal.RoundingMode.HALF_UP)
    name + " " + countryTag + " contracts count: " + Console.BLUE  + counter + Console.RESET + " avg. contract value: " + Console.YELLOW + scaled.toString + Console.RESET
    }

}
