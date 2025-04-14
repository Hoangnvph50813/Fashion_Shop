/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories.Impl;

import DomainModel.Voucher;
import Repositories.IVoucherReponsitory;
import Utilities.DBcontext;
import java.sql.Connection;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Duc
 */
public class VoucherReponsitory implements IVoucherReponsitory {

    @Override
    public Integer insert(Voucher vc) {
        try {
            Connection conn = DBcontext.getConnection();
            String sql = "INSERT INTO Voucher (Ten,Ma,loai,idNguoiTao) values (?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, vc.getTen());
            ps.setString(2, vc.getMa());
            ps.setInt(3, vc.getTheLoai());
            ps.setString(4, vc.getIdUser());
            return ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return -1;
    }

    @Override
    public Integer update(String ma, Voucher ms) {
        try {
            Connection conn = DBcontext.getConnection();
            String sql = "Update Voucher set Ten = ?, Loai = ?, idNguoiTao = ? where Ma = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ms.getTen());
            ps.setInt(2, ms.getTheLoai());
            ps.setString(3, ms.getIdUser());
            return ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return -1;
    }

    @Override
    public Integer delete(String ma) {
        try {
            Connection conn = DBcontext.getConnection();
            String sql = "Delete from Voucher where Ma = ?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, ma);

            return ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return -1;
    }

    @Override
    public String checkMa(String ma) {
        String maCheck = null;
        try {
            Connection conn = DBcontext.getConnection();
            String sql = "Select Voucher from Voucher Where Ma = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ma);

            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String maSearch = rs.getString("Ma");
                maCheck = maSearch;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return maCheck;
    }

    @Override
    public Voucher getOne(String id) {
        try {
            Connection conn = DBcontext.getConnection();
            String sql = "Select Id,Ten,Ma, Loai, idNguoiTao from Voucher where Id = ? ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.execute();

            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String idSearch = rs.getString(1);
                String ten = rs.getString(2);
                String ma = rs.getString(3);
                int loai = rs.getInt(4);
                String nguoiTao = rs.getString(5);
                Voucher ms = new Voucher(idSearch, ten, ma, loai, nguoiTao);
                return ms;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Voucher> getList() {
        List<Voucher> listVc = new ArrayList<>();
        try {
            Connection conn = DBcontext.getConnection();
            String sql = "Select * from Voucher";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();

            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String idSearch = rs.getString(1);
                String ten = rs.getString(2);
                String ma = rs.getString(3);
                int loai = rs.getInt(4);
                String nguoiTao = rs.getString(5);
                Voucher ms = new Voucher(idSearch, ten, ma, loai, nguoiTao);
                listVc.add(ms);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listVc;
    }

}
