import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import javax.imageio.ImageIO;

import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.videoio.VideoCapture;


public class Snapshot {
    private String saveFile;
    private VideoCapture webSource = null;

    private Mat frame = new Mat();

    public Snapshot(String saveFile) {
        this.saveFile = saveFile;
        webSource = new VideoCapture(0);
    }

    public int takeSnapshot(int count) {
        System.out.println("tady");
        if (webSource.grab()) {
            try {
                webSource.retrieve(frame);
                Imgcodecs.imwrite(saveFile, frame);
                System.out.println("Saving picture");
                webSource.release();

            } catch (Exception ex) {
                System.out.println("Error");
                ex.printStackTrace();
            }
        }
        System.out.println("yde");
        count += 1;
        return count;
    }
}
