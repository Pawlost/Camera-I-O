import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.videoio.VideoCapture;


public class Snapshot {
    private VideoCapture webSource = null;
    private Thread t;

    public Snapshot(String saveFile) {
        webSource = new VideoCapture(0);
        MyRunnable myRunnable = new MyRunnable(webSource, saveFile);
        t = new Thread(myRunnable);
    }

    public void takeShot() throws Exception {
        t.interrupt();
        t.start();
    }
}
