
package Entity;

public class Producto {
    
    private String nombre;
    private String categoria;
    private double precio;
    private int cantidad;

    public Producto() {
    }

    public Producto(String nombre, String categoria, double precio, int cantidad) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Producto { \n" + "nombre: " + nombre + "\n"  + "categoria: " + categoria + "\n"  + "precio: " + precio +"\n"  +  "cantidad: " + cantidad + "\n}";
    }
    
    
    
}

// Para ello, se debe crear una clase llamada Producto que guarde la información de cada uno de los productos 
//de la tienda. La clase Producto debe guardar el nombre del producto, la categoría, el precio y la cantidad en 
//inventario.