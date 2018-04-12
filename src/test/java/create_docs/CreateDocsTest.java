import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.codeborne.selenide.Configuration;

public class CreateDocsTest {
	
		protected CreateDocs crd;
		
		protected AuthFunc auth;
 
	    protected String base_url;
	    
	    protected String cmp_name_search_key;
	    
	    protected String doc_num;
	    
	    protected  String[][] doc_types = {{"UPD_SCHF","УПД. Счет-фактура"},{"UPD_DOP","УПД. Документ об отгрузке товаров"},{"UPD_SF_DOP","Счет-фактура и документ об отгрузке товаров"},
				 {"UCD_CSF","УКД. Корректировочный счет-фактура"},{"UCD_DIC","УКД. Документ об изменении стоимости отгруженных товаров"},{"UCD_CSF_DIC","УКД. Корректировочный счет-фактура и документ об изменении"}};
		
	
	    @Test 
	 
	 public void New_UPD_SCHF(){
		 crd = new CreateDocs(getWebDriver());
		 
			doc_num = crd.Crt_Docs(base_url, doc_types[0][0],doc_types[0][1],false);
			crd.Check_After_Create(doc_num);
	 }
	 
	 @Test (enabled=false)
	 
	 public void New_UPD_DOP(){
		 crd = new CreateDocs(getWebDriver());
		 
			doc_num = crd.Crt_Docs(base_url, doc_types[1][0],doc_types[1][1],false);
			crd.Check_After_Create(doc_num);
	 }
	 @Test (enabled=false)
 
	 public void New_UPD_SF_DOP(){
		 crd = new CreateDocs(getWebDriver());
		 
			doc_num = crd.Crt_Docs(base_url, doc_types[2][0],doc_types[2][1],false);
			crd.Check_After_Create(doc_num);
	 }
	 @Test (enabled=false)
	 
	 public void New_UCD_CSF(){
		 crd = new CreateDocs(getWebDriver());
		 
			doc_num = crd.Crt_Docs(base_url, doc_types[3][0],doc_types[3][1],false);
			crd.Check_After_Create(doc_num);
	 }
	 @Test (enabled=false)
	 
	 public void New_UCD_DIC(){
		 crd = new CreateDocs(getWebDriver());
		 
			doc_num = crd.Crt_Docs(base_url, doc_types[4][0],doc_types[4][1],false);
			crd.Check_After_Create(doc_num);
	 }
	 @Test (enabled=false)
	 
	 public void New_UCD_CSF_DIC(){
		 crd = new CreateDocs(getWebDriver());
		 
			doc_num = crd.Crt_Docs(base_url, doc_types[5][0],doc_types[5][1],false);
			crd.Check_After_Create(doc_num);
	 }

}