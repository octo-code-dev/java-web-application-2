/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locacaodvds.testes;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import locacaodvds.dao.AtorDAO;
import locacaodvds.entidades.Ator;

/**
 *
 * @author erich
 */
public class TesteAtorDAO {
    public static void main(String[] args) {
        AtorDAO dao = null;
        try{
        dao = new AtorDAO();
        
        //salvar
        Ator a = new Ator();
        a.setNome("Johnny");
        a.setSobrenome("Depp");
        a.setData_de_estreia(java.sql.Date.valueOf("1984-10-12"));
        dao.salvar(a);
        
        //atualizar
        /*Ator a = new Ator();
        a.setNome("Adrien");
        a.setSobrenome("Brody");
        a.setData_de_estreia(java.sql.Date.valueOf("1988-05-07"));
        a.setId(1);
        dao.atualizar(a);*/
        
        //excluir
        /*Ator a = new Ator();
        a.setId(1);
        dao.excluir(a);*/
        
        //listarTodos
        /*List<Ator> lista = new ArrayList<Ator>();
        lista = dao.listarTodos();
        for(int i=0;i<lista.size();i++){
            System.out.println("ID do Ator: "+lista.get(i).getId());
            System.out.println("Nome do Ator: "+lista.get(i).getNome());
            System.out.println("Sobrenome do Ator: "+lista.get(i).getSobrenome());
            System.out.println("Data de estreia do Ator: "+lista.get(i).getData_de_estreia());
            System.out.println("");
        }*/
        
        //obterPorId
        /*Ator a = new Ator();
        a = dao.obterPorId(2);
            System.out.println("ID do Ator: "+a.getId());
            System.out.println("Nome do Ator: "+a.getNome());
            System.out.println("Sobrenome do Ator: "+a.getSobrenome());
            System.out.println("Data de estreia do Ator: "+a.getData_de_estreia());*/
        
        }catch(SQLException exc){
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
