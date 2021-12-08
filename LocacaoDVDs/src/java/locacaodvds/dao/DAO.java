/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locacaodvds.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import locacaodvds.jdbc.ConnectionFactory;

/**
 *
 * @author erich
 */
public abstract class DAO<T extends Object> {
    
    private Connection conexao;
    
    public DAO() throws SQLException {
        
        conexao = ConnectionFactory.getConnection();
        
    }
    
    public Connection getConnection(){
        return conexao;
    }
    
    public void fecharConexao() throws SQLException {
        conexao.close();
    }
    
    public abstract void salvar(T obj) throws SQLException;
    
    public abstract void atualizar(T obj) throws SQLException;
    
    public abstract void excluir(T obj) throws SQLException;
    
    public abstract List<T> listarTodos() throws SQLException;
    
    public abstract T obterPorId(int id) throws SQLException;
    
}
