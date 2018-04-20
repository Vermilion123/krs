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




public class KAGroupTest {
    
	protected KAGroup kfunc;
    
    protected String group_name;
    
    protected String temp_name;
    
    @Test (enabled=false)
    
    public void Check_Create_DeleteKAGroup ()
    {
    	kfunc = new KAGroup(getWebDriver());
		String[] cmp_search_keys = kfunc.Get_Test_Data("src/main/resources/test_data_ka_groups.txt");
    	group_name = kfunc.CreateKAGroup(cmp_search_keys, "");
    	kfunc.ChooseKAGroup(group_name);
    	kfunc.DeleteKaGroup(group_name);
    }
    
    @Test (enabled=false)
    
    public void Check_GroupNameExist ()
    {
    	String[] temp = new String[1];
    	kfunc = new KAGroup(getWebDriver());
		String[] cmp_search_keys = kfunc.Get_Test_Data("src/main/resources/test_data_ka_groups.txt");
		temp[0] = cmp_search_keys[0];
    	group_name = kfunc.CreateKAGroup(temp, "");
    	temp[0] = cmp_search_keys[1];
    	group_name = kfunc.CreateKAGroup(temp, group_name);
    	$(By.xpath("//p[contains(text(),'уже существует')]")).shouldBe(visible);
    	sleep(1500);
    	kfunc.DeleteKaGroup(group_name);
    
    }
    
    @Test
    
    public void Check_GroupWithKAExist ()
    {
    	String[] temp = new String[1];
    	kfunc = new KAGroup(getWebDriver());
		String[] cmp_search_keys = kfunc.Get_Test_Data("src/main/resources/test_data_ka_groups.txt");
		temp[0] = cmp_search_keys[0];
    	group_name = kfunc.CreateKAGroup(temp, "");	
    	temp_name =  kfunc.CreateKAGroup(temp, "");
    	$(By.xpath("//p[contains(text(),'Ошибка входных параметров')]")).shouldBe(visible);
    	sleep(1500);
    	kfunc.DeleteKaGroup(group_name);
    }
}