/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Impl;

import DomainModel.ChiTietQuanAo;
import Repositories.IChiTietQuanAoRepository;
import Repositories.IKichCoReponsitory;
import Repositories.IMauSacRepository;
import Repositories.ITheLoaiReponsitory;
import Repositories.Impl.ChiTietQuanAoRepository;
import Repositories.Impl.KichCoReponsitory;
import Repositories.Impl.MauSacRepository;
import Repositories.Impl.TheLoaiReponsitory;
import Service.IChiTietQuanAoService;
import ViewModel.ChiTietQuanAoRespone;
import java.util.List;

/**
 *
 * @author Duc
 */
public class ChiTietQuanAoService implements IChiTietQuanAoService {

    private IChiTietQuanAoRepository chiTietQuanAoRepository;
    private IMauSacRepository mauSacRepository;
    private IKichCoReponsitory kichCoReponsitory;
    private ITheLoaiReponsitory theLoaiReponsitory;

    public ChiTietQuanAoService() {
        chiTietQuanAoRepository = new ChiTietQuanAoRepository();
        mauSacRepository = new MauSacRepository();
        kichCoReponsitory = new KichCoReponsitory();
        theLoaiReponsitory = new TheLoaiReponsitory();

    }

    @Override
    public List<ChiTietQuanAoRespone> getAllCTQA() {
        return chiTietQuanAoRepository.getAll();
    }

    @Override
    public Integer insert(ChiTietQuanAo ctqa) {
        try {
            return chiTietQuanAoRepository.insert(ctqa);
        } catch (Exception e) {
            return -1;
        }
    }

    @Override
    public Integer update(ChiTietQuanAo ctqa, String ma) {
        try {
            return chiTietQuanAoRepository.update(ctqa, ma);
        } catch (Exception e) {
            return -1;
        }
    }

    @Override
    public Integer delete(String ma) {
        try {
            return chiTietQuanAoRepository.delete(ma);
        } catch (Exception e) {
            return -1;
        }
    }

    @Override
    public List<ChiTietQuanAoRespone> searchByMa(String ma) {
        return chiTietQuanAoRepository.getListByMa(ma);
    }

    @Override
    public String checkMa(String ma) {
        try {
            return chiTietQuanAoRepository.checkMa(ma);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<ChiTietQuanAo> getAll() {
        return chiTietQuanAoRepository.getQuanAo();
    }

    @Override
    public Integer updateSoLuong(String id, int soLuong) {
        try {
            return chiTietQuanAoRepository.updateSoLuong(id, soLuong);
        } catch (Exception e) {
            return -1;
        }
    }

    @Override
    public Integer getSLTon(String id) {
        try {
            return chiTietQuanAoRepository.getSoLuong(id);
        } catch (Exception e) {
            return -1;
        }
    }

    @Override
    public String getNameColorByID(String id) {
        String ms = "";
        for (var temp : mauSacRepository.getList()) {
            if (temp.getId().equals(id)) {
                ms = temp.getTen();
            }
        }

        return ms;
    }

    @Override
    public String getNameSizeByID(String id) {
        String ms = "";
        for (var temp : kichCoReponsitory.getAll()) {
            if (temp.getId().equals(id)) {
                ms = temp.getSize();
            }
        }

        return ms;
    }

    @Override
    public String getNameTypeByID(String id) {
        String ms = "";
        for (var temp : theLoaiReponsitory.getAll()) {
            if (temp.getId().equals(id)) {
                ms = temp.getTentl();
            }
        }

        return ms;
    }

    @Override
    public String getTT(int tt) {
        String trangThai = "";
        if (tt == 1) {
            trangThai = "Hết hàng";
        } else {
            trangThai = "Còn Hàng";
        }
        return trangThai;
    }

}
