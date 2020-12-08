/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufscar.dc.dsw.dao;

import br.ufscar.dc.dsw.domain.Hotel;
import br.ufscar.dc.dsw.domain.Cidade;
import br.ufscar.dc.dsw.domain.Estado;
import br.ufscar.dc.dsw.domain.Promocao;
import br.ufscar.dc.dsw.domain.Site;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;


/**
 *
 * @author ellen
 */
public class HotelDao extends GenericDao {
    
    public List<Hotel> getAll() {

        List<Hotel> listaHoteis = new ArrayList<>();

        String sql = "SELECT h.id, h.nome, h.cep, h.logradouro, h.numero, h.bairro, h.cidade_id, c.nome AS cidade, c.estado_id, e.sigla AS sigla, e.nome AS estado" +
                     " FROM Hotel h INNER JOIN Cidade c ON c.id = h.cidade_id INNER JOIN Estado e ON e.id = c.estado_id";

        try {
            Connection conn = this.getConnection();
            Statement statement = conn.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String nome = resultSet.getString("nome");
                String cep = resultSet.getString("cep");
                String logradouro = resultSet.getString("logradouro");
                int numero = resultSet.getInt("numero");
                String bairro = resultSet.getString("bairro");
                Long cidade_id = resultSet.getLong("cidade_id");
                String cidadeNome = resultSet.getString("cidade");
                Long estado_id = resultSet.getLong("estado_id");
                String estadoNome = resultSet.getString("estado");
                String sigla = resultSet.getString("sigla");
                Estado estado = new Estado(estado_id, estadoNome, sigla);
                Cidade cidade = new Cidade(cidade_id, cidadeNome, estado);
                Hotel hotel = new Hotel(id, nome, cep, logradouro, numero, bairro, cidade);
                listaHoteis.add(hotel);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaHoteis;
    }
    
    public List<Hotel> getWhereCity(String parametro) {

        List<Hotel> listaHoteis = new ArrayList<>();
        String nomeCidade = parametro.substring(0,parametro.length()-5);
        String siglaEstado = parametro.substring(nomeCidade.length()+3,parametro.length());
        
        String sql = "SELECT h.id, h.nome, h.cep, h.logradouro, h.numero, h.bairro, h.cidade_id, c.nome AS cidade, c.estado_id, e.sigla AS sigla, e.nome AS estado" +
                     " FROM Hotel h INNER JOIN Cidade c ON c.id = h.cidade_id INNER JOIN Estado e ON e.id = c.estado_id WHERE UPPER(c.nome) like ? and UPPER(e.sigla) like ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1,nomeCidade.toUpperCase());
            statement.setString(2,siglaEstado.toUpperCase());
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String nome = resultSet.getString("nome");
                String cep = resultSet.getString("cep");
                String logradouro = resultSet.getString("logradouro");
                int numero = resultSet.getInt("numero");
                String bairro = resultSet.getString("bairro");
                Long cidade_id = resultSet.getLong("cidade_id");
                String cidadeNome = resultSet.getString("cidade");
                Long estado_id = resultSet.getLong("estado_id");
                String estadoNome = resultSet.getString("estado");
                String sigla = resultSet.getString("sigla");
                Estado estado = new Estado(estado_id, estadoNome, sigla);
                Cidade cidade = new Cidade(cidade_id, cidadeNome, estado);
                Hotel hotel = new Hotel(id, nome, cep, logradouro, numero, bairro, cidade);
                listaHoteis.add(hotel);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaHoteis;
    }
    public List<Hotel> getWhereIDCity(int idCidade) {

        List<Hotel> listaHoteis = new ArrayList<>();

        String sql = "SELECT h.id, h.nome, h.cep, h.logradouro, h.numero, h.bairro, h.cidade_id, c.nome AS cidade, c.estado_id, e.sigla AS sigla, e.nome AS estado" +
                     " FROM Hotel h INNER JOIN Cidade c ON c.id = h.cidade_id INNER JOIN Estado e ON e.id = c.estado_id WHERE c.id = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, idCidade);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String nome = resultSet.getString("nome");
                String cep = resultSet.getString("cep");
                String logradouro = resultSet.getString("logradouro");
                int numero = resultSet.getInt("numero");
                String bairro = resultSet.getString("bairro");
                Long cidade_id = resultSet.getLong("cidade_id");
                String cidadeNome = resultSet.getString("cidade");
                Long estado_id = resultSet.getLong("estado_id");
                String estadoNome = resultSet.getString("estado");
                String sigla = resultSet.getString("sigla");
                Estado estado = new Estado(estado_id, estadoNome, sigla);
                Cidade cidade = new Cidade(cidade_id, cidadeNome, estado);
                Hotel hotel = new Hotel(id, nome, cep, logradouro, numero, bairro, cidade);
                listaHoteis.add(hotel);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaHoteis;
    }
    
    public Hotel getByEmail (String email){
        
        Hotel hotel = new Hotel(email);
        String sql = "SELECT h.id, h.nome, h.cep, h.logradouro, h.numero, h.bairro, h.cidade_id, c.nome AS cidade, c.estado_id, e.sigla AS sigla, e.nome AS estado" +
                     " FROM Hotel h INNER JOIN Cidade c ON c.id = h.cidade_id INNER JOIN Estado e ON e.id = c.estado_id WHERE h.email = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String nome = resultSet.getString("nome");
                String cep = resultSet.getString("cep");
                String logradouro = resultSet.getString("logradouro");
                int numero = resultSet.getInt("numero");
                String bairro = resultSet.getString("bairro");
                Long cidade_id = resultSet.getLong("cidade_id");
                String cidadeNome = resultSet.getString("cidade");
                Long estado_id = resultSet.getLong("estado_id");
                String estadoNome = resultSet.getString("estado");
                String sigla = resultSet.getString("sigla");
                Estado estado = new Estado(estado_id, estadoNome, sigla);
                Cidade cidade = new Cidade(cidade_id, cidadeNome, estado);
                hotel = new Hotel(id, nome, cep, logradouro, numero, bairro, cidade);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
        return hotel;
    }
    
}
