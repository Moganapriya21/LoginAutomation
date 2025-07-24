package Login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Check_login {

	WebDriver d ;
	@BeforeMethod
	public void method(){
	System.setProperty("WebDriver edge.EdgeDriver", "D:\\selenium");
	 d = new EdgeDriver();
	d.get("https://practicetestautomation.com/practice-test-login/");
	}
	@DataProvider (name="provider")
	Object[][] dataset()
	{
		Object data[][]= {
				{"student","Password123"},
				{"Student","Password123"},
				{"student","password123"},
				{"Student","password123"},
		};
		return data;
	}
	
	
	@Test(dataProvider="provider")
	public void login(String user,String pass) {
	d.findElement(By.name("username")).sendKeys(user);
	d.findElement(By.name("password")).sendKeys(pass);
	d.findElement(By.className("btn")).click();
	String url=d.getCurrentUrl();
	if(url.equals("https://practicetestautomation.com/logged-in-successfully/")) {
	System.out.println("successfully logged-in");
	}
	else {
		System.out.println("Not logged-in");
	}
}
	@AfterMethod
	public void after() {
		d.close();
		
	}
	
}

