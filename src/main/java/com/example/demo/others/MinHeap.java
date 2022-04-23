package com.example.demo.others;

import java.util.Vector;

//suppose you already have min heap now you have to add new element in this heap
// then this approach is valid. For more: https://www.geeksforgeeks.org/insertion-and-deletion-in-heaps/
//create min heap using array
public class MinHeap {


   private static final int DEFAULT_CAPACITY = 100;
   private static final int DEFAULT_SIZE = 10;
   private static Vector<Integer> arr;

   private static int index = 0;


   public MinHeap(int capacity){
    arr = new Vector<>(capacity);
   }

    public static void percolateUp(int i){
     if(i>0 && arr.get(getParent(i)) > arr.get(i)){
         swap(i,getParent(i));
         percolateUp(getParent(i));
     }
    }

    public static void percolateDown(int i){
       int smallest = i;
       int left = getLeftChild(i);
       int right = getRightChild(i);

       if(i<arr.size() && arr.get(left) < arr.get(smallest))
           smallest = left;
       if(i<arr.size() &&  arr.get(right) < arr.get(smallest))
           smallest = right;

       if(smallest != i){
           swap(smallest,i);
           percolateDown(smallest);
       }
    }

    private static int getParent(int pos){
       if(pos == 0)
           return pos;
       return (pos-1) / 2;
    }

    private static int getLeftChild(int pos){
       return (2*pos + 1);
    }

    private static int getRightChild(int pos){
       return (2*pos + 2);
    }

    public static void insertElement(int item){
       arr.addElement(item);
       int i = arr.size() - 1;
       percolateUp(i);
    }

    public static int deleteElement(){
       if(arr.isEmpty()){
           System.out.println("Heap is empty");
           return -1;
       }
      int rootElement = arr.get(0);
       arr.setElementAt(arr.lastElement(),0);
       arr.remove(arr.size()-1);
      percolateDown(0);
      return rootElement;
    }

    public static void swap(int index1, int index2){
     int temp = arr.get(index1);
     arr.setElementAt(arr.get(index2),index1);
     arr.setElementAt(temp,index2);
    }

    public static boolean isEmpty(){
     return arr.isEmpty();
    }

    public static void displayHeap(){
       for(int i=0;i<arr.size();i++){
           System.out.print(arr.get(i) + " ");
       }
    }

    public static void main(String[] args){
        MinHeap heap = new MinHeap(10);
        insertElement(35);
        insertElement(10);
        insertElement(6);
        insertElement(2);
        displayHeap();

    }
}
