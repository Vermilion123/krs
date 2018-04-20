import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.disabled;
import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.codeborne.selenide.Configuration;

public class KAGroup {
	
    protected AuthFunc nfunc;
    
    protected String server = System.getProperty("server");
    
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
    
    public String[] Get_Test_Data(String f_path)
  	{
      	String[] data = new String[10];
      	try {
          	Path filePath = Paths.get(f_path);
          	Scanner scanner = new Scanner(filePath);
          	Pattern pattern = Pattern.compile(".*"+server+".*");
          	int j = 0;
          	while (scanner.hasNext()) {
          		if (scanner.hasNext(pattern))
          			data[j] = scanner.nextLine().replace(server+";","");j++;
          	}}
          	 catch (FileNotFoundException e) {
          		    e.printStackTrace();
          		} catch (IOException e) {
          		    e.printStackTrace();
          		} 
      	return data;
          	
  	}
    
    public String CreateKAGroup (String[] cmp_search_keys, String group_name) 
    {
    	
		double a = Math.random();
		if (group_name == "") group_name = "auto_group_"+String.valueOf(a).substring(2, 7);
    	$("[data-menu-status='RelationRequestCount']").click();
    	$(By.xpath("//a[@href='/manage/counteragent/group']")).click();
    	$("#add-item").click();
    	sleep(500);
    	$("[data-action='save']").shouldHave(attribute("class","button primary disabled ignore"));
	    	for(int i=0; i < cmp_search_keys.length; i++)
	    	{
		    	if(cmp_search_keys[i] != null)
		    	{	
			    	$("#add-item").click();
			    	
			    	sleep(500);
			    	$(By.cssSelector("[aria-owns^=selected-users-for-role_taglist]")).click();
			    	sleep(500);
			    	$(By.cssSelector("[aria-owns^=selected-users-for-role_taglist]")).val(cmp_search_keys[i]);	
			    	sleep(500);
			    	$(By.xpath("descendant-or-self::*[contains(text(),'"+cmp_search_keys[i]+" /')]")).click();
			    	$(By.cssSelector("[id$=popup-save-button]")).click();
		    	}
	    	}
    	
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