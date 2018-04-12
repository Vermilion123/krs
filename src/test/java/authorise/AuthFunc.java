import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.regex.Pattern;

import com.codeborne.selenide.Configuration;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;


public class AuthFunc {
	
	private String base_url;
	
	private String server = System.getProperty("server");
	
    private final WebDriver driver;

    public AuthFunc(WebDriver driver){
        this.driver = driver;
    }
    
    public String getBaseURL(){
    	
    	String server = System.getProperty("server");
    	base_url =  "https://courier-"+server+".esphere.ru/";
        return base_url;
    }
    
    public String[] Get_Data_From_File(String f_path)
  	{
      	String[] credet = new String[10];
      	try {
          	Path filePath = Paths.get(f_path);
          	
          	Scanner scanner = new Scanner(filePath);
          	int j = 0; Pattern pattern = Pattern.compile(".*"+server+".*");
          	while (scanner.hasNext()) {
          		if (scanner.hasNext(pattern))
          		credet = scanner.nextLine().split(";");j++;
          		scanner.nextLine();
          	}
          	
        //	for(int i=0; i < credet.length; i++)
        //			if(server.equals(credet[i][0])) {log1 = credetials[i][1]; pass1 = credetials[i][2]; cmp_name_search_key = credetials[i][3];}
        	
          	 }
          	 catch (FileNotFoundException e) {
          		    e.printStackTrace();
          		} catch (IOException e) {
          		    e.printStackTrace();
          		} 
      	return credet;
          	
  	}
    
    


}
