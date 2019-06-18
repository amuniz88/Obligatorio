package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage{

    @FindBy(how = How.CLASS_NAME, using = "ico-register")
    WebElement register;

    public HomePage(WebDriver driver){
        super(driver);
    }

    public PORegistrarUsuario registroDeUsuario(){
        register.click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("button-1"))));
        return new PORegistrarUsuario(driver);
    }

}
