package mc322;

public class MainExemplo {
    public static void main(String[] args){
        Veiculo Cyberskeleton = new Veiculo("1LOV3LUCY", "Arasaka", "Prototype Cyberskeleton");
        Cliente David = new Cliente("David Martinez", "185.635.910-70", "23/05/2058", 18, "Santo Domingo");
        Seguradora TraumaTeam = new Seguradora("Trauma Team", "(19) 3721-5000", "helpdesk@traumateam.com", "Corpo Plaza, 191");
        Sinistro AdamSmasher = new Sinistro("21/03/2076", "Arasaka Tower");

        System.out.println("Laudo do Acidente:\n\nInformações do Veículo:\n\n    "
        + Cyberskeleton.getMarca() + " " + Cyberskeleton.getModelo() + "\n    Placa: "+
        Cyberskeleton.getPlaca() + "\n\n" + David.toString() + "Informações da Seguradora:\n\n    "
        + TraumaTeam.getNome() + "\n    Telefone: "+TraumaTeam.getTelefone()+"\n    Endereço: " +
        TraumaTeam.getEndereco() + "\n\nInformações do Sinistro:\n\n    Data do Acidente: " +
        AdamSmasher.getData() + "\n    Endereço do Acidente: " + AdamSmasher.getEndereco() +
        "\n    ID do Sinistro: "+AdamSmasher.getId()+"\n");
    }  
}
