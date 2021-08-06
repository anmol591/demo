package com.example.demo.others;

import org.apache.commons.collections.CollectionUtils;

import java.util.Arrays;
import java.util.Collections;

public class SortingAlgorithm {
    private static void mergeSortUtil(int arr[],int l,int m,int r){
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];

        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    public static void mergeSort(int arr[],int l,int r){
        if (l < r) {
            // Find the middle point
            int m =l+ (r-l)/2;

            // Sort first and second halves
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);

            // Merge the sorted halves
            mergeSortUtil(arr, l, m, r);
        }
    }

    public static void selectionSortUtil(int arr[]){
        int length = arr.length;
        int minIndex;
        for(int i=0;i<length-1;i++){
             minIndex = i;
             for(int j=i+1;j<length;j++){
                 if(arr[j] < arr[minIndex])
                     minIndex = j;
             }
            swap(arr,i,minIndex);
        }
    }

    public static void insertionSortUtil(int arr[]){
        int length = arr.length;
        for(int i = 1; i < length; i++){
            int value = arr[i];
            int j = i-1;
            while(j>=0 && value < arr[j]){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = value;
        }
    }

    public static void bubbleSortUtil(int arr[]){
        int length = arr.length;
        boolean swapped = false;

        while (!swapped){
            swapped = true;
            int i = 0;
            while(i < length-1){
                if(arr[i] > arr[i+1]){
                    swap(arr,i,i+1);
                    swapped = false;
                }
                i++;
            }

        }

    }

    public static void swap(int arr[],int a,int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void printArray(int arr[]){
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }


    public static void main(String args[]){
        int arr[] = { 1, 2, 3, 4, 5, 6 };
        //mergeSort(arr,0,arr.length-1);
        bubbleSortUtil(arr);
        System.out.println("Array after sorting: ");
        printArray(arr);
    }
}
