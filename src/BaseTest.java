import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import ru.esteru.selenium.factory.WebDriverFactory;

import java.net.MalformedURLException;
import java.util.Calendar;
import java.util.Random;

/**
 * Created by ko4 on 12.06.2014.
 */
public class BaseTest {

    public static String strDriver;
    public static WebDriver driver;
    private static DesiredCapabilities cpb = new DesiredCapabilities();
    public static void setDriver(String strDriver) {
        switch (strDriver) {
            case "FF": {
                cpb = DesiredCapabilities.firefox();
                cpb.setBrowserName("firefox");
                //firefox_binary
                //cpb.setCapability("firefox_binary","TODO:");
                break;
            }
            case "Chrome": {
                System.setProperty("webdriver.chrome.driver", "D:\\lib\\chromedriver.exe");
                cpb = DesiredCapabilities.chrome();
                cpb.setBrowserName("chrome");

                // Add ChromeDriver-specific capabilities through ChromeOptions.
                ChromeOptions options = new ChromeOptions();
                options.addArguments("start-maximized");
                options.addArguments("test-type");  //You are using an unsupported command-line flag --ignore-certificate-errors. Stability and security will suffer.
                cpb.setCapability(ChromeOptions.CAPABILITY, options);
                break;
            }
            case "IE": {
                System.setProperty("webdriver.ie.driver", "D:\\lib\\IEDriverServer.exe");
                cpb = DesiredCapabilities.internetExplorer();
                cpb.setBrowserName("internet explorer");
                //ie.ensureCleanSession
                cpb.setCapability("ie.ensureCleanSession",true);
                break;
            }
            case "Opera":{
                cpb = DesiredCapabilities.opera();
                cpb.setBrowserName("opera");
                //opera.binary
                cpb.setCapability("opera.binary","TODO:");
                break;
            }
            case "Safari": {
                cpb = DesiredCapabilities.safari();
                cpb.setBrowserName("safari");
                //cleanSession
                cpb.setCapability("cleanSession",true);
                break;
            }
            case "Phantom": {
                System.setProperty("phantomjs.binary.path", "D:\\lib\\phantomjs.exe");
                cpb = DesiredCapabilities.phantomjs();
                cpb.setBrowserName("phantomjs");
                break;
            }
            case "Sauce": {
                cpb.setCapability(CapabilityType.BROWSER_NAME, "firefox");
/*                if (version != null) {
                    capabilities.setCapability(CapabilityType.VERSION, version);
                }*/
                //cpb.setCapability("platform", Platform.XP);
                cpb.setBrowserName("sauce");
                break;
            }
            default: {
                throw new IllegalArgumentException("Unknown Browser");
            }
        }
    }

    public BaseTest (){

    }
    public void getDriver(){
        setDriver(strDriver);
        try {
            driver = new WebDriverFactory().getDriver(cpb);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
    public void getDriver(String Browser){
        strDriver = Browser;
        setDriver(strDriver);
        try {
            driver = new WebDriverFactory().getDriver(cpb);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public String[] generateRandomDate(boolean over16){
        int  a;
        //int maxDate = 12784; //01.01.2005 in Unix Time divide on 86400 = (1000msec*60sec*60min*24hours)
        Calendar cal = Calendar.getInstance();
        long today = (cal.getTimeInMillis()/(1000*60*60*24));
        cal.add(Calendar.YEAR,-16);
        long targetDate = (cal.getTimeInMillis()/(1000*60*60*24));
        Random rnd = new Random();
        if (over16){
            a = rnd.nextInt((int)targetDate);
        } else {
            a = rnd.nextInt((int)((today-targetDate)+targetDate));
        }
        /*if (a % 30 == 0) {
            String randomDate[] = {"-", "-", ""};
            return randomDate;
        }*/
        long index = (long)a*1000*86400;
        Calendar mydate = Calendar.getInstance();
        mydate.setTimeInMillis(index);
        mydate.getTimeInMillis();
        String months[] = {"январь", "февраль","март", "апрель", "май", "июнь", "июль", "август", "сентябрь", "октябрь", "ноябрь", "декабрь"};
        String bDay = (""+mydate.get(Calendar.DAY_OF_MONTH));
        String bMonth = (months[mydate.get(Calendar.MONTH)]);
        String bYear = (""+mydate.get(Calendar.YEAR));
        String randomDate[] = {bDay,bMonth, bYear};
        return randomDate;
    }
}
