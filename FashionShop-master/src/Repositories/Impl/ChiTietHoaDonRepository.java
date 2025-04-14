/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories.Impl;

import DomainModel.ChiTietHoaDon;
import Repositories.IChiTietHoaDonRepository;
import Utilities.DBcontext;
import ViewModel.ChiTietHoaDonRespone;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Duc
 */
public class ChiTietHoaDonRepository implements IChiTietHoaDonRepository {

    @Override
    public List<ChiTietHoaDonRespone> getAll() {
        List<ChiTietHoaDonRespone> listCTHD = new ArrayList<>();
        try {
            Connection conn = DBcontext.getConnection();
            String sql = "select cthd.Id, cthd.IdChiTietQA,hd.MaHD,ctqa.MaQuanAo,ctqa.TenQuanAo,cthd.SoLuong,cthd.DonGia from ChiTietHoaDon cthd  join HoaDon hd on cthd.IdHD = hd.Id\n"
                    + " join ChiTietQuanAo ctqa on cthd.IdChiTietQA = ctqa.Id ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();

            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String id = rs.getString("Id");
                String idqa = rs.getString("IdChiTietQA");
                String ma = rs.getString("MaHD");
                String maqa = rs.getString("MaQuanAo");
                String ten = rs.getString("TenQuanAo");
                Integer soLuong = rs.getInt("SoLuong");
                Float donGia = rs.getFloat("DonGia");

                ChiTietHoaDonRespone cthd = new ChiTietHoaDonRespone(id, idqa, ma, maqa, ten, soLuong, donGia);
                listCTHD.add(cthd);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listCTHD;
    }

    @Override
    public Integer insert(ChiTietHoaDon cthd) {
        try {
            Connection conn = DBcontext.getConnection();
            String sql = "insert into ChiTietHoaDon(IdHD,IdChiTietQA,SoLuong,DonGia) values(?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, cthd.getIdHD());
            ps.setString(2, cthd.getIdChiTietQA());
            ps.setInt(3, cthd.getSoLuong());
            ps.setFloat(4, cthd.getDonGia());

            return ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return -1;
    }

    @Override
    public Integer update(String id, int soLuong) {
        try {
            Connection conn = DBcontext.getConnection();
            String sql = "Update ChiTietHoaDon set SoLuong = ? where Id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, soLuong);
            ps.setString(2, id);

            return ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return -1;
    }

    @Override
    public List<ChiTietHoaDonRespone> getAllByMa(String ma) {
        List<ChiTietHoaDonRespone> listCTHD = new ArrayList<>();
        try {
            Connection conn = DBcontext.getConnection();
            String sql = "select hd.MaHD,ctqa.TenQuanAo,ctqa.MaQuanAo,ctqa.SoLuong,cthd.DonGia from ChiTietHoaDon cthd  join HoaDon hd on cthd.IdHD = hd.Id\n"
                    + "                   join ChiTietQuanAo ctqa on cthd.IdChiTietQA = ctqa.Id where ctqa.MaQuanAo =  ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ma);
            ps.execute();

            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String mahd = rs.getString("MaHD");
                String maqa = rs.getString("MaQuanAo");
                String ten = rs.getString("TenQuanAo");
                Integer soLuong = rs.getInt("SoLuong");
                Float donGia = rs.getFloat("DonGia");

                ChiTietHoaDonRespone cthd = new ChiTietHoaDonRespone(mahd, maqa, ten, soLuong, donGia);
                listCTHD.add(cthd);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listCTHD;
    }

    @Override
    public List<ChiTietHoaDonRespone> getAllHD(String id) {
        List<ChiTietHoaDonRespone> listCTHD = new ArrayList<>();
        try {
            Connection conn = DBcontext.getConnection();
            String sql = "	select cthd.Id,hd.MaHD,cthd.IdChiTietQA,ctqa.MaQuanAo,ctqa.TenQuanAo,cthd.SoLuong,cthd.DonGia from HoaDon hd join ChiTietHoaDon cthd on hd.Id = cthd.IdHD\n"
                    + "							join ChiTietQuanAo ctqa on cthd.IdChiTietQA = ctqa.Id where cthd.IdHD = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.execute();

            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String idCTHD = rs.getString("Id");
                String idCTQA = rs.getString("IdChiTietQA");
                String mahd = rs.getString("MaHD");
                String maqa = rs.getString("MaQuanAo");
                String ten = rs.getString("TenQuanAo");
                Integer soLuong = rs.getInt("SoLuong");
                Float donGia = rs.getFloat("DonGia");

                ChiTietHoaDonRespone cthd = new ChiTietHoaDonRespone(idCTHD, idCTQA, mahd, maqa, ten, soLuong, donGia);
                listCTHD.add(cthd);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listCTHD;
    }

    @Override
    public Integer delete(String id) {
        try {
            Connection conn = DBcontext.getConnection();
            String sql = "Delete from ChiTietHoaDon where Id = ? ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);

            return ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return -1;
    }

    @Override
    public Integer getSLMua(String id) {
        int soLuongMua = 0;
        try {
            Connection conn = DBcontext.getConnection();
            String sql = "Select SoLuong from ChiTietHoaDon where Id = ? ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.execute();

            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                int soLuong = rs.getInt("SoLuong");
                soLuongMua = soLuong;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return soLuongMua;
    }

    @Override
    public String getIdQA(String idHD, String idqa) {
        String idQA = null;
        try {
            Connection conn = DBcontext.getConnection();
            String sql = "select IdChiTietQA from ChiTietHoaDon where IdHD = ? and IdChiTietQA = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, idHD);
            ps.setString(2, idqa);
            ps.execute();

            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String id = rs.getString("IdChiTietQA");

                idQA = id;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return idQA;
    }

    @Override
    public String loadTongHoaDon() {
        String tongHD = "";
        try {
            // Câu lệnh SQL để tính tổng số hóa đơn có tình trạng = 1
            String sql = "SELECT COUNT(*) AS total_invoices FROM HoaDon WHERE tinhTrang = 1";

            // Tạo PreparedStatement
            PreparedStatement ps = DBcontext.getConnection().prepareStatement(sql);

            // Thực hiện truy vấn và lấy kết quả
            ResultSet rs = ps.executeQuery();

            // Xử lý kết quả
            if (rs.next()) {
                // Lấy tổng số hóa đơn từ cột "total_invoices"
                int count = rs.getInt("total_invoices");
                // Chuyển đổi số nguyên thành chuỗi
                tongHD = String.valueOf(count);
            }

            // Đóng ResultSet và PreparedStatement
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // In ra tổng số hóa đơn
        System.out.println(tongHD);

        // Trả về tổng số hóa đơn dưới dạng chuỗi
        return tongHD;
    }

    @Override
    public String loadTongDoanhThu() {
        String tongDT = "";
        try {
            String sql = "SELECT SUM(donGia * soLuong) AS tongDoanhThu FROM ChiTietHoaDon";
            PreparedStatement ps = DBcontext.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                tongDT = String.valueOf(rs.getFloat("tongDoanhThu"));
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(tongDT);
        return tongDT;

    }

    @Override
    public String loadTongDoanhThuNgay(int date) {
        String totalRevenue = "";
        try {
            // Câu lệnh SQL để tính tổng doanh thu cho năm cụ thể
            String sql = "SELECT SUM(c.donGia * c.soLuong) AS tongDoanhThu "
                    + "FROM HoaDon h "
                    + "JOIN ChiTietHoaDon c ON h.Id = c.IdHD "
                    + "WHERE MONTH(h.ngayThanhToan) = ?";

            // Tạo PreparedStatement
            Connection conn = DBcontext.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            // Thiết lập giá trị cho tham số năm
            ps.setInt(1, date);

            // Thực hiện truy vấn và lấy kết quả
            ResultSet rs = ps.executeQuery();

            // Xử lý kết quả
            if (rs.next()) {
                // Lấy tổng doanh thu từ cột "tongDoanhThu"
                totalRevenue = rs.getString("tongDoanhThu");
            }

            // Đóng ResultSet và PreparedStatement
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // In ra tổng doanh thu
        System.out.println("Tổng doanh thu cho năm " + date + ": " + totalRevenue);

        // Trả về tổng doanh thu dưới dạng chuỗi
        return totalRevenue;
    }
}
