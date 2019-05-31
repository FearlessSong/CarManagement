package Eneity;

public class Return {
    String FixDate;
    String CareDate;
    public Return(String fix,String Care) {
    	FixDate=fix;
    	CareDate=Care;
    }
    public String FixDate()
    {
    	return FixDate;
    }
    public String CareDate()
    {
    	return CareDate;
    }
}
