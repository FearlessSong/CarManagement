package Eneity;

public class Fix {
	String CarNumber;
	   String FixDate;
	   String Worker;
	   String Tester;
	   public Fix(String Number,String car,String Work,String Test) {
		  CarNumber=Number;
		  FixDate = car;
		  Worker=Work;
		  Tester=Test;
    }
	   public String getCarNumber()
	   {
		   return CarNumber;
	   }
	   public String getFixDate()
	   {
		   return FixDate;
	   }
	   public String getWorker() {
		   return Worker;
	   }
	   public String getTester() {
		   return Tester;
	   }
}
