import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Date;

public class AgregarGanado extends JFrame {
    private JPanel AgregarGanado;
    private JTextField NombreField;
    private JTextField RazaField;
    private JTextField EdadField;
    private JButton agregarButton;
    private JComboBox EspecieField;
    private JButton Regresar;
    private int ID_Num;

    public AgregarGanado(TuFinca sistema, Finca finca, export_csv csv){
        AgregarGanado = new JPanel();
        AgregarGanado.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel titleLabel = new JLabel("Agregar Cabeza de ganado");
        titleLabel.setFont(new Font("Raleway", Font.BOLD, 18));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        AgregarGanado.add(titleLabel, gbc);

        JLabel nombreLabel = new JLabel("Nombre: ");
        nombreLabel.setFont(new Font("Raleway", Font.PLAIN, 16));
        gbc.gridy = 1;
        AgregarGanado.add(nombreLabel, gbc);

        NombreField = new JTextField();
        NombreField.setFont(new Font("Raleway", Font.PLAIN, 14));
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.ipadx = 150;
        AgregarGanado.add(NombreField, gbc);

        JLabel especieLabel = new JLabel("Especie");
        especieLabel.setFont(new Font("Raleway", Font.PLAIN, 16));
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        AgregarGanado.add(especieLabel, gbc);

        EspecieField = new JComboBox<>(new String[]{
            "Bovino", "Aviar", "Equino", "Ovino", "Caprino"
        });
        EspecieField.setFont(new Font("Raleway", Font.PLAIN, 14));
        gbc.gridy = 4;
        AgregarGanado.add(EspecieField, gbc);

        JLabel razaLabel = new JLabel("Raza");
        razaLabel.setFont(new Font("Raleway", Font.PLAIN, 16));
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        AgregarGanado.add(razaLabel, gbc);

        RazaField = new JTextField();
        RazaField.setFont(new Font("Raleway", Font.PLAIN, 14));
        gbc.gridy = 2;
        AgregarGanado.add(RazaField, gbc);

        JLabel edadLabel = new JLabel("Edad (En años)");
        edadLabel.setFont(new Font("Raleway", Font.PLAIN, 16));
        gbc.gridy = 3;
        AgregarGanado.add(edadLabel, gbc);

        EdadField = new JTextField();
        EdadField.setFont(new Font("Raleway", Font.PLAIN, 14));
        gbc.gridy = 4;
        AgregarGanado.add(EdadField, gbc);

        JCheckBox embarazoCheck = new JCheckBox("Seleccione solo si esta cabeza esta embarazada");
        embarazoCheck.setFont(new Font("Raleway", Font.BOLD, 14));
        gbc.gridy = 5;
        gbc.gridx = 0;
        AgregarGanado.add(embarazoCheck,gbc);

        agregarButton = new JButton("Agregar");
        agregarButton.setFont(new Font("Raleway", Font.BOLD, 16));
        gbc.gridy = 7;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        AgregarGanado.add(agregarButton, gbc);

        Regresar = new JButton("Regresar");
        Regresar.setFont(new Font("Raleway", Font.BOLD, 14));
        Regresar.setForeground(new Color(-11179215));
        gbc.gridy = 7;
        gbc.gridx = 2;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.EAST;
        AgregarGanado.add(Regresar, gbc);

        setUndecorated(true);
        setVisible(true);
        setContentPane(this.AgregarGanado);
        setTitle("Agregar Ganado");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900,380);
        setLocationRelativeTo(null);

        JLabel embarazo_inicio_label = new JLabel("En que fecha empezo el embarazo aproximadamente?");
        embarazo_inicio_label.setFont(new Font("Raleway", Font.BOLD, 14));
        gbc.gridx = 0;
        gbc.gridy = 6;
        embarazo_inicio_label.setVisible(false);
        AgregarGanado.add(embarazo_inicio_label,gbc);

        JDateChooser embarazo_inicio_field = new JDateChooser(new Date());
        embarazo_inicio_field.setFont(new Font("Raleway", Font.BOLD, 14));
        gbc.gridy = 6;
        gbc.gridx = 2;
        embarazo_inicio_field.setVisible(false);
        AgregarGanado.add(embarazo_inicio_field,gbc);

        embarazoCheck.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JCheckBox cb = (JCheckBox) e.getSource();
                if (cb.isSelected()){
                    embarazo_inicio_field.setVisible(true);
                    embarazo_inicio_label.setVisible(true);
                }else {embarazo_inicio_field.setVisible(false);embarazo_inicio_label.setVisible(false);}
            }
        });

        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CabezaGanado cabezaGanado = new CabezaGanado();
                Seccion seccion = new Seccion();
                seccion.setSeccion("General");
                cabezaGanado.setNombre(NombreField.getText());
                cabezaGanado.setEdad((Integer.parseInt(EdadField.getText())));
                cabezaGanado.setRaza(RazaField.getText());
                cabezaGanado.setEspecie((String) EspecieField.getSelectedItem());
                cabezaGanado.setSeccion(seccion);
                if (embarazoCheck.isSelected()){
                    cabezaGanado.setEmbarazada(true);
                    cabezaGanado.setEmbarazo_inicio(embarazo_inicio_field.getDate());
                }
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
