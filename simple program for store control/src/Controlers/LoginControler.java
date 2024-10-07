package Controlers;

import Frames.TelaLogin;
import Frames.TelaPrincipal;
import Frames.TelaPrincipal_1;
import Model.Funcionario;
import dao.Conexao;
import dao.FuncionarioDao;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;



public class LoginControler {
    
    private TelaLogin view;
    
    public LoginControler(TelaLogin view){
        this.view = view;
    }

    public void autenticar() throws SQLException {
        
        String usuario = view.getTxtUsuario().getText();
        String senha = view.getTxtSenha().getText();
        
       
        
        Funcionario funcionarioLogar = new Funcionario(usuario, senha);
        
        
        Connection conexao = new Conexao().getConnection();
        FuncionarioDao funcionarioDao = new FuncionarioDao(conexao);
        
        int existe = funcionarioDao.existePorUsuarioESenha(funcionarioLogar);
        
        if(existe == 1){
            TelaPrincipal telaMenu = new TelaPrincipal();
            telaMenu.setVisible(true);
        }else if(existe == 2) {
            TelaPrincipal_1 telaMenu1 = new TelaPrincipal_1();
            telaMenu1.setVisible(true);
        }else if(existe == 4){
            JOptionPane.showMessageDialog(null, "selecione uma funcao");
        }else{
            JOptionPane.showMessageDialog(null, "usuario nao encontrado");
        }
        
        

    }
    
}
