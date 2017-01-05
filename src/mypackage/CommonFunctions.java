package mypackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class CommonFunctions {

	public WebDriver driver; 
	public String URL="http://10.207.182.108:81/opencart/";		//localhost: http://10.207.182.108:81/opencart/

	public void login() throws InterruptedException{
		System.setProperty("Webdriver.chrome.driver", "chromedriver.exe");	
		 driver=new ChromeDriver();
		driver.get(URL);
		driver.findElement(By.xpath(".//*[@id='welcome']/a[1]")).click();
		driver.findElement(By.xpath(".//*[@id='content']/div[2]/div[2]/form/div/input[1]")).sendKeys("mail76@gmail.com");
		driver.findElement(By.name("password")).sendKeys("vaseem123");
		driver.findElement(By.xpath(".//*[@id='content']/div[2]/div[2]/form/div/input[3]")).click();
		String username = driver.findElement(By.xpath(".//*[@id='welcome']/a[1]")).getText();
		if(username.equals("vaseem")){
			System.out.println("Login succesful user first name is showing as link - PASSED");
			
		}
		else {
			System.out.println("Login unsuccesful -FAILED");
		}
	}
public void logout(){
	  driver.findElement(By.xpath(".//*[@id='welcome']/a[2]")).click();

			String logoutmsg= driver.findElement(By.xpath(".//*[@id='content']/h1")).getText();
			boolean logout=logoutmsg.equals("Account Logout");
		boolean	 loginlink= driver.findElement(By.xpath(".//*[@id='welcome']/a[1]")).isEnabled();
		if(logout&&loginlink==true){
			System.out.println("Logout succesful-PASSED");
		}
		else{
			System.out.println("Logout  not succesful-FAILED");
		}
	
	
	
	
	
	
}
public void close(){
	driver.close();
}
	
	
	public static void main(String[] args) throws InterruptedException {

		
		CommonFunctions objCommonFunctions=new CommonFunctions();
		
		objCommonFunctions.login();
	
		
			

	}

}
