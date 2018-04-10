import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.codeborne.selenide.Configuration;

public class Create_Docs_Test {
	
	 protected Create_Docs crd;
		 
	    
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
	    	

	    	server = System.getProperty("server");
	    //	System.out.println(server);
	    	 if (server.equals("test"))
	    	    {
	    	    	base_url = "https://courier-test.esphere.ru/"; 
	    	    	log1 = "U56"; pass1 = "12345678";
	    	    	cmp_name_search_key = "5003124613";
	    	    	cmp_search_string = "5003124613 / 500301001";
	    	    }
	    	 else if (server.equals("demo"))
	    	    {
	    	    	base_url = "https://courier-demo.esphere.ru";
	    	    	log1 = "U203"; pass1 = "12345678";
	    	    	cmp_name_search_key = "7840044905";
	    	    	cmp_search_string = "7840044905 / 784001001";
	    	    }

	    	 
	    	// System.out.println(base_url);
	    	 Configuration.browser = "chrome";
	    	 System.setProperty("selenide.browser", "chrome");
	    	 
	        open(base_url);

	    }
	 
	 @Test  
		
		public void LoginCourier(){
	        $("#IDToken1").sendKeys(log1);
	        $("#IDToken2").sendKeys(pass1);
	        $("[ng-click=\"doLogin()\"]").click();
	    }
		
	 @Test
	 
	 public void New_UPD_SCHF(){
		 
	//  crd = new Create_Docs("UPD_SCHF","УПД. Счет-фактура",cmp_name_search_key,false);
	//  crd = new Create_Docs(getWebDriver() ,"UPD_DOP","УПД. Документ об отгрузке товаров",cmp_name_search_key,false);
	//  crd = new Create_Docs(getWebDriver() ,"UPD_SF_DOP","Счет-фактура и документ об отгрузке товаров",cmp_name_search_key,false);
	//  crd = new Create_Docs(getWebDriver() ,"UCD_CSF","УКД. Корректировочный счет-фактура",cmp_name_search_key,false);
	//	crd = new Create_Docs(getWebDriver() ,"UCD_DIC","УКД. Документ об изменении стоимости отгруженных товаров",cmp_name_search_key,false);
	    crd = new Create_Docs(getWebDriver() ,"UCD_CSF_DIC","УКД. Корректировочный счет-фактура и документ об изменении",cmp_name_search_key,false);
	  
	 }

}