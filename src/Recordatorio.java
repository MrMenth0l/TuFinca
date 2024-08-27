import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import com.twilio.rest.content.v1.Content;
import java.util.List;

public class Recordatorio {
    public static final String ACCOUNT_SID = "ACd74432c8e7e33e3b1311b7e1975b79d4";
    public static final String AUTH_TOKEN = "eafa8c0d269dc6ea8649684b6e4f8b38";

    public Recordatorio(String numero, List<String> Tarea, int tipo){
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        String to = "+502"+numero;

        String from = "+12513136808";

        String mensaje = "";

        switch (tipo){
            case 1:
                mensaje = "RECORDATORIO DE TAREA\n" +
                        "\n" +
                        "Hola, " + Tarea.get(3)+" TuFinca te recuerda de realizar tu tarea "+ Tarea.get(0).toUpperCase()+".\n" +
                        "\n" +
                        "Te recordamos que se necesita hacer antes de: " + Tarea.get(2) +"\n" +
                        "\n" +
                        "Tarea: "+ Tarea.get(0)+"\n" +
                        "Descripción: "+Tarea.get(1)+"\n";
                break;
            case 2:
                mensaje = "NUEVA TAREA\n"+
                        "\n" +
                        "Hola, " + Tarea.get(3)+" Se te ha asignado una nueva Tarea "+
                        "\n" +
                        "Tarea: " + Tarea.get(0)+"\n"+
                        "Descripcion: " + Tarea.get(1) +"\n"+
                        "Fecha: " + Tarea.get(2)+"\n" +
                        "\n"+
                        "FAVOR REALIZAR ANTES DE LA SIGUIENTE FECHA: " +Tarea.get(2);
                break;

        }

        try {
            Message message = Message.creator(
                    new PhoneNumber(to),
                    new PhoneNumber(from),
                    mensaje
            ).create();
            System.out.println("Recordatorio enviado. SID: " + message.getSid());
        } catch (Exception e) {
            System.err.println("ERROR, mensaje no enviado: " + e.getMessage());
        }
    }
}
