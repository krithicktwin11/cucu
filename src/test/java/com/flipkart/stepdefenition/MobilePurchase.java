package com.flipkart.stepdefenition;


import java.awt.RenderingHints.Key;
import java.io.File;
import java.io.IOException;
import java.sql.Driver;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MobilePurchase {
	public static WebDriver driver;
	@Given("user launches flipkart application")
	public void user_launches_flipkart_application() {
		System.out.println("launch");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	    driver.get("https://www.flipkart.com/");
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Given("user handles the login")
	public void user_handles_the_login() {
				System.out.println("login");
				   WebElement close=   driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']"));
					close.click();
	}
          String name ="";
	@When("user search mobile {string} ")
	public void user_search_mobile(String mobile) {
		     name =mobile;
		WebElement search = driver.findElement(By.name("q"));
		search.sendKeys(name,Keys.ENTER);
		//driver.findElement(By.xpath("//button[@class='L0Z3Pu']")).click();    
	}

	@When("user select the mobile and click add to cart")
	public void user_select_the_mobile_and_click_add_to_cart() throws InterruptedException {
		System.out.println("windowhandle");
		   
		   driver.findElement(By.xpath("(//div[contains(text(),'"+name+"')])[2]")).click();
		 
		   
		   String parent=  driver.getWindowHandle();
		   Set<String>child=driver.getWindowHandles();
		
		           for(String r:child){
			   if(!parent.equals(r)){
				driver.switchTo().window(r);
			  }
		       }  
	}

	@When("user doing the payment")
	public void user_doing_the_payment() throws InterruptedException {
		   System.out.println("Screenshot");
		   
		    JavascriptExecutor j= (JavascriptExecutor)driver;
		   j.executeScript("window.scrollBy(0,2500)","");
		 
		
	}

	@Then("user recieve the confirmation message")
	public void user_recieve_the_confirmation_message() throws IOException {
		  
		   TakesScreenshot ts= (TakesScreenshot)driver;
	         File src=  ts.getScreenshotAs(OutputType.FILE);
	        File d= new File("C:\\Users\\krith\\workspace\\cucumber-project\\screenschot\\photo.png");
	        FileUtils.copyFile(src, d);
	    
	}
	
	@When("user search mobile ")
	public void user_search_mobile_by_oneD_list(DataTable dataTable) {
		List<String> datas =dataTable.asList();
		 name = datas.
			WebElement search = driver.findElement(By.name("q"));
			search.sendKeys(name,Keys.ENTER);
		
	    
	}

}
