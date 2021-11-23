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

public class ProductoDAO implements ICRUD<Producto> {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    @Override
    public List<Producto> selectAll() {
        String sql = "select * from producto";
        List<Producto> lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Producto em = new Producto();
                em.setId(rs.getString(1));
                em.setNombre(rs.getString(2));
                em.setPrecio(rs.getString(3));
                em.setStk(rs.getString(4));
                em.setEstado(rs.getString(5));
                lista.add(em);
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
        return lista;
    }

    @Override
    public void insert(Producto id) {
        String sql = "insert into producto (Nombres, Precio, Stock, Estado) values (?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, id.getNombre());
            ps.setString(2, id.getPrecio());
            ps.setString(3, id.getStk());
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
    public void update(Producto pro) {
        String sql = "update producto set Nombres=?, Precio=?, Stock=?, Estado=? where IdProducto=?";

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, pro.getNombre());
            ps.setString(2, pro.getPrecio());
            ps.setString(3, pro.getStk());
            ps.setString(4, pro.getEstado());
            ps.setString(5, pro.getId());
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
        String sql = "delete from producto where IdProducto=" + id;
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
    public Producto selectById(String t) {
        Producto pro = new Producto();
        String sql = "select * from producto where IdProducto=" + t;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                pro.setNombre(rs.getString(2));
                pro.setPrecio(rs.getString(3));
                pro.setStk(rs.getString(4));
                pro.setEstado(rs.getString(5));

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
        return pro;
    }

}
