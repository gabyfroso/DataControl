package utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DataControl {

    /*
     * Controlado :3
     */
    public static void add_nota(String ubicacion, String add_nota) throws Exception {
        try (
                FileWriter fw = new FileWriter(ubicacion, true);) {
            fw.write(add_nota);
            fw.close();
        }

        catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void Create_directorio(String direccion) {

        File directorio_mkdir = new File(direccion);

        if (!directorio_mkdir.exists()) {
            if (directorio_mkdir.mkdirs()) {

            } else {
                System.out.println("Ocurrio un problema al crear la carpeta.");
                System.out.println("Dir intentado: " + direccion);
            }
        } else {
            // System.out.println("exist: " + direccion + " actually");
        }
    }

    /*
     * Controlado :3
     */
    public static void leer_notas(String direccion) throws Exception {
        add_nota(direccion, "");

        try {
            BufferedReader lector;
            FileReader archivo = new FileReader(direccion);

            if (archivo.ready()) {
                lector = new BufferedReader(archivo);
                String cadena;

                while ((cadena = lector.readLine()) != null) {
                    System.out.println("+ " + cadena);
                }
            } else {
                archivo.close();
            }
        } catch (Exception e) {
            System.out.println("No se que pasó, contáctame");
        }
    }

    /*
     * Perfecto, le mandas un texto y te escribe lo que estaba en esa direccion
     * Volviendotelo Return String.
     */
    public static String almacenar_todo_en_uno(String direccion) throws Exception {
        add_nota(direccion, "");
        String tempo = "";

        try {
            BufferedReader lector;
            FileReader archivo = new FileReader(direccion);

            if (archivo.ready()) {
                lector = new BufferedReader(archivo);
                String cadena;

                while ((cadena = lector.readLine()) != null) {
                    tempo = tempo + cadena + "\n";
                }
            } else {
                /*
                 * Significando que es uno vacío
                 * hacemos la prueba de ello, caso
                 * contrario, ya sabemos.
                 */
                lector = new BufferedReader(archivo);
                int x = lector.read();
                while (x != -1) {
                    if ((x = lector.read()) == -1) {
                        // Directorio no contuvo nada
                    }
                    {
                        System.out.println("-Ex no deberia estar aqui\nError en: DataControl.AlmacenarTodo.");
                        System.out.println("Direccion: " + direccion);
                    }
                }
                lector.close();
            }
            archivo.close();
        } catch (Exception e) {
            System.out.println("No se que pasó, contáctame");
        }

        return tempo;
    }

    /*
     * Controlado :3
     */
    public static String LeerLinea(String direccion_src, int linea) throws Exception {
        add_nota(direccion_src, "");
        int conteo = 0;
        String ingreso_tempoString = "";

        try {
            BufferedReader lector;
            FileReader archivo = new FileReader(direccion_src);

            if (archivo.ready()) {
                lector = new BufferedReader(archivo);
                String cadena;

                while ((cadena = lector.readLine()) != null) {
                    if (linea == conteo) {
                        ingreso_tempoString = cadena;
                    }
                    conteo++;
                }
            } else {
                archivo.close();
            }
        } catch (Exception e) {
            System.out.println("Error en LeerLinea");
            return "Error en LeerLinea " + linea;
        }
        return ingreso_tempoString;
    }

    /*
     * Controlado :3
     */
    public static int Cuantas_Lineas_hay_int(String direccion) throws Exception {
        add_nota(direccion, "");
        long NumeroLineas = 0;

        try (FileReader fr = new FileReader(direccion)) {
            BufferedReader bf = new BufferedReader(fr);

            while ((bf.readLine()) != null) {
                NumeroLineas++;
            }
        } catch (Exception e) {
        }

        return (int) NumeroLineas;
    }

    /*
     * buscará la definición, y la dirá hasta toparse con un -
     * si quieres que empiece desde alli,
     * que_buscar = "-"
     * 
     * si quieres tener antes
     * que_buscar= ""
     * 
     * eje:
     * nota: ayer a la noche
     * vi un lobo
     * -
     * &&&&&&&&&&&&&&&&&&&&&
     * nota2: ayer vi una
     * gabiota-
     */
    public static String Buscar_definicion(String direccion_src, String que_buscar) throws Exception {
        add_nota(direccion_src, "");

        String tempo = DataControl.almacenar_todo_en_uno(direccion_src);
        String tempDef = "";
        boolean cortar = false;

        if (tempo.indexOf(que_buscar) != -1) {
            for (int i = tempo.indexOf(que_buscar) + que_buscar.length(); i < tempo.length(); i++) {
                if ((int) tempo.charAt(i) == 45) {
                    cortar = true;
                }
                if (!cortar) {
                    tempDef = tempDef + tempo.charAt(i);
                }
            }
        } else {
            System.out.println("no se ha encontrado la definicion");
            return "\nControlData: no encontrada def";
        }

        return tempDef;
    }

    public static File retornarFile(String direccion) {

        return new File(direccion);
    }

    public final static void clearConsole() throws InterruptedException, IOException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }
}
