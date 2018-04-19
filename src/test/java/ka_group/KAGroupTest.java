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
    
    @Test 
    
    public void Check_Create_DeleteKAGroup ()
    {
    	kfunc = new KAGroup(getWebDriver());
    	group_name = kfunc.CreateKAGroup();
    	kfunc.ChooseKAGroup(group_name);
    	kfunc.DeleteKaGroup(group_name);
    }
    
    @Test (enabled=false)
    
    public void Check_GroupNameExist ()
    {
    	
    
    }
    
    @Test (enabled=false)
    
    public void Check_GroupWithKAExist ()
    {
    	
    
    }
}