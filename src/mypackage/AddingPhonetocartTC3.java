package mypackage;



import java.io.File;
import java.io.FileWriter;
import java.io.IOException;




import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class AddingPhonetocartTC3 extends CommonFunctions{
	//private Scanner randomcouponNO;












	public void addingphone() throws InterruptedException, IOException{
	try{
	driver.findElement(By.xpath(".//*[@id='header']/div[5]/a[1]")).click();
	driver.findElement(By.xpath(".//*[@id='slideshow0']/a")).click();
	driver.findElement(By.xpath(".//*[@id='image']")).click();
	Thread.sleep(1000);
	int k=0;
	while(k<6){
	driver.findElement(By.xpath(".//*[@id='cboxNext']")).click();
	Thread.sleep(1000);
	k++;
	} 
	driver.findElement(By.id("cboxClose")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath(".//*[@id='button-cart']")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath(".//*[@id='notification']/div/a[2]")).click();
	driver.findElement(By.xpath(".//*[@id='shipping_estimate']")).click();
	driver.findElement(By.id("button-quote")).click();
	Thread.sleep(1000);
	driver.findElement(By.id("flat.flat")).click();
	driver.findElement(By.id("button-shipping")).click();
String Total=	driver.findElement(By.xpath(".//*[@id='total']/tbody/tr[3]/td[2]")).getText();
File file = new File("TotalAmount.txt");
file.createNewFile();
FileWriter writer = new FileWriter(file); 
writer.write(Total);
writer.flush();
writer.close();
driver.findElement(By.id("use_coupon")).click();

driver.findElement(By.xpath(".//*[@id='coupon']/form/input[1]")).sendKeys("12345");
driver.findElement(By.xpath(".//*[@id='coupon']/form/input[3]")).click();
String warning=driver.findElement(By.className("warning")).getText();
 File file1 =new File("Warningmsg.txt");	
 file.createNewFile();
 FileWriter writer1 = new FileWriter(file1); 
 writer1.write(warning);
 writer1.flush();
 writer1.close();	
 driver.findElement(By.xpath(".//*[@id='content']/div[5]/div[1]/a")).click();
	Thread.sleep(1000);
 driver.findElement(By.id("payment-address-new")).click();
 
 
 
 File fl = new File("BillingDetails.xls");
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
 
			
 driver.findElement(By.name("firstname")).sendKeys(inputdata[i][0]);
	
	driver.findElement(By.xpath(".//*[@id='payment-new']/table/tbody/tr[2]/td[2]/input")).sendKeys(inputdata[i][1]);
	driver.findElement(By.name("address_1")).sendKeys(inputdata[i][2]);
	driver.findElement(By.name("city")).sendKeys(inputdata[i][3]);
	driver.findElement(By.name("postcode")).sendKeys(inputdata[i][4]);
	Select dropdown= new Select(driver.findElement(By.name("country_id")));
	dropdown.selectByVisibleText(inputdata[i][5]);
	Select  dropdown1= new Select(driver.findElement(By.xpath(".//*[@id='payment-new']/table/tbody/tr[10]/td[2]/select")));
	Thread.sleep(1000);
	dropdown1.selectByVisibleText(inputdata[i][6]);
	 driver.findElement(By.xpath(".//*[@id='button-payment-address']")).click();
	 Thread.sleep(1000);
	 driver.findElement(By.xpath(".//*[@id='shipping-existing']/select/option[2]")).click();
	 driver.findElement(By.xpath(".//*[@id='button-shipping-address']")).click();
	 Thread.sleep(1000);
	 driver.findElement(By.name("comment")).sendKeys("product is corretly deliver to same address");
	
	 driver.findElement(By.xpath(".//*[@id='button-shipping-method']")).click();
	 Thread.sleep(1000);
	 driver.findElement(By.xpath(".//*[@id='payment-method']/div[2]/div/div/input[1]")).click();
	 driver.findElement(By.xpath(".//*[@id='payment-method']/div[2]/div/div/a/b")).click();
	 Thread.sleep(1000);
	String terms= driver.findElement(By.xpath(".//*[@id='cboxLoadedContent']/h1")).getText();

    
      File file11 = new File("characterinTerms.txt");
      file11.createNewFile();
      FileWriter writer11 = new FileWriter(file11); 
      writer11.write("Total charters in terms and conditions is    "   +terms.length());
      writer11.flush();
      writer11.close();
      driver.findElement(By.xpath(".//*[@id='cboxClose']")).click();
      Thread.sleep(1000);
      driver.findElement(By.xpath(".//*[@id='button-payment-method']")).click();
      Thread.sleep(1000);
      driver.findElement(By.xpath(".//*[@id='payment-address']/div[1]/a")).click();
      Thread.sleep(1000);
      driver.findElement(By.xpath(".//*[@id='payment-existing']/select/option[3]")).click();
      Thread.sleep(1000);
     driver.findElement(By.xpath(".//*[@id='button-payment-address']")).click();
     Thread.sleep(1000);         
      driver.findElement(By.xpath(".//*[@id='button-shipping-address']")).click();
      Thread.sleep(1000);
      driver.findElement(By.xpath(".//*[@id='button-shipping-method']")).click();
      Thread.sleep(1000);
      driver.findElement(By.xpath(".//*[@id='payment-method']/div[2]/div/div/input[1]")).click();
      Thread.sleep(1000);
      driver.findElement(By.xpath(".//*[@id='button-payment-method']")).click();
      Thread.sleep(1000);
      driver.findElement(By.xpath(".//*[@id='button-confirm']")).click();

      Thread.sleep(1000);
      
      driver.manage().window().maximize();
    
       Thread.sleep(1000);
     
     }
	
 
 
 
 
	
	}
	catch(Exception e){
		System.out.println("Exception occured");
		
	}
	}
	
public static void main(String[] args)    {
try{
		AddingPhonetocartTC3 objAddingPhonetocartTC3=new AddingPhonetocartTC3();
		objAddingPhonetocartTC3.login();
		objAddingPhonetocartTC3.addingphone();
		objAddingPhonetocartTC3.logout();
		
	}
catch(Exception ex){
	
}
}
}
