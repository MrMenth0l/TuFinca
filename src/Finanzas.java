import java.util.List;

public class Finanzas {
    private  boolean BG;
    private boolean ER;
    private List<Double> pasivos;
    private List<Double> activos;
    private List<Double> patrimonios;
    private List<Double> ingresos;
    private List<Double> egresos;

    public void setActivos(List<Double> activos) {this.activos = activos;}
    public void setPasivos(List<Double> pasivo) {this.pasivos = pasivo;}
    public void setPatrimonios(List<Double> patrimonios) {this.patrimonios = patrimonios;}
    public void setIngresos(List<Double> ingresos) {this.ingresos = ingresos;}
    public void setEgresos(List<Double> egresos) {this.egresos = egresos;}
    public void setBG(boolean BG) {this.BG = BG;}
    public void setER(boolean ER) {this.ER = ER;}

    public List<Double> getActivos() {return activos;}
    public List<Double> getPasivos() {return pasivos;}
    public List<Double> getPatrimonios() {return patrimonios;}
    public List<Double> getEgresos() {return egresos;}
    public List<Double> getIngresos() {return ingresos;}
    public boolean isBG() {return BG;}
    public boolean isER() {return ER;}

    public void addActivo(Double activo){activos.add(activo);}
    public void addPasivo(Double pasivo){pasivos.add(pasivo);}
    public void addPatrimonio(Double patrimonio){patrimonios.add(patrimonio);}
    public void addIngreso(Double ingreso){ingresos.add(ingreso);}
    public void addEgreso(Double egreso){egresos.add(egreso);}


}