package utilities;

import org.monte.media.Format;
import org.monte.media.FormatKeys;
import org.monte.media.Registry;
import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder;

import java.awt.*;
import java.io.File;
import java.io.IOException;

import static org.monte.media.FormatKeys.*;
import static org.monte.media.FormatKeys.FrameRateKey;
import static org.monte.media.VideoFormatKeys.*;
import static org.monte.media.VideoFormatKeys.QualityKey;

// Custom Screen Recorder class for recording test executions.
public class MonteScreenRecorder extends ScreenRecorder
{
    public static ScreenRecorder screenRecorder;
    public String name;

    // Constructor for MonteScreenRecorder
    // Initializes the screen recorder with specific configurations for recording area, formats, and output folder.
    // parameters:
    // cfg           Graphics configuration for the screen recording.
    // captureArea   The area of the screen to capture (Rectangle).
    // fileFormat    The format of the output file.
    // screenFormat  The format of the video screen recording.
    // mouseFormat   The format for capturing mouse actions.
    // audioFormat   The format for capturing audio (null if not used).
    // movieFolder   The folder where the recorded video will be saved.
    // name          The custom name for the video file.
    public MonteScreenRecorder(GraphicsConfiguration cfg, Rectangle captureArea, Format fileFormat,
                               Format screenFormat, Format mouseFormat, Format audioFormat, File movieFolder, String name)
            throws IOException, AWTException {
        super(cfg, captureArea, fileFormat, screenFormat, mouseFormat, audioFormat, movieFolder);
        this.name = name;
    }

    // Method name: createMovieFile
    // description: create a new video file with a custom name in the specified folder.
    // Method parameters: fileFormat (The format of the output video file)
    // Method return: a File object (representing the created video file)
    @Override
    protected File createMovieFile(Format fileFormat) throws IOException
    {
        if (!movieFolder.exists())
        {
            movieFolder.mkdirs();
        }
        else if (!movieFolder.isDirectory())
        {
            throw new IOException("\"" + movieFolder + "\" is not a directory.");
        }

        System.out.println("file is now created");
        return new File(movieFolder,
                name + "." + Registry.getInstance().getExtension(fileFormat));
    }

    // Method name: startRecord
    // Method description: Starts recording the screen
    // Method parameters: String (the name of the test method to use as the file name)
    // comments: configures the recording settings such as resolution, file format, and recording folder.
    public static void startRecord(String methodName) throws Exception
    {
        File file = new File("C:/Automation/FinalProject/test-recordings");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height;

        Rectangle captureSize = new Rectangle(0, 0, width, height);

        GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment().
                getDefaultScreenDevice()
                .getDefaultConfiguration();

        // Initializes the screen recorder with the specified settings.
        screenRecorder = new MonteScreenRecorder(gc, captureSize,
                new Format(MediaTypeKey, FormatKeys.MediaType.FILE, MimeTypeKey, MIME_AVI),
                new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
                        CompressorNameKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE, DepthKey, 24, FrameRateKey,
                        Rational.valueOf(15), QualityKey, 1.0f, KeyFrameIntervalKey, 15 * 60),
                new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, "black", FrameRateKey, Rational.valueOf(30)),
                null, file, methodName);

        // Starts the recording.
        screenRecorder.start();
    }

    // Method name: stopRecord
    // Method description: stops the screen recording and saves the video file.
    public static void stopRecord() throws Exception
    {
        screenRecorder.stop();
        System.out.println("file stop recording");
    }
}