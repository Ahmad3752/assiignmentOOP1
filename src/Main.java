import java.util.*;
public class Main {
    public static void main(String[] args) {
Scanner sc=new Scanner(System.in);
      //  dbConnection conne=new dbConnection();
  //      Connection connect=conne.getConnection();
        book myBook;
        User myUser;
         Library lib=new Library();

         //lib.addBook(myBook);
        System.out.println("******LIBRARY MANAGMENT SYSTEM ******");
        System.out.println("1  ::ADD BOOKS");
        System.out.println("2 ::ADD USER");
        System.out.println("3 ::DISPALAY BOOKS");
        System.out.println("4 ::SEARCH FOR BOOK ");
        System.out.println("5 ::Do you wanna borrow book");
        System.out.println("6 ::do you wanna return book");


int option;
        System.out.println("ENTER THE OPTION YOU WANT ");
        option=sc.nextInt();
        switch (option) {
            case 1:
                System.out.println("enter bookid\tBOOKTITLE\tBOOKAUTHOR\tBOOKGENRE\tBOOKAVAILAIBILITY");
                int id=sc.nextInt();
                String title=sc.next();
                String author=sc.next();
                String genre=sc.next();
                    char Availability=sc.next().charAt(0);
                   myBook=new book(id,title,author,genre,Availability);
                  lib.addBook(myBook);
                break;
            case 2:
                System.out.println("ENTER USERID\tUSER NAME\tCONTACT INFORMATION\tBORROWED BOOKS");
                int id1=sc.nextInt();
                String name=sc.next();
                String contact=sc.next();
                String borrowedbooks=sc.next();
                myUser=new User(id1,name,contact,borrowedbooks);
                lib.addUser(myUser);
                break;
            case 3:
lib.displayBook();
                break;
            case 4:
                System.out.println("enter the user id for searching books");
             int   x=sc.nextInt();
             lib.searchBook(x);
             break;
             case 5:
                 String bookname;
                 System.out.println("enter the book name");
                 bookname=sc.next();
                 lib.borrowBook(bookname);
                 break;
                 case 6:
                     String book;
                     System.out.println("enter the book name you want to return");
                     book=sc.next();
                     lib.returnBook(book);

                     break;
        }
    }

}