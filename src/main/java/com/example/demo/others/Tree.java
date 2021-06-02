package com.example.demo.others;

import com.example.demo.datastructure.QueueObj;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class Tree {
   public static Node1 root;

  static {
     root = new Node1(45);
  }


   public static void printTopView(){
      Map<Integer,Integer> map = new TreeMap<>();
      topViewUtil(map);
      for(Map.Entry m : map.entrySet()){
         System.out.println(m.getValue());
      }

   }

   private static void topViewUtil(Map<Integer,Integer> map){
      if(root == null)
         return;

      Queue<QueueObj1> q = new LinkedList<>();
      q.add(new QueueObj1(root,0));

      while(!q.isEmpty()){
         QueueObj1 item = q.poll();
         if(!map.containsKey(item.getHd())){
            map.put(item.getHd(), item.getNode().getData());
         }
         if(null != item.getNode().getLeft()){
            q.add(new QueueObj1(item.getNode().getLeft(),item.getHd()-1));
         }
         if(null != item.getNode().getRight()){
            q.add(new QueueObj1(item.getNode().getRight(),item.getHd() + 1));
         }
      }
   }

   private static int height(Node1 root){
      if(root == null)
          return 0;
      int lheight = height(root.getLeft());
      int rheight = height(root.getRight());
      return (lheight > rheight ? lheight + 1 : rheight+1);
   }

   public static void printSpiral(){
       Deque<Node1> deque = new ArrayDeque<>();

       boolean flag = false;
       deque.addLast(root);
       while (!deque.isEmpty()){
           int size = deque.size();
           if(flag){
               //print left to right
               while (size > 0){
                   Node1 item = deque.pollFirst();
                   System.out.print(item.getData() + " ");
                   if(item.getLeft() != null)
                       deque.addLast(item.getLeft());
                   if(item.getRight() != null)
                       deque.addLast(item.getRight());

                   size--;
               }

           }else{
               while(size > 0){
                   Node1 item = deque.pollLast();
                   System.out.println(item.getData() + " ");
                   if(item.getRight() != null)
                       deque.addFirst(item.getRight());
                   if(item.getRight() != null)
                       deque.addFirst(item.getLeft());
                   size --;
               }

           }
           flag = !flag;
           System.out.println();
       }
   }

   public static int lca(int n1, int n2){
     if(root == null)
         return -1;
       List<Integer>path1 = new ArrayList<>();
       List<Integer>path2 = new ArrayList<>();

     if(!findPath(root,n1,path1) || !findPath(root,n2,path2))
         System.out.println("Either n1 or n2 is absent");

     for(int i = 0; i< path1.size() && i< path2.size(); i++){
         if(path1.get(i) != path2.get(i))
             return path1.get(i-1);
     }
    return -1;
   }

   private static boolean findPath(Node1 root,int key,List<Integer> path){
      if(root == null)
          return false;
      path.add(root.getData());
      if(root.getData() == key)
          return true;
      if(root.getLeft() != null && findPath(root.getLeft(),key,path) || root.getRight() != null && findPath(root.getRight(),key,path))
          return true;

      path.remove(path.size() - 1);
      return false;
   }


}
