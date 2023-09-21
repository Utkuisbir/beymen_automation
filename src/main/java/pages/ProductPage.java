package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {
    private WebDriver driver;
    private WebElement productTitle;


    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectRandomProductAndAddToCart() throws IOException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        productTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.m-productCard__title")));


        List<WebElement> productList = driver.findElements(By.cssSelector("span.m-productCard__title"));

        if (productList.size() == 0) {
            System.out.println("Ürün bulunamadı.");
            return;
        }

        Random random = new Random();
        int randomIndex = random.nextInt(productList.size());
        WebElement selectedProduct = productList.get(randomIndex);
        
        String productName = selectedProduct.findElement(By.cssSelector("span.m-productCard__title")).getText();
        String productPrice = selectedProduct.findElement(By.cssSelector("span.m-productCard__newPrice")).getText();
        
        saveProductInfoToFile(productName, productPrice);
        
        selectedProduct.click();

    }

    private void saveProductInfoToFile(String productName, String productPrice) throws IOException {
        FileWriter writer = new FileWriter("product_info.txt");
        writer.write("Ürün Adı: " + productName + "\n");
        writer.write("Ürün Fiyatı: " + productPrice + "\n");
        writer.close();
    }
}
