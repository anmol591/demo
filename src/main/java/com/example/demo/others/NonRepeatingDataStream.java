package com.example.demo.others;

//find first non repeating character from a stream of characters
public class NonRepeatingDataStream {
    static class DoublyLLNode{
        char data;
        DoublyLLNode prev;
        DoublyLLNode next;

        public DoublyLLNode(char ch){
            this.data = ch;
            this.prev = this.next = null;
        }
    }

    static class DLL{
        DoublyLLNode head;
        DoublyLLNode tail;

        public DLL(){
            this.head = this.tail = null;
        }

        private DoublyLLNode addNodeToList(DoublyLLNode node){
            if(head == null){
                head = node;
                tail = head;
                return head;
            }
            node.prev = tail;
            tail.next = node;
            tail = node;
            return tail;
        }

        private void deleteNodeFromList(DoublyLLNode node){
            if(head == null)
                return;
            if(head == node){
                DoublyLLNode next = head.next;
                if(next != null)
                    next.prev = null;
                head = next;
                if(tail == node)
                    tail = head;

            } else if(tail == node){
                tail.prev.next = null;
                tail = tail.prev;

            } else {
                DoublyLLNode prev = node.prev;
                prev.next = node.next;
                node.next.prev = prev;
            }
        }
    }

    public void findFirstNonRepeating(String str){
        int size = 256;
        DoublyLLNode[] charMap = new DoublyLLNode[size];
        boolean[] repeated = new boolean[size];
        DLL dll = new DLL();


        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);

            if(!repeated[ch]){
                if(charMap[ch] == null){
                    DoublyLLNode node = new DoublyLLNode(ch);
                    dll.addNodeToList(node);
                    charMap[ch] = node;
                } else {
                    dll.deleteNodeFromList(charMap[ch]);
                    charMap[ch] = null;
                    repeated[ch] = true;
                }
            }
            if(dll.head != null){
                System.out.println("First non repeating character:" + dll.head.data);
            }
        }
    }

    public static void main(String[] args){
         String str = "ABCDBAGHC";
        NonRepeatingDataStream dataStream = new NonRepeatingDataStream();
        dataStream.findFirstNonRepeating(str);
    }
}
