package Service;

import Entity.Producto;
import Entity.Tienda;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductoService {

    ArrayList<Producto> prod = new ArrayList<>();

    Scanner sc = new Scanner(System.in).useDelimiter("\n");

    public void crear() {

        Producto product = new Producto();

        System.out.println("Ingrese el nombre del producto, por favor");
        product.setNombre(sc.next());

        System.out.println("Ingrese la categoria del producto, por favor");
        product.setCategoria(sc.next());

        System.out.println("Ingrese el precio del producto, por favor");
        product.setPrecio(sc.nextDouble());

        System.out.println("Ingrese la cantidad del producto, por favor");
        product.setCantidad(sc.nextInt());

        prod.add(product);

    }

    public void mostrar() {

        for (Producto producto : prod) {
            System.out.println(producto.toString());
        }

    }

    public void actualizar() {

        System.out.println("MENU ACTUALIZAR: ");
        System.out.println("Ingrese opcion que quiere actualizar: \n"
                + "1. Nombre \n"
                + "2. Categoría \n"
                + "3. Precio \n"
                + "4. Stock");
        int actualizacion = sc.nextInt();

        switch (actualizacion) {
            case 1:
                actualizarNombre();
                break;
            case 2:
                actualizarCategoria();
                break;
            case 3:
                actualizarPrecio();
                break;
            case 4:
                actualizarCantidad();
                break;
            default:
                throw new AssertionError();
        }

    }

    public void actualizarNombre() {

        System.out.println("De que producto desea actualizar el nombre?");
        String nombreActualizar = sc.next();

        for (Producto producto : prod) {
            if (producto.getNombre().equalsIgnoreCase(nombreActualizar)) {

                System.out.println("Ingrese nuevo nombre del producto");
                String newNombre = sc.next();

                producto.setNombre(newNombre);
                System.out.println("El producto '" + nombreActualizar + "' fue cambiado a : " + newNombre);
                break; // si aca no pingo break pasa tambien al siguiente if negativo
            }
            if (!producto.getNombre().equalsIgnoreCase(nombreActualizar)) {
                System.out.println("El producto " + nombreActualizar + " no pudo ser actualizado");
            }
        }
    }

    public void actualizarCategoria() {

        System.out.println("De que producto desea actualizar la categoría?");
        String nombreActualizar = sc.next();
        

        for (Producto producto : prod) {
            if (producto.getNombre().equalsIgnoreCase(nombreActualizar)) {

                String categoriaAnterior = producto.getCategoria();
                
                System.out.println("Ingrese nueva categoría del producto");
                String newCategoria = sc.next();

                producto.setCategoria(newCategoria);
                System.out.println("El producto '" + nombreActualizar + "' que se encontraba en la categoría '" + categoriaAnterior + "' fue cambiado a la categoria: " + newCategoria);
                break; // si aca no pingo break pasa tambien al siguiente if negativo
            }
            if (!producto.getNombre().equalsIgnoreCase(nombreActualizar)) {
                System.out.println("El producto '" + nombreActualizar + "' no pudo ser actualizado");
            }
        }
    }

    public void actualizarPrecio() {

        System.out.println("De que producto desea actualizar el precio?");
        String nombreActualizar = sc.next();

        for (Producto producto : prod) {
            if (producto.getNombre().equalsIgnoreCase(nombreActualizar)) {

                double precioAnterior = producto.getPrecio();
                
                System.out.println("Ingrese nuevo precio del producto");
                double newPrecio = sc.nextDouble();

                producto.setPrecio(newPrecio);
                System.out.println("El producto '" + nombreActualizar + "' cuyo precio era '" + precioAnterior + "' ahora vale: " + newPrecio);
                break; // si aca no pingo break pasa tambien al siguiente if negativo
            }
            if (!producto.getNombre().equalsIgnoreCase(nombreActualizar)) {
                System.out.println("El producto '" + nombreActualizar + "' no pudo ser actualizado");
            }
        }
    }

    public void actualizarCantidad() {

     System.out.println("De que producto desea actualizar la cantidad?");
        String nombreActualizar = sc.next();

        for (Producto producto : prod) {
            if (producto.getNombre().equalsIgnoreCase(nombreActualizar)) {

                int cantidadAnterior = producto.getCantidad();
                
                System.out.println("Ingrese nueva cantidad del producto");
                int newCantidad = sc.nextInt();

                producto.setCantidad(newCantidad);
                System.out.println("El producto '" + nombreActualizar + "' cuya cantidad era '" + cantidadAnterior + "' unidades, ahora tiene: " + newCantidad  + " unidades");
                
                break; // si aca no pongo break pasa tambien al siguiente if negativo
            }
            if (!producto.getNombre().equalsIgnoreCase(nombreActualizar)) {
                System.out.println("El producto '" + nombreActualizar + "' no pudo ser actualizado");
            }
        }
    }

    public void eliminar() {

        System.out.println("Que producto desea eliminar?");
        String prodEliminar = sc.next();

        for (Producto producto : prod) {
            if (producto.getNombre().equalsIgnoreCase(prodEliminar)) {
                prod.remove(producto);  // Asi elimina el producto, item
                // prod.remove(prodEliminar); // Asi me baja de a uno la cantidad
                System.out.println("El producto '" + prodEliminar + "' ha sido eliminado con éxito");
                break;
            }
            if (!producto.getNombre().equalsIgnoreCase(prodEliminar)) {
                System.out.println("El producto '" + prodEliminar + "' no ha podido ser eliminado");
            }
        }

    }

//        public void buscarEliminar(String varElegido) {
//        // Uso el iterador, porque si uso FOREACH da error
//        Iterator<PersonaArrayList> it = nuevaLista.iterator();
//        while (it.hasNext()) {
//            if (it.next().getApellido().equals(varElegido)) { // Si se cumple la condicion de encontrar "Ese apellido elegido,lo elimina)
//                it.remove();
//            }
//        }
//    }
    
    public void menu() {

        int menuPpal = 0;

        Tienda nuevaTienda = new Tienda(prod);

        nuevaTienda.mostrarProducto();

        nuevaTienda.mostrarProducto();

        do {

            int tamanioLista = prod.size();

            String opciones = "Ingrese opcion: \n";
            String model1 = "1. Agregar producto\n";
            String model2 = !(tamanioLista > 0) ? "" : "2. Obtener Productos \n3. Actualizar Productos \n4. Eliminar Productos \n5. Vender Productos \n6. Reponer Productos";

            // 'Operador ternario' funciona 1ra parte hasta ? como el if, hasta los : si es true, hceme esto
            // Despues : es como un else, sino haceme esto otro
            System.out.println(opciones + model1 + model2);

            menuPpal = sc.nextInt();

            switch (menuPpal) {
                case 1:
                    crear();
                    break;
                case 2:
                    mostrar();
                    break;
                case 3:
                    actualizar();
                    break;
                case 4:
                    eliminar();
                    break;
                case 5:
                    nuevaTienda.venta();
                    break;
                case 6:
                    nuevaTienda.reposición();

                    break;

                case 7:
                    System.exit(0);  // Para salir del menu
                    break;

                default:
                    System.out.println("Ingrese una opción correcta, por favor (1 a 7)");
            }

        } while (menuPpal > 0 && menuPpal < 8);

    }

}
