package databases;

import classes.Book;
import exception.NoSuchBookException;

import java.util.ArrayList;
import java.util.List;

public class BookShelf {
    //保存很多书
    //保存书的集合
    private List<Book>bookList=new ArrayList<>();
    //饿汉模式
    public static BookShelf instance=new BookShelf();
    public static BookShelf getInstance(){
        return instance;
    }

    public  Book search(String ISBN)throws NoSuchBookException{
        for(Book book:bookList){
            if(book.isBook(ISBN)){
                return book;
            }
        }
        throw new NoSuchBookException(ISBN);
    }

    public void putBook(Book book) {
        bookList.add(book);
    }

    public List<Book>queryBook(Where<Book>where){
        List<Book>ret=new ArrayList<>();
        for(Book book:bookList){
            if(where==null||where.test(book)){
                ret.add(book);
            }
        }
        return ret;
    }
    //查询
}


