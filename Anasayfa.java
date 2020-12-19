import java.util.Scanner;

public class Anasayfa{

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Kac tane departman olacak: ");
        int depSayisi = scanner.nextInt();
        Departman[] departmans = new Departman[depSayisi];
        int i;
        int PerId = 100; //personel id daha sonra classa atanacak
        int servisId = 50; // servis id daha sonra classa atanacak 50 den baslasin perId den farklı olsun

        //departman bilgilerinin alinmasi
        for(i=0 ; i< depSayisi ; i++)
        {
            
            System.out.println("\n----"+(i+1)+". departman icin ----");
            System.out.print("Departman no: ");
            int depNo = scanner.nextInt();
            System.out.print("Departman Adı: ");
            String depAd = scanner.next();
            Departman departman1 = new Departman(depNo, depAd);
            departmans[i] = departman1;

            System.out.print("Bu departmana ait personel sayısı: ");
            int perSayisi = scanner.nextInt();
            Personel[] personeller = new Personel[perSayisi];//personel sayisi kada personeller dizisi olustur

            //personel bilgilerinin alinmasi
            for (int j = 0 ; j< perSayisi ; j++)
            {
                PerId++;//her bilgi alindiginda artacak
                System.out.println("\n****"+(j+1)+". personelin****");
                System.out.print("Adı: ");
                String perAD = scanner.next();
                System.out.print("Soyadı: ");
                String perSOYAD = scanner.next();
                System.out.print("Yaşı: ");
                int perYAS = scanner.nextInt();
                
                //nesne uretilir ve uretilen nesne dizinin gerekli indisine atanır
                Personel personel1 = new Personel(depNo ,depAd,perAD, perSOYAD, perYAS);
                personel1.SetPerId(PerId);
                personeller[j] = personel1;

            }

            //mainde olusturdugum personeller dizisini departman classindaki personeller dizisine atadik
            for(int k = 0; k< personeller.length ; k++)
            { 
                departman1.personeller = personeller;
            }

         
            //departmana ait servis bilgilerinin alinmasi
            System.out.print("Departmana ait servis sayısı: "); 
            int servis_Sayisi = scanner.nextInt();
            Servis[] servisler = new Servis[servis_Sayisi]; //servis sayisi kadar bir servisler dizisi olustur

            for(int k = 0 ; k < servis_Sayisi ; k++)
            {
                servisId++; //her bilgi girildiginde artacak
                System.out.println("\n****"+(k+1)+". servis icin ****");
                System.out.print("Servis güzergahını giriniz: ");
                System.out.print(" ");
                String guzergah = scanner.next();

                Servis servis1 = new Servis(depNo, depAd, guzergah);
                servis1.SetServisID(servisId);//servis id nin arttirilmasi
                servisler[k] = servis1;
            }

            //alinan bilgilerin departman nesnesinin icindeki diziye aktarilmasi
            for (int a = 0 ; a < servisler.length; a++ ) {
                departman1.servisler = servisler;
            }

        }

        
        while(true)
        {

            System.out.println(" "); // menu guzel gorunsun
            System.out.println("1-Tüm Departman Bilgilerini Listele");
            System.out.println("2-Departman Adına Göre Arama Yap");
            System.out.println("3-Personel Adına Göre Arama Yap");
            System.out.println("4-Servis Güzergahına Göre Arama Yap");
            System.out.println("5-Çıkış");
            int secim = scanner.nextInt();
    
    
            switch (secim) {
                case 1:

                    //departman yazdirma 
                    for ( int j = 0 ; j < departmans.length ; j++ ) {
                        
                        System.out.print ( "\nDepartman No:" + departmans[ j ].getDepNo());
                        System.out.println ( " Departman Ad:" + departmans[ j ].getDepAd());
                        
    
                        //departmana ait personel yazdirma
                        for(int k = 0; k< departmans[ j ].personeller.length ; k++)
                        {
                            System.out.println((k+1) + ". Personel Id:"+ departmans[ j ].personeller[ k ].getPerID() +
                            " Ad:"+ departmans[ j ].personeller[ k ].getPerAD() + 
                            " Soyad:"+ departmans[ j ].personeller[ k ].getPerSOYAD() + 
                            " Yas:"+ departmans[ j ].personeller[ k ].getPerYAS());
                        }
    
                        //departmana ait servis yazdirma
                        for (int a = 0 ; a < departmans[ j ].servisler.length ; a++ ) {
                            
                            System.out.println((a+1)+". Servis Güzergahı:"+  departmans[ j ].servisler[ a ].getServisGuzergah() +
                            " Id:" + departmans[ j ].servisler[ a ].getServisID());
                
                        }
                    }
                    break;
    

                case 2:

                    int bulundu_mu = 0; // aranilan bulunamadı ise mesaj vermek icin kullanacagim
                    
                    System.out.print("Aranacak departman adını giriniz: ");
                    String aranacak = scanner.next();
    
    
                    for(int z = 0; z < departmans.length ; z++)
                    {
                        if(aranacak.equals( departmans[ z ].getDepAd() )) //aranilacak olan, departmans dizisindeki ada esitse
                        {
                            bulundu_mu = 1; // bulundu
                            
                            System.out.print ( "\nDepartman No:" + departmans[ z ].getDepNo());
                            System.out.println ( " Departman Ad:" + departmans[ z ].getDepAd());

                            System.out.println(" ");//menu hos gorunsun

                            //aranilan personel bilgisi yazdirilir
                            for(int k = 0; k< departmans[ z ].personeller.length ; k++)
                            {   
                                System.out.println((k+1)+". Personel Ad:"+ departmans[ z ].personeller[ k ].getPerAD()+" Soyad:"+ departmans[ z ].personeller[ k ].getPerSOYAD()+" Yaş:"+departmans[ z ].personeller[ k ].getPerYAS()+" Id:"+departmans[ z ].personeller[ k ].getPerID());
                            }
    
                            //servis yazdirma
                            for (int a = 0 ; a < departmans[ z ].servisler.length ; a++ ) {
                                System.out.println((a+1)+". Servis " +departmans[ z ].servisler[ a ].getServisGuzergah()+" Id:"+departmans[ z ].servisler[ a ].getServisID() );  
                            }   
                        }
                    }

                    if(bulundu_mu == 0)
                    {
                        System.out.println("\nDepartman bulunamadı...\n");
                    }
                    break;
            

                case 3:

                    int isim_bulundu_mu = 0; //aranilan isim bulunamadiginda mesaj vermek icin kullanacagim
                    
                    System.out.println("Aranack personelin adı:");
                    String ad = scanner.next();
                    
                    for ( int j = 0 ; j < departmans.length ; j++ ) {

                        for(int k = 0 ; k < departmans[ j ].personeller.length ; k++)
                        {
                            if(ad.equals(departmans[ j ].personeller[ k ].getPerAD()))
                            {
                                isim_bulundu_mu = 1;//bulundu
                                System.out.println("Personel bilgileri:" + departmans[ j ].personeller[ k ].getPerAD() +" "+departmans[ j ].personeller[ k ].getPerSOYAD()+" Yaş:"+departmans[ j ].personeller[ k ].getPerYAS()+" Id:"+departmans[ j ].personeller[ k ].getPerID() +" Departman no:"+ departmans[ j ].personeller[ k ].getDepNo());

                            }
                        }   
                    }

                    if(isim_bulundu_mu == 0)
                    {
                        System.out.println("\nPersonel bulunamadı...");
                    }

                    break;
                
                
                case 4:

                    int guzergah_bulundu_mu = 0;//guzergah bulunmadiginda mesaj vermek icin kullanacagim
                    System.out.println("\nArama yapılacak servis güzergahı:");
                    String guzergah = scanner.next();

                    for ( int j = 0 ; j < departmans.length ; j++ ) {

                        for(int k = 0 ; k < departmans[ j ].servisler.length ; k++)
                        {
                         
                            //departmans dizisinin her bir elemani nesne. her bir nesne icineki servisler dizinin elemanlarina bak
                            //get ile servis guzergahini al esit mi kontrol et   
                            if(guzergah.equals(departmans[ j ].servisler[ k ].getServisGuzergah())) 
                            {
                                guzergah_bulundu_mu = 1; //bulundu
                                System.out.println("\nServis bilgileri:" +departmans[ j ].servisler[ k ].getServisGuzergah() + " Id:" + departmans[ j ].servisler[ k ].getServisID() + " Departman no:" + departmans[ j ].servisler[ k ].getDepNo());
                            }     
                        }
                    }

                    if(guzergah_bulundu_mu == 0)
                    {
                        System.out.println("\nServis bulunamadı...");
                    }

                    break;

                case 5 :
                    System.exit(0);


                default:
                    System.out.println("\nYanlış seçim yaptınız\n");
                    break;
            }
        }
    }
}