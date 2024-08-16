import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Login extends JFrame {
    private JPanel Login;
    private JTextField UsuarioField1;
    private JPasswordField PassField1;
    private JLabel Pass;
    private JLabel Usuario;
    private JButton IngresarButton;
    private JTextField FincaField;
    private JButton regresarButton;

    public Login(TuFinca sistema, export_csv csv){
    setContentPane(Login);
        setTitle("Ingresar Cuenta");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300,300);
        setLocationRelativeTo(null);
        setVisible(true);
        IngresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!sistema.getFincas().isEmpty()) {
                    for (int i = 0; i < sistema.getFincas().size(); i++) {
                        if (sistema.getFincas().get(i).getNombre_Finca().equals(FincaField.getText())) {
                            for (int j = 0; j < sistema.getFincas().get(i).getUsuarios().size(); j++) {
                                if (UsuarioField1.getText().equals(sistema.getFincas().get(i).getUsuarios().get(j).getUser()) ) {
                                    if ( PassField1.getText().equals(sistema.getFincas().get(i).getUsuarios().get(j).getPass())) {
                                        Finca finca = sistema.getFincas().get(i);
                                        Usuario usuario_activo = sistema.getFincas().get(i).getUsuarios().get(j);
                                        JOptionPane.showMessageDialog(Login.this, "Bienvenido " + UsuarioField1.getText());
                                        dispose();
                                        new SetupFinca(sistema, finca, csv);
                                        break;
                                    }else{
                                        if(j==sistema.getFincas().get(i).getUsuarios().size()-1) {
                                            JOptionPane.showMessageDialog(Login.this, "Contraseña incorrecto");
                                        }

                                    }
                                } else {
                                    if(j==sistema.getFincas().get(i).getUsuarios().size()-1) {
                                            JOptionPane.showMessageDialog(Login.this, "Usuario incorrecto");
                                        }

                                }
                            }
                        } else {
                            if(i==sistema.getFincas().size()-1) {
                                Font font = new Font("Raleway", Font.BOLD, 16);
                                JOptionPane.showMessageDialog(Login.this, "Codigo de finca incorrecto");
                            }
                        }
                    }
                }else {JOptionPane.showMessageDialog(Login.this, "Finca no registrada, crear cuenta");
                    dispose();
                    new Main(sistema, csv);
                }


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
