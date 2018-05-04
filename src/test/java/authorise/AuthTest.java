
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.codeborne.selenide.Configuration;



public class AuthTest {
	
    protected WebDriver driver;
	 
    protected AuthFunc nfunc;
    
    protected String[] credetials;
    
    protected String server;
    
    protected String base_url;
    
    protected String log1;
    
    protected String pass1;
    
    protected String cmp_name_search_key;
    
    protected String cmp_search_string;
    
    protected String doc_num;
    
    @BeforeClass
    @Parameters("browser")
    
    public void setup(String browser){
    	nfunc = new AuthFunc(driver);
    	
    	credetials =  nfunc.Get_Data_From_File("src/main/resources/credet.txt");
    	server = System.getProperty("server");
    	
    	 log1 = credetials[1]; pass1 = credetials[2]; cmp_name_search_key = credetials[3];
    	
    	base_url = "https://courier-"+server+".esphere.ru/";
    	 Configuration.browser = "chrome";
    //	 System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
    	 
    	 System.setProperty("selenide.browser", "chrome");
    	 
        open(base_url);

    }
    
    @Test 
	 public void LoginCourier(){
   	
         $("#IDToken1").sendKeys(log1);
         $("#IDToken2").sendKeys(pass1);
         $("[ng-click=\"doLogin()\"]").click();
     }
    
}