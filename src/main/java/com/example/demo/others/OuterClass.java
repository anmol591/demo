package com.example.demo.others;

public class OuterClass {
    private static String msg = "anmol";
    private String val = "kumar";

    static class InnerClass{
        void display(){
            System.out.println("Innerclass display" + msg);
        }
    }

    class InnerClassNonStatic{
        private void display(){
            System.out.println("Innerclass non static display method" + msg + val);
        }
    }

    public static void main(String[] args){
        InnerClass innerClass = new InnerClass();
        innerClass.display();

        OuterClass.InnerClassNonStatic innerClassNonStatic = new OuterClass().new InnerClassNonStatic();
        innerClassNonStatic.display();
    }
}
