package by.jwd.task03.parser;

import by.jwd.task03.entity.Element;

import java.io.IOException;

public interface Parser {
    public Element parse(String dataXML) throws IOException;
}
