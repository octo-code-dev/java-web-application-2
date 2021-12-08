/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locacaodvds.controladores;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import locacaodvds.dao.GeneroDAO;
import locacaodvds.entidades.Genero;

/**
 *
 * @author erich
 */
public class GenerosServlet extends HttpServlet {

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

        GeneroDAO dao = null;
        RequestDispatcher disp = null;
        String acao = request.getParameter("acao");

        try {

            dao = new GeneroDAO();

            if (acao.equals("criar")) {

                String descricao = request.getParameter("descricao");

                Genero g = new Genero();
                g.setDescricao(descricao);

                dao.salvar(g);

                disp = request.getRequestDispatcher("/formularios/genero/listagem.jsp");

            } else if (acao.equals("alterar")) {
                int id = 0;
                id = Integer.parseInt(request.getParameter("id"));
                String descricao = request.getParameter("descricao");

                Genero g = new Genero();
                g.setId(id);
                g.setDescricao(descricao);

                dao.atualizar(g);

                disp = request.getRequestDispatcher("/formularios/genero/listagem.jsp");

            } else if (acao.equals("excluir")) {

                int id = Integer.parseInt(request.getParameter("id"));

                Genero g = new Genero();
                g.setId(id);
                dao.excluir(g);

                disp = request.getRequestDispatcher("/formularios/genero/listagem.jsp");

            } else if (acao.equals("prepAlteracao")) {

                int id = Integer.parseInt(request.getParameter("id"));
                Genero g = dao.obterPorId(id);
                request.setAttribute("genero", g);

                disp = request.getRequestDispatcher("/formularios/genero/alterar.jsp");

            } else if (acao.equals("prepExclusao")) {

                int id = Integer.parseInt(request.getParameter("id"));
                Genero g = dao.obterPorId(id);
                request.setAttribute("genero", g);

                disp = request.getRequestDispatcher("/formularios/genero/excluir.jsp");

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
