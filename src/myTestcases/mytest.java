package myTestcases;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class mytest extends parameter {

//	to access a mobile App and interact within we need build a setup
	DesiredCapabilities caps = new DesiredCapabilities();

	AndroidDriver driver;

	@BeforeTest
	public void mSetup() {
//		to declared the type PLATFORM_NAME (key , value)
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
//		the device you gone test on it
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "appTset");
//		import the mobile application using File method
		File myMobileAppLocation = new File("src/myApplication/calculator.apk");
//	    to set capability we use a setCapability method
		caps.setCapability(MobileCapabilityType.APP, myMobileAppLocation.getAbsolutePath());
	}

	@Test(priority = 1, enabled = false)
	public void myTest() throws MalformedURLException {
//	 to identify and link between driver with caps

	}

	@Test(enabled = true, priority = 2)
	public void pressOnAllNumber2() throws IOException, InterruptedException {

		List<WebElement> allNumber = driver.findElements(By.className("android.widget.ImageButton"));

		for (int i = 0; i < allNumber.size(); i++) {

			// Check if the element's resource-id contains "digit" before clicking

			if (allNumber.get(i).getAttribute("resource-id").contains("digit")) {

				String allNum = allNumber.get(i).getAttribute("content-desc");

				int number = Integer.parseInt(allNum);

				boolean isNumeric = allNum.matches("\\d+");

				// 'isNumeric' will be false if non-numeric values were accepted

				if (isNumeric == true && number % 2 == 0) {

					allNumber.get(i).click();
					tSShoot();

				}

			}
		}

	}
}
