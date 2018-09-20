import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.videoio.VideoCapture;

public class MyRunnable implements Runnable {

    private VideoCapture webSource;
    private Mat frame;
    private String saveFile;

    public MyRunnable(VideoCapture webSource, String saveFile) {
        this.webSource = webSource;
        frame = new Mat();
        this.saveFile = saveFile;
    }

 @Override
    public void run() {
        if (webSource.grab()) {
            webSource.retrieve(frame);
            Imgcodecs.imwrite(saveFile, frame);
            webSource.release();
        }
    }
}
