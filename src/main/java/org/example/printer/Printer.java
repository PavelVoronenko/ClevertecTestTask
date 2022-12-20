package org.example.printer;

import org.example.exceptions.InputException;

public interface Printer {
    void print(String check)throws InputException;
}
