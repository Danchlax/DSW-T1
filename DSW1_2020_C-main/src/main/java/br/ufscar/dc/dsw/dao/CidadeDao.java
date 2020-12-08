/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufscar.dc.dsw.dao;

import br.ufscar.dc.dsw.domain.Cidade;
import br.ufscar.dc.dsw.domain.Estado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ellen
 */
public class CidadeDao extends GenericDao{
        
    

    public List<Cidade> getAll() {
        List<Cidade> listaCidades = new ArrayList<>();
        String sql = "SELECT c.id, c.nome, c.estado_id, e.nome as estadoNome, e.sigla AS sigla FROM Cidade c INNER JOIN Estado e ON e.id = c.estado_id ORDER BY c.nome";
        try {
            Connection conn = this.getConnection();
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Long id = Long.parseLong(resultSet.getString("id"));    
                String nome = resultSet.getString("nome");    
                Long estado_id = Long.parseLong(resultSet.getString("estado_id")); 
                String estadoNome = resultSet.getString("estadoNome"); 
                String sigla = resultSet.getString("sigla");
                Estado estado = new Estado(estado_id, estadoNome, sigla);
                Cidade cidade = new Cidade(id,nome, estado);
                listaCidades.add(cidade);
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaCidades;
    }
    public List<Cidade> getByName(String n) {
        List<Cidade> listaCidades = new ArrayList<>();
        String sql = "SELECT c.id, c.nome, c.estado_id, e.nome as estadoNome, e.sigla AS sigla FROM Cidade c INNER JOIN Estado e ON e.id = c.estado_id WHERE UPPER(c.nome) like ? ORDER BY c.nome";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, '"'+n.toUpperCase()+'"');
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Long id = Long.parseLong(resultSet.getString("id"));    
                String nome = resultSet.getString("nome");    
                Long estado_id = Long.parseLong(resultSet.getString("estado_id")); 
                String estadoNome = resultSet.getString("estadoNome"); 
                String sigla = resultSet.getString("sigla");
                Estado estado = new Estado(estado_id, estadoNome, sigla);
                Cidade cidade = new Cidade(id,nome,estado);
                listaCidades.add(cidade);
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaCidades;
    }
    
}
