package main;

import clases.Producto;
import org.w3c.dom.*;
import utils.UtilidadesXML;

import javax.print.Doc;
import java.lang.annotation.Documented;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static List<Producto> listProducto= new ArrayList<>();
    private static String archivo ="productos.xml";
    private static Document doc;
    public static void main(String[] args) {
        //crearListaProductos();
        //generarDOMXMLConListaProductos();
        //serializarDOMXML();
        UtilidadesXML.imprimirXMLSAX(archivo);
    }

    private static void crearListaProductos(){
        Producto producto=new Producto(2344,"Pasta térmica 4g", 6,36);
        listProducto.add(producto);
        producto=new Producto(1098,"Placa base Asus",150,14);
        listProducto.add(producto);
        producto=new Producto(7643,	"Amd Ryzen 9", 6,560);
        listProducto.add(producto);
    }
    private static void generarDOMXMLConListaProductos(){
        doc=UtilidadesXML.generarDOMXML(listProducto);
    }

    private static void serializarDOMXML(){
        UtilidadesXML.serializaDOMXML(doc,archivo);
    }

}
