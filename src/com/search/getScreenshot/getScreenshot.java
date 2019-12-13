package com.search.getScreenshot;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class getScreenshot {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input")).sendKeys("ProQuest\n");
		
		//Click ProQuest link
		driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div/div[1]/a/div/cite")).click();
		//Click search button, type QA and search
		driver.findElement(By.xpath("//*[@id=\"main-navbar-collapse\"]/ul[1]/li[8]/a/i")).click();
		driver.findElement(By.xpath("//*[@id=\"search-form\"]/div/span[1]/input[2]")).sendKeys("QA");
		driver.findElement(By.xpath("//*[@id=\"search-form\"]/div/span[2]/button/i")).click();
		//Take a screenshot
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("C:\\Temp\\ProQuestQA.jpg"));
		//Close browser
		driver.close();
	}
}
