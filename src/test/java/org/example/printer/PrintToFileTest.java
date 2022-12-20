package org.example.printer;

import org.example.exceptions.InputException;
import org.junit.jupiter.api.Test;

import java.io.PrintWriter;

import static org.mockito.Mockito.*;

class PrintToFileTest {
    PrintToFile printToFile = new PrintToFile();

    @Test
    void testPrint() throws InputException {
        printToFile.print("check");
    }

    @Test
    public void testPrintReceipt(){
        PrintWriter printWriter = mock(PrintWriter.class);
        doNothing().when(printWriter).println(isA(String.class));
        printWriter.println("");

        verify(printWriter, times(1)).println("");
    }
}
