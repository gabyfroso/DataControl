import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import utility.Recomplete_withFile;
import utility.control_de_datos;

public class App {

    public static File disponible_txt = new File("materias_disponibles.txt");
    private static File donde_hacer = new File("");
    public static ArrayList<File> materias_directorio = new ArrayList<File>();

    public static void main(String[] args) throws Exception {

        Recomplete_withFile.Recompletado_arbol_genealogico(donde_hacer, disponible_txt);

        Scanner sc;
        int ir_al;

        System.out.println("0- Actualizar datos direccionales");
        for (File nombre_materia : Recomplete_withFile.direcc_grls) {
            System.out.println(nombre_materia.getName());
        }

        System.out.println("¿a cual desea ir?\n");

        sc = new Scanner(System.in);
        ir_al = sc.nextInt();
        sc.close();

        switch (ir_al) {
            case 0:
                System.out.println("Actualizando...");
                Actualizar_datos();
                System.out.println("Terminado");
                break;
            default:
                break;

            }
    }

    private static void Actualizar_datos() throws Exception
    {
        ArrayList<File> temp = new ArrayList<File>();
        ArrayList<File> temp2 = new ArrayList<File>();

        String strtempo;

        for (File directorio : Recomplete_withFile.direcc_grls) {
            materias_directorio.add(directorio);
            strtempo = directorio.getAbsolutePath() + "\\" + directorio.getName();

            temp.add(control_de_datos.retornarFile(directorio.getAbsolutePath()));
            temp2.add(control_de_datos.retornarFile(strtempo + ".txt"));
        }

        Recomplete_withFile.close();
        for (int i = 0; i < temp.size() ; i++) {
            Recomplete_withFile.Recompletado_arbol_genealogico(temp.get(i), temp2.get(i));
        }

    }
}