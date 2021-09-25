package runner;

import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.demo.pageobject.urbancollection;
import com.demo.pageobject.urbandining;
import com.demo.pageobject.urbangift;
import com.demo.pageobject.urbanhelp;
import com.demo.pageobject.urbankids;
import com.demo.pageobject.urbanproduct;
import com.demo.pageobject.urbansale;
import com.demo.pageobject.urbansearch;
import com.demo.pageobject.urbansignup;
import com.demo.pageobject.urbanstores;
import com.demo.pageobject.urbantrack;
import com.demo.reusablecomponents.ReusableMethods;
import com.demo.reusablecomponents.reusablecomponents;

import utils.excelutils;

public class comprehensive extends reusablecomponents {
	public static Logger Log=LogManager.getLogger(reusablecomponents.class.getName());

	@BeforeTest
	public void initialize() throws IOException {
		driver=initializeDriver();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		Log.info("loading the Url");
	}
	@Test(priority=0,dataProvider="test1data")
	public void login(String Username,String Password) throws Exception {
		Log.info("Signing up the page");
		Actions a=new Actions(driver);
		WebElement actels=driver.findElement(urbansignup.icon);
		a.moveToElement(actels).build().perform();
		ReusableMethods.click(urbansignup.signupicon, driver);
		Thread.sleep(15000);
		Log.info("Enter the Username and Password");
		ReusableMethods.sendKeys(urbansignup.username,Username, driver);
		Thread.sleep(15000);
		ReusableMethods.click(urbansignup.showpass, driver);
		ReusableMethods.sendKeys(urbansignup.password,Password,driver);
		ReusableMethods.click(urbansignup.signup, driver);		
		

	
	}
	@Test(priority=1)
	public void select() throws Exception {
		Log.info("Searching for Beds");
		ReusableMethods.sendKeys(urbansearch.search,"Beds", driver);
		Thread.sleep(500);
		ReusableMethods.click(urbansearch.icon, driver);
		Actions a=new Actions(driver);
		WebElement actels=driver.findElement(urbanproduct.product);
		a.moveToElement(actels).build().perform();
		Log.info("viewing the types of beds");
		ReusableMethods.click(urbanproduct.view, driver);
		
		
	}
	@Test(priority=2)
	public void Track() throws Exception {
		Log.info("Tracking the order");
		ReusableMethods.click(urbantrack.track, driver);
		ReusableMethods.sendKeys(urbantrack.id,"Aab14234", driver);
		ReusableMethods.sendKeys(urbantrack.phnum,"6374562393", driver);
		ReusableMethods.click(urbantrack.submit, driver);
		
		
	}
	@Test(priority=4)
	public void sale() throws Exception {	
		Actions a=new Actions(driver);
		Log.info("Entering into study chairs products");
		WebElement actels=driver.findElement(urbansale.sale);
		a.moveToElement(actels).build().perform();
		Thread.sleep(7000);
		ReusableMethods.click(urbansale.studychairs, driver);
		ReusableMethods.click(urbansale.check, driver);
		
	}
	@Test(priority=3)
	public void store() throws Exception {
		Log.info("Viewing the store");
		ReusableMethods.click(urbanstores.store, driver);
		ReusableMethods.click(urbanstores.pic, driver);
		
	}
	@Test(priority=5)
	public void help() throws Exception {
		Log.info("Seeking for help");
		ReusableMethods.click(urbanhelp.helps, driver);
		ReusableMethods.click(urbanhelp.question, driver);
		Log.info("Printing the ans for question");
		System.out.println("Answer:");
		System.out.println(driver.findElement(By.xpath("//*[@id=\"4205\"]/div[3]/p[1]")).getText());
		
		
	}
	@Test(priority=6)
	public void Dining() throws Exception{
		Log.info("Checking the Dining");
		Actions a=new Actions(driver);
		WebElement actels=driver.findElement(urbandining.dinner);
		a.moveToElement(actels).build().perform();
		Thread.sleep(5000);
		Log.info("View of 6 seater table");
		ReusableMethods.click(urbandining.tables, driver);
		ReusableMethods.click(urbandining.selecting, driver);
		
		
	}
	@Test(priority=7)
	public void Collection() throws Exception{
		Log.info("View of collection");
		Actions a=new Actions(driver);
		WebElement actels=driver.findElement(urbancollection.collect);
		Thread.sleep(15000);
		ReusableMethods.click(urbancollection.close, driver);
		a.moveToElement(actels).build().perform();
		Thread.sleep(20000);
		ReusableMethods.click(urbancollection.outdoor, driver);
		Log.info("Printing the price");
		System.out.println(driver.findElement(By.xpath("//*[@id=\"content\"]/div[4]/div/ul/li[1]/div/div[3]/a/div[2]/span")).getText());
		
		
		
	}
	@Test(priority=9)
	public void gift() throws Exception {
		Log.info("Entering gift card menu");
		ReusableMethods.click(urbangift.giftcard, driver);
		Log.info("Category selected");
		ReusableMethods.click(urbangift.catrgory, driver);
		ReusableMethods.click(urbangift.price, driver);
		ReusableMethods.click(urbangift.next, driver);
		
		
	}
	@Test(priority=8)
	public void kidroom() throws Exception{
		Log.info("Viewing the kids section");
		Actions a=new Actions(driver);
		WebElement actels=driver.findElement(urbankids.kid);
		a.moveToElement(actels).build().perform();
		Thread.sleep(20000);
		ReusableMethods.click(urbankids.kidchair, driver);
		Log.info("Pinting Emi price");
		System.out.println("Emi from:");
		System.out.println(driver.findElement(By.xpath("//*[@id=\"content\"]/div[4]/div/ul/li[2]/div/div[5]/a/div[3]/span")).getText());
		
	}
	@AfterTest
	public void teardown() {
		driver.close();
		
	}

	@DataProvider(name="test1data")
	public static Object[][] getData() throws IOException {
		Object data[][]=testdata("C:\\Users\\Kumar\\eclipse-workspace\\demo1\\resorces1\\asig.xlsx","Sheet1");
		return data;
	}
	public static Object[][] testdata(String excelpath, String sheetname) throws IOException {
		excelutils excel=new excelutils(excelpath,sheetname);
		int rowcount=excel.getRowCount();
		int colcount=excel.getColCount();
		
		Object data[][]=new Object[rowcount-1][colcount];
		
		for(int i=1; i<rowcount; i++)
        {
            for(int j=0; j<colcount; j++)
            {
                String cellData = excel.getCellDataString(i, j);
                data[i-1][j]=cellData;
                
                
            }
             
        }
		return data;
	}
	
	
}

