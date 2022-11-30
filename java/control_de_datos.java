import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class control_de_datos {

    /*
     * Controlado :3
     */
    public static void add_nota(String ubicacion, String add_nota) throws Exception {
        try
        {
            FileWriter fw = new FileWriter(ubicacion, true);
            fw.write(add_nota);
            fw.close();
        }

        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    private static FileReader archivo;

    public static void Create_direct(String direccion) {

        File directorio_mkdir = new File(direccion);

        if (!directorio_mkdir.exists()) {
            if (directorio_mkdir.mkdirs()) {
                
            }
            else{
                System.out.println("Ocurrio un problema al crearlo.");
            }
        }
        else
        {
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
            archivo = new FileReader(direccion);

            if (archivo.ready()) {
                lector = new BufferedReader(archivo);
                String cadena;

                while ((cadena = lector.readLine()) != null ) {
                    System.out.println("+ " + cadena);
                }
            } else {
                System.out.println("-");
            }
        } catch (Exception e) {
            System.out.println("No se que pasó, contáctame");
        }
    }

    /*
     * Perfecto, le mandas un texto y te escribe lo que estaba en esa direccion
     * Volviendotelo Return String.
     */
    public static String almacenar_todo_en_uno(String direccion) throws Exception
    {
        add_nota(direccion, "");
        int conteo=0;
        String tempo=" \n ";

        try {
            BufferedReader lector;
            archivo = new FileReader(direccion);

            if (archivo.ready()) {
                lector = new BufferedReader(archivo);
                String cadena;

                while ((cadena = lector.readLine()) != null ) {
                    if (conteo == 0) {
                        tempo = tempo+cadena + "\nDefinicion:\n";
                    }
                    if (conteo != 0) {
                        tempo = tempo+cadena;
                    }
                    conteo++;
                }
            } else {
                System.out.println("-Ex no deberia estar aqui");
            }
        } catch (Exception e) {
            System.out.println("No se que pasó, contáctame");
        }

        return tempo;
    }

    /*
     * Controlado :3
     */
    public static String LeerLinea(String direccion_src, int linea) throws Exception 
    {
        add_nota(direccion_src, "");
        int conteo=0;
        String ingreso_tempoString="";
        
        try {
            BufferedReader lector;
            archivo = new FileReader(direccion_src);

            if (archivo.ready()) {
                lector = new BufferedReader(archivo);
                String cadena;

                while ((cadena = lector.readLine()) != null ) {
                    if (linea == conteo) {
                        ingreso_tempoString = cadena;
                    }
                    conteo++;
                }
            } else {
                System.out.println("-");
            }
        } catch (Exception e) {
            System.out.println("Error en LeerLinea");
        }
        return ingreso_tempoString;
    }

    /*
     * Controlado :3
     */
    public static int Cuantas_Lineas(String direccion) throws Exception
    {
        add_nota(direccion, "");
        long NumeroLineas = 0;
        
        try (FileReader fr = new FileReader(direccion)) {
            BufferedReader bf = new BufferedReader(fr);

            while ((bf.readLine()) != null ) {
                NumeroLineas++;
            }
        } catch (Exception e) {
        }

        return (int)NumeroLineas;
    }
}
