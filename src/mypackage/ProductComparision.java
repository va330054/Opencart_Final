package mypackage;

import java.io.File;
import java.io.FileWriter;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class ProductComparision extends CommonFunctions {
public void  compare() {
       
	try{
		File fl = new File("SearchProduct.xls");
		Workbook w= Workbook.getWorkbook(fl);
		Sheet s= w.getSheet("Sheet1");
		int Rows=s.getRows();
		int cloumns=s.getColumns();
		String inputdata[] []=new String[Rows][cloumns];
		for(int i=1;i<=Rows;i++){
			for(int j=0;j<cloumns;j++){
				Cell c=s.getCell(j, i);
				inputdata[i][j]=c.getContents();
				
			
				//secondtest
				driver.findElement(By.name("search")).sendKeys(inputdata[i][j]);
			driver.findElement(By.xpath(".//*[@id='search']/input")).sendKeys(Keys.ENTER);	
					driver.findElement(By.xpath(".//*[@id='menu']/ul/li[6]/a")).click();
					Select dropdown= new Select(driver.findElement(By.xpath(".//*[@id='content']/div[2]/div[3]/select")));
					dropdown.selectByIndex(4);
					driver.findElement(By.xpath(".//*[@id='content']/div[4]/div[1]/div[1]/div[3]/a")).click();
					driver.findElement(By.xpath(".//*[@id='content']/div[4]/div[2]/div[1]/div[3]/a")).click();
					driver.findElement(By.xpath(".//*[@id='content']/div[4]/div[3]/div[1]/div[3]/a")).click();
				Thread.sleep(1000);
					driver.findElement(By.className("close")).click();
					driver.findElement(By.xpath(".//*[@id='compare-total']")).click();
					driver.findElement(By.linkText("Palm Treo Pro")).click();
				String feature5	= driver.findElement(By.xpath(".//*[@id='tab-description']/ul/li[5]")).getText();
				
				//writing 5th feature to flat file
				
				File file = new File("FifthFeature.txt");
				file.createNewFile();
				FileWriter writer = new FileWriter(file); 
				writer.write(feature5);
				writer.flush();
				writer.close();
					
		
				driver.findElement(By.id("button-cart")).click();
				Thread.sleep(1000);
				driver.findElement(By.xpath(".//*[@id='notification']/div/a[2]")).click();
				
				driver.findElement(By.xpath(".//*[@id='content']/div[5]/div[1]/a")).click();
				Thread.sleep(1000);
				driver.findElement(By.xpath(".//*[@id='button-payment-address']")).click();
				Thread.sleep(1000);
				driver.findElement(By.xpath(".//*[@id='button-shipping-address']")).click();
				Thread.sleep(1000);
				driver.findElement(By.xpath(".//*[@id='button-shipping-method']")).click();
				Thread.sleep(1000);
				driver.findElement(By.name("agree")).click();
				driver.findElement(By.xpath(".//*[@id='button-payment-method']")).click();
				Thread.sleep(1000);
				driver.findElement(By.xpath(".//*[@id='button-confirm']")).click();
				Thread.sleep(1000);
				driver.manage().window().maximize();
				driver.navigate().back();
				String cartempty= driver.findElement(By.xpath(".//*[@id='content']/div[2]")).getText();
			if(cartempty.equals("Your shopping cart is empty!")){
				System.out.println("shopping cart is empty -PASSED");
			}
			else {
				System.out.println("shopping cart is not empty -FAILED");
			}
			driver.findElement(By.xpath(".//*[@id='header']/div[5]/a[3]")).click();
			driver.findElement(By.xpath(".//*[@id='column-right']/div/div[2]/ul/li[6]/a")).click();
			driver.findElement(By.xpath(".//*[@id='column-right']/div/div[2]/ul/li[10]/a")).click();
			driver.findElement(By.xpath(".//*[@id='footer']/div[3]/ul/li[4]/a")).click();
			boolean b= driver.findElement(By.xpath(".//*[@id='content']/div[2]/div[1]/a")).isEnabled();
			if(b==true){
				System.out.println(b);
				System.out.println("Grid link is enabled");
			driver.findElement(By.xpath(".//*[@id='content']/div[2]/div[1]/a")).click();
				}
			 b= driver.findElement(By.xpath(".//*[@id='content']/div[2]/div[1]/a")).isEnabled();
			 if(b==true){
				 System.out.println("display is toggled");
			 }
			
				}
		}
	}
		catch(Exception e){
			
		}
	}

public static void  main(String[] args) throws InterruptedException {
			ProductComparision objProductComparision=new ProductComparision();
			objProductComparision.login();
			objProductComparision.compare();
			objProductComparision.logout();
}

}


