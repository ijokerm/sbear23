package classes;

import action.Action;

import java.util.List;
import java.util.Scanner;
//contains 查询
public class Teacher extends User{
    public  Teacher(String id,String name){
        super(id, name);
    }

    @Override
    public void menu() {
        System.out.println("==请选择==");
        System.out.println("==0.退出==");
        System.out.println("==1.上架==");
        System.out.println("==2.查询图书==");
        System.out.println("==3.查询记录==");

    }

    @Override
    public boolean input() {
        Scanner scanner=new Scanner(System.in);
        int select=scanner.nextInt();
        switch (select){
            case 0:return true;
            case 1:
                System.out.println("请上架");
                putBook();break;
            case 2:
                System.out.println("请查询图书");
                queryBook();break;
            case 3:
                System.out.println("请查询记录");
                queryRecoder();break;
        }
        return false;
    }

    private void putBook(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入ISBN");
        String ISBN=scanner.nextLine();
        System.out.println("请输入书名");
        String name=scanner.nextLine();
        System.out.println("请输入作者");
        String author=scanner.nextLine();
        System.out.println("请输入价格");
        double price=scanner.nextDouble();
        System.out.println("请输入数量");
        int count=scanner.nextInt();

        Book book= Action.putBook(ISBN,name,author,price,count);
        System.out.printf("<<%s>>上架成功！%n",book.getTitle());
    }


}
