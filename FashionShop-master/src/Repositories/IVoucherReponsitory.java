/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repositories;

import DomainModel.Voucher;
import java.util.List;

/**
 *
 * @author Duc
 */
public interface IVoucherReponsitory {
     Integer insert(Voucher vc);

    Integer update(String ma, Voucher vc);

    Integer delete(String ma);

    String checkMa(String ma);
    
    Voucher getOne(String id);
    
    List<Voucher> getList();
    
}
