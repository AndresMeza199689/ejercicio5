/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio5;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

/**
 *
 * @author Dell
 */
public class Ejercicio5 {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        String login,pass1,pass2,dia,codigo;
        
        Scanner sc = new Scanner(System.in);
        
        Usuario f = new Usuario("fperez","lechemerengada");
        f.modificarPassword("lechemerengada","cr7comeback");
        
        Usuario m = new Usuario("mlama","tururu");
        
        Blacklist B = new Blacklist();
        Codigo C = new Codigo(3);
        
        B.añadirUsuario(f);
        B.añadirUsuario(m);
        C.añadirUsuario(f);
        C.añadirUsuario(m);
        
        ArrayList<Verificador> ListaDeVerificacion = new ArrayList<>();
        ListaDeVerificacion.add(B);
        ListaDeVerificacion.add(C);
        
        for(Verificador i:ListaDeVerificacion){
            if(i.equals(B)){
                B.bloquear(m.getLogin());
            }
        }
        
        for (Verificador j:ListaDeVerificacion) {
           System.out.println("...  Validar Usuario  ...");
           System.out.println("Ingrese nombre de Usuario:");
           login = sc.nextLine(); 
           System.out.println("Ingrese contraseña Actual:");
           pass1 = sc.nextLine();
           
           if(j.equals(B)){
               
            System.out.println("...BlackList..");
            if(!B.bloqueado(login)){
            B.loginPaso1(login, pass1);
            if(B.loginPaso1(login, pass1)!=null){
                System.out.println(B.pDesafio);
                System.err.println(B.rDesafio(login));
                System.out.print("Ingrese la Respuesta:");
                dia = sc.nextLine();
                B.loginPaso2(B.loginPaso1(login,pass1), dia);
                if(B.loginPaso2(B.loginPaso1(login,pass1), dia)){
                    System.out.println("Login paso 2 ha sido exitoso");
                 }else System.out.println("No se pudo completar el paso 2 la respuesta es incorrecta");
            }else System.out.println("verifique si el usuario es correcto o la contraseña sea correcta");  
            }else System.out.println("El usuario se encuentra bloqueado"); 
            
           }else{
               
               
                C.loginPaso1(login, pass1);
                if(C.loginPaso1(login, pass1)!=null){
                    System.out.println("...Codigo...");
                    System.err.println(C.rDesafio(login));
                    System.out.println("Tiene "+C.n()+" intentos");
                    for (int i = 0; i < C.n(); i++) {
                        System.out.println("...Intento "+(i+1)+"...");
                       System.out.print("Ingrese la Respuesta:");
                       codigo = sc.nextLine(); 
                         if(C.verificarCodigo(login, codigo)){
                             C.loginPaso2(C.loginPaso1(login, pass1), codigo);
                             if(C.loginPaso2(C.loginPaso1(login, pass1), codigo)){
                                 System.out.println("El paso dos ha sido realizado con exito");
                                 break;
                             }
                             
                         }else if((i+1) < C.n())System.err.println("Intente nuevamente");
                         if((i+1) == C.n() && C.loginPaso2(C.loginPaso1(login, pass1), codigo)==false)
                             System.out.println("Ha sido Superado el limite de intentos");
                            
                         if(C.verificarCodigo(login, codigo)) System.out.println("El codigo ingresado es incorrecto");
                    }   
                    String codigom = "";
                       
                        C.loginPaso2(C.loginPaso1(login, pass1), codigom);
                        
                        
                    
                }else if(C.loginPaso1(login, pass1)==null)System.out.println("verifique si el usuario es correcto o la contraseña sea correcta");
           }
        }                 
    }
}
                       

        
        
      
    

