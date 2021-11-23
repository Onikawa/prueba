package Modelo;

import com.utp.model.interfaces.*;
import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteDAO implements ICRUD<Cliente> {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    @Override
    public List<Cliente> selectAll() {
        String sql = "select * from cliente";
        List<Cliente> lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cliente em = new Cliente();
                em.setId(rs.getString(1));
                em.setDni(rs.getString(2));
                em.setNom(rs.getString(3));
                em.setDirec(rs.getNString(4));
                em.setEstado(rs.getString(5));
                lista.add(em);
            }
        } catch (SQLException e2) {
        }
        return lista;
    }

    @Override
    public void insert(Cliente id) {
        String sql = "insert into cliente (Dni, Nombres, Direccion,Estado) values (?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, id.getDni());
            ps.setString(2, id.getNom());
            ps.setString(3, id.getDirec());
            ps.setString(4, id.getEstado());
            ps.executeUpdate();
        } catch (Exception e) {
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e2) {
            }
        }

    }

    @Override
    public void update(Cliente cli) {
        String sql = "update cliente set Dni=?, Nombres=?, Direccion=?, Estado=? where IdCliente=?";

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, cli.getDni());
            ps.setString(2, cli.getNom());
            ps.setString(3, cli.getDirec());
            ps.setString(4, cli.getEstado());
            ps.setString(5, cli.getId());
            ps.executeUpdate();
        } catch (Exception e) {
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e2) {
            }
        }

    }

    @Override
    public void delete(String id) {
        String sql = "delete from cliente where IdCliente=" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e2) {
            }
        }

    }

    @Override
    public Cliente selectById(String t) {
        Cliente cli = new Cliente();
        String sql = "select * from cliente where IdCliente=" + t;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {

                cli.setDni(rs.getString(2));
                cli.setNom(rs.getString(3));
                cli.setDirec(rs.getString(4));
                cli.setEstado(rs.getString(5));
     
            }
        } catch (Exception e) {
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e2) {
            }
        }
        return cli;
    }
     public Cliente selectByDni(String t) {
        Cliente cli = new Cliente();
        String sql = "select * from cliente where Dni=" + t;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                cli.setId(rs.getString(1));
                cli.setDni(rs.getString(2));
                cli.setNom(rs.getString(3));
                cli.setDirec(rs.getString(4));
                cli.setEstado(rs.getString(5));
     
            }
        } catch (Exception e) {
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e2) {
            }
        }
        return cli;
    }
 

}
