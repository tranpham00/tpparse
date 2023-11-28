package edu.francistuttle;

public class Monitor {
    String id;
    String manufacturer;
    String resolution;

    public Monitor(String i, String m, String r)
    {
        id = i;
        manufacturer = m;
        resolution = r;
    }

    public void print()
    {
        System.out.println("\tMonitor ID: " + id);
        System.out.println("\tManufacturer: " + manufacturer);
        System.out.println("\tResolution: " + resolution);
    }
}
