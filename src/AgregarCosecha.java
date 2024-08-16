import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class AgregarCosecha extends JFrame {
    private JTextField CosechaField;
    private JButton agregarButton;
    private JTextField SizeField;
    private JTextField GeoField;
    private JPanel AgregarCosecha;
    private JComboBox EstadoField;
    private JComboBox EpocaField;
    private JComboBox MedidaField;
    private JButton Regresar;

    public AgregarCosecha(TuFinca sistema, Finca finca, export_csv csv){
        setContentPane(AgregarCosecha);
        setTitle("TuFinca");
        setSize(500,400);
        setLocationRelativeTo(null);
        setVisible(true);

        String [] estados = {"Vacia", "En crecimiento", "Sembra", "Lista para cosechar"};


        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Cosecha cosecha = new Cosecha();
                cosecha.setTipo(CosechaField.getText());
                cosecha.setTamaño(Integer.valueOf(SizeField.getText()));
                cosecha.setMedida((String) MedidaField.getSelectedItem());
                cosecha.setEstado((String) EstadoField.getSelectedItem());
                cosecha.setEpoca((String) EpocaField.getSelectedItem());
                cosecha.setGeografia(GeoField.getText());
                cosecha.setID_Num(finca.getCosechas().size()+1);
                finca.addCosecha(cosecha);
                try {
                    csv.exportData(cosecha.getDatos(), cosecha.getFile(),finca);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                JOptionPane.showMessageDialog(AgregarCosecha.this, "Cosecha: " + cosecha.getTipo() + "\nAgregada correctamente");
                dispose();
                new SetupFinca(sistema,finca, csv);
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
