package dataProviders;

import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;

public class DPGeneral {

    @DataProvider(name = "DP_Usuario")
    public Object[][] dpUsuario(){
        return new Object[][]{
            {"s.savat@gmail.com", "F", "Silvia", "Savat", "15", "3", "1999", "Savatcom", "123456", "123456", false}
        };
    }

    @DataProvider(name = "DP_Producto")
    public Object[][] dpProducto(Method method){
        Object[][] datos = null;
        if(method.getName().equalsIgnoreCase("checkoutEfectivo")) {
            datos = new Object[][]{
                    {"adidas", "22", "azul", "2", "1", "234", "21654", "1", "2", "visa", "Bestcard", "4348630111063811", "6", "2025", "202", true, false}
            };
        }else if(method.getName().equalsIgnoreCase("checkoutTarjeta")){
            datos = new Object[][]{
                    {"Hat", "36", "", "1", "2", "234", "21654", "1", "1", "visa", "Bestcard", "4348630111063811", "6", "2025", "202", true, false}
            };
        }
        return datos;
    }

    @DataProvider(name = "DP_ProductList")
    public Object[][] dpProductList(Method method){
        Object[][] datos = null;
        if(method.getName().equalsIgnoreCase("addToWishList") || method.getName().equalsIgnoreCase("compareProduct")){
            datos = new Object[][]{
                    {"Digital", "VANQUISH", "Leica"},
                    {"Laptop", "Asus", "Lenovo"},
                    {"Sound", "Speaker", "Forge"},
                    {"Book", "HP", "Samsung"},
                    {"HTC", "M8", "Blue"}
            };
        }
        return datos;
    }

    @DataProvider(name = "DP_MyAccount")
    public Object[][] dpMyAccount(Method method){
        Object[][] datos = null;
        if(method.getName().equalsIgnoreCase("changePassword")){
            datos = new Object[][]{
                    {"123", "222222", "222222", "Old password doesn't match", false},
                    {"123456", "123456", "123456", "You entered the password that is the same as one of the last passwords you used. Please create a new password.", false},
                    {"123456", "1234567", "1234567", "Password was changed", true}
            };
        }else if(method.getName().equalsIgnoreCase("modifyUserInfo")){
            datos = new Object[][]{
                    {"1", "4", "2000"}
            };
        }else if(method.getName().equalsIgnoreCase("addUserAddress")){
            datos = new Object[][]{
                    {"Silvia", "Savat", "s.savat@gmail.com", "235", "Colonia", "Calle 1", "32155", "098989898"}
            };
        }
        return datos;
    }
}
