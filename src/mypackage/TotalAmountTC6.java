package mypackage;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;


public class TotalAmountTC6 extends CommonFunctions {
	String Total;
	public void totalamountmethod() throws BiffException, IOException, InterruptedException{
		int dollar;
		driver.findElement(By.name("search")).sendKeys("canon");
		driver.findElement(By.xpath(".//*[@id='search']/input")).sendKeys(Keys.ENTER);	
	    driver.findElement(By.xpath(".//*[@id='content']/div[6]/div/div[2]/div[1]/a/img")).click();
	    driver.findElement(By.name("quantity")).clear();
		File fl = new File("Quantity.xls");
			Workbook w= Workbook.getWorkbook(fl);
			Sheet s= w.getSheet("Sheet1");
			int Rows=s.getRows();
			int cloumns=s.getColumns();
			
			
			String inputdata[] []=new String[Rows][cloumns];
			for(int i=1;i<Rows;i++){
				for(int j=0;j<cloumns;j++){
					Cell c=s.getCell(j, i);
					inputdata[i][j]=c.getContents();
		 
				}
				 driver.findElement(By.name("quantity")).sendKeys(inputdata[i][0]);
				 }
			
			 driver.findElement(By.xpath(".//*[@id='button-cart']")).click();
			 Thread.sleep(1000);
			 //check point ribbon message
		String ribbonmsg=	 driver.findElement(By.xpath(".//*[@id='notification']/div")).getText();
		if(ribbonmsg.contains("Success: You have added")){
			
			System.out.println("item added succesfully -PASSED");
		}
		else{
			System.out.println("item not added succesfully -FAILED");	
		}
		Thread.sleep(1000);
		 driver.findElement(By.xpath(".//*[@id='notification']/div/a[2]")).click();
String Total= driver.findElement(By.xpath(".//*[@id='total']/tbody/tr[2]/td[2]")).getText();


int index=Total.lastIndexOf("$");
String totalans=Total.substring(index+1);


File file112 = new File("TotalOfTotal.txt");

try{
dollar = (int)(Float.parseFloat(totalans));


file112.createNewFile();
FileWriter writer111 = new FileWriter(file112); 
writer111.write( Total);
writer111.flush();
writer111.close();

if(dollar <200){
	
	
driver.findElement(By.xpath(".//*[@id='content']/div[5]/div[2]/a")).click();
this.totalamountmethod();
}
else{
driver.manage().window().maximize();
	Thread.sleep(1000);
	 this.logout();
	
}
}catch(Exception e){
	
	System.out.println("Error in converting Int");
	e.printStackTrace();
}


	}
	
	
	public static void main(String[] args) throws InterruptedException {
		try{
		TotalAmountTC6 objTotalAmountTC6=new TotalAmountTC6();
		objTotalAmountTC6.login();
		objTotalAmountTC6.totalamountmethod();
		
	}
		catch(Exception e){
			
		}
		}
	

}




