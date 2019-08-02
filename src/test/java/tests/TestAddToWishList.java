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

    @Test(dataProvider = "DP_SendEmail", dataProviderClass = DPGeneral.class)
    public void sendEmailToFriend(String email, String msg, String contenido, boolean correcto){
        wishList = homePage.goToWishList();

        emailToFriend = wishList.clickSendEmailToFriend();
        emailToFriend.sendEmailToFriend(email, msg);

        Assert.assertTrue(emailToFriend.subTitleIsDisplayed());
        Assert.assertTrue(emailToFriend.subTitleContains(""));
        //Asserts dobles dependiendo del contenido del DataProvider.  Se prueba envío incorrecto y envío correcto
        Assert.assertTrue(emailToFriend.messageReturnIsDisplayed(correcto));
        Assert.assertTrue(emailToFriend.messageReturnContains(contenido, correcto));

        homePage.clickToLogout();
    }
}
