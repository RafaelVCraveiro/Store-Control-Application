package Controlers;

import Frames.*;
import Model.Venda;
import java.util.ArrayList;
import java.util.List;


public class Executavel {

    public static List<Venda> vendas;
    
    
    public static void main(String args[]){
        
        vendas = new ArrayList<Venda>();
        
        
        TelaLogin telalog = new TelaLogin();
        telalog.setVisible(true);   
        
    }
    
    
}
