import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.*;

public class Calculator extends Thread
{
    MediaPlayer rolling;
    public Calculator() {
        rolling = new MediaPlayer(new Media(new File("RecommendedDailyValues.mp3").toURI().toString()));
    }
    
    public void run() {
        rolling.play();
    }
}
