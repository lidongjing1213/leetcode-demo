package com.leetcode.demo.stack;


import java.util.Stack;

public class BrowserStack {

    private Stack xStack;

    private Stack yStack;

    public BrowserStack(){
        this.xStack=new Stack();
        this.yStack=new Stack();
    }

    public void forward(String item){
        this.xStack.push(item);


    }
}
