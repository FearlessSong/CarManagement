package Eneity;

public class Car {
      String company; //���˹�˾
      int route;//��·
      String type;//����
      String engine;//������
      String box;//������
      String brige;//����
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
