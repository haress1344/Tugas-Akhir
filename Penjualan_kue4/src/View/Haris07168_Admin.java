package View;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import Controller.Haris07168_MemberController;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Haris07168_Admin {

    private static Haris07168_MemberController member = new Haris07168_MemberController();
    JFrame TampilanAdmin = new JFrame();
    JTable tabelmember = new JTable();
    JScrollPane scrolladmin = new JScrollPane(tabelmember);
    JButton back;
    JLabel ListMember;

    public Haris07168_Admin() {
        TampilanAdmin.setSize(650, 500);
        TampilanAdmin.setLayout(null);
        TampilanAdmin.getContentPane().setBackground(Color.ORANGE);

        ListMember = new JLabel("List Member");
        ListMember.setBounds(200, 30, 400, 30);
        ListMember.setFont(new Font("Timer New Roman", Font.BOLD, 40));
        TampilanAdmin.add(ListMember);

        scrolladmin.setBounds(30, 100, 570, 200);
        tabelmember.setModel(member.listmember());
        TampilanAdmin.add(scrolladmin);

        back = new JButton("back");
        back.setBounds(50, 400, 100, 30);
        back.setBackground(Color.red);
        TampilanAdmin.add(back);

        TampilanAdmin.setLocationRelativeTo(null);
        TampilanAdmin.setVisible(true);
        TampilanAdmin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                TampilanAdmin.dispose();
                Haris07168_GUI gui = new Haris07168_GUI();
            }
        });
    }
}
