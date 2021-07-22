/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Torta;

import Modelo.Empleado;
import confing.Conexion;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author Devis vergara
 */
@WebServlet(name = "graficoTorta", urlPatterns = {"/graficoTorta"})
public class graficoTorta extends HttpServlet {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;

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

        response.setContentType("image/PNG");
        OutputStream out = response.getOutputStream();

        try {

            int pre = 0;
            int ger = 0;
            int sub = 0;
            int lid = 0;
            int ope = 0;

            try {
                String sql = "SELECT COUNT(cargoid),\n"
                        + "CASE\n"
                        + "WHEN cargoid =1 THEN'PRESIDENTE'\n"
                        + "WHEN cargoid =2 THEN'GERENTE'\n"
                        + "WHEN cargoid =3 THEN'SUBGERENTE'\n"
                        + "WHEN cargoid =4 THEN'LIDERES'\n"
                        + "WHEN cargoid =5 THEN'OPERARIOS'\n"
                        + "ELSE 'NINGUNO'\n"
                        + "END AS cargoid\n"
                        + "FROM empleado\n"
                        + "GROUP BY cargoid";
                con = Conexion.getConexion();
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();

                DefaultPieDataset data = new DefaultPieDataset();
                while (rs.next()) {
                    data.setValue(rs.getString(2) + ": " + String.valueOf(rs.getInt(1)), rs.getInt(1));
                }

                JFreeChart cha = ChartFactory.createPieChart3D("Cargo de empleados", data, true, true, true);

                int ancho = 450;
                int alto = 500;

                final PiePlot3D plot = (PiePlot3D) cha.getPlot();
                plot.setStartAngle(270);
                plot.setForegroundAlpha(0.80f);
                plot.setInteriorGap(0.03);

                ChartUtilities.writeChartAsPNG(out, cha, ancho, alto);

                ps.close();
                rs.close();
                cn.desconectar();

            } catch (Exception ex) {
            }

        } finally {
            out.close();
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
