package Controller;

import java.util.ArrayList;
import Entity.Haris07168_MemberEntity;
import javax.swing.table.DefaultTableModel;

public class Haris07168_MemberController implements Haris07168_ControllerInterface {

    private static int indeks = 0;

    public void insertMember(String nama, String username, String password) {
        Haris07168_ObjectModelController.member.insertData(new Haris07168_MemberEntity(nama, username, password));
    }

    public void login(String Username, String Password) {
        indeks = Haris07168_ObjectModelController.member.cekData(Username, Password);
    }

    public Haris07168_MemberEntity memberEntity() {
        return Haris07168_ObjectModelController.member.showDataMember(indeks);
    }

    public DefaultTableModel listmember() {
        DefaultTableModel TabelMember = new DefaultTableModel();
        Object[] kolom = {"Nama", "Username", "Password"};
        TabelMember.setColumnIdentifiers(kolom);
        int size = Haris07168_ObjectModelController.member.getArrayListMember().size();
        for (int i = 0; i < size; i++) {
            Object[] data = new Object[8];
            data[0] = Haris07168_ObjectModelController.member.getArrayListMember().get(i).getNama();
            data[1] = Haris07168_ObjectModelController.member.getArrayListMember().get(i).getUser();
            data[2] = Haris07168_ObjectModelController.member.getArrayListMember().get(i).getPass();
            TabelMember.addRow(data);
        }
        return TabelMember;
    }

}
