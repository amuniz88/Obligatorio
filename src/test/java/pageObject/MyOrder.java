package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class MyOrder extends BasePage {

    @FindBy(className = "order-number")
    WebElement orderNum;

    @FindBy(className = "order-details-area")
    WebElement datesOrder;

    @FindBy(className = "selected-checkout-attributes")
    WebElement orderGift;

    @FindBy(className = "unit-price")
    WebElement price;

    WebDriver driver;
    List<OrderList> orders;
    List<OrderList> SeccionTotales;

    public MyOrder(WebDriver driver){
        super(driver);
        orders = new ArrayList<>();
        WebElement tabla = findElement(By.cssSelector(".data-table tbody"));
        List<WebElement> filas = tabla.findElements(By.cssSelector("tr"));
        for(WebElement fila : filas){
            orders.add(new OrderList(fila));
        }

        SeccionTotales = new ArrayList<>();
        WebElement tablaSecTot = findElement(By.cssSelector(".cart-total tbody"));
        List<WebElement> filasTotales = tablaSecTot.findElements(By.cssSelector("tr"));
        for(WebElement filaTot : filasTotales){
            SeccionTotales.add(new OrderList(filaTot));
        }
    }

    public boolean verifyConfirmedOrder(){
        if(order.getNumOrder() == Integer.valueOf(orderNum.getText().replace("ORDER #",""))){
            return true;
        } else {
            return false;
        }
    }

    public boolean datesOrderIsDisplayed(){
        return datesOrder.isDisplayed();
    }

    public boolean nameContainsProduct(String element){
        for(int i = 0; i < orders.size(); i++){
            if(orders.get(i).getName().contains(element)){
                order.setNombre(element);
                order.setPos(i);
                return true;
            }
        }
        return false;
    }

    public boolean priceProduct(){
        boolean retorno = false;

        for(int i = 0; i < orders.size(); i++){
            if(order.getPos() == i){
                if(order.getPrecio() == orders.get(i).getPriceList()) {
                    retorno = true;
                    break;
                }
            }
        }
        return retorno;
    }

    public boolean priceProductMasGift(){
        double precioTotal = order.getPrecio() * Double.valueOf(order.getCantidad());
        boolean retorno = false;

        if (order.getGift() == true) {
            precioTotal = order.getPrecio() + 10;
        }

        for(int i = 0; i < orders.size(); i++) {
            if(order.getPos() == i) {
                for(int j = 0; j < SeccionTotales.size(); j++) {
                    if (SeccionTotales.get(j).getPreciosOrder() == precioTotal) {
                        retorno = true;
                    }
                }
            }
        }
        return retorno;
    }
}
