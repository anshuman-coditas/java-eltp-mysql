package MysqlAssignment;

import java.sql.*;

public class Ques2a {
    public static void main(String[] args) {


        Statement st, st1, st2, st3;
        PreparedStatement ps, ps2, ps3;
        ResultSet rs, rs1, rs2;
        Connection con;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentDemo", "root", "root");
            System.out.println("Connected");
            CallableStatement cs=con.prepareCall("{call getrecord(?)}");
            cs.setInt(1,4);
            cs.execute();



        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}
