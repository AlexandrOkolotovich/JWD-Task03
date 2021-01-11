package by.jwd.task03.printer;

import by.jwd.task03.entity.Element;

import java.io.IOException;

public interface Printer {
    public void print(Element element) throws IOException;
}
