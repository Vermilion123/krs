import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.disabled;
import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

import java.awt.Robot;
import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

public class CreateDocs {
	
	private final WebDriver driver;
	
	protected AuthFunc nfunc;

	public static Object scrollElementIntoView(WebDriver driver, WebElement element) {
	    return ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	public CreateDocs(WebDriver driver)
	{
		this.driver = driver;
	}
	
	
	public String Create_Docs_Load(String doc_type, String doc_name, String search_key, Boolean set_fields){
		nfunc = new AuthFunc(driver);
		String base_url = nfunc.getBaseURL();
		String[] cmp_data = nfunc.Get_Data_From_File("src/main/resources/test_cmp_data.txt");
		String cmp_name_search_key = cmp_data[1];
		
		((JavascriptExecutor) driver).executeScript("window.location.href='"+base_url+"documents#?f=4'");
		$(By.xpath("//a[@href='/document/new']")).click();
		$(By.xpath("//span[@class='k-select'][1]")).click();
		$("#documentTypeId_listbox").shouldBe(visible);
    	$("[aria-owns=\"receiver-id_listbox\"]").shouldHave(attribute("aria-disabled", "true"));
    	$(By.xpath("//input[@aria-owns='documentTypeId_listbox']")).val(search_key);
    	sleep(1000);
    	
    	$(By.xpath("descendant-or-self::li[contains(text(),\""+search_key+"\")]")).click();
    	$("[aria-owns=\"receiver-id_listbox\"]").click();
    	sleep(500);
    	$("input[aria-owns=\"receiver-id_listbox\"]").val(cmp_name_search_key);
    	$(By.xpath("descendant-or-self::*[contains(text(),'"+cmp_name_search_key+"')]")).click();
    	((JavascriptExecutor) driver).executeScript("document.getElementById('fileDocument').style.display = 'block'; "
    			+ "document.getElementById('fileDocument').parentElement.parentElement.parentElement.style.display = 'block' ;");
    	File file = new File("src/main/resources/docs/"+doc_name+".xml");
    	$("#fileDocument").uploadFile(file);
    	sleep(2000);
    	$(By.xpath("//div[@id='document-card-toolBar-container']/div/div/div/div/nav/ul/li[8]/a[@data-action=\"save\"]")).click(); 
    	String doc_number = $("#number").val();
		return doc_number;
	}
	
	public String Crt_Docs(String doc_type, String search_key, Boolean set_fields){
    
		nfunc = new AuthFunc(driver);
		String base_url = nfunc.getBaseURL();
		String[] cmp_data = nfunc.Get_Data_From_File("src/main/resources/test_cmp_data.txt");
		String cmp_name_search_key = cmp_data[1];
		
		((JavascriptExecutor) driver).executeScript("window.location.href='"+base_url+"documents#?f=4'");
		double a = Math.random();
		String doc_number = String.valueOf(a).substring(2, 7);
		$(By.xpath("//a[@href='/document/new']")).click();
		$(By.xpath("//span[@class='k-select'][1]")).click();
		$("#documentTypeId_listbox").shouldBe(visible);
    	$("[aria-owns=\"receiver-id_listbox\"]").shouldHave(attribute("aria-disabled", "true"));
    	$(By.xpath("//input[@aria-owns='documentTypeId_listbox']")).val(search_key);
    	sleep(1000);
    	
    	$(By.xpath("descendant-or-self::li[contains(text(),\""+search_key+"\")]")).click();
    	$("[aria-owns=\"receiver-id_listbox\"]").click();
    	sleep(500);
    	$("input[aria-owns=\"receiver-id_listbox\"]").val(cmp_name_search_key);
    	$(By.xpath("descendant-or-self::*[contains(text(),'"+cmp_name_search_key+"')]")).click();
    	$("#new-doc").click();
    	$("#key").sendKeys("auto"+doc_number);
    	if(doc_type == "UCD_CSF" || doc_type == "UCD_DIC" || doc_type == "UCD_CSF_DIC")
    	{
    		$(By.xpath("//dd[@id='invoice']/form/span/input[@id='key']")).sendKeys("auto_schf_"+doc_number);
    		$(By.xpath("//div[@id=\"document-changes-panel-container\"]/div[1]/div[1]/a")).click();
    		sleep(500);
    		$(By.name("transfer-documents")).sendKeys("auto_schf_"+doc_number);
    		$(By.xpath("descendant-or-self::*[contains(@id,'popup-save-button')]")).click();
    		
    	}
    	 ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
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
    	
    	if(doc_type == "UPD_DOP" || doc_type == "UPD_SF_DOP")
    	{
	    	$(By.xpath("//div[@id=\"handover-info-panel-container\"]/div[1]/div[1]/a")).click();
	    	sleep(500);
	    	$("[for=\"individualPerson\"]").click();
	    	$(By.name("lastName")).sendKeys("auto_surname");
	    	$(By.name("firstName")).sendKeys("auto_name");
	    	$(By.xpath("descendant-or-self::*[contains(@id,'popup-save-button')]")).click();
	    	
	    	$(By.xpath("//div[@id=\"shipment-info-panel-container\"]/div[1]/div[1]/a")).click();
	    	sleep(500);
	    	$(By.name("shipment-info")).sendKeys("auto_shipment_name");
	    	$(By.name("reason-name")).sendKeys("auto_reason");
	    	$(By.xpath("descendant-or-self::*[contains(@id,'popup-save-button')]")).click();
    	}
    	$(By.name("row-name-1")).sendKeys("Auto_Product");
    	if(doc_type == "UCD_CSF" || doc_type == "UCD_DIC" || doc_type == "UCD_CSF_DIC")
    	{
    		$(By.name("row-unitBefore-1_input")).sendKeys("Штука");
    		$(By.name("row-unitAfter-1_input")).sendKeys("Штука");
    		$(By.xpath("//table[@class='form-table invoice-table width-100']/tbody/tr[1]/td[5]/span/span/input[1]")).click();
        	$(By.name("row-amountBefore-1")).val("50");
        	$(By.xpath("//table[@class='form-table invoice-table width-100']/tbody/tr[2]/td[3]/span/span/input[1]")).click();
        	$(By.name("row-amountAfter-1")).val("45");
        	$(By.xpath("//table[@class='form-table invoice-table width-100']/tbody/tr[1]/td[6]/span/span/input[1]")).click();
        	$(By.name("row-priceBefore-1")).val("100");
        	$(By.xpath("//table[@class='form-table invoice-table width-100']/tbody/tr[2]/td[4]/span/span/input[1]")).click();
        	$(By.name("row-priceAfter-1")).val("100");
        	$(By.xpath("//table[@class='form-table invoice-table width-100']/tbody/tr[1]/td[10]/span/span/input[1]")).click();
        	$(By.name("row-vatSumBefore-1")).val("900");
        	$(By.xpath("//table[@class='form-table invoice-table width-100']/tbody/tr[1]/td[11]/span/span/input[1]")).click();
        	$(By.name("row-totalSumBefore-1")).val("5900");
        	$("[aria-owns='re-count-type_listbox']").click();
        	sleep(300);
        	$(By.xpath("//ul[@id='re-count-type_listbox']/li[3]")).click();
        	$("[data-bind='click: reCountAll, visible: isRecountButtonVisible']").click();
    	}
    	else
    	{
	    	$(By.name("row-unit-1_input")).sendKeys("Штука");
	    	if (doc_type == "UPD_SCHF") $("[class='k-formatted-value invoice-row-amount k-input']").click();
	    	else $("[class='k-formatted-value invoice-row-amount k-input required']").click();
	    	$(By.name("row-amount-1")).val("50");
	    	if(doc_type == "UPD_DOP") $("[class='k-widget k-numerictextbox invoice-row-netSum']").click();
	    	else $("[class='k-widget k-numerictextbox invoice-row-netSum required']").click();
	    	$(By.name("row-netSum-1")).val("5000");
    	}
    	if(set_fields)
    	{
	    	$(By.xpath("//dd[@id='dopInfo']/form/ul/li/span/form/span[1]/input[1]")).sendKeys("First_key");
	    	$(By.xpath("//dd[@id='dopInfo']/form/ul/li/span/form/span[2]/input[1]")).sendKeys("Value_key_"+doc_number);
    	}
    	$(By.xpath("//div[@id='toolBar-form-container']/div/div/div/div/nav/ul/li[8]/a[@data-action=\"save\"]")).click();
    	sleep(1500);
    	$(By.xpath("//div[@id='document-card-toolBar-container']/div/div/div/div/nav/ul/li[8]/a[@data-action=\"save\"]")).click(); 
    	sleep(1000);
    	return "auto"+doc_number;
    }
	
	public void Check_After_Create(String doc_num)
	{
		 $("[href=\"/documents#?f=3\"]").click();
		 $(By.xpath("//span[contains(text(),\"Расширенный поиск\")]")).click();
		sleep(500);
		$(By.xpath("//div[@id='document-column-1-container']/div[2]/input")).sendKeys(doc_num);
		$(By.xpath("//input[@type=\"submit\"]")).click();
		sleep(1000);
		$(By.xpath("descendant-or-self::a[contains(text(),'"+doc_num+"')]")).shouldBe(visible);
		
	}
	
	
		
}