import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SetupFinca extends JFrame{
    private JButton CosechaAgregar;
    private JButton GanadoAgregar;
    private JButton SeccionAgregar;
    private JButton SuministradorAgregar;
    private JButton SuministroAgregar;
    private JButton RevisarFinca;
    private JButton Regresar;
    private JPanel Setup;
    private JButton asignarGanadoASeccionButton;

    public SetupFinca(TuFinca sistema, Finca finca, export_csv csv) {
        setContentPane(Setup);
        setTitle("TuFinca");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        setVisible(true);

        GanadoAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AgregarGanado(sistema,finca, csv);

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
                new RevisarSetup(sistema,finca,csv);
                dispose();

            }
        });
        Regresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Main(sistema,csv);
            }
        });
        asignarGanadoASeccionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AsignarGanado(sistema,finca,csv);
            }
        });
    }
}
