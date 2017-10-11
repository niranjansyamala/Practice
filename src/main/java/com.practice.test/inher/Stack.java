package com.practice.test.inher;

import java.util.NoSuchElementException;

public class Stack {
    int arr[];
    int size;
    int top, len;


    Stack(int size) {
        this.size = size;
        top = -1;
        len = 0;
        arr = new int[size];
    }


    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == size - 1;
    }

    public void push(int data) {
        if (isFull()) {
            throw new IndexOutOfBoundsException();
        }
        arr[++top] = data;
        len++;
    }

    public int pop() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        len--;
        return arr[top--];
    }

    public static void main(String[] args) {
        Stack stack = new Stack(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
