package by.jwd.task03.entity;

import java.util.ArrayList;
import java.util.List;

public class Element {

    private String name;
    private List<Attribute> attributes;
    private List<Element> childElement;
    private String content;

    public Element() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }

    public List<Element> getChildElement() {
        return childElement;
    }

    public void setChildElement(List<Element> childElement) {
        this.childElement = childElement;
    }

    public void addChildElement(Element element){
        if(childElement == null){
            childElement = new ArrayList<Element>();
        }
        childElement.add(element);
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
