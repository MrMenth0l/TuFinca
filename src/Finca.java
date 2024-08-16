import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Finca {
    private File finca;
    private List<Usuario> usuarios = new ArrayList<Usuario>();
    private List<CabezaGanado> cabezaGanados = new ArrayList<CabezaGanado>();
    private List<Seccion> secciones = new ArrayList<Seccion>();
    private List<Suministrador> suministradores = new ArrayList<Suministrador>();
    private List<Cosecha> cosechas = new ArrayList<Cosecha>();
    private List<Suministro> suministros = new ArrayList<Suministro>();
    private String Nombre_Finca;


    public File getFinca() {return finca;}

    public List<Usuario> getUsuarios() {return usuarios;}
    public List<CabezaGanado> getCabezaGanados() {return cabezaGanados;}
    public List<Seccion> getSecciones() {return secciones;}
    public List<Cosecha> getCosechas() {return cosechas;}
    public List<Suministrador> getSuministradores() {return suministradores;}
    public List<Suministro> getSuministros() {return suministros;}


    public void addUsuario(Usuario usuario){usuarios.add(usuario);}
    public void addCabezaGanado(CabezaGanado cabezaGanado){cabezaGanados.add(cabezaGanado);}
    public void addSeccion(Seccion seccion){secciones.add(seccion);}
    public void addSuministrador(Suministrador suministrador){suministradores.add(suministrador);}
    public void addCosecha(Cosecha cosecha){cosechas.add(cosecha);}
    public void addSuministros(Suministro suministro){suministros.add(suministro);}

    public void setNombre_Finca(String nombre_Finca) {Nombre_Finca = nombre_Finca;this.finca = new File("Fincas.csv");}
    public String getNombre_Finca() {return Nombre_Finca;}

    public String getFincaPath(){
        return "out/sistema/finca-"+getNombre_Finca();
    }

}
