/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    JButton logout, masukkan;
    JTextArea output = new JTextArea();
    JTextField inputJumKue;
    JLabel IsiKeranjang, layanan, jumkue;
    JComboBox pilkue = new JComboBox(Haris07168_KueEntity.namakue);

    public Haris07168_Member() {
        TampilanMember.setSize(720, 600);
        TampilanMember.setLayout(null);
        TampilanMember.getContentPane().setBackground(Color.ORANGE);
        IsiKeranjang = new JLabel("Isi Keranjang");
        IsiKeranjang.setFont(new Font("Timer New Roman", Font.BOLD, 30));
        IsiKeranjang.setBounds(90, 30, 200, 40);
        TampilanMember.add(IsiKeranjang);

        layanan = new JLabel("Layanan");
        layanan.setBounds(450, 30, 250, 30);
        layanan.setFont(new Font("Times New Roman", Font.BOLD, 30));
        TampilanMember.add(layanan);

        output.setBounds(30, 90, 300, 300);
        TampilanMember.add(output);

        pilkue.setBounds(450, 90, 230, 30);
        TampilanMember.add(pilkue);

        jumkue = new JLabel("Jumlah Kue");
        jumkue.setBounds(450, 120, 200, 30);
        TampilanMember.add(jumkue);
        inputJumKue = new JTextField();
        inputJumKue.setBounds(450, 150, 200, 30);
        TampilanMember.add(inputJumKue);

        masukkan = new JButton("Masukkan");
        masukkan.setBounds(500, 200, 100, 30);
        masukkan.setBackground(Color.GREEN);
        TampilanMember.add(masukkan);

        TampilanMember.setVisible(true);
        TampilanMember.setLocationRelativeTo(null);
        TampilanMember.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        masukkan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int indexmenu = pilkue.getSelectedIndex() + 1;
                int jum = Integer.parseInt(inputJumKue.getText());
                Haris07168_ObjectModel.keranjang.insertKeranjang(indexmenu, jum);
                output.setText(datakeranjang());
            }
        });

    }

    String datakeranjang() {
        String Text = null;
        for (int i = 0; i < Haris07168_ObjectModel.keranjang.cekArrayListKeranjang().size(); i++) {
            System.out.print(Haris07168_ObjectModel.keranjang.cekArrayListKeranjang().size());
            Text+= "Nama Kue = " + Haris07168_ObjectModel.keranjang.cekArrayListKeranjang().get(i).getKue() + "\nJumlah Kue = "
                    + Haris07168_ObjectModel.keranjang.cekArrayListKeranjang().get(i).getJum() + "\nHarga Satuan = "
                    + Haris07168_ObjectModel.keranjang.cekArrayListKeranjang().get(i).getHarga() + "\nTotal Harga = "
                    + Haris07168_ObjectModel.keranjang.cekArrayListKeranjang().get(i).getTotal();
        }
        return Text;
    }

}