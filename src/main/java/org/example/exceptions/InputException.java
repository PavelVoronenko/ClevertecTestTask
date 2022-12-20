package org.example.exceptions;

public class InputException extends Exception{

    private final String InputException;

    public InputException(String message) {
        InputException = message;
    }

    public String getStr() {
        return InputException;
    }
}
