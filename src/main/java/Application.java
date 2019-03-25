import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        String Query="CREATE TABLE sql7285176.Kartice (\r\n" + 
        		"  id_kartice varchar(25) NOT NULL,\r\n" + 
        		"  tip varchar(20) NOT NULL,\r\n" + 
        		"  broj int(50) NOT NULL,\r\n" + 
        		"  security_code varchar(3) NOT NULL,\r\n" + 
        		"  datum_isteka varchar(5) NOT NULL,\r\n" + 
        		"  nosilac_kartice varchar(100) NOT NULL,\r\n" + 
        		"  korisnik_kartice_id varchar(255) NOT NULL,\r\n" + 
        		"  stanje decimal(20, 0) NOT NULL,\r\n" + 
        		"  PRIMARY KEY (id_kartice)\r\n" + 
        		")\r\n" + 
        		"ENGINE = INNODB,\r\n" + 
        		"CHARACTER SET latin1,\r\n" + 
        		"COLLATE latin1_swedish_ci";
        
        try
        {
          // create a mysql database connection
          String myDriver = "org.gjt.mm.mysql.Driver";
          String myUrl = "sql7285176.sql7.freemysqlhosting.net";
          Class.forName(myDriver);
          Connection conn = DriverManager.getConnection(myUrl, "root", "");
          Statement statement = conn.createStatement();
          statement.executeUpdate("INSERT INTO Kartice VALUES(1,'visa', 4242-4242-4242-4242,123,12/20,'Tarik',4321,500)");
        }
        catch (Exception e)
        {
          System.err.println("Got an exception!");
          System.err.println(e.getMessage());
        }
     
    }
}
