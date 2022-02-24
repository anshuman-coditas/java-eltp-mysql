package MysqlAssignment;

import java.sql.*;

public class Ques3a {
    public static void main(String[] args) {
        Statement st, st1, st2, st3;
        PreparedStatement ps, ps2, ps3;
        ResultSet rs, rs1,rs2;
        Connection con;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentDemo", "root", "root");
            System.out.println("Connected");
            /*String update="alter table student add column gender varchar(1)";
            ps= con.prepareStatement(update);
            ps.execute();*/
            st= con.createStatement();
            String show="select * from student where year=3 and percent>76";
            rs=st.executeQuery(show);
            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
            System.out.printf("%15s %15s %15s %15s %15s %15s ","ID","NAME","YEAR","PERCENTAGE","CITY","GENDER");
            System.out.println();
            System.out.println("---------------------------------------------------------------------------------------------------------------------------");
            while(rs.next()){
                System.out.printf("%14s %17s %14s %15s %14s %15s ",rs.getInt(1),rs.getString(2),rs.getInt(3),
                        rs.getString(4),rs.getFloat(5),rs.getString(6));
                System.out.println();
            }
            System.out.println("********************************************");
            st1= con.createStatement();
            String show1="select * from student where id between 1 and 10";
            rs1=st1.executeQuery(show1);
            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
            System.out.printf("%15s %15s %15s %15s %15s %15s ","ID","NAME","YEAR","PERCENTAGE","CITY","GENDER");
            System.out.println();
            System.out.println("---------------------------------------------------------------------------------------------------------------------------");
            while(rs1.next()){
                System.out.printf("%14s %17s %14s %15s %14s %15s ",rs1.getInt(1),rs1.getString(2),rs1.getInt(3),
                        rs1.getString(4),rs1.getFloat(5),rs1.getString(6));
                System.out.println();
            }
           /* st2= con.createStatement();
            String ins1="insert into student values(6,'Emily',4,'Pune',89.8,'F')";
            String ins2="insert into student values(7,'Thomas',2,'Delhi',78.6,'M')";
            String ins3="insert into student values(8,'Arthur',3,'Bangalore',94.5,'M')";
            st2.addBatch(ins1);
            st2.addBatch(ins2);
            st2.addBatch(ins3);
            st2.executeBatch();*/
            /*String update="update student set name = CASE WHEN(gender='M') then CONCAT('Mr. ',name) WHEN(gender='F') then CONCAT('Ms. ',name) END";
            ps2= con.prepareStatement(update);
            ps2.execute();

            String delete="delete from student where year=4";
            ps3= con.prepareStatement(delete);
            ps3.execute();*/
            System.out.println("*************************************");
            st3= con.createStatement();
            String showLast="select * from student";
            rs2=st3.executeQuery(showLast);
            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
            System.out.printf("%15s %15s %15s %15s %15s %15s ","ID","NAME","YEAR","PERCENTAGE","CITY","GENDER");
            System.out.println();
            System.out.println("---------------------------------------------------------------------------------------------------------------------------");
            while(rs2.next()){
                System.out.printf("%14s %17s %14s %15s %14s %15s ",rs2.getInt(1),rs2.getString(2),rs2.getInt(3),
                        rs2.getString(4),rs2.getFloat(5),rs2.getString(6));
                System.out.println();
            }




        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}
/*
Connected
--------------------------------------------------------------------------------------------------------------------------
             ID            NAME            YEAR      PERCENTAGE            CITY          GENDER
---------------------------------------------------------------------------------------------------------------------------
             4    Mr. Mr. Harvey              3          Mumbai           96.0               M
             8    Mr. Mr. Arthur              3       Bangalore           95.0               M
********************************************
--------------------------------------------------------------------------------------------------------------------------
             ID            NAME            YEAR      PERCENTAGE            CITY          GENDER
---------------------------------------------------------------------------------------------------------------------------
             1      Mr. Mr. Alex              1           Delhi           90.0               M
             2      Mr. Mr. Mike              2           Delhi           89.0               M
             4    Mr. Mr. Harvey              3          Mumbai           96.0               M
             7    Mr. Mr. Thomas              2           Delhi           79.0               M
             8    Mr. Mr. Arthur              3       Bangalore           95.0               M
*************************************
--------------------------------------------------------------------------------------------------------------------------
             ID            NAME            YEAR      PERCENTAGE            CITY          GENDER
---------------------------------------------------------------------------------------------------------------------------
             1      Mr. Mr. Alex              1           Delhi           90.0               M
             2      Mr. Mr. Mike              2           Delhi           89.0               M
             4    Mr. Mr. Harvey              3          Mumbai           96.0               M
             7    Mr. Mr. Thomas              2           Delhi           79.0               M
             8    Mr. Mr. Arthur              3       Bangalore           95.0               M

It is Showing Mr. Mr. Because It got executed 2 Times.
 */
