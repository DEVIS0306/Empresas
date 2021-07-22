package Modelo;

import confing.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jevergara
 */
public class EmpleadoDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;



    //Operaciones crud
    public List listar() {
        String sql = "select * from empleado";
        List<Empleado> lista = new ArrayList<>();
        try {
            con = Conexion.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Empleado em = new Empleado();
                em.setId(rs.getInt(1));
                em.setCc(rs.getString(2));
                em.setNom(rs.getString(3));
                em.setApell(rs.getString(4));
                em.setEdad(rs.getInt(5));
                em.setFecha(rs.getString(6));
                em.setTel(rs.getString(7));
                em.setJefes(rs.getString(8));
                em.setCargoid(rs.getInt(9));
                lista.add(em);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    public Empleado listarId(int id) {
        Empleado emp = new Empleado();
        String sql = "select * from empleado where id=" + id;
        try {
            con = Conexion.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                emp.setCc(rs.getString(2));
                emp.setNom(rs.getString(3));
                emp.setApell(rs.getString(4));
               // emp.setEdad(rs.getInt(5));
                emp.setEdad(Integer.parseInt(rs.getString(5)));
                emp.setFecha(rs.getString(6));
                emp.setTel(rs.getString(7));
                emp.setJefes(rs.getString(8));
                emp.setCargoid(rs.getInt(9));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return emp;
    }

    public int agregar(Empleado em) {
        String sql = "insert into empleado(cc, nombres, apellidos, edad, fecha_Nacimiento, telefono, jefes, cargoid) values(?,?,?,?,?,?,?,?)";
        try {
            con = Conexion.getConexion();;
            ps = con.prepareStatement(sql);
            ps.setString(1, em.getCc());
            ps.setString(2, em.getNom());
            ps.setString(3, em.getApell());
            ps.setInt(4, em.getEdad());
            ps.setString(5, em.getFecha());
            ps.setString(6, em.getTel());
            ps.setString(7, em.getJefes());
            ps.setInt(8, em.getCargoid());
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return r;
    }

    public int actualizar(Empleado em) {
        String sql = "update empleado set cc=?, nombres=?, apellidos=?, edad=?, fecha_Nacimiento=?, telefono=?, jefes=?, cargoid=? where id=?";
        try {
            con = Conexion.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, em.getCc());
            ps.setString(2, em.getNom());
            ps.setString(3, em.getApell());
            ps.setInt(4, em.getEdad());
            ps.setString(5, em.getFecha());
            ps.setString(6, em.getTel());
            ps.setString(7, em.getJefes());
            ps.setInt(8, em.getCargoid());
            ps.setInt(9, em.getId());
            ps.executeUpdate();

        } catch (Exception e) {
        }
        return r;
    }

    public void delete(int id) {
        String sql = "delete from empleado where id=" + id;
        try {
            con = Conexion.getConexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }

    }

    public List buscar(String em) {
        List<Empleado>listar= new ArrayList<>();
        String sql;
        sql="select * from empleado where id like '%"+em+"%' or cc like '%"+em+"%' or nombres like '%"+em+"%' or apellidos like '%"+em+"%' or jefes like '%"+em+"%' or cargoid like '%"+em+"%'";
        try {
             con = Conexion.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Empleado emp1 = new Empleado();
                emp1.setId(Integer.parseInt(rs.getString(1)));
                 emp1.setCc(rs.getString(2));
                emp1.setNom(rs.getString(3));
                emp1.setApell(rs.getString(4));
               // emp.setEdad(rs.getInt(5));
                emp1.setEdad(Integer.parseInt(rs.getString(5)));
                emp1.setFecha(rs.getString(6));
                emp1.setTel(rs.getString(7));
                emp1.setJefes(rs.getString(8));
                emp1.setCargoid(rs.getInt(9));
                listar.add(emp1);

            }

        } catch (Exception e) {
        }
        return listar;
    }

}