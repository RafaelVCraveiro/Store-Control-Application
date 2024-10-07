package Model;

public class Produto {
    
    private String nome;
    private String fabricante;
    private int quantidade;
    private String codigo;
    private int id;
    private double valor;

    public Produto(String nome, String fabricante, int quantidade, String codigo, double valor) {
        this.nome = nome;
        this.fabricante = fabricante;
        this.quantidade = quantidade;
        this.codigo = codigo;
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Produto(String codigo) {
       
        this.codigo = codigo;
    }

    public Produto(int quantidade, String codigo, double valor) {
        this.quantidade = quantidade;
        this.codigo = codigo;
        this.valor = valor;
    }

    

    

    
    
    
    

    
    
    
    
    
    
    
    
    public Produto(String nome, String fabricante, int quantidade, String codigo, int id) {
        this.nome = nome;
        this.fabricante = fabricante;
        this.quantidade = quantidade;
        this.codigo = codigo;
        this.id = id;
    }
    
 
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
    
    
}
