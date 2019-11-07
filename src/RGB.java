import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class RGB extends Automation {

    public RGB(WebDriver driver) {
        letter_one(driver, "R");
        letter_one(driver, "G");
        letter_one(driver, "B");
    }

    private static void letter_one(WebDriver driver, String caracter) {
        Actions act;
        act = new Actions(driver);
        WebElement letter;

        if (caracter == "G") {
            letter = driver.findElement(By.id("G"));
        } else if (caracter == "B") {
            letter = driver.findElement(By.id("B"));
        } else {
            letter = driver.findElement(By.id("R"));
        }

        act.moveToElement(letter).moveByOffset(-50, 0).perform();
        // check if element is found background change color
        verify_color(driver, caracter);
    }

    private static void verify_color(WebDriver driver, String letter) {
        String bg_color, font_color;
        bg_color = driver.findElement(By.xpath("//body")).getCssValue("background-color");
        font_color = driver.findElement(By.xpath("//*[@id='R-fill' and @class='black']")).getCssValue("background-color");
        switch (letter){
            case "G":
                assert (bg_color.equals("rgba(255, 0, 0, 1)")) : "Background color is not green !!";
                assert (font_color.equals("rgba(0, 0, 0, 1)")) : "Font color is not black !!";
                break;
            case "B":
                assert (bg_color.equals("rgba(0, 0, 255, 1)")) : "Background color is not blue !!";
                assert (font_color.equals("rgba(0, 0, 0, 1)")) : "Font color is not black !!";
                break;
            default:
                assert (bg_color.equals("rgba(255, 0, 0, 1)")) : "Background color is not red !!";
                assert (font_color.equals("rgba(0, 0, 0, 1)")) : "Font color is not black !!";
        }
        Wait();

    }

    private static void Wait() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException err) {
            System.out.println("Failed to wait a 3 seconds interval !!");
        }
    }

}
