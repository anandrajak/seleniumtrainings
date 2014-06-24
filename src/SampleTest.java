import org.junit.Test;

import java.net.MalformedURLException;

/**
 * Created by ko4 on 12.06.2014.
 */
public class SampleTest extends BaseTest{
    public static String URL = "http://fotostrana.ru";



    @Test
    //(timeout = 180000)
    public void testAuthorizationViaEmail() throws Exception {
        // переход на базовый урл
     getDriver("Chrome");
     driver.get(URL);
     getDriver("FF");
     driver.get(URL);
     getDriver("IE"); //http://screen.fst.su/ko4/ko4Shot2014-06-13020833.png
     driver.get(URL);
     getDriver("Phantom");
     driver.get(URL);
     getDriver("Sauce");
     driver.get(URL);

    }
}
