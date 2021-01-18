package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.*;

public class Haris07168_GUI {

    JFrame TampilanAwal = new JFrame();
    JLabel login, daftar, top, labelUsernameLog, labelPasswordLog, labelPasswordReg, labelUsernameReg, labelNamaReg;
    JRadioButton radioAdmin, radioMember;
    JTextField textUsernameLog, textUsernameReg, textNamaReg;
    JPasswordField loginpass, daftarpass;
    JButton Logbut, Regbut;
    private boolean ceklogin = false;

    public Haris07168_GUI() {
        TampilanAwal.setSize(700, 630);
        TampilanAwal.setLayout(null);
        TampilanAwal.getContentPane().setBackground(Color.ORANGE);

        top = new JLabel("Cookie Store Here !");
        top.setBounds(170, 10, 600, 50);
        top.setFont(new Font("Times New Roman", Font.BOLD, 40));
        TampilanAwal.add(top);

        login = new JLabel("Login");
        login.setBounds(100, 50, 100, 100);
        login.setFont(new Font("Times New Roman", Font.BOLD, 30));
        TampilanAwal.add(login);

        radioAdmin = new JRadioButton("Admin");
        radioAdmin.setBounds(30, 150, 100, 30);
        radioAdmin.setBackground(Color.GREEN);
        TampilanAwal.add(radioAdmin);

        radioMember = new JRadioButton("Member");
        radioMember.setBounds(140, 150, 100, 30);
        radioMember.setBackground(Color.GREEN);
        TampilanAwal.add(radioMember);

        labelUsernameLog = new JLabel("Username");
        labelUsernameLog.setBounds(30, 180, 200, 30);
        TampilanAwal.add(labelUsernameLog);
        textUsernameLog = new JTextField();
        textUsernameLog.setBounds(30, 210, 200, 30);
        TampilanAwal.add(textUsernameLog);

        labelPasswordLog = new JLabel("Password");
        labelPasswordLog.setBounds(30, 240, 100, 30);
        TampilanAwal.add(labelPasswordLog);
        loginpass = new JPasswordField();
        loginpass.setBounds(30, 270, 200, 30);
        TampilanAwal.add(loginpass);

        Logbut = new JButton("Login");
        Logbut.setBounds(90, 320, 100, 40);
        Logbut.setBackground(Color.GREEN);
        TampilanAwal.add(Logbut);

        daftar = new JLabel("Daftar Member");
        daftar.setFont(new Font("Times New Roman", Font.BOLD, 30));
        daftar.setBounds(400, 50, 200, 100);
        TampilanAwal.add(daftar);

        labelNamaReg = new JLabel("Nama");
        labelNamaReg.setBounds(400, 150, 200, 30);
        TampilanAwal.add(labelNamaReg);
        textNamaReg = new JTextField();
        textNamaReg.setBounds(400, 180, 200, 30);
        TampilanAwal.add(textNamaReg);

        labelUsernameReg = new JLabel("Username Baru");
        labelUsernameReg.setBounds(400, 210, 100, 30);
        TampilanAwal.add(labelUsernameReg);
        textUsernameReg = new JTextField();
        textUsernameReg.setBounds(400, 240, 200, 30);
        TampilanAwal.add(textUsernameReg);

        labelPasswordReg = new JLabel("Password Baru");
        labelPasswordReg.setBounds(400, 270, 100, 30);
        TampilanAwal.add(labelPasswordReg);
        daftarpass = new JPasswordField();
        daftarpass.setBounds(400, 300, 200, 30);
        TampilanAwal.add(daftarpass);

        Regbut = new JButton("Daftar");
        Regbut.setBounds(450, 360, 100, 40);
        Regbut.setBackground(Color.GREEN);
        TampilanAwal.add(Regbut);

        TampilanAwal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        TampilanAwal.setVisible(true);
        TampilanAwal.setLocationRelativeTo(null);

        radioAdmin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (radioAdmin.isSelected()) {
                    radioMember.setSelected(false);
                    ceklogin = true;
                }
            }
        });

        radioMember.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (radioMember.isSelected()) {
                    radioAdmin.setSelected(false);
                    ceklogin = false;
                }
            }
        });

        Logbut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (ceklogin == true) {
                    try {
                        Haris07168_ObjectController.admin.dataAdmin();
                        Haris07168_ObjectController.admin.login(textUsernameLog.getText(), loginpass.getText());
                        String nama = Haris07168_ObjectController.admin.adminEntity().getNama();
                        JOptionPane.showMessageDialog(null, "Selamat datang Admin " + nama, "information", JOptionPane.INFORMATION_MESSAGE);
                        Haris07168_Admin AdminGui = new Haris07168_Admin();
                        TampilanAwal.dispose();
                    } catch (Exception exception) {
                        JOptionPane.showMessageDialog(null, "Username atau Password salah", "information", JOptionPane.INFORMATION_MESSAGE);
                    }
                    kosong();
                } else {
                    try {
                        Haris07168_ObjectController.member.login(textUsernameLog.getText(), loginpass.getText());
                        String nama = Haris07168_ObjectController.member.memberEntity().getNama();
                        JOptionPane.showMessageDialog(null, "Selamat datang Di Cookie Store, " + nama, "information", JOptionPane.INFORMATION_MESSAGE);
                        Haris07168_Member MemberGui = new Haris07168_Member();
                        TampilanAwal.dispose();
                    } catch (Exception eception) {
                        JOptionPane.showMessageDialog(null, "Username atau Password salah", "information", JOptionPane.INFORMATION_MESSAGE);
                        kosong();
                    }
                }
            }
        });
        
        Regbut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    String nama = textNamaReg.getText();
                    String username = textUsernameReg.getText();
                    String pass = daftarpass.getText();
                    Haris07168_ObjectController.member.insertMember(nama, username, pass);
                    JOptionPane.showMessageDialog(null, "Registrasi sukses", "information", JOptionPane.INFORMATION_MESSAGE);
                    kosong();
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(null, "Format Penulisan Salah", "Registrasi Gagal", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
    }
    
    void kosong() {
        textUsernameReg.setText(null);
        daftarpass.setText(null);
        textNamaReg.setText(null);
        textUsernameLog.setText(null);
        loginpass.setText(null);
    }
}
