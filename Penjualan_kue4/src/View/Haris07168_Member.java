
package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import javax.swing.*;
import Entity.Haris07168_KueEntity;

public class Haris07168_Member {

    JFrame TampilanMember = new JFrame();
    JButton logout, masukkan, ubah, hapus;
    JTextArea output = new JTextArea();
    JTextField inputJumKue1, inputJumKue2, inputJumKue3, inputUrut1, inputUrut2;
    JLabel IsiKeranjang, layanan, jumkue1, jumkue2, jumkue3, urutan1, urutan2, ganti;
    JComboBox pilkue1, pilkue2;

    public Haris07168_Member() {
        TampilanMember.setSize(720, 600);
        TampilanMember.setLayout(null);
        TampilanMember.getContentPane().setBackground(Color.ORANGE);
        IsiKeranjang = new JLabel("Isi Keranjang");
        IsiKeranjang.setFont(new Font("Times New Roman", Font.BOLD, 30));
        IsiKeranjang.setBounds(90, 30, 200, 40);
        TampilanMember.add(IsiKeranjang);

        layanan = new JLabel("Layanan");
        layanan.setBounds(450, 30, 250, 30);
        layanan.setFont(new Font("Times New Roman", Font.BOLD, 30));
        TampilanMember.add(layanan);

        output.setBounds(30, 90, 300, 300);
        TampilanMember.add(output);
        
        pilkue1 = new JComboBox(Haris07168_KueEntity.namakue);
        pilkue1.setBounds(450, 90, 200, 30);
        TampilanMember.add(pilkue1);

        jumkue1 = new JLabel("Jumlah Kue");
        jumkue1.setBounds(450, 120, 200, 30);
        TampilanMember.add(jumkue1);
        inputJumKue1 = new JTextField();
        inputJumKue1.setBounds(450, 150, 200, 30);
        TampilanMember.add(inputJumKue1);

        masukkan = new JButton("Masukkan");
        masukkan.setBounds(500, 200, 100, 30);
        masukkan.setBackground(Color.GREEN);
        TampilanMember.add(masukkan);

        urutan1 = new JLabel("Urutan Kue");
        urutan1.setBounds(450, 250, 200, 30);
        TampilanMember.add(urutan1);
        inputUrut1 = new JTextField();
        inputUrut1.setBounds(450, 280, 200, 30);
        TampilanMember.add(inputUrut1);

        ganti = new JLabel("Kue Pengganti");
        ganti.setBounds(450, 310, 200, 30);
        TampilanMember.add(ganti);
        pilkue2 = new JComboBox(Haris07168_KueEntity.namakue);
        pilkue2.setBounds(450, 340, 200, 30);
        TampilanMember.add(pilkue2);
        
        jumkue2 = new JLabel("Jumlah Kue");
        jumkue2.setBounds(450, 370, 200, 30);
        TampilanMember.add(jumkue2);
        inputJumKue2 = new JTextField();
        inputJumKue2.setBounds(450, 400, 200, 30);
        TampilanMember.add(inputJumKue2);
        
        ubah = new JButton("Ganti Kue");
        ubah.setBounds(500, 450, 100, 30);
        ubah.setBackground(Color.GREEN);
        TampilanMember.add(ubah);
        
        urutan2 = new JLabel("Hapus Urutan Kue");
        urutan2.setBounds(30, 400, 180, 30);
        TampilanMember.add(urutan2);
        inputUrut2 = new JTextField();
        inputUrut2.setBounds(30, 430, 180, 30);
        TampilanMember.add(inputUrut2);
        
        hapus = new JButton("Hapus");
        hapus.setBounds(230, 430, 100, 30);
        hapus.setBackground(Color.GRAY);
        TampilanMember.add(hapus);
        
        logout = new JButton("Logout");
        logout.setBounds(30, 480, 100, 30);
        logout.setBackground(Color.red);
        TampilanMember.add(logout);

        TampilanMember.setVisible(true);
        TampilanMember.setLocationRelativeTo(null);
        TampilanMember.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        masukkan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int indexmenu = pilkue1.getSelectedIndex() + 1;
                int jum = Integer.parseInt(inputJumKue1.getText());
                Haris07168_ObjectController.keranjang.insertKeranjang(indexmenu, jum);
                output.setText(datakeranjang());
            }
        });
        
        ubah.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                int indexurut = Integer.parseInt(inputUrut1.getText());
                int indexmenu = pilkue2.getSelectedIndex()+1;
                int jum = Integer.parseInt(inputJumKue2.getText());
                Haris07168_ObjectController.keranjang.UpdateKeranjang(indexmenu, jum, indexurut-1);
                output.setText(datakeranjang());
            }
        });
        
        hapus.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                int indexurut = Integer.parseInt(inputUrut2.getText());
                Haris07168_ObjectController.keranjang.HapusIsiKeranjang(indexurut-1);
                output.setText(datakeranjang());
            }
        });
        
        logout.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                Haris07168_ObjectController.keranjang.ResetKeranjang();
                TampilanMember.dispose();
                Haris07168_GUI gui = new Haris07168_GUI();
            }
        });

    }

    String datakeranjang() {
        String Text = "=================";
        for (int i = 0; i < Haris07168_ObjectController.keranjang.cekArrayListKeranjang().size(); i++) {

            Text += "\nNama Kue = " + Haris07168_ObjectController.keranjang.cekArrayListKeranjang().get(i).getKue() + "\nJumlah Kue = "
                    + Haris07168_ObjectController.keranjang.cekArrayListKeranjang().get(i).getJum() + "\nHarga Satuan = "
                    + Haris07168_ObjectController.keranjang.cekArrayListKeranjang().get(i).getHarga() + "\nTotal Harga = "
                    + Haris07168_ObjectController.keranjang.cekArrayListKeranjang().get(i).getTotal() + "\n=================";
        }
        return Text;
    }

}
