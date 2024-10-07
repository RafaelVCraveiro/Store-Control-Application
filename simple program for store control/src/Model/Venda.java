package Model;


public class Venda {
    
    private String codigo;
    private int quantidade;
    private double valor;

    public Venda(String codigo, int quantidade) {
        this.codigo = codigo;
        this.quantidade = quantidade;
    }

    public Venda(String codigo, int quantidade, double valor) {
        this.codigo = codigo;
        this.quantidade = quantidade;
        this.valor = valor;
    }
    
    
    
    
    
    
    
    
    
    
    

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
    
    
    
}
