/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locacaodvds.testes;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import locacaodvds.dao.DVDDAO;
import locacaodvds.entidades.Ator;
import locacaodvds.entidades.ClassificacaoEtaria;
import locacaodvds.entidades.DVD;
import locacaodvds.entidades.Genero;

/**
 *
 * @author erich
 */
public class TesteDVDDAO {
    public static void main(String[] args) {
        DVDDAO dao = null;
        try{
            dao = new DVDDAO();
            
            //salvar
            DVD d = new DVD();
            d.setTitulo("The Pursuit of Happyness");
            d.setAno_de_lancamento(2006);
            Ator ap = new Ator();
            ap.setId(2);
            d.setAtor_principal_id(ap);
            Ator ac = new Ator();
            ac.setId(4);
            d.setAtor_coadjuvante_id(ac);
            d.setData_de_lancamento(java.sql.Date.valueOf("2007-02-02"));
            d.setDuracao_em_minutos(117);
            Genero g = new Genero();
            g.setId(1);
            d.setGenero_id(g);
            ClassificacaoEtaria ce = new ClassificacaoEtaria();
            ce.setId(1);
            d.setClassificacao_etaria_id(ce);
            dao.salvar(d);
            
            //atualizar
            /*DVD d = new DVD();
            d.setTitulo("A Janela Secreta");
            d.setAno_de_lancamento(2004);
            Ator ap = new Ator();
            ap.setId(2);
            d.setAtor_principal_id(ap);
            Ator ac = new Ator();
            ac.setId(4);
            d.setAtor_coadjuvante_id(ac);
            d.setData_de_lancamento(java.sql.Date.valueOf("2004-03-12"));
            d.setDuracao_em_minutos(96);
            Genero g = new Genero();
            g.setId(2);
            d.setGenero_id(g);
            ClassificacaoEtaria ce = new ClassificacaoEtaria();
            ce.setId(4);
            d.setClassificacao_etaria_id(ce);
            d.setId(1);
            dao.salvar(d);*/
            
            //excluir
            /*DVD d = new DVD();
            d.setId(1);
            dao.excluir(d);*/
            
            //listarTodos
            /*List<DVD> lista = new ArrayList<DVD>();
            lista = dao.listarTodos();
            for(int i=0;i<lista.size();i++){
                System.out.println("ID do DVD: "+lista.get(i).getId());
                System.out.println("Título do DVD: "+lista.get(i).getTitulo());
                System.out.println("Ano de lançamento do DVD: "+lista.get(i).getAno_de_lancamento());
                System.out.println("ID do Ator principal do DVD: "+lista.get(i).getAtor_principal_id().getId());
                System.out.println("Nome do Ator principal do DVD: "+lista.get(i).getAtor_principal_id().getNome());
                System.out.println("Sobrenome do Ator principal do DVD: "+lista.get(i).getAtor_principal_id().getSobrenome());
                System.out.println("Data de estreia do Ator principal do DVD: "+lista.get(i).getAtor_principal_id().getData_de_estreia());
                System.out.println("ID do Ator Coadjuvante do DVD: "+lista.get(i).getAtor_coadjuvante_id().getId());
                System.out.println("Nome do Ator Coadjuvante do DVD: "+lista.get(i).getAtor_coadjuvante_id().getNome());
                System.out.println("Sobrenome do Ator Coadjuvante do DVD: "+lista.get(i).getAtor_coadjuvante_id().getSobrenome());
                System.out.println("Data de estreia do Ator Coadjuvante do DVD: "+lista.get(i).getAtor_coadjuvante_id().getData_de_estreia());
                System.out.println("Data de lançamento do DVD: "+lista.get(i).getData_de_lancamento());
                System.out.println("Duração em minutos do DVD: "+lista.get(i).getDuracao_em_minutos());
                System.out.println("ID do gênero do DVD: "+lista.get(i).getGenero_id().getId());
                System.out.println("Descrição do gênero do DVD: "+lista.get(i).getGenero_id().getDescricao());
                System.out.println("ID da Classificação Etária do DVD: "+lista.get(i).getClassificacao_etaria_id().getId());
                System.out.println("Descrição da Classificação Etária do DVD: "+lista.get(i).getClassificacao_etaria_id().getDescricao());
                System.out.println("");
            }*/
            
            //obterPorId
            /*DVD d = new DVD();
            d = dao.obterPorId(2);
                System.out.println("ID do DVD: "+d.getId());
                System.out.println("Título do DVD: "+d.getTitulo());
                System.out.println("Ano de lançamento do DVD: "+d.getAno_de_lancamento());
                System.out.println("ID do Ator principal do DVD: "+d.getAtor_principal_id().getId());
                System.out.println("Nome do Ator principal do DVD: "+d.getAtor_principal_id().getNome());
                System.out.println("Sobrenome do Ator principal do DVD: "+d.getAtor_principal_id().getSobrenome());
                System.out.println("Data de estreia do Ator principal do DVD: "+d.getAtor_principal_id().getData_de_estreia());
                System.out.println("ID do Ator Coadjuvante do DVD: "+d.getAtor_coadjuvante_id().getId());
                System.out.println("Nome do Ator Coadjuvante do DVD: "+d.getAtor_coadjuvante_id().getNome());
                System.out.println("Sobrenome do Ator Coadjuvante do DVD: "+d.getAtor_coadjuvante_id().getSobrenome());
                System.out.println("Data de estreia do Ator Coadjuvante do DVD: "+d.getAtor_coadjuvante_id().getData_de_estreia());
                System.out.println("Data de lançamento do DVD: "+d.getData_de_lancamento());
                System.out.println("Duração em minutos do DVD: "+d.getDuracao_em_minutos());
                System.out.println("ID do gênero do DVD: "+d.getGenero_id().getId());
                System.out.println("Descrição do gênero do DVD: "+d.getGenero_id().getDescricao());
                System.out.println("ID da Classificação Etária do DVD: "+d.getClassificacao_etaria_id().getId());
                System.out.println("Descrição da Classificação Etária do DVD: "+d.getClassificacao_etaria_id().getDescricao());*/
            
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
