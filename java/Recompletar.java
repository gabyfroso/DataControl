import java.util.ArrayList;

public class Recompletar {

    private static int NumeroLineas;
    static ArrayList<String> nombres_generales = new ArrayList<String>();
    static ArrayList<String> direcciones_carpetas_generales = new ArrayList<String>();
    private static String directorio_src;
    private static String direcciones_generales;

    String Directorio_general;

    /*
     * Estructura del archivo direccion es la siguiente:
     * Direccion: ruta\ruta\archivo.txt
     * 
     * archivo.txt:
     * ruta\
     * 
     * carpeta1
     * carpeta2
     * carpeta3
     */
    public static void Recompletado_arbol_genealogico(String direccion) throws Exception {

        directorio_src = direccion;
        control_de_datos.add_nota(direccion, "");

        NumeroLineas = control_de_datos.Cuantas_Lineas(directorio_src);

        obetener_y_ejecutar();
    }

    private static void obetener_y_ejecutar() throws Exception {

        direcciones_generales = control_de_datos.LeerLinea(directorio_src, 0);

        String tempoString;

        for (int i = 2; i < NumeroLineas; i++) {
            tempoString = control_de_datos.LeerLinea(directorio_src, i);
            nombres_generales.add(tempoString);
            tempoString = direcciones_generales + tempoString;

            control_de_datos.Create_direct(tempoString);
            direcciones_carpetas_generales.add(tempoString + "\\");
        }

        create_srcs();
    }

    private static void create_srcs() throws Exception {
        String tempo_names;

        for (int j = 0; j < NumeroLineas; j++) {
            tempo_names = direcciones_carpetas_generales.get(j) + nombres_generales.get(j);
            tempo_names = tempo_names + ".txt";
            control_de_datos.add_nota(tempo_names, "");
        }
    }
}
