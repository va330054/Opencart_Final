package mypackage;

import org.openqa.selenium.By;

public class AddingProductsTC7 extends CommonFunctions {

	public void addingprodmethod() throws InterruptedException{
		
	driver.findElement(By.xpath(".//*[@id='menu']/ul/li[6]/a")).click();
	driver.findElement(By.xpath(".//*[@id='content']/div[4]/div[1]/div[1]/div[1]/input")).click();
	Thread.sleep(1000);
String msg1=	driver.findElement(By.xpath(".//*[@id='notification']/div")).getText();
	if(msg1.contains("Success: You have added HTC Touch HD to your shopping cart!")){
		System.out.println("product-1 added -PASSED");
	}
	else{
		System.out.println("Product-1 not added-FAILED");
	}
	driver.findElement(By.xpath(".//*[@id='menu']/ul/li[6]/a")).click();
	
	
	
	driver.findElement(By.xpath(".//*[@id='content']/div[4]/div[2]/div[1]/div[1]/input")).click();
	Thread.sleep(1000);
String msg2=	driver.findElement(By.xpath(".//*[@id='notification']/div")).getText();
	if(msg2.contains("Success: You have added iPhone to your shopping cart!")){
		System.out.println("product-2 added -PASSED");
	}
	else{
		System.out.println("Product-2 not added-FAILED");
	}
	driver.findElement(By.xpath(".//*[@id='notification']/div/img")).click();
	
		
	
	
	driver.findElement(By.xpath(".//*[@id='content']/div[4]/div[3]/div[1]/div[1]/input")).click();
	Thread.sleep(1000);
String msg3=	driver.findElement(By.xpath(".//*[@id='notification']/div")).getText();
	if(msg3.contains("Success: You have added Palm Treo Pro to your shopping cart!")){
		System.out.println("product-3 added -PASSED");
	}
	else{
		System.out.println("Product-3 not added-FAILED");
	}
	
	driver.findElement(By.xpath(".//*[@id='notification']/div/a[2]")).click();
	driver.findElement(By.xpath(".//*[@id='content']/div[5]/div[1]/a")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath(".//*[@id='button-payment-address']")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath(".//*[@id='button-shipping-address']")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath(".//*[@id='button-shipping-method']")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath(".//*[@id='payment-method']/div[2]/div/div/input[1]")).click();
	driver.findElement(By.xpath(".//*[@id='button-payment-method']")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath(".//*[@id='button-confirm']")).click();
	Thread.sleep(1000);
	driver.manage().window().maximize();
	
	
	
	
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) throws InterruptedException {
	
		
		AddingProductsTC7 objAddingProductsTC7=new AddingProductsTC7();
		
		objAddingProductsTC7.login();
		objAddingProductsTC7.addingprodmethod();
		objAddingProductsTC7.logout();
		
		
		
		
		
		
		
		
		
		

	}

}
