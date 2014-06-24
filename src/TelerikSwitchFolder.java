import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOfElementLocated;

/**
 * Created by 1 on 6/24/2014.
 */
public class TelerikSwitchFolder extends BaseTest{
    private static List<WebElement> listFolders = null;
    private static String baseURL = "http://demos.telerik.com/aspnet-ajax/webmail/default.aspx";
    @Test
    public void testSwitchFolder(){
        getDriver("FF");
        driver.get(baseURL);
        GeneralPage page = PageFactory.initElements(driver, GeneralPage.class);
        listFolders = page.getListFolder();
        for (int i = 0; i < listFolders.size(); i++){
            WebElement currentFolder = listFolders.get(i);
            currentFolder.click();
            assertTrue(page.isPreloaderDisplayed());
            new WebDriverWait(driver, 10).until(invisibilityOfElementLocated(page.preloaderLocator));
            assertEquals(page.getTitleOfSelectedFolder(),
                    currentFolder.getText());
        }
    }
}
