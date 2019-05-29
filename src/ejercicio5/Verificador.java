/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio5;

import java.util.HashMap;
import java.util.UUID;

/**
 *
 * @author Dell
 */
public abstract class Verificador {
    protected HashMap <String,Usuario> ColeccionDeusuarios;
    protected final String pDesafio;
    protected HashMap <String,String> desafios;

    public Verificador(String pDesafio) {
        this.pDesafio = pDesafio;
        ColeccionDeusuarios = new HashMap <String,Usuario>(); 
        desafios = new HashMap <String,String>();
    }
    
    public void añadirUsuario(Usuario... a){
        for(Usuario u:a){
            ColeccionDeusuarios.put(u.getLogin(),u);
        }      
    }
    
    public boolean eliminarUsuario(Usuario a){
        ColeccionDeusuarios.remove(a.getLogin());
        return false;
    }
    
    public void verificacionDosPasos(String login,String pass){
       String token=loginPaso1(login,pass);
          loginPaso2(token,rDesafio(login));
    }
    
    protected String loginPaso1(String login, String pass){
        String token;       
        if(ColeccionDeusuarios.containsKey(login) && ColeccionDeusuarios.get(login).getPassword().equals(pass)){
             token = UUID.randomUUID().toString(); 
                          rDesafio(login);
                          desafios.put(token, rDesafio(login));
             return token;
        }      
        return null;  
    }
    
   public boolean loginPaso2(String token, String r){
       if(desafios.containsKey(token)){
           if(desafios.get(token).equals(r)){
               desafios.remove(token);
               return true;
           }else{
               return false;
           }
       }
        return false;    
   }
    
    public abstract String rDesafio(String login);

    public HashMap<String, Usuario> getColeccionDeusuarios() {
        return ColeccionDeusuarios;
    }

    public void setColeccionDeusuarios(HashMap<String, Usuario> ColeccionDeusuarios) {
        this.ColeccionDeusuarios = ColeccionDeusuarios;
    }

    public String getpDesafio() {
        return pDesafio;
    }

    public void setDesafios(HashMap<String, String> desafios) {
        this.desafios = desafios;
    }

  
    
    
}
