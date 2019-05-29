/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio5;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Dell
 */
public class Blacklist extends Verificador{
    private ArrayList<String> blacklist;
    
    public Blacklist() {
        super("Introduzca el número del día de su último acceso");
        this.blacklist = new ArrayList<String>();
    }
    
    public boolean bloquear(String login){
        if(this.ColeccionDeusuarios.containsKey(login)){
            blacklist.add(login);
            return true;
        }
        return false;
    }
    
    public boolean desbloquear(String login){
        if(blacklist.contains(login)){
            blacklist.remove(login);    
            return true;
        }
        return false;
    }
    
    public boolean bloqueado(String login){
        if(blacklist.contains(login)){
            return true;
        }
        return false;
    }
    
    public boolean HabilitarVerificacion(String login, String pass){
        if(!bloqueado(login)){
            return true;
        }
        return false;
        }
    
    public int RecibirFecha(String login){
        Usuario a = this.ColeccionDeusuarios.get(login);
        LocalDate fecha = a.getUltimoAcceso();
        return fecha.getDayOfMonth();      
    }

    public String rDesafio(String login) {
        String dia =""+RecibirFecha(login);
        return dia;  
    }
    
}
