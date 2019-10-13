package Random.RandomAutomation;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "/home/alex/Downloads/geckodriver");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.seleniumeasy.com/test/table-sort-search-demo.html");
		String leftBound = "//tbody/tr[@role='row']";
		String rightBound = "/td[1]";
		ArrayList<String> names = new ArrayList<String>();
    	driver.findElement(By.xpath("//th[@class='sorting_asc']")).click();
		String pages = driver.findElement(By.xpath("//div[@id='example_info']")).getText();
		System.out.println(pages);
		String[] arr = pages.split(" ");
		int entries = Integer.parseInt(arr[5].toString());
		System.out.println(entries);
		int np = pages(entries, 10);
		
		for (int i = 2; i <= np; i++) {
			for (int j = 1; j <= 10; j++) {
				String fullXpath = leftBound + "[" + j + "]" + rightBound;
				WebElement element = driver.findElement(By.xpath(fullXpath));
				names.add(element.getText());
			}
			driver.findElement(By.xpath("//a[contains(text(),'"+i+"')]")).click();
		}
		driver.quit();
		
		for(String s: names )
			System.out.println(s);
			
		System.out.println(checkSorting(names));
	}

	  public static boolean checkSorting(ArrayList< String > arraylist){
	        boolean isSorted=true;
	        for(int i=1;i < arraylist.size();i++){
	            if(arraylist.get(i-1).compareTo(arraylist.get(i)) < 0){
	                isSorted= false;
	                break;
	            }
	        }
	        return isSorted;
	    }

	public static int pages(int entries, int onPage) {
		int totalPages = 0;
		totalPages = entries / onPage;
		if (entries % onPage != 0)
			totalPages += 1;

		return totalPages;
	}
}
