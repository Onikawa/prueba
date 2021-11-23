/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Empleado;
import Modelo.EmpleadoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author onikawa
 */
public class Controlador extends HttpServlet {

    EmpleadoDAO obj = new EmpleadoDAO();
    Empleado em = new Empleado();
    String id ;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("accion");
        switch (action) {
            case "Principal":
                request.getRequestDispatcher("Principal.jsp").forward(request, response);
                break;
            case "Listar":
                ListarEmpleado(request, response);
                break;
            case "Agregar":
                AgregarEmpleado(request, response);
                break;
            case "Editar":
                EditarEmpleado(request, response);
                 break;
            case "Actualizar":
                ActualizarEmpleado(request, response);
                break;
  
            case "Borrar":
                BorrarEmpleado(request, response);
                break;

        }
    }

    protected void ListarEmpleado(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("empleados", obj.selectAll());
        request.getRequestDispatcher("Empleados.jsp").forward(request, response);

    }

    protected void AgregarEmpleado(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String dni = request.getParameter("txtDni");
        String nom = request.getParameter("txtNombres");
        String tel = request.getParameter("txtTel");
        String est = request.getParameter("txtestado");
        String user = request.getParameter("txtUsuario");
        em.setDni(dni);
        em.setNom(nom);
        em.setTel(tel);
        em.setEstado(est);
        em.setUser(user);
        obj.insert(em);
        request.getRequestDispatcher("Controlador?accion=Listar").forward(request, response);

    }

    protected void EditarEmpleado(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        id = request.getParameter("id");
        Empleado e = obj.selectById(id);
        request.setAttribute("empleado", e);
        request.getRequestDispatcher("Controlador?accion=Listar").forward(request, response);

    }

    protected void ActualizarEmpleado(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id2=(id);
         String dni1 = request.getParameter("txtDni");
        String nom1 = request.getParameter("txtNombres");
        String tel1 = request.getParameter("txtTel");
        String est1 = request.getParameter("txtestado");
        String user1 = request.getParameter("txtUsuario");
        em.setDni(dni1);
        em.setNom(nom1);
        em.setTel(tel1);
        em.setEstado(est1);
        em.setUser(user1);
        em.setId (id2);
        obj.update(em);
        request.getRequestDispatcher("Controlador?accion=Listar").forward(request, response);

    }
      protected void BorrarEmpleado(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            id=request.getParameter ("id");
            obj.delete (id);
            request.getRequestDispatcher("Controlador?accion=Listar").forward(request, response);

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
