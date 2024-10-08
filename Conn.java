package bank.management.system;

import java.sql.*;

public class Conn {
   
    //Step 1 : Create Connection
    Connection c;
    Statement s;
    public Conn(){
        try{
            c=DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem", "root", "shubhankar@2004");
            s=c.createStatement();
            
        } catch (Exception e){
            System.out.println(e);
        }
    }
    
}
