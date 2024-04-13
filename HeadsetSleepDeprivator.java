import javax.sound.sampled.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class HeadsetSleepDeprivator {

    private static final String CONFIG_FILE = "config.txt";
    private static final float SAMPLE_RATE = 44100.0f;
    private static final int BIT_DEPTH = 16;
    private static final int CHANNELS = 1;

    public static void generateHighFrequencyTone(int durationMs, float frequency, float volume) throws LineUnavailableException {
        AudioFormat format = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, SAMPLE_RATE, BIT_DEPTH, CHANNELS, 2, SAMPLE_RATE, false);
        SourceDataLine line = AudioSystem.getSourceDataLine(format);
        line.open(format);
        line.start();

        long bufferLength = (long) (SAMPLE_RATE * durationMs / 1000);
        byte[] buffer = new byte[(int) (bufferLength * 2)];

        for (int i = 0; i < bufferLength; i++) {
            double angle = 2.0 * Math.PI * i / (SAMPLE_RATE / frequency);
            short val = (short) (Math.sin(angle) * Short.MAX_VALUE * volume);
            buffer[2 * i] = (byte) (val & 0xFF);
            buffer[2 * i + 1] = (byte) ((val >> 8) & 0xFF);
        }

        line.write(buffer, 0, buffer.length);
        line.drain();
        line.stop();
        line.close();
    }

    private static Properties loadOrCreateProperties() throws IOException {
        Properties props = new Properties();
        File configFile = new File(CONFIG_FILE);
        if (configFile.exists()) {
            props.load(new FileInputStream(configFile));
        } else {
            // Default values
            props.setProperty("frequency", "20");
            props.setProperty("duration", "10000");
            props.setProperty("sleeptime", "120000");
            props.setProperty("volume", "0.1");
            props.store(new FileOutputStream(CONFIG_FILE), "Headphone Sleep Deprivation Configuration");
        }
        return props;
    }

    public static void main(String[] args) {
        try {
            Properties props = loadOrCreateProperties();
            int durationMs = Integer.parseInt(props.getProperty("duration"));
            float frequency = Float.parseFloat(props.getProperty("frequency"));
            float volume = Float.parseFloat(props.getProperty("volume"));
            int sleepTime = Integer.parseInt(props.getProperty("sleeptime"));

            while (true) {
                generateHighFrequencyTone(durationMs, frequency, volume);
                Thread.sleep(sleepTime);
            }
        } catch (IOException e) {
            System.err.println("Error handling the configuration file: " + e.getMessage());
            return;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        } catch (LineUnavailableException e) {
            System.err.println("Audio line unavailable: " + e.getMessage());
            return;
        }
    }
}