package org.example;

import org.example.base.ConnectDAOSetting;
import org.example.base.discountCardBase.DiscountCardBaseImpl;
import org.example.base.productBase.ProductsBase;
import org.example.base.productBase.ProductsBaseImpl;
import org.example.check.CheckServices;
import org.example.check.CheckServicesImpl;
import org.example.check.CheckToString;
import org.example.base.discountCardBase.DiscountCardBase;
import org.example.exceptions.InputException;
import org.example.printer.PrintToConsole;
import org.example.printer.PrintToFile;
import org.example.printer.Printer;

public class CheckRunner {
    public static void main(String[] args) {

        try {

            ConnectDAOSetting setting = new ConnectDAOSetting();

            ProductsBase product = new ProductsBaseImpl(setting.connections());
            DiscountCardBase card = new DiscountCardBaseImpl(setting.connections());

            CheckServices checkServices = new CheckServicesImpl(args, product, card);
            CheckToString check = checkServices.createCheck();

            Printer toFile = new PrintToFile();
            toFile.print(check.toString());

            Printer toConsole = new PrintToConsole();
            toConsole.print(check.toString());

        } catch (InputException e) {
            System.err.println(e.getStr());
        }
    }
}