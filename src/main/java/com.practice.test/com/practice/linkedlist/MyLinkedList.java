package com.practice.test.com.practice.linkedlist;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyLinkedList {

    Node node;

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }


    void push(int data) {
        if (node == null) {
            node = new Node(data);
        } else {
            Node newNode = new Node(data);
            node.next = newNode;
        }
    }


    int length() {
        int count = 0;
        while (node.next != null) {
            count++;
            node = node.next;
        }
        return count;
    }


    public static int findCount(File textFile, String key) {
        try {
            Pattern patt = Pattern.compile(".*\\the java\\b");
            FileInputStream inputStream = new FileInputStream(textFile);
            byte[] read = new byte[256];

            int rc = inputStream.read(read);
            while (rc !=-1) {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String text = bufferedReader.readLine();
                System.out.println(text.length());
                /*if (patt.matcher(text).find()) {
                    System.out.println("Yes");
                }*/
                rc=  inputStream.read(read);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }


    boolean detectLoop() {
        Node slowPointer = node;
        Node fastPointed = node;
        while (slowPointer != null && fastPointed != null && fastPointed.next != null) {
            slowPointer = slowPointer.next;
            fastPointed = fastPointed.next.next;
            if (slowPointer == fastPointed) {
                return true;
            }

        }
        return false;
    }

    public static void main(String[] args) {

        File file = new File("test.txt");
        findCount(file,"the java");

    }


}
