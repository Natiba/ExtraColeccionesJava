package Entity;

import java.util.ArrayList;
import java.util.Scanner;

public class Tienda {

    ArrayList<Producto> productosTienda;
    Scanner sc;

    public Tienda(ArrayList<Producto> productosRecibidos) {

        productosTienda = productosRecibidos;
        sc = new Scanner(System.in).useDelimiter("\n");

    }

    public boolean venta() {

        System.out.println("Ingresar nombre producto a buscar");
        String prodIngresado = sc.next();

        for (Producto producto : productosTienda) {
            if (producto.getNombre().equalsIgnoreCase(prodIngresado)) {

                decrementar(producto);
                return true;
            }

        }
        System.out.println("El producto no existe");
        return false;
    }

    public void decrementar(Producto p) {

        if (p.getCantidad() > 0) {
            p.setCantidad(p.getCantidad() - 1);
        }

    }

    public void reposición() {

        boolean flag = false;

        System.out.println("Ingresar nombre producto a reponerr");
        String prodReponer = sc.next();

        for (Producto producto : productosTienda) {
            if (producto.getNombre().equalsIgnoreCase(prodReponer)) {
                incrementar(producto);
                flag = true;
            }

        }

        if (flag == false) {
            System.out.println("El producto no existe");
        }
    }

    public void incrementar(Producto p) {

        p.setCantidad(p.getCantidad() + 1);

    }

    public void mostrarProducto() {

        for (Producto producto : productosTienda) {
            System.out.println(producto.toString());
        }

    }

}

//La clase Tienda contendrá además los siguientes métodos:
//Método venta(): El usuario ingresa el nombre del producto que quiere comprar y se lo busca en el ArrayList. 
//Si está en el ArrayList, se llama con ese objeto Producto al método. El método se decrementa de a uno, como un 
//carrito de compras, el atributo cantidad en inventario, del producto que ingresó el usuario. 
//Esto sucederá cada vez que se realice una venta del producto. No se podrán vender productos de los que no 
//queden inventario disponible para vender. Devuelve true si se ha podido realizar la operación y false en caso 
//contrario.
//Método reposición(): El usuario ingresa el nombre del producto que quiere reponer y se lo busca en el ArrayList. 
//Si está en el ArrayList, se llama con ese objeto al método. El método incrementa de a uno, como un carrito de 
//compras, el atributo cantidad en inventario, del producto seleccionado por el usuario. 
//Esto sucederá cada vez que se produzca una reposición de un producto.
//Método toString para mostrar los datos de los productos.
