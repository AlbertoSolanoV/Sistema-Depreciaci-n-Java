/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package depreciacion;

import java.util.HashSet;
import javax.xml.parsers.ParserConfigurationException;

/**
 *
 * @author berna
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParserConfigurationException {
       Principal ventana=new Principal();
       ventana.setTitle("Control de Activos");
    ventana.setSize(1100,700);
      ventana.setLocationRelativeTo(null);
      ventana.setVisible(true);
    
    }
    
}
