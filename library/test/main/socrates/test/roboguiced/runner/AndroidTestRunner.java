package socrates.test.roboguiced.runner;

import java.io.File;

import org.junit.runners.model.InitializationError;

import com.xtremelabs.robolectric.RobolectricConfig;
import com.xtremelabs.robolectric.RobolectricTestRunner;

public class AndroidTestRunner extends RobolectricTestRunner {

    // The name of the Android manifest file.
    private static final String MANIFEST_FILE_NAME = "AndroidManifest.xml";

    // The name of the Android resource folder.
    private static final String RES_FOLDER_NAME = "res";

    // Find the root of the Android project. This depends on how the unit test runner
    // is executed: from within an IDE, or from the Ant build file. If it's executed
    // from within an IDE (so from inside the `test/` directory), the root is located
    // one directory "up" (`..`), and when executed from the Ant build file, it's just
    // the present working dir: `.`
    private static final File ROOT_ANDROID_PROJECT =
            new File(MANIFEST_FILE_NAME).exists() ? new File(".") : new File("..");

    /**
     * The manifest file of the Android project that is to be tested.
     */
    public static final File MANIFEST_ANDROID_PROJECT =
            new File(ROOT_ANDROID_PROJECT, MANIFEST_FILE_NAME);

    /**
     * The resource folder of the Android project that is to be tested.
     */
    public static final File RES_FOLDER_ANDROID_PROJECT =
            new File(ROOT_ANDROID_PROJECT, RES_FOLDER_NAME);

    /**
     * Creates a new <code>AndroidTestRunner</code>.
     * project
     * @param testClass            the class to be tested.
     * @throws InitializationError if either <code>MANIFEST_ANDROID_PROJECT</code> or
     *                             <code>RES_FOLDER_ANDROID_PROJECT</code> do not exist.
     */
    public AndroidTestRunner(Class<?> testClass) throws InitializationError {
        super(testClass,
                new RobolectricConfig(
                        MANIFEST_ANDROID_PROJECT, RES_FOLDER_ANDROID_PROJECT
                )
        );
    }
}
