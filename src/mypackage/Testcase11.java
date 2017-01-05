package mypackage;



import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;







import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
public class Testcase11 extends CommonFunctions {
	public static WebDriver driver;
	private static Scanner input;
	private static Scanner input1;
public  void  registration() throws BiffException, IOException, InterruptedException {
		File fl = new File("RegistrationDetails.xls");
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
			
			
			System.setProperty("Webdriver.chrome.driver", "chromedriver.exe");	
		 driver=new ChromeDriver();
		
		driver.get("http://10.207.182.108:81/opencart/");

			driver.findElement(By.xpath(".//*[@id='welcome']/a[2]")).click();
			
			
			driver.findElement(By.name("firstname")).sendKeys(inputdata[i][0]);
			driver.findElement(By.name("lastname")).sendKeys(inputdata[i][1]);
			driver.findElement(By.name("email")).sendKeys(inputdata[i][2]);
			driver.findElement(By.name("telephone")).sendKeys(inputdata[i][3]);
			driver.findElement(By.name("address_1")).sendKeys(inputdata[i][4]);
			driver.findElement(By.name("city")).sendKeys(inputdata[i][5]);
			driver.findElement(By.name("postcode")).sendKeys(inputdata[i][6]);
			Select dropdown= new Select(driver.findElement(By.name("country_id")));
			dropdown.selectByVisibleText(inputdata[i][7]);
			driver.manage().window().maximize();
			Thread.sleep(1000);
			Select  dropdown1= new Select(driver.findElement(By.xpath(".//*[@id='content']/form/div[2]/table/tbody/tr[10]/td[2]/select")));
			Thread.sleep(1000);
			dropdown1.selectByVisibleText(inputdata[i][8]);
			driver.findElement(By.name("password")).sendKeys(inputdata[i][9]);
			driver.findElement(By.name("confirm")).sendKeys(inputdata[i][10]);
			driver.findElement(By.name("agree")).click();
			driver.findElement(By.xpath(".//*[@id='content']/form/div[5]/div/input[2]")).click();
			String message =driver.findElement(By.xpath(".//*[@id='content']/h1")).getText();
			if(message.equals("Your Account Has Been Created!")){
				System.out.println("account has succesfully created -PASSED");
			}
			else {
				System.out.println("account has not created -FAILED");
			}
			
	
		driver.findElement(By.linkText("contact us")).click();		
String name=driver.findElement(By.xpath(".//*[@id='content']/form/div[2]/input[1]")).getAttribute("value");
	//System.out.println(name);	
String email=driver.findElement(By.xpath(".//*[@id='content']/form/div[2]/input[2]")).getAttribute("value");
	//System.out.println(email);		
	if((name.equals(inputdata[i][0]))&&(email.equals(inputdata[i][2]))){
		System.out.println("Name and emails are correct- PASSED");
		
	}
	else{
		System.out.println("Name and emails are  not correct- FAILED");
	}
	
}	
		
	driver.findElement(By.name("enquiry")).sendKeys("This is to Change of Address/Phone number");	
input = new Scanner(System.in);
	System.out.println("please enter the captcha in  the box");
	String captch=input.nextLine();
driver.findElement(By.name("captcha")).sendKeys(captch);	
		
driver.findElement(By.xpath(".//*[@id='content']/form/div[3]/div/input")).click();
String sucessmsg=driver.findElement(By.xpath(".//*[@id='content']/p")).getText();
if (sucessmsg.contains("Your enquiry has been successfully sent to the store owner!"))	{
	System.out.println("sucess msg is displaying correctly- PASSED");
}
else{
	System.out.println("sucess msg is  not displaying correctly- FAILED");
}
	
driver.findElement(By.xpath(".//*[@id='content']/div[2]/div/a")).click();
driver.findElement(By.xpath(".//*[@id='slideshow0']/a")).click();
driver.findElement(By.xpath(".//*[@id='tabs']/a[2]")).click();

File f2 = new File("ReviewProduct.xls");
Workbook w1= Workbook.getWorkbook(f2);
Sheet s1= w1.getSheet("Sheet1");
int Rows1=s1.getRows();
int cloumns1=s1.getColumns();


String inputdata1[] []=new String[Rows1][cloumns1];
for(int i1=1;i1<Rows1;i1++){
	for(int j1=0;j1<cloumns1;j1++){
		Cell c1=s1.getCell(j1, i1);
		inputdata1[i1][j1]=c1.getContents();
	}
	
driver.findElement(By.name("name")).sendKeys(inputdata1[i1] [0]);
driver.findElement(By.name("text")).sendKeys(inputdata1[i1] [1]);
int rating=Integer.parseInt(inputdata1[i1] [2]);
driver.findElement(By.xpath(".//*[@id='tab-review']/input["+(rating+1)+"]")).click();


input1 = new Scanner(System.in);
System.out.println("please enter the captcha in  the box");
String captch2=input1.nextLine();
driver.findElement(By.name("captcha")).sendKeys(captch2);	
driver.findElement(By.xpath(".//*[@id='button-review']")).click();	
Thread.sleep(1000);
String eerormsg=driver.findElement(By.xpath(".//*[@id='tab-review']/div[2]")).getText();
if(eerormsg.contains("Warning: Review Text must be between 25 and 1000 characters!")){
	System.out.println("Warning: Review Text must be between 25 and 1000 characters!-PASSED");
	driver.findElement(By.name("text")).clear();
	driver.findElement(By.name("text")).sendKeys(inputdata1[i1] [3]);
	driver.findElement(By.xpath(".//*[@id='button-review']")).click();
	Thread.sleep(1000);
	String succesmsg=driver.findElement(By.xpath(".//*[@id='tab-review']/div[2]")).getText();
	if(succesmsg.contains("Thank you for your review. It has been submitted to the webmaster for approval.")){
		System.out.println("review sucessfully submitted-PASSED");
	}
	else
	{
		System.out.println("review sucessfully not submitted-FAILED");
	}
}
else{
	System.out.println("Error msg not showing -FAILED");
}
}
driver.findElement(By.xpath(".//*[@id='content']/div[2]/div[2]/div[3]/div/span[2]/a[1]")).click();
Thread.sleep(1000);
driver.findElement(By.xpath(".//*[@id='notification']/div/img")).click();
String itemname=driver.findElement(By.xpath(".//*[@id='content']/h1")).getText();
String wish=driver.findElement(By.xpath(".//*[@id='wishlist-total']")).getText();
driver.findElement(By.xpath(".//*[@id='wishlist-total']")).click();
String itemname2=driver.findElement(By.xpath(".//*[@id='wishlist-row49']/tr/td[2]/a")).getText();
//checkpoint should be added
List<WebElement> ele = driver.findElements(By.xpath(".//*[@id='content']/div[2]/table/thead/tr"));



String a=wish;

int index = a.lastIndexOf("(");
int index1 = a.lastIndexOf(")");
String ans=a.substring(index+1, index1);
//System.out.println(itemname);
//System.out.println(itemname2);
//System.out.println(ans);
//System.out.println(ele.size());
int y=ele.size();
String size1=String.valueOf(y);
//System.out.println(size1);
if((itemname.equals(itemname2))&&(size1.equals(ans))){
	System.out.println("check point to validate product no and no. of records-PASSED");
}
else
{
	System.out.println("check point to validate product no and no. of records-FAILED");	
}







driver.findElement(By.xpath(".//*[@id='currency']/a[2]")).click();
String poundunitprice=driver.findElement(By.xpath(".//*[@id='wishlist-row49']/tr/td[5]/div")).getText();

File file = new File("pondunitprice.txt");
file.createNewFile();
FileWriter writer = new FileWriter(file); 
writer.write(poundunitprice);
//writer.flush();
writer.close();


driver.findElement(By.xpath(".//*[@id='currency']/a[1]")).click();
String eurounitprice=driver.findElement(By.xpath(".//*[@id='wishlist-row49']/tr/td[5]/div")).getText();

File file1 = new File("eurounitprice.txt");
file.createNewFile();
FileWriter writer1 = new FileWriter(file1); 
writer1.write(eurounitprice);
//writer1.flush();
writer1.close();

driver.findElement(By.xpath(".//*[@id='currency']/a[3]")).click();
String Dollarunitprice=driver.findElement(By.xpath(".//*[@id='wishlist-row49']/tr/td[5]/div")).getText();

File file2 = new File("dollarunitprice.txt");
file.createNewFile();
FileWriter writer2 = new FileWriter(file2); 
writer2.write( Dollarunitprice);
//writer2.flush();
writer2.close();

driver.findElement(By.xpath(".//*[@id='wishlist-row49']/tr/td[6]/img")).click();
Thread.sleep(1000);
driver.findElement(By.xpath(".//*[@id='notification']/div/img")).click();

driver.findElement(By.xpath(".//*[@id='wishlist-row49']/tr/td[6]/a/img")).click();

driver.findElement(By.xpath(".//*[@id='content']/div[3]/div/a")).click();
Thread.sleep(1000);
driver.manage().window().maximize();
Thread.sleep(1000);
}




public  static void main(String args[]){
	try{
	Testcase11 objTestcase11=new Testcase11();
	objTestcase11.registration();
	 driver.findElement(By.xpath(".//*[@id='welcome']/a[2]")).click();

		String logoutmsg= driver.findElement(By.xpath(".//*[@id='content']/h1")).getText();
		boolean logout=logoutmsg.equals("Account Logout");
	boolean	 loginlink= driver.findElement(By.xpath(".//*[@id='welcome']/a[1]")).isEnabled();
	if(logout&&loginlink==true){
		System.out.println("Logout succesful-PASSED");
	}

	
	}
	catch(Exception e){
		
	}
	
}
}




