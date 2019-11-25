package ShujuJiegou;

import java.util.Arrays;

public class MyStack {
    //用顺序表实现栈的操作
    private int[] array=new int[20];
    private int top=0;

    private void ensureCapacity(){
        if(top<array.length){
            return;
        }
        array= Arrays.copyOf(array,array.length*2);
    }
    public int push(int element){//将指定元素压入栈顶
        ensureCapacity();
        array[top++]=element;
        return element;
    }
    public int pop(){//删除栈顶元素
        return array[--top];
    }
    public int peek(){//返回栈顶元素
        return array[top-1];
    }
    public int search(int element) {//返回和给定值相等的元素位置
        for(int i=0;i<array.length;i++){
            if(array[i]==element){
                return i;
            }
        }
        return -1;
    }
    public int getSize(){
        return top;
    }
    public boolean IsEmpty(){
        return top==0;
    }
    public void dispay(){
        for(int i=0;i<array.length;i++){
            System.out.println(array[i]);
        }
    }
}
