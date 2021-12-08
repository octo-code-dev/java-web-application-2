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
public class DVD {
    
    private int id;
    private String titulo;
    private int ano_de_lancamento;
    private Ator ator_principal_id;
    private Ator ator_coadjuvante_id;
    private Date data_de_lancamento;
    private int duracao_em_minutos;
    private Genero genero_id;
    private ClassificacaoEtaria classificacao_etaria_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAno_de_lancamento() {
        return ano_de_lancamento;
    }

    public void setAno_de_lancamento(int ano_de_lancamento) {
        this.ano_de_lancamento = ano_de_lancamento;
    }

    public Ator getAtor_principal_id() {
        return ator_principal_id;
    }

    public void setAtor_principal_id(Ator ator_principal_id) {
        this.ator_principal_id = ator_principal_id;
    }

    public Ator getAtor_coadjuvante_id() {
        return ator_coadjuvante_id;
    }

    public void setAtor_coadjuvante_id(Ator ator_coadjuvante_id) {
        this.ator_coadjuvante_id = ator_coadjuvante_id;
    }

    public Date getData_de_lancamento() {
        return data_de_lancamento;
    }

    public void setData_de_lancamento(Date data_de_lancamento) {
        this.data_de_lancamento = data_de_lancamento;
    }

    public int getDuracao_em_minutos() {
        return duracao_em_minutos;
    }

    public void setDuracao_em_minutos(int duracao_em_minutos) {
        this.duracao_em_minutos = duracao_em_minutos;
    }

    public Genero getGenero_id() {
        return genero_id;
    }

    public void setGenero_id(Genero genero_id) {
        this.genero_id = genero_id;
    }

    public ClassificacaoEtaria getClassificacao_etaria_id() {
        return classificacao_etaria_id;
    }

    public void setClassificacao_etaria_id(ClassificacaoEtaria classificacao_etaria_id) {
        this.classificacao_etaria_id = classificacao_etaria_id;
    }
    
    
    
}
