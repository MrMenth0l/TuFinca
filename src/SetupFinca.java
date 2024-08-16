import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SetupFinca extends JFrame {
    private JButton CosechaAgregar;
    private JButton GanadoAgregar;
    private JButton SeccionAgregar;
    private JButton SuministradorAgregar;
    private JButton SuministroAgregar;
    private JButton RevisarFinca;
    private JButton Regresar;
    private JButton asignarGanadoASeccionButton;

    public SetupFinca(TuFinca sistema, Finca finca, export_csv csv) {
        setTitle("Configurador de su Finca");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Full screen setup
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gd = ge.getDefaultScreenDevice();
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        // Initialize the main panel with GridBagLayout
        JPanel Setup = new JPanel();
        Setup.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.weightx = 1;
        gbc.weighty = 1;

        // Create and configure components
        GanadoAgregar = new JButton("Agregar cabeza de ganado");
        GanadoAgregar.setFont(new Font("Raleway", Font.PLAIN, 18));
        gbc.gridx = 1;
        gbc.gridy = 1;
        Setup.add(GanadoAgregar, gbc);

        SuministradorAgregar = new JButton("Agregar Suministrador");
        SuministradorAgregar.setFont(new Font("Raleway", Font.PLAIN, 18));
        gbc.gridy = 3;
        Setup.add(SuministradorAgregar, gbc);

        CosechaAgregar = new JButton("Agregar Cosecha");
        CosechaAgregar.setFont(new Font("Raleway", Font.PLAIN, 18));
        gbc.gridy = 5;
        Setup.add(CosechaAgregar, gbc);

        SuministroAgregar = new JButton("Agregar Suministro");
        SuministroAgregar.setFont(new Font("Raleway", Font.PLAIN, 18));
        gbc.gridy = 4;
        Setup.add(SuministroAgregar, gbc);

        SeccionAgregar = new JButton("Agregar seccion de su finca");
        SeccionAgregar.setFont(new Font("Raleway", Font.PLAIN, 18));
        gbc.gridy = 2;
        Setup.add(SeccionAgregar, gbc);

        JLabel welcomeLabel = new JLabel("Bienvenido al configurador de su Finca: ");
        welcomeLabel.setFont(new Font("Raleway", Font.BOLD, 22));
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        Setup.add(welcomeLabel, gbc);

        Regresar = new JButton("Regresar");
        Regresar.setFont(new Font("Raleway", Font.BOLD, 18));
        Regresar.setForeground(new Color(-11179215)); // Color: -11179215
        gbc.gridy = 7;
        gbc.gridx = 2;
        gbc.gridwidth = 1;
        Setup.add(Regresar, gbc);

        RevisarFinca = new JButton("Revisar estado de finca actual");
        RevisarFinca.setFont(new Font("Raleway", Font.BOLD, 18));
        RevisarFinca.setForeground(new Color(-11179215)); // Color: -11179215
        gbc.gridx = 1;
        Setup.add(RevisarFinca, gbc);

        asignarGanadoASeccionButton = new JButton("Asignar ganado a seccion");
        asignarGanadoASeccionButton.setFont(new Font("Raleway", Font.PLAIN, 18));
        gbc.gridy = 6;
        Setup.add(asignarGanadoASeccionButton, gbc);

        setContentPane(Setup);
        setLocationRelativeTo(null);
        setVisible(true);

        GanadoAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AgregarGanado(sistema, finca, csv);
            }
        });
        SeccionAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AgregarSeccion(sistema, finca, csv);
            }
        });
        SuministradorAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AgregarSuministrador(sistema, finca, csv);
            }
        });
        SuministroAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AgregarSuministro(sistema, finca, csv);
            }
        });
        CosechaAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AgregarCosecha(sistema, finca, csv);
            }
        });
        RevisarFinca.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RevisarSetup(sistema, finca, csv);
                dispose();
            }
        });
        Regresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Main(sistema, csv);
                dispose();
            }
        });
        asignarGanadoASeccionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AsignarGanado(sistema, finca, csv);
            }
        });
    }
}