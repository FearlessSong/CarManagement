package Eneity;

public class CarCareInfo {
	   String CarNumber;
	   String CareDate;
	   String Worker;
	   String Tester;
	   public CarCareInfo(String carn,String car,String Work,String Test) {
		   CarNumber=carn;
		  CareDate = car;
		  Worker=Work;
		  Tester=Test;
       }
	   public String getCarNumber()
	   {
		   return CarNumber;
	   }
	   public String getCareDate()
	   {
		   return CareDate;
	   }
	   public String getWorker() {
		   return Worker;
	   }
	   public String getTester() {
		   return Tester;
	   }
}
