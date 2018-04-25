/**
  * Created by ibm on 2018-04-25.
  */
class Country(val name: String, val countryTag: String, var counter: Int = 0, var total: BigDecimal = 0){

  def  calcAvgContractValue(): BigDecimal ={
    if(counter>0){
      total/counter
    } else {
      0
    }
  }

  override def toString: String = name + " " + countryTag + " contracts count: " + counter + " avg. contract value: " + calcAvgContractValue().toString()

}
