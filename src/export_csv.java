import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class export_csv
{
    public void exportSistema(TuFinca sistema) throws IOException {
        if(!Files.exists(Path.of("src/sistema"))) {
            Files.createDirectory(Path.of("src/sistema"));
            System.out.println("si exporta?");
        }
    }

    public void exportFinca(Finca finca) throws IOException {
        if(!Files.exists(Path.of("src/sistema/finca-" + finca.getNombre_Finca()))) {
            Files.createDirectory(Path.of("src/sistema/finca-" + finca.getNombre_Finca()));
            exportSetup(finca);
        }
    }
    private void exportSetup(Finca finca) throws IOException {
            File Usuarios = new File("Usuarios.csv");
            exportData("Usuario, Contraseña", Usuarios,finca);

            File Ganado = new File("Cabezas_de_Ganado.csv");
            exportData("Nombre, Raza, Especie, Edad(años), ID_Num",  Ganado, finca);

            File Secciones = new File("Secciones.csv");
            exportData("Seccion, Tamaño, Medida, Funcion, Estado, Cabezas, ID_Num",  Secciones, finca);

            File Suministradores = new File("Suministradores.csv");
            exportData("Nombre, Producto, Precio(QTZ), Dias de espera, ID_Num",  Suministradores, finca);

            File Suministros = new File("Suministros.csv");
            exportData("Nombre, Tipo, Cantidad, Dias desde compra, ID_Num",  Suministros, finca);

            File Cosechas = new File("Cosechas.csv");
            exportData("Tipo, Tamaño, Medida, Estado, Epoca, Geografia, ID_Num",  Cosechas, finca);

            File CabezasGanado = new File("Cabezas&Ganado.csv");
            exportData("Cabeza, Seccion", CabezasGanado, finca);
    }

    public void exportData(String datos, File file, Finca finca) throws IOException {
        File Datos = new File("src/sistema/finca-"+finca.getNombre_Finca()+"/"+file);
        FileWriter fw =  new FileWriter(Datos, true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw. write(datos);
        bw.newLine();
        bw.close();
        fw.close();


    }
}
