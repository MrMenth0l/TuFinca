import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class AgregarTarea extends JFrame {
    private JPanel AgregarTarea;
    public AgregarTarea(TuFinca sistema, Finca finca, export_csv csv){
        setTitle("Agregar tarea");
        setLayout(new GridBagLayout());

        AgregarTarea = new JPanel();
        AgregarTarea.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel titleLabel = new JLabel("Agregar Tarea: ");
        titleLabel.setFont(new Font("Raleway", Font.BOLD, 18));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        AgregarTarea.add(titleLabel, gbc);

        JLabel NombreLabel = new JLabel("Nombre de la tarea: ");
        NombreLabel.setFont(new Font("Raleway", Font.BOLD, 16));
        gbc.gridx = 1;
        gbc.gridy = 2;
        AgregarTarea.add(NombreLabel);

        JTextField NombreField = new JTextField();
        NombreField.setFont(new Font("Raleway", Font.BOLD, 16));
        gbc.gridy = 3;
        AgregarTarea.add(NombreField,gbc);

        JLabel DescripcionLabel = new JLabel("Descripcio de tarea");
        DescripcionLabel.setFont(new Font("Raleway", Font.BOLD, 16));
        gbc.gridy = 4;
        AgregarTarea.add(DescripcionLabel,gbc);

        JTextField DescripcionField = new JTextField();
        DescripcionField.setFont(new Font("Raleway", Font.BOLD, 16));
        gbc.gridy = 5;
        AgregarTarea.add(DescripcionField,gbc);

        JLabel TrabajadorLabel = new JLabel("Trabajador asignado");
        TrabajadorLabel.setFont(new Font("Raleway", Font.BOLD, 16));
        gbc.gridy = 6;
        AgregarTarea.add(TrabajadorLabel,gbc);

        String[] Trabajadores = new String[finca.getTrabajadores().size()];

        for (int i = 0; i < finca.getTrabajadores().size(); i++) {
            Trabajadores[i] = (finca.getTrabajadores().get(i).getNombre());
        }

        JComboBox TrabajadorField = new JComboBox<>(Trabajadores);
        TrabajadorField.setFont(new Font("Raleway", Font.BOLD, 16));
        gbc.gridy = 7;
        AgregarTarea.add(TrabajadorField,gbc);

        JLabel FechaLabel = new JLabel("Fecha a realizarse");
        FechaLabel.setFont(new Font("Raleway", Font.BOLD, 16));
        gbc.gridy = 8;
        AgregarTarea.add(FechaLabel,gbc);

        JDateChooser FechaField = new JDateChooser();
        FechaField.setFont(new Font("Raleway", Font.PLAIN, 16));
        FechaField.setIcon(new ImageIcon("src/graficos/CalendarioSmall.png"));
        gbc.gridy = 9;
        AgregarTarea.add(FechaField,gbc);

        JButton crearButton = new JButton("Crear tarea");
        crearButton.setFont(new Font("Raleway", Font.PLAIN, 16));
        gbc.gridy=10;
        AgregarTarea.add(crearButton,gbc);


        setContentPane(AgregarTarea);
        setSize(600,600);
        setVisible(true);
        setLocationRelativeTo(null);

        crearButton.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               for (int i = 0; i < finca.getTrabajadores().size(); i++) {
                   if (finca.getTrabajadores().get(i).getNombre().equals(String.valueOf(TrabajadorField.getSelectedItem()))){
                       Trabajador trabajador = finca.getTrabajadores().get(i);
                       trabajador.setTareas();
                       List<String> tarea_datos = new ArrayList<>();
                       tarea_datos.add(NombreField.getText());
                       tarea_datos.add(DescripcionField.getText());
                       SimpleDateFormat dateFormat= new SimpleDateFormat("dd/MMM/yyyy");
                       String dateOnly = dateFormat.format(FechaField.getDate());
                       tarea_datos.add(dateOnly);
                       trabajador.addTarea(tarea_datos);

                       File tareasFile = new File("Tareas-"+trabajador.getID_Num());
                       File file = new File("Tareas.csv");
                       String datosTrabajador = NombreField.getText() + ","+DescripcionField.getText()+","+dateOnly;
                       String datosTarea = datosTrabajador +","+trabajador.getNombre()+","+trabajador.getID_Num();
                       List<String> Tarea= new ArrayList<>();
                       Tarea.add(NombreField.getText());
                       Tarea.add(DescripcionField.getText());
                       Tarea.add(dateOnly);
                       Tarea.add(trabajador.getNombre());
                       Tarea.add(trabajador.getID_Num());
                       finca.addTarea(Tarea);
                       try {
                           csv.setupTarea(tareasFile,finca);
                           csv.exportData(datosTrabajador,tareasFile,finca,true);
                           csv.exportData(datosTarea, file,finca);

                       } catch (IOException ex) {
                           throw new RuntimeException(ex);
                       }
                   }

               }
               dispose();
           }
       });


    }
}
