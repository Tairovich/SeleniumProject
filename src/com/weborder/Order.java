package com.weborder;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Order {

	public static void main(String[] args) {
		
		//number between 1 and 100
		Random r = new Random();
		int rNumber = r.nextInt(100) +1;
		
		//middle name generation
		char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < 7; i++) {
		    char c = chars[random.nextInt(chars.length)];
		    sb.append(c);
		}
		
		//zip code with 5 digits
		StringBuilder sb2 = new StringBuilder();
		for (int i = 0; i < 5; i++) {
			int zip = r.nextInt(9);
			sb2.append(""+zip);
		}
		
		
		
		System.setProperty("webdriver.chrome.driver", "/Users/Admin/Documents/SeleniumDependencies/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
		driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
		driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
		driver.findElement(By.id("ctl00_MainContent_login_button")).click();
		driver.findElement(By.cssSelector("a[href='Process.aspx']")).click();
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity")).sendKeys(""+rNumber);
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtName")).sendKeys( "John" +" " +sb.toString() + " " +"Smith"    );
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox2")).sendKeys("123 Any st");
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox3")).sendKeys("Anytown");
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox4")).sendKeys("Virginia");
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5")).sendKeys(sb2.toString());
		
		//Payment Information
		int rCard = r.nextInt(3)+1;
		if(rCard == 1) {
			driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_0")).click();
			
			StringBuilder vs = new StringBuilder();
			for (int i = 0; i < 15; i++) {
				int visa = r.nextInt(9);
				vs.append(""+visa);
			}
			driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6")).sendKeys("4"+vs);
		}else if (rCard == 2) {
			driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_1")).click();
			StringBuilder vs = new StringBuilder();
			for (int i = 0; i < 15; i++) {
				int visa = r.nextInt(9);
				vs.append(""+visa);
			}
			driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6")).sendKeys("5" + vs);
		}else {
			driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_2")).click();
			
			StringBuilder vs = new StringBuilder();
			for (int i = 0; i < 14; i++) {
				int visa = r.nextInt(9);
				vs.append(""+visa);
			}
			driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6")).sendKeys("3");
		}
		String month = "";
		int m = r.nextInt(12)+1;
		if(m < 10) {
			month = "0"+m;
		}else {
			month =""+m;
		}
		
		int year = r.nextInt(22-17) + 18;
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox1")).sendKeys(""+month+"/"+year);
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_InsertButton")).click();
		
		//Verifying page contains "New order has been successfully added."
		
		String expected = "New order has been successfully added.";
		if(driver.getPageSource().contains(expected)) {
			System.out.println("pass");
		}else {
			System.out.println("fail");
		
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
