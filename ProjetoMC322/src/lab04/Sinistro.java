package lab04;
import java.util.Random;


public class Sinistro {
    private final int id;
    private String data;
    private String endereco;
    private Seguradora seguradora;
    private Veiculo veiculo;
    private Cliente cliente;
    private static Random rand = new Random();

    public Sinistro(String data, String endereco, Seguradora seguradora, Veiculo veiculo, Cliente cliente) {
        this.data = data;
        this.endereco = endereco;
        this.seguradora = seguradora;
        this.veiculo = veiculo;
        this.cliente = cliente;
        id = gerarId(); //Cria um id único e aleatório
    }
    private int gerarId() //Produz um inteiro aleatório de 9 algarismos
    {
        return rand.nextInt(999999999);
    }
    public int getId() {
        return id;
    }
    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public Seguradora getSeguradora() {
        return seguradora;
    }
    public void setSeguradora(Seguradora seguradora) {
        this.seguradora = seguradora;
    }
    public Veiculo getVeiculo() {
        return veiculo;
    }
    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public String toString() {
        return "Informações do Sinistro:\n"
        +"\n    ID: " + getId()
        +"\n    Data: " + getData()
        +"\n    Endereço: " + getEndereco()
        +"\n    Seguradora: " + getSeguradora().getNome()
        +"\n    Veiculo: " + getVeiculo().getMarca() + " " + getVeiculo().getModelo() + " " + getVeiculo().getAnoFabricacao() + ", Placa: " + getVeiculo().getPlaca()
        +"\n    Cliente: " + getCliente().getNome()
        +"\n    Tipo do Cliente: " + getCliente().tipoDeCliente()
        +"\n"
        ;
    }
}
