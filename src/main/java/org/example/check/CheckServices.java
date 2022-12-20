package org.example.check;

import org.example.exceptions.InputException;

public interface CheckServices {

    public CheckToString createCheck () throws InputException;
}
