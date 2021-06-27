package com.gobibo;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class BookTicket extends DriverClass{

	public static void main(String[] args) throws Exception {
		//Call BrowserSetup Method
	 BookTicket.setupBrower();	
		Thread.sleep(2000);
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//div[1]/header/ul/li[1]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"roundTrip\"]")).click();
		Thread.sleep(500);
		//FROM
		driver.findElement(By.xpath("//*[@id=\"gosuggest_inputSrc\"]")).sendKeys("Madurai");
		Thread.sleep(500);
		// Actions class
	      Actions a = new Actions(driver);
	      // moveToElement() and then click()
	      a.sendKeys(Keys.DOWN).build().perform();
			Thread.sleep(100);
			a.sendKeys(Keys.ENTER).build().perform();
			Thread.sleep(500);
			//TO
	      driver.findElement(By.xpath("//*[@id=\"gosuggest_inputDest\"]")).sendKeys("Chennai");
			Thread.sleep(500);
	      a.sendKeys(Keys.DOWN).build().perform();
			Thread.sleep(100);
	      a.sendKeys(Keys.ENTER).build().perform();
			Thread.sleep(500);

	      
//From Date Select
		      driver.findElement(By.xpath("//*[@id=\"departureCalendar\"]")).click();
		      Thread.sleep(200);

String fmonthyear = driver.findElement(By.xpath("//*[@class='DayPicker-Caption']")).getText();
System.out.println(fmonthyear);

while(!(fmonthyear.equals("August 2021")))
{

	driver.findElement(By.xpath("//div[1]/div[1]/div[1]/div/div[6]/div/div/div/div[1]/span[2]")).click();
	fmonthyear = driver.findElement(By.xpath("//*[@class='DayPicker-Caption']")).getText();
}
driver.findElement(By.xpath("//*[@id=\"fare_20210820\"]")).click();



//To Date Select
driver.findElement(By.xpath("//*[@id=\"returnCalendar\"]")).click();
Thread.sleep(500);
String tmonthyear = driver.findElement(By.xpath("//*[@class='DayPicker-Caption']")).getText();
System.out.println(tmonthyear);


Thread.sleep(500);
while(!(tmonthyear.equals("September 2021")))
{

	driver.findElement(By.xpath("//div[1]/div[1]/div[1]/div/div[8]/div/div/div/div[1]/span[2]")).click();
	tmonthyear = driver.findElement(By.xpath("//*[@class='DayPicker-Caption']")).getText();
}
driver.findElement(By.xpath("//*[@id=\"fare_20210928\"]")).click();
Thread.sleep(500);
driver.findElement(By.xpath("//*[@id=\"pax_link_common\"]")).click();

driver.findElement(By.xpath("//*[@id=\"adultPaxPlus\"]")).click();
driver.findElement(By.xpath("//*[@id=\"childPaxPlus\"]")).click();
driver.findElement(By.xpath("//*[@id=\"infantPaxPlus\"]")).click();

Thread.sleep(500);
//select Class of Travel
Select fclass= new Select (driver.findElement(By.xpath("//*[@id=\"gi_class\"]")));
fclass.selectByValue("E");

Thread.sleep(500);
driver.findElement(By.xpath("//*[@id=\"gi_search_btn\"]")).click();
Thread.sleep(2000);

//Click Price sort
driver.findElement(By.xpath("//div/div[3]/div[2]/div[1]/div[4]/div/span")).click();

driver.findElement(By.xpath("//div[1]/div/div[2]/span[2]/input")).click();

Thread.sleep(2000);

JavascriptExecutor js = (JavascriptExecutor) driver;
js.executeScript("window.scrollBy(0,3000)");

Thread.sleep(500);
driver.findElement(By.xpath("//div[2]/div[4]/div[3]/div[2]/div[2]/div[1]/div/span")).click();
Thread.sleep(500);

driver.findElement(By.xpath("//*[@class='common-elementsstyles__CustSelectTrvl-ilw4bs-9 jGncYu']")).click();

Select salutation1= new Select (driver.findElement(By.xpath("//*[@class='common-elementsstyles__CustSelectTrvl-ilw4bs-9 jGncYu']")));
salutation1.selectByValue("Mr");

driver.findElement(By.name("givenname")).sendKeys("AnanthaKumar");
driver.findElement(By.name("lastname")).sendKeys("Silonmani");

	}


}