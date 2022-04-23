package com.example.demo.others;
//merge k sorted linked lists
public class MergeKLists {
    private static Node sortedMerge(Node a, Node b){
        Node result = null;
        if(a == null)
            return b;
        if(b == null)
            return a;
        if(a.data <= b.data){
            result = a;
            result.next = sortedMerge(a.next,b);
        }
        else{
            result = b;
            result.next = sortedMerge(a,b.next);
        }
        return result;
    }

    private static Node mergeKLists(Node arr[],int last){

        while (last != 0) {
            int i = 0, j = last;
            while(i<j){
                arr[i] = sortedMerge(arr[i],arr[j]);

                i++;
                j--;
                if(i>=j)
                    last = j;
            }
        }
        return arr[0];
    }

    public static void main(String args[]){
        int k = 3;
        Node[] arr =  new Node[3];

        arr[0] = new Node(5);
        arr[0].next = new Node(8);
        arr[0].next.next = new Node(9);

        arr[1] = new Node(2);
        arr[1].next = new Node(4);
        arr[1].next.next = new Node(6);

        arr[2] = new Node(7);
        arr[2].next = new Node(12);
        arr[2].next.next = new Node(14);

        Node output = mergeKLists(arr,k-1);
        while(output != null){
            System.out.println(output.data);
            output = output.next;
        }
     }
}
