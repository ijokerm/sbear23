package NiuKe;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Nicosit {
    public static String getMinNum(int n){
        StringBuilder str=new StringBuilder();
        int num=(int)Math.pow(n,3);//pow将第一个参数的值返回到第二个参数的幂
        Queue<Integer>queue=new LinkedList<Integer>();
        int sum=0;
        int i=0;
        for(i=0;i<10000;i+=2){
            queue.offer(i);//offer()如果在不违反容量限制的情况下立即执行，则将指定的元素插入到此队列中
               if(queue.size()>n){
            sum=queue.poll();
               }
               sum+=i;
               if(sum==num){
                   break;
               }
            }
        if(i<10000){
            while(!queue.isEmpty()){
                str.append(queue.poll());
                if(!queue.isEmpty()){
                    str.append("+");
                }
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNextInt()){
            int n=sc.nextInt();
            String str=getMinNum(n);
            System.out.println(str);
        }
    }
}
