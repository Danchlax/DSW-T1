/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufscar.dc.dsw.domain;

import java.sql.Date;

/**
 *
 * @author ellen
 */
public class Promocao {
    private Long id;
    private String quarto;
    private Date dataInicial;
    private Date dataFinal;
    private float valor;
    private Site site;
    private Hotel hotel;

    public Promocao(Long id, String quarto, Date dataInicial, Date dataFinal, float valor, Site site, Hotel hotel) {
        this.id = id;
        this.quarto = quarto;
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
        this.valor = valor;
        this.site = site;
        this.hotel = hotel;
    }

    public Promocao(String quarto, Date dataInicial, Date dataFinal, float valor, Site site, Hotel hotel) {
        this.quarto = quarto;
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
        this.valor = valor;
        this.site = site;
        this.hotel = hotel;
    }

    public Long getId() {
        return id;
    }

    public String getQuarto() {
        return quarto;
    }

    public Date getDataInicial() {
        return dataInicial;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public float getValor() {
        return valor;
    }

    public Site getSite() {
        return site;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setQuarto(String quarto) {
        this.quarto = quarto;
    }

    public void setDataInicial(Date dataInicial) {
        this.dataInicial = dataInicial;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public void setSite(Site site) {
        this.site = site;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
    
    
    
}
