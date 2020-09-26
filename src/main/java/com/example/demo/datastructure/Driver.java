package com.example.demo.datastructure;

public class Driver {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(20);
        tree.root.setLeft(new Node(8));
        tree.root.setRight(new Node(22));
        tree.root.getLeft().setRight(new Node(3));
        tree.root.getRight().setLeft(new Node(4));
        tree.root.getLeft().setLeft(new Node(5));
        tree.root.getLeft().getRight().setRight(new Node(14));
        tree.root.getLeft().getRight().setLeft(new Node(10));
        tree.root.getRight().setRight(new Node(25));
        BinaryTree.bottomView(tree.root);
    }
}
