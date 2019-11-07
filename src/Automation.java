import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Automation {

    public static void main(String[] args) {
        String bg_color, font_color;
        WebDriver driver;

        //open browser
        driver = browser();

        // redirect window size
        driver.manage().window().maximize();

        // go to  url
        driver.get("https://www.rrrgggbbb.com/");

        new RGB (driver);

        driver.close();
    }


    private static WebDriver browser() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Pedro\\IdeaProjects\\chromedriver3.exe");
        WebDriver driver = new ChromeDriver();
        return driver;
    }

}