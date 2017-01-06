package mypackage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileReader;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;






public class GiftVoucherTC5 extends CommonFunctions{
	private Scanner input;
	public BufferedReader br1;
	
	public void giftvouchermethod() throws InterruptedException, IOException{
		driver.findElement(By.xpath(".//*[@id='footer']/div[3]/ul/li[2]/a")).click();
		//reading from txt file
		
		String sCurrentLine1;
		String  data1[]=new String[10];
		int j=0;
		FileReader f3=new FileReader("testing1.txt");
		br1 = new BufferedReader(f3);

		while ((sCurrentLine1 = br1.readLine()) != null) {
			
			

			 data1[j]=(String) sCurrentLine1;
			
		j++;

		
		}
		
		driver.findElement(By.xpath(".//*[@id='content']/form/table/tbody/tr[1]/td[2]/input")).sendKeys(data1[0]);
		driver.findElement(By.xpath(".//*[@id='content']/form/table/tbody/tr[2]/td[2]/input")).sendKeys(data1[1]);
		
		
		driver.findElement(By.id("voucher-7")).click();
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath(".//*[@id='content']/form/div/div/input[2]")).click();
		driver.findElement(By.xpath(".//*[@id='content']/div[2]/div/a")).click();
boolean close=driver.findElement(By.xpath(".//*[@id='content']/form/div/table/tbody/tr[1]/td[4]/a/img")).isEnabled();

if(close==true)	{
	try{
	while(close==true){
		
	driver.findElement(By.xpath(".//*[@id='content']/form/div/table/tbody/tr[1]/td[4]/a/img")).click();
                      }
	}
		catch(Exception e){
			
		}
	}
else{
driver.findElement(By.xpath(".//*[@id='content']/div[3]/div/a")).click();
}
driver.findElement(By.xpath(".//*[@id='footer']/div[2]/ul/li[1]/a")).click();
Thread.sleep(1000);
String name=driver.findElement(By.xpath(".//*[@id='content']/form/div[2]/input[1]")).getAttribute("value");

String email=driver.findElement(By.xpath(".//*[@id='content']/form/div[2]/input[2]")).getAttribute("value");

//check points for name and email
	if((name.equals("vaseem"))&&(email.equals("mail76@gmail.com"))){
		System.out.println("Name and Emails are correcly displyaing in contact Us- PASSED");
	}
	else{
		System.out.println("Name and Emails are  not correcly displyaing in contact Us - FAILED");
	}
	
	driver.findElement(By.name("enquiry")).sendKeys("This is to Change of Address/Phone number");
	input = new Scanner(System.in);
	System.out.println("please enter the captcha in  the box");
	String captch=input.nextLine();

	driver.findElement(By.name("captcha")).sendKeys(captch);
	driver.findElement(By.xpath(".//*[@id='content']/form/div[3]/div/input")).click();
String msg1=	driver.findElement(By.xpath(".//*[@id='content']/p")).getText();
if(msg1.equals("Your enquiry has been successfully sent to the store owner!")){
	System.out.println("message after continue in inquiry is succesful-passed");
}
else{
	System.out.println("message after continue in inquiry is  not succesful-Failed");
}

driver.findElement(By.xpath(".//*[@id='content']/div[2]/div/a")).click();
driver.findElement(By.xpath(".//*[@id='footer']/div[4]/ul/li[3]/a")).click();
driver.findElement(By.xpath(".//*[@id='content']/div[3]/div/a")).click();
//checkpoint of Edit your account
 boolean editlink=driver.findElement(By.xpath(".//*[@id='content']/div[2]/ul/li[1]/a")).isDisplayed();
if(editlink==true){
	System.out.println("Edit your account link is displyed -PASSED");
	}
else{
	System.out.println("Edit your account link is  not displyed -FAILED");
}

driver.findElement(By.xpath(".//*[@id='content']/div[2]/ul/li[1]/a")).click();
String email1=driver.findElement(By.name("email")).getAttribute("value");

String fname=driver.findElement(By.name("firstname")).getAttribute("value");

String lname=driver.findElement(By.name("lastname")).getAttribute("value");


if((email1.equals("mail76@gmail.com"))&&(fname.equals("vaseem"))&&(lname.equals("akram"))){
	System.out.println("personal information is displaying correctly in edit your account- PASSED");
}
else{
	System.out.println("personal information is  not displaying correctly in edit your account -FAILED");
}

//Reading telephone number from flat file
String sCurrentLine2;
String  data2[]=new String[10];
int k=0;
FileReader f4=new FileReader("testing2.txt");
br1 = new BufferedReader(f4);

while ((sCurrentLine2 = br1.readLine()) != null) {
	
	

	 data2[k]=(String) sCurrentLine2;
	
k++;


}
driver.findElement(By.name("telephone")).clear();
driver.findElement(By.name("telephone")).sendKeys(data2[0]);
String phoneNo =driver.findElement(By.name("telephone")).getAttribute("value");
if(phoneNo.equals(data2[0])){
	System.out.println("updated phone number is displaying correctly-PASSED");
	
	}
else{
	System.out.println("updeated phone number is not  displaying correctly-FAILED");
}

driver.findElement(By.xpath(".//*[@id='content']/form/div[2]/div[2]/input")).click();
boolean returnlink=driver.findElement(By.xpath(".//*[@id='content']/div[3]/ul/li[4]/a")).isDisplayed();
if (returnlink==true){
	System.out.println("view your return request link is displayed-PASSED");
}
else{
	System.out.println("view your return request link is not  displayed-FAILED");
}

driver.findElement(By.xpath(".//*[@id='content']/div[3]/ul/li[4]/a")).click();
Thread.sleep(1000);
driver.findElement(By.xpath(".//*[@id='content']/div[2]/div[3]/div[3]/a/img")).click();
boolean returnid=driver.findElement(By.xpath(".//*[@id='content']/table[2]/tbody/tr/td[1]")).isDisplayed();
if (returnid==true){
	System.out.println("earlier return product is displayed-PASSED");
}
else{
	System.out.println("earlier return product is not  displayed-FAILED");	
}



String orderid= driver.findElement(By.xpath(".//*[@id='content']/table[1]/tbody/tr/td[2]")).getText();
//storing orderid to flat file
File fileo = new File("orderid.txt");
fileo.createNewFile();
FileWriter writer = new FileWriter(fileo); 
writer.write(orderid);
writer.flush();
writer.close();
Thread.sleep(1000);                           
driver.findElement(By.xpath(".//*[@id='content']/div[2]/div/a")).click();
Thread.sleep(1000); 
driver.findElement(By.xpath(".//*[@id='content']/div[13]/div/a")).click();


boolean modifyAddlink=driver.findElement(By.xpath(".//*[@id='content']/div[2]/ul/li[3]/a")).isDisplayed();
if ( modifyAddlink==true){
	System.out.println("modify  your Address link is displayed-PASSED");
}
else{
	System.out.println("modify your Address  link is not  displayed-FAILED");
}

driver.findElement(By.xpath(".//*[@id='content']/div[2]/ul/li[3]/a")).click();

String sCurrentLine;
String  data[]=new String[20];
int i=0;
FileReader f2=new FileReader("testing.txt");
br1 = new BufferedReader(f2);

while ((sCurrentLine = br1.readLine()) != null) {
	
	

	 data[i]=(String) sCurrentLine;
	
i++;

}




String address=driver.findElement(By.xpath(".//*[@id='content']/div[2]/table/tbody/tr/td[1]")).getText();


if((address.contains(data[0]))&& (address.contains(data[0]))){
	System.out.println("Address is verified- PASSED");
}
else{
	System.out.println("Address is not verified- FAILED");
}
  
  
driver.findElement(By.xpath(".//*[@id='content']/div[2]/table/tbody/tr/td[2]/a[1]")).click();
//filling data from flat file
driver.findElement(By.name("firstname")).clear();
driver.findElement(By.name("firstname")).sendKeys(data[0]);
driver.findElement(By.name("lastname")).clear();
driver.findElement(By.name("lastname")).sendKeys(data[1]);
driver.findElement(By.name("address_1")).clear();
driver.findElement(By.name("address_1")).sendKeys(data[2]);
driver.findElement(By.name("city")).clear();
driver.findElement(By.name("city")).sendKeys(data[3]);
driver.findElement(By.name("postcode")).clear();
driver.findElement(By.name("postcode")).sendKeys(data[4]);

Select dropdowna= new Select(driver.findElement(By.name("country_id")));
dropdowna.selectByVisibleText(data[5]);


Select  dropdownb= new Select(driver.findElement(By.xpath(".//*[@id='content']/form/div[1]/table/tbody/tr[10]/td[2]/select")));

dropdownb.selectByVisibleText(data[6]);

driver.findElement(By.xpath(".//*[@id='content']/form/div[2]/div[2]/input")).click();
String address1=driver.findElement(By.xpath(".//*[@id='content']/div[2]/table/tbody/tr/td[1]")).getText();



if((address1.contains(data[5]))&& (address1.contains(data[6]))){
	JOptionPane.showMessageDialog( null, "" + "success", address1, JOptionPane.INFORMATION_MESSAGE);
}
else{
	System.out.println("Address is not verified- FAILED");
}

driver.manage().window().maximize();
Thread.sleep(1000);


	}	
	
public static void main(String[] args) throws InterruptedException  {
		try{
		GiftVoucherTC5 objGiftVoucherTC5 =new GiftVoucherTC5();
		objGiftVoucherTC5.login();
		objGiftVoucherTC5.giftvouchermethod();
		objGiftVoucherTC5.logout();
		objGiftVoucherTC5.close();
	}
		catch(Exception e){
			System.out.println(e);
		}

}
	}
