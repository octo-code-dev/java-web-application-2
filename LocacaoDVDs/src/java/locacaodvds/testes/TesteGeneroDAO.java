/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locacaodvds.testes;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import locacaodvds.dao.GeneroDAO;
import locacaodvds.entidades.Genero;

/**
 *
 * @author erich
 */
public class TesteGeneroDAO {
    
    public static void main(String[] args) {
        
        GeneroDAO dao = null;
        
        try{
            dao = new GeneroDAO();
            
            //salvar
            /*Genero g = new Genero();
            g.setDescricao("Terror");
            dao.salvar(g);*/
            
            //atualizar
            /*Genero g = new Genero();
            g.setDescricao("Drama");
            g.setId(1);
            dao.atualizar(g);*/
            
            //excluir
            /*Genero g = new Genero();
            g.setId(1);
            dao.excluir(g);*/
            
            //listarTodos
            /*List<Genero> lista = new ArrayList<Genero>();
            lista = dao.listarTodos();
            for(int i=0;i<lista.size();i++){
                System.out.println("ID do Gênero: "+lista.get(i).getId());
                System.out.println("Descrição do Gênero: "+lista.get(i).getDescricao());
                System.out.println("");
            }*/
            
            //obterPorId
            /*Genero g = new Genero();
            g = dao.obterPorId(2);
            System.out.println("ID do Gênero: "+g.getId());
            System.out.println("Descrição do Gênero: "+g.getDescricao());*/
            
        }catch (SQLException exc){
            exc.printStackTrace();
        }finally{
            if(dao!=null){
                try{
                    dao.fecharConexao();
                }catch(SQLException exc){
                    System.out.println("Erro ao fechar conexão!");
                    exc.printStackTrace();
                }
            }
        }
        
    }
    
}
