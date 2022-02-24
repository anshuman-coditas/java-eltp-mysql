package MysqlAssignment;
import java.sql.*;
import java.util.Formatter;

public class Ques3 {
    public static void main(String[] args) {
        Statement st,st1,st2,st3;
        PreparedStatement ps,ps2,ps3;
        ResultSet rs,rs1;
        Connection con;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Employee","root","root");
            System.out.println("Connected");
           /* st= con.createStatement();
            String ins1="insert into Employee2 values (1,'Alex','Manager','2022-12-02',5,600000,'Working')";
            String ins2="insert into Employee2 values (2,'Mike','Tech Lead','2014-01-02',8,900000,'Working')";
            String ins3="insert into Employee2 values (3,'Louis','Fraud Analyst','2020-10-12',3,450000,'Left')";
            String ins4="insert into Employee2 values (4,'Alicia','Associate','2021-05-13',1,300000,'Working')";
            String ins5="insert into Employee2 values (5,'Harvey','Head Manager','2019-08-05',11,1700000,'Working')";
            String ins6="insert into Employee2 values (6,'Jessica','Associate','2018-09-01',2,300000,'Left')";
            String ins7="insert into Employee2 values (7,'Samantha','Lead Analyst','2013-12-11',10,120000,'Left')";
            String ins8="insert into Employee2 values (8,'Robert','Lead Analyst','2022-01-03',4,900000,'Working')";
            String ins9="insert into Employee2 values (9,'Katrina','Associate','2020-03-11',2,500000,'Working')";
            String ins10="insert into Employee2 values (10,'Thomas','Programmer','2025-04-25',7,850000,'Left')";
            st.addBatch(ins1);
            st.addBatch(ins2);
            st.addBatch(ins3);
            st.addBatch(ins4);
            st.addBatch(ins5);
            st.addBatch(ins6);
            st.addBatch(ins7);
            st.addBatch(ins8);
            st.addBatch(ins9);
            st.addBatch(ins10);
            st.executeBatch();
            con.commit();*/
            st1= con.createStatement();;
            String show="Select * from Employee2";
            rs=st1.executeQuery(show);
            Formatter fmt=new Formatter();
            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
            System.out.printf("%15s %15s %15s %15s %15s %15s %15s","ID","NAME","DESIGNATION","DOJ","EXP","SALARY","STATUS");
            System.out.println();
            System.out.println("---------------------------------------------------------------------------------------------------------------------------");
            while(rs.next()){
                System.out.printf("%14s %16s %14s %17s %14s %14s %17s",rs.getInt(1),rs.getString(2),rs.getString(3),
                        rs.getDate(4),rs.getInt(5),rs.getInt(6),rs.getString(7));
                System.out.println();
            }

            /*System.out.println("***************************************");
            String alter="Alter table Employee2 add city varchar(30)";
            ps3= con.prepareStatement(alter);
            ps3.execute();*/
           System.out.println("*************************************************************************************");
            st2= con.createStatement();
            String show1="select * from Employee2 where city='Pune' and salary>2000";
            rs1= st2.executeQuery(show1);
            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
            System.out.printf("%15s %15s %15s %15s %15s %15s %15s","ID","NAME","DESIGNATION","DOJ","EXP","SALARY","STATUS");
            System.out.println();
            System.out.println("---------------------------------------------------------------------------------------------------------------------------");
            while(rs1.next()){
                System.out.printf("%14s %16s %14s %17s %14s %14s %17s",rs1.getInt(1),rs1.getString(2),rs1.getString(3),
                        rs1.getDate(4),rs1.getInt(5),rs1.getInt(6),rs1.getString(7));
                System.out.println();
            }

          /* String update="Update Employee2 set salary=salary+1000 where exp>3";
            ps=con.prepareStatement(update);
            ps.execute();
            String delete="Delete from Employee2 where status='left'";
            ps2=con.prepareStatement(delete);
            ps2.execute();
*/




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
             ID            NAME     DESIGNATION             DOJ             EXP          SALARY          STATUS
---------------------------------------------------------------------------------------------------------------------------
             1             Alex        Manager        2022-12-02              5         601000           Working
             2             Mike      Tech Lead        2014-01-02              8         901000           Working
             4           Alicia      Associate        2021-05-13              1         300000           Working
             5           Harvey   Head Manager        2019-08-05             11        1701000           Working
             8           Robert   Lead Analyst        2022-01-03              4         901000           Working
             9          Katrina      Associate        2020-03-11              2         500000           Working
*************************************************************************************
--------------------------------------------------------------------------------------------------------------------------
             ID            NAME     DESIGNATION             DOJ             EXP          SALARY          STATUS
---------------------------------------------------------------------------------------------------------------------------
             1             Alex        Manager        2022-12-02              5         601000           Working
             4           Alicia      Associate        2021-05-13              1         300000           Working

 */
