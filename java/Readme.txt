Recomended/Recomendado

Ponerlo en carpeta Utility, caso contrario, se deberá eliminar la parte superior de Utility,
 throws Exception
es escencial para que funcione la clase java, ya que caso de que no exista, lo va a crear y 
evitará colapsos innecesarios

--------------------
Eng:
Put it in the Utility folder, otherwise, you should remove the upper part of Utility,
   throws an exception
it is essential for the java class to work, since if it does not exist, it will create it and
avoid necessary collapses

|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
||||                                   DataControl                                 ||||
|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||

    - Add_nota(Direccion, Nota);
Created .txt (if not exist) and add notes

    - Create_directorio(String direccion)

Created directory/binder
Crear carpeta

    - leer_notas(String direccion)
Lee las notas, mas no las regresa, solo dice
*a
*b

    - almacenar_todo_en_uno(String direccion)
Return .txt in String

    - LeerLinea(String direccion_src, int linea)
Return .txt in String expecificated in line (0~infinity)
if not searching, Return "Error en LeerLinea " + linea;

    - Cuantas_Lineas_hay_int(String direccion)
Return int Lines with .txt

    - Buscar_definicion(String Directxt, String searching)
searching Text's

|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
||||                                   Recomplete                                  ||||
|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
Recomplete.Recompletado_arbol_genealogico(File Direc with unwrap, File elemnt.txt);

unrap: address of the folder where "unwrap" the .txt data
elemtx.txt: the .txt file

pd: It doesn't matter if it exists or not, it will create it if it is not denied by the system

example:

        - text.txt
    \\Fild_Unrap\\Direc

    Asintota
    Coustinini
    Maxwell


Tree
    x:
    |--Fild_Undrap:
    |   |-Direc:
    |       |-Asintota
    |       |-Coustinini
    |       |-Maxwell
    |--text.txt
    |--App.java  


Español
Recomplete.Recompletado_arbol_genealogico(File Direccion, File docment.txt)

Direccion: Direccion donde desees desenvolver el texto
docment.txt: Documento donde tendrá una estructura de; (0), (2-infinito), creará 
las carpetas con los nombres del documento, poniendo la direccion en la posición 0
donde se va a desenvolver

Ejemplo:
        - text.txt
    \\Fild_Unrap\\Direc

    Asintota
    Coustinini
    Maxwell


Tree
    x:
    |--Fild_Undrap:
    |   |-Direc:
    |       |-Asintota
    |       |-Coustinini
    |       |-Maxwell
    |--text.txt
    |--App.java  