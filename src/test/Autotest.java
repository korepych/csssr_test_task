package test;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class Autotest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("http://blog.csssr.ru/qa-engineer/");

        JavascriptExecutor scroll = driver;
        scroll.executeScript("window.scrollBy(0,600)"); //скроллим ниже

        WebElement element = driver.findElement(By.xpath(".//div[@class='graphs-errors']/a")); //находим второй блок
        element.click();

        //проверяем гиперссылку
        try {
            element = driver.findElement(By.xpath(".//a[@href='http://monosnap.com/']"));
            System.out.println("Right hyperlink!");
        } catch (NoSuchElementException e) {
            System.out.println("Wrong hyperlink!");
        }
        //driver.close(); //раскоментить если нужно
    }
}
