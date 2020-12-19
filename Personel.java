
public class Personel extends Departman {
    
    private String perAD;
    private String perSOYAD;
    private int perYAS;
    private int perId;

    public Personel(int depNo , String depAd,String perAD, String perSOYAD, int perYAS)
    {
        super(depNo, depAd);
        this.perAD = perAD;
        this.perSOYAD = perSOYAD;
        this.perYAS = perYAS;  
    }


    public String getPerAD()
    {
        return perAD;
    }

    public void SetPerAD(String perAD)
    {
       this.perAD = perAD;
    }
    
    public String getPerSOYAD()
    {
        return perSOYAD;
    }
    
    public void SetPerSOYAD(String perSOYAD)
    {
       this.perSOYAD = perSOYAD;
    }

    public int getPerYAS()
    {
        return perYAS;
    }
    
    public void SetPerYAS(int perYAS)
    {
       this.perYAS = perYAS;
    }

    public int getPerID()
    {
        return perId;
    }

    public void SetPerId(int PerId)
    {
        this.perId = PerId;
    }
}
