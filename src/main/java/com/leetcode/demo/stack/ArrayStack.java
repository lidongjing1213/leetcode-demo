package com.leetcode.demo.stack;


public class ArrayStack {

    //数组
    private String[] items;
    //栈中元素个数
    private int count;
    //栈的大小
    private int n;

    //初始化数组，申请一个大小为n的数组空间
    public ArrayStack(int n) {
        this.items = new String[n];
        this.n = n;
        this.count = 0;
    }

    //入栈
    public boolean push(String item) {
        if (count == n) {
            String[] copyItem=new String[n*2];
            for(int i=0;i<n;i++){
                copyItem[i]=items[i];
            }
            items=copyItem;
            n=n*2;
        }
        items[count] = item;
        ++count;
        return true;
    }

    //出站

    public String pop(){
        if(count==0){
            return null;
        }
        String temp=items[count-1];
        --count;
        return temp;
    }
}
