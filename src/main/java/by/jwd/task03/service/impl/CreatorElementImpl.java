package by.jwd.task03.service.impl;

import by.jwd.task03.entity.Attribute;
import by.jwd.task03.entity.Element;
import by.jwd.task03.reader.PreprocessingData;
import by.jwd.task03.service.CreatorElement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CreatorElementImpl implements CreatorElement {
    @Override
    public Element create(String[] elementsTree) throws IOException {

        Element rootElement = null;

        String elementNameAndAttributeRegex = ".+?=\".+?\"";
        String elementNameAndContentRegex = ".+?>.+?</.+";
        String elementEndRegex = "^/.+";

        Stack<Element> stackElements = new Stack<Element>();

        for (String element : elementsTree) {

            if (element.matches(elementNameAndAttributeRegex)) {
                stackElements.push(createElementWithNameAndAttribute(element));

            }else if (element.matches(elementNameAndContentRegex)) {
                stackElements.peek().addChildElement(createElementWithNameAndContent(element));

            }else if (element.matches(elementEndRegex)) {
                Element topElementStack = stackElements.pop();
                if (!stackElements.empty()) {
                    stackElements.peek().addChildElement(topElementStack);

                }else {
                    rootElement = topElementStack;

                }

            }else {
                stackElements.push(createElementWithName(element));

            }
        }

        return rootElement;
    }

    public Element createElementWithNameAndAttribute(String element) {

        final String ELEMENT_NAME_AND_ATTRIBUTE_SPLIT = " ";
        String[] elementNameAndAttribute = element.split(ELEMENT_NAME_AND_ATTRIBUTE_SPLIT);
        String elementName = elementNameAndAttribute[0];
        Element elementTree = new Element();
        elementTree.setName(elementName);

        List<Attribute> attributes = new ArrayList<Attribute>();

        for (int numberAttribute = 1; numberAttribute < elementNameAndAttribute.length; numberAttribute++) {

            final String ATTRIBUTE_NAME_AND_VALUE_SPLIT = "=";
            String[] attributeNameAndValue = elementNameAndAttribute[numberAttribute]
                    .split(ATTRIBUTE_NAME_AND_VALUE_SPLIT);
            String attributeName = attributeNameAndValue[0];
            String attributeValue = attributeNameAndValue[1];

            Attribute attribute = new Attribute();
            attribute.setName(attributeName);

            PreprocessingData preprocessingData = new PreprocessingData();
            attribute.setValue(preprocessingData.removeFirstAndLastCharacter(new StringBuilder(attributeValue)));

            attributes.add(attribute);
            elementTree.setAttributes(attributes);
        }

        return elementTree;
    }

    public Element createElementWithNameAndContent(String element) {

        final String ELEMENT_NAME_AND_CONTENT_SPLIT = ">";
        String[] elementNameAndContent = element.split(ELEMENT_NAME_AND_CONTENT_SPLIT);
        String elementName = elementNameAndContent[0];

        Element elementTree;
        String elementNameAndAttributeRegex = ".+?=\".+?\"";

        if (elementName.matches(elementNameAndAttributeRegex)) {
            elementTree = createElementWithNameAndAttribute(elementName);
        } else {
            elementTree = new Element();
            elementTree.setName(elementName);
        }

        final String ELEMENT_CONTENT_SPLIT = "<";
        String[] elementContent = elementNameAndContent[1].split(ELEMENT_CONTENT_SPLIT);
        String content = elementContent[0];
        elementTree.setContent(content);

        return elementTree;
    }

    public Element createElementWithName(String element) {

        Element elementTree = new Element();
        elementTree.setName(element);

        return elementTree;
    }
}
