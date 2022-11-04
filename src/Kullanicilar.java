import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author canerkoskos
 */

interface IGiris{
public String getAdSoyad(int a);
public String getSifre(int a);
public boolean sifredegistirme(int a,String b);
}

interface IMusteri{

public double getBakiye(int a);
public double getFatura(int a);
public boolean faturaode(int a);
public boolean paracekme(int a,double b);
public boolean parayatırma(int a,double b);
public boolean paratransferi(int a,int b,double c);

}

interface IPersonel{

public int getHesapno(int a);
public boolean getKartdurumu(int a);
public double getKartlimiti(int a);
public boolean getKredidurumu(int a);
public boolean KartonayiGuncelle(int a,boolean b);
public boolean KartlimitiGuncelle(int a,double b);
public boolean KredionayiGuncelle(int a,boolean b);
public boolean HesapnoGuncelle(int a,int b);
public boolean Musteriekle(String ad,String soyad,int hesapno,boolean kredikarti,boolean kredionayi,double kredikartılimiti);

}

abstract class Kullanicilar extends Baglanti implements IGiris {
    
}
class Musteri extends Kullanicilar implements IMusteri{

    int hizmetno;
    
    @Override
    public String getSifre(int a) {
        String sorgu = "Select * From musteri where hizmetno="+a;
      
        try {
            statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sorgu);
            
            while (rs.next()) {
                               
                String sifre = rs.getString("sifre");
                
                return sifre;
                               
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Baglanti.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return "";
        
    }
    @Override
    public double getBakiye(int a) {
        String sorgu = "Select * From islemmusteri where hizmetno="+a;
      
        try {
            statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sorgu);
            
            while (rs.next()) {
                               
                double bakiye = rs.getDouble("bakiye");
                
                return bakiye;
                               
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Baglanti.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return 0;
        
    }
    @Override
    public double getFatura(int a){
        String sorgu = "Select * From islemmusteri where hizmetno="+a;
        try {
            statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sorgu);
            
            while (rs.next()) {
                               
                double fatura = rs.getDouble("fatura");
                return fatura;
                
            }
               
        } catch (SQLException ex) {
            Logger.getLogger(Baglanti.class.getName()).log(Level.SEVERE, null, ex);
        }

       return 0;
    }
    @Override
    public boolean faturaode(int a){
        String sorgu = "Select * From islemmusteri where hizmetno="+a;
        double bakiye = 0,fatura = 0;
        boolean sonuc=true;
    
         try {
            statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sorgu);
            
            while (rs.next()) {
                               
                bakiye = rs.getDouble("bakiye");
                fatura = rs.getDouble("fatura");
                
            }
               
        } catch (SQLException ex) {
            Logger.getLogger(Baglanti.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(bakiye>=fatura) {
            bakiye=bakiye-fatura;
            
        try {
            statement = con.createStatement();
            
            String sorgu1 = "Update islemmusteri Set bakiye = "+bakiye+" where hizmetno="+a;
            String sorgu2 = "Update islemmusteri Set fatura = 0 where hizmetno="+a;
            
            statement.executeUpdate(sorgu1);
            statement.executeUpdate(sorgu2);
            
        sonuc=true;
            
        } catch (SQLException ex) {
            Logger.getLogger(Baglanti.class.getName()).log(Level.SEVERE, null, ex);
        } 
        }
        else{
        sonuc= false;  
                
        }
        return sonuc;
    }
    @Override
    public String getAdSoyad(int a){
    String sorgu = "Select * From musteri where hizmetno="+a;
    String ad="";
    String soyad="";
        try {
            statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sorgu);
            
            while (rs.next()) {
                               
                ad = rs.getString("ad");
                soyad=rs.getString("soyad");                
            }
                        
        } 
        catch (SQLException ex) {
            Logger.getLogger(Musteri.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ad+" "+soyad;
    
    }
    @Override
    public boolean paracekme(int a,double b){
    String sorgu = "Select * From islemmusteri where hizmetno="+a;
        double cek=b;
        double bakiye = 0;
        boolean sonuc=true;
    
         try {
            statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sorgu);
            
            while (rs.next()) {
                               
                bakiye = rs.getDouble("bakiye");
                               
            }
               
        } catch (SQLException ex) {
            Logger.getLogger(Baglanti.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(bakiye>=cek) {
            bakiye=bakiye-cek;
            
        try {
            statement = con.createStatement();
            
            String sorgu1 = "Update islemmusteri Set bakiye = "+bakiye+" where hizmetno="+a;
                       
            statement.executeUpdate(sorgu1);
                        
        sonuc=true;
            
        } catch (SQLException ex) {
            Logger.getLogger(Baglanti.class.getName()).log(Level.SEVERE, null, ex);
        } 
        }
        else{
        sonuc= false;         
        }
        return sonuc;
        
    }
    @Override
    public boolean parayatırma(int a,double b){
    String sorgu = "Select * From islemmusteri where hizmetno="+a;
        double yatır=b;
        double bakiye = 0;
        boolean sonuc=true;
    
         try {
            statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sorgu);
            
            while (rs.next()) {
                               
                bakiye = rs.getDouble("bakiye");
                               
            }
               
        } catch (SQLException ex) {
            Logger.getLogger(Baglanti.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(yatır>0){ 
            bakiye=bakiye+yatır;
        try {
            statement = con.createStatement();
            
            String sorgu1 = "Update islemmusteri Set bakiye = "+bakiye+" where hizmetno="+a;
                       
            statement.executeUpdate(sorgu1);
                                   
        } 
        catch (SQLException ex) {
            Logger.getLogger(Baglanti.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        else{        
        sonuc=false;        
        }
        
        return sonuc;        
    }
    @Override
    public boolean paratransferi(int a,int b,double c){
    String sorgu1 = "Select * From islemmusteri where hizmetno="+a;
    String sorgu2 = "Select * From islemmusteri where hesapno="+b;
    double bakiye1 = 0,bakiye2=0,transfer=c;
    int hesno=0;
        boolean sonuc=true;
    
         try {
            statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sorgu1);
            
            while (rs.next()) {
                               
                bakiye1 = rs.getDouble("bakiye");
                               
            }
               
        } catch (SQLException ex) {
            Logger.getLogger(Baglanti.class.getName()).log(Level.SEVERE, null, ex);
        }
         try {
            statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sorgu1);
            
            while (rs.next()) {
                               
                hesno = rs.getInt("hesapno");
                               
            }
               
        } catch (SQLException ex) {
            Logger.getLogger(Baglanti.class.getName()).log(Level.SEVERE, null, ex);
        }
         try {
            statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sorgu2);
            
            while (rs.next()) {
                               
                bakiye2 = rs.getDouble("bakiye");
                               
            }
               
        } catch (SQLException ex) {
            Logger.getLogger(Baglanti.class.getName()).log(Level.SEVERE, null, ex);
        }
         if(hesno==b){
         return false;
         }
         else if(bakiye1>=transfer){
        bakiye1=bakiye1-transfer;
        bakiye2=bakiye2+transfer;
        try {
            statement = con.createStatement();
            
            String sorgu3 = "Update islemmusteri Set bakiye = "+bakiye1+" where hizmetno="+a;
            String sorgu4 = "Update islemmusteri Set bakiye = "+bakiye2+" where hesapno="+b;
                       
            statement.executeUpdate(sorgu3);
            statement.executeUpdate(sorgu4);
                                   
        } 
        catch (SQLException ex) {
            Logger.getLogger(Baglanti.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    else{
        sonuc=false;}
    return sonuc;
    }
    @Override
    public boolean sifredegistirme(int a,String b){
        String sorgu = "Select * From musteri where hizmetno="+a;
        String sifre1="",sifre2=b;
        boolean sonuc=true;
        try {
            statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sorgu);
            
            while (rs.next()) {
                               
                sifre1 = rs.getString("sifre");
                
            }
      
        } catch (SQLException ex) {
            Logger.getLogger(Baglanti.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(!sifre1.equals(sifre2)) {
        sifre1=sifre2;    
            
        try {
            statement = con.createStatement();
            
            String sorgu1 = "Update musteri Set sifre = '"+sifre1+"' where hizmetno="+a;
                       
            statement.executeUpdate(sorgu1);
                        
        sonuc=true;
            
        } catch (SQLException ex) {
            Logger.getLogger(Baglanti.class.getName()).log(Level.SEVERE, null, ex);
        } 
        }
        else{
        sonuc= false;         
        }
        return sonuc;
    
    
    }
}


abstract class Calisan extends Kullanicilar{
  
public abstract String getAd(int a);
public abstract String getSoyad(int a);
public abstract boolean adGuncelle(int a,String b);
public abstract boolean soyadGuncelle(int a,String b);
  
}

class Personel extends Calisan implements IPersonel{

    @Override
    public String getAdSoyad(int a) {
    String sorgu = "Select * From calisan where id="+a;
    String ad="";
    String soyad="";
        try {
            statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sorgu);
            
            while (rs.next()) {
                               
                ad = rs.getString("ad");
                soyad=rs.getString("soyad");                
            }
                        
        } 
        catch (SQLException ex) {
            Logger.getLogger(Musteri.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ad+" "+soyad;
    
    }

    @Override
    public String getSifre(int a) {
        String sorgu = "Select * From calisan where id="+a;
      
        try {
            statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sorgu);
            
            while (rs.next()) {
                               
                String sifre = rs.getString("sifre");
                
                return sifre;
                               
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Baglanti.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return "";
        
    }

    @Override
    public String getAd(int a) {
        String sorgu = "Select * From islemcalisan where hesapno="+a;
      
        try {
            statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sorgu);
            
            while (rs.next()) {
                               
                String ad = rs.getString("ad");
                
                return ad;
                               
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Baglanti.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return "";
    }

    @Override
    public String getSoyad(int a) {
        String sorgu = "Select * From islemcalisan where hesapno="+a;
      
        try {
            statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sorgu);
            
            while (rs.next()) {
                               
                String soyad = rs.getString("soyad");
                
                return soyad;
                               
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Baglanti.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return "";
    }

    @Override
    public int getHesapno(int a) {
        String sorgu = "Select * From islemcalisan where hesapno="+a;
      
        try {
            statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sorgu);
            
            while (rs.next()) {
                               
                int hesapno = rs.getInt("hesapno");
                
                return hesapno;
                               
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Baglanti.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return 0;
    }

    @Override
    public boolean getKartdurumu(int a) {
        String sorgu = "Select * From islemcalisan where hesapno="+a;
      
        try {
            statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sorgu);
            
            while (rs.next()) {
                               
                boolean kartdurumu = rs.getBoolean("kredikartı");
                
                return kartdurumu;
                               
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Baglanti.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }

    @Override
    public double getKartlimiti(int a) {
        String sorgu = "Select * From islemcalisan where hesapno="+a;
      
        try {
            statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sorgu);
            
            while (rs.next()) {
                               
                double kartlimiti = rs.getDouble("kredikartılimiti");
                
                return kartlimiti;                               
            }
                       
        } catch (SQLException ex) {
            Logger.getLogger(Baglanti.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return 0;
    }

    @Override
    public boolean getKredidurumu(int a) {
        String sorgu = "Select * From islemcalisan where hesapno="+a;
      
        try {
            statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sorgu);
            
            while (rs.next()) {
                               
                boolean kredionayi = rs.getBoolean("kredionayi");
                
                return kredionayi;                               
            }
                      
        } catch (SQLException ex) {
            Logger.getLogger(Baglanti.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }

    @Override
    public boolean KartonayiGuncelle(int a,boolean b) {
       
        try {
            statement = con.createStatement();
            
            String sorgu1 = "Update islemcalisan Set kredikarti = "+b+" where hesapno="+a;
                       
            statement.executeUpdate(sorgu1);
            return true;
                                   
        } 
        catch (SQLException ex) {
            Logger.getLogger(Baglanti.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
           
    }

    @Override
    public boolean KartlimitiGuncelle(int a,double b) {
       
        if(b>=0){ 
            
        try {
            statement = con.createStatement();
            
            String sorgu1 = "Update islemcalisan Set kredikartilimiti = "+b+" where hesapno="+a;
                       
            statement.executeUpdate(sorgu1);
            return true;                       
        } 
        catch (SQLException ex) {
            Logger.getLogger(Baglanti.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        }
        else{        
        return false;        
        }
              
    }

    @Override
    public boolean KredionayiGuncelle(int a,boolean b) {
        try {
            statement = con.createStatement();
            
            String sorgu1 = "Update islemcalisan Set kredionayi = "+b+" where hesapno="+a;
                       
            statement.executeUpdate(sorgu1);
            return true;                       
        } 
        catch (SQLException ex) {
            Logger.getLogger(Baglanti.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean Musteriekle(String ad, String soyad, int hesapno, boolean kredikarti, boolean kredionayi, double kredikartilimiti) {
         try {
            statement = con.createStatement();
            
            String sorgu = "Insert Into islemcalisan (ad,soyad,hesapno,kredikartı,kredionayi,kredikartilimiti) VALUES(" + "'" + ad + "'," + "'" + soyad + "'," + hesapno +","+kredikarti+","+kredionayi+","+kredikartilimiti+")";
            
            statement.executeUpdate(sorgu);
            return true;
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Baglanti.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean adGuncelle(int a,String b) {
        try {
            statement = con.createStatement();
            
            String sorgu1 = "Update islemcalisan Set ad = '"+b+"' where hesapno="+a;
                       
            statement.executeUpdate(sorgu1);
            return true;                       
        } 
        catch (SQLException ex) {
            Logger.getLogger(Baglanti.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean soyadGuncelle(int a,String b) {
        try {
            statement = con.createStatement();
            
            String sorgu1 = "Update islemcalisan Set soyad = '"+b+"' where hesapno="+a;
                       
            statement.executeUpdate(sorgu1);
            return true;                       
        } 
        catch (SQLException ex) {
            Logger.getLogger(Baglanti.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean HesapnoGuncelle(int a, int b) {
         try {
            statement = con.createStatement();
            
            String sorgu1 = "Update islemcalisan Set hesapno = "+b+" where hesapno="+a;
                       
            statement.executeUpdate(sorgu1);
            return true;                       
        } 
        catch (SQLException ex) {
            Logger.getLogger(Baglanti.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean sifredegistirme(int a, String b) {
        String sorgu = "Select * From calisan where id="+a;
        String sifre1="",sifre2=b;
        boolean sonuc=true;
        try {
            statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sorgu);
            
            while (rs.next()) {
                               
                sifre1 = rs.getString("sifre");
                
            }
      
        } catch (SQLException ex) {
            Logger.getLogger(Baglanti.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(!sifre1.equals(sifre2)) {
        sifre1=sifre2;    
            
        try {
            statement = con.createStatement();
            
            String sorgu1 = "Update calisan Set sifre = '"+sifre1+"' where id="+a;
                       
            statement.executeUpdate(sorgu1);
                        
        sonuc=true;
            
        } catch (SQLException ex) {
            Logger.getLogger(Baglanti.class.getName()).log(Level.SEVERE, null, ex);
        } 
        }
        else{
        sonuc= false;         
        }
        return sonuc;
    }
    
}

   
class Yonetici extends Calisan{

    @Override
    public String getAdSoyad(int a) {
        String sorgu = "Select * From yonetici where id="+a;
        String ad="";
        String soyad="";
        try {
            statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sorgu);
            
            while (rs.next()) {
                               
                ad = rs.getString("ad");
                soyad=rs.getString("soyad");                
            }
                        
        } 
        catch (SQLException ex) {
            Logger.getLogger(Musteri.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ad+" "+soyad;   
    }
    @Override
    public String getSifre(int a) {
        String sorgu = "Select * From yonetici where id="+a;
      
        try {
            statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sorgu);
            
            while (rs.next()) {
                               
                String sifre = rs.getString("sifre");
                
                return sifre;
                               
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Baglanti.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return "";
    }

    @Override
    public String getAd(int a) {
        String sorgu = "Select * From islemyonetici where id="+a;
      
        try {
            statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sorgu);
            
            while (rs.next()) {
                               
                String ad = rs.getString("ad");
                
                return ad;
                               
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Baglanti.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return "";
    }
    @Override
    public String getSoyad(int a) {
        String sorgu = "Select * From islemyonetici where id="+a;
      
        try {
            statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sorgu);
            
            while (rs.next()) {
                               
                String soyad = rs.getString("soyad");
                
                return soyad;
                               
            }
                
        } catch (SQLException ex) {
            Logger.getLogger(Baglanti.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return "";
        
    }
    public static int getId(int a){
    String sorgu = "Select * From islemyonetici where id="+a;
      
        try {
            statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sorgu);
            
            while (rs.next()) {
                               
                int id = rs.getInt("id");
                
                return id;
                               
            }
                
        } catch (SQLException ex) {
            Logger.getLogger(Baglanti.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return 0;
    }
    public static double getMaas(int a){
    String sorgu = "Select * From islemyonetici where id="+a;
      
        try {
            statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sorgu);
            
            while (rs.next()) {
                               
                double maas = rs.getDouble("maas");
                
                return maas;
                               
            }
                
        } catch (SQLException ex) {
            Logger.getLogger(Baglanti.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return 0;
    
    }

    @Override
    public boolean adGuncelle(int a, String b) {
        try {
            statement = con.createStatement();
            
            String sorgu1 = "Update islemyonetici Set ad = '"+b+"' where id="+a;
                       
            statement.executeUpdate(sorgu1);
            return true;                       
        } 
        catch (SQLException ex) {
            Logger.getLogger(Baglanti.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean soyadGuncelle(int a, String b) {
        try {
            statement = con.createStatement();
            
            String sorgu1 = "Update islemyonetici Set soyad = '"+b+"' where id="+a;
                       
            statement.executeUpdate(sorgu1);
            return true;                       
        } 
        catch (SQLException ex) {
            Logger.getLogger(Baglanti.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    public static boolean idGuncelle(int a, int b) {
    try {
            statement = con.createStatement();
            
            String sorgu1 = "Update islemyonetici Set id = "+b+" where id="+a;
                       
            statement.executeUpdate(sorgu1);
            return true;                       
        } 
        catch (SQLException ex) {
            Logger.getLogger(Baglanti.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    public static boolean maasGuncelle(int a, double b) {
    try {
            statement = con.createStatement();
            
            String sorgu1 = "Update islemyonetici Set maas = "+b+" where id="+a;
                       
            statement.executeUpdate(sorgu1);
            return true;                       
        } 
        catch (SQLException ex) {
            Logger.getLogger(Baglanti.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    public static boolean calisanEkle(String ad, String soyad, int id, double maas) {
         try {
            statement = con.createStatement();
            
            String sorgu = "Insert Into islemyonetici (ad,soyad,id,maas) VALUES(" + "'" + ad + "'," + "'" + soyad + "'," + id +","+maas+")";
            
            statement.executeUpdate(sorgu);
            return true;
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Baglanti.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean sifredegistirme(int a, String b) {
        String sorgu = "Select * From yonetici where id="+a;
        String sifre1="",sifre2=b;
        boolean sonuc=true;
        try {
            statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sorgu);
            
            while (rs.next()) {
                               
                sifre1 = rs.getString("sifre");
                
            }
      
        } catch (SQLException ex) {
            Logger.getLogger(Baglanti.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(!sifre1.equals(sifre2)) {
        sifre1=sifre2;    
            
        try {
            statement = con.createStatement();
            
            String sorgu1 = "Update yonetici Set sifre = '"+sifre1+"' where id="+a;
                       
            statement.executeUpdate(sorgu1);
                        
        sonuc=true;
            
        } catch (SQLException ex) {
            Logger.getLogger(Baglanti.class.getName()).log(Level.SEVERE, null, ex);
        } 
        }
        else{
        sonuc= false;         
        }
        return sonuc;
    }

}