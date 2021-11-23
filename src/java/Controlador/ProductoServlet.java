/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Producto;
import Modelo.ProductoDAO;
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
public class ProductoServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
       ProductoDAO obj = new ProductoDAO();
    Producto em = new Producto();
    String id ;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
           String action = request.getParameter("accion");
        switch (action) {
            case "Principal":
                request.getRequestDispatcher("Principal.jsp").forward(request, response);
                break;
            case "Listar":
                ListarPoducto(request, response);
                break;
            case "Agregar":
                AgregarPoducto(request, response);
                break;
            case "Editar":
                EditarPoducto(request, response);
                 break;
            case "Actualizar":
                ActualizarPoducto(request, response);
                break;
  
            case "Borrar":
                BorrarPoducto(request, response);
                break;

        }
        }
     protected void ListarPoducto(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("Producto", obj.selectAll());
        request.getRequestDispatcher("Productos.jsp").forward(request, response);

    }

    protected void AgregarPoducto(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String prec = request.getParameter("txtpre");
        String nom = request.getParameter("txtNombres");
        String Stock = request.getParameter("txtStock");
        String est = request.getParameter("txtestado");
        em.setPrecio(prec);
        em.setNombre(nom);
        em.setStk(Stock);
        em.setEstado(est);
        obj.insert(em);
        request.getRequestDispatcher("ProductoServlet?accion=Listar").forward(request, response);

    }

    protected void EditarPoducto(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        id = request.getParameter("id");
        Producto e = obj.selectById(id);
        request.setAttribute("producto", e);
        request.getRequestDispatcher("ProductoServlet?accion=Listar").forward(request, response);

    }
    

    protected void ActualizarPoducto(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id2=(id);
          String prec = request.getParameter("txtpre");
        String nom = request.getParameter("txtNombres");
        String Stock = request.getParameter("txtStock");
        String est = request.getParameter("txtestado");
        em.setPrecio(prec);
        em.setNombre(nom);
        em.setStk(Stock);
        em.setEstado(est);
        em.setId(id2);
        obj.update(em);
        request.getRequestDispatcher("ProductoServlet?accion=Listar").forward(request, response);

    }
      protected void BorrarPoducto(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            id=request.getParameter ("id");
            obj.delete (id);
            request.getRequestDispatcher("ProductoServlet?accion=Listar").forward(request, response);

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
