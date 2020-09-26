package com.example.demo.datastructure;

public class Node {
    private int data;
    private Node left;
    private Node right;

    public Node(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public void setData(int data){
        this.data = data;
    }

    public int getData(){
        return this.data;
    }

    public void setLeft(Node left){
        this.left = left;
    }

    public Node getLeft(){
        return this.left;
    }

    public void setRight(Node right){
        this.right = right;
    }

    public Node getRight(){
        return this.right;
    }
}
