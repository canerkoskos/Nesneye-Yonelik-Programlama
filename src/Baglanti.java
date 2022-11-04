import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Baglanti {
    
    private String kullanici_adi = "caner";
    private String parola = "1234";
    static Connection con = null;    
    static Statement statement = null;
    
       
    public Baglanti() {
        
        String url = "jdbc:derby://localhost:1527/atm";
   
        
        
        try {
            con = DriverManager.getConnection(url, kullanici_adi, parola);
            System.out.println("Bağlantı Başarılı...");
            
            
        } catch (SQLException ex) {
            System.out.println("Bağlantı Başarısız...");
            //ex.printStackTrace();
        }
        
    }
    
}
