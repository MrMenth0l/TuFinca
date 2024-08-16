public class Conversion {
    public double Conversion(int tamaño, String medida) {
        double conv_tamaño = 0;
        switch (medida) {

            case "Manzanas":
                conv_tamaño = (tamaño * 698896);
                break;
            case "Hectareas":
                conv_tamaño = (tamaño*10000);
                break;
            case "Metrosˆ2":
                conv_tamaño = (tamaño);
                break;
            case "Yardasˆ2":
                conv_tamaño = (tamaño*0.836127);
                break;
            case "Varasˆ2":
                conv_tamaño = (tamaño*0.698896);
                break;
            default:
                conv_tamaño = 0;
                break;
        }
        return conv_tamaño;
    }
}
