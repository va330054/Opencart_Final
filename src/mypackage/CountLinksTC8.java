package mypackage;
import java.util.List;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CountLinksTC8 extends CommonFunctions {
	
	public void Count() {
		
		List<WebElement> ls = driver.findElements(By.tagName("a"));
		System.out.println(ls.size());
		JOptionPane.showMessageDialog(null, ls.size(), "InfoBox: " + "Number_of_Links", JOptionPane.INFORMATION_MESSAGE);
    }	

		
	

	public static void main(String[] args) throws InterruptedException  {
		
		CountLinksTC8 obj =new CountLinksTC8();
		obj.login();
		obj.Count();
		obj.logout();
	}
	

}


