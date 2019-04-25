package amazonAutoTestingFramework.utils.helpers;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.remote.MobileCapabilityType;

public class AppiumDriverManager {
	
	/*
	 * This is the Appium's capabilities class in case we want to integrate Appium and Selenium in one framework
	 */
	public enum Capabilities {

		ANDROID {
			@Override
			public DesiredCapabilities getCapabilities(String app, String device, String pkg, Proxy proxy) {
				DesiredCapabilities capabilities = new DesiredCapabilities();
				capabilities.setCapability("appPackage", "com.escooterapp");
				capabilities.setCapability("appActivity", "com.escooterapp.MainActivity");
				capabilities.setCapability("dontStopAppOnReset", "true");
				capabilities.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir")+"/Base_App_Files/android/"+app);
				capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
				capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "CAA_Test_Device");
				capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 30000);
				capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
				// following ("true") is optional to auto allow all permissions and disable pop-ups
				capabilities.setCapability("autoGrantPermissions", "true");
				capabilities.setCapability(CapabilityType.PROXY, proxy);
				capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

				return capabilities;
			}
		},

		IOS { 
			@Override
			public DesiredCapabilities getCapabilities(String app, String device, String pkg, Proxy proxy) {
				DesiredCapabilities capabilities = new DesiredCapabilities();
				capabilities.setCapability("appPackage", "com.escooterapp");
				capabilities.setCapability("appActivity", "com.escooterapp.MainActivity");
				capabilities.setCapability("dontStopAppOnReset", "true");
				capabilities.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir")+"/Base_App_Files/android/"+app);
				capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
				capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "CAA_Test_Device");
				capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 30000);
				capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
				// following ("true") is optional to auto allow all permissions and disable pop-ups
				capabilities.setCapability("autoGrantPermissions", "true");
				capabilities.setCapability(CapabilityType.PROXY, proxy);
				capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				return capabilities;

			}
		};

		public abstract DesiredCapabilities getCapabilities(String app, String device, String pkg, Proxy proxy);

	}

}
