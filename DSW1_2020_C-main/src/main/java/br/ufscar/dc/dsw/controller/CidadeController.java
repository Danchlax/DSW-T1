/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufscar.dc.dsw.controller;

import br.ufscar.dc.dsw.dao.CidadeDao;
import br.ufscar.dc.dsw.domain.Cidade;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

/**
 *
 * @author ellen
 */
@WebServlet(urlPatterns = {"/buscaPorNome/*"})
public class CidadeController extends HttpServlet{
    
    private static final long serialVersionUID = 1L;

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        String nome = request.getParameter("term");

        Gson gsonBuilder = new GsonBuilder().create();
        List<String> cidades = new ArrayList<>();
        if (nome.length()>0){
            for (Cidade cidade : new CidadeDao().getAll()) {
                cidades.add(cidade.getNome()+" - "+cidade.getEstado().getSigla());          
            }
        }else{
            for (Cidade cidade : new CidadeDao().getByName(nome)) {
                cidades.add(cidade.getNome()+" - "+cidade.getEstado().getSigla());          
            }
        }
        System.out.println(gsonBuilder.toJson(cidades));
        response.getWriter().write(gsonBuilder.toJson(cidades));
        
    }
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         processRequest(request, response);
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         processRequest(request, response);
    }
    
}
