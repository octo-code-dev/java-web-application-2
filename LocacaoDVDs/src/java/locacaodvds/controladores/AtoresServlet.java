/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locacaodvds.controladores;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import locacaodvds.dao.AtorDAO;
import locacaodvds.entidades.Ator;

/**
 *
 * @author erich
 */
public class AtoresServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        AtorDAO dao = null;
        RequestDispatcher disp = null;
        String acao = request.getParameter("acao");

        try {
            dao = new AtorDAO();
            if (acao.equals("criar")) {
                String nome = request.getParameter("nome");
                String sobrenome = request.getParameter("sobrenome");
                String data_de_estreia = request.getParameter("data_de_estreia");

                Ator a = new Ator();
                a.setNome(nome);
                a.setSobrenome(sobrenome);
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                try {
                    java.util.Date data = sdf.parse(data_de_estreia);
                    a.setData_de_estreia(new java.sql.Date (data.getTime()));
                } catch (ParseException exc) {
                    exc.printStackTrace();
                }
                dao.salvar(a);
                disp = request.getRequestDispatcher("/formularios/ator/listagem.jsp");
            } else if (acao.equals("alterar")) {
                int id = Integer.parseInt(request.getParameter("id"));
                String nome = request.getParameter("nome");
                String sobrenome = request.getParameter("sobrenome");
                String data_de_estreia = (request.getParameter("data_de_estreia"));
                Ator a = new Ator();
                a.setId(id);
                a.setNome(nome);
                a.setSobrenome(sobrenome);
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                try {
                    java.util.Date data = sdf.parse(data_de_estreia);
                    a.setData_de_estreia(new java.sql.Date (data.getTime()));
                } catch (ParseException exc) {
                    exc.printStackTrace();
                }
                dao.atualizar(a);
                disp = request.getRequestDispatcher("/formularios/ator/listagem.jsp");
            } else if (acao.equals("excluir")) {
                int id = Integer.parseInt(request.getParameter("id"));
                Ator a = new Ator();
                a.setId(id);
                dao.excluir(a);
                disp = request.getRequestDispatcher("/formularios/ator/listagem.jsp");
            } else if (acao.equals("prepAlteracao")) {
                int id = Integer.parseInt(request.getParameter("id"));
                Ator a = dao.obterPorId(id);
                request.setAttribute("ator", a);
                disp = request.getRequestDispatcher("/formularios/ator/alterar.jsp");
            } else if (acao.equals("prepExclusao")) {
                int id = Integer.parseInt(request.getParameter("id"));
                Ator a = dao.obterPorId(id);
                request.setAttribute("ator", a);
                disp = request.getRequestDispatcher("/formularios/ator/excluir.jsp");
            }
        } catch (SQLException exc) {
            exc.printStackTrace();
        } finally {
            if (dao != null) {
                try {
                    dao.fecharConexao();
                } catch (SQLException exc) {
                    System.out.println("Erro ao fechar conexão!");
                    exc.printStackTrace();
                }
            }
        }
        if (disp != null) {
            disp.forward(request, response);
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
