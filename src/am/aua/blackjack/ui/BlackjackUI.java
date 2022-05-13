package am.aua.blackjack.ui;

import am.aua.blackjack.core.*;
import am.aua.blackjack.core.Blackjack;
import javax.swing.*;
import javax.swing.text.StyledEditorKit;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BlackjackUI extends JFrame {
    private Blackjack game;
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;
    private static final Color background = new Color( 67, 133, 22 );
    JButton start;
    JButton exit;
    JButton enter1;
    JTextField text1;
    JTextField text2;
    String name, betMoney;

    public BlackjackUI(){
        super("BLACKJACK");
        setSize(WIDTH, HEIGHT);
        setLayout( new GridBagLayout());
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        JLabel aLabel = new JLabel("Hello! ^_^ Welcome to your game of BlackJack!! \n If you want to start, press START, otherwise press EXIT.");
        add(aLabel);
        start = new JButton("START");
        start.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                JLabel nameEntry = new JLabel("Please enter your name.");
                add(nameEntry);
                JTextField text = new JTextField(10);
                add(text);
                enter1 = new JButton("ENTER");
                add(enter1);
                enter1.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Blackjack game =new Blackjack(1, text.getText());
                        JLabel betMoney = new JLabel("You have $1000. How much money do you bet?" );
                        JTextField bet = new JTextField(10);
                        add(betMoney);
                        add(bet);
                        JButton enter2 = new JButton("START GAME");
                        add(enter2);
                        enter1.setVisible(false);
                        text.setVisible(false);
                        nameEntry.setVisible(false);
                        enter2.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {

                            }
                        });
                    }
                });
                aLabel.setVisible(false);
                start.setVisible(false);
                exit.setVisible(false);
            }
        });

        exit = new JButton("EXIT");
        exit.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        text1 = new JTextField(50);
        text2 = new JTextField(50);


        add(start);
        add(exit);

        getContentPane().setBackground( background );



    }

    public static void main (String[] args){//Not in main because UI incomplete
        BlackjackUI blackjackUI = new BlackjackUI();
        blackjackUI.setVisible( true );
    }


}
