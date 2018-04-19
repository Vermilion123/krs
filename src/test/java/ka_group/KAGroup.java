import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.disabled;
import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.codeborne.selenide.Configuration;

public class KAGroup {
	
    protected AuthFunc nfunc;
    
    protected String server;
    
    protected String base_url;
    
    protected String log1;
    
    protected WebDriver driver;
    
    protected String pass1;
    
    protected String cmp_name_search_key;
    
    protected String cmp_search_string;
    
    protected String doc_num;
    
    public KAGroup(WebDriver driver){
        this.driver = driver;
    }
    
    public String CreateKAGroup () // переделать, чтобы создавала группу для нескольких КА, переданных массивом
    {
    	nfunc = new AuthFunc(getWebDriver());
		String base_url = nfunc.getBaseURL();
		String[] cmp_data = nfunc.Get_Data_From_File("src/main/resources/test_cmp_data.txt");
		String cmp_name_search_key = cmp_data[1];
		double a = Math.random();
		String group_name = "auto_group_"+String.valueOf(a).substring(2, 7);
    	$("[data-menu-status='RelationRequestCount']").click();
    	$(By.xpath("//a[@href='/manage/counteragent/group']")).click();
    	$("#add-item").click();
    	sleep(500);
    	$("[data-action='save']").shouldHave(attribute("class","button primary disabled ignore"));
    	$("#add-item").click();
    	$(By.cssSelector("[aria-owns^=selected-users-for-role_taglist]")).click();sleep(500);
    	$(By.cssSelector("[aria-owns^=selected-users-for-role_taglist]")).val(cmp_name_search_key);	
    	sleep(500);
    	$(By.xpath("descendant-or-self::*[contains(text(),'"+cmp_name_search_key+" /')]")).click();
    	$(By.cssSelector("[id$=popup-save-button]")).click();
    	$("[data-action='save']").click();
    	sleep(500);
    //	$("input[data-bind=\"value: name\"]").shouldHave(attribute("aria-invalid","true")); надо потом разобраться, схера ли отрабатывает 1 раз из 5-ти
    	$("input[data-bind=\"value: name\"]").val(group_name);
    	$("[data-action='save']").click();
    	return group_name;
    }
    
    public void ChooseKAGroup(String group_name)
    {
    	$(By.xpath("//div[@id='top-filter-content']/div/span/input[1]")).val(group_name);
    	sleep(500);
    	$("[data-bind='click: trimAndSubmit']").click();
    }
    
    
    public void DeleteKaGroup(String group_name)
    {
    	nfunc = new AuthFunc(getWebDriver());
		String base_url = nfunc.getBaseURL();
    	((JavascriptExecutor) driver).executeScript("window.location.href='"+base_url+"manage/counteragent/group'");
    	ChooseKAGroup(group_name);
    	$(By.xpath("//a[contains(text(),'"+group_name+"')]")).hover();
    	$("[data-bind='click: deleteRow, visible: isGroupListEditMode']").click();
    	ChooseKAGroup(group_name);
    	sleep(1000);
    	$(By.xpath("//a[contains(text(),'"+group_name+"')]")).shouldNotBe(visible);
    }
}