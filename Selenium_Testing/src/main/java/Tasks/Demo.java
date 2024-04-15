package Tasks;

import java.util.List;
import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  List<String> strings = List.of("apple", "banana", "grape", "kiwi", "pear");

	        // Find the shortest string using Stream.min()
	        String lowestString = strings.stream().min((s1, s2) -> Integer.compare(s1.length(), s2.length())).orElse("");

	        System.out.println("Lowest string: " + lowestString);
	        
	        
	        ///////////////////////////////////////////////////////////
	        
	     
	                String[] products = {"Lenovo", "Huawei", "Oppo", "HP", "Mac", "MSI", "Asus", "Dell"};
	                int[] price = {4500000, 1700000, 6500000, 1000000, 3000000, 14000000, 183000000, 44000000};

	                int lowestValue = Integer.MAX_VALUE;
	                int lowestIndex = -1;

	                for (int i = 0; i < price.length; i++) {
	                    if (price[i] < lowestValue) {
	                        lowestValue = price[i];
	                        lowestIndex = i;
	                    }
	                }

	                if (lowestIndex != -1) {
	                    System.out.println("The cheapest product is: " + products[lowestIndex] +
	                            " with a price of: " + price[lowestIndex]);
	                } else {
	                    System.out.println("No products found.");
	                }
	                ////////////////////////////
	                
	                By driver = null;
					WebElement textField = driver.findElement((SearchContext) By.id("text_field_id")); // replace with your text field's ID

	                // Generate a random UUID and convert it to a string
	                String randomText = UUID.randomUUID().toString();
	                // Trim the random string to a specific length if needed
	                randomText = randomText.substring(0, Math.min(randomText.length(), 10));

	                // Send the random string to the text field
	                textField.sendKeys(randomText);
	            

	}
}