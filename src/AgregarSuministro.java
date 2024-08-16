import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class AgregarSuministro extends JFrame {
    private JPanel AgregarSuministro;
    private JTextField NombreField;
    private JButton agregarButton;
    private JTextField ExistenciaField;
    private JTextField DiasField;
    private JComboBox TipoField;
    private JButton Regresar;

    public AgregarSuministro(TuFinca sistema, Finca finca, export_csv csv){
        setContentPane(AgregarSuministro);
        setTitle("TuFinca");
        setSize(300,380);
        setLocationRelativeTo(null);
        setVisible(true);


        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Suministro suministro = new Suministro();
                suministro.setNombre(NombreField.getText());
                suministro.setTipo((String) TipoField.getSelectedItem());
                suministro.setCantidad(Integer.valueOf(ExistenciaField.getText()));
                suministro.setDiasDesdeCompra(Integer.valueOf(DiasField.getText()));
                suministro.setID_Num(finca.getSuministros().size()+1);
                finca.addSuministros(suministro);
                try {
                    csv.exportData(suministro.getDatos(),suministro.getFile(),finca);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                JOptionPane.showMessageDialog(AgregarSuministro.this, "Suministro: " + suministro.getNombre() + "\nAgregado correctamente");
                dispose();
                new SetupFinca(sistema,finca,csv);
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
