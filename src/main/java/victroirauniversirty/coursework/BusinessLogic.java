/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package victroirauniversirty.coursework;

import java.util.Random;
import java.awt.Dimension;
import victroirauniversirty.coursework.supportAccess.DoublyList;
import victroirauniversirty.coursework.supportAccess.MyNode;
/**
 *
 * @author DROID
 */
public class BusinessLogic {
    //nodelists is the number of boxes we have we implementeed the doubly linked list we ahll be able to sort it ad adn remove based on the previous na dnext ndoes
    
    public final MyNode[] NodeLists ;
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
     this.LadersDecider();
     this.snakesDecider();
     }
     public MyNode MoveDice(int CurrentPosition,int DiceNumber){
         var res = CurrentPosition+DiceNumber;
     return NodeLists[res];
     }
    
    public int DiceRoller(){
        return new Random().nextInt(6) + 1;
    }
     public void boxpopulator(){ 
        
        this.LadersDecider();
        this.snakesDecider();
         
     }
     public int MoveAction(int dicechance,MyNode currentnode){
        return 0;


     }
    private void snakesDecider(){
       var SnakeNodes = DiceRoller();
        for(int i=0;i>=SnakeNodes;i++){

         MyNode res =this.MynodesFunc.GenerateSnake();
         res.positionShiftSetter(PositionToFrom(res.PostionShiftGetter(),res));
         this.NodeLists[res.PostionShiftGetter()]=res;
         res.isSnake = true;
        // this.MynodesFunc./ search the node and replace it 
        }
        System.out.println(SnakeNodes);
       
        //define the boxes ro be called snaekes so that you define there to and from demotion
//        NodeLists[0];
  //      int [] listOfSnakesboxes = new [3];
        //listofSnakesBoxes.
    }
    private void LadersDecider(){
        var LaderNodes = DiceRoller();
        for(int i=0;i>=LaderNodes;i++){

         var res = this.MynodesFunc.GenerateLAdder();
         res.positionShiftSetter(PositionToFrom(res.PostionShiftGetter(),res));
         this.NodeLists[res.PostionShiftGetter()]=res;
         res.isLadder = true;
        // this.MynodesFunc./ search the node and replace it 
        }
 //define the boxes ro be called snaekes so that you define there to and from promotion
      System.out.println(LaderNodes);
       
    }   
    private static int PositionToFrom(int currentPosition,MyNode Node){
        if(Node.isSnake){
    return (new Random().nextInt(currentPosition)-10);
        } 
        if(Node.isLadder){
            return (new Random().nextInt(currentPosition)+10);
        }
      
        return 0;
                }
    }
