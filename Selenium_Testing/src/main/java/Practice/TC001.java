package Practice;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC001 {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		String url="https://demowebshop.tricentis.com/";
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		
// Providing valid Email with invalid password
		
		driver.findElement(By.xpath("//a[@class='ico-login']")).click();
		driver.findElement(By.id("Email")).sendKeys("demoselenium8@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("jjojsojoj");
		driver.findElement(By.xpath("//input[@value=\"Log in\"]")).click();
		
// taking the screenshot of error message of the invalid email
		
				WebElement section=driver.findElement(By.xpath("//div[@class=\"returning-wrapper\"]"));
				File src=section.getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(src, new File("C:\\screen shot\\hgb.png"));
				System.out.println(" The screenshot is successfully invalid email");
				Thread.sleep(3000);
				driver.navigate().refresh();
				
// given valid email and invalid password
				
				driver.findElement(By.id("Email")).sendKeys("demoselenium80@gmail.com");
				driver.findElement(By.id("Password")).sendKeys("demo2task");
				driver.findElement(By.xpath("//input[@value=\"Log in\"]")).click();
				System.out.println(driver.findElement(By.xpath("//div[@class=\"validation-summary-errors\"]")).getText());
				driver.findElement(By.id("Email")).clear();
				driver.findElement(By.id("Password")).clear();
				Thread.sleep(3000);
				
//valid user name and valid password
				
				driver.findElement(By.xpath("//input[@id=\"Email\"]")).sendKeys("demoselenium80@gmail.com");
				driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("demo2task");
				driver.findElement(By.xpath("//input[@value=\"Log in\"]")).submit();
				Thread.sleep(3000);
				
					
//screenshot the successful login page
				WebElement section1=driver.findElement(By.xpath("//div[@class=\"master-wrapper-content\"]"));
				File trg=section1.getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(trg, new File("C:\\screen shot\\jhg.jpg"));
				System.out.println("The screenshot is successful valid credentials");
				
//logout the page
				driver.findElement(By.xpath("//a[@class='ico-logout']")).click();
				
// closing the entire browser
				driver.close();
				driver.quit();
				
				
				
				
				
	}

}
