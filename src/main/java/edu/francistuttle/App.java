package edu.francistuttle;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

import java.util.ArrayList;

public class App 
{
    public static void main( String[] args ) throws Exception
    {
        /*Document document = readXMLDocumentFromFile("C:\\Users\\ap1101037\\Desktop\\github-tran\\tpparse\\src\\main\\java\\edu\\francistuttle\\lab.xml");

        //Verify XML Content

        //Here comes the root node
        Element root = document.getDocumentElement();
        System.out.println(root.getNodeName());

        //Get all computers
        NodeList nList = document.getElementsByTagName("computer");
        System.out.println("============================");


        for (int temp = 0; temp < nList.getLength(); temp++) 
        {
        Node node = nList.item(temp);
    
            if (node.getNodeType() == Node.ELEMENT_NODE) 
            {
                //Print each computer's detail
                Element eElement = (Element) node;
                System.out.println("\nComputer ID : " + eElement.getAttribute("id"));
                System.out.println("Manufacturer : " + eElement.getElementsByTagName("manufacturer").item(0).getTextContent());
                System.out.println("Year Purchased : " + eElement.getElementsByTagName("yearPurchased").item(0).getTextContent());
                System.out.println("Processor : " + eElement.getElementsByTagName("processor").item(0).getTextContent());

                NodeList cList = eElement.getElementsByTagName("monitor");

                for (int ind = 0; ind < cList.getLength(); ind++) 
                {
                    Node childNode = cList.item(ind);

                    if (childNode.getNodeType() == Node.ELEMENT_NODE) 
                    {
                        //Print each computer's detail
                        Element childElement = (Element) childNode;
                        System.out.println("\n\tMonitor ID : " + childElement.getAttribute("id"));
                        System.out.println("\tManufacturer : " + childElement.getElementsByTagName("manufacturer").item(0).getTextContent());
                        System.out.println("\tResolution : " + childElement.getElementsByTagName("resolution").item(0).getTextContent());
                        
                    }
                }
            }
        }
        */

        ComputerLab cs = new ComputerLab();
        ArrayList<Computer> lab = cs.parse("C:\\Users\\ap1101037\\Desktop\\github-tran\\tpparse\\src\\main\\java\\edu\\francistuttle\\lab.xml");

        for(Computer c : lab)
        {
            c.print();
        }
    }


    public static Document readXMLDocumentFromFile(String fileNameWithPath) throws Exception 
    {

        //Get Document Builder
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        //Build Document
        Document document = builder.parse(new File(fileNameWithPath));

        //Normalize the XML Structure; It's just too important !!
        document.getDocumentElement().normalize();

        return document;
    }
}