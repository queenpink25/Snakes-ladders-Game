/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package victroirauniversirty.coursework;

import java.util.Random;

/**
 *
 * @author DROID
 */
public class BusinessLogic {
    private final int[] BoxFileds;
    public BusinessLogic(){
        /*here we are constructint he array to be exactly 99 from 0-99 so it holds 100 nubers*/
     BoxFileds = new int[100];
     for(var i=0;i<BoxFileds.length;i++){
     BoxFileds[i]=i;
     }
     
    }
    public int DiceRoller(){
        return new Random().nextInt(6) + 1;
    }
}

