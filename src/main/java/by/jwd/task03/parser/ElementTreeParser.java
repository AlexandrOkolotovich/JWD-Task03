package by.jwd.task03.parser;

public class ElementTreeParser {

    public String[] parse(String preparedData) {

        final String ELEMENTS_SPLIT = "><";

        String[] elementsTree = preparedData.split(ELEMENTS_SPLIT);

        return elementsTree;
    }
}
