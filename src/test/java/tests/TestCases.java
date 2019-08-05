package tests;

import dataProviders.DPGeneral;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCases extends BaseTestWhitLogin{

    @Test(dataProvider = "DP_Producto", dataProviderClass = DPGeneral.class)
    public void checkoutEfectivo(String producto, String size, String color, String gift, String cant, String country, String postal, String r_shopp, String r_Pay, String cardType, String cardNom, String cardNum, String expMonth, String expYear, String cardCode, boolean term, boolean samAddress, String city, String address, String postalCode, String phone){
        searchR = homePage.goTobuscarProducto(producto);

        prodDet = searchR.selectProd(producto);

        shopCart = prodDet.addToCart(size, color, cant);

        check = shopCart.checkoutProd(gift, country, postal, term);
        check.billingAddress(samAddress, country, city, address, postalCode, phone);
        check.shippingAddress();
        check.shippingMethod(r_shopp);
        check.paymentMethod(r_Pay, cardType, cardNom, cardNum, expMonth, expYear, cardCode);
        order = check.confirmOrder();

        Assert.assertTrue(order.verifyConfirmedOrder());
        Assert.assertTrue(order.datesOrderIsDisplayed());
        Assert.assertTrue(order.nameContainsProduct(producto));
        Assert.assertTrue(order.priceProduct());
        Assert.assertTrue(order.priceProductMasGift());

        homePage.clickToLogout();
    }

    @Test(dataProvider = "DP_Producto", dataProviderClass = DPGeneral.class)
    public void checkoutTarjeta(String producto, String size, String color, String gift, String cant, String country, String postal, String r_shopp, String r_Pay, String cardType, String cardNom, String cardNum, String expMonth, String expYear, String cardCode, boolean term, boolean samAddress, String city, String address, String postalCode, String phone){
        searchR = homePage.goTobuscarProducto(producto);
        prodDet = searchR.selectProd(producto);
        shopCart = prodDet.addToCart(size, color, cant);

        check = shopCart.checkoutProd(gift, country, postal, term);
        check.billingAddress(samAddress, country, city, address, postalCode, phone);
        check.shippingAddress();
        check.shippingMethod(r_shopp);
        check.paymentMethod(r_Pay, cardType, cardNom, cardNum, expMonth, expYear, cardCode);
        order = check.confirmOrder();

        Assert.assertTrue(order.verifyConfirmedOrder());
        Assert.assertTrue(order.datesOrderIsDisplayed());
        Assert.assertTrue(order.nameContainsProduct(producto));
        Assert.assertTrue(order.priceProduct());
        Assert.assertTrue(order.priceProductMasGift());

        homePage.clickToLogout();
    }
}
