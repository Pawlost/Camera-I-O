import org.opencv.core.Core;

import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

public class Main {
    static{
        nu.pattern.OpenCV.loadShared();
    }
    public static void main(String[] args) {
        int count = 0;
        while (count < 10) {
                File pictures = new File("./pictures/");
                pictures.mkdirs();
                Snapshot snapshot = new Snapshot(pictures.getPath() + "/" + count + ".jpg");
                count = snapshot.takeSnapshot(count);
                System.out.println(count);
        }
    }
}
