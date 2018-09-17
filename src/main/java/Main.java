import org.opencv.core.Core;

import java.io.File;
import java.io.IOException;

public class Main {
    static{
        nu.pattern.OpenCV.loadShared();
    }
    public static void main(String[] args) {
        File pictures= new File("./pictures/kokot.jpg");
        pictures.mkdirs();
        Snapshot snapshot = new Snapshot(pictures, "jpg");
        snapshot.takeSnapshot();
    }
}
