package com.example.demo.datastructure;


class ListNode {
    private int data;
    private ListNode next;

    public ListNode(int item){
        this.data = item;
        this.next = null;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}

public class Driver {
    ListNode head;
    public Driver(){
        head = null;
    }

    private void insertNode(int item){
        ListNode node = new ListNode(item);
        node.setNext(head);
        head = node;
    }

    private void printList(){
        ListNode ptr = head;
        while (ptr != null){
            System.out.println(ptr.getData() + " ");
            ptr = ptr.getNext();
        }
    }

    private int deleteNode(){
        if(head == null){

            return -1;
        }
        ListNode temp = head;
        head = head.getNext();
        return temp.getData();
    }

    private void removeDuplicates(){
        ListNode prev = head;
        ListNode ptr = head.getNext();
        while (ptr != null){
            if(ptr.getData() == prev.getData()){
                prev.setNext(ptr.getNext());
            }
            else{
                prev = ptr;
            }
            ptr = ptr.getNext();
        }
    }

    public static void main(String args[]){
        Driver driver = new Driver();
        driver.insertNode(8);
//        driver.insertNode(8);
//        driver.insertNode(5);
//        driver.insertNode(3);
//        driver.insertNode(3);
        driver.insertNode(3);

//        int result = driver.deleteNode();
//
//        if(result == -1){
//            System.out.println("List is empty");
//        }else{
//            System.out.println(result);
//        }
        driver.removeDuplicates();
        driver.printList();
    }

}
