package com.jmrchelani;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DSAProject {

    /*

    Why is the Data Structure necessary?

    Because the history needs to be accessed in a particular manner-
    where the forward and backward button works in logical and acceptable manner.
    With the help of Data Structuring, the forward and backward traversal is possible
    and the main aim of the program is achieved.

    What does this program do?

    This program demonstrates how in-real applications forward and back buttons work.
    This program takes data about history from a txt file and then with the help of commands
    utilizes the Stack data structure and achieves the main goal- to be able to move back and forth in history.

     */

    public static void main(String[] args) {
        LinkedStack stack = new LinkedStack();
        File file = new File("history.txt");
        Scanner scan;
        try {
            scan = new Scanner(file);
            while(scan.hasNext()) {
                stack.push(scan.nextLine());
            }
            System.out.println("Loaded History successfully.");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        scan = new Scanner(System.in);
        LinkedStack next = new LinkedStack();

        int yes = 0;
        String temp = "";
        while(yes == 0 || yes == 1 || yes == 2) {
            if(yes == 0) {
                System.out.println("Type \"exit\" to exit this program.");
                System.out.println("Type \"N\" to go to Next page");
                System.out.println("Type \"B\" to go back");
            }
            if(yes == 1) {
                if(stack.length() > 0) {
                    next.push(stack.pop());
                } else {
                    System.out.println("You pressed back but there is no more tabs in history backwards.");
                }
            }
            if(yes == 2) {
                if(next.length() > 0) {
                    stack.push(next.pop());
                } else {
                    System.out.println("You pressed next but there is no more tabs in history forward.");
                }
            }
            System.out.println("You are currently at page: "+ ((stack.length() > 0) ? stack.peek() : "Empty Tab") );
            System.out.print("Type the command: ");
            temp = scan.nextLine();
            if(temp.equalsIgnoreCase("N")) yes = 2;
            else if(temp.equalsIgnoreCase("B")) yes = 1;
            else if(temp.equalsIgnoreCase("exit")) yes = 3;
            else yes = 3;
        }
    }


}
