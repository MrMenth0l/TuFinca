import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class TareasDia extends JFrame {
    private JPanel TareasDia;

    public TareasDia(TuFinca sistema, Finca finca, export_csv csv, String date){

        List<List<String>> tareasList = finca.getTareas();
        Object [][] Tareas = new Object[tareasList.size()][4];
        String [] header = {"Trabajador", "Nombre de tarea", "Descripcion", "Fecha a realizarse"};
        Font font = new Font("Raleway", Font.PLAIN, 14);
        int a = 0;
        for (int i = 0; i < tareasList.size(); i++) {
            if (tareasList.get(i).get(2).equals(date)) {
                Tareas[a][0] = tareasList.get(i).get(3);
                Tareas[a][1] = tareasList.get(i).get(0);
                Tareas[a][2] = tareasList.get(i).get(1);
                Tareas[a][3] = tareasList.get(i).get(2);
                a ++;
            }
        }

        if (a>0){
        TableModel model = new DefaultTableModel(Tareas, header);
        JTable tareasTable = new JTable(model);
        tareasTable.setSize(400,50);
        tareasTable.setFont(font);

        TareasDia = new JPanel();

        JScrollPane scrollPane = new JScrollPane(tareasTable);
        scrollPane.setSize(400, 50);
        TareasDia.add(scrollPane);

        JButton regresar = new JButton("Regresar");
        regresar.setFont(new Font("Raleway",Font.BOLD,14));
        regresar.setForeground(new Color(-11179215));
        TareasDia.add(regresar,BorderLayout.PAGE_END);


        setContentPane(TareasDia);
        setTitle("Tareas para " + date);
        setSize(600,400);
        setLocationRelativeTo(null);
        setVisible(true);

       regresar.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               dispose();
           }
       });
    }else {JOptionPane.showMessageDialog(TareasDia.this ,"No hay tareas para " + date);dispose();}
    }
}
