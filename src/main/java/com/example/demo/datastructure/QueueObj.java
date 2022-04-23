package com.example.demo.datastructure;

public class QueueObj {
    Node node;
    int hd;

    public QueueObj(Node node,int hd){
        this.node = node;
        this.hd = hd;
    }

    public Node getNode(){
        return this.node;
    }

    public int getHd(){
        return this.hd;
    }
}
