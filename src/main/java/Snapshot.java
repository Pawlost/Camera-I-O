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


    //Djava.library.path="C:\opencv\build\java\x86
    // definitions
    private DaemonThread myThread = null;
    private File saveFile;
    private String format;
    int count = 0;
    private VideoCapture webSource = null;

    private Mat frame = new Mat();
    private MatOfByte mem = new MatOfByte();

    public Snapshot(File saveFile, String format) {
        this.saveFile = saveFile;
        this.format = format;
        webSource = new VideoCapture(0);
        myThread = new DaemonThread();
        Thread t = new Thread(myThread);
        t.setDaemon(true);
        t.start();
    }

    public void takeSnapshot() {
        myThread.run();
    }

    /////////////////////////////////////////////////////////////////////
    class DaemonThread implements Runnable {
        public void run() {
            synchronized (this) {
                if (webSource.grab()) {
                    try {
                        webSource.retrieve(frame);
                        Imgcodecs.imwrite(saveFile.getPath(), frame);
                        BufferedImage buff = new BufferedImage(frame.width(), frame.height(), BufferedImage.TYPE_INT_BGR);
                        ImageIO.write(buff, "jpg", saveFile);
                        System.out.println("Saving picture");
                        webSource.release();
                        this.wait();

                    } catch (Exception ex) {
                        System.out.println("Error");
                        ex.printStackTrace();
                    }
                }
            }
        }
    }
}
