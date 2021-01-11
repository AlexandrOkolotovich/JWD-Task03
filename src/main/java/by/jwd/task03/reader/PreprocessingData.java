package by.jwd.task03.reader;

public class PreprocessingData {

    public String preparation(String dataFile) {

        String dataWithoutSpaces;
        dataWithoutSpaces = dataFile.replaceAll(">\\s*<", "><");

        String preparedData;
        preparedData = removeFirstAndLastCharacter(new StringBuilder(dataWithoutSpaces.trim()));

        return preparedData;
    }

    public String removeFirstAndLastCharacter(StringBuilder data) {

        data.deleteCharAt(0);
        data.deleteCharAt(data.length() - 1);

        return data.toString();

    }
}
