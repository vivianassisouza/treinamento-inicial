import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class SearchTest {

    WebDriver driver = new ChromeDriver();

    @Test
    public void buscaGoogle() {
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

        driver.get("https://google.com.br");
        driver.findElement(By.xpath("//textarea[@title='Pesquisar']")).sendKeys("ABC");
        driver.findElement(By.xpath("//textarea[@title='Pesquisar']")).sendKeys(Keys.ENTER);

        Assertions.assertEquals("ABC - Pesquisa Google", driver.getTitle());

        Assertions.assertTrue(driver.getPageSource().contains("ABC"));
    }
}