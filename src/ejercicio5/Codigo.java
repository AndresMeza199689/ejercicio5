/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio5;

import java.util.Random;

/**
 *
 * @author Dell
 */
public class Codigo extends Verificador {
    private int n;
    public Codigo(int n) {
        super("Introduzca el número que ha recibido por SMS");
        this.n = n;
    }
    
  
       String r = ""+(int) (Math.random() * 1000) ;
  
    public void imprimirC(){
        System.err.println(r);
    }
    
    public boolean verificarCodigo(String login,String codigo){
       if(rDesafio(login).equals(codigo)){
         return true;  
       } 
        return false;
    }
    
    public int n(){
        return this.n;
    } 
    
    @Override
    public String rDesafio(String login) {
        String a = ""+this.r;
        return a;
    }
    
}
