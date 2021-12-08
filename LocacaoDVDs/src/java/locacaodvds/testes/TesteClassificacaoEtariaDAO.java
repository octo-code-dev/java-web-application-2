/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locacaodvds.testes;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import locacaodvds.dao.ClassificacaoEtariaDAO;
import locacaodvds.entidades.ClassificacaoEtaria;

/**
 *
 * @author erich
 */
public class TesteClassificacaoEtariaDAO {
    
    public static void main(String[] args) {
        ClassificacaoEtariaDAO dao = null;
        try{
            dao = new ClassificacaoEtariaDAO();
            
            //salvar
            ClassificacaoEtaria ce = new ClassificacaoEtaria();
            ce.setDescricao("Livre");
            dao.salvar(ce);
            
            //atualizar
            /*ClassificacaoEtaria ce = new ClassificacaoEtaria();
            ce.setDescricao("12 anos");
            ce.setId(1);
            dao.atualizar(ce);*/
            
            //excluir
            /*ClassificacaoEtaria ce = new ClassificacaoEtaria();
            ce.setId(1);
            dao.excluir(ce);*/
            
            //listarTodos
            /*List<ClassificacaoEtaria> lista = new ArrayList<ClassificacaoEtaria>();
            lista = dao.listarTodos();
            for(int i=0;i<lista.size();i++){
                System.out.println("ID da Classificação Etária: "+lista.get(i).getId());
                System.out.println("Descrição da Classificação Etária: "+lista.get(i).getDescricao());
                System.out.println("");
            }*/
            
            //obterPorId
            /*ClassificacaoEtaria ce = new ClassificacaoEtaria();
            ce = dao.obterPorId(2);
            System.out.println("ID da Classificação Etária: "+ce.getId());
            System.out.println("Descrição da Classificação Etária: "+ce.getDescricao());*/
            
        }catch(SQLException exc){
            exc.printStackTrace();
        } finally{
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
