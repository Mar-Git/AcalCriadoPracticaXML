package utils;

import org.xml.sax.*;
import org.xml.sax.helpers.*;

import java.util.ArrayList;
import java.util.List;

public class HandlerSAX extends DefaultHandler {
    private int indicadorFila =0;
    private int indicadorColum =0;
    private StringBuilder builder = new StringBuilder();
    private String[] filaTabla = new String[4];
    private List<String> elementos = new ArrayList<>();

    @Override
    public void startElement(String uri, String localName, String nombreEtiqueta, Attributes attributes) throws SAXException {
        if(attributes.getLength()>0){
            elementos.add(attributes.getValue(0));
        }
        if(indicadorFila >=1 && indicadorColum <4) {
            if(indicadorColum==0 && attributes.getLength()>0){
                filaTabla[indicadorColum]=attributes.getLocalName(0);
            }
            else{
                filaTabla[indicadorColum]=nombreEtiqueta;
            }
            indicadorColum++;
        }
        indicadorFila++;
    }

    @Override
    public void endDocument(){
        System.out.println(getTabla());
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        indicadorFila--;
    }

    @Override
    public void characters(char ch[], int start, int length) throws SAXException {
        String cadena=new String(ch, start, length);
        if (!(cadena.trim().length() == 0))
            elementos.add(cadena);
    }

    public String getTabla() {
        for (String string : filaTabla) {
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
