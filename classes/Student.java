package classes;

import databases.BookShelf;
import databases.RecoderShelf;
import exception.NoSuchBookException;
import exception.NotBorrowedException;

import java.util.Scanner;

public class Student extends User {
    public Student(String id,String name){
        super(id, name);
    }

    @Override
    public void menu() {
        System.out.println("==请选择==");
        System.out.println("==0.退出==");
        System.out.println("==1.查询图书==");
        System.out.println("==2.借阅图书==");
        System.out.println("==3.归还图书=='");
        System.out.println("==2.查询记录==");
    }

    @Override
    public boolean input() {
        Scanner scanner=new Scanner(System.in);
        int select=scanner.nextInt();
        switch (select){
            case 0:return true;
            case 1:
                queryBook();break;
            case 2:
                break;
            case 3:
                System.out.println("请查询记录");break;
            case 4:

        }
        return false;
    }

    private void returnBook(){
        //有这本书；借过这本书
        //还书流程
        //借阅记录删除；书的存量+1
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入要归还书籍的ISBN");
        String ISBN=scanner.nextLine();
        User user=User.getCurrenUser();
        try{
            BookShelf bookShelf=BookShelf.getInstance();
            Book book=bookShelf.search(ISBN);
            RecoderShelf recoderShelf=RecoderShelf.getInstance();
            recoderShelf.remove(user,ISBN);
            book.returnBook();
            System.out.printf("《%s》归还成功！",book.getTitle());
        }catch (NoSuchBookException e){
        }catch (NotBorrowedException e){
        }
    }
}
