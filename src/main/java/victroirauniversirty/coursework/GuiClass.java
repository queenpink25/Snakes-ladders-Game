/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package victroirauniversirty.coursework;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import victroirauniversirty.coursework.supportAccess.MyNode;

/**
 *
 * @author DROID
 */
public class GuiClass {
    private final BusinessLogic Logicdefault = new BusinessLogic();
    private int CurrentPosition;
    public GuiClass(){
        this.CurrentPosition = 0;
   
    MainFrame();
}
    private JPanel  MainPanel(){
   
     JPanel pane = new JPanel();
   
     pane.setPreferredSize(new Dimension(600,500));
     pane.setLayout(null);
     JPanel BgPAne = new JPanel();
     BgPAne.setSize(450,500);
     BgPAne.setLayout(null);
     BgPAne.setBackground(Color.BLACK);
     pane.add(BgPAne);
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
                  GameStarter.setText("Stop Dice");
                  Constructors(BgPAne);
                  Logicdefault.boxpopulator();
                 // GameStarter.setBackground(Color.red);
             }
             else{
                   DiceRoller.setEnabled(false);
                    GameStarter.setText("Play Game");
             }
         
     });
      DiceRoller.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            int roler = Logicdefault.DiceRoller();  // roll the dice
            text.setText(String.valueOf(roler));     // show dice value
            // here i have to moe the deivce
            var res = Logicdefault.MoveDice(CurrentPosition, roler);
// i move the diece
    

            MoveDiceOnBoard(res, BgPAne);
           
         }
     });
     //pane.setBackground(Color.red);
     return pane;
    }
     /*private JPanel GameBg(){
      var Jp = new JPanel();
      Jp
      return Jp;
     } */
    private void MainFrame(){
     JFrame mainframe = new JFrame("Course Work");
     mainframe.pack();
     var Cpm = MainPanel();
     mainframe.add(Cpm);
     mainframe.setLocationRelativeTo(null);
     mainframe.setVisible(true);
     mainframe.setSize(800,500+ mainframe.getInsets().top);
     mainframe.setResizable(false);
     
    }
    private void Constructors(JPanel pane){
        pane.setLayout(new GridLayout(10, 10,2,2));
        var height = pane.getSize().height;//columns
          var Wodth = pane.getSize().width;//rows
          for(int i=0; i<10;i++){
              
              //for rows
              for(int b=0;b<10;b++){
                  JButton btn = new JButton(i+""+b);
                  
                  btn.setSize(Wodth/10, height/10);
                  btn.setLayout(null);
                  btn.setMargin(new Insets(0,0,0,0));
                  
                  btn.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 16));
                  //btn.setText(String.valueOf(i)+String.valueOf(b));
                  
                  btn.addActionListener(e -> {
                System.out.println("Button " + btn.getText() + " clicked");
                btn.setBackground(Color.MAGENTA);
                        });

                  btn.setForeground(Color.white);
                  btn.setBackground(Color.LIGHT_GRAY);
                  if(i==0 && b==0){
                  btn.setText("Start");
                  btn.setBackground(Color.GREEN);
                  }
                  if(i==9 && b==9){
                  btn.setText("End");
                  btn.setBackground(Color.red);
                  }
                  pane.add(btn);
              }
              
          }
      System.out.println(pane.getSize());
    }
    private void MoveDiceOnBoard(MyNode res,JPanel pane){
        var btnslists = pane.getComponents();
        if(res.isSnake){
            //this.CurrentPosition-=res.PostionShiftGetter();
            System.out.println("Demotion");
        }
        else if(res.isLadder){
            System.out.println("Promotion");
            //this.CurrentPosition+=res.PostionShiftGetter();
            
        }
        for(Component comp : btnslists){
            comp.setBackground(Color.lightGray);
            if(comp instanceof JButton btn){ 
                
                var btntext = btn.getText();
                if("Start".equals(btntext)){
                    System.out.println("started");
                    continue;
                }
                if("End".equals(btntext)){
                    System.out.println("Ended");
                    continue;
                }
                
                int post = Integer.parseInt(btntext);
                if(  this.CurrentPosition<=0){
                    continue;
                }
                if(  this.CurrentPosition==post){
                    
                    btn.setBackground(Color.cyan);
                    System.out.println(  this.CurrentPosition);
                }
            }
        }
        System.out.println(  this.CurrentPosition);
    }
}

