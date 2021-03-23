package com.example.demo.others;

public class Kthsmallest {

    public static int findKthSmallest(int arr[],int low,int high,int k){
      if(k>0 && k<=high-low + 1){
          int index = divideArray(arr,low,high);
          if(index-low == k-1)
              return arr[index];
          if(index-low > k-1)
              return findKthSmallest(arr,low,index-1,k);
          return findKthSmallest(arr,index+1,high,k-index+low-1);
      }
      return Integer.MAX_VALUE;
    }

    public static int divideArray(int arr[],int low,int high){
        int pivot = arr[high];
        int i = low;
        for(int j=low;j<=high-1;j++){
            if(arr[j] <= pivot){
             swap(arr,i,j);
             i++;
            }
        }
        swap(arr,i,high);
        return i;

    }

//    public static void randomPartition(){
//
//    }

    public static void swap(int arr[], int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args){
        int arr[] = {4,8,2,9,12,17,32,1};
        int len = arr.length;
        int k = 3;
        System.out.println(findKthSmallest(arr,0,len-1,k));
    }
}
