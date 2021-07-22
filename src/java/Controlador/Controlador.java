/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Empleado;
import Modelo.EmpleadoDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jevergara
 */
public class Controlador extends HttpServlet {

    Empleado em = new Empleado();
    EmpleadoDAO edao = new EmpleadoDAO();

    int ide;
    int idc;
    int idp;

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

        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");
        if (menu.equals("Empleado")) {

            switch (accion) {
                case "Listar":
                    List lista = edao.listar();
                    request.setAttribute("empleado", lista);

                    break;
                case "Buscar":
                    String dato = request.getParameter("txtBuscar");
                    List<Empleado> listar = edao.buscar(dato);
                    request.setAttribute("empleado", listar);
                    request.getRequestDispatcher("Empleado.jsp").forward(request, response);

                    break;
                case "Editar":
                    ide = Integer.parseInt(request.getParameter("id"));
                    Empleado e = edao.listarId(ide);
                    request.setAttribute("Empleado", e);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);

                    break;
                case "Actualizar":

                    String cc1 = request.getParameter("txtCc");
                    String nom1 = request.getParameter("txtNombres");
                    String apell1 = request.getParameter("txtApellidos");
                    int edad1 = Integer.parseInt(request.getParameter("txtEdad"));
                    String fecha1 = request.getParameter("txtFecha");
                    String tel1 = request.getParameter("txtTel");
                    String jefes1 = request.getParameter("txtJefes");
                    int cargoid1 = Integer.parseInt(request.getParameter("txtCargo"));
                    em.setCc(cc1);
                    em.setNom(nom1);
                    em.setApell(apell1);
                    em.setEdad(edad1);
                    em.setFecha(fecha1);
                    em.setTel(tel1);
                    em.setJefes(jefes1);
                    em.setCargoid(cargoid1);
                    em.setId(ide);
                    edao.actualizar(em);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                case "Delete":

                    ide = Integer.parseInt(request.getParameter("id"));
                    edao.delete(ide);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                case "Agregar":
                    String cc = request.getParameter("txtCc");
                    String nom = request.getParameter("txtNombres");
                    String apell = request.getParameter("txtApellidos");
                    int edad = Integer.parseInt(request.getParameter("txtEdad"));
                    String fecha = request.getParameter("txtFecha");
                    String tel = request.getParameter("txtTel");
                    String jefes = request.getParameter("txtJefes");
                    int cargoid = Integer.parseInt(request.getParameter("txtCargo"));
                    em.setCc(cc);
                    em.setNom(nom);
                    em.setApell(apell);
                    em.setEdad(edad);
                    em.setFecha(fecha);
                    em.setTel(tel);
                    em.setJefes(jefes);
                    em.setCargoid(cargoid);
                    edao.agregar(em);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);

                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("Empleado.jsp").forward(request, response);
        }
        if (menu.equals("inicio")) {
            request.getRequestDispatcher("inicio.jsp").forward(request, response);
        }
          if (menu.equals("Estadistica")) {
            request.getRequestDispatcher("Estadistica.jsp").forward(request, response);
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
