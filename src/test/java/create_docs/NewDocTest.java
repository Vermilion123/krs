import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import com.codeborne.selenide.Configuration;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.Condition.*;

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


public class NewDocTest {
	
    protected WebDriver driver;
    
    protected String server;
    
    protected String base_url;
    
    protected String cmp_name_search_key;
    
    protected String doc_num;

	@Test 
	
    public void New_Doc_Form_Test(){
		double a = Math.random();
		doc_num = String.valueOf(a).substring(2, 7);
		$(By.xpath("//a[@href='/document/new']")).click();
		$(By.xpath("//span[@class='k-select'][1]")).click();
    	$("#documentTypeId_listbox").shouldBe(visible);
    	$("[aria-owns=\"receiver-id_listbox\"]").shouldHave(attribute("aria-disabled", "true"));
    	$("#client-relation").shouldBe(visible);
    	$("#number").shouldBe(disabled);
    	$("#date").shouldBe(disabled);
    	$("#parent").shouldBe(disabled);
    	$("#doc-comment").shouldBe(enabled);
    	$("[data-action=save]").shouldBe(visible);
    	$("[data-action=cancel]").shouldBe(visible);
    	$("#new-doc").shouldNotBe(visible);
    	$("#document-upload-link").shouldNotBe(visible);
    	$("#attachment").shouldNotBe(visible);
    	$("dd[data-bind=\"visible: sumFieldsVisible\"]").shouldNotBe(visible);
    	$("dd[data-bind=\"visible: contractFieldsVisible\"]").shouldNotBe(visible);
    	
    	
    	/*
    	$(By.xpath("//input[@aria-owns='documentTypeId_listbox']")).sendKeys("упд");
    	$(By.xpath("//li[contains(text(),\"УПД. Счет-фактура\")]")).click();
    	$("[aria-owns=\"receiver-id_listbox\"]").shouldHave(attribute("aria-disabled", "false"));
    	$("[aria-owns=\"receiver-id_listbox\"]").click();
    	sleep(500);
    	System.out.println(cmp_name_search_key);
    	$("input[aria-owns=\"receiver-id_listbox\"]").val(cmp_name_search_key);
    	$(By.xpath("//small[contains(text(),'"+cmp_search_string+"')]")).click();
    	$("#document-upload-link").shouldBe(visible);
    	$("#new-doc").shouldBe(visible);
    	$("#new-doc").click();
    	$("#key").sendKeys("auto"+doc_num);
    	$(By.xpath("//a[@data-bind=\"click: addSigner\"]")).click();
    	sleep(500);
    	$("[for=\"signer-info-type-person\"]").click();
    	$(By.name("lastName")).sendKeys("auto_surname");
    	$(By.name("firstName")).sendKeys("auto_name");
    	$("[aria-owns=\"signer-info-role-type_listbox\"]").click();
    	$(By.xpath("//li[contains(text(),\"Лицо, ответственное за подписание счетов-фактур\")]")).click();
    	$("[aria-owns=\"signer-info-status-type_listbox\"]").click();
    	$(By.xpath("//li[contains(text(),\"Работник организации продавца товаров (работ, услуг, имущественных прав)\")]")).click();
    	$(By.xpath("descendant-or-self::*[contains(@id,'popup-save-button')]")).click();
    	$(By.name("row-name-1")).sendKeys("Auto_Product");
    	$(By.name("row-unit-1_input")).sendKeys("Штука");
    	$("[class='k-formatted-value invoice-row-amount k-input']").click();
    	$(By.name("row-amount-1")).val("50");
    	$("[class='k-widget k-numerictextbox invoice-row-netSum required']").click();
    	$(By.name("row-netSum-1")).val("5000");
    	$(By.xpath("//dd[@id='dopInfo']/form/ul/li/span/form/span[1]/input[1]")).sendKeys("First_key");
    	$(By.xpath("//dd[@id='dopInfo']/form/ul/li/span/form/span[2]/input[1]")).sendKeys("Value_key_"+doc_num);
    	$(By.xpath("//div[@id='toolBar-form-container']/div/div/div/div/nav/ul/li[7]/a[@data-action=\"save\"]")).click();
    	sleep(1000);
    	$(By.xpath("//div[@id='document-card-toolBar-container']/div/div/div/div/nav/ul/li[7]/a[@data-action=\"save\"]")).click(); */
    }
	
	@Test (enabled=false)
	
	 public void Search_by_infofields(){
		$("[href=\"/documents#?f=13\"]").click();
		$(By.xpath("//span[contains(text(),\"Расширенный поиск\")]")).click();
		sleep(1000);
		$("[data-tab-name=\"infoField\"]").click();
		sleep(500);
		$(By.xpath("//div[@id='raw-container']/dt/input")).val("First_key");
		$(By.xpath("//div[@id='raw-container']/dd/input")).val("Value_key_"+doc_num);
		$(By.xpath("//input[@type=\"submit\"]")).click();
		sleep(1000);
		$(By.xpath("descendant-or-self::a[contains(text(),'"+doc_num+"')]")).click();
		$("#documentEditable").click();
		$("#edit-doc").click();
		sleep(1000);
		$(By.xpath("//dd[@id='dopInfo']/form/ul/li/span/form/span[1]/input[1]")).val("");
    	$(By.xpath("//dd[@id='dopInfo']/form/ul/li/span/form/span[2]/input[1]")).val("");
		$(By.xpath("//div[@id='toolBar-form-container']/div/div/div/div/nav/ul/li[7]/a[@data-action=\"save\"]")).click();
    	sleep(1000);
    	$(By.xpath("//div[@id='document-card-toolBar-container']/div/div/div/div/nav/ul/li[7]/a[@data-action=\"save\"]")).click();
	}
	
	@Test (enabled=false)
	
	 public void Search_inf_after_del(){
		$("[href=\"/documents#?f=13\"]").click();
		$(By.xpath("//span[contains(text(),\"Расширенный поиск\")]")).click();
		sleep(1000);
		$("[data-tab-name=\"infoField\"]").click();
		sleep(500);
		$(By.xpath("//div[@id='raw-container']/dt/input")).val("First_key");
		$(By.xpath("//div[@id='raw-container']/dd/input")).val("Value_key_"+doc_num);
		$(By.xpath("//input[@type=\"submit\"]")).click();
		$(By.xpath("descendant-or-self::a[contains(text(),'"+doc_num+"')]")).shouldNotBe(visible);
		sleep(2000);
	}
	  


}
