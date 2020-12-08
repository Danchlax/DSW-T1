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
public class Hotel {
    
    private Long id;
    private String email;
    private String nome;
    private String cep;
    private String logradouro;
    private int numero;
    private String bairro;
    private Cidade cidade;

    public Hotel(Long id, String nome, String cep, String logradouro, int numero, String bairro, Cidade cidade) {
        this.id = id;
        this.nome = nome;
        this.cep = cep;
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
    }

    public Hotel(String nome, String email, String cep, String logradouro, int numero, String bairro, Cidade cidade) {
        this.nome = nome;
        this.cep = cep;
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
    }

    public Hotel(Long id) {
        this.id = id;
    }

    public Hotel(String email) {
        this.email = email;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCep() {
        return cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public int getNumero() {
        return numero;
    }

    public String getBairro() {
        return bairro;
    }

    public Cidade getCidade() {
        return cidade;
    }
    
    
}
