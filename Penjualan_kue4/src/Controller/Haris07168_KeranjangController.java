package Controller;

import java.util.ArrayList;
import Entity.Haris07168_KeranjangEntity;

public class Haris07168_KeranjangController {

    public void insertKeranjang(int indexmenu, int jum) {
        String Haris07168_namakue;
        float Haris07168_harga;
        int Haris07168_jum;
        switch (indexmenu) {
            case 1:
                Haris07168_namakue = "Tahu Kornet";
                Haris07168_harga = 2500;
                System.out.print("Jumlah Tahu Kornet = ");
                Haris07168_jum = jum;
                Haris07168_ObjectModelController.keranjang.insertData(new Haris07168_KeranjangEntity(Haris07168_namakue, jum, Haris07168_harga));
                break;
            case 2:
                Haris07168_namakue = "Bitterbalen";
                Haris07168_harga = 3000;
                System.out.print("Jumlah Bitterbalen = ");
                Haris07168_jum = jum;
                Haris07168_ObjectModelController.keranjang.insertData(new Haris07168_KeranjangEntity(Haris07168_namakue, jum, Haris07168_harga));
                break;
            case 3:
                Haris07168_namakue = "Bolu";
                Haris07168_harga = 2000;
                System.out.print("Jumlah Bolu = ");
                Haris07168_jum = jum;
                Haris07168_ObjectModelController.keranjang.insertData(new Haris07168_KeranjangEntity(Haris07168_namakue, jum, Haris07168_harga));
                break;
            case 4:
                Haris07168_namakue = "Cookie";
                Haris07168_harga = 4000;
                System.out.print("Jumlah Cookie = ");
                Haris07168_jum = jum;
                Haris07168_ObjectModelController.keranjang.insertData(new Haris07168_KeranjangEntity(Haris07168_namakue, jum, Haris07168_harga));
                break;
        }
    }

    public void UpdateKeranjang(int indexmenu, int jum, int indexurut) {
        String Haris07168_namakue;
        float Haris07168_harga;
        int Haris07168_jum;
        switch (indexmenu) {
            case 1:
                Haris07168_namakue = "Tahu Kornet";
                Haris07168_harga = 2500;
                System.out.print("Jumlah Tahu Kornet = ");
                Haris07168_jum = jum;
                Haris07168_ObjectModelController.keranjang.updateisi(indexurut, Haris07168_namakue, jum, Haris07168_harga);
                break;
            case 2:
                Haris07168_namakue = "Bitterbalen";
                Haris07168_harga = 3000;
                System.out.print("Jumlah Bitterbalen = ");
                Haris07168_jum = jum;
                Haris07168_ObjectModelController.keranjang.updateisi(indexurut, Haris07168_namakue, jum, Haris07168_harga);
                break;
            case 3:
                Haris07168_namakue = "Bolu";
                Haris07168_harga = 2000;
                System.out.print("Jumlah Bolu = ");
                Haris07168_jum = jum;
                Haris07168_ObjectModelController.keranjang.updateisi(indexurut, Haris07168_namakue, jum, Haris07168_harga);
                break;
            case 4:
                Haris07168_namakue = "Cookie";
                Haris07168_harga = 4000;
                System.out.print("Jumlah Cookie = ");
                Haris07168_jum = jum;
                Haris07168_ObjectModelController.keranjang.updateisi(indexurut, Haris07168_namakue, jum, Haris07168_harga);
                break;
        }
    }

    public void HapusIsiKeranjang(int indexurut) {
        Haris07168_ObjectModelController.keranjang.hapusisi(indexurut);
    }

    public void ResetKeranjang() {
        Haris07168_ObjectModelController.keranjang.reset();
    }

    public ArrayList<Haris07168_KeranjangEntity> cekArrayListKeranjang() {
        return Haris07168_ObjectModelController.keranjang.getArrayListKeranjang();
    }
}
