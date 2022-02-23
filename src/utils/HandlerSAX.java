package utils;

import org.xml.sax.*;
import org.xml.sax.helpers.*;

import java.util.ArrayList;
import java.util.List;

public class HandlerSAX extends DefaultHandler {

    private static final String TABULACION = "       ";
    private static final int LONGITUD =30;
    List<String> productList=new ArrayList<>();
    String[] miLista = new String[4];

    @Override
    public void startDocument(){
        //System.out.println("Comienzo del documento XML");
    }
    @Override
    public void endDocument(){
        //System.out.println("Fin del documento XML");
    }
    @Override
    public void startElement(String uri, String nombre, String nombreC, Attributes att){
        //System.out.println("<"+nombreC+">");
        StringBuilder sb = new StringBuilder();
        sb.append(nombreC);
        sb.append(TABULACION);
        System.out.println(sb);
    }
    @Override
    public void endElement(String uri, String nombre, String nombreC){
        //System.out.println("Fin del elemento "+nombreC);
    }
    @Override
    public void characters (char[] ch, int inicio, int longitud)
            throws SAXException{
        /*String cad = new String(ch, inicio, longitud);
        cad = cad.replaceAll("[\t\n]",""); // Quitamos tabuladores y saltos de linea
        System.out.println("\t\t" + cad);*/
        StringBuilder sb = new StringBuilder();
        sb.append(new String (ch,inicio,longitud));
        sb.append(TABULACION);
        System.out.println(sb);
    }

    public static String rellenarString(int longitudDeseada,String cadena){
        while(cadena.length() < longitudDeseada){
            cadena += " ";
        }
        return cadena;
    }
}
/*
package utils;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class GestorEventos extends DefaultHandler{
    private int nivel=0;
    private int nivelArray=0;
    private StringBuilder builder = new StringBuilder();
    private String[] array = new String[4];
    private List<String> elementos = new ArrayList<>();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if(nivel>1 && nivelArray<4) {
        	array[nivelArray]=qName;
        	nivelArray++;
        }
        nivel++;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        nivel--;
    }

    @Override
    public void characters(char ch[], int start, int length) throws SAXException {
        String string=new String(ch, start, length);
        if (!(string.trim().length() == 0))
        	elementos.add(string);
    }

	public String getTabla() {
		for (String string : array) {
			builder.append(String.format("%-20s", string.toUpperCase().charAt(0)+string.substring(1)));
		}
		builder.append(System.lineSeparator());
		builder.append("-".repeat(80));
		builder.append(System.lineSeparator());
		for (int i = 1; i <= elementos.size(); i++) {
			builder.append(String.format("%-20s", elementos.get(i-1)));
			if (i%4==0)
				builder.append(System.lineSeparator());
		}
		return builder.toString();
	}
}
 */
