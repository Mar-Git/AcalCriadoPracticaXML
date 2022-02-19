package utils;

import clases.Producto;
import org.w3c.dom.*;
import org.xml.sax.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import java.io.*;
import java.util.*;
import java.util.logging.*;

public abstract class UtilidadesXML {

    public static Document generarDOMXML(List<Producto> listProducto){
        Document doc=null;
        try {
            doc=((DocumentBuilderFactory.newInstance()).newDocumentBuilder()).newDocument();
            doc.setXmlVersion("1.0");
            Element elProductos = doc.createElement("productos");
            doc.appendChild(elProductos);
            for (Producto producto:listProducto) {
                cargarProductos(doc, elProductos, producto);
            }
        } catch (ParserConfigurationException e) {
            System.err.println(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return doc;
    }

     public static void serializaDOMXML(Document doc, String archivo){
        try{
            DOMSource domSource = new DOMSource(doc);
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.METHOD, "xml");
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            inicializarArchivoXML(archivo, domSource, transformer);
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
     }

    private static void inicializarArchivoXML(String archivo, DOMSource domSource, Transformer transformer) throws IOException, TransformerException {
        FileWriter fw = new FileWriter(archivo);
        StreamResult sr = new StreamResult(fw);
        transformer.transform(domSource, sr);
    }


    private static void cargarProductos(Document doc, Element elProductos, Producto producto) {
        Element elProducto,elStock,elDescripcion,elPrecio;
        elProducto= doc.createElement("producto");
        elProducto.setAttribute("id", String.valueOf(producto.getId()));
        elDescripcion= doc.createElement("descripcion");
        elDescripcion.appendChild(doc.createTextNode(producto.getDescripcion()));
        elProducto.appendChild(elDescripcion);
        elPrecio= doc.createElement("precio");
        elPrecio.appendChild(doc.createTextNode( String.valueOf(producto.getPrecio())));
        elProducto.appendChild(elPrecio);
        elStock= doc.createElement("stock");
        elStock.appendChild(doc.createTextNode( String.valueOf(producto.getStock())));
        elProducto.appendChild(elStock);
        elProductos.appendChild(elProducto);
    }

    public static void imprimirXMLSAX(String nombreFichero) {
        File xmlFile = new File( nombreFichero );
        HandlerSAX gestor;
        XMLReader procesadorXML=null;
        InputSource archivoXML;
        try {
            SAXParserFactory parserFactory = SAXParserFactory.newInstance();
            SAXParser parser = parserFactory.newSAXParser();
            procesadorXML = parser.getXMLReader();
            gestor = new HandlerSAX();
            procesadorXML.setContentHandler(gestor);
            archivoXML = new InputSource(nombreFichero);
            procesadorXML.parse(archivoXML);
        } catch (SAXException ex) {
            Logger.getLogger(UtilidadesXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(UtilidadesXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
