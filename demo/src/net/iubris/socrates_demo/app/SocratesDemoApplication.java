package net.iubris.socrates_demo.app;

import roboguice.RoboGuice;
import android.app.Application;

public class SocratesDemoApplication extends Application {

	static {
		RoboGuice.setUseAnnotationDatabases(false);
	}
}
