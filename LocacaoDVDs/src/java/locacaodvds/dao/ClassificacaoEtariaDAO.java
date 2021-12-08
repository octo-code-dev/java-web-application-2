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
import locacaodvds.entidades.ClassificacaoEtaria;

/**
 *
 * @author erich
 */
public class ClassificacaoEtariaDAO extends DAO<ClassificacaoEtaria>{
    
    public ClassificacaoEtariaDAO() throws SQLException{
}

    @Override
    public void salvar(ClassificacaoEtaria obj) throws SQLException {
        
        String sql = "insert into classificacao_etaria (descricao) values (?)";
        PreparedStatement stmt = getConnection().prepareStatement(sql);
        
        stmt.setString(1, obj.getDescricao());
        
        stmt.executeUpdate();
        stmt.close();
        
    }

    @Override
    public void atualizar(ClassificacaoEtaria obj) throws SQLException {
        
        String sql = "update classificacao_etaria set descricao=? where id=?";
        PreparedStatement stmt = getConnection().prepareStatement(sql);
        
        stmt.setString(1, obj.getDescricao());
        stmt.setInt(2, obj.getId());
        
        stmt.executeUpdate();
        stmt.close();
        
    }

    @Override
    public void excluir(ClassificacaoEtaria obj) throws SQLException {
        
        String sql = "delete from classificacao_etaria where id=?";
        PreparedStatement stmt = getConnection().prepareStatement(sql);
        
        stmt.setInt(1, obj.getId());
        
        stmt.executeUpdate();
        stmt.close();
        
    }

    @Override
    public List<ClassificacaoEtaria> listarTodos() throws SQLException {
        
        List<ClassificacaoEtaria> lista = new ArrayList<ClassificacaoEtaria>();
        String sql = "select * from classificacao_etaria order by id";
        PreparedStatement stmt = getConnection().prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()){
            
            ClassificacaoEtaria ce = new ClassificacaoEtaria();
            
            ce.setId(rs.getInt("id"));
            ce.setDescricao(rs.getString("descricao"));
            
            lista.add(ce);
            
        }
        
        rs.close();
        stmt.close();
        
        return lista;
        
    }

    @Override
    public ClassificacaoEtaria obterPorId(int id) throws SQLException {
        
        ClassificacaoEtaria ce = null;
        String sql = "select * from classificacao_etaria where id=?";
        PreparedStatement stmt = getConnection().prepareStatement(sql);
        
        stmt.setInt(1, id);
        
        ResultSet rs = stmt.executeQuery();
        
        if (rs.next()){
            
            ce = new ClassificacaoEtaria();
            ce.setId(rs.getInt("id"));
            ce.setDescricao(rs.getString("descricao"));
            
        }
        
        rs.close();
        stmt.close();
        
        return ce;
        
    }
    
}
