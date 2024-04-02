package myTestcases;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class parameter {
	Date date = new Date();

	DesiredCapabilities caps = new DesiredCapabilities();

	public void tSShoot() throws InterruptedException, IOException {
		AndroidDriver driver;
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);

		TakesScreenshot Ts = (TakesScreenshot) driver;

		String fileName = date.toString().replace(":", "-");

		File fileTs = Ts.getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(fileTs, new File("src/pictures/" + fileName + ".jpg"));

	}

}
