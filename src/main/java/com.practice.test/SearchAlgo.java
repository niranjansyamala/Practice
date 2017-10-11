package com.practice.test;

public class SearchAlgo {

    //Sorted Search

    public static boolean binaryCode(int minIdx, int maxIdx, int key, int[] a) {
        if (a[(minIdx + maxIdx) / 2] == key) {
            return true;
        }
        if (a[(minIdx + maxIdx) / 2] > key) {
            return binaryCode(minIdx, ((maxIdx + minIdx) / 2) - 1, key, a);
        }
        if (a[(minIdx + maxIdx) / 2] < key) {
            return binaryCode(((maxIdx + minIdx) / 2) + 1, maxIdx, key, a);
        }
        return false;
    }


    BinaryTree buildTree(int[] a) {

        return null;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(binaryCode(0, a.length - 1, 10, a));
    }


}
