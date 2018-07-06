
package Controles;


import DAOs.DAOFuncionario;
import Entidades.Funcionario;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author a1712209
 */
@WebServlet(name = "FuncionarioServlet", urlPatterns = {"/funcionario"})
public class FuncionarioServlet extends HttpServlet {
    
    Locale ptBr = new Locale("pt", "BR");
    NumberFormat formatoDinheiro = NumberFormat.getCurrencyInstance(ptBr);

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
        response.setContentType("text/html;charset=UTF-8");
        String nomeFuncionario = "";

        try (PrintWriter out = response.getWriter()) {
            nomeFuncionario = request.getParameter("nomeFuncionario");

            String resultado = "";
            if (nomeFuncionario == null || nomeFuncionario.equals("")) {
                resultado = listaFuncionariosCadastrados();
            } else {
                resultado = listaFuncionarioNome(nomeFuncionario);
            }
            request.getSession().setAttribute("resultado3", resultado);
            response.sendRedirect(request.getContextPath() + "/paginas/funcionario.jsp");
        }
    }

    protected String listaFuncionarioNome(String nomeFuncionario) {
             DAOFuncionario funcionario = new DAOFuncionario();
        String tabela = "";
        List<Funcionario> lista = funcionario.listByNomeFuncionario(tabela);
        for (Funcionario l : lista) {
            tabela += "<tr>"
                    + "<td>" + l.getId()+ "</td>"
                    + "<td>" + l.getNomeFuncionario()+ "</td>"
                    + "<td>" + l.getEndereco()+"</td>"
                    + "<td>" + l.getTelefone()+ "</td>"
                    + "<td>" + l.getEmail()+ "</td>"
                   
                    + "</tr>";
        }
        
        return tabela;
    }

    protected String listaFuncionariosCadastrados() {
        DAOFuncionario funcionario = new DAOFuncionario();
        String tabela = "";
        List<Funcionario> lista = funcionario.listByNomeFuncionario(tabela);
        for (Funcionario l : lista) {
            tabela += "<tr>"
                    + "<td>" + l.getId()+ "</td>"
                    + "<td>" + l.getNomeFuncionario()+ "</td>"
                    + "<td>" + l.getEndereco()+"</td>"
                    + "<td>" + l.getTelefone()+ "</td>"
                    + "<td>" + l.getEmail()+ "</td>"
                    + "</tr>";
        }

        return tabela;
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
        System.out.println("teste doget");
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
        System.out.println("teste dopost");
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
