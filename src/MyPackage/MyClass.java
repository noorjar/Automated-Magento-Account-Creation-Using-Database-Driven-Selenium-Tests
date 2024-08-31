package MyPackage;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyClass extends ParametersClass{

	@BeforeTest
	public void mysetup() throws SQLException {
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels","root","noor1234");
		generalSetUp() ;
	}

	@Test(priority = 1)
	public void GetRandomFirstLastName () throws SQLException {
		stmt =con.createStatement();
		rs =stmt.executeQuery("SELECT customerNumber FROM customers");
         while (rs.next()) {
             int customerNumber = rs.getInt("customerNumber");
             customerNumbersList.add(customerNumber);
         }
         int randomcustomerNumber= customerNumbersList.get(rand.nextInt(customerNumbersList.size()));
         System.out.println(randomcustomerNumber);
         
 	rs = stmt.executeQuery("SELECT contactFirstName, contactLastName FROM customers WHERE customerNumber = "+randomcustomerNumber);
 	  while (rs.next()) {
           FirstName = rs.getString("contactFirstName");
           LastName = rs.getString("contactLastName");
          System.out.println("First Name :"+FirstName);
          System.out.println("Last Name :"+LastName);
      }
 
	}

	@Test (priority = 2)
	public void CreateanAccount() {
		WebElement ClickonCreateAccount =driver.findElement(By.linkText("Create an Account"));
		ClickonCreateAccount.click();
		WebElement FirstNameTab =driver.findElement(By.id("firstname"));
		WebElement LastNameTab =driver.findElement(By.id("lastname"));
		WebElement EmailTab =driver.findElement(By.id("email_address"));
		WebElement PasswordTab =driver.findElement(By.id("password"));
		WebElement PasswordTab2 =driver.findElement(By.id("password-confirmation"));
		WebElement CreateAccountButton = driver.findElement(By.xpath("//button[@title='Create an Account']"));
		String email = FirstName + LastName + RandomNumberforEmail + EmailDomain;
		FirstNameTab.sendKeys(FirstName);
		LastNameTab.sendKeys(LastName);
		EmailTab.sendKeys(email);
		PasswordTab.sendKeys(Password);
		PasswordTab2.sendKeys(Password);
		CreateAccountButton.click();
	}

	
	
	
	
	
	
	
	
}
