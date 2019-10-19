package classes;


import java.text.SimpleDateFormat;
import java.util.Date;

public class Recoder {
    private String userID;
    private String bookISBN;
    private Date borrowedAt;

    public Recoder(String id,String ISBN){
        this.userID=id;
        this.bookISBN=ISBN;
        this.borrowedAt=new Date();
    }
    public boolean is(User user,String ISBN){
        return userID.equals(user.getID())&&bookISBN.equals(ISBN);
    }
    public String getUserID(){
        return userID;
    }
    public String getBookISBN(){
        return bookISBN;
    }

    public String getBorrowedAt(){
        SimpleDateFormat fmt=new SimpleDateFormat("YYYY-MM-dd-HH:mm:ss");
        return fmt.format(borrowedAt);
    }
}
