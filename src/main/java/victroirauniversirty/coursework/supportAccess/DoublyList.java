/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package victroirauniversirty.coursework.supportAccess;

/**
 *
 * @author DROID
 */
public class DoublyList implements MyNodeFuncs{
   private MyNode Ogutwe;
    @Override
    public void AddAtFirst(int value) {
        // addin at the end of the nodelist
        //rules of a douby it has a previous and next so we shall implement that in here
      MyNode Node = new MyNode(value);
      //value is the data weare insering into the list 
     
      //inserting at the end of the list
      if(Ogutwe==null){
            Ogutwe=Node;
      }
      // isnerint at the begining
     
    }

    @Override
    public void RemoteAtlast(int Value) {
        if (this.Ogutwe==null){
         throw new UnsupportedOperationException("The Node is empty"); 
        }
        MyNode RemovableNode = new MyNode(Value);
        while(Ogutwe.NextNode!=null){
             if(Ogutwe.NextNode == null){
            RemovableNode = Ogutwe;
            }
        }
      
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void AddAtpositionx(int from ,int To) {
        MyNode posNode = new MyNode(0);
          MyNode FromsNode = new MyNode(from);
          MyNode tosNode = new MyNode(To);
        Ogutwe.NextNode = tosNode;
        Ogutwe.PreviousNode = FromsNode;
        Ogutwe = posNode;
        
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
    
}
