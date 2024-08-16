import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RevisarSetup extends JFrame{
    private JButton revisarGanadoButton;
    private JButton revisarSeccionesDeFincaButton;
    private JButton revisarSuministradoresButton;
    private JButton revisarSuministrosButton;
    private JButton revisarCosechasbutton;
    private JButton regresarButton;
    private JPanel RevisarSetup;

    public RevisarSetup(TuFinca sistema, Finca finca, export_csv csv) {
        setContentPane(RevisarSetup);
        setTitle("TuFinca");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
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
        regresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SetupFinca(sistema,finca, csv);
                dispose();
            }
        });
    }
}
