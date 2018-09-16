import org.opencv.core.Core;

import java.io.File;
import java.io.IOException;

public class Main {
    static{
        nu.pattern.OpenCV.loadShared();
    }
    public static void main(String[] args) {
        File pictures= new File("./pictures/");
        pictures.mkdirs();
        System.out.println(pictures.getPath());
        try {
            FileSaver.createFile(pictures.getPath()+"/kokot.txt", "kokot");
        } catch (IOException ignore) {
        }
    }
}
