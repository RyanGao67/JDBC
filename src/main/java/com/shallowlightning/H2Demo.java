package com.shallowlightning;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class H2Demo {
    // How to use H2 database:
    // java -cp ./bin/h2-1.4.200.jar org.h2.tools.Shell
    // download H2 to linux, and run the above command
    // remember to put the DB_URL, '~/test/test2' is the file path
//  static final String JDBC_DRIVER = "org.h2.Driver";
    static final String DB_URL = "jdbc:h2:~/test/test2";               //=====> h2
//  static final String dbUrl  = "jdbc:mysql://localhost:3306/demo";   //=====> mysql
    static final String USER = "sa";
    static final String PASS = "";
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt = conn.createStatement();
            String sql =  "CREATE TABLE   REGISTRATION " +
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