/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locacaodvds.entidades;

import java.sql.Date;

/**
 *
 * @author erich
 */
public class Ator {
    
    private int id;
    private String nome;
    private String sobrenome;
    private Date data_de_estreia;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public Date getData_de_estreia() {
        return data_de_estreia;
    }

    public void setData_de_estreia(Date data_de_estreia) {
        this.data_de_estreia = data_de_estreia;
    }
    
    
    
}
