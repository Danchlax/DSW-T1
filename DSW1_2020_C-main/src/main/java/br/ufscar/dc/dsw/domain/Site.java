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
public class Site {
    private Long id;
    private String nome;
    private String url;
    private String email;

    public Site(Long id, String nome, String url) {
        this.id = id;
        this.nome = nome;
        this.url = url;
    }

    public Site(String nome, String url, String email) {
        this.nome = nome;
        this.url = url;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getUrl() {
        return url;
    }

    public String getEmail() {
        return email;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    
}
