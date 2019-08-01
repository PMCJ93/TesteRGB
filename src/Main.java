import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Main {

    public static void main(String[] args) {
        String bg_color, font_color;
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Pedro\\IdeaProjects\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        Actions act = new Actions(driver);

        
        // redirecionar o tramanho da janela
        driver.manage().window().maximize();
        
        // ir para URL https://www.rrrgggbbb.com/
        driver.get("https://www.rrrgggbbb.com/");
        
        // encontrar o elemento com o id=R
        WebElement red_letter = driver.findElement(By.id("R"));
        act.moveToElement(red_letter).perform();

        
        // verificar se o elemento é encontrado background passa a red  e a letra a black
        bg_color = driver.findElement(By.xpath("//body")).getCssValue("background-color");
        font_color = driver.findElement(By.xpath("//*[@id='R-fill' and @class='black']")).getCssValue("background-color");
        assert (bg_color.equals("rgba(255, 0, 0, 1)")) : "Background color is not red !!";
        assert (font_color.equals("rgba(0, 0, 0, 1)")) : "Font color is not black !!";

        Wait();
        // encontrar o elemento com o id=G
        // green -50 para fazer o over na letra
        WebElement green_letter = driver.findElement(By.id("G"));
        act.moveToElement(green_letter).moveByOffset(-50, 0).perform();
        
        // verificar se o elemento é encontrado background passa a green e a letra a black
        bg_color = driver.findElement(By.xpath("//body")).getCssValue("background-color");
        font_color = driver.findElement(By.xpath("//*[@id='G-fill' and @class='black']")).getCssValue("background-color");
        assert (bg_color.equals("rgba(255, 0, 0, 1)")) : "Background color is not green !!";
        assert (font_color.equals("rgba(0, 0, 0, 1)")) : "Font color is not black !!";

        Wait();

        // encontrar o elemento com o id=B
        WebElement blue_letter = driver.findElement(By.id("B"));
        act.moveToElement(blue_letter).perform();

        // verificar se o elemento é encontrado background passa a blue e a letra a black
        bg_color = driver.findElement(By.xpath("//body")).getCssValue("background-color");
        font_color = driver.findElement(By.xpath("//*[@id='B-fill' and @class='black']")).getCssValue("background-color");
        assert (bg_color.equals("rgba(0, 0, 255, 1)")) : "Background color is not blue !!";
        assert (font_color.equals("rgba(0, 0, 0, 1)")) : "Font color is not black !!";

        Wait();

        driver.close();
    }

    private static void Wait() {
        // tempo de para espera entre as ações
        try {
            Thread.sleep(5000);
        } catch (InterruptedException err) {
            System.out.println("Failed to wait a 3 seconds interval !!");
        }
    }
}
