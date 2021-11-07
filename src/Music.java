import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Music {
    private URL url;
    private Clip clip;
//    /**
//     * @param requestedSound The requested type of sound
//     */
    public Music(){}
    public Music(String requestedSound) {
        url = this.getClass().getResource(requestedSound);
        if (url != null) {
            try {
                // Open an audio input stream.
                // Get a sound clip resource.
                // Open audio clip and load samples from the audio input stream.
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(url);
                clip = AudioSystem.getClip();
                clip.open(audioInput);


            } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
                e.printStackTrace();
            }

        }
    }

    /**
     * Plays the sound
     */
    public void play() {
        clip.setFramePosition(0);
        clip.start();
    }

    public static synchronized void playSound(final String url) {
        try
        {
            File file = new File(url);
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(file);
            AudioFormat format = inputStream.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, format);
            Clip clip = (Clip)AudioSystem.getLine(info);
            clip.open(inputStream);
            clip.start();
        }

        catch (IOException | LineUnavailableException | UnsupportedAudioFileException e1)
        {
            e1.printStackTrace();
        }
    }
}