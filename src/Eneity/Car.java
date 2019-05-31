package Eneity;

public class Car {
      String company; //客运公司
      int route;//车路
      String type;//车型
      String engine;//发动机
      String box;//变速箱
      String brige;//车桥
      public Car(String com,int rou,String typ,String eng,String bo,String bri){
    	  company=com;
    	  route=rou;
    	  type=typ;
    	  engine=eng;
    	  box=bo;
    	  brige=bri;
    	  System.out.println(com);
      }
      public String getCompany()
      {
    	  return company;
      }
      public String getRoute()
      {
    	  return String.valueOf(route);
      }
      public String getType() {
    	  return type;
      }
      public String getEngine() {
    	  return engine;
      }
      public String getBox() {
    	  return box;
      }
      public String getBrige() {
    	  return brige;
      }
}
