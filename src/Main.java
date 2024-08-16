import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.List;

public class Main extends JFrame {
    private JPanel Inicio;
    private JButton IngresarCuenta;
    private JLabel InitialLabel;
    private JButton crearCuentaButton;

    public Main(TuFinca sistema, export_csv csv){
        setContentPane(Inicio);
        setTitle("TuFinca");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        setVisible(true);
        IngresarCuenta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Login(sistema, csv);
                setVisible(false);
            }
        });
        crearCuentaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SignIn(sistema,csv);
                setVisible(false);
            }
        });
    }

    public static void main(String[] args) throws IOException {
        export_csv csv = new export_csv();
        TuFinca sistema = new TuFinca();
        csv.exportSistema(sistema);
        if(Files.exists(Path.of("out/sistema"))){
            File sistema_datos = new File("out/sistema");
            File [] fincas = sistema_datos.listFiles();
            for (int i = 0; i < Objects.requireNonNull(fincas).length; i++) {
                File[] Datos_Finca = fincas[i].listFiles();
                Finca finca =new Finca();
                finca.setNombre_Finca(fincas[i].getName().replace("finca-",""));
                sistema.addFinca(finca);
                for (int j = 0; j < Objects.requireNonNull(Datos_Finca).length; j++) {
                    String a =new File(String.valueOf(Datos_Finca[j])).getName();

                    switch (a){
                        case "Usuarios.csv":
                            File Usuarios_finca = new File(fincas[i]+"/"+"Usuarios.csv");
                            Scanner scu = new Scanner(new File(String.valueOf(Usuarios_finca)));
                            scu.useDelimiter(",");
                            while (scu.hasNext())
                            {
                                List<String> datos = new ArrayList<>();
                                datos.add(scu.nextLine());
                                List<String> usuario = Arrays.asList(datos.get(0).split(","));
                                Usuario user = new Usuario();
                                user.setUser(usuario.get(0));
                                user.setPass(usuario.get(1));
                                finca.addUsuario(user);
                            }
                            scu.close();
                            break;
                        case "Cabezas_de_Ganado.csv":
                            File Ganado_finca = new File(fincas[i]+"/"+"Cabezas_de_Ganado.csv");
                            Scanner scg = new Scanner(new File(String.valueOf(Ganado_finca)));
                            scg.useDelimiter(",");
                            if (scg.hasNextLine()) {
                                scg.nextLine();
                            }
                            while (scg.hasNext())
                            {
                                List<String> datos = new ArrayList<String>();
                                datos.add(scg.nextLine());
                                List<String> cabeza = Arrays.asList(datos.get(0).split(","));
                                CabezaGanado ganado = new CabezaGanado();
                                ganado.setNombre(cabeza.get(0));
                                ganado.setRaza(cabeza.get(1));
                                ganado.setEspecie(cabeza.get(2));
                                ganado.setEdad(Integer.valueOf(cabeza.get(3)));
                                ganado.setID_Num(cabeza.get(4));
                                finca.addCabezaGanado(ganado);
                            }
                            scg.close();
                            break;
                        case "Secciones.csv":
                            File Secciones_finca = new File(fincas[i]+"/"+"Secciones.csv");
                            Scanner scs = new Scanner(new File(String.valueOf(Secciones_finca)));
                            scs.useDelimiter(",");
                            if (scs.hasNextLine()) {
                                scs.nextLine();
                            }
                            while (scs.hasNext())  //returns a boolean value
                            {
                                List<String> datos = new ArrayList<String>();
                                datos.add(scs.nextLine());
                                List<String> seccion_general = Arrays.asList(datos.get(0).split(","));
                                Seccion seccion = new Seccion();
                                seccion.setSeccion(seccion_general.get(0));
                                seccion.setTamaño(Integer.parseInt(seccion_general.get(1)));
                                seccion.setMedida(seccion_general.get(2));
                                seccion.setFuncion(seccion_general.get(3));
                                seccion.setEstado(seccion_general.get(4));
                                seccion.setCabezas(Integer.parseInt(seccion_general.get(5)));
                                seccion.setID_Num(seccion_general.get(6));
                                finca.addSeccion(seccion);
                            }
                            scs.close();
                            break;
                        case "Suministradores.csv":
                            File Suministradores_finca = new File(fincas[i]+"/"+"Suministradores.csv");
                            Scanner scm = new Scanner(new File(String.valueOf(Suministradores_finca)));
                            scm.useDelimiter(",");
                            if (scm.hasNextLine()) {
                                scm.nextLine();
                            }
                            while (scm.hasNext())
                            {
                                List<String> datos = new ArrayList<String>();
                                datos.add(scm.nextLine());
                                List<String> Suministrador_general = Arrays.asList(datos.get(0).split(","));
                                Suministrador suministrador = new Suministrador();
                                suministrador.setNombre(Suministrador_general.get(0));
                                suministrador.setProducto(Suministrador_general.get(1));
                                suministrador.setPrecio(Integer.parseInt(Suministrador_general.get(2)));
                                suministrador.setDias_espera(Integer.parseInt(Suministrador_general.get(3)));
                                suministrador.setID_Num(Suministrador_general.get(4));
                                finca.addSuministrador(suministrador);
                            }
                            scm.close();
                            break;
                        case "Suministros.csv":
                            File Suministros_finca = new File(fincas[i]+"/"+"Suministros.csv");
                            Scanner sc_m = new Scanner(new File(String.valueOf(Suministros_finca)));
                            sc_m.useDelimiter(",");
                            if (sc_m.hasNextLine()) {
                                sc_m.nextLine();
                            }
                            while (sc_m.hasNext())
                            {
                                List<String> datos = new ArrayList<String>();
                                datos.add(sc_m.nextLine());
                                List<String> Suministro_general = Arrays.asList(datos.get(0).split(","));
                                Suministro suministro = new Suministro();
                                suministro.setNombre(Suministro_general.get(0));
                                suministro.setTipo(Suministro_general.get(1));
                                suministro.setCantidad(Integer.valueOf(Suministro_general.get(2)));
                                suministro.setDiasDesdeCompra(Integer.valueOf(Suministro_general.get(3)));
                                suministro.setID_Num(Suministro_general.get(4));
                                finca.addSuministros(suministro);
                            }
                            sc_m.close();
                            break;
                        case "Cosechas.csv":
                            File Cosechas_finca = new File(fincas[i]+"/"+"Cosechas.csv");
                            Scanner sc_c = new Scanner(new File(String.valueOf(Cosechas_finca)));
                            sc_c.useDelimiter(",");
                            if (sc_c.hasNextLine()) {
                                sc_c.nextLine();
                            }
                            while (sc_c.hasNext())
                            {
                                List<String> datos = new ArrayList<String>();
                                datos.add(sc_c.nextLine());
                                List<String> Cosecha_general = Arrays.asList(datos.get(0).split(","));
                                Cosecha cosecha = new Cosecha();
                                cosecha.setTipo(Cosecha_general.get(0));
                                cosecha.setTamaño(Integer.valueOf(Cosecha_general.get(1).trim()));
                                cosecha.setMedida(Cosecha_general.get(2));
                                cosecha.setEstado(Cosecha_general.get(3));
                                cosecha.setEpoca(Cosecha_general.get(4));
                                cosecha.setGeografia(Cosecha_general.get(5));
                                cosecha.setID_Num(Cosecha_general.get(6));
                                finca.addCosecha(cosecha);
                            }
                            sc_c.close();
                            break;
                        default:
                            break;
                    }
                }
            }
        }
        for (int i = 0; i < sistema.getFincas().size(); i++) {
            Finca finca = sistema.getFincas().get(i);
            File CabezasSeccion = new File(finca.getFincaPath()+"/Cabezas&Ganado.csv");
            Scanner sc_cs = new Scanner(new File(String.valueOf(CabezasSeccion)));
            sc_cs.useDelimiter(",");
            if (sc_cs.hasNextLine()){
                sc_cs.nextLine();
            }
            while (sc_cs.hasNextLine()){
                List<String> datos = new ArrayList<String>();
                datos.add(sc_cs.nextLine());
                List<String> Cabeza_ganado = Arrays.asList(datos.get(0).split(","));
                for (int j = 0; j < finca.getSecciones().size(); j++) {
                    if (Cabeza_ganado.get(1).equals(finca.getSecciones().get(j).getSeccion())){
                        for (int k = 0; k < finca.getCabezaGanados().size(); k++) {
                            if (Cabeza_ganado.get(0).equals(finca.getCabezaGanados().get(k).getNombre())){
                                Seccion seccion = finca.getSecciones().get(j);
                                CabezaGanado cabeza = finca.getCabezaGanados().get(k);
                                cabeza.setSeccion(seccion);
                                seccion.addCabezaGanado(cabeza);
                            }
                        }
                    }
                }
            }
        }
        new Main(sistema, csv);



    }
}
