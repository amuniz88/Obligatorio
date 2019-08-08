package objects;

public class Order {

    private static int pos;
    private static int numOrder;
    private static String nombre;
    private static double precio;
    private static int cantidad;
    private static boolean gift;

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        Order.pos = pos;
    }

    public int getNumOrder() {
        return numOrder;
    }

    public void setNumOrder(int numOrder) {
        Order.numOrder = numOrder;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        Order.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public boolean getGift() {
        return gift;
    }

    public void setGift(boolean gift) {
        this.gift = gift;
    }

    public Order(){}
}
