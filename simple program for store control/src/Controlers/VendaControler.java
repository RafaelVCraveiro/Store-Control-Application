package Controlers;

import Frames.TelaCadastroVendas;
import Frames.TelaRelatorio;
import Model.Relatorio;
import Model.Venda;
import dao.Conexao;
import dao.VendaDao;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;



public class VendaControler {
    
    private TelaCadastroVendas cadastro;
    
    private TelaRelatorio relatorio;

    public VendaControler(TelaCadastroVendas cadastro) {
        this.cadastro = cadastro;
    }

    public VendaControler(TelaRelatorio relatorio) {
        this.relatorio = relatorio;
    }

    

    
    
    
    public void salvarVenda(){
        
        String codigo = cadastro.getTxtCodigo().getText();
        int quantidade = Integer.parseInt(cadastro.getTxtQuantidade().getText());
        
        Venda venda1 = new Venda(codigo, quantidade);
        
        try {
            Connection conexao = new Conexao().getConnection();
            VendaDao vendaDao = new VendaDao(conexao);
            vendaDao.insertVenda(venda1);
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioControler.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    public void preencherTabelaVendas(){
        
        String dataInicial = relatorio.getTxtInicial().getText();
        String dataFinal = relatorio.getTxtFinal().getText();
        
        Relatorio relatorio1 = new Relatorio(dataInicial, dataFinal);
        
        try {
            Connection conexao = new Conexao().getConnection();
            VendaDao vendaDao = new VendaDao(conexao);
            vendaDao.preencherTabelaVendas(relatorio1);
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioControler.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    
    
    
    
    
    
}
