package shoestore.shoestore;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AppTest {
	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		 System.setProperty("webdriver.chrome.driver","C:/Users/doramylove/Downloads/chromedriver_win32 (2)/chromedriver.exe");
		  driver = new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 driver.manage().window().maximize();
		 driver.get("https://rb-shoe-store.herokuapp.com/");
		try{
			driver.findElement(By.xpath("//input[@id='remind_email_input']")).sendKeys("dora.chowdary@gmail.com");
			driver.findElement(By.xpath("//input[@id='remind_email_submit']")).click();
			if(driver.findElement(By.xpath(".//*[@id='flash']/div")).getText().contains("Thanks! We will notify you of our new shoes at this email:"))
			{
				System.out.println("As a user of the Shoe Store I am able to submit my email address");
			}
				  int numberOfElementsFound = getNumberOfElementsFound(By.tagName("a"));
				  for (int pos = 0; pos < numberOfElementsFound; pos++) {
					  if (getElementWithIndex(By.tagName("a"), pos).isDisplayed()){
					  getElementWithIndex(By.tagName("a"), pos).click();
					  List<WebElement> noofshoes =  driver.findElements(By.xpath("//ul[@id='shoe_list']/li/div/table/tbody/tr/td"));
					  for(WebElement element: noofshoes){
						  String Ele = element.getAttribute("innerHTML");
						if(Ele.equalsIgnoreCase("Price")){
							System.out.println("price is displayed");
						}
						if(Ele.equalsIgnoreCase("Description")){
							System.out.println("Description is displayed");
						}
					  }
					  List<WebElement> noofimages = driver.findElements(By.xpath("//td[@class='shoe_image']/img"));
					  for(WebElement ele: noofimages){
						String image = ele.getAttribute("src");
						if(image.contains("http")){
							System.out.println("image is displayed");
						}
					  }
				 
					  }
				  }	
	}
	catch(Exception e){
		e.printStackTrace();
	}
	}
	
	public static int getNumberOfElementsFound(By by) {
        return driver.findElements(by).size();

    }

    public static WebElement getElementWithIndex(By by, int pos) {
        return driver.findElements(by).get((int) pos);
    }
}
