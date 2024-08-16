import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class AgregarGanado extends JFrame {
    private JPanel AgregarGanado;
    private JTextField NombreField;
    private JTextField RazaField;
    private JTextField EdadField;
    private JButton agregarButton;
    private JComboBox EspecieField;
    private JLabel Especie;
    private JButton Regresar;
    private int ID_Num;

    public AgregarGanado(TuFinca sistema, Finca finca, export_csv csv){
        setContentPane(AgregarGanado);
        setTitle("TuFinca");
        setSize(300,380);
        setLocationRelativeTo(null);
        setVisible(true);


        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CabezaGanado cabezaGanado = new CabezaGanado();
                Seccion seccion = new Seccion();
                seccion.setSeccion("General");
                cabezaGanado.setNombre(NombreField.getText());
                cabezaGanado.setEdad((Integer.valueOf(EdadField.getText())));
                cabezaGanado.setRaza(RazaField.getText());
                cabezaGanado.setEspecie((String) EspecieField.getSelectedItem());
                cabezaGanado.setSeccion(seccion);
                ID_Num = finca.getCabezaGanados().size()+1;
                cabezaGanado.setID_Num(ID_Num);
                finca.addCabezaGanado(cabezaGanado);
                System.out.println(finca.getNombre_Finca());
                try {
                    csv.exportData(cabezaGanado.getDatos(),cabezaGanado.getFile(),finca);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                JOptionPane.showMessageDialog(AgregarGanado.this, "Cabeza de ganado: " + cabezaGanado.getNombre() + "\nAgregada correctamente");
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
