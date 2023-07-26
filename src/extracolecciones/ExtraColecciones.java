package extracolecciones;

import Entity.Producto;
import Entity.Tienda;
import Service.ProductoService;
import java.util.ArrayList;
import java.util.Scanner;

public class ExtraColecciones {

    public static void main(String[] args) {

        ProductoService prodS = new ProductoService();

        prodS.menu();

    }

}

//En el main, se creará un ArrayList de tipo Producto que guardará todos los productos creados. 
//A continuación, tendrás que crear un bucle que solicite al usuario los datos de cada producto 
//y los setee en el objeto Producto correspondiente, que se agregará al ArrayList.
//Aclaración:
//Se debe realizar un CRUD para los productos (Crear, Leer, Modificar o Eliminar)
//Podrás crear los métodos que sean necesarios para que el programa sea más completo.
