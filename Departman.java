public class Departman {
    
    private int depNo;
    private String depAd;
    public  Personel[] personeller ;
    public  Servis[] servisler;

    public Departman(int depNo, String depAd)
    {
        this.depNo = depNo;
        this.depAd = depAd;
    }

   public void SetDepNo(int depNo)
    {
       this.depNo = depNo;
    }
    
    public int getDepNo()
    {
        return depNo;
    }

    public void SetDepAd(String depAd)
    {
        this.depAd = depAd;
    }

    public String getDepAd()
    {
        return depAd;
    }

}
