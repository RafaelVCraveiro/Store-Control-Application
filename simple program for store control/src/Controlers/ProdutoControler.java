package Controlers;


import Frames.TelaCadastroProdutos;
import Model.Produto;
import Frames.TelaGerenciarProdutos;
import dao.Conexao;
import dao.ProdutoDao;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class ProdutoControler {
    
    private TelaCadastroProdutos cadastro;
    
    private TelaGerenciarProdutos gerenciar;

    public ProdutoControler(TelaCadastroProdutos cadastro) {
        this.cadastro = cadastro;
    }

    public ProdutoControler(TelaGerenciarProdutos produtos) {
        this.gerenciar = produtos;
    }
    
    
    
    public void salvarProdutos(){
        
        String nome = cadastro.getTxtNome().getText();
        String fabricante = cadastro.getTxtFabricante().getText();
        String codigo = cadastro.getTxtCodigo().getText();
        double valor = Double.parseDouble(cadastro.getTxtValor().getText());
        int quantidade = Integer.parseInt(cadastro.getTxtQuantidade().getText());
        
        Produto produto1 = new Produto(nome, fabricante, quantidade, codigo, valor);
        
        try {
            Connection conexao = new Conexao().getConnection();
            ProdutoDao produtoDao = new ProdutoDao(conexao);
            produtoDao.insertProduto(produto1);
            
            
            JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso");
            
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioControler.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    
    public void excluirProdutoPorCodigo() {
        
        String codigo = gerenciar.getTxtCodigo().getText();
        
        Produto produtoExcluir = new Produto(codigo);
        
        try {
            Connection conexao = new Conexao().getConnection();
            ProdutoDao produtoDao = new ProdutoDao(conexao);
            boolean excluir = produtoDao.removerProdutoPorCodigo(produtoExcluir);
            
            if(excluir == true){
                JOptionPane.showMessageDialog(null, "Produto excluido com sucesso!");
                
                
            }else{
                JOptionPane.showMessageDialog(null, "Produto nao encontrado");
            }
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioControler.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    
    
    
}
