package dao;

import Model.Funcionario;
import java.sql.*;
import javax.swing.JOptionPane;
import Frames.TelaGerenciarFuncionarios;


public class FuncionarioDao {
    
    private final Connection connection;
    private TelaGerenciarFuncionarios gerenciar;

    public FuncionarioDao(Connection connection) {
        this.connection = connection;
    }
    
    public void insertFuncionario(Funcionario funcionario) throws SQLException{
        
        String sql = "insert into funcionarios(usuario, senha, nome, email, nascimento, telefone, cpf, funcao) values('"+funcionario.getUsuario()+"','"+funcionario.getSenhha()+"','" +funcionario.getNome()+"','"+funcionario.getEmail()+"', '"+funcionario.getDatanasci()+"','"+funcionario.getTelefone()+"', '"+funcionario.getCpf()+"','"+funcionario.getFuncao()+"');";                                                                                    
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.execute();
        
    }

    

    public boolean removerFuncionario(Funcionario excluirFuncionario) throws SQLException{
        int confirma= JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover esse funcionario?","atencao", JOptionPane.YES_NO_CANCEL_OPTION);
        if (confirma == JOptionPane.YES_OPTION){
            String sql = "delete from funcionarios * where usuario = '"+ excluirFuncionario.getUsuario()+"';";
            PreparedStatement statement = connection.prepareStatement(sql);
            
            
            statement.execute();
            return true;
            
            
        }
        return false;
    }
    
    public int existePorUsuarioESenha(Funcionario funcionarioLogar) throws SQLException {
        String sql = "select * from funcionarios where usuario = '"+funcionarioLogar.getUsuario()+"' and senha = '"+funcionarioLogar.getSenhha()+"';";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.execute();
        
        ResultSet rs = statement.getResultSet();
        
        int admin = 1;
        int atendente = 2;
        int nao = 3;
        int naoEncontrado = 4;
        
        
        if(rs.next()){
            
            String perfil = rs.getString(9);
            
            if(perfil.equals("Administrador")){
                return admin;
            }else if(perfil.equals("Atendente")) {
                return atendente;
            }else if(perfil.equals("<Selecione um Item>")){
                return naoEncontrado;
            }
            
        
        
        }
        return nao;
    }
            
    }     

