package classes;

public class Book {
    private String ISBN;
    private String title;
    private String author;
    private double price;
    //总量
    private int totalCount;
    //存量
    private int curCount;
    //借阅次数
    private int borrowedCount;

    public Book(String ISBN,String title,String author,double price,int count){
        this.ISBN=ISBN;
        this.author=author;
        this.price=price;
        this.curCount=count;
        this.totalCount=count;
        this.borrowedCount=0;
    }

    public boolean isBook(String ISBN){
        return this.ISBN.equals(ISBN);
        //String类型的用equals比较
    }
    public void increaseCount(int count){
        curCount+=count;
        totalCount+=count;
    }
    public String getTitle(){
        return title;
    }
    public String getAuthor(){
        return author;
    }
    public double getPrice(){
        return price;
    }
    public int getCurCount(){
        return curCount;
    }
    public int getBorrowedCount(){
        return borrowedCount;
    }
    public void borrowBook(){
        curCount++;
        borrowedCount++;
    }
    public void returnBook(){
        curCount++;
    }

}