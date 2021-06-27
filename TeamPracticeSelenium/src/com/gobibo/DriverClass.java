package com.gobibo;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class DriverClass {
	public static WebDriver driver;

	public static WebDriver setupBrower()
	{
	  	 // System Property for Chrome Driver   
			System.setProperty("webdriver.chrome.driver", "E:\\STUDY\\selenium\\Drivers\\chromedriver.exe");
	     // Instantiate a ChromeDriver class.     
			driver=new ChromeDriver();  
		    driver.manage().window().maximize();

		    try {
		    Properties p = new Properties();
		    String path = System.getProperty("user.dir");
		    InputStream in = new FileInputStream(path+ "/src/com/gobibo/config.properties");
		    p.load(in);
		    String launchurl = p.getProperty("url");
		    driver.get(launchurl);
			}
		    
			catch (Exception exp) 
			{
				System.out.println(exp.getMessage());
			}
		    return driver;
	}
	
}
