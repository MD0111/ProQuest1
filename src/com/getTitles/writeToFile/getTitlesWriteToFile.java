package com.getTitles.writeToFile;

import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class getTitlesWriteToFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input")).sendKeys("ProQuest\n");
		//Get the titles
		List <WebElement> postTitles= driver.findElements(By.className("S3Uucc"));
		  for (WebElement eachTitle : postTitles) {
		    //System.out.println(eachTitle.getText());
		  	String innerText = eachTitle.getText();
			String idForTxtFile = new SimpleDateFormat("dd.MM.yyyy_HH.mm.ss").format(new Date());
			File file = new File("C:\\Temp\\InnerTextFile.txt" + idForTxtFile);
		    //Write to a file
		   try {
			  FileWriter fw = new FileWriter(file,true);
			  String lineSeparator = System.getProperty("line.separator");
			  String[] output = innerText.split ("\n");
			  
			  for (int i=0; i<=output.length-1; i++) {
				  fw.write(output[i]);
				  fw.write(lineSeparator); 
			  }
			  fw.flush();
			  fw.close();
		   }catch(Exception e) {
			  System.out.println(e);
			  e.printStackTrace();
			  System.out.println(e.getLocalizedMessage());
		 }
    }
  }
}

