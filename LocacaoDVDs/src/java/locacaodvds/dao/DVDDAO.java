/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locacaodvds.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import locacaodvds.entidades.Ator;
import locacaodvds.entidades.ClassificacaoEtaria;
import locacaodvds.entidades.DVD;
import locacaodvds.entidades.Genero;

/**
 *
 * @author erich
 */
public class DVDDAO extends DAO<DVD>{
    
    public DVDDAO() throws SQLException{

    }

    @Override
    public void salvar(DVD obj) throws SQLException {
        
        String sql = "insert into dvd (titulo,ano_de_lancamento,"
                + "ator_principal_id,ator_coadjuvante_id,data_de_lancamento,"
                + "duracao_em_minutos,genero_id,classificacao_etaria_id) "
                + "values (?,?,?,?,?,?,?,?)";
        
        PreparedStatement stmt = getConnection().prepareStatement(sql);
        stmt.setString(1, obj.getTitulo());
        stmt.setInt(2, obj.getAno_de_lancamento());
        stmt.setInt(3, obj.getAtor_principal_id().getId());
        stmt.setInt(4, obj.getAtor_coadjuvante_id().getId());
        stmt.setDate(5, obj.getData_de_lancamento());
        stmt.setInt(6, obj.getDuracao_em_minutos());
        stmt.setInt(7, obj.getGenero_id().getId());
        stmt.setInt(8, obj.getClassificacao_etaria_id().getId());
        
        stmt.executeUpdate();
        stmt.close();
        
    }

    @Override
    public void atualizar(DVD obj) throws SQLException {
        
        String sql = "update dvd set titulo=?,ano_de_lancamento=?,"
                + "ator_principal_id=?,ator_coadjuvante_id=?,"
                + "data_de_lancamento=?,duracao_em_minutos=?,genero_id=?,"
                + "classificacao_etaria_id=? where id=?";
        
        PreparedStatement stmt = getConnection().prepareStatement(sql);
        
        stmt.setString(1, obj.getTitulo());
        stmt.setInt(2, obj.getAno_de_lancamento());
        stmt.setInt(3, obj.getAtor_principal_id().getId());
        stmt.setInt(4, obj.getAtor_coadjuvante_id().getId());
        stmt.setDate(5, obj.getData_de_lancamento());
        stmt.setInt(6, obj.getDuracao_em_minutos());
        stmt.setInt(7, obj.getGenero_id().getId());
        stmt.setInt(8, obj.getClassificacao_etaria_id().getId());
        stmt.setInt(9, obj.getId());
        
        stmt.executeUpdate();
        stmt.close();

    }

    @Override
    public void excluir(DVD obj) throws SQLException {
        
        String sql = "delete from dvd where id=?";
        PreparedStatement stmt = getConnection().prepareStatement(sql);
        
        stmt.setInt(1, obj.getId());
        
        stmt.executeUpdate();
        stmt.close();
        
    }

    @Override
    public List<DVD> listarTodos() throws SQLException {
        
        List<DVD> lista = new ArrayList<DVD>();
        String sql = "select "
                + "d.id idDvd,"
                + "d.titulo tituloDvd,"
                + "d.ano_de_lancamento ano_de_lancamentoDvd,"
                + "ap.id idAtorPrincipal,"
                + "ap.nome nomeAtorPrincipal,"
                + "ap.sobrenome sobrenomeAtorPrincipal,"
                + "ap.data_de_estreia data_de_estreiaAtorPrincipal,"
                + "ac.id idAtorCoadjuvante,"
                + "ac.nome nomeAtorCoadjuvante,"
                + "ac.sobrenome sobrenomeAtorCoadjuvante,"
                + "ac.data_de_estreia data_de_estreiaAtorCoadjuvante,"
                + "d.data_de_lancamento data_de_lancamentoDvd,"
                + "d.duracao_em_minutos duracao_em_minutosDvd,"
                + "g.id idGenero,"
                + "g.descricao descricaoGenero,"
                + "ce.id idClassificacao_etaria,"
                + "ce.descricao descricaoClassificacao_etaria "
                + "from dvd d, genero g, classificacao_etaria ce, ator ap, ator ac "
                + "where d.ator_principal_id=ap.id and d.ator_coadjuvante_id=ac.id "
                + "and d.genero_id=g.id and d.classificacao_etaria_id=ce.id order by idDvd";
        
        PreparedStatement stmt = getConnection().prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()){
            
            DVD d = new DVD();
            Ator ap = new Ator();
            Ator ac = new Ator();
            Genero g = new Genero();
            ClassificacaoEtaria ce = new ClassificacaoEtaria();
            d.setId(rs.getInt("idDvd"));
            d.setTitulo(rs.getString("tituloDvd"));
            d.setAno_de_lancamento(rs.getInt("ano_de_lancamentoDvd"));
            d.setAtor_principal_id(ap);
            d.setAtor_coadjuvante_id(ac);
            d.setData_de_lancamento(rs.getDate("data_de_lancamentoDvd"));
            d.setDuracao_em_minutos(rs.getInt("duracao_em_minutosDvd"));
            d.setGenero_id(g);
            d.setClassificacao_etaria_id(ce);
            
            ap.setId(rs.getInt("idAtorPrincipal"));
            ap.setNome(rs.getString("nomeAtorPrincipal"));
            ap.setSobrenome(rs.getString("sobrenomeAtorPrincipal"));
            ap.setData_de_estreia(rs.getDate("data_de_estreiaAtorPrincipal"));

            ac.setId(rs.getInt("idAtorCoadjuvante"));
            ac.setNome(rs.getString("nomeAtorCoadjuvante"));
            ac.setSobrenome(rs.getString("sobrenomeAtorCoadjuvante"));
            ac.setData_de_estreia(rs.getDate("data_de_estreiaAtorCoadjuvante"));
            
            g.setId(rs.getInt("idGenero"));
            g.setDescricao(rs.getString("descricaoGenero"));
            
            ce.setId(rs.getInt("idClassificacao_etaria"));
            ce.setDescricao(rs.getString("descricaoClassificacao_etaria"));
            
            lista.add(d);
            
        }
        
        rs.close();
        stmt.close();
        
        return lista;
        
    }

    @Override
    public DVD obterPorId(int id) throws SQLException {
        
        DVD d = null;
        String sql = "select "
                + "d.id idDvd,"
                + "d.titulo tituloDvd,"
                + "d.ano_de_lancamento ano_de_lancamentoDvd,"
                + "ap.id idAtorPrincipal,"
                + "ap.nome nomeAtorPrincipal,"
                + "ap.sobrenome sobrenomeAtorPrincipal,"
                + "ap.data_de_estreia data_de_estreiaAtorPrincipal,"
                + "ac.id idAtorCoadjuvante,"
                + "ac.nome nomeAtorCoadjuvante,"
                + "ac.sobrenome sobrenomeAtorCoadjuvante,"
                + "ac.data_de_estreia data_de_estreiaAtorCoadjuvante,"
                + "d.data_de_lancamento data_de_lancamentoDvd,"
                + "d.duracao_em_minutos duracao_em_minutosDvd,"
                + "g.id idGenero,"
                + "g.descricao descricaoGenero,"
                + "ce.id idClassificacao_etaria,"
                + "ce.descricao descricaoClassificacao_etaria "
                + "from dvd d, genero g, classificacao_etaria ce, ator ap, ator ac "
                + "where d.id=? and d.ator_principal_id=ap.id and d.ator_coadjuvante_id=ac.id "
                + "and d.genero_id=g.id and d.classificacao_etaria_id=ce.id";
        
        PreparedStatement stmt = getConnection().prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        
        if(rs.next()){
            
            d = new DVD();
            Ator ap = new Ator();
            Ator ac = new Ator();
            Genero g = new Genero();
            ClassificacaoEtaria ce = new ClassificacaoEtaria();
            d.setId(rs.getInt("idDvd"));
            d.setTitulo(rs.getString("tituloDvd"));
            d.setAno_de_lancamento(rs.getInt("ano_de_lancamentoDvd"));
            d.setAtor_principal_id(ap);
            d.setAtor_coadjuvante_id(ac);
            d.setData_de_lancamento(rs.getDate("data_de_lancamentoDvd"));
            d.setDuracao_em_minutos(rs.getInt("duracao_em_minutosDvd"));
            d.setGenero_id(g);
            d.setClassificacao_etaria_id(ce);
            
            ap.setId(rs.getInt("idAtorPrincipal"));
            ap.setNome(rs.getString("nomeAtorPrincipal"));
            ap.setSobrenome(rs.getString("sobrenomeAtorPrincipal"));
            ap.setData_de_estreia(rs.getDate("data_de_estreiaAtorPrincipal"));

            ac.setId(rs.getInt("idAtorCoadjuvante"));
            ac.setNome(rs.getString("nomeAtorCoadjuvante"));
            ac.setSobrenome(rs.getString("sobrenomeAtorCoadjuvante"));
            ac.setData_de_estreia(rs.getDate("data_de_estreiaAtorCoadjuvante"));
            
            g.setId(rs.getInt("idGenero"));
            g.setDescricao(rs.getString("descricaoGenero"));
            
            ce.setId(rs.getInt("idClassificacao_etaria"));
            ce.setDescricao(rs.getString("descricaoClassificacao_etaria"));
            
        }
        
        rs.close();
        stmt.close();
        
        
        return d;
        
    }
    
}
