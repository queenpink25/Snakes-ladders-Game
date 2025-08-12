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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
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
     
     
     
     GameBoardPanel BgPAne = new GameBoardPanel();
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
     JTextField text2 = new JTextField();
      JTextArea  text3 = new JTextArea ();
      text3.setText("Rules of the game \n Press start \n role dice \nif you land on snake \nyou will be pushed back \nif you land on ladder\nyou wil be elevated \notherwise will move steps\n based on the dice value");
     text.setBackground(Color.MAGENTA);
      text3.setBounds(550, 150, 200, 400);
     //text.setFont(Font.ROMAN_BASELINE);
     text.setBounds(450,250,100,100);
     text2.setBackground(Color.lightGray);
     text2.setBounds(450, 150, 100, 100);
     text.setEditable(false);
     pane.add(text2);
     pane.add(text);
     pane.add(text3);
     
       GameStarter.addActionListener(e -> {
             if(!DiceRoller.isEnabled()){
                 DiceRoller.setEnabled(true);
                  GameStarter.setText("Stop Dice");
                  Constructors(BgPAne);
                  
                  var SpecialBtns =  Logicdefault.boxpopulator(BgPAne);
                 
                  
                  pane.add(SpecialBtns);
                    BgPAne.repaint();
                 // GameStarter.setBackground(Color.red);
             }
             else{
                   DiceRoller.setEnabled(false);
                    GameStarter.setText("Play Game");
             }
         
     });
      DiceRoller.addActionListener((ActionEvent e) -> {
          int roler = Logicdefault.DiceRoller();  // roll the dice
          text.setText(String.valueOf(roler));     // show dice value
          // here i have to moe the deivce
          var res = Logicdefault.MoveDice(CurrentPosition, roler);
          // i move the diece
          var value =  MoveDiceOnBoard(res, BgPAne);
          if(value!=null){
              text2.setText(value);
          }
          else{
              text2.setText("Game Over finsihed");
              text2.setBackground(Color.green);
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
    private void Constructors(GameBoardPanel pane){
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
                  
                 
                  //btn.setOpaque(false);
                  //btn.setContentAreaFilled(false);
                 //btn.setBorderPainted(false);
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
          //pane.setOpaque(false);
      //System.out.println(pane.getSize());
    }
    //// movin here does 3 times traversing 
     String MoveDiceOnBoard(MyNode res,JPanel pane){
        var btnslists = pane.getComponents();
        // set the new node position'
        ////this.CurrentPosition+=res.value;
        //System.out.println(res.value);
        //
      
        try {
            //Thread.sleep(300);
             if(res.isSnake){
            this.CurrentPosition-=res.PostionShiftGetter();
             shuffle(btnslists);
            return ("Snkd by \n"+String.valueOf(res.PostionShiftGetter()+ " upto"+CurrentPosition));
            }
            if(res.isLadder){
            
                this.CurrentPosition+=res.PostionShiftGetter();
                shuffle(btnslists);
                return("Ldr by \n"+String.valueOf(res.PostionShiftGetter()+ " upto"+CurrentPosition));

            }
            else{
                  //used postfix
             CurrentPosition=res.value;
             shuffle(btnslists);
             return("Normal by "+res.value);
             
            }
       
        } catch (Exception ex) {
             JOptionPane.showMessageDialog(
        null,
        "OverFlow NextNode is null! Challenge accepted game won",
        "Game Notice",
        JOptionPane.ERROR_MESSAGE
    );
    System.out.println("Over FLowe Challenge triggered");
 
  
            System.out.println("Over FLow detected");
             return("Game Over you finished");
        }

    }
    private void shuffle(Component[] btnslists){
        //System.out.println("CurrentPosition"+CurrentPosition);
        for(Component comp : btnslists){
                comp.setBackground(Color.lightGray);
                if(comp instanceof JButton btn){ 
                    
                    var btntext = btn.getText();
                    if("Start".equals(btntext)){
                       // System.out.println("started");
                        continue;
                    }
                    if("End".equals(btntext)){
                        //System.out.println("Ended");
                        continue;
                    }
                    
                    int post = Integer.parseInt(btntext);
                    if(CurrentPosition<=0){
                        //CurrentPosition = Math.abs(CurrentPosition);
                        JOptionPane.showMessageDialog(
                                null,
                                "Underflow! Challenge got turned back to start",
                                "Game Notice",
                                JOptionPane.ERROR_MESSAGE
                            );
                            System.out.println("UnderFlow Challenge triggered");
                            CurrentPosition = 0;
                            continue;
                    }
                    if(CurrentPosition==post){
                        
                        btn.setBackground(Color.cyan);
                      //  System.out.println("the position is "+CurrentPosition);
                    }
                }
            }
    }
    
}

