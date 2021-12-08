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
import locacaodvds.entidades.Genero;

/**
 *
 * @author erich
 */
public class GeneroDAO  extends DAO<Genero>{
    
    public GeneroDAO() throws SQLException{
}

    @Override
    public void salvar(Genero obj) throws SQLException {
        
        String sql = "insert into genero (descricao) values (?)";
        PreparedStatement stmt = getConnection().prepareStatement(sql);
        
        stmt.setString(1, obj.getDescricao());
        
        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public void atualizar(Genero obj) throws SQLException {
        
        String sql = "update genero set descricao=? where id=?";
        PreparedStatement stmt = getConnection().prepareStatement(sql);
        
        stmt.setString(1, obj.getDescricao());
        stmt.setInt(2, obj.getId());
        
        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public void excluir(Genero obj) throws SQLException {
        
        String sql = "delete from genero where id=?";
        PreparedStatement stmt = getConnection().prepareStatement(sql);
        
        stmt.setInt(1, obj.getId());
        
        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public List<Genero> listarTodos() throws SQLException {
        
        String sql = "select * from genero order by id";
        PreparedStatement stmt = getConnection().prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        
        List<Genero> lista = new ArrayList<Genero>();
        
        while (rs.next()){
            
            Genero g = new Genero();
                
            g.setId(rs.getInt("id"));
            g.setDescricao(rs.getString("descricao"));
            
            lista.add(g);
            
        }
        rs.close();
        stmt.close();
        
        return lista;
    }

    @Override
    public Genero obterPorId(int id) throws SQLException {
        
        String sql = "select * from genero where id=?";
        PreparedStatement stmt = getConnection().prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        
        Genero g = null;
        
        if(rs.next()){
            
            g = new Genero();
            g.setId(rs.getInt("id"));
            g.setDescricao(rs.getString("descricao"));
            
        }
        rs.close();
        stmt.close();
        
        return g;
    }
    
}
