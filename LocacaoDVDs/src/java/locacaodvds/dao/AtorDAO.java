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

/**
 *
 * @author erich
 */
public class AtorDAO extends DAO<Ator>{
    
    public AtorDAO() throws SQLException{
    }

    @Override
    public void salvar(Ator obj) throws SQLException {
        
        String sql = "insert into ator (nome,sobrenome,data_de_estreia) values (?,?,?)";
        PreparedStatement stmt = getConnection().prepareStatement(sql);
        
        stmt.setString(1, obj.getNome());
        stmt.setString(2, obj.getSobrenome());
        stmt.setDate(3, obj.getData_de_estreia());
        
        stmt.executeUpdate();
        stmt.close();
        
    }

    @Override
    public void atualizar(Ator obj) throws SQLException {
        
        String sql = "update ator set nome=?,sobrenome=?,data_de_estreia=? where id=?";
        PreparedStatement stmt = getConnection().prepareStatement(sql);
        
        stmt.setString(1, obj.getNome());
        stmt.setString(2, obj.getSobrenome());
        stmt.setDate(3, obj.getData_de_estreia());
        stmt.setInt(4, obj.getId());
        
        stmt.executeUpdate();
        stmt.close();
        
    }

    @Override
    public void excluir(Ator obj) throws SQLException {
        
        String sql = "delete from ator where id=?";
        PreparedStatement stmt = getConnection().prepareStatement(sql);
        
        stmt.setInt(1, obj.getId());
        
        stmt.executeUpdate();
        stmt.close();
        
    }

    @Override
    public List<Ator> listarTodos() throws SQLException {
        
        List<Ator> lista = new ArrayList<Ator>();
        String sql = "select * from ator order by id";
        PreparedStatement stmt = getConnection().prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()){
            
            Ator a = new Ator();
            a.setId(rs.getInt("id"));
            a.setNome(rs.getString("nome"));
            a.setSobrenome(rs.getString("sobrenome"));
            a.setData_de_estreia(rs.getDate("data_de_estreia"));
            
            lista.add(a);
            
        }
        
        rs.close();
        stmt.close();
        
        return lista;
    }

    @Override
    public Ator obterPorId(int id) throws SQLException {
        
        Ator a = null;
        String sql = "select * from ator where id=?";
        PreparedStatement stmt = getConnection().prepareStatement(sql);
        
        stmt.setInt(1, id);
        
        ResultSet rs = stmt.executeQuery();
        
        if(rs.next()){
            
            a = new Ator();
            a.setId(rs.getInt("id"));
            a.setNome(rs.getString("nome"));
            a.setSobrenome(rs.getString("sobrenome"));
            a.setData_de_estreia(rs.getDate("data_de_estreia"));
            
        }
        
        rs.close();
        stmt.close();
        
        return a;
        
    }
    
}
