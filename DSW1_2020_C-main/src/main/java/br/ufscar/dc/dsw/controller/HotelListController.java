/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufscar.dc.dsw.controller;

import javax.servlet.annotation.WebServlet;
import br.ufscar.dc.dsw.dao.HotelDao;
import br.ufscar.dc.dsw.domain.Hotel;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ellen
 */
@WebServlet(urlPatterns = "/hoteis/*")
public class HotelListController extends HttpServlet{
    private HotelDao dao;

    @Override
    public void init() {
        dao = new HotelDao();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException {
                
        String action = request.getPathInfo();
        if (action == null) {
            action = "";
        }

        try {
            switch (action) {
                default:
                    lista(request, response);
                    break;
            }
        } catch (RuntimeException | IOException | ServletException e) {
            throw new ServletException(e);
        }
    }

    private void lista(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Hotel> listaHoteis;
        if(request.getParameter("cidade")==null){
            listaHoteis = dao.getAll();
        }else{
            listaHoteis = dao.getWhereCity(request.getParameter("cidade"));
        }
        request.setAttribute("listaHoteis", listaHoteis);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/listaHotel.jsp");
        dispatcher.forward(request, response);
    }
    
}
