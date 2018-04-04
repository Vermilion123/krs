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
    


    
    
    public WebElement getTextField(){
//	return driver.findElement(By.xpath("//input[@placeholder='Введите название, ОГРН, ИНН или ФИО']")); 
return driver.findElement(By.xpath("//span[@class='twitter-typeahead']/input[2]")); 

       // return driver.findElement(By.xpath(
       //     "/html/body[@class='ng-scope']/div[@class='wrapper']/header/input"));
    }
 
    public WebElement getButton(){
        return driver.findElement(By.cssSelector(".btn"));
    }

    public void typeSearchKeyword(String keyword){
        getTextField().clear();
        getTextField().sendKeys(keyword);
    }

    public void typeSearchKeywordAndPressEnter(String keyword){
        getTextField().clear();
        getTextField().sendKeys(keyword + Keys.RETURN);
    }

    public void submitSearch(){
        getButton().click();
    }

  

    public WebElement getElementByXpath(String xpath){
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
    }

    public WebElement getElementByCSS(String css){
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(css)));
    }

    public int countElementsByCSS(String css){
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(css)));
        List<WebElement> elementList = driver.findElements(By.cssSelector(css));
        return elementList.size();
    }

    public int countElementsByXpath(String xpath){
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        List<WebElement> elementList = driver.findElements(By.xpath(xpath));
        return elementList.size();
    }

}
