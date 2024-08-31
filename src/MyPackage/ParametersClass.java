package MyPackage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ParametersClass {
	Random rand = new Random();
	WebDriver driver = new ChromeDriver();
	Connection con;
	Statement stmt ;
	ResultSet rs;
	List<Integer> customerNumbersList = new ArrayList<>();
	String FirstName = null;
	String LastName = null;
	int RandomNumberforEmail = rand.nextInt(7864);
	String ArrayforEmailDomain []= {"@gmail.com","@yahoo.com","@outlook.com"}; 
	String EmailDomain  = ArrayforEmailDomain[rand.nextInt(ArrayforEmailDomain.length)];
	
	int RandomforPassword =rand.nextInt(250);
	String Password =LastName+FirstName+String.valueOf(RandomforPassword)+"@";

	
	public void generalSetUp() {
		driver.manage().window().maximize();
		driver.get("https://magento.softwaretestingboard.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}
}
