import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.List;
import java.util.NoSuchElementException;

import com.codeborne.selenide.Configuration;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;


/**
 * Created by carapooh on 17.04.2017.
 */
public class NewDocFunc {

    private final WebDriver driver;
    private final String url = "https://courier-test.esphere.ru/";
    private final long timeout = 20L;

    public NewDocFunc(WebDriver driver){
        this.driver = driver;
    }

    public String getURL(){
        return url;
    }

    public long getTimeout() {
        return timeout;
    }
    

//	public static 
    
    

 
    

  


}
