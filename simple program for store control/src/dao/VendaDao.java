package dao;


import static Controlers.Executavel.vendas;
import Model.Relatorio;
import Model.Venda;
import java.sql.*;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class VendaDao {
    
    private final Connection connection;

    public VendaDao(Connection connection) {
        this.connection = connection;
    }
    
    
    
    
    public void insertVenda(Venda venda) throws SQLException{
        
        String sql = "select preco, quantidade from produtos where codigo = '"+venda.getCodigo()+"';";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.execute();
        
        ResultSet rs = statement.getResultSet();
        
        if(rs.next()){
            
            double valorUnidade = rs.getDouble(1);
            int quantidade = rs.getInt(2);
            
            int quantidadeSobra = quantidade - venda.getQuantidade();
            
            double valorTotal = valorUnidade * venda.getQuantidade();
            
            
            if(quantidadeSobra < 0){
                JOptionPane.showMessageDialog(null, "Produto sem estoque");
           
            }else if( quantidadeSobra == 0){
          
            String sql1 = "insert into vendas(codigo, quantidade, valor, data) values('"+venda.getCodigo()+"','"+venda.getQuantidade()+"','" +valorTotal+"', CURRENT_DATE);";   
            String sql2 = "update produtos set quantidade = '"+ quantidadeSobra +"' where codigo = '"+venda.getCodigo()+"';";
            String sql3 = "delete from produtos * where codigo = '"+ venda.getCodigo()+"';";
            
            PreparedStatement statement1 = connection.prepareStatement(sql1);
            PreparedStatement statement2 = connection.prepareStatement(sql2);
            PreparedStatement statement3 = connection.prepareStatement(sql3);
            
            statement1.execute();
            statement2.execute();
            statement3.execute();
            
            JOptionPane.showMessageDialog(null, "Venda realizada com sucesso");
    
        }else{
            String sql1 = "insert into vendas(codigo, quantidade, valor, data) values('"+venda.getCodigo()+"','"+venda.getQuantidade()+"','" +valorTotal+"', CURRENT_DATE);";   
            String sql2 = "update produtos set quantidade = '"+ quantidadeSobra +"' where codigo = '"+venda.getCodigo()+"';";
            
            PreparedStatement statement1 = connection.prepareStatement(sql1);
            PreparedStatement statement2 = connection.prepareStatement(sql2);
            
            statement1.execute();
            statement2.execute();
            
            JOptionPane.showMessageDialog(null, "Venda realizada com sucesso");
            }
 
    }
    
    }
    
    public void preencherTabelaVendas(Relatorio relatorio) throws SQLException{
        
        String sql = "select codigo, quantidade, valor from vendas where data between cast('"+relatorio.getDataInicial()+"' as date) and cast('"+relatorio.getDataFinal()+"' as date);";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.execute();
        
        ResultSet rs = statement.getResultSet();
        
        while (rs.next()){
            int itens = rs.getInt(2);
            String codigo = rs.getString(1);
            double valor = rs.getDouble(3);
            
            
            Venda vendaComDados = new Venda(codigo, itens, valor);
            vendas.add(vendaComDados);
            
        }
    
        
    }
    
    public static void preencherTabelaVenda(JTable tabela, List<Venda> Lista){
        
        DefaultTableModel dtm = (DefaultTableModel) tabela.getModel();
        dtm.setRowCount(Lista.size());
        tabela.setModel(dtm);
        
        double valorInicial = 0;
        int posLinha = 0;
        int unidadesInicial = 0;
        
        
        for (Venda a : Lista){
            
            valorInicial = valorInicial + a.getValor();
            unidadesInicial = unidadesInicial + a.getQuantidade();
            
            tabela.setValueAt(a.getCodigo(), posLinha, 0);
            tabela.setValueAt(a.getQuantidade(), posLinha, 1);
            tabela.setValueAt(a.getValor(), posLinha, 2);
            tabela.setValueAt(unidadesInicial, posLinha, 3);
            tabela.setValueAt(valorInicial, posLinha, 4);
   
            posLinha++;
        }
        
        
    }
    
    
}
