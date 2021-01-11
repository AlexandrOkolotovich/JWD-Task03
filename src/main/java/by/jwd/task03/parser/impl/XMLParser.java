package by.jwd.task03.parser.impl;

import by.jwd.task03.entity.Element;
import by.jwd.task03.parser.ElementTreeParser;
import by.jwd.task03.parser.Parser;
import by.jwd.task03.reader.PreprocessingData;
import by.jwd.task03.service.CreatorElement;
import by.jwd.task03.service.impl.CreatorElementImpl;

import java.io.IOException;

public class XMLParser implements Parser {
    @Override
    public Element parse(String dataXML) throws IOException {

        Element element = null;
        String[] elementsTree;

        ElementTreeParser treeParser = new ElementTreeParser();
        PreprocessingData preprocessingData = new PreprocessingData();
        String preparedData = preprocessingData.preparation(dataXML);

        elementsTree = treeParser.parse(preparedData);

        CreatorElement creatorElement = new CreatorElementImpl();

        element = creatorElement.create(elementsTree);

        return element;
    }
}
