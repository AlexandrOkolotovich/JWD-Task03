package by.jwd.task03.service;

import by.jwd.task03.entity.Element;

import java.io.IOException;

public interface CreatorElement {
    public Element create(String[] elementsTree) throws IOException;
}
