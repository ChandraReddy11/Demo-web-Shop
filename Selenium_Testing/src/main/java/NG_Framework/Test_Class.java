package NG_Framework;

import java.net.MalformedURLException;
import java.time.Duration;

import javax.print.DocFlavor.URL;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.helpers.Reporter;

public class Test_Class {
	
	   public String username = "YOUR USERNAME";
	    public String accesskey = "YOUR ACCESSKEY";
	    public static RemoteWebDriver driver = null;
	    public String gridURL = "@hub.lambdatest.com/wd/hub";
	 
	    @BeforeClass
	    public void setUp() throws Exception {
	        DesiredCapabilities capabilities = new DesiredCapabilities();
	        capabilities.setCapability("browserName", "chrome");
	        capabilities.setCapability("version", "95.0");
	        capabilities.setCapability("platform", "win10"); // If this cap isn't specified, it will just get the any available one
	        capabilities.setCapability("build", "CaptchaInSelenium");
	        capabilities.setCapability("name", "TCaptchaInSeleniumSample");
	        try {
	    //        driver = new RemoteWebDriver(new URL("https://" + username + ":" + accesskey + gridURL), capabilities);
	   //     } catch (MalformedURLException e) {
	            System.out.println("Invalid grid URL");
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	        }
	        driver.get("https://old.reddit.com/login");
	 
	 
	    }
	 
	 
	    @Test
	    public void clickOnRecaptchaCheckBoxInSelenium() {
	        try {
	            System.out.println("Let's start with fresh registration");
	            WebElement username=driver.findElement(By.xpath("//input[@name='user']"));
	            username.sendKeys("some_username_200");
	 
	            WebElement password=driver.findElement(By.xpath("//input[@name='passwd']"));
	            password.sendKeys("SuperStrongP@ssw0rd");
	 
	            WebElement verifyPassword=driver.findElement(By.xpath("//input[@name='passwd2']"));
	            verifyPassword.sendKeys("SuperStrongP@ssw0rd");
	 
	            WebElement email=driver.findElement(By.xpath("//input[@name='email']"));
	            email.sendKeys("xyz@gmail.com");
	 
	            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
	            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(
	                    By.xpath("//iframe[starts-with(@name, 'a-') and starts-with(@src, 'https://www.google.com/recaptcha')]")));
	           
	            wait.until(ExpectedConditions.elementToBeClickable(
	                        By.xpath("//div[@class='recaptcha-checkbox-border']"))).click();
	 
	            System.out.println("Clicked the checkbox");
	 
	        } catch (Exception e) {
	 
	        }
	 
	    }
	 
	 
	    @AfterClass
	    public void closeBrowser() {
	        driver.close();
	//        Reporter.log("Closing the browser", true);
	 
	    }
	 
	}


