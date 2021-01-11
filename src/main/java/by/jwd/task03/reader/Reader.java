package by.jwd.task03.reader;

import java.io.File;
import java.io.IOException;

public interface Reader {
    public String readFile(File file) throws IOException;
}
