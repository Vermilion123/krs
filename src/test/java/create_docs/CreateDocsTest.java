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
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.codeborne.selenide.Configuration;


public class CreateDocsTest {
	
		protected CreateDocs crd;
 
	    protected String base_url;
	    
	    protected String cmp_name_search_key;
	    
	    protected AuthFunc nfunc;
	    
	    protected String doc_num;
	    
	    protected Map< String, String > docs_paths = new HashMap< String, String >();
	    
	    protected  String[][] doc_types = {{"UPD_SCHF","УПД. Счет-фактура",""},{"UPD_DOP","УПД. Документ об отгрузке товаров",""},{"UPD_SF_DOP","Счет-фактура и документ об отгрузке товаров",""},
				 {"UCD_CSF","УКД. Корректировочный счет-фактура",""},{"UCD_DIC","УКД. Документ об изменении стоимости отгруженных товаров",""},{"UCD_CSF_DIC","УКД. Корректировочный счет-фактура и документ об изменении",""}};
	   
	    @Test 
	    
	    public void Get_File_Docs(){
	    	nfunc = new AuthFunc(getWebDriver());
	    	docs_paths = nfunc.Get_Docs_File_Paths("src/main/resources/docs.txt");
	    	for(int i=0; i < doc_types.length; i++)
	    	{
	    		doc_types[i][2] = docs_paths.get(doc_types[i][0]);
	    	}
	    }
	    
	    @Test (enabled=false) 
	    
	    public void New_UPD_SCHF_Load(){
	    	crd = new CreateDocs(getWebDriver());
			 
			doc_num = crd.Create_Docs_Load(doc_types[0][0], doc_types[0][2], doc_types[0][1],false);
			crd.Check_After_Create(doc_num);
	    }
	    
	    @Test 
	    
	    public void New_UPD_DOP_Load(){
	    	crd = new CreateDocs(getWebDriver());
			 
			doc_num = crd.Create_Docs_Load(doc_types[1][0], doc_types[1][2], doc_types[1][1],false);
			crd.Check_After_Create(doc_num);
	    }
	    
	    @Test (enabled=false)
	   
	    public void Test_First_Form(){
			double a = Math.random();
			String doc_num = String.valueOf(a).substring(2, 7);
			
			nfunc = new AuthFunc(getWebDriver());
			String base_url = nfunc.getBaseURL();
			String[] cmp_data = nfunc.Get_Data_From_File("src/main/resources/test_cmp_data.txt");
			String cmp_name_search_key = cmp_data[1];
			
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
	    	
	    	$(By.xpath("//input[@aria-owns='documentTypeId_listbox']")).sendKeys(doc_types[0][1]);
	    	$(By.xpath("//li[contains(text(),\"УПД. Счет-фактура\")]")).click();
	    	$("[aria-owns=\"receiver-id_listbox\"]").shouldHave(attribute("aria-disabled", "false"));
	    	$("[aria-owns=\"receiver-id_listbox\"]").click();
	    	sleep(500);
	    	
	    	$("input[aria-owns=\"receiver-id_listbox\"]").val(cmp_name_search_key);
	    	$(By.xpath("descendant-or-self::*[contains(text(),'"+cmp_name_search_key+"')]")).click();
	    	$("#document-upload-link").shouldBe(visible);
	    	$("#new-doc").shouldBe(visible);
	    	$("[data-bind=\"visible: clientRelationVisible\"]").shouldBe(visible);
	    	$("#attachments-uploader").shouldBe(visible);
	    }
		  
	    @Test (enabled=false)
	 
	 public void New_UPD_SCHF(){
		 crd = new CreateDocs(getWebDriver());
		 
			doc_num = crd.Crt_Docs(doc_types[0][0],doc_types[0][1],false);
			crd.Check_After_Create(doc_num);
	 }
	 
	 @Test (enabled=false)
	 
	 public void New_UPD_DOP(){
		 crd = new CreateDocs(getWebDriver());
		 
			doc_num = crd.Crt_Docs(doc_types[1][0],doc_types[1][1],false);
			crd.Check_After_Create(doc_num);
	 }
	 @Test (enabled=false)
 
	 public void New_UPD_SF_DOP(){
		 crd = new CreateDocs(getWebDriver());
		 
			doc_num = crd.Crt_Docs(doc_types[2][0],doc_types[2][1],false);
			crd.Check_After_Create(doc_num);
	 }
	 @Test (enabled=false)
	 
	 public void New_UCD_CSF(){
		 crd = new CreateDocs(getWebDriver());
		 
			doc_num = crd.Crt_Docs(doc_types[3][0],doc_types[3][1],false);
			crd.Check_After_Create(doc_num);
	 }
	 @Test (enabled=false)
	 
	 public void New_UCD_DIC(){
		 crd = new CreateDocs(getWebDriver());
		 
			doc_num = crd.Crt_Docs(doc_types[4][0],doc_types[4][1],false);
			crd.Check_After_Create(doc_num);
	 }
	 @Test (enabled=false)
	 
	 public void New_UCD_CSF_DIC(){
		 crd = new CreateDocs(getWebDriver());
		 
			doc_num = crd.Crt_Docs(doc_types[5][0],doc_types[5][1],false);
			crd.Check_After_Create(doc_num);
	 }

}