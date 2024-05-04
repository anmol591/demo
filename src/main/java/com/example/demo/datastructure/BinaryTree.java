package com.example.demo.datastructure;
import java.util.*;


public class BinaryTree {
    public Node root;

    public void inorder(Node root){
        if(root == null)
            return;
        inorder(root.getLeft());
        System.out.println(root.getData() + " ");
        inorder(root.getRight());
    }

    void printLevelOrder(){
        Queue<Node> q = new LinkedList<Node>();
        q.add(this.root);
        while(!q.isEmpty()){
            Node temp = q.poll();
            System.out.println(temp.getData());
            if(temp.getLeft() != null)
                q.add(temp.getLeft());
            if(temp.getRight() != null)
                q.add(temp.getRight());
        }
    }

    static void printVerticalUtil(Node root, int hd, Map<Integer,Vector<Integer>> m){
        if(root == null)
            return;

        Vector<Integer> vector = m.get(hd);
        if(vector == null)
            vector = new Vector<Integer>();
        vector.add(root.getData());
        m.put(hd,vector);
        printVerticalUtil(root.getLeft(), hd-1, m);
        printVerticalUtil(root.getRight(), hd+1, m);
    }

    static void printVerticalOrder(Node root){
        Map<Integer,Vector<Integer>> map = new HashMap<>();

        int hd = 0;
        printVerticalUtil(root,hd,map);

        Set entrySet = map.entrySet();
        Iterator it = entrySet.iterator();
        while(it.hasNext()){
            Map.Entry val = (Map.Entry)it.next();
            System.out.println(val.getValue());
        }
    }

    static void topView(Node root){
        TreeMap<Integer,Integer> m = new TreeMap<>();

        topViewUtil(root,m);

        for(Map.Entry entry : m.entrySet()){
            System.out.println(entry.getValue());
        }
    }

    static void topViewUtil(Node root,TreeMap<Integer,Integer>m){
        if(root == null)
            return;

        Queue<QueueObj> q = new LinkedList<>();
        q.add(new QueueObj(root,0));

        while(q.isEmpty() == false){
            QueueObj temp = q.poll();
            if(m.containsKey(temp.hd) == false)
                m.put(temp.getHd(),temp.getNode().getData());

            if(temp.getNode().getLeft() != null){
                q.add(new QueueObj(temp.getNode().getLeft(),temp.getHd()-1));
            }
            if(temp.getNode().getRight() != null){
                q.add(new QueueObj(temp.getNode().getRight(),temp.getHd()+1));
            }
        }

    }


    static void bottomView(Node root){
        TreeMap<Integer,Integer> m = new TreeMap<>();
        bottomViewUtil(root,m);

        for(Map.Entry entry : m.entrySet()){
            System.out.println(entry.getValue());
        }
    }

    static void bottomViewUtil(Node root,TreeMap<Integer,Integer>m){
        if(root == null)
            return;
        Queue<QueueObj> q = new LinkedList<>();
        q.add(new QueueObj(root, 0));

        while(!q.isEmpty()){
            QueueObj temp = q.poll();

            m.put(temp.getHd(),temp.getNode().getData());

            if(temp.getNode().getLeft() != null){
                q.add(new QueueObj(temp.getNode().getLeft(),temp.getHd()-1));
            }
            if(temp.getNode().getRight() != null){
                q.add(new QueueObj(temp.getNode().getRight(),temp.getHd()+1));
            }
        }
    }

    static int printVerticalWidth(Node root) {
        if (root == null) {
            return 0;
        }

        Queue<QueueObj> queue = new LinkedList<>();
        queue.offer(new QueueObj(root, 0));
        int minHD = 0;
        int maxHD = 0;

        while (!queue.isEmpty()) {
            QueueObj current = queue.poll();
            Node node = current.getNode();
            int hd = current.getHd();

            // Update minHD and maxHD
            minHD = Math.min(minHD, hd);
            maxHD = Math.max(maxHD, hd);

            if (node.getLeft() != null) {
                queue.offer(new QueueObj(node.getLeft(), hd - 1));
            }
            if (node.getRight() != null) {
                queue.offer(new QueueObj(node.getRight(), hd + 1));
            }
        }

        // Vertical width is the difference between maxHD and minHD (+1 for inclusive range)
        return maxHD - minHD + 1;

    }


    public static void main(String[] args) {
        Node root = new Node(1);
        root.setLeft( new Node(2));
        root.setRight(new Node(3));
        root.getLeft().setLeft(new Node(4));
        root.getLeft().setRight(new Node(5));
        root.getRight().setLeft(new Node(6));
        root.getRight().setRight(new Node(7));

        System.out.println("Vertical width of the binary tree: " + printVerticalWidth(root));
    }
}
