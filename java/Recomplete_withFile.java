package utility;
import java.io.File;
import java.util.ArrayList;

/*
 * Obtendras las direcciones creadas con los txt 
 * para volver a hacer el proceso en caso de que gustes
 * 
 * solo usa:
 * para ver su tamaño si desea i
 * Recompletar.direcciones_creadas_conTxt.size();
 * 
 * para ver
 * Recompletar.direcciones_creadas_conTxt.get(x_valor);
*/
public class Recomplete_withFile {

    private static int NumeroLineas;
    public static ArrayList<File> direcc_grls = new ArrayList<File>();
    private static File archivo_txt;
    private static File imhere = new File("");

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
    public static void Recompletado_arbol_genealogico(File direccion) throws Exception {
        archivo_txt = direccion;
        control_de_datos.add_nota(archivo_txt.getPath(), "");

        NumeroLineas = control_de_datos.Cuantas_Lineas_hay_int(archivo_txt.getAbsolutePath());

        obetener_y_ejecutar();
    }

    private static void obetener_y_ejecutar() throws Exception {
        String tmpFilmain_string = control_de_datos.LeerLinea(archivo_txt.getPath(), 0);
        String tempname;

        for (int i = 2; i < NumeroLineas; i++) {

            /*
             * obj1
             * obj2...
             */
            tempname = control_de_datos.LeerLinea(archivo_txt.getPath(), i);
            tempname = imhere.getCanonicalPath() + "\\" + tmpFilmain_string + "\\" + tempname;
            /*
             * ..\\obj1
             */
            direcc_grls.add(control_de_datos.retornarFile(tempname));
        }

        create_srcs();
    }

    private static void create_srcs() throws Exception {
        String tempo_names;
        
        for (File filetemp : direcc_grls) {
            tempo_names = filetemp.getPath();
            control_de_datos.Create_directorio(tempo_names);
            System.out.println("direc creado: "+ tempo_names);


            tempo_names = tempo_names + "\\" + filetemp.getName() + ".txt";

            System.out.println("srcs\ntemponame: "+ tempo_names + "\n");
            control_de_datos.add_nota(tempo_names, "");
        }
    }

    /*
     * Close hace referencia a otros apartados, 
     * volver los valores a 0 para no almacenar nada más.
     */
    public static void close()
    {
        NumeroLineas = 0;
        direcc_grls.clear();
    }
}
