/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package victroirauniversirty.coursework.supportAccess;

/**
 *
 * @author DROID
 */
public class MyNode {
   public  int value;
    // the next bvalue
   public Boolean isSnake;
   public Boolean isLadder;
    MyNode NextNode;
    // the previous node 
    int PositionShift;
    MyNode PreviousNode;
    public MyNode(int Val){
        this.NextNode = null;
        this.PreviousNode = null;
        this.value = Val;
        this.isLadder = false;
        this.isSnake = false;
        this.PositionShift = 0;
        // class constructore
        //this is for a doubly where we have the 
        /// the value so thus case the value is the head 
    
}
    public int PostionShiftGetter(){
        return this.PositionShift;
    }
    public void positionShiftSetter(int val){
       this.PositionShift = val;
    }
      public MyNode NextMyNodeGetter(){
        return this.NextNode;
    }
    public void NextNodeSetter (MyNode val){
       this.NextNode = val;
    }
    public MyNode PreviousMyNodeGetter(){
        return this.PreviousNode;
    }
    public void PreviousMyNodeSetter(MyNode val){
       this.PreviousNode = val;
    }
}
