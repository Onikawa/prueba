/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Cliente;
import Modelo.ClienteDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author onikawa
 */
public class ClienteServlet extends HttpServlet {

    ClienteDAO obj = new ClienteDAO();
    Cliente em = new Cliente();
    String id;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("accion");
        switch (action) {

            case "Listar":
                ListarCliente(request, response);
                break;
            case "Agregar":
                AgregarCliente(request, response);
                break;
            case "Editar":
                EditarCliente(request, response);
                break;
            case "Actualizar":
                ActualizarCliente(request, response);
                break;

            case "Borrar":
                BorrarCliente(request, response);
                break;
            case "Buscar":
                BuscarCliente(request, response);
                break;
        }
    }

    protected void ListarCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("Clientes", obj.selectAll());
        request.getRequestDispatcher("Clientes.jsp").forward(request, response);

    }

    protected void AgregarCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String dni = request.getParameter("txtDni");
        String nom = request.getParameter("txtNombres");
        String dir = request.getParameter("txtdire");
        String est = request.getParameter("txtestado");
        em.setDni(dni);
        em.setNom(nom);
        em.setDirec(dir);
        em.setEstado(est);
        obj.insert(em);
        request.getRequestDispatcher("ClienteServlet?accion=Listar").forward(request, response);

    }

    protected void EditarCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        id = request.getParameter("id");
        Cliente e = obj.selectById(id);
        request.setAttribute("cliente", e);
        request.getRequestDispatcher("ClienteServlet?accion=Listar").forward(request, response);

    }

    protected void BuscarCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String dni = request.getParameter("codigocliente");
        Cliente e = obj.selectByDni(dni);
        request.setAttribute("cliente", e);
        request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);

    }

    protected void ActualizarCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id2 = (id);
        String dni = request.getParameter("txtDni");
        String nom = request.getParameter("txtNombres");
        String dir = request.getParameter("txtDireccion");
        String est = request.getParameter("txtestado");
        em.setDni(dni);
        em.setNom(nom);
        em.setDirec(dir);
        em.setEstado(est);
        em.setId(id2);
        obj.update(em);
        request.getRequestDispatcher("ClienteServlet?accion=Listar").forward(request, response);

    }

    protected void BorrarCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        id = request.getParameter("id");
        obj.delete(id);
        request.getRequestDispatcher("ClienteServlet?accion=Listar").forward(request, response);

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
