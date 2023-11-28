package edu.francistuttle;
import java.util.ArrayList;

public class Computer {
    String id;
    String manufacturer;
    String yearPurchased;
    String processor;

    ArrayList<Monitor> monitors;

    public Computer(String i, String m, String y, String p, ArrayList<Monitor> monitorsList)
    {
        id = i;
        manufacturer = m;
        yearPurchased = y;
        processor = p;
        monitors = monitorsList;
    }

    public void print()
    {
        System.out.println("Computer ID: " + id);
        System.out.println("Manufacturer: " + manufacturer);
        System.out.println("Year Purchased: " + yearPurchased);
        System.out.println("Processor: " + processor);
        for(Monitor m : monitors)
        {
            m.print();
        }
    }
}
