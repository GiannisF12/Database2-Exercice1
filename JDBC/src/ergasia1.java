import java.io.*;
import java.text.*;
import java.util.*;
import java.sql.*;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;




public class ergasia1 
{
    Scanner scanner = new Scanner(System.in);
    String DB_URL = "jdbc:mysql://localhost:3306/university";
    String USER = "root";
    String PASS = "";

    private static final String createTable = "CREATE TABLE course ("
                    + "cname VARCHAR(100) NOT NULL,"
                    + "meets_at DATE NOT NULL,"
                    + "room VARCHAR(100) NOT NULL,"
                    + "fid INTEGER NOT NULL,"
                    + "PRIMARY KEY (cname))";

    public void create_table()
    {
        ResultSet rs;
        Statement stmt;

        try
        {
            Connection con = DriverManager.getConnection(DB_URL, USER, PASS);

            stmt = con.createStatement();
            stmt.executeUpdate(createTable);
            System.out.println("Table created");

            String sql = "INSERT INTO course VALUES ('istoria','2022-05-28','amfitheatro',3)";
            stmt.executeUpdate(sql);


        }
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
    }
    

    public void insert_user() //erwthma 1
    {
        try
        {
            Connection con = DriverManager.getConnection(DB_URL, USER, PASS);

            System.out.println("Enter snum: ");
            String snum = scanner.nextLine();

            System.out.println("Enter sname: ");
            String sname = scanner.nextLine();

            System.out.println("Enter deptid: ");
            String deptid = scanner.nextLine();

            System.out.println("Enter slevel: ");
            String slevel = scanner.nextLine();

            System.out.println("Enter age: ");
            String age = scanner.nextLine();

            String insert_user = "INSERT into STUDENT " + " (snum, sname, deptid, slevel, age)" + " values (?, ?, ?, ?, ?)";
            PreparedStatement pstmt = con.prepareStatement(insert_user);

            pstmt.setString(1, snum);
            pstmt.setString(2, sname);
            pstmt.setString(3, deptid);
            pstmt.setString(4, slevel);
            pstmt.setString(5, age);

            pstmt.executeUpdate();
            System.out.println("Student Registered");
        }
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
              
    }

    public void delete_user() //erwthma 2
    {
        try
        {
            Connection con = DriverManager.getConnection(DB_URL, USER, PASS);

            System.out.println("Choose user's id to delete: ");
            String delete = scanner.nextLine();
            
            String delete_user = "delete from STUDENT where SNUM="+delete+" ";
            PreparedStatement pstmt2 = con.prepareStatement(delete_user);
            pstmt2.executeUpdate();
            System.out.println("Student Deleted");
        }
        catch (SQLException e) 
        {
            e.printStackTrace();
        }

    
    }

    public void stats() //erwthma 3
    {
        ResultSet rs,rs2;
        Statement stmt,stmt2;
        int snum,deptid=0,age,deptid_user=0;
        String sname,slevel,dname;
        try
        {
            Connection con = DriverManager.getConnection(DB_URL, USER, PASS);

            stmt = con.createStatement();
            stmt2 = con.createStatement();

            rs = stmt.executeQuery("SELECT * FROM department ORDER BY dname ASC ");
    
            while(rs.next())
            {
                int count = 0; 
                deptid = rs.getInt("deptid");
                dname = rs.getString("dname");
                rs2 = stmt2.executeQuery("SELECT * FROM student WHERE deptid="+deptid+" ORDER BY sname ASC ");
                System.out.println("\nDepartment:"+dname);
                while(rs2.next())
                {
                    count++;
                    sname = rs2.getString("sname");
                    System.out.println(+count+": "+sname);
                            
                }
                System.out.println("Total number of Students:"+count);
                System.out.println("\n");
            }
                
        }
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
    }

    public void stats2() //erwthma 4
    {
        ResultSet rs,rs2,rs3;
        Statement stmt,stmt2,stmt3;
        int snum;
        String cname,sname;
        try
        {
            Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = con.createStatement();
            stmt2 = con.createStatement();
            stmt3 = con.createStatement();

            rs = stmt.executeQuery("SELECT * FROM course ");
            while(rs.next())
            {
                cname = rs.getString("cname");

                rs2 = stmt2.executeQuery("SELECT * FROM enrolled ");
                while(rs2.next())
                {
                    snum = rs2.getInt("snum");

                    rs3 = stmt3.executeQuery("SELECT * FROM student WHERE snum="+snum+"");
                    while(rs3.next())
                    {
                        sname = rs3.getString("sname");
                        System.out.println("Student with name: "+sname+" is enrolled in class: "+cname);
                    }

                }

            }

        }
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
    }

    
    public static void main(String args[]) 
    {
        ergasia1 pro = new ergasia1();
        Scanner scanner = new Scanner(System.in);
        int value;

        do
        {
            System.out.println("Options:");
            System.out.println("1. Insert Student");
            System.out.println("2. Delete Student");
            System.out.println("3. Stats");
            System.out.println("4. Stats2");
            System.out.println("5. Exit");
            System.out.println("Select Option:");
            value = scanner.nextInt();

            switch (value) 
            {
                case 1:
                System.out.println("Option 1 selected");
                pro.insert_user();
                break;

                case 2:
                System.out.println("Option 2 selected");
                pro.delete_user();
                break;

                case 3:
                System.out.println("Option 3 selected");
                pro.stats();
                break;

                case 4:
                System.out.println("Option 4 selected");
                pro.stats2();
                break;

                case 5:
                System.out.println("Exit selected");
                break;
            }

        }
        while(value !=5);

        //pro.create_table();


            
            
         
    }
}