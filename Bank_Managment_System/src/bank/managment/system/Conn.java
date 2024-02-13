
package bank.managment.system;

import java.sql.*;

public class Conn {
    
    Connection c;
    Statement s;
    public Conn(){
        try{
           
            c=DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","40603944@M");
            s=c.createStatement();
            
        }catch(Exception e){
            System.out.println(e);
        }
    }
   
    
}
