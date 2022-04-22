package hotelSel;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HotelWebappTest {

	WebDriver driver;
	Select select;
	WebDriverWait wait;

	@Before

	public void setup() {
		/*
		 * String browser = System.getProperty("Navigateur"); // String browser = ""; if
		 * (browser.equalsIgnoreCase("firefox")) {
		 * System.setProperty("webdriver.gecko.driver",
		 * "src/main/resources/driver/geckodriver.exe"); driver = new FirefoxDriver(); }
		 * 
		 * else if (browser.equalsIgnoreCase("chrome")) {
		 * System.setProperty("webdriver.chrome.driver",
		 * "src/main/resources/driver/chromedriver.exe"); driver = new ChromeDriver(); }
		 * 
		 * else if(browser.equalsIgnoreCase("edge")){
		 * System.setProperty("webdriver.edge.driver",
		 * "src/main/resources/driver/msedgedriver.exe"); driver = new EdgeDriver();
		 * 
		 * } else { System.setProperty("webdriver.chrome.driver",
		 * "src/main/resources/driver/chromedriver.exe"); driver = new ChromeDriver(); }
		 */

		System.setProperty("webdriver.gecko.driver", "src/main/resources/driver/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8080/HotelWebapp/");

	}

	@After

	public void teardown() {
		driver.quit();
	}

	@Test

	public void run1() throws Exception {
		wait = new WebDriverWait(driver, 15); // Explicit wait
		Select drpVille = new Select(driver.findElement(By.name("ville")));
		drpVille.selectByVisibleText("Londres");

		Actions action = new Actions(driver);

		action.moveToElement(driver.findElement(By.xpath("//button[@type='submit']"))).build().perform();

		action.moveToElement(driver.findElement(By.xpath("//button[@type='submit']"))).click().build().perform();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//th[text()='Nom']")));

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

		HotelMethods.listeTableau(driver);

		Scanner sc = new Scanner(new File("src/main/resources/london.csv"));
		List<String> fileCSV = new ArrayList<>();
		while (sc.hasNext())// returns a boolean value
		{
			fileCSV.add(sc.nextLine());
			System.out.println(fileCSV);
		}

		boolean boolval = result.equals(fileCSV);
		assertTrue(boolval);
		System.out.println("Lists are equal :" + boolval);

	}

	@Test

	public void run2() throws Exception {
		wait = new WebDriverWait(driver, 15); // Explicit wait
		Select drpVille = new Select(driver.findElement(By.name("ville")));
		drpVille.selectByVisibleText("Paris");

		Actions action = new Actions(driver);

		action.moveToElement(driver.findElement(By.xpath("//button[@type='submit']"))).build().perform();

		action.moveToElement(driver.findElement(By.xpath("//button[@type='submit']"))).click().build().perform();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//th[text()='Nom']")));

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

		Scanner sc = new Scanner(new File("src/main/resources/file.csv"));
		List<String> fileCSV = new ArrayList<>();
		while (sc.hasNext())// returns a boolean value
		{
			fileCSV.add(sc.nextLine());
			System.out.println(fileCSV);
		}

		boolean boolval = result.equals(fileCSV);
		assertTrue(boolval);
		System.out.println("Lists are equal :" + boolval);

	}
}
