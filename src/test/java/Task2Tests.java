import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Task2Tests {
    @Test
    public void Task2_1() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/progress-bar");
        driver.manage().window().maximize();
        WebElement button=driver.findElement(By.xpath("//*[@id=\"startStopButton\"]"));
        button.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.textToBe(By.xpath("//*[@id=\"progressBar\"]/div"),"100%"));
        System.out.println("100%");


    }
    @Test
    public void Task2_2() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html ");
        driver.manage().window().maximize();

        WebElement programmingDropdown=driver.findElement(By.xpath("//*[@id=\"dropdowm-menu-1\"]"));
        Select Language = new Select(programmingDropdown);
        String Lang="Python";
        Language.selectByVisibleText(Lang);
        String selected = Language.getFirstSelectedOption().getText();
        Assert.assertEquals(Lang,selected);


        driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/label[1]/input")).click();
        driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/label[2]/input")).click();
        driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/label[4]/input")).click();

        driver.findElement(By.xpath("//*[@id=\"radio-buttons\"]/input[5]")).click();


        WebElement orange = driver.findElement(By.xpath("//*[@id=\"fruit-selects\"]/option[2]"));
        Assert.assertFalse(orange.isEnabled());
    }


}
