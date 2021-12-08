/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locacaodvds.servicos;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import locacaodvds.dao.DVDDAO;
import locacaodvds.entidades.DVD;

/**
 *
 * @author erich
 */
public class DVDServices {
    public List<DVD> getTodos(){
        List<DVD> lista = new ArrayList<DVD>();
        DVDDAO dao = null;
        try{
            dao = new DVDDAO();
            lista = dao.listarTodos();
        }catch (SQLException exc){
            exc.printStackTrace();
        }finally{
            if(dao!=null){
                try{
                    dao.fecharConexao();
                }catch (SQLException exc){
                    System.out.println("Erro ao fechar conexão!");
                    exc.printStackTrace();
                }
            }
        }
        return lista;
    }
}
