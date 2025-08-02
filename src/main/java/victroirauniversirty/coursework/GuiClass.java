/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package victroirauniversirty.coursework;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author DROID
 */
public class GuiClass {
    private final BusinessLogic Logicdefault = new BusinessLogic();
    public GuiClass(){
     
    MainFrame();
}
    private JPanel  MainPanel(){
   
     JPanel pane = new JPanel();
   
     pane.setSize(600,600);
     pane.setLayout(null);
     // button shuffler
     JButton GameStarter = new JButton();
     GameStarter.setBounds(450, 10,100 ,30 );
     GameStarter.setText("Start Game");
     JButton DiceRoller = new JButton();
     DiceRoller.setEnabled(false);
     DiceRoller.setBounds(450, 50,100 ,30 );
     DiceRoller.setText("Role Dice");
     pane.add(DiceRoller);
     pane.add(GameStarter);
     // results number
     JTextField text = new JTextField();
     text.setBackground(Color.MAGENTA);
     //text.setFont(Font.ROMAN_BASELINE);
     text.setBounds(450,250,100,100);
     
     text.setEditable(false);
     pane.add(text);
       GameStarter.addActionListener(e -> {
             if(!DiceRoller.isEnabled()){
                 DiceRoller.setEnabled(true);
                  GameStarter.setText("Role Dice");
             }
             else{
                   DiceRoller.setEnabled(false);
                    GameStarter.setText("Play Game");
             }
         
     });
      DiceRoller.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
             int roler = Logicdefault.DiceRoller();
             text.setText(String.valueOf(roler));
             //System.out.println(Logicdefault.NodeLists.length);
         }
     });
     //pane.setBackground(Color.red);
     return pane;
    }
    private void MainFrame(){
     JFrame mainframe = new JFrame("Course Work");
     mainframe.pack();
     var Cpm = MainPanel();
     mainframe.add(Cpm);
     mainframe.setVisible(true);
     mainframe.setSize(800,600);
     mainframe.setResizable(false);
     
    }
}

