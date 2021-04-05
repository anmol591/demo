package com.example.demo.others;

//find median of two sorted array of same size(odd length) in o(log n)
public class FindMedian {
    public static Float getMedian(int first[], int startingIndexFirst, int endingIndexFirst,int second[],
                                  int startingIndexSecond,int endingIndexSecond){
        if(endingIndexFirst-startingIndexFirst+1 == 2 && endingIndexSecond-startingIndexSecond+1 == 2){
            Float x = (float)Math.max(first[startingIndexFirst],second[startingIndexSecond]);
            Float y = (float)Math.min(first[endingIndexFirst],second[endingIndexSecond]);
            return (x+y)/2;
        }
        Float m1 = calculateMedian(first,startingIndexFirst,endingIndexFirst);
        Float m2 = calculateMedian(second,startingIndexSecond,endingIndexSecond);

        int middleIndexOfFirst = (startingIndexFirst+endingIndexFirst)/2;
        int middleIndexOfSecond = (startingIndexSecond+endingIndexSecond)/2;

        if(m1>m2)
            return getMedian(first,startingIndexFirst,middleIndexOfFirst,second,middleIndexOfSecond,endingIndexSecond);
        return getMedian(first,middleIndexOfFirst,endingIndexFirst,second,startingIndexSecond,middleIndexOfSecond);

    }

    public static Float calculateMedian(int arr[],int start,int end){
        int n = end-start+1;
        if(n%2 == 0)
            return  (float)(arr[start+n/2-1] + arr[start+n/2])/2;
        return (float) arr[start + n/2];
    }

    public static void main(String[] args){
        int arr1[] = {2,6,9,10,11};
        int arr2[] = {1,5,7,12,15};
        if(arr1.length == arr2.length){
            System.out.println("Median is: "+ getMedian(arr1,0,arr1.length-1,arr2,0,arr2.length-1));
        }

    }
}
