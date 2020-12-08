/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufscar.dc.dsw.controller;

import br.ufscar.dc.dsw.dao.HotelDao;
import br.ufscar.dc.dsw.dao.PromocaoDao;
import br.ufscar.dc.dsw.domain.Hotel;
import br.ufscar.dc.dsw.domain.Promocao;
import br.ufscar.dc.dsw.domain.Usuario;
import br.ufscar.dc.dsw.util.Erro;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ellen
 */
@WebServlet(urlPatterns = "/hotel/")
public class HotelController extends HttpServlet {
    
    private static final long serialVersionUID = 1L;
    
    private HotelDao dao;
    

    @Override
    public void init() {
        dao = new HotelDao();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String action = request.getPathInfo();
        if (action==null){action="";}
        Usuario usuario = (Usuario) request.getSession().getAttribute("usuarioLogado");
        System.out.print(usuario.toString());
    	Erro erros = new Erro();
    	
    	if (usuario == null) {
    		response.sendRedirect(request.getContextPath());
    	} else if (usuario.getPapel().equals("HOTEL")) {
                try {
                    switch (action) {
                        default:
                            System.out.print(usuario.getEmail());
                            listaPromocao(request, response, usuario.getEmail());
                            break;
                    }
                } catch (RuntimeException | IOException | ServletException e) {
                    throw new ServletException(e);
                }         
        } else {
                    erros.add("Acesso não autorizado!");
                    request.setAttribute("mensagens", erros);
                    RequestDispatcher rd = request.getRequestDispatcher("/noAuth.jsp");
                    rd.forward(request, response);
                } 
    }
    
    private void listaPromocao(HttpServletRequest request, HttpServletResponse response, String email)
            throws ServletException, IOException {
            PromocaoDao daoo = new PromocaoDao();
            Hotel hotel1 = dao.getByEmail(email);
            Long id = hotel1.getId();
            List<Promocao> listaPromocao = daoo.getPromocoes(id);

            request.setAttribute("listaPromocao", listaPromocao);
            request.setAttribute("hotel", hotel1);
            RequestDispatcher dispatcher = request.getRequestDispatcher("hotelHome.jsp");
            dispatcher.forward(request, response);
    }
    
}
