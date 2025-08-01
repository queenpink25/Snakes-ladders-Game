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
    int value;
    // the next bvalue
    Boolean isSnake;
    Boolean isLadder;
    MyNode NextNode;
    // the previous node 
    int PositionShift;
    MyNode PreviousNode;
    public MyNode(int Val){
        this.NextNode = null;
        this.PreviousNode = null;
        this.value = Val;
        this.isLadder = false;
        this.isSnake = true;
        this.PositionShift = 0;
        // class constructore
        //this is for a doubly where we have the 
        /// the value so thus case the value is the head 
    
}
}
