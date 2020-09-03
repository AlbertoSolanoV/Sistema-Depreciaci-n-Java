package depreciacion;

import java.nio.channels.FileChannel;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import java.io.IOException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
import java.nio.file.CopyOption;
import java.nio.file.StandardCopyOption;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;
import depreciacion.ArchivoClase;
import java.util.ArrayList;

public class ArchivoClase {

    JTable tbla;
    public static DefaultTableModel modeloClase;
    public String ArchTemporal;
    public String cod;
    public String nom;
    public String ubicacion;
    public String valorAct;
    public String valorRes;
    public String Responsable;
    public String vidaUtil;
    public String AcumuladaDepre;
    public String depre1;
    public String depre2;
    public String depre3;
    public String depre4;
    public String depre5;
    public long[] Deprelista = new long[6];
    public String[] ListaATablaXML = new String[7];
    public boolean primera = true;
    public String RutaArchivo;
    public String rutaArchivovieja;
    long valoractivolong;
    long valorreslong;
    int vida;

    ActivoClases AcClase = new ActivoClases(cod, nom, ubicacion, valoractivolong, valorreslong, Responsable, vida);

    public void saveActivos(String Codigo, String Nombre, String Ubicacion, long valorAct,
            long valorResc, String responsable, int vidautil, long AcumuladoDepre)
            throws JDOMException, IOException, ParserConfigurationException,
            SAXException, TransformerConfigurationException {

        try {
            //Lectura XML
            File fXmlFile = new File(RutaArchivo);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            org.w3c.dom.Document doc = null;
            try {
                doc = dBuilder.parse(fXmlFile);
            } catch (SAXException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            //Prepara el Archivo xml para Obtener Datos
            doc.getDocumentElement().normalize();
            //Obtenemos nodo padre Nodo Padre del Documentos Control de Activos
            Node nodoRaiz = doc.getDocumentElement();
            //Agregamos Etiqueta

            //Creamos Etiqueta
            org.w3c.dom.Element nuevoActivo = doc.createElement("Activo");

            org.w3c.dom.Element nuevoCod = doc.createElement("codActivo");
            nuevoCod.setTextContent(Codigo);

            org.w3c.dom.Element nuevoNombre = doc.createElement("NomActivo");
            nuevoNombre.setTextContent(Nombre);

            org.w3c.dom.Element nuevoRespo = doc.createElement("Rsponsable");
            nuevoRespo.setTextContent(responsable);

            org.w3c.dom.Element nuevoUbicacion = doc.createElement("Ubicación");
            nuevoUbicacion.setTextContent(Ubicacion);

            org.w3c.dom.Element nuevoValorAct = doc.createElement("Valor");
            nuevoValorAct.setTextContent(String.valueOf(valorAct));

            org.w3c.dom.Element nuevaVidaUtil = doc.createElement("VidaUtil");
            nuevaVidaUtil.setTextContent(String.valueOf(vidautil));

            org.w3c.dom.Element nuevoValorResc = doc.createElement("Valor_Rescate");
            nuevoValorResc.setTextContent(String.valueOf(valorResc));

            org.w3c.dom.Element nuevoDepreAnual = doc.createElement("DepreAnual");
            nuevoDepreAnual.setTextContent(String.valueOf(Math.round(AcumuladoDepre)));

            org.w3c.dom.Element nuevoDetalle = doc.createElement("Detalle");

            org.w3c.dom.Element depre1 = doc.createElement("DepreAcumuladaAno1");
            depre1.setTextContent(String.valueOf(Math.round(Deprelista[1])));

            org.w3c.dom.Element depre2 = doc.createElement("DepreAcumuladaAno2");
            depre2.setTextContent(String.valueOf(Math.round(Deprelista[2])));

            org.w3c.dom.Element depre3 = doc.createElement("DepreAcumuladaAno3");
            depre3.setTextContent(String.valueOf(Math.round(Deprelista[3])));

            org.w3c.dom.Element depre4 = doc.createElement("DepreAcumuladaAno4");
            depre4.setTextContent(String.valueOf(Math.round(Deprelista[4])));

            org.w3c.dom.Element depre5 = doc.createElement("DepreAcumuladaAno5");
            depre5.setTextContent(String.valueOf(Math.round(Deprelista[5])));

            nuevoActivo.appendChild(nuevoCod);
            nuevoActivo.appendChild(nuevoNombre);
            nuevoActivo.appendChild(nuevoUbicacion);
            nuevoActivo.appendChild(nuevoValorAct);
            nuevoActivo.appendChild(nuevoValorResc);
            nuevoActivo.appendChild(nuevoRespo);
            nuevoActivo.appendChild(nuevaVidaUtil);
            nuevoActivo.appendChild(nuevoDepreAnual);
            nuevoActivo.appendChild(nuevoDetalle);
            nuevoDetalle.appendChild(depre1);
            nuevoDetalle.appendChild(depre2);
            nuevoDetalle.appendChild(depre3);
            nuevoDetalle.appendChild(depre4);
            nuevoDetalle.appendChild(depre5);
            //relacionar con Etiqueta ya existente
            nodoRaiz.appendChild(nuevoActivo);
            //Transformar
            TransformerFactory transFactory = TransformerFactory.newInstance();
            Transformer transformer = transFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(RutaArchivo));
            transformer.transform(source, result);
        } catch (TransformerException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void BuscarArchivo(boolean guardarcomo) {

        if (guardarcomo) {
            try {
                FileReader leer = new FileReader("Rutaxml.txt");
                BufferedReader rb = new BufferedReader(leer);

                RutaArchivo = rb.readLine();
                ArchTemporal = rb.readLine();
                rutaArchivovieja = RutaArchivo;
            } catch (Exception ex) {

                JFileChooser chooser = new JFileChooser();
                chooser.setDialogTitle("Seleccione la Carpeta");
                chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                chooser.setAcceptAllFileFilterUsed(false);

                if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                    RutaArchivo = chooser.getSelectedFile().toString();
                    ArchTemporal = chooser.getSelectedFile().toString();
                    try {
                        PrintWriter escribir = new PrintWriter("Rutaxml.txt");
                        RutaArchivo = RutaArchivo + "\\" + "Sistema_Control_de_Activos_Xml.xml";
                        ArchTemporal = ArchTemporal + "\\" + "Temporal.xml";
                        escribir.println(RutaArchivo);
                        escribir.println(ArchTemporal);
                        escribir.close();

                        FileWriter hacerxml = new FileWriter(RutaArchivo);
                        hacerxml.close();

                        CrearXML(RutaArchivo);
                        rutaArchivovieja = RutaArchivo;
                    } catch (Exception err) {
                    }
                } else {
                    System.out.println("No Selection ");
                }
            }
        } else {
            JFileChooser chooser = new JFileChooser();
            chooser.setDialogTitle("Seleccione la nueva dirección");
            chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            chooser.setAcceptAllFileFilterUsed(false);

            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                RutaArchivo = chooser.getSelectedFile().toString();
                ArchTemporal = chooser.getSelectedFile().toString();
                try {
                    File rutavieja = new File("Rutaxml.txt");
                    rutavieja.delete();
                    PrintWriter escribir = new PrintWriter("Rutaxml.txt");
                    RutaArchivo = RutaArchivo + "\\" + "Sistema_Control_de_Activos_Xml.xml";
                      escribir.println(RutaArchivo);
                    ArchTemporal = ArchTemporal + "\\" + "Temporal.xml";
                  
                    escribir.println(ArchTemporal);
                    
                    escribir.close();
                    CrearXML(RutaArchivo);
                    FileWriter hacerxml = new FileWriter(RutaArchivo);
                    hacerxml.close();
                    File vieja = new File(rutaArchivovieja);
                    File nueva = new File(RutaArchivo);
                    copiarArchivo(vieja, nueva);
                    vieja.delete();
                } catch (Exception err) {

                }

            } else {
                System.out.println("No Selection ");
            }

        }

    }

    private static void copiarArchivo(File source, File dest) throws IOException {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        } finally {
            is.close();
            os.close();
        }
    }

    private void CrearXML(String ruta) throws IOException {

        Element Activos = new Element("costarica");
        Document document = new Document(Activos);

        XMLOutputter xmlOutput = new XMLOutputter();
        xmlOutput.output(document, System.out);
        xmlOutput.setFormat(Format.getPrettyFormat());
        xmlOutput.output(document, new FileWriter(ruta));

    }

    public void readActivosXml() throws ParserConfigurationException {
        BuscarArchivo(true);
        File fXmlFile = new File(RutaArchivo);

        if (fXmlFile.length() != 230) {

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            org.w3c.dom.Document doc = null;
            try {
                doc = dBuilder.parse(fXmlFile);
            } catch (SAXException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            doc.getDocumentElement().normalize();

            System.out.println("Root elemento :" + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("Activo");
            NodeList nListDetalle = doc.getElementsByTagName("Detalle");
            System.out.println("cantidad " + nList.getLength());

            System.out.println("----------------------------");

            for (int temp = 0; temp < nList.getLength(); temp++) {

                Node nNode = nList.item(temp);
                Node nNodeDetalle = nListDetalle.item(temp);
                System.out.println("\nCurrent Element :" + nNode.getNodeName());

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    org.w3c.dom.Element eElement = (org.w3c.dom.Element) nNode;
                    org.w3c.dom.Element eElementDetalle = (org.w3c.dom.Element) nNodeDetalle;

                    cod = eElement.getElementsByTagName("codActivo").item(0).getTextContent();
                    nom = eElement.getElementsByTagName("NomActivo").item(0).getTextContent();
                    Responsable = eElement.getElementsByTagName("Rsponsable").item(0).getTextContent();
                    ubicacion = eElement.getElementsByTagName("Ubicación").item(0).getTextContent();
                    valorAct = eElement.getElementsByTagName("Valor").item(0).getTextContent();
                    vidaUtil = eElement.getElementsByTagName("VidaUtil").item(0).getTextContent();
                    valorRes = eElement.getElementsByTagName("Valor_Rescate").item(0).getTextContent();
                    AcumuladaDepre = eElement.getElementsByTagName("DepreAnual").item(0).getTextContent();
                    depre1 = eElementDetalle.getElementsByTagName("DepreAcumuladaAno1").item(0).getTextContent();
                    depre2 = eElementDetalle.getElementsByTagName("DepreAcumuladaAno2").item(0).getTextContent();
                    depre3 = eElementDetalle.getElementsByTagName("DepreAcumuladaAno3").item(0).getTextContent();
                    depre4 = eElementDetalle.getElementsByTagName("DepreAcumuladaAno4").item(0).getTextContent();
                    depre5 = eElementDetalle.getElementsByTagName("DepreAcumuladaAno5").item(0).getTextContent();

                    ListaATablaXML[0] = cod;
                    ListaATablaXML[1] = nom;
                    ListaATablaXML[2] = ubicacion;
                    ListaATablaXML[3] = valorAct;
                    ListaATablaXML[4] = valorRes;
                    ListaATablaXML[5] = Responsable;
                    ListaATablaXML[6] = vidaUtil;
                    modeloClase.addRow(ListaATablaXML);

                }
            }

        } else {
            primera = false;
        }

    }

    public void EliminarXML(String codigoEliminar) throws ParserConfigurationException, IOException {

        File fXmlFile = new File(RutaArchivo);

        File xmlTemporalruta = new File(ArchTemporal);
        //Leer el xml archivo-----------------------------------
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        org.w3c.dom.Document doc = null;
        try {
            doc = dBuilder.parse(fXmlFile);
        } catch (SAXException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        doc.getDocumentElement().normalize();

        System.out.println("Root elemento :" + doc.getDocumentElement().getNodeName());
        NodeList nList = doc.getElementsByTagName("Activo");
        NodeList nListDetalle = doc.getElementsByTagName("Detalle");
        System.out.println("cantidad " + nList.getLength());

        System.out.println("----------------------------");
        CrearXML(ArchTemporal);
        for (int temp = 0; temp < nList.getLength(); temp++) {

            Node nNode = nList.item(temp);
            Node nNodeDetalle = nListDetalle.item(temp);
            System.out.println("\nCurrent Element :" + nNode.getNodeName());

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                org.w3c.dom.Element eElement = (org.w3c.dom.Element) nNode;
                org.w3c.dom.Element eElementDetalle = (org.w3c.dom.Element) nNodeDetalle;

                cod = eElement.getElementsByTagName("codActivo").item(0).getTextContent();
                nom = eElement.getElementsByTagName("NomActivo").item(0).getTextContent();
                Responsable = eElement.getElementsByTagName("Rsponsable").item(0).getTextContent();
                ubicacion = eElement.getElementsByTagName("Ubicación").item(0).getTextContent();
                valorAct = eElement.getElementsByTagName("Valor").item(0).getTextContent();
                vidaUtil = eElement.getElementsByTagName("VidaUtil").item(0).getTextContent();
                valorRes = eElement.getElementsByTagName("Valor_Rescate").item(0).getTextContent();
                AcumuladaDepre = eElement.getElementsByTagName("DepreAnual").item(0).getTextContent();
                depre1 = eElementDetalle.getElementsByTagName("DepreAcumuladaAno1").item(0).getTextContent();
                depre2 = eElementDetalle.getElementsByTagName("DepreAcumuladaAno2").item(0).getTextContent();
                depre3 = eElementDetalle.getElementsByTagName("DepreAcumuladaAno3").item(0).getTextContent();
                depre4 = eElementDetalle.getElementsByTagName("DepreAcumuladaAno4").item(0).getTextContent();
                depre5 = eElementDetalle.getElementsByTagName("DepreAcumuladaAno5").item(0).getTextContent();

                if (cod.equals(codigoEliminar)) {

                } else {

                    try {
                        //Lectura XML
                        File FileTemporal = new File(ArchTemporal);
                        DocumentBuilderFactory dbFactoryTemporal = DocumentBuilderFactory.newInstance();
                        DocumentBuilder dBuilderTemporal = dbFactoryTemporal.newDocumentBuilder();
                        org.w3c.dom.Document docTemporal = null;
                        try {
                            docTemporal = dBuilder.parse(xmlTemporalruta);
                        } catch (SAXException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        } catch (IOException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                        //Prepara el Archivo xml para Obtener Datos
                        docTemporal.getDocumentElement().normalize();
                        //Obtenemos nodo padre Nodo Padre del Documentos Control de Activos
                        Node nodoRaizTempo = docTemporal.getDocumentElement();
                        //Agregamos Etiqueta

                        //Creamos Etiqueta
                        org.w3c.dom.Element nuevoActivo = docTemporal.createElement("Activo");

                        org.w3c.dom.Element nuevoCod = docTemporal.createElement("codActivo");
                        nuevoCod.setTextContent(cod);

                        org.w3c.dom.Element nuevoNombre = docTemporal.createElement("NomActivo");
                        nuevoNombre.setTextContent(nom);

                        org.w3c.dom.Element nuevoRespo = docTemporal.createElement("Rsponsable");
                        nuevoRespo.setTextContent(Responsable);

                        org.w3c.dom.Element nuevoUbicacion = docTemporal.createElement("Ubicación");
                        nuevoUbicacion.setTextContent(ubicacion);

                        org.w3c.dom.Element nuevoValorAct = docTemporal.createElement("Valor");
                        nuevoValorAct.setTextContent(String.valueOf(valorAct));

                        org.w3c.dom.Element nuevaVidaUtil = docTemporal.createElement("VidaUtil");
                        nuevaVidaUtil.setTextContent(String.valueOf(vidaUtil));

                        org.w3c.dom.Element nuevoValorResc = docTemporal.createElement("Valor_Rescate");
                        nuevoValorResc.setTextContent(String.valueOf(valorRes));

                        org.w3c.dom.Element nuevoDepreAnual = docTemporal.createElement("DepreAnual");
                        nuevoDepreAnual.setTextContent(AcumuladaDepre);

                        org.w3c.dom.Element nuevoDetalle = docTemporal.createElement("Detalle");

                        org.w3c.dom.Element depre1s = docTemporal.createElement("DepreAcumuladaAno1");
                        depre1s.setTextContent(depre1);

                        org.w3c.dom.Element depre2s = docTemporal.createElement("DepreAcumuladaAno2");
                        depre2s.setTextContent(depre2);

                        org.w3c.dom.Element depre3s = docTemporal.createElement("DepreAcumuladaAno3");
                        depre3s.setTextContent(depre3);

                        org.w3c.dom.Element depre4s = docTemporal.createElement("DepreAcumuladaAno4");
                        depre4s.setTextContent(depre4);

                        org.w3c.dom.Element depre5s = docTemporal.createElement("DepreAcumuladaAno5");
                        depre5s.setTextContent(depre5);

                        nuevoActivo.appendChild(nuevoCod);
                        nuevoActivo.appendChild(nuevoNombre);
                        nuevoActivo.appendChild(nuevoUbicacion);
                        nuevoActivo.appendChild(nuevoValorAct);
                        nuevoActivo.appendChild(nuevoValorResc);
                        nuevoActivo.appendChild(nuevoRespo);
                        nuevoActivo.appendChild(nuevaVidaUtil);
                        nuevoActivo.appendChild(nuevoDepreAnual);
                        nuevoActivo.appendChild(nuevoDetalle);
                        nuevoDetalle.appendChild(depre1s);
                        nuevoDetalle.appendChild(depre2s);
                        nuevoDetalle.appendChild(depre3s);
                        nuevoDetalle.appendChild(depre4s);
                        nuevoDetalle.appendChild(depre5s);
                        //relacionar con Etiqueta ya existente
                        nodoRaizTempo.appendChild(nuevoActivo);
                        //Transformar
                        TransformerFactory transFactory = TransformerFactory.newInstance();
                        Transformer transformer = transFactory.newTransformer();
                        DOMSource source = new DOMSource(docTemporal);
                        StreamResult result = new StreamResult(new File(ArchTemporal));
                        transformer.transform(source, result);
                    } catch (TransformerException ex) {
                        Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }

                //---------------------------------------------------------------------------------------      
            }
        }
        fXmlFile.delete();
        copiarArchivo(xmlTemporalruta, fXmlFile);
        xmlTemporalruta.delete();

    }

    public void ModificarXML(String codigoEliminar, String NombreNuevo, String UbicacionNuevo, long valorActNuevo,
            long valorRescNuevo, String responsableNuevo, int vidautilNuevo, long Depreciacion) throws ParserConfigurationException, IOException, TransformerException {

       File fXmlFile = new File(RutaArchivo);

        File xmlTemporalruta = new File(ArchTemporal);
        //Leer el xml archivo-----------------------------------
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        org.w3c.dom.Document doc = null;
        try {
            doc = dBuilder.parse(fXmlFile);
        } catch (SAXException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        doc.getDocumentElement().normalize();

        System.out.println("Root elemento :" + doc.getDocumentElement().getNodeName());
        NodeList nList = doc.getElementsByTagName("Activo");
        NodeList nListDetalle = doc.getElementsByTagName("Detalle");
        System.out.println("cantidad " + nList.getLength());

        System.out.println("----------------------------");
        CrearXML(ArchTemporal);
        for (int temp = 0; temp < nList.getLength(); temp++) {

            Node nNode = nList.item(temp);
            Node nNodeDetalle = nListDetalle.item(temp);
            System.out.println("\nCurrent Element :" + nNode.getNodeName());

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                org.w3c.dom.Element eElement = (org.w3c.dom.Element) nNode;
                org.w3c.dom.Element eElementDetalle = (org.w3c.dom.Element) nNodeDetalle;

                cod = eElement.getElementsByTagName("codActivo").item(0).getTextContent();
                nom = eElement.getElementsByTagName("NomActivo").item(0).getTextContent();
                Responsable = eElement.getElementsByTagName("Rsponsable").item(0).getTextContent();
                ubicacion = eElement.getElementsByTagName("Ubicación").item(0).getTextContent();
                valorAct = eElement.getElementsByTagName("Valor").item(0).getTextContent();
                vidaUtil = eElement.getElementsByTagName("VidaUtil").item(0).getTextContent();
                valorRes = eElement.getElementsByTagName("Valor_Rescate").item(0).getTextContent();
                AcumuladaDepre = eElement.getElementsByTagName("DepreAnual").item(0).getTextContent();
                depre1 = eElementDetalle.getElementsByTagName("DepreAcumuladaAno1").item(0).getTextContent();
                depre2 = eElementDetalle.getElementsByTagName("DepreAcumuladaAno2").item(0).getTextContent();
                depre3 = eElementDetalle.getElementsByTagName("DepreAcumuladaAno3").item(0).getTextContent();
                depre4 = eElementDetalle.getElementsByTagName("DepreAcumuladaAno4").item(0).getTextContent();
                depre5 = eElementDetalle.getElementsByTagName("DepreAcumuladaAno5").item(0).getTextContent();

                if (cod.equals(codigoEliminar)) {
                    try {
                        File FileTemporal = new File(ArchTemporal);
                        DocumentBuilderFactory dbFactoryTemporal = DocumentBuilderFactory.newInstance();
                        DocumentBuilder dBuilderTemporal = dbFactoryTemporal.newDocumentBuilder();
                        org.w3c.dom.Document docTemporal = null;
                        try {
                            docTemporal = dBuilder.parse(xmlTemporalruta);
                        } catch (SAXException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        } catch (IOException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                        //Prepara el Archivo xml para Obtener Datos
                        docTemporal.getDocumentElement().normalize();
                        //Obtenemos nodo padre Nodo Padre del Documentos Control de Activos
                        Node nodoRaizTempo = docTemporal.getDocumentElement();
                        //Agregamos Etiqueta

                        //Creamos Etiqueta
                        org.w3c.dom.Element nuevoActivo = docTemporal.createElement("Activo");

                        org.w3c.dom.Element nuevoCod = docTemporal.createElement("codActivo");
                        nuevoCod.setTextContent(codigoEliminar);

                        org.w3c.dom.Element nuevoNombre = docTemporal.createElement("NomActivo");
                        nuevoNombre.setTextContent(NombreNuevo);

                        org.w3c.dom.Element nuevoRespo = docTemporal.createElement("Rsponsable");
                        nuevoRespo.setTextContent(responsableNuevo);

                        org.w3c.dom.Element nuevoUbicacion = docTemporal.createElement("Ubicación");
                        nuevoUbicacion.setTextContent(UbicacionNuevo);

                        org.w3c.dom.Element nuevoValorAct = docTemporal.createElement("Valor");
                        nuevoValorAct.setTextContent(String.valueOf(valorActNuevo));

                        org.w3c.dom.Element nuevaVidaUtil = docTemporal.createElement("VidaUtil");
                        nuevaVidaUtil.setTextContent(String.valueOf(vidautilNuevo));

                        org.w3c.dom.Element nuevoValorResc = docTemporal.createElement("Valor_Rescate");
                        nuevoValorResc.setTextContent(String.valueOf(valorRescNuevo));

                        org.w3c.dom.Element nuevoDepreAnual = docTemporal.createElement("DepreAnual");
                        nuevoDepreAnual.setTextContent(String.valueOf(Depreciacion) );

                        org.w3c.dom.Element nuevoDetalle = docTemporal.createElement("Detalle");

                        org.w3c.dom.Element depre1s = docTemporal.createElement("DepreAcumuladaAno1");
                        depre1s.setTextContent(depre1);

                        org.w3c.dom.Element depre2s = docTemporal.createElement("DepreAcumuladaAno2");
                        depre2s.setTextContent(depre2);

                        org.w3c.dom.Element depre3s = docTemporal.createElement("DepreAcumuladaAno3");
                        depre3s.setTextContent(depre3);

                        org.w3c.dom.Element depre4s = docTemporal.createElement("DepreAcumuladaAno4");
                        depre4s.setTextContent(depre4);

                        org.w3c.dom.Element depre5s = docTemporal.createElement("DepreAcumuladaAno5");
                        depre5s.setTextContent(depre5);

                        nuevoActivo.appendChild(nuevoCod);
                        nuevoActivo.appendChild(nuevoNombre);
                        nuevoActivo.appendChild(nuevoUbicacion);
                        nuevoActivo.appendChild(nuevoValorAct);
                        nuevoActivo.appendChild(nuevoValorResc);
                        nuevoActivo.appendChild(nuevoRespo);
                        nuevoActivo.appendChild(nuevaVidaUtil);
                        nuevoActivo.appendChild(nuevoDepreAnual);
                        nuevoActivo.appendChild(nuevoDetalle);
                        nuevoDetalle.appendChild(depre1s);
                        nuevoDetalle.appendChild(depre2s);
                        nuevoDetalle.appendChild(depre3s);
                        nuevoDetalle.appendChild(depre4s);
                        nuevoDetalle.appendChild(depre5s);
                        //relacionar con Etiqueta ya existente
                        nodoRaizTempo.appendChild(nuevoActivo);
                        //Transformar
                        TransformerFactory transFactory = TransformerFactory.newInstance();
                        Transformer transformer = transFactory.newTransformer();
                        DOMSource source = new DOMSource(docTemporal);
                        StreamResult result = new StreamResult(new File(ArchTemporal));
                        transformer.transform(source, result);
                           } catch (TransformerException ex) {
                        Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                        }
                } else {

                    try {
                        //Lectura XML
                        File FileTemporal = new File(ArchTemporal);
                        DocumentBuilderFactory dbFactoryTemporal = DocumentBuilderFactory.newInstance();
                        DocumentBuilder dBuilderTemporal = dbFactoryTemporal.newDocumentBuilder();
                        org.w3c.dom.Document docTemporal = null;
                        try {
                            docTemporal = dBuilder.parse(xmlTemporalruta);
                        } catch (SAXException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        } catch (IOException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                        //Prepara el Archivo xml para Obtener Datos
                        docTemporal.getDocumentElement().normalize();
                        //Obtenemos nodo padre Nodo Padre del Documentos Control de Activos
                        Node nodoRaizTempo = docTemporal.getDocumentElement();
                        //Agregamos Etiqueta

                        //Creamos Etiqueta
                        org.w3c.dom.Element nuevoActivo = docTemporal.createElement("Activo");

                        org.w3c.dom.Element nuevoCod = docTemporal.createElement("codActivo");
                        nuevoCod.setTextContent(cod);

                        org.w3c.dom.Element nuevoNombre = docTemporal.createElement("NomActivo");
                        nuevoNombre.setTextContent(nom);

                        org.w3c.dom.Element nuevoRespo = docTemporal.createElement("Rsponsable");
                        nuevoRespo.setTextContent(Responsable);

                        org.w3c.dom.Element nuevoUbicacion = docTemporal.createElement("Ubicación");
                        nuevoUbicacion.setTextContent(ubicacion);

                        org.w3c.dom.Element nuevoValorAct = docTemporal.createElement("Valor");
                        nuevoValorAct.setTextContent(String.valueOf(valorAct));

                        org.w3c.dom.Element nuevaVidaUtil = docTemporal.createElement("VidaUtil");
                        nuevaVidaUtil.setTextContent(String.valueOf(vidaUtil));

                        org.w3c.dom.Element nuevoValorResc = docTemporal.createElement("Valor_Rescate");
                        nuevoValorResc.setTextContent(String.valueOf(valorRes));

                        org.w3c.dom.Element nuevoDepreAnual = docTemporal.createElement("DepreAnual");
                        nuevoDepreAnual.setTextContent(AcumuladaDepre);

                        org.w3c.dom.Element nuevoDetalle = docTemporal.createElement("Detalle");

                        org.w3c.dom.Element depre1s = docTemporal.createElement("DepreAcumuladaAno1");
                        depre1s.setTextContent(depre1);

                        org.w3c.dom.Element depre2s = docTemporal.createElement("DepreAcumuladaAno2");
                        depre2s.setTextContent(depre2);

                        org.w3c.dom.Element depre3s = docTemporal.createElement("DepreAcumuladaAno3");
                        depre3s.setTextContent(depre3);

                        org.w3c.dom.Element depre4s = docTemporal.createElement("DepreAcumuladaAno4");
                        depre4s.setTextContent(depre4);

                        org.w3c.dom.Element depre5s = docTemporal.createElement("DepreAcumuladaAno5");
                        depre5s.setTextContent(depre5);

                        nuevoActivo.appendChild(nuevoCod);
                        nuevoActivo.appendChild(nuevoNombre);
                        nuevoActivo.appendChild(nuevoUbicacion);
                        nuevoActivo.appendChild(nuevoValorAct);
                        nuevoActivo.appendChild(nuevoValorResc);
                        nuevoActivo.appendChild(nuevoRespo);
                        nuevoActivo.appendChild(nuevaVidaUtil);
                        nuevoActivo.appendChild(nuevoDepreAnual);
                        nuevoActivo.appendChild(nuevoDetalle);
                        nuevoDetalle.appendChild(depre1s);
                        nuevoDetalle.appendChild(depre2s);
                        nuevoDetalle.appendChild(depre3s);
                        nuevoDetalle.appendChild(depre4s);
                        nuevoDetalle.appendChild(depre5s);
                        //relacionar con Etiqueta ya existente
                        nodoRaizTempo.appendChild(nuevoActivo);
                        //Transformar
                        TransformerFactory transFactory = TransformerFactory.newInstance();
                        Transformer transformer = transFactory.newTransformer();
                        DOMSource source = new DOMSource(docTemporal);
                        StreamResult result = new StreamResult(new File(ArchTemporal));
                        transformer.transform(source, result);
                    } catch (TransformerException ex) {
                        Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }

                //---------------------------------------------------------------------------------------      
            }
        }
        fXmlFile.delete();
        copiarArchivo(xmlTemporalruta, fXmlFile);
        xmlTemporalruta.delete();
    }

   
}
