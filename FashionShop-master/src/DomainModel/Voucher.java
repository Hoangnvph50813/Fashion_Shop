/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModel;

/**
 *
 * @author Duc
 */
public class Voucher {

    private String id;
    private String ma;
    private String ten;
    private int theLoai;
    private String idUser;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(int theLoai) {
        this.theLoai = theLoai;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public Voucher(String id, String ma, String ten, int theLoai, String idUser) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.theLoai = theLoai;
        this.idUser = idUser;
    }

    public Voucher() {
    }
}
