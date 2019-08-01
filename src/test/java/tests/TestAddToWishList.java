package tests;

import dataProviders.DPGeneral;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestAddToWishList extends BaseTestWhitLogin {

    @Test(dataProvider = "DP_ProductList", dataProviderClass = DPGeneral.class)
    public void addToWishList(String object, String prodItem1, String prodItem2){
        searchR = homePage.goTobuscarProducto(object);
        searchR.addToWishList(prodItem1);
        searchR.addToWishList(prodItem2);

        wishList = homePage.goToWishList();

        Assert.assertTrue(wishList.elementsInToList());
        Assert.assertTrue(wishList.verifyItemsInList(prodItem1));
        Assert.assertTrue(wishList.verifyItemsInList(prodItem2));
        Assert.assertTrue(wishList.verifyPriceTotalProduct(prodItem1));
        Assert.assertTrue(wishList.verifyPriceTotalProduct(prodItem2));

        homePage.clickToLogout();
    }
}
