/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package victroirauniversirty.coursework;

import java.awt.Color;
import java.awt.Component;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import victroirauniversirty.coursework.supportAccess.DoublyList;
import victroirauniversirty.coursework.supportAccess.MyNode;
/**
 *
 * @author DROID
 */
public class BusinessLogic {
    //nodelists is the number of boxes we have we implementeed the doubly linked list we ahll be able to sort it ad adn remove based on the previous na dnext ndoes
    
    public MyNode[] NodeLists ;
    public DoublyList MynodesFunc = null;
    public BusinessLogic(){
        /*here we are constructint he array to be exactly 99 from 0-99 so it holds 100 nubers*/
        this.NodeLists = new MyNode[100];
     //this.MynodesFunc = new DoublyList(i);
     for(int i=0;i<NodeLists.length;i++){
         MynodesFunc = new DoublyList(i);
         if(i==0){
           MynodesFunc.AddAtFirst(this.MynodesFunc.Ogutwe);
            }
        if(i==99){
            MynodesFunc.AddAtLast(this.MynodesFunc.Ogutwe);
         }
        else{
        NodeLists[i]= MynodesFunc.AddAtpositionx(i--, i++);
         }
     }
     
     //this.LadersDecider();
     //this.snakesDecider();
     }
     public MyNode MoveDice(int CurrentPosition,int DiceNumber){
         try{
         var res = CurrentPosition+DiceNumber;
         var ser =  NodeLists[res];
         return NodeLists[res];
    }
         catch(java.lang.ArrayIndexOutOfBoundsException ex){
                 return null;
         }
     }
         
    
    public int DiceRoller(){
        return new Random().nextInt(6) + 1;
    }
     public JComponent boxpopulator(JPanel pane){ 
        //MyNode[] nodeList = new MyNode[];
        //nodeList
        List<MyNode> specialKeysList = new LinkedList<>();
        JScrollPane Spane = new JScrollPane();
         Spane.setBounds(550, 0, 200, 100);
       var Laders = this.LadersDecider();
       var Snakes = this.snakesDecider();
          specialKeysList.addAll(Laders);
          specialKeysList.addAll(Snakes);
          //need to draw 2d graphics only for the linked lists nodes
        Component[] comps  = pane.getComponents();
        
         JPanel labelPanel = new JPanel();
        labelPanel.setLayout(new BoxLayout(labelPanel, BoxLayout.Y_AXIS)); 
        for(int i =0; i<specialKeysList.size();i++){
            var Mnode = specialKeysList.get(i);
            DrawGraphics(Mnode,comps, (GameBoardPanel) pane);
            JLabel lbl = new JLabel();
            if(Mnode.isLadder){
            lbl.setBackground(Color.blue);
            lbl.setText("Btn "+Mnode.PostionShiftGetter()+" Laddr Upby "+Mnode.value);
             lbl.setOpaque(true);
              lbl.setForeground(Color.white);
             //Spane.add(lbl);
            }
             if(Mnode.isSnake){
            lbl.setBackground(Color.red);
             lbl.setText("Btn "+Mnode.PostionShiftGetter()+" Snake Downby "+Mnode.value);
              lbl.setOpaque(true);
              lbl.setForeground(Color.white);
              //Spane.add(lbl);
            }
            labelPanel.add(lbl);
            /*System.out.println("is lader"+Mnode.isLadder);
            System.out.println("is snakke"+Mnode.isSnake);
            System.out.println(Mnode.PostionShiftGetter());
            System.out.println(Mnode.value);
        */}
       Spane.setViewportView(labelPanel);
    Spane.setBackground(Color.white);
       return Spane;
     }
     public int MoveAction(int dicechance,MyNode currentnode){
        return 0;


     }
    private List<MyNode> snakesDecider(){
       var SnakeNodes = DiceRoller();
          List<MyNode> snakesList = new ArrayList<>();
        for(int i=0;i<SnakeNodes;i++){
            MynodesFunc = new DoublyList(i);
            MyNode res =MynodesFunc.GenerateSnake();
            res.positionShiftSetter(PositionToFrom(res.PostionShiftGetter(),res));
            
            this.NodeLists[res.PostionShiftGetter()]=res;
            res.isSnake = true;
            snakesList.add(res);
        // this.MynodesFunc./ search the node and replace it 
        }
       return snakesList;
       
        //define the boxes ro be called snaekes so that you define there to and from demotion
//        NodeLists[0];
  //      int [] listOfSnakesboxes = new [3];
        //listofSnakesBoxes.
    }
    private List<MyNode> LadersDecider(){
        var LaderNodes = DiceRoller();
         List<MyNode> LadersList = new ArrayList<>();
        for(int i=0;i<LaderNodes;i++){
        MynodesFunc = new DoublyList(i);
         MyNode res = this.MynodesFunc.GenerateLAdder();
         res.positionShiftSetter(PositionToFrom(res.PostionShiftGetter(),res));
         this.NodeLists[res.PostionShiftGetter()]=res;
         res.isLadder = true;
         LadersList.add(res);
        // this.MynodesFunc./ search the node and replace it 
        }
 //define the boxes ro be called snaekes so that you define there to and from promotion
       System.out.println(LaderNodes);
       return LadersList;
    }   
    private static int PositionToFrom(int currentPosition, MyNode node) {
    if (node.isSnake) {
        // Move down, but not below 0
        int minshift = 10+currentPosition;
        int shift = new Random().nextInt(minshift); // 0 to currentPosition-1
        return Math.abs(currentPosition - shift);
    } else if (node.isLadder) {
        // Move up, but not above 99
        int maxShift = 99 - currentPosition;
        int shift = maxShift > 0 ? new Random().nextInt(maxShift) : 0;
        return currentPosition + shift;
    }
    return currentPosition;
}
    void DrawGraphics(MyNode Node,Component[] ListOfComponents,GameBoardPanel pane){
       
       for(Component comp:ListOfComponents){
           if(comp instanceof JButton btn){
                String text = btn.getText();
                
                if (text != null && !text.equals("Start") && !text.equals("End")) {
                     var targetBounds = ListOfComponents[Node.PostionShiftGetter()].getBounds();
                   int tesxt;
                   tesxt = Integer.parseInt(text);
                   int x1 = btn.getX() + btn.getWidth() / 2;
                   int y1 = btn.getY() + btn.getHeight() / 2;
                   int x2 = targetBounds.x + targetBounds.width / 2;
                   int y2 = targetBounds.y + targetBounds.height / 2;
                   if(tesxt==Node.value){
                       if(Node.isLadder){
                            pane.addLine(Color.GREEN, x1, y1, x2, y2);
                            btn.setToolTipText("iam a Ladder");
                            btn.setBackground(Color.blue);
                           /*  JComponent cmp = new JComponent(){
                           @Override
                           protected void paintComponent(Graphics g) {
                                        super.paintComponent(g);
                                       g.setColor(Color.green);
                                        

                                        g.drawLine(x1, y1, x2, y2);
                                       // g.drawLine(btn.getBounds().x+=2, btn.getBounds().y+=2, btnto.getBounds().x+=2, btnto.getBounds().y+=2); // Draw a line from point A to B
                                    }
                           };
                           //cmp.setLayout(null);
                             cmp.setBounds(0, 0, pane.getWidth(), pane.getHeight());
                                cmp.setOpaque(false); // transparent background

                                
                                pane.add(cmp);
                                pane.setComponentZOrder(cmp, 0);
                               // pane.repaint();
                         
                         Graphics2D grd = new Graphics2D();
                           grd
                           System.out.println(newNode);
                           */
                       }
                       if(Node.isSnake){
                             pane.addLine(Color.red, x1, y1, x2, y2);
                             btn.setToolTipText("iam a Snake");
                               btn.setBackground(Color.red);
                           /*    JComponent Sncmp = new JComponent(){
                           @Override
                           protected void paintComponent(Graphics g) {
                                        super.paintComponent(g);
                                        g.setColor(Color.red);
                                        int x1 = btn.getX() + btn.getWidth() / 2;
                                        int y1 = btn.getY() + btn.getHeight() / 2;
                                        int x2 = targetBounds.x + targetBounds.width / 2;
                                        int y2 = targetBounds.y + targetBounds.height / 2;

                                        g.drawLine(x1, y1, x2, y2);
                                        //g.drawLine(btn.getBounds().x+=2, btn.getBounds().y+=2, btnto.getBounds().x+=2, btnto.getBounds().y+=2); // Draw a line from point A to B  
                                    }
                           };
                          // Sncmp.setLayout(null);
                                Sncmp.setBounds(0, 0, pane.getWidth(), pane.getHeight());
                                Sncmp.setOpaque(false); // transparent background

                                
                                pane.add(Sncmp);
                                pane.setComponentZOrder(Sncmp, 0);
                                //pane.repaint();
                           */
                           }
                          
                       }
                   }  
           } 
       }
       }
       
         
    }
    

