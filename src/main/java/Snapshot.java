import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.videoio.VideoCapture;


public class Snapshot {
    private String saveFile;
    private VideoCapture webSource = null;
    private int count;

    private Mat frame = new Mat();

    public Snapshot(String saveFile) {
        this.saveFile = saveFile;
        webSource = new VideoCapture(0);
    }

    public void takeShot() throws Exception {
        if (webSource.grab()) {
                webSource.retrieve(frame);
                Imgcodecs.imwrite(saveFile, frame);
                System.out.println("Saving picture");
                webSource.release();
        }
        count++;
    }

    public int getCount() {
        return count;
    }
}
