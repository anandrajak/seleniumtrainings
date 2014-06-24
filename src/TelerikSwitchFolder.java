import org.junit.Test;
import static org.junit.Assert.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOfElementLocated;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.List;

/**
 * Created by 1 on 6/24/2014.
 */
public class TelerikSwitchFolder extends BaseTest{
    private static List<WebElement> listFolders = null;
    @Test
    public void testSwitchFolder(){
        getDriver("FF");
        driver.get("http://demos.telerik.com/aspnet-ajax/webmail/default.aspx");
        //вынести инициализацию в PageObject
        listFolders = driver.findElements(By.xpath("//*[@class=\"rtMid rtSelected\"]/following-sibling::*//*[@class=\"rtIn\"]"));
        for (int i = 0; i < listFolders.size(); i++){
            WebElement element = listFolders.get(i);
            element.click();
            assertTrue(driver.findElement(By.cssSelector(".raDiv")).isDisplayed());
            new WebDriverWait(driver, 10).until(invisibilityOfElementLocated(By.cssSelector(".raDiv")));
            assertEquals(driver.findElement(By.cssSelector(".rtSelected>.rtIn")).getText(),
                    element.getText());
        }


    }
}
