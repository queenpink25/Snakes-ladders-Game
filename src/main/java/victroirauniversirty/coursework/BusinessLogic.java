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
    
    private final MyNode[] NodeLists ;
    private final DoublyList MynodesFunc;
    public BusinessLogic(){
        /*here we are constructint he array to be exactly 99 from 0-99 so it holds 100 nubers*/
    
     this.NodeLists  = new MyNode[100];
    }
    public int DiceRoller(){
        return new Random().nextInt(6) + 1;
    }
     public Dimension boxpopulator(Dimension sizes){ 
        
         // the boxes will be of sizes ?? dimension sizes of hiegh
         System.out.println(sizes.height/9);
          // the boxes will be of sizes ?? dimension sizes of width
         System.out.println(sizes.width/9);
          return new Dimension(sizes.height/9,sizes.width/9);
     }
     public int MoveAction(int dicechance,MyNode currentnode){
        return 0;


     }
    private void snakesDecider(){
        //define the boxes ro be called snaekes so that you define there to and from demotion
        NodeLists[0];
        int [] listOfSnakesboxes = new [3];
        //listofSnakesBoxes.
    }
    private void LadersDecider(){
 //define the boxes ro be called snaekes so that you define there to and from promotion
    
    }   
}