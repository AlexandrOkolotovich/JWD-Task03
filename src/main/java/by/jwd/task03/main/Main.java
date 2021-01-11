package by.jwd.task03.main;

import by.jwd.task03.entity.Element;
import by.jwd.task03.parser.Parser;
import by.jwd.task03.parser.impl.XMLParser;
import by.jwd.task03.printer.Printer;
import by.jwd.task03.printer.impl.XMLPrinter;
import by.jwd.task03.reader.Reader;
import by.jwd.task03.reader.impl.XMLReader;

import java.io.File;
import java.io.IOException;

public class Main {

    private static final String PATH = "resources/info.xml";

    public static void main(String[] args) throws IOException {

        File file = new File(PATH);

        Element element;

        Reader reader = new XMLReader();
        Parser parser = new XMLParser();
        Printer printer = new XMLPrinter();

        String dataXML = reader.readFile(file);
        element = parser.parse(dataXML);
        printer.print(element);

    }
}
