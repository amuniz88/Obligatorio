package tests;

import dataProviders.DPGeneral;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCompareProduct extends BaseTestWhitLogin{

    @Test(dataProvider = "DP_ProductList", dataProviderClass = DPGeneral.class)
    public void compareProduct(String producto, String item1, String item2){
        searchR = homePage.goTobuscarProducto(producto);
        searchR.addToCompareList(item1);
        searchR.addToCompareList(item2);

        compareList = homePage.goToCompareList();

        Assert.assertTrue(compareList.verifyItemsNameInList(item1));
        Assert.assertTrue(compareList.verifyItemsNameInList(item2));
        Assert.assertTrue(compareList.cantItemsinList());
        Assert.assertTrue(compareList.subtitleContains("Compare products"));
        Assert.assertTrue(compareList.subTitleIsDisplayed());

        homePage.clickToLogout();
    }

}
