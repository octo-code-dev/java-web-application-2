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
import locacaodvds.dao.DVDDAO;
import locacaodvds.entidades.Ator;
import locacaodvds.entidades.ClassificacaoEtaria;
import locacaodvds.entidades.DVD;
import locacaodvds.entidades.Genero;

/**
 *
 * @author erich
 */
public class DVDsServlet extends HttpServlet {

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

        DVDDAO dao = null;
        RequestDispatcher disp = null;
        String acao = request.getParameter("acao");

        try {
            dao = new DVDDAO();

            if (acao.equals("criar")) {
                String titulo = request.getParameter("titulo");
                int ano_de_lancamento = Integer.parseInt(request.getParameter("ano_de_lancamento"));
                int ator_principal_id = Integer.parseInt(request.getParameter("ator_principal_id"));
                Ator ap = new Ator();
                ap.setId(ator_principal_id);
                int ator_coadjuvante_id = Integer.parseInt(request.getParameter("ator_coadjuvante_id"));
                Ator ac = new Ator();
                ac.setId(ator_coadjuvante_id);
                String data_de_lancamento = (request.getParameter("data_de_lancamento"));
                int duracao_em_minutos = Integer.parseInt(request.getParameter("duracao_em_minutos"));
                int genero_id = Integer.parseInt(request.getParameter("genero_id"));
                Genero g = new Genero();
                g.setId(genero_id);
                int classificacao_etaria_id = Integer.parseInt(request.getParameter("classificacao_etaria_id"));
                ClassificacaoEtaria ce = new ClassificacaoEtaria();
                ce.setId(classificacao_etaria_id);
                DVD dvd = new DVD();
                dvd.setTitulo(titulo);
                dvd.setAno_de_lancamento(ano_de_lancamento);
                dvd.setAtor_principal_id(ap);
                dvd.setAtor_coadjuvante_id(ac);
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                try{
                java.util.Date data = sdf.parse(data_de_lancamento);
                dvd.setData_de_lancamento(new java.sql.Date(data.getTime()));
                }catch(ParseException exc){
                    System.out.println("Erro ao converter data de lançamento");
                    exc.printStackTrace();
                }
                dvd.setDuracao_em_minutos(duracao_em_minutos);
                dvd.setGenero_id(g);
                dvd.setClassificacao_etaria_id(ce);
                dao.salvar(dvd);
                disp = request.getRequestDispatcher("/formularios/dvd/listagem.jsp");
            } else if (acao.equals("alterar")) {
                int id = Integer.parseInt(request.getParameter("id"));
                String titulo = request.getParameter("titulo");
                int ano_de_lancamento = Integer.parseInt(request.getParameter("ano_de_lancamento"));
                int ator_principal_id = Integer.parseInt(request.getParameter("ator_principal_id"));
                Ator ap = new Ator();
                ap.setId(ator_principal_id);
                int ator_coadjuvante_id = Integer.parseInt(request.getParameter("ator_coadjuvante_id"));
                Ator ac = new Ator();
                ac.setId(ator_coadjuvante_id);
                String data_de_lancamento = (request.getParameter("data_de_lancamento"));
                int duracao_em_minutos = Integer.parseInt(request.getParameter("duracao_em_minutos"));
                int genero_id = Integer.parseInt(request.getParameter("genero_id"));
                Genero g = new Genero();
                g.setId(genero_id);
                int classificacao_etaria_id = Integer.parseInt(request.getParameter("classificacao_etaria_id"));
                ClassificacaoEtaria ce = new ClassificacaoEtaria();
                ce.setId(classificacao_etaria_id);
                DVD dvd = new DVD();
                dvd.setId(id);
                dvd.setTitulo(titulo);
                dvd.setAno_de_lancamento(ano_de_lancamento);
                dvd.setAtor_principal_id(ap);
                dvd.setAtor_coadjuvante_id(ac);
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                try{
                java.util.Date data = sdf.parse(data_de_lancamento);
                dvd.setData_de_lancamento(new java.sql.Date(data.getTime()));
                }catch(ParseException exc){
                    System.out.println("Erro ao converter data de lançamento");
                    exc.printStackTrace();
                }
                dvd.setDuracao_em_minutos(duracao_em_minutos);
                dvd.setGenero_id(g);
                dvd.setClassificacao_etaria_id(ce);
                dao.atualizar(dvd);
                disp = request.getRequestDispatcher("/formularios/dvd/listagem.jsp");
            } else if (acao.equals("excluir")) {
                int id = Integer.parseInt(request.getParameter("id"));
                DVD dvd = new DVD();
                dvd.setId(id);
                dao.excluir(dvd);
                disp = request.getRequestDispatcher("/formularios/dvd/listagem.jsp");
            } else if (acao.equals("prepAlteracao")) {
                int id = Integer.parseInt(request.getParameter("id"));
                DVD dvd = dao.obterPorId(id);
                request.setAttribute("dvd", dvd);
                disp = request.getRequestDispatcher("/formularios/dvd/alterar.jsp");
            } else if (acao.equals("prepExclusao")) {
                int id = Integer.parseInt(request.getParameter("id"));
                DVD dvd = dao.obterPorId(id);
                request.setAttribute("dvd", dvd);
                disp = request.getRequestDispatcher("/formularios/dvd/excluir.jsp");
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
