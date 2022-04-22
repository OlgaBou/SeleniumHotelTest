package hotelSel;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HotelMethods {
	
	WebDriver driver;
	Select select;
	WebDriverWait wait;
	
	public static void listeTableau(WebDriver driver) {
		WebElement table = driver.findElement(By.xpath("//tbody"));
		// Now get all the TR elements from the table
		List<WebElement> allRows = table.findElements(By.tagName("tr"));
		List<String> result = new ArrayList<>();
		// And iterate over them, getting the cells
		for (WebElement row : allRows) {
			List<WebElement> cells = row.findElements(By.tagName("td"));
			// Print the contents of each cell
			for (WebElement cell : cells) {
				result.add(cell.getText());
			}
		}
		System.out.println(result);
	}

}
