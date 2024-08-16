import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RevisarSetup extends JFrame{
    private JButton revisarGanadoButton;
    private JButton revisarSeccionesDeFincaButton;
    private JButton revisarSuministradoresButton;
    private JButton revisarSuministrosButton;
    private JButton revisarCosechasbutton;
    private JButton Regresar;
    private JPanel RevisarSetup;

    public RevisarSetup(TuFinca sistema, Finca finca, export_csv csv) {
        setTitle("Configurador de su Finca");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Full screen setup
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gd = ge.getDefaultScreenDevice();
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        // Initialize the main panel with GridBagLayout
        JPanel RevisarSetup = new JPanel();
        RevisarSetup.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.weightx = 1;
        gbc.weighty = 1;

        // Create and configure components
        revisarGanadoButton = new JButton("Cabeza de ganado");
        revisarGanadoButton.setFont(new Font("Raleway", Font.PLAIN, 18));
        gbc.gridx = 1;
        gbc.gridy = 1;
        RevisarSetup.add(revisarGanadoButton, gbc);

        revisarSuministradoresButton = new JButton("Suministradores de su finca");
        revisarSuministradoresButton.setFont(new Font("Raleway", Font.PLAIN, 18));
        gbc.gridy = 3;
        RevisarSetup.add(revisarSuministradoresButton, gbc);

        revisarCosechasbutton = new JButton("Cosechas de su finca");
        revisarCosechasbutton.setFont(new Font("Raleway", Font.PLAIN, 18));
        gbc.gridy = 5;
        RevisarSetup.add(revisarCosechasbutton, gbc);

        revisarSuministrosButton = new JButton("Suministros de su finca");
        revisarSuministrosButton.setFont(new Font("Raleway", Font.PLAIN, 18));
        gbc.gridy = 4;
        RevisarSetup.add(revisarSuministrosButton, gbc);

        revisarSeccionesDeFincaButton = new JButton("Secciones de su finca");
        revisarSeccionesDeFincaButton.setFont(new Font("Raleway", Font.PLAIN, 18));
        gbc.gridy = 2;
        RevisarSetup.add(revisarSeccionesDeFincaButton, gbc);

        JLabel welcomeLabel = new JLabel("Revisar su Finca: ");
        welcomeLabel.setFont(new Font("Raleway", Font.BOLD, 22));
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        RevisarSetup.add(welcomeLabel, gbc);

        Regresar = new JButton("Regresar");
        Regresar.setFont(new Font("Raleway", Font.BOLD, 18));
        Regresar.setForeground(new Color(-11179215)); // Color: -11179215
        gbc.gridy = 7;
        gbc.gridx = 2;
        gbc.gridwidth = 1;
        RevisarSetup.add(Regresar, gbc);


        setContentPane(RevisarSetup);
        setLocationRelativeTo(null);
        setVisible(true);

        revisarGanadoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RevisarCabezas(sistema, finca, csv);
                dispose();
            }
        });
        revisarSeccionesDeFincaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RevisarSeccion(sistema,finca, csv);
                dispose();
            }
        });
        revisarSuministradoresButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RevisarSuministradores(sistema, finca, csv);
                dispose();
            }
        });
        revisarSuministrosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RevisarSuministros(sistema, finca, csv);
                dispose();
            }
        });
        revisarCosechasbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RevisarCosecha(sistema, finca, csv);
                dispose();
            }
        });
        Regresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SetupFinca(sistema,finca, csv);
                dispose();
            }
        });
    }
}
