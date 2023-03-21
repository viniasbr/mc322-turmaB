package mc322;

public class Sinistro {
    private int id;
    private String data;
    private String endereco;
    private int ordemEmissao; //Ordem do sinistro nas emissões diárias
    private static int totalDeEmissoes = 0;//Total atual de sinistros emitidos
    public Sinistro(String data, String endereco) {
        this.data = data;
        this.endereco = endereco;
        ordemEmissao = totalDeEmissoes;
        id = gerarId(); //Cria um id que depende da data e da ordem dos sinistros emitidos no dia
        totalDeEmissoes++;
    }
    private int gerarId()
    {
        String dataLimpa = data.replaceAll("[^0123456789]", "");
        return (Integer.valueOf(dataLimpa)%796931)*1000 + this.ordemEmissao; //Assume que ordemEmissao < 1000. 796931 é um primo aleatório de 6 algarismos.
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
}
