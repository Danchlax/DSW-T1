/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufscar.dc.dsw.dao;

import br.ufscar.dc.dsw.domain.Hotel;
import br.ufscar.dc.dsw.domain.Promocao;
import br.ufscar.dc.dsw.domain.Site;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ellen
 */
public class PromocaoDao extends GenericDao {
    
    public List<Promocao> getPromocoes(Long idHotel) {

        List<Promocao> listaPromocao = new ArrayList<>();

        String sql = "SELECT p.quarto, p.valor, p.dataInicial, p.dataFinal, p.site_id, s.nome AS site, s.url FROM Promocao p "
                   + "INNER JOIN Site s ON s.id = p.site_id INNER JOIN hotel h ON h.id = p.hotel_id WHERE p.hotel_id = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setLong(1, idHotel);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String quarto = resultSet.getString("quarto");
                float valor = resultSet.getFloat("valor");
                Date dataInicial = resultSet.getDate("dataInicial");
                Date dataFinal = resultSet.getDate("dataFinal");
                Long site_id = resultSet.getLong("site_id");
                String siteNome = resultSet.getString("site");
                String url = resultSet.getString("url");
                Site site = new Site(site_id, siteNome, url);
                Hotel hotel = new Hotel(idHotel);
                Promocao promocao = new Promocao(quarto, dataInicial, dataFinal, valor, site, hotel);
                listaPromocao.add(promocao);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaPromocao;
    }
    
}
