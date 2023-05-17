package lab04;

public class Sinistro {
    private final int id;
    private String data;
    private String endereco;
    private Seguradora seguradora;
    private Veiculo veiculo;
    private Cliente cliente;

    public Sinistro(String data, String endereco, Seguradora seguradora, Veiculo veiculo, Cliente cliente) {
        this.data = data;
        this.endereco = endereco;
        this.seguradora = seguradora;
        this.veiculo = veiculo;
        this.cliente = cliente;
        id = gerarId(); //Cria um id único que depende da data e da posição do sinistro na lista da seguradora
    }
    private int gerarId() //Codifica a data em 6 algarismos usando o resto da divisão por um primo e produz o id a partir disso e da ordemEmissao
    {
        String dataLimpa = data.replaceAll("[^0123456789]", "");
        return (Integer.valueOf(dataLimpa)%796931)*1000 + seguradora.getListaSinistros().size(); //Assume que listaSinistros.size() < 1000. 796931 é um primo aleatório de 6 algarismos.
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
        +"\n\n"
        ;
    }
}
