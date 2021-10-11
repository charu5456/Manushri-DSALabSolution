package com.greatlearning.model;

import java.util.ArrayList;

public class Main {
    int data;
    Main left, right;

    static Main newNode(int data) {
        Main newNode = new Main();
        newNode.data = data;
        newNode.left = null;
        newNode.right = null;
        return newNode;
    }

    public static ArrayList<Integer> longestPath(Main root) {
        if (root == null) {
            ArrayList<Integer> result = new ArrayList<>();
            return result;
        }
        ArrayList<Integer> left = longestPath(root.left);
        ArrayList<Integer> right = longestPath(root.right);
        if (right.size() < left.size()) {
            left.add(root.data);
        } else {
            right.add(root.data);
        }
        return left.size() > right.size() ? left : right;
    }

    public static void main(String[] args) {
        Main root = newNode(100);
        root.left = newNode(20);
        root.right = newNode(130);
        root.right.left = newNode(110);
        root.right.right = newNode(140);
        root.left.left = newNode(10);
        root.left.right = newNode(50);
        root.left.left.left = newNode(5);

        ArrayList<Integer> result = longestPath(root);
        int n = result.size();

        System.out.print(result.get(n - 1));
        for (int i = n - 2; i >= 0; i--) {
            System.out.print(" -> " + result.get(i));
        }
    }
}
