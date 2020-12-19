public class Servis extends Departman {

    private int servisID ;
    private String servisGuzergah;

    public Servis(int depNo, String depAd, String ServisGuzergah)
    {
        super(depNo, depAd);
        this.servisGuzergah = ServisGuzergah;     
    }

    public String getServisGuzergah()
    {
        return servisGuzergah;
    }
    
    public void SetServisGuzergah(String servisguzergah)
    {
       this.servisGuzergah = servisguzergah;
    }

    public int getServisID()
    {
        return servisID;
    }

    public void SetServisID(int servisID)
    {
        this.servisID = servisID;
    }
    
    
    
}
