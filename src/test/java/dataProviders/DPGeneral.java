package dataProviders;

import org.testng.annotations.DataProvider;

public class DPGeneral {

    @DataProvider(name = "DP_Usuario")
    public Object[][] dpUsuario(){
        return new Object[][]{
            {"s.savat@gmail.com", "F", "Silvia", "Savat", "15", "3", "1999", "Savatcom", "123456", "123456", false}
        };
    }

    @DataProvider(name = "DP_Producto")
    public Object[][] dpProducto(){
        return new Object[][]{
            {"Shoes", "22", "azul", "2", "1", "234", "21654", "1", "2", "visa", "Bestcard", "4348630111063811", "6", "2025", "202", true, false}
        };
    }
}
