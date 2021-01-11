package by.jwd.task03.printer.impl;

import by.jwd.task03.entity.Attribute;
import by.jwd.task03.entity.Element;
import by.jwd.task03.printer.Printer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class XMLPrinter implements Printer {
    @Override
    public void print(Element element) {
        if(element != null){
            System.out.print(printInfoFromXML(element) + " {");

            if(element.getChildElement() != null){
                List<Element> listElements = createListOutputElements(element);

                for (Element childElement : listElements) {
                    System.out.print(" " + printInfoFromXML(childElement));
                }
            }
        }
        System.out.println("}\n");
    }

    private String printInfoFromXML(Element element){
        String infoFromXML;

        infoFromXML = element.getName();

        if(element.getAttributes() != null){
            List<Attribute> listAttributes = element.getAttributes();
            int indexAttribute = 0;

            while (indexAttribute < listAttributes.size()) {
                Attribute attribute = listAttributes.iterator().next();
                infoFromXML += " " + attribute.getName() + " = " + attribute.getValue();

                indexAttribute++;
            }
        }
        if(element.getContent() != null){
            infoFromXML += ": " + element.getContent();
        }

        return infoFromXML;
    }

    private List<Element> createListOutputElements(Element element){

        List<Element> listOutputElements = new ArrayList<Element>(element.getChildElement());

        int indexElement = 0;
        int insertIndex;

        while (indexElement < listOutputElements.size()){
            insertIndex = indexElement + 1;

            if(listOutputElements.get(indexElement).getChildElement() != null){
                listOutputElements.addAll(insertIndex, listOutputElements.get(indexElement).getChildElement());
            }

            indexElement = insertIndex;
        }

        return listOutputElements;
    }
}
