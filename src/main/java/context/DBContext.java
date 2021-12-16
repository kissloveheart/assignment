
package context;


import java.sql.Connection;
import java.sql.DriverManager;


public class DBContext {

    
    /*USE BELOW METHOD FOR YOUR DATABASE CONNECTION FOR BOTH SINGLE AND MULTILPE SQL SERVER INSTANCE(s)*/
    /*DO NOT EDIT THE BELOW METHOD, YOU MUST USE ONLY THIS ONE FOR YOUR DATABASE CONNECTION*/
     public Connection getConnection()throws Exception {
//        String url = "jdbc:sqlserver://"+serverName+":"+portNumber + "\\" + instance +";databaseName="+dbName;
//        if(instance == null || instance.trim().isEmpty())
//            url = "jdbc:sqlserver://"+serverName+":"+portNumber +";databaseName="+dbName;
//        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    	 //PostgreSQL 
//    	String url = "jdbc:postgresql://"+serverName+":"+portNumber +"/"+dbName;
//    	 Connection conn = null;
//        try {
//            Class.forName("org.postgresql.Driver"); // load driver name
//            conn = DriverManager.getConnection(url, userID, password);  
//         } catch (Exception e) {
//            e.printStackTrace();
//            System.err.println(e.getClass().getName()+": "+e.getMessage());
//            System.exit(0);
//         }
//         System.out.println("Opened database successfully");  	 
    	 String dbUrl = System.getenv("JDBC_DATABASE_URL");
    	    return DriverManager.getConnection(dbUrl);
    }   

    /*Insert your other code right after this comment*/
    /*Change/update information of your database connection, DO NOT change name of instance variables in this class*/
    private final String serverName = "localhost";
    private final String dbName = "postgres";
    private final String portNumber = "5434";
    private final String instance="";//LEAVE THIS ONE EMPTY IF YOUR SQL IS A SINGLE INSTANCE
    private final String userID = "postgres";
    private final String password = "admin";

	
    
    
}
 