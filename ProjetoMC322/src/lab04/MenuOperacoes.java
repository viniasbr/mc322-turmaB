package lab04;

public enum MenuOperacoes {
    SAIR(0,0), CADASTRAR(1,0), LISTAR(2,0), EXCLUIR(3,0), GERAR_SINISTRO(4,0), TRANSFERIR_SEGURO(5,0),
    CADASTRAR_VOLTAR(1,0), CADASTRAR_CLIENTE(1,1), CADASTRAR_VEICULO(2,0) ,CADASTRAR_SEGURADORA(1,3),
    LISTAR_VOLTAR(2, 0), LISTAR_CLIENTES(2, 1), LISTAR_SINISTROS_SEG(2, 2), LISTAR_SINISTROS_CLI(2, 3), LISTAR_VEICULOS_CLI(2, 4), LISTAR_VEICULOS_SEG(2, 5),
    EXCLUIR_VOLTAR(3,0), EXCLUIR_CLIENTE(3,1), EXCLUIR_VEICULO(3,2), EXCLUIR_SINISTRO(3,3);


    private final int c0;
    private final int c1;
    
    
    MenuOperacoes(int c0, int c1) {
        this.c0 = c0;
        this.c1 = c1;
    }
    public int getC0() {
        return c0;
    }
    public int getC1() {
        return c1;
    }
    public void menuTextual()
    {
        //TODO: Menu Textual
    }
}
