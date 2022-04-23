package com.example.demo.others;

//crate max heap
public class Heap {
    public static void heapify(int arr[],int n,int index){
        int largest = index;
        int l = 2*index + 1;
        int r = 2*index + 2;
        if(l<n && arr[l] > arr[largest])
            largest = l;
        if(r<n && arr[r] > arr[largest])
            largest = r;
        if(largest != index){
            int temp = arr[index];
            arr[index] = arr[largest];
            arr[largest] = temp;
            heapify(arr,n,largest);
        }

    }

    public static void buildHeap(int arr[], int n){
        int startIndex = (n/2)-1;
      for(int i=startIndex;i>=0;i--){
          heapify(arr,n,i);
      }
      displayHeap(arr,n);
    }

    public static void displayHeap(int arr[],int n){
        for(int i=0;i<n;i++){
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args){
        int arr[] = {0,2,4,1,5,3,15};
        int size = arr.length;
        buildHeap(arr,size);
    }
}
