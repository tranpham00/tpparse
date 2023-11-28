package edu.francistuttle;
import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.*;

public class ComputerLab {
    
    public ArrayList<Computer> parse(String pathname)
    {
        ArrayList<Computer> computers = new ArrayList<Computer>();
        try
        {
            Document document = readXMLDocumentFromFile(pathname);
            NodeList nList = document.getElementsByTagName("computer");
            for(int i = 0; i < nList.getLength(); i++)
            {
                Node node = nList.item(i);
                if(node.getNodeType() == Node.ELEMENT_NODE)
                {
                    Element eElement = (Element) node;
                    NodeList nList2 = eElement.getElementsByTagName("monitor");
                    ArrayList<Monitor> mList = new ArrayList<Monitor>();

                    for(int j = 0; j < nList2.getLength(); j++)
                    {
                        Node childNode = nList2.item(j);
                        if(childNode.getNodeType() == Node.ELEMENT_NODE)
                        {
                            Element eElement2 = (Element) childNode;
                            mList.add(new Monitor(eElement2.getAttribute("id"), eElement2.getElementsByTagName("manufacturer").item(0).getTextContent(), 
                                eElement2.getElementsByTagName("resolution").item(0).getTextContent()));
                        }
                    }
                    computers.add(new Computer(eElement.getAttribute("id"), eElement.getElementsByTagName("manufacturer").item(0).getTextContent(), 
                        eElement.getElementsByTagName("yearPurchased").item(0).getTextContent(), eElement.getElementsByTagName("processor").item(0).getTextContent(), 
                        mList));
                }
            }
            return computers;
        }
        catch(Exception e)
        {
            System.out.println("Invalid" + e);
            return null;
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
