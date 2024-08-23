import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

public class AsginarRecordatorio extends JFrame {
    public AsginarRecordatorio(Finca finca, export_csv csv, Trabajador trabajador, List Tarea, String datosTrabajador, String datosTarea, File trabajador_file, File file ){

        JPanel AsignarRecordatorio = new JPanel();
        AsignarRecordatorio.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel recordatorio = new JLabel("Cuando quiere recordar de esta tarea?");
        recordatorio.setFont(new Font("Raleway", Font.BOLD, 14));
        recordatorio.setHorizontalAlignment(SwingConstants.CENTER);
        gbc.gridx = 0;
        gbc.gridy = 1;
        AsignarRecordatorio.add(recordatorio, gbc);

        JDateChooser diasField = new JDateChooser();
        diasField.setFont(new Font("Raleway", Font.PLAIN, 12));
        gbc.gridy=2;
        AsignarRecordatorio.add(diasField,gbc);

        JButton aceptar = new JButton("Aceptar");
        aceptar.setFont(new Font("Raleway", Font.BOLD, 14));
        gbc.gridy = 3;
        AsignarRecordatorio.add(aceptar,gbc);

        setContentPane(AsignarRecordatorio);
        setSize(300,200);
        setVisible(true);
        setLocationRelativeTo(null);

        aceptar.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               SimpleDateFormat dateFormat= new SimpleDateFormat("dd/MMM/yyyy");
               String dateOnly = dateFormat.format(diasField.getDate());
               String Trabajador = datosTrabajador;
               Trabajador += ","+dateOnly;
               String Tarea = datosTarea;
               Tarea += ","+dateOnly;
               try {
                           csv.setupTarea(trabajador_file,finca);
                           csv.exportData(Trabajador,trabajador_file,finca,true);
                           csv.exportData(Tarea, file,finca);

                           } catch (IOException ex) {
                               throw new RuntimeException(ex);
                           }
               dispose();
           }
       });



    }
}
