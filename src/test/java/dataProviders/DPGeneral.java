package dataProviders;

import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;

public class DPGeneral {

    @DataProvider(name = "DP_Usuario")
    public Object[][] dpUsuario(){
        return new Object[][]{
            {"e.muvida6@gmail.com", "F", "Emilia", "Muvida", "15", "3", "1999", "Savatcom", "123456", "123456", false}
        };
    }

    @DataProvider(name = "DP_Producto")
    public Object[][] dpProducto(Method method){
        Object[][] datos = null;
        if(method.getName().equalsIgnoreCase("checkoutEfectivo")) {
            datos = new Object[][]{
                    {"adidas", "22", "azul", "2", "1", "235", "21654", "1", "2", "visa", "Bestcard", "4348630111063811", "6", "2025", "202", true, false, "Montevideo", "18 de Julio 123", "20202", "098989898"}
            };
        }else if(method.getName().equalsIgnoreCase("checkoutTarjeta")){
            datos = new Object[][]{
                    {"Hat", "36", "", "1", "2", "235", "21654", "1", "1", "visa", "Bestcard", "4348630111063811", "6", "2025", "202", true, false, "Montevideo", "18 de Julio 123", "20202", "098989898"}
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
                    {"1234567", "1234567", "1234567", "You entered the password that is the same as one of the last passwords you used. Please create a new password.", false},
                    {"1234567", "12345678", "1234567", "Password was changed", true}
            };
        }else if(method.getName().equalsIgnoreCase("modifyUserInfo")){
            datos = new Object[][]{
                    {"1", "4", "2000"}
            };
        }else if(method.getName().equalsIgnoreCase("addUserAddress")){
            datos = new Object[][]{
                    {"Emilia", "Muvida", "e.muvida@gmail.com", "235", "Colonia", "Calle 1", "32155", "098989898"}
            };
        }
        return datos;
    }

    @DataProvider(name = "DP_SendEmail")
    public Object[][] dpSendEmail(Method method){
        Object[][] datos = null;
        if(method.getName().equalsIgnoreCase("sendEmailToFriend")){
            datos = new Object[][]{
                    {"", "Estimado, buenas tardes.  Le comparto mi WishList", "Enter friend's email", false},
                    {"obligatorio.bios@gmail.com", "Estimado, buenas tardes.  Le comparto mi WishList", "Your message has been sent.", true}
            };
        }
        return datos;
    }

    @DataProvider(name = "DP_ContactUs")
    public Object[][] dpContactUs(Method method){
        Object[][] datos = null;
        if(method.getName().equalsIgnoreCase("contactUs")){
            datos = new Object[][]{
                    {"", "Enter enquiry", false},
                    {"Buenas tardes, mensaje a quien corresponda y/o administre esta página.  Mensaje Test", "Your enquiry has been successfully sent to the store owner.", true}
            };
        }
        return datos;
    }
}
