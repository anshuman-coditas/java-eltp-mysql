package MysqlAssignment;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;

public class Ques4 {
    public static void main(String[] args) {


        Statement st, st1, st2, st3;
        PreparedStatement ps, ps2, ps3;
        ResultSet rs, rs1, rs2;
        Connection con;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentDemo", "root", "root");
            System.out.println("Connected");
           ps=con.prepareStatement("select * from image");
           rs=ps.executeQuery();
           if(rs.next()){
               Blob b=rs.getBlob(2);
               byte[] byteArr=b.getBytes(2,(int)b.length());
               FileOutputStream fout=new FileOutputStream("C:/Users/Coditas/Dekstop/file.jpg");
               fout.write(byteArr);
               fout.close();
           }
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        catch (SQLException e){
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
