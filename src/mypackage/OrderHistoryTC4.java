package mypackage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

	import org.openqa.selenium.By;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

	public class OrderHistoryTC4 extends CommonFunctions {
		public int i=0;
		private Scanner scan;
		
		public void orderhistory() throws InterruptedException, IOException{
			driver.findElement(By.xpath(".//*[@id='header']/div[5]/a[1]")).click();
	driver.findElement(By.xpath(".//*[@id='content']/div[2]/div[2]/div/div[1]/div[1]/a/img")).click();

	try{
	boolean c =		driver.findElement(By.partialLinkText("Related Products")).isDisplayed();	
	System.out.println(c);		
	}
	catch(Exception e){
		i++;
		System.out.println("Warning:Related products tab not found!");
	}


	driver.manage().window().maximize();
	driver.navigate().back();
	driver.findElement(By.xpath(".//*[@id='content']/div[2]/div[2]/div/div[3]/div[1]/a/img")).click();		
	try{
	boolean d =		driver.findElement(By.partialLinkText("Related Products")).isDisplayed();	
	System.out.println(d);		
	}
	catch(Exception e){
		i++;
		System.out.println("Warning:Related products tab not found!");
	}

	driver.navigate().back();
	driver.findElement(By.xpath(".//*[@id='content']/div[2]/div[2]/div/div[4]/div[1]/a/img")).click();		
	try{
	boolean j =		driver.findElement(By.partialLinkText("Related Products")).isDisplayed();	
	System.out.println(j);		
	}
	catch(Exception e){
		i++;
		System.out.println("Warning:Related products tab not found!");
	}


	driver.navigate().back();
	driver.findElement(By.xpath(".//*[@id='content']/div[2]/div[2]/div/div[5]/div[1]/a/img")).click();		
	try{
	boolean f =		driver.findElement(By.partialLinkText("Related Products")).isDisplayed();	
	System.out.println(f);		
	}
	catch(Exception e){
		i++;
		System.out.println("Warning:Related products tab not found!");
	}

	driver.navigate().back();
	driver.findElement(By.xpath(".//*[@id='content']/div[2]/div[2]/div/div[6]/div[1]/a/img")).click();		
	try{
	boolean h =		driver.findElement(By.partialLinkText("Related Products")).isDisplayed();	
	System.out.println(h);		
	}
	catch(Exception e){
		i++;
		System.out.println("Warning:Related products tab not found!");
	}



	driver.navigate().back();
	driver.findElement(By.xpath(".//*[@id='content']/div[2]/div[2]/div/div[2]/div[1]/a/img")).click();
	try{
	boolean b=		driver.findElement(By.partialLinkText("Related Products")).isDisplayed();
	System.out.println(b);
		}
		catch(Exception e){
			i++;
			System.out.println("Warning:Related products tab not found!");
		}

	System.out.println("number of items not having related tab count is  "+i);
driver.findElement(By.xpath(".//*[@id='button-cart']")).click();
driver.findElement(By.xpath(".//*[@id='header']/div[5]/a[4]")).click();
driver.findElement(By.xpath(".//*[@id='content']/form/div/table/tbody/tr/td[4]/input[1]")).clear();
String shoppingProductName=driver.findElement(By.xpath(".//*[@id='content']/form/div/table/tbody/tr/td[2]/a")).getText();
	//System.out.println( shoppingProductName);
	 

driver.findElement(By.xpath(".//*[@id='content']/form/div/table/tbody/tr/td[4]/input[1]")).sendKeys("2");

driver.findElement(By.xpath(".//*[@id='content']/form/div/table/tbody/tr/td[4]/input[2]")).click();
Thread.sleep(1000); 
driver.findElement(By.xpath(".//*[@id='content']/div[5]/div[1]/a")).click();
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
	 String productNameOrder=driver.findElement(By.xpath(".//*[@id='confirm']/div[2]/div[1]/table/tbody/tr/td[1]/a")).getText();
	 //System.out.println(productNameOrder);
	 String ProductModelOrder=driver.findElement(By.xpath(".//*[@id='confirm']/div[2]/div[1]/table/tbody/tr/td[2]")).getText();
	 //System.out.println(ProductModelOrder);
	 String ProductModeQuantityrOrder=driver.findElement(By.xpath(".//*[@id='confirm']/div[2]/div[1]/table/tbody/tr/td[3]")).getText();
	// System.out.println(ProductModeQuantityrOrder);
	 //writing to excel sheet.
	 String arr[]=new String[3];
	 arr[0]=productNameOrder;
	 arr[1]=shoppingProductName;
	 
	 if(arr[0].equalsIgnoreCase(arr[1])){
		 arr[2]="True";
	 }else{
		 arr[2]="False";
	 }
	 
	 File file1 = new File("PRODUCTNAME.xls");
	 WritableWorkbook wb = Workbook.createWorkbook(file1);
	 WritableSheet ws = wb.createSheet("sheet1", 1);
	 int row = arr.length;
	 try{
	
	 for(int i=0;i<row;i++){
		 
		 Label lb = new Label(i,0,arr[i]);
		 ws.addCell(lb);
		 
	 }
	 wb.write();
	 wb.close();
	 }catch(Exception e){
		 e.printStackTrace();
	 }

	 Thread.sleep(1000);
	 driver.findElement(By.xpath(".//*[@id='button-confirm']")).click();
	 Thread.sleep(2000);
	 driver.findElement(By.xpath(".//*[@id='footer']/div[4]/ul/li[2]/a")).click();
	 
	 driver.findElement(By.xpath(".//*[@id='content']/div[2]/div[3]/div[3]/a[1]/img")).click();
	 String ProductNameHistory=driver.findElement(By.xpath(".//*[@id='content']/table[3]/tbody/tr/td[1]")).getText();
	 //System.out.println(ProductNameHistory);
	 String ProductModelHistory=driver.findElement(By.xpath(".//*[@id='content']/table[3]/tbody/tr/td[2]")).getText();
	 //System.out.println(ProductModelHistory);
	 String ProductQuantityHistory=driver.findElement(By.xpath(".//*[@id='content']/table[3]/tbody/tr/td[3]")).getText();
	 //System.out.println(ProductQuantityHistory);
	 
	 if((productNameOrder.equals(ProductNameHistory))&&(ProductModelHistory.equals(ProductModelOrder))&&(ProductQuantityHistory.equals(ProductModeQuantityrOrder)))
	 {
	 System.out.println("Previous order is displayed in history result view - Passed");
	 }
	 
	 else{
		 driver.findElement(By.xpath(".//*[@id='welcome']/a[2]")).click();

			String logoutmsg= driver.findElement(By.xpath(".//*[@id='content']/h1")).getText();
			boolean logout=logoutmsg.equals("Account Logout");
		boolean	 loginlink= driver.findElement(By.xpath(".//*[@id='welcome']/a[1]")).isEnabled();
		if(logout&&loginlink==true){
			System.out.println("Logout succesful-PASSED"); 
		  }
	 }
	 
	 
	 //entering details in return order from history
	 driver.findElement(By.xpath(".//*[@id='footer']/div[2]/ul/li[2]/a")).click();
	 driver.findElement(By.xpath(".//*[@id='content']/form/div[1]/div[2]/input[1]")).sendKeys("25647");
	 driver.findElement(By.xpath(".//*[@id='return-product']/div/div[1]/div[1]/input")).sendKeys("iphone1");
	 driver.findElement(By.xpath(".//*[@id='return-product']/div/div[1]/div[2]/input")).sendKeys("product123");
	 driver.findElement(By.xpath(".//*[@id='return-reason-id4']")).click();
	 scan = new Scanner(System.in);
	 System.out.println("Enter the captcha in return");
	 String  captcha =scan.nextLine();
	 
	 driver.findElement(By.xpath(".//*[@id='return-product']/div/div[2]/div[3]/input")).sendKeys(captcha);
	 driver.findElement(By.xpath(".//*[@id='content']/form/div[3]/div[2]/input")).click();
	 driver.findElement(By.xpath(".//*[@id='content']/div[2]/div/a")).click();
	 
	 
	 
	 }
		
public static void main(String[] args) throws InterruptedException{
			try{
			OrderHistoryTC4 objOrderHistoryTC4= new OrderHistoryTC4();
			objOrderHistoryTC4.login();
			objOrderHistoryTC4.orderhistory();
			objOrderHistoryTC4.logout();
			}catch(Exception e){
				e.printStackTrace();
			}
		}

	}



