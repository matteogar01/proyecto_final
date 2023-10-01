import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable (tableName = "vehiculos")
public class Inventario {
    @DatabaseField (id = true)
    private String placa; //llave primaria//
    @DatabaseField
    private String marca;
    @DatabaseField
    private String modelo;
    @DatabaseField
    private int año;
    @DatabaseField
    private int ejes;
    @DatabaseField
    private int cc;
    @DatabaseField
    private int valor;

    public Inventario(String placa, String marca, String modelo, int año, int ejes, int cc, int valor) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.año = año;
        this.ejes = ejes;
        this.cc = cc;
        this.valor = valor;
    }

    public Inventario(){
        //contructor vacio
        this.placa = "";
        this.marca = "";
        this.modelo = "";
        this.año = 0;
        this.ejes = 0;
        this.cc = 0;
        this.valor = 0;
    }
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public int getEjes() {
        return ejes;
    }

    public void setEjes(int ejes) {
        this.ejes = ejes;
    }

    public int getCc() {
        return cc;
    }

    public void setCc(int cc) {
        this.cc = cc;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
}
