/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import DomainModel.Voucher;
import java.util.ArrayList;

/**
 *
 * @author Duc
 */
public interface IVoucherService {
        ArrayList<Voucher> getlist();

    Integer them(Voucher vc);

    Integer xoa(String id);

    Integer sua(String id, Voucher vc);
     String checkMa(String ma);
     Integer getLoai (String loai);
     String getNguoiTaoById(String id);
}
