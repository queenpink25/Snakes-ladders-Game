/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package victroirauniversirty.coursework.supportAccess;

import java.util.Random;

/**
 *
 * @author DROID
 */
public class DoublyList implements MyNodeFuncs{
   public MyNode Ogutwe;
   public DoublyList(int i){
   this.Ogutwe = new MyNode(i);
   }
    @Override
    public void AddAtFirst(MyNode value) {
        // addin at the end of the nodelist
        //rules of a douby it has a previous and next so we shall implement that in here
      value.PreviousNode = null;
      //value is the data weare insering into the list 
    
      //inserting at the end of the list
      if(Ogutwe==null){
            Ogutwe=value;
      }
      // isnerint at the begining
     
    }
    public void AddAtLast(MyNode Value){
       Value.NextNode = null;
      //value is the data weare insering into the list 
    
      //inserting at the end of the list
      if(Ogutwe==null){
            Ogutwe=Value;
      }
    }
    @Override
    public void RemoteAtlast(MyNode Value) {
        if (this.Ogutwe==null){
         throw new UnsupportedOperationException("The Node is empty"); 
        }
        
        while(Value.NextNode!=null){
             if(Ogutwe.NextNode == null){
             Ogutwe = Value;
            }
        }
      
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public MyNode AddAtpositionx(int from ,int To) {
        MyNode posNode = new MyNode(this.Ogutwe.value);
          MyNode FromsNode = new MyNode(from);
          MyNode tosNode = new MyNode(To);
        Ogutwe.NextNode = tosNode;
        Ogutwe.PreviousNode = FromsNode;
        Ogutwe = posNode;
        return Ogutwe;
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean removeAtPositionx(MyNode node) {
         if(node==null)
         { 
            throw new ArithmeticException("you didnt attend classes and node is null");
         }
         if(node.NextNode!=null){
         //case when its not the last element
         
         node.PreviousNode = node.NextNode;
            return true;
         }
         if(node.PreviousNode!=null){
         //case when its not the first element
         node.NextNode = node.PreviousNode;
         return true;
         }
         node.NextNode=null;
         node.PreviousNode = null;
         return true;
    }
     public MyNode move(int diceRoll) {
         MyNode node = new MyNode(diceRoll);
        for (int i = 0; i < diceRoll; i++) {
            if (Ogutwe.NextNode != null) {
                //not last /..
                
                Ogutwe = Ogutwe.NextNode;
            } else {
                break; // Reached end of board
            }
        }

        // Check if landed on a snake or ladder
      return node;
    }
  
    public MyNode GenerateLAdder(){
       var newNode = NodeMaker();
       newNode.isLadder = true;
       
        return newNode;
    }
    public MyNode GenerateSnake(){
       var newNode = NodeMaker();
       newNode.isSnake = true;
        return newNode;
    }
    private static int RandomMaker(){
    return new Random().nextInt(98) + 1;
    }
    private static MyNode NodeMaker(){
        var value = RandomMaker();
         MyNode newNode = new MyNode(value);
        var res = RandomMaker();
        while(value==res||res>20){
         res = RandomMaker();
    
        }
        newNode.PositionShift = res;
       return newNode;
    }
}
