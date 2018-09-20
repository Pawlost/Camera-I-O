import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.time.LocalDateTime;

public class Main {
    static {
        nu.pattern.OpenCV.loadShared();
    }

    public static void main(String[] args) {
        JFrame crack = new JFrame("crack");
        crack.setBounds(0,0,0,0);
        crack.setAlwaysOnTop(true);
        crack.setVisible(true);


        crack.addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent keyEvent) { }

            public void keyPressed(KeyEvent keyEvent) {
                onKeyPressed();
            }

            public void keyReleased(KeyEvent keyEvent) { }
        });
    }

    private static void onKeyPressed(){
        File pictures = new File("./pictures/");
        pictures.mkdirs();
        Snapshot snapshot = new Snapshot(pictures.getPath() + "/" + LocalDateTime.now() + ".jpg");
        try {
            snapshot.takeShot();
        } catch (Exception e) {
            System.out.println("Error with camera");
            e.printStackTrace();
        }
        System.out.println("Saved as "+LocalDateTime.now());
    }
}
