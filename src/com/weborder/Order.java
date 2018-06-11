package com.weborder;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Order {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver","/Users/soniasaber/Documents/selenium dependencies/drivers/chromedriver");

		WebDriver driver = new ChromeDriver();
		driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
		

		Thread.sleep(2000);
		driver.findElement(By.name("ctl00$MainContent$username")).sendKeys("Tester");
		Thread.sleep(2000);
		driver.findElement(By.name("ctl00$MainContent$password")).sendKeys("test");
		Thread.sleep(2000);
		driver.findElement(By.name("ctl00$MainContent$login_button")).click();
		Thread.sleep(2000);
		driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/weborders/Process.aspx");
		Thread.sleep(2000);
		
		//quantity
		Random random = new Random();
		int i = random.nextInt(99) + 1;
		String f = "" + i;
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtQuantity")).sendKeys(f);
		Thread.sleep(2000);
		
		//name
		int leftLimit = 97; // letter 'a'
		int rightLimit = 122; // letter 'z'
		int targetStringLength = 5;
		Random random2 = new Random();
		StringBuilder buffer = new StringBuilder(targetStringLength);
		for (int z = 0; z < targetStringLength; z++) {
			int randomLimitedInt = leftLimit + (int) (random2.nextFloat() * (rightLimit - leftLimit + 1));
			buffer.append((char) randomLimitedInt);
		}
		String generatedString = buffer.toString();
		Thread.sleep(2000);
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtName"))
				.sendKeys("John " + generatedString + " Smith");
		
		//address
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox2")).sendKeys("123 Any st");
		Thread.sleep(2000);
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox3")).sendKeys("Anytown");
		Thread.sleep(2000);
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox4")).sendKeys("Virginia");
		Thread.sleep(2000);
		
		//zip code
		Random random1 = new Random();
        int y = random1.nextInt(99999);
        String n = "" + y;
        driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox5")).sendKeys(n);
		Thread.sleep(2000);
		
		//card name and number
		int z = random.nextInt(3) + 1;
		Thread.sleep(2000);
		if (z == 1) {
			driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_0")).click();
			Random random3 = new Random();
			Random random4 = new Random();
			int a = random3.nextInt(9999999);
			int b = random4.nextInt(99999999);
			driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox6")).sendKeys(4 + "" + a + b);
		} else if (z == 2) {
			driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_1")).click();
			Random random3 = new Random();
			Random random4 = new Random();
			int a = random3.nextInt(9999999);
			int b = random4.nextInt(99999999);
			driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox6")).sendKeys(5 + "" + a + b);
		} else if (z == 3) {
			driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_2")).click();
			Random random3 = new Random();
			Random random4 = new Random();
			int a = random3.nextInt(9999999);
			int b = random4.nextInt(9999999);
			driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox6")).sendKeys(3 + "" + a + b);
		}
		Thread.sleep(2000);
		
		//date
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox1")).sendKeys("08/21");
		Thread.sleep(2000);
		
		//click process
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_InsertButton")).click();
		Thread.sleep(2000);
		
		//result
		
		
		String expected = "New order has been successfully added.";
        String text = driver.findElement(By.tagName("body")).getText();
        if (text.contains(expected)) {
            System.out.println("pass");
        } else {
            System.out.println("fail");
            System.out.println("Expected:\t" + expected);
        }

	}
}