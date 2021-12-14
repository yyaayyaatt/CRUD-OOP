/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud.oop.dao;

import com.mysql.jdbc.Statement;
import crud.oop.koneksi.DBConnection;
import crud.oop.model.Mahasiswa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

/**
 *
 * @author yyaayyaatt
 */
public class MahasiswaDao {

    private Connection conn;
    private PreparedStatement stmt;
    private Statement statement;
    private ResultSet resultSet;
    private Mahasiswa mahasiswa;

    public Mahasiswa save(Mahasiswa mahasiswa) {
        conn = new DBConnection().connect();

        try {
            String query = "insert into mahasiswa (nim,nama,alamat,jk) values (?,?,?,?)";
            stmt = conn.prepareStatement(query);
            try {
                stmt.setString(1, mahasiswa.getNim());
                stmt.setString(2, mahasiswa.getNama());
                stmt.setString(3, mahasiswa.getAlamat());
                stmt.setString(4, mahasiswa.getJk());

                stmt.executeUpdate();
                System.out.println("Data Berhasil disimpan.");
                JOptionPane.showMessageDialog(null, "Data Berhasil disimpan.");

            } catch (SQLException ex) {
                Logger.getLogger(MahasiswaDao.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Data gagal disimpan.");
            }
            stmt.close();
        } catch (Exception e) {
            Logger.getLogger(MahasiswaDao.class.getName()).log(Level.SEVERE, null, e);

        }
        return mahasiswa;
    }

    public List<Mahasiswa> getAll() {

        conn = new DBConnection().connect();
        List<Mahasiswa> mahasiswas = null;
        try {
            mahasiswas = new ArrayList<>();
            String query = "select * from Mahasiswa";
            statement = (Statement) conn.createStatement();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                mahasiswa = new Mahasiswa();
                mahasiswa.setNim(resultSet.getString("nim"));
                mahasiswa.setNama(resultSet.getString("nama"));
                mahasiswa.setAlamat(resultSet.getString("alamat"));
                mahasiswa.setJk(resultSet.getString("jk"));
                mahasiswas.add(mahasiswa);
            }

        } catch (SQLException ex) {
            Logger.getLogger(MahasiswaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mahasiswas;
    }

    public Mahasiswa Edit(Mahasiswa mahasiswa) {
        conn = new DBConnection().connect();

        String query = "update mahasiswa set nama=?, alamat=?, jk=? where nim=?";
        try {
            stmt = conn.prepareStatement(query);
            try {
                stmt.setString(1, mahasiswa.getNama());
                stmt.setString(2, mahasiswa.getAlamat());
                stmt.setString(3, mahasiswa.getJk());
                stmt.setString(4, mahasiswa.getNim());
                stmt.executeUpdate();
                System.out.println("Data berhasil diubah.");
            } catch (SQLException ex) {
                Logger.getLogger(MahasiswaDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            stmt.close();
        } catch (Exception ex) {
            Logger.getLogger(MahasiswaDao.class.getName()).log(Level.SEVERE, null, ex);

        }
        return mahasiswa;
    }

    public Mahasiswa getNim(Mahasiswa mahasiswa) {
        conn = new DBConnection().connect();
        try {
            String query = "select * from mahasiswa where nim='" + mahasiswa.getNim() + "'";
            statement = (Statement) conn.createStatement();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                mahasiswa = new Mahasiswa();
                mahasiswa.setNim(resultSet.getString("nim"));
                mahasiswa.setNama(resultSet.getString("nama"));
                mahasiswa.setAlamat(resultSet.getString("alamat"));
                if (resultSet.getString("jk").equals("L")) {
                    mahasiswa.setJk("L");
                } else {
                    mahasiswa.setJk("P");
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(MahasiswaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mahasiswa;
    }

    public Mahasiswa hapus(Mahasiswa mahasiswa) {
        conn = new DBConnection().connect();

        try {
            String query = "delete from mahasiswa where nim=?";
            stmt = conn.prepareStatement(query);
            try {
                stmt.setString(1, mahasiswa.getNim());
                stmt.executeUpdate();
                System.out.println("Data Berhasil dihapus.");
            } catch (SQLException ex) {
                Logger.getLogger(MahasiswaDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            stmt.close();
        } catch (Exception ex) {
            Logger.getLogger(MahasiswaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mahasiswa;
    }
}
