package classes;

import action.Action;
import databases.RecoderShelf;
import databases.Where;

import java.util.List;
import java.util.Scanner;

public abstract class User {
    private static String id;
    private static String name;

    public User(String id, String name) {
        this.id = id;
        this.name = name;
    }

    private static User currentUser=null;

    public static User login() throws Exception{
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入学号");
        scanner.nextLine();
        System.out.println("请输入姓名");
        scanner.nextLine();
        System.out.println("请输入你的角色");
        String role=scanner.next();
        if(role.equals("老师")){
            currentUser=new Teacher(id,name);
        }else if(role.equals("学生")){
            currentUser=new Student(id,name);
        }else{
            throw new Exception("错误的角色");
        }
        return currentUser;
    }
    public static User getCurrenUser(){
        return currentUser;
    }
    public abstract void menu();


    public abstract boolean input();

    private static class Curren implements Where<Book>{
        @Override
        public boolean test(Book book) {
            //有疑问
            return book.getCurCount()>0;
        }
    }
    private static class BookTile implements Where<Book>{
        private String title;
        BookTile(String title){
            this.title=title;
        }

        @Override
        public boolean test(Book book) {
           //有疑问
            return book.getTitle().equals(title);
        }
    }

    public void queryBook(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("请选择全查询还是条件查询");
        System.out.println("1.全查询");
        System.out.println("2.查询存量>0的");
        System.out.println("其他.根据书名查询");
        int select=scanner.nextInt();
        scanner.nextLine();
        List<Book>bookList;
        switch(select){
            case 1:
                bookList=Action.queryBook();break;
            case 2:
                bookList=Action.queryBooksByWhere(new Curren());break;
            default:
                System.out.println("请输入书名");
                String title=scanner.nextLine();
                bookList=Action.queryBooksByWhere(new BookTile(title));break;
        }
        for(Book book:bookList){
            System.out.printf("《%s》by%s价格：%.2f存量:%d借阅次数:%d%n",book.getTitle(),book.getAuthor(),book.getPrice()
            ,book.getCurCount(),book.getBorrowedCount());
        }
        System.out.println("共查询到"+bookList.size()+"本书");
    }

    protected void queryRecoder(){
        List<Recoder>recoderList=Action.queryRecoder();
        for(Recoder recoder:recoderList){
            System.out.printf("% %s %s%n ",recoder.getUserID(),recoder.getBookISBN(),recoder.getBorrowedAt());
        }
        System.out.println("共查询到"+recoderList.size()+"条借阅记录");
    }

    public String getID(){
        return id;
    }

    public static String getName() {
        return name;
    }
}



