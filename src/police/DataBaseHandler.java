/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package police;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
//lkojijiojoijioi

public class DataBaseHandler
{
    public  PreparedStatement pst ;
    public  Connection con;
    
    public DataBaseHandler()
    {
        pst = null;
        con = null;
       
    }
    public void loadDriver()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            System.out.println("Driver Loaded");
        }
        catch(Exception ex)
        {
            System.out.println("Error "+ ex.getMessage());
        }
    }
    public void connectToDatabase(String dbName,String user,String pass)
    {
        try
        {
           con = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+dbName, user, pass);
           System.out.println("Connected to database: "+ dbName);
        }
        catch (SQLException ex)
        {
            System.out.println("Error "+ ex.getMessage());
        }
    }
    public void createDataBase(String dbName)
    {        
        String query = "CREATE DATABASE IF NOT EXISTS "+dbName;
        try
        {
            connectToDatabase("mysql","root","");
            pst = con.prepareStatement(query);
            int resp =  pst.executeUpdate();
            if(resp != -1)
            {
                System.out.println("Database \""+ dbName+"\" created ");
            }

            pst.close();
            con.close();
        } 
        catch (SQLException ex)
        {
            System.out.println("Error "+ex.getMessage());
        }
    }
    public void creatTable1(String tbname)
    {
        String query = "CREATE TABLE IF NOT EXISTS "+tbname+" (id INT( 10 ) NOT NULL auto_increment ," +
                "rank VARCHAR( 30 ) NOT NULL ," +
                "firstname VARCHAR( 30 ) NOT NULL ," +
                "lastname VARCHAR( 250 ) NOT NULL ," +
                "gender VARCHAR( 10 ) NOT NULL ," +
                "phone VARCHAR( 30 ) NOT NULL ," +
                "policeID VARCHAR( 40 ) NOT NULL ," +
                "password VARCHAR( 20 ) NOT NULL ," +
                "address VARCHAR( 98 ) NOT NULL ," +
                "picture VARCHAR( 98 ) NOT NULL ," +
                "ac VARCHAR( 22 ) NOT NULL ," +
                "PRIMARY KEY ( id )) ENGINE = InnoDB ";

        try
        {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/prms", "root", "");
            pst = con.prepareStatement(query);
            int resp =  pst.executeUpdate();
            if(resp != -1)
            {
                System.out.println("Table \""+ tbname+"\" created ");
            }

            pst.close();
            con.close();
        }
        catch (SQLException ex)
        {
            System.out.println("Error "+ex.getMessage());
        }
    }
     public void creatTable2(String tbname)
    {
       String query = "CREATE TABLE IF NOT EXISTS "+tbname+" (crime_id INT( 10 ) NOT NULL auto_increment ," +
                "case_name VARCHAR( 30 ) NOT NULL ," +
                "ofname VARCHAR( 30 ) NOT NULL ," +
                "ofad VARCHAR( 60 ) NOT NULL ," +
                "statement VARCHAR( 250 ) NOT NULL ," +
                "rfname VARCHAR( 30 ) NOT NULL ," +
                "rlname VARCHAR( 40 ) NOT NULL ," +
                "rphone VARCHAR( 20 ) NOT NULL ," +
                "radd VARCHAR( 98 ) NOT NULL ," +
                "rgen VARCHAR( 28 ) NOT NULL ," +
                "rdate VARCHAR( 98 ) NOT NULL ," +
                "PRIMARY KEY ( crime_id )) ENGINE = InnoDB ";

        try
        {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/prms", "root", "");
            pst = con.prepareStatement(query);
            int resp =  pst.executeUpdate();
            if(resp != -1)
            {
                System.out.println("Table \""+ tbname+"\" created ");
            }

            pst.close();
            con.close();
        }
        catch (SQLException ex)
        {
            System.out.println("Error "+ex.getMessage());
        }
    }
    public void insertRecord()
    {
        try
        {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/prms", "root", "");
            pst = con.prepareStatement("INSERT INTO POLICE VALUES(?,?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, 0);
            pst.setString(2, "Inspector-General of Police");
            pst.setString(3,"ADEWALE");
            pst.setString(4,"MUTIAT");
            pst.setString(5, "Male");
            pst.setString(6,"08130565294");
            pst.setString(7,"NIGPOL1");
            pst.setString(8, "12345");
            pst.setString(9,"Adenike ogbomoso");
            pst.setString(10," ");
            pst.setString(11,"IGP");
            int resp =  pst.executeUpdate();
            if(resp != -1)
            {
                System.out.println("Record created ");
            }

            pst.close();
            con.close();
        }
        catch (SQLException ex)
        {
            System.out.println("Error "+ex.getMessage());
        }
    }

}