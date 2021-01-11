package by.jwd.task03.reader.impl;

import by.jwd.task03.reader.Reader;

import java.io.*;

public class XMLReader implements Reader {
    @Override
    public String readFile(File file) throws IOException {

        if(file == null){
            throw new FileNotFoundException();
        }

        BufferedReader reader = new BufferedReader(new FileReader(file));
        StringBuilder data = new StringBuilder();

        String dataXML = null;

        while ((dataXML = reader.readLine()) != null){
            if(!dataXML.isEmpty()){
                data.append(dataXML);
            }
        }

        reader.close();

        return data.toString();
    }
}
