package ShujuJiegou;

import java.util.LinkedList;

public class MyStack2 implements Stack {
    //用链表（接口）实现一个栈
    private LinkedList<Integer>list;
    public MyStack2(){
        list=new LinkedList<>();
    }

    @Override
    public int getSize() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void push(int element) {
       list.addFirst(element);
    }

    @Override
    public int pop() {
        return list.pop();
    }

    @Override
    public int peek() {
        return list.peek();
    }
    public String toString(){
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append("stack:top");
        stringBuilder.append(list);
        return stringBuilder.toString();
    }
}
