package lab03;
import java.util.ArrayList;
import java.util.Date;

public class Cliente {
    private String nome;
    private String endereco;
    private Date dataLicenca;
    private String educacao;
    private String genero;
    private String classeEconomica;
    private ArrayList<Veiculo> listaVeiculos;

    public Cliente(String nome, String endereco, Date dataLicenca, String educacao, String genero,
            String classeEconomica, Veiculo veiculo) {
        this.nome = nome;
        this.endereco = endereco;
        this.dataLicenca = dataLicenca;
        this.educacao = educacao;
        this.genero = genero;
        this.classeEconomica = classeEconomica;
        listaVeiculos.add(veiculo);
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Date getDataLicenca() {
        return dataLicenca;
    }
    public void setDataLicenca(Date dataLicenca) {
        this.dataLicenca = dataLicenca;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public ArrayList<Veiculo> getListaVeiculos() {
        return listaVeiculos;
    }
    public void addVeiculo(Veiculo veiculo) {
        listaVeiculos.add(veiculo);
    }
    public Veiculo getVeiculo(int i) {
        return listaVeiculos.get(i);
    }
    public String getEducacao() {
        return educacao;
    }
    public void setEducacao(String educacao) {
        this.educacao = educacao;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public String getClasseEconomica() {
        return classeEconomica;
    }
    public void setClasseEconomica(String classeEconomica) {
        this.classeEconomica = classeEconomica;
    }
    public String toString() {
        String saida = "Informações do Cliente:\n"
        +"\n    Nome: " + nome
        +"\n    Endereço: " + endereco
        +"\n    Data da Licença: " + dataLicenca
        +"\n    Veiculo(s): ";
        for(Veiculo v: listaVeiculos)
        {
            saida = saida + "         " + v.getMarca() +" "+ v.getModelo() + " " + v.getAnoFabricacao() + ", Placa: " + v.getPlaca() +"\n";
        }
        saida = saida + "\n";
        return saida;
    }
}
