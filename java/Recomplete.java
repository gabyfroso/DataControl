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
public class Recomplete {

    private static int NumeroLineas;
    public static ArrayList<File> direcc_grls = new ArrayList<File>();
    private static File donde_hacerlo;
    private static File archivo_txt;

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
    public static void Recompletado_arbol_genealogico(File donde_hacer, File que_leer) throws Exception {
        archivo_txt = que_leer;
        donde_hacerlo = donde_hacer;
        DataControl.add_nota(archivo_txt.getPath(), "");

        NumeroLineas = DataControl.Cuantas_Lineas_hay_int(archivo_txt.getAbsolutePath());

        obetener_y_ejecutar();
    }

    private static void obetener_y_ejecutar() throws Exception {
        String tmpFilmain_string = DataControl.LeerLinea(archivo_txt.getPath(), 0);
        String tempname;

        for (int i = 2; i < NumeroLineas; i++) {

            /*
             * obj1
             * obj2...
             */
            tempname = DataControl.LeerLinea(archivo_txt.getPath(), i);
            tempname = donde_hacerlo.getCanonicalPath() + "\\" + tmpFilmain_string + "\\" + tempname;
            /*
             * ..\\obj1
             */
            direcc_grls.add(DataControl.retornarFile(tempname));
        }

        create_srcs();
    }

    private static void create_srcs() throws Exception {
        String tempo_names;
        
        for (File filetemp : direcc_grls) {
            tempo_names = filetemp.getPath();
            DataControl.Create_directorio(tempo_names);

            tempo_names = tempo_names + "\\" + filetemp.getName() + ".txt";
            DataControl.add_nota(tempo_names, "");
        }
    }

    /*
     * Close hace referencia a otros apartados, 
     * volver los valores a 0 para no almacenar nada más.
     * recuerda, usamos arraylist, debes cerrarlo antes de usarlo de nuevo
     */
    public static void close()
    {
        NumeroLineas = 0;
        direcc_grls.clear();
    }
}
