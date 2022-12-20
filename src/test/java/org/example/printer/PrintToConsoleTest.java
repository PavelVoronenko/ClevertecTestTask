package org.example.printer;

import org.junit.jupiter.api.Test;

class PrintToConsoleTest {
    PrintToConsole printToConsole = new PrintToConsole();

    @Test
    void testPrint() {
        printToConsole.print("check");
    }
}
