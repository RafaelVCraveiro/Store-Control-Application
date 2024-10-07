package dao;


import Model.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class ProdutoDao {
    
    private final Connection connection;

    public ProdutoDao(Connection connection) {
        this.connection = connection;
    }
    
    public void insertProduto(Produto produto) throws SQLException{
        
        String sql = "insert into produtos(nome, fabricante, quantidade, codigo, preco) values('"+produto.getNome()+"','"+produto.getFabricante()+"','" +produto.getQuantidade()+"','"+produto.getCodigo()+"','"+produto.getValor()+"');";                                                                                    
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.execute();
        
    }
    
    
    
    public boolean removerProdutoPorCodigo(Produto excluirProdutoPorCodigo) throws SQLException{
        int confirma= JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover esse produto?","atencao", JOptionPane.YES_NO_CANCEL_OPTION);
        if (confirma == JOptionPane.YES_OPTION){
            String sql = "delete from produtos * where codigo = '"+ excluirProdutoPorCodigo.getCodigo()+"';";
            PreparedStatement statement = connection.prepareStatement(sql);
            
            
            statement.execute();
            return true;
            
            
        }
        return false;
    }
    
}
