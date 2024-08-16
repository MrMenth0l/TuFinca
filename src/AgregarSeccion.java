import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class AgregarSeccion extends JFrame {
    private JPanel AgregarSeccion;
    private JTextField NombreField;
    private JButton agregarButton;
    private JTextField SizeField;
    private JTextField FuncionField;
    private JTextField EstadoField;
    private JComboBox MedidaField;
    private JButton agregarCabezasDeGanadoButton;
    private JButton Regresar;

    public AgregarSeccion(TuFinca sistema, Finca finca, export_csv csv){
        Seccion seccion = new Seccion();
        setContentPane(AgregarSeccion);
        setTitle("TuFinca");
        setSize(650,380);
        setLocationRelativeTo(null);
        setVisible(true);


        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                seccion.setSeccion(NombreField.getText());
                seccion.setTamaño(Integer.valueOf(SizeField.getText()));
                seccion.setMedida((String) MedidaField.getSelectedItem());
                seccion.setFuncion(FuncionField.getText());
                seccion.setEstado(EstadoField.getText());
                seccion.setID_Num(finca.getSecciones().size()+1);
                finca.addSeccion(seccion);
                try {
                    csv.exportData(seccion.getDatos(), seccion.getFile(),finca);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                JOptionPane.showMessageDialog(AgregarSeccion.this, "Seccion: " + seccion.getSeccion() + "\nAgregada correctamente");
                dispose();
                new SetupFinca(sistema,finca, csv);
            }
        });
        agregarCabezasDeGanadoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AsignarGanado(sistema, finca, csv,seccion);
            }
        });
        Regresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
}
