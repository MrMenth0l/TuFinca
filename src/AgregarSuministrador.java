import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class AgregarSuministrador extends JFrame{
    private JPanel AgregarSuministrador;
    private JTextField NombreField;
    private JButton agregarButton;
    private JTextField ProductoField;
    private JTextField PrecioField;
    private JTextField EsperaField;
    private JButton Regresar;

    public AgregarSuministrador(TuFinca sistema, Finca finca, export_csv csv){
        setContentPane(AgregarSuministrador);
        setTitle("TuFinca");
        setSize(600,350);
        setLocationRelativeTo(null);
        setVisible(true);


        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Suministrador suministrador = new Suministrador();
                suministrador.setNombre(NombreField.getText());
                suministrador.setProducto(ProductoField.getText());
                suministrador.setPrecio(Integer.parseInt(PrecioField.getText()));
                suministrador.setDias_espera(Integer.parseInt(EsperaField.getText()));
                suministrador.setID_Num(finca.getSuministradores().size()+1);
                finca.addSuministrador(suministrador);
                try {
                    csv.exportData(suministrador.getDatos(),suministrador.getFile(), finca);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                JOptionPane.showMessageDialog(AgregarSuministrador.this, "Suministrador: " + suministrador.getNombre() + "\nAgregado correctamente");
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
