package org.nttdata;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class SearchTest {

    WebDriver driver = new ChromeDriver();

    @Test
    public void buscaGoogle() {
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));

        driver.get("https://google.com.br");
        Assertions.assertEquals("https://www.google.com.br/", driver.getCurrentUrl());

        driver.findElement(By.xpath("//textarea[@title='Pesquisar']")).sendKeys("ABC");
        driver.findElement(By.cssSelector("[name=q]")).sendKeys(Keys.ENTER);

        Assertions.assertTrue(driver.getPageSource().contains("ABC"));
        Assertions.assertEquals(driver.getTitle(), "ABC - Pesquisa Google");
        Assertions.assertFalse(driver.getTitle().contains("BCA"));
        Assertions.assertNotEquals(driver.getCurrentUrl(), "https://google.com.br");
        Assertions.assertNotNull(driver);

        List<WebElement> links = driver.findElements(By.xpath("//h3[contains(text(), 'ABC')]"));

        for (int i = 0; i < 5 && i < links.size(); i++) {
            WebElement link = links.get(i);

            link.click();
            String linkText = driver.getCurrentUrl();
            String titleText = driver.getTitle();
            System.out.println(linkText);
            System.out.println(titleText);
            driver.navigate().back();
        }

        int i = 0;
        while (i<5){
            WebElement link = links.get(i);
            link.click();
            driver.navigate().back();
            i++;
        }
    }
}