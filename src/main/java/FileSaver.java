import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class FileSaver {
    public static void createFile(String filePath, String text) throws IOException {
        File file = new File(filePath);
        FileUtils.writeStringToFile(file, text + "\n", "UTF-8");
    }
}
