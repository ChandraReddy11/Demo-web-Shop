package Tasks;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TCtesting {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		String url="https://sampleapp.tricentis.com/101/app.php";
		WebDriverManager.chromedriver().setup();
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		
		driver.findElement(By.id("enterproductdata")).click();
		
		  boolean   ProductData= driver.findElement(By.xpath("(//section[@class='idealsteps-step'])[3]")).isDisplayed();
		     if (ProductData==true) {
		    System.out.println(ProductData);
		    String year = "2004";
		    int day = 22;

		    driver.findElement(By.id("openstartdatecalender")).click();
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		    while (true) {
		        String text = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
		        if (text.equals(year)) {
		            break;
		        } else {
		            driver.findElement(By.className("ui-datepicker-prev")).click();
		        }
		    }
		    WebElement desiredDay = driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']//a[text()='" + day + "']"));
	        desiredDay.click();

		     }
	}

}
