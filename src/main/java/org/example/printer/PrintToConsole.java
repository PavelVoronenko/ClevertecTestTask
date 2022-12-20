package org.example.printer;

public class PrintToConsole implements Printer {
    public void print(String check)  {
        System.out.println(check);
    }
}
