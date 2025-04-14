/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Impl;

import DomainModel.Voucher;
import Repositories.IUsersReponsitory;
import Repositories.IVoucherReponsitory;
import Repositories.Impl.UsersReponsitory;
import Repositories.Impl.VoucherReponsitory;
import Service.IVoucherService;
import java.util.ArrayList;

/**
 *
 * @author Duc
 */
public class VoucherService implements IVoucherService {

    private IVoucherReponsitory vc;
    private IUsersReponsitory usr;

    public VoucherService() {
        this.usr = new UsersReponsitory();
        this.vc = new VoucherReponsitory();
    }

    @Override
    public ArrayList<Voucher> getlist() {
        return (ArrayList<Voucher>) this.vc.getList();
    }

    @Override
    public Integer them(Voucher vc) {
        try {
            this.vc.insert(vc);
        } catch (Exception e) {
        }
        return -1;
    }

    @Override
    public Integer xoa(String id) {
        try {
            this.vc.delete(id);
        } catch (Exception e) {
        }
        return -1;
    }

    @Override
    public Integer sua(String id, Voucher vc) {
        try {
            this.vc.update(id, vc);
        } catch (Exception e) {
        }
        return -1;
    }

    @Override
    public String checkMa(String ma) {
        return this.vc.checkMa(ma);
    }

    @Override
    public Integer getLoai(String loai) {
        int result;
        if (loai.equals("3")) {
            result = 1;
        }
        if (loai.equals("5")) {
            result = 2;
        } else {
            result = 3;
        }
        return result;
    }

    @Override
    public String getNguoiTaoById(String id) {
        String result = "";
        for (var temp : usr.selectAll()) {
            if (temp.getId().equals(id)) {
                result = temp.getHoten();
            }
        }
        return result;
    }

}
