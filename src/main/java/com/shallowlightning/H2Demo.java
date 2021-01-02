package com.shallowlightning;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class H2Demo {
    ////////////////////////////////////////////////////////// How to use H2 database:
    // java -cp ./bin/h2-1.4.200.jar org.h2.tools.Shell   ====> embeded mode   ====> DB_URL=jdbc:h2:~/test/test2
    // java -cp ./bin/h2-1.4.200.jar org.h2.tools.Server -webAllowOthers -tcpAllowOthers  ====> server mode  ====> DB_URL=jdbc:h2:tcp://localhost/~/test
    // download H2 to linux, and run either of the above commands
    // remember to put the DB_URL, '~/test/test2' is the file path
    //////////////////////////////////////////////////////////
//  static final String JDBC_DRIVER = "org.h2.Driver";                 //=====> h2 driver(Deprecated)
//  static final String DB_URL = "jdbc:h2:~/test/test2";               //=====> h2 embeded mode
    static final String DB_URL = "jdbc:h2:tcp://localhost/~/test";     //=====> h2 server mode
//  static final String DB_URL = "jdbc:mysql://localhost:3306/demo";   //=====> mysql
    static final String USER = "sa";
    static final String PASS = "";
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt = conn.createStatement();
            String sql =  "CREATE TABLE   REGISTRATION1 " +
                    "(id INTEGER not NULL, " +
                    " first VARCHAR(255), " +
                    " last VARCHAR(255), " +
                    " age INTEGER, " +
                    " PRIMARY KEY ( id ))";
            stmt.executeUpdate(sql);   System.out.println("Created table in given database...");
            stmt.close();            conn.close();
        }
        catch(SQLException se) {        se.printStackTrace();       }
        catch(Exception e) {            e.printStackTrace();        }
        finally {
            try{if(stmt!=null) stmt.close();}catch(SQLException se2){}
            try{if(conn!=null) conn.close();}catch(SQLException se) {se.printStackTrace();}
        }
    }
}