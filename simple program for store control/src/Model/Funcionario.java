package Model;


public class Funcionario {
    
    private String nome;
    private String datanasci;
    private String email;
    private String telefone;
    private String Cpf;
    private String funcao;
    private String usuario;
    private String senhha;
    private  int id;

    public Funcionario(String nome, String datanasci, String email, String telefone, String Cpf, String funcao, String usuario, String senhha, int id) {
        this.nome = nome;
        this.datanasci = datanasci;
        this.email = email;
        this.telefone = telefone;
        this.Cpf = Cpf;
        this.funcao = funcao;
        this.usuario = usuario;
        this.senhha = senhha;
        this.id = id;
    }

    public Funcionario(String funcao, String usuario, String senhha) {
        this.funcao = funcao;
        this.usuario = usuario;
        this.senhha = senhha;
    }

    public Funcionario(String usuario, String senhha) {
        this.usuario = usuario;
        this.senhha = senhha;
    }

    public Funcionario(String usuario) {
        this.usuario = usuario;
    }

    public Funcionario(String nome, String telefone, String funcao, String usuario) {
        this.nome = nome;
        this.telefone = telefone;
        this.funcao = funcao;
        this.usuario = usuario;
    }
    

    
    
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
    public String getUsuario() {
        return usuario;
    }

    public Funcionario(String nome, String datanasci, String email, String telefone, String Cpf, String funcao, String usuario, String senhha) {
        this.nome = nome;
        this.datanasci = datanasci;
        this.email = email;
        this.telefone = telefone;
        this.Cpf = Cpf;
        this.funcao = funcao;
        this.usuario = usuario;
        this.senhha = senhha;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenhha() {
        return senhha;
    }

    public void setSenhha(String senhha) {
        this.senhha = senhha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDatanasci() {
        return datanasci;
    }

    public void setDatanasci(String datanasci) {
        this.datanasci = datanasci;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return Cpf;
    }

    public void setCpf(String Cpf) {
        this.Cpf = Cpf;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }
    
            
    
}
