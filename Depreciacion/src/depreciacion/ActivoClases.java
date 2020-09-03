package depreciacion;

import java.util.Map;
import java.util.TreeMap;

public class ActivoClases {

    private String codigo;
    private String nombre;
    private String Ubicacion;
    private long valorActivo;
    private long valorRescate;
    private String responsable;
    private int vidaUtil;
    Map<String, ActivoClases> Activos = new TreeMap<String, ActivoClases>();

    public ActivoClases(String codigo, String nombre, String ubica, long valorActivo, long valorRescate, String responsable, int vidaUtil) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.Ubicacion = ubica;
        this.valorActivo = valorActivo;
        this.valorRescate = valorRescate;
        this.responsable = responsable;
        this.vidaUtil = vidaUtil;

    }

    @Override
    public String toString() {
        return this.codigo + "  --  " + this.nombre + "  --  " + this.Ubicacion + " -- " + this.valorActivo + " -- " + this.valorRescate + " -- " + this.responsable + " -- " + this.vidaUtil;
    }

    public String InsertarAMaps(String codigo, String nombre, String ubica, long valorActivo, long valorRescate, String responsable, int vidaUtil) {

        try{
          System.out.println("LLaves Activas"+Activos.values());
            if (Activos.containsKey(codigo)) {
                System.out.println("El Codigo ya existe");
            }else{
                Activos.put(codigo, new ActivoClases(codigo, nombre, ubica, valorActivo, valorRescate, responsable, vidaUtil));
                System.out.println("LLaves Activas"+Activos.values());
            }
        
            
               
        }catch(Exception e){
        
        }
       
        
        return "Insertado con exito";
    }

    public String validaciones(String Cod, String nombre, String ubicacion, long ValorActivoFor, long ValorRescateFor, String Responsable, int VidaUtilFor) {
        String Error = "";
        

        if (nombre.matches("[0-9]*") || nombre.isBlank()) {
            Error = "El nombre no puede ser solo numeros";
        }
        if (ubicacion.matches("[0-9]*") || ubicacion.isBlank()) {
            Error = "La ubicacion no puede ser solo numeros";
        }
        if (Responsable.matches("[0-9]*") || Responsable.isBlank()) {
            Error = "El responsable no puede ser solo numeros";
        }

        return Error;
    }
}
