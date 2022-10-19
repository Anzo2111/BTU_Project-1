import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class exam {
    @Test
    public void exam() {
        //login
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/login");
        driver.manage().window().maximize();

        WebElement username = driver.findElement(By.id("userName"));
        WebElement pass = driver.findElement(By.id("password"));
        username.sendKeys("test123");
        pass.sendKeys("Automation@123");
        driver.findElement(By.xpath("//*[@id=\"login\"]")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        wait.until(ExpectedConditions.textToBe(By.xpath("//*[@id=\"submit\"]"),"Log out"));



        //go to book store
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"gotoStore\"]"))).click();
        wait.until(ExpectedConditions.textToBe(By.xpath("//*[@id=\"submit\"]"),"Log out"));
        List<WebElement> rows = driver.findElements(By.tagName("img"));
        // sxvanairad ver davtvale rva wiogni amitom suratebit davtvale da zedmeti 3 surati gamovakeli :ddd
        int count = rows.size() - 3;
        Assert.assertEquals(count, 8);


        //book details
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"see-book-Git Pocket Guide\"]/a"))).click();
        WebElement title = new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/label")));
        Assert.assertEquals(title.getText(), "Git Pocket Guide");

        //add your collection
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[2]/div[9]/div[2]/button"))).click();
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String text = alert.getText();
        Assert.assertEquals(text, "Book already present in the your collection!");
        alert.accept();

        //back to  book store
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"addNewRecordButton\"]"))).click();
        // sxvanairad ver davtvale rva wiogni amitom suratebit davtvale da zedmeti 3 surati gamovakeli :ddd
        Assert.assertEquals(count, 8);

        //Log out
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"submit\"]"))).click();
        WebElement welcome = driver.findElement(By.xpath("//*[@id=\"userForm\"]/div[1]/h2"));
        Assert.assertEquals(welcome.getText(), "Welcome,");
        WebElement welcome1 = driver.findElement(By.xpath("//*[@id=\"userForm\"]/div[1]/h5"));
        Assert.assertEquals(welcome1.getText(), "Login in Book Store");



    }
}
