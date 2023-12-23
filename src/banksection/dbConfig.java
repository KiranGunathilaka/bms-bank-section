
package banksection;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.util.logging.Logger;
import java.util.logging.Level;
/**
 *
 * @author User
 */
public class dbConfig {
    private static String serverName = "localhost";
    private static String userName = "root";
    private static String password = "";
    private static String dbName = "bankmanagementdatabase";
    private static int port = 3306;
    
    public static Connection getConn(){
        Connection conn = null;
        
        MysqlDataSource dataSource = new MysqlDataSource();
        
        dataSource.setServerName(serverName);
        dataSource.setUser(userName);
        dataSource.setPassword(password);
        dataSource.setDatabaseName(dbName);
        dataSource.setPortNumber(port);
        
        try{
        conn = dataSource.getConnection();
        System.out.println("Connection successful");
        return conn;
        }
        catch(SQLException ex){
            System.out.println("Connection failed");
            JOptionPane.showMessageDialog(null,"Connection Failed", "Eror",2);
            Logger.getLogger("Get Connection ->" + dbConfig.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
