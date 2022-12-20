package org.example.printer;

import org.example.exceptions.InputException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class PrintToFile implements Printer{

    public void print(String check) throws InputException {

        File file = new File ("Receipt.txt");

        try {
            PrintWriter printWriter = new PrintWriter(file);
            printWriter.println(check);
            printWriter.close();
        } catch (FileNotFoundException e) {
            throw new InputException("Error. File '" + file + "' is in use by another application.");
        }
    }
}
