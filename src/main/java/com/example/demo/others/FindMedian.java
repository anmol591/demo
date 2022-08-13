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

    //This approach is used to tackle arrays of unequal size and also for arrays of equal size
    public static double findMedianSortedArrays(int input1[], int input2[]) {
        //if input1 length is greater than switch them so that input1 is smaller than input2.
        if (input1.length > input2.length) {
            return findMedianSortedArrays(input2, input1);
        }
        int x = input1.length;
        int y = input2.length;

        int low = 0;
        int high = x;
        while (low <= high) {
            int partitionX = (low + high)/2;
            int partitionY = (x + y + 1)/2 - partitionX;

            //if partitionX is 0 it means nothing is there on left side. Use -INF for maxLeftX
            //if partitionX is length of input then there is nothing on right side. Use +INF for minRightX
            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : input1[partitionX - 1];
            int minRightX = (partitionX == x) ? Integer.MAX_VALUE : input1[partitionX];

            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : input2[partitionY - 1];
            int minRightY = (partitionY == y) ? Integer.MAX_VALUE : input2[partitionY];

            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                //We have partitioned array at correct place
                // Now get max of left elements and min of right elements to get the median in case of even length combined array size
                // or get max of left for odd length combined array size.
                if ((x + y) % 2 == 0) {
                    return ((double)Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY))/2;
                } else {
                    return (double)Math.max(maxLeftX, maxLeftY);
                }
            } else if (maxLeftX > minRightY) { //we are too far on right side for partitionX. Go on left side.
                high = partitionX - 1;
            } else { //we are too far on left side for partitionX. Go on right side.
                low = partitionX + 1;
            }
        }

        //Only we we can come here is if input arrays were not sorted. Throw in that scenario.
        throw new IllegalArgumentException();
    }

    public static void main(String[] args){
        int arr1[] = {2,5};
        int arr2[] = {3,8};
        System.out.println(findMedianSortedArrays(arr1,arr2));
//        if(arr1.length == arr2.length){
//            System.out.println("Median is: "+ getMedian(arr1,0,arr1.length-1,arr2,0,arr2.length-1));
//        }

    }
}
