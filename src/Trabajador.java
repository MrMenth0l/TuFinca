import java.io.File;
import java.util.List;

public class Trabajador {
    private String Trabajador_ID;
    private String Nombre;
    private String Rol;
    private double Sueldo;
    private String ID_Num;
    private List<String> Tareas;
    private File file;


    public Trabajador(){this.file = new File("Trabajadores.csv");}

    public void setTrabajador_ID(String trabajador_ID) {Trabajador_ID = trabajador_ID;}
    public void setNombre(String nombre) {Nombre = nombre;}
    public void setRol(String rol) {Rol = rol;}
    public void setSueldo(double sueldo) {Sueldo = sueldo;}
    public void setID_Num(String ID_Num) {this.ID_Num = ID_Num;}
    public void setID_Num(int ID_Num) {this.ID_Num = "#"+ getNombre().substring(0,2) + getRol().substring(0,2) + ID_Num;}
    public void setTareas(List<String> tareas) {Tareas = tareas;}
    public void addTarea(String tarea){Tareas.add(tarea);}

    public String getTrabajador_ID() {return Trabajador_ID;}
    public String getNombre() {return Nombre;}
    public String getRol() {return Rol;}
    public String getID_Num() {return ID_Num;}
    public double getSueldo() {return Sueldo;}
    public List<String> getTareas() {return Tareas;}
    public File getFile() {return file;}

}
