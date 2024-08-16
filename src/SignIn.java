import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class SignIn extends JFrame {
    private JPanel SignIn;
    private JTextField FincaField;
    private JTextField UsuarioField;
    private JPasswordField PassField;
    private JPasswordField PassField2;
    private JButton IngresarButton;
    private JButton regresarButton;
    private String usuario;
    private String pass;


    public SignIn(TuFinca sistema, export_csv csv){
        setContentPane(SignIn);
        setTitle("Crear cuenta");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300,350);
        setLocationRelativeTo(null);
        setVisible(true);
        IngresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Finca finca =new Finca();
                Usuario usuario_activo = new Usuario();
                for (int i = 0; i < sistema.getFincas().size() ; i++) {
                    if (FincaField.getText().equals(sistema.getFincas().get(i).getNombre_Finca())){
                        finca = sistema.getFincas().get(i);
                    }
                }
                if(PassField.getText().equals(PassField2.getText())) {
                    finca.setNombre_Finca(FincaField.getText());
                    usuario_activo.setUser(UsuarioField.getText());
                    usuario_activo.setPass(PassField.getText());
                    usuario_activo.getFile();
                    sistema.addFinca(finca);
                    try {
                        csv.exportFinca(finca);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    JOptionPane.showMessageDialog(SignIn.this, "Bienvenido " + usuario_activo.getUser());
                    finca.addUsuario(usuario_activo);
                    try {
                        csv.exportData(usuario_activo.getUser()+"," +usuario_activo.getPass(), usuario_activo.getFile(),finca);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    new SetupFinca(sistema, finca, csv);
                    dispose();
                }else{JOptionPane.showMessageDialog(SignIn.this,"Ingrese bien su contraseña");}
            }
        });
        regresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Main(sistema, csv);
                dispose();
            }
        });
    }
}


