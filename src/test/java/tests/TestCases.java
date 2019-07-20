package tests;

import dataProviders.DPGeneral;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCases extends BaseTestWhitLogin{

    @Test(dataProvider = "DP_Producto", dataProviderClass = DPGeneral.class)
    public void checkoutEfectivo(String producto, String size, String color, String gift, String cant, String country, String postal, String r_shopp, String r_Pay, String cardType, String cardNom, String cardNum, String expMonth, String expYear, String cardCode, boolean term, boolean samAddress){
        searchR = homePage.goTobuscarProducto(producto);

        shopCart = searchR.addToCart(size, color, cant);

        check = shopCart.checkoutShoes(gift, country, postal, term);
        check.billingAddress(samAddress);
        check.shippingAddress();
        check.shippingMethod(r_shopp);
        check.paymentMethod(r_Pay, cardType, cardNom, cardNum, expMonth, expYear, cardCode);

        order = check.confirmOrder();
        Assert.assertTrue(order.verifyConfirmedOrder());
        Assert.assertTrue(order.datesOrderIsDisplayed());
        Assert.assertTrue(order.nameContainsProduct(producto));
        Assert.assertTrue(order.priceProduct());
        Assert.assertTrue(order.priceProductMasGift());
    }
}
