package Eneity;

public class Material {
	String CarNumber;
	String Date;
	String Worker;
	String Tester;
	String Fee;
	String Record;
	public Material(String car,String da,String work,String test,String fe,String re) {
		CarNumber=car;
		Date=da;
		Worker=work;
		Tester=test;
		Fee=fe;
		Record=re;
	}
	public String getCarNumber() {
		return CarNumber;
	}
	public String getDate() {
		return Date;
	}
	public String getWorker() {
		return Worker;
	}
	public String getTester() {
		return Tester;
	}
	public String getFee() {
		return Fee;
	}
	public String Record() {
		return Record;
	}
}
