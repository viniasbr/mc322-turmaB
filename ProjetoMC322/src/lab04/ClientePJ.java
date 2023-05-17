package lab04;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ClientePJ extends Cliente{
    private final String cnpj;
    private LocalDate dataFundacao;
    private int qtdeFuncionarios;
    
    public ClientePJ(String nome, String endereco, Veiculo veiculo, String cnpj, LocalDate dataFundacao) {
        super(nome, endereco, veiculo);
        this.cnpj = cnpj;
        this.dataFundacao = dataFundacao;
    }
    public String getCnpj() {
        return cnpj;
    }
    public LocalDate getDataFundacao() {
        return dataFundacao;
    }
    public void setDataFundacao(LocalDate dataFundacao) {
        this.dataFundacao = dataFundacao;
    }
    public int getQtdeFuncionarios() {
        return qtdeFuncionarios;
    }
    public void setQtdeFuncionarios(int qtdeFuncionarios) {
        this.qtdeFuncionarios = qtdeFuncionarios;
    }
    @Override
    public double calculaScore()
    {
        return CalcSeguro.VALOR_BASE.fator()*(1+(qtdeFuncionarios/100))*getListaVeiculos().size();
    }
    @Override
    public String toString() {
        String saida = "Informações do Cliente Pessoa Jurídica:\n"
        +"\n    Nome: " + getNome()
        +"\n    Endereço: " + getEndereco()
        +"\n    Valor do Seguro: R$" + String.format("%.2f", getValorSeguro())
        +"\n    CNPJ: " + getCnpj()
        +"\n    dataFundacao: " + getDataFundacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
        +"\n    Quantidade de Funcionários: " + getQtdeFuncionarios()
        +"\n    Veiculo(s): ";
        for(Veiculo v: getListaVeiculos())
        {
            saida = saida + "\n         " + v.getMarca() +" "+ v.getModelo() + " " + v.getAnoFabricacao() + ", Placa: " + v.getPlaca();
        }
        saida = saida + "\n    Validez do CNPJ: ";
        return saida + "\n";
    }
    @Override
    public String tipoDeCliente()
    {
        return "PJ";
    }
}
