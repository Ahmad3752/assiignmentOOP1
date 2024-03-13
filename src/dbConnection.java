import java.sql.Connection;
import java.sql.DriverManager;
public class dbConnection {
    static Connection con=null;
    public static Connection getConnectionMethod(){
        try {
            String url = "jdbc:mysql://localhost:3306/";
            String userName = "root";
            String db = "ali";
            String passWord = "qw4hddqcrghm";
            con=DriverManager.getConnection(url+db,userName,passWord);
            System.out.println("connected successfully");
        }catch (Exception e){
            e.printStackTrace();
        }

        return con;
    }
}
