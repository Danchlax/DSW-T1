/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufscar.dc.dsw.domain;

/**
 *
 * @author ellen
 */
public class Cidade {
    
    private Long id;
    private String nome;
    private Estado estado;

    public Cidade(Long id, String nome, Estado estado) {
        this.id = id;
        this.nome = nome;
        this.estado = estado;
    }

    public Cidade(String nome, Estado estado) {
        this.nome = nome;
        this.estado = estado;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Estado getEstado() {
        return estado;
    }
    
    
    
}
