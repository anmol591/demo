package com.example.demo.others;

import java.util.PriorityQueue;
import java.util.Vector;

//https://www.geeksforgeeks.org/merge-k-sorted-arrays-set-2-different-sized-arrays/
class HeapNode implements Comparable<HeapNode>{
    int value;
    int arrayIndex;
    int elementIndex;

    public HeapNode(int val,int arrayIndex,int elementIndex){
        this.value = val;
        this.arrayIndex = arrayIndex;
        this.elementIndex = elementIndex;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getArrayIndex() {
        return arrayIndex;
    }

    public void setArrayIndex(int arrayIndex) {
        this.arrayIndex = arrayIndex;
    }

    public int getElementIndex() {
        return elementIndex;
    }

    public void setElementIndex(int elementIndex) {
        this.elementIndex = elementIndex;
    }

    @Override
    public int compareTo(HeapNode o) { //this is important
        return Integer.compare(this.value,o.value);
    }
}
public class MergeKArrays {

    public static int[] mergeKArrays(int[][] vec,int rows,int cols){
        int[] output = new int[rows*cols];
        int j =0;
        PriorityQueue<HeapNode> queue = new PriorityQueue<>();

        for(int i=0;i<vec.length;i++)
            queue.add(new HeapNode(vec[i][0],i,0));

            while(!queue.isEmpty()){
                HeapNode curr = queue.poll();
                int arrayIndex = curr.getArrayIndex();
                int elementIndex = curr.getElementIndex();

                output[j++] = curr.getValue();

                if(elementIndex + 1 < vec[arrayIndex].length)
                    queue.add(new HeapNode(vec[arrayIndex][elementIndex+1],arrayIndex,elementIndex+1));
            }
            return output;
    }

    public static void main(String args[]){
       int[][] vec = { {1, 3, 5, 7},
               {2, 4},
               {2, 9, 10, 11} };

       int[] output = mergeKArrays(vec,3,4);
       for(int i =0;i<output.length;i++)
           System.out.print(output[i] + " ");

    }

}
