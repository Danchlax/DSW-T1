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
public class Usuario {

    private Long id;
    private String email;
    private String senha;
    private String papel;
    
    public Usuario(Long id) {
		this.id = id;
	}

    public Usuario(String email, String senha, String papel) {
        super();
        this.email = email;
        this.senha = senha;
        this.papel = papel;
    }

    public Usuario(Long id, String email, String senha, String papel) {
        super();
        this.id = id;
        this.email = email;
        this.senha = senha;
        this.papel = papel;
    }

    public Usuario(String email) {
        this.email = email;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setPapel(String papel) {
        this.papel = papel;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public String getPapel() {
        return papel;
    }
    
    
}
