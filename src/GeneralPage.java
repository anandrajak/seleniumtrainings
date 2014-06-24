import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by ko4 on 24-Jun-14.
 */
public class GeneralPage {
    private final WebDriver driver;

    public GeneralPage(WebDriver driver) {
        this.driver=driver;
    }

    By listFolderLocator = By.xpath("//*[@class=\"rtMid rtSelected\"]/following-sibling::*//*[@class=\"rtIn\"]");
    By preloaderLocator = By.cssSelector(".raDiv");
    By selectedFolder = By.cssSelector(".rtSelected>.rtIn");

    public List<WebElement> getListFolder (){
        return driver.findElements(By.xpath("//*[@class=\"rtMid rtSelected\"]/following-sibling::*//*[@class=\"rtIn\"]"));
    }

    public Boolean isPreloaderDisplayed (){
        return driver.findElement(preloaderLocator).isDisplayed();
    }

    public String getTitleOfSelectedFolder(){
        return driver.findElement(selectedFolder).getText();
    }

}
