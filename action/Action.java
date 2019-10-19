package action;
import classes.Book;
import classes.Recoder;
import classes.User;
import databases.BookShelf;
import databases.RecoderShelf;
import databases.Where;
import exception.BorrowedOutException;
import exception.NoSuchBookException;
import exception.YetBorrowedException;
import exception.NotBorrowedException;

import java.util.List;

public class Action {
/**
 * 图书上架
 * 1.如果已经有了，增加数目（存量、总量）
 * 2.如果没有，新书上架
 * @param ISBN
 * @param author
 * @param count
 * @param price
 * @param title
 *Teach
 */
public static Book putBook(String ISBN,String title,String author,double price,int count){
   //系统内部只能有一个书架对象
   //单例模式
    BookShelf bookshelf=BookShelf.getInstance();
    try{
        Book book=bookshelf.search(ISBN);
        book.increaseCount(count);
        return book;
    }catch (NoSuchBookException exc){
        Book book=new Book(ISBN,title,author,price,count);
        bookshelf.putBook(book);
        return book;
      }
   }

   public static List<Book> queryBook(){
    BookShelf bookShelf=BookShelf.getInstance();
    return bookShelf.queryBook(null);
   }

   public static List<Book> queryBooksByWhere(Where<Book>where){
    BookShelf bookShelf=BookShelf.getInstance();
    return bookShelf.queryBook(where);
   }
   public static List<Recoder> queryRecoder(){
    RecoderShelf recoderShelf=RecoderShelf.getInstance();
    return recoderShelf.queryRecoder(null);
   }
   public static Book borrowBook(User user,String ISBN)throws NoSuchBookException, BorrowedOutException, YetBorrowedException {
    BookShelf bookShelf=BookShelf.getInstance();
    RecoderShelf recoderShelf=RecoderShelf.getInstance();
    Book book=bookShelf.search(ISBN);
    if(book.getCurCount()<=0){
        throw new BorrowedOutException();
    }
    if(recoderShelf.contains(user,ISBN)){
        throw new YetBorrowedException();
    }
    book.borrowBook();
    recoderShelf.putRecorder(user,ISBN);
    return book;
   }

   public static Book returnBook(User user,String ISBN)throws NoSuchBookException,NotBorrowedException{
    BookShelf bookShelf=BookShelf.getInstance();
    Book book=bookShelf.search(ISBN);
    RecoderShelf recoderShelf=RecoderShelf.getInstance();
    recoderShelf.remove(user,ISBN);
    book.returnBook();
    return book;
   }
}
