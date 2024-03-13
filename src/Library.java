import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.*;

public  class Library {
    Scanner sc=new Scanner(System.in);

    public  void addBook(book books) {

        try {
            Connection con = dbConnection.getConnectionMethod();
            String Query = query.insert;
            PreparedStatement ps = con.prepareStatement(Query);
            ps.setInt(1, books.getBid());
            ps.setString(2, books.btitle);
            ps.setString(3, books.bauthor);
            ps.setString(4, books.bgenre);
            ps.setString(5, Character.toString(books.bAvailability));
            ps.executeUpdate();
            ps.close();
            System.out.println("add book successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
        public void addUser(User user) {
        try {
            Connection con = dbConnection.getConnectionMethod();
            String Query = query.insertuser;
            PreparedStatement ps = con.prepareStatement(Query);
            ps.setInt(1, user.getUid());
            ps.setString(2, user.getUname());
            ps.setString(3, user.getUcontact());
            ps.setString(4,user.getUborrowedbooks());
            ps.executeUpdate();
            ps.close();
            System.out.println("user added successfully ");
        }catch (SQLException e) {
            e.printStackTrace();
        }
        }
public void displayBook(){
        try {
            Connection con = dbConnection.getConnectionMethod();
            String Query = query.insertDisplay;
            Statement st = con.createStatement();
           ResultSet rs=st.executeQuery(Query);
            System.out.println("BOOK_ID\t BOOK_TITLE\tBOOK_AUTHOR\tBOOK_GENRE\tBOOK_AVAILABILITY");
            while (rs.next()) {
                System.out.println( rs.getInt(1)+"\t\t"+ rs.getString(2)+"\t\t"+ rs.getString(3)+"\t\t"+ rs.getString(4)+"\t\t"+ rs.getString(5));


            }
            System.out.println("table values read succesfully");

        }catch (Exception e){
            e.printStackTrace();
        }

}
    public void searchBook(int userId) {
        try {
            Connection con = dbConnection.getConnectionMethod();
            String Query = query.searchBoo;
            Statement stm=con.createStatement();
           ResultSet rs=stm.executeQuery(Query);
           while(rs.next()) {
               if(userId==rs.getInt(1)){
                   System.out.println("the name of book is " + rs.getString(4));
               }
               else {
                   System.out.println("It isne available");
               }

           }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
public void borrowBook(String x){
        char y='y';
        try {
            Connection con=dbConnection.getConnectionMethod();
            String Query= query.checkAvailaibility;
            Statement stm=con.createStatement();
            ResultSet rs=stm.executeQuery(Query);
            Boolean Arr=false;
            while(rs.next()) {
                if(rs.getString(2).equals(x)&&(rs.getString(5).equals("y"))){
                    System.out.println("YES the book is available \n SO DO YOU WANT TO BORROW");
                    Arr=true;
                    String option;
                    System.out.println("do you want to borrow the book YES OR NO and enter your id");
                    option=sc.next();
                    int id=sc.nextInt();
                    if(option.equals("YES")){
                        String qr="update users set uborrowedbooks= ?where uid=?";
                        PreparedStatement ps=con.prepareStatement(qr);
                        ps.setString(1,x);
                        ps.setInt(2,id);
                        ps.executeUpdate();
                        String ans="update books set bAvailability=? where btitle=?";
                        PreparedStatement ps1=con.prepareStatement(ans);
                        ps1.setString(2,x);
                        ps1.setString(1,"n");
                        ps1.executeUpdate();
                        ps1.close();
                        ps.close();
                        System.out.println("you have successfully borrowed the book");
                        break;
                    }
                }

            }
         if(Arr==false){
             System.out.println(" the book is not available");
         }
        }catch (Exception e) {
            e.printStackTrace();
        }

}
    public void returnBook(String bookName) {
        try {
            Connection con = dbConnection.getConnectionMethod();
            Statement stmt = con.createStatement();
            String q = "select * from users";
            ResultSet rs = stmt.executeQuery(q);
            boolean arr = false;
            System.out.println("Enter your id");
            int opt = sc.nextInt();
            while (rs.next()) {
                if (rs.getString(4).equals(bookName) && rs.getInt(1) == opt) {
                    arr = true;

                    String qr = "update users set uborrowedbooks=? where uid=?";
                    PreparedStatement ps = con.prepareStatement(qr);
                    ps.setString(1, "Null");
                    ps.setInt(2, opt);
                    ps.executeUpdate();
                    String ans = "update books set bAvailability=? where btitle=?";
                    PreparedStatement ps1 = con.prepareStatement(ans);
                    ps1.setString(2, bookName);
                    ps1.setString(1, "y");
                    ps1.executeUpdate();
                    ps.close();
                    ps1.close();
                    System.out.println("You have successfully returned the book");
                    break;
                }
            }
            if (!arr) {
                System.out.println("You have not borrowed that book or your ID is incorrect");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}





















