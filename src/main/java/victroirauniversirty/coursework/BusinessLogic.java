/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package victroirauniversirty.coursework;

import java.awt.Component;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import javax.swing.JPanel;
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
        NodeLists[i]= MynodesFunc.AddAtpositionx(i--, i++);
         }
     //this.LadersDecider();
     //this.snakesDecider();
     }
     public MyNode MoveDice(int CurrentPosition,int DiceNumber){
         var res = CurrentPosition+DiceNumber;
       var ser =  NodeLists[res];
     return NodeLists[res];
     }
    
    public int DiceRoller(){
        return new Random().nextInt(6) + 1;
    }
     public void boxpopulator(JPanel pane){ 
        //MyNode[] nodeList = new MyNode[];
        //nodeList
        List<MyNode> specialKeysList = new LinkedList<MyNode>();
     
       var Laders = this.LadersDecider();
       var Snakes = this.snakesDecider();
          specialKeysList.addAll(Laders);
          specialKeysList.addAll(Snakes);
        Component[] comps  = pane.getComponents();
        
        System.out.println(specialKeysList.size());
        for(int i =0; i<=specialKeysList.size();i++){
            var Mnode = specialKeysList.get(i);
          System.out.println("is lader"+Mnode.isLadder);
           System.out.println("is snakke"+Mnode.isSnake);
            System.out.println(Mnode.PostionShiftGetter());
            System.out.println(Mnode.value);
        }
       
     }
     public int MoveAction(int dicechance,MyNode currentnode){
        return 0;


     }
    private List<MyNode> snakesDecider(){
       var SnakeNodes = DiceRoller();
          List<MyNode> snakesList = new ArrayList<>();
        for(int i=0;i<=SnakeNodes;i++){
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
        for(int i=0;i<=LaderNodes;i++){
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
    private static int PositionToFrom(int currentPosition,MyNode Node){
        if(Node.isSnake){
    return (new Random().nextInt(currentPosition));
        } 
        if(Node.isLadder){
            return (new Random().nextInt(currentPosition));
        }
      
        return 0;
                }
    }
