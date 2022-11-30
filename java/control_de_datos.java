import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class control_de_datos {

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
                System.out.println("Ocurrio un problema al crearlo.");
            }
        } else {
            System.out.println("exist: " + direccion + " actually");
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
                System.out.println("-Ex no deberia estar aqui");
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

    public static String Buscar_definicion(String direccion_src, String que_buscar) throws Exception {
        add_nota(direccion_src, "");

        String tempo = control_de_datos.almacenar_todo_en_uno(direccion_src);
        String tempDef = "";

        if (tempo.indexOf(que_buscar) != -1) {
            for (int i = tempo.indexOf(que_buscar) + que_buscar.length(); i < tempo.length(); i++) {
                tempDef = tempDef + tempo.charAt(i);
            }
        } else {
            System.out.println("no se ha encontrado");
        }
        
        return tempDef;
    }
}
