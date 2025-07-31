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
    MyNode NextNode;
    // the previous node 
    MyNode PreviousNode;
    public MyNode(int Val){
        this.NextNode = null;
        this.PreviousNode = null;
        this.value = Val;
        // class constructore
        //this is for a doubly where we have the 
        /// the value so thus case the value is the head 
    
}
}
