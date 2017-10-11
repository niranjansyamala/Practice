package com.practice.test;

public class BinaryTree {
    Node root;

    int findGiven(int key, Node head) {
        if (head.data == key) {
            return 1;
        }
        if (head.data > key) {
            return findGiven(key, head.right);
        }
        if (head.data < key) {
            return findGiven(key, head.left);
        }
        return 0;
    }


    public boolean hasPathSum(Node head, int sum) {
        if (head == null) {
            return sum == 0;
        } else {
            boolean ans = false;

            if (sum == 0 && head.left == null && head.right == null) {
                return true;
            }

            if (hasPathSum(head.left, sum - head.data)) {
                return true;
            }

            if (hasPathSum(head.right, sum - head.data)) {
                return true;
            }
        }
        return false;
    }


    static class Node {
        Node left, right;
        int data;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }
    /* Driver program to test the above functions */
    public static void main(String args[])
    {
        int sum = 23;

        /* Constructed binary tree is
              10
             /  \
           8     2
          / \   /
         3   5 2
        */
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(10);
        tree.root.left = new Node(8);
        tree.root.right = new Node(2);
        tree.root.left.left = new Node(3);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(2);

        if (tree.hasPathSum(tree.root, sum))
            System.out.println("There is a root to leaf path with sum " + sum);
        else
            System.out.println("There is no root to leaf path with sum " + sum);
    }

}
