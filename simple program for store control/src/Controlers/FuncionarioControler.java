package Controlers;

import Frames.TelaCadastroFuncionario;
import Model.Funcionario;
import Frames.TelaGerenciarFuncionarios;
import dao.Conexao;
import dao.FuncionarioDao;
import javax.swing.JOptionPane;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FuncionarioControler {
    
    
    
    
    
    private TelaCadastroFuncionario cadastro;
    private TelaGerenciarFuncionarios gerenciar;

    public FuncionarioControler(TelaGerenciarFuncionarios gerenciar) {
        this.gerenciar = gerenciar;
    }
    
    
    public FuncionarioControler(TelaCadastroFuncionario cadastro){
        this.cadastro = cadastro;
    }

    
    
    
    
    
    public void salvarFuncionario() {
        
        
        
        String usuario = cadastro.getTxtUsuario().getText();
        String senha = cadastro.getTxtSenha().getText();
        String nome = cadastro.getTxtNome().getText();
        String email = cadastro.getTxtEmail().getText();
        String nascimento = cadastro.getTxtDatanasci().getText();
        String telefone = cadastro.getTxtTelefone().getText();
        String cpf = cadastro.getTxtCpf().getText();
        String funcao = cadastro.getComboFuncao().getSelectedItem().toString();
   
        Funcionario funcionario1 = new Funcionario(nome, nascimento, email, telefone, cpf, funcao, usuario, senha);
        
        try {
            Connection conexao = new Conexao().getConnection();
            FuncionarioDao funcionarioDao = new FuncionarioDao(conexao);
            funcionarioDao.insertFuncionario(funcionario1);
            
            
            JOptionPane.showMessageDialog(null, "Funcionario cadastrado com sucesso");
            
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioControler.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    public void excluirFuncionario() {
        
        String usuario = gerenciar.getTxtUsuario().getText();
        
        Funcionario funcionarioExcluir = new Funcionario(usuario);
        
        try {
            Connection conexao = new Conexao().getConnection();
            FuncionarioDao funcionarioDao = new FuncionarioDao(conexao);
            boolean excluir = funcionarioDao.removerFuncionario(funcionarioExcluir);
            
            if(excluir == true){
                JOptionPane.showMessageDialog(null, "Funcionario excluido com sucesso!");
                
                
            }else{
                JOptionPane.showMessageDialog(null, "usuario nao encontrado");
            }
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioControler.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
        
       
       
    }
    
    
    
    
       
        
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
        
    
    
        

