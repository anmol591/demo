package com.example.demo.others;

public class QueueObj1 {
    private Node1 node;
    private int hd;

    public QueueObj1(Node1 node, int hd) {
        this.node = node;
        this.hd = hd;
    }

    public Node1 getNode() {
        return node;
    }

    public void setNode(Node1 node) {
        this.node = node;
    }

    public int getHd() {
        return hd;
    }

    public void setHd(int hd) {
        this.hd = hd;
    }
}
