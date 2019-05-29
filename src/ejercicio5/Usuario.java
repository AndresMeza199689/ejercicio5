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
public class Usuario {

    private final String login;
    private LocalDate ultimoAcceso;
    private String password;
    private ArrayList<String> historial;

    public Usuario(String login, String password) {
        this.login = login;
        this.password = password;
        historial = new ArrayList<String>();
        historial.add(password);
        ultimoAcceso = LocalDate.now();
    }


    public boolean llenarhistorial(String pass) {
        if (!this.historial.contains(pass)) {
            this.historial.add(pass);
            return true;
        }
        return false;
    }

    public boolean modificarPassword(String pass1, String pass2) {
        if (validar(pass1)) {
            if (!this.historial.contains(pass2)) {
                this.password = pass2;
            }
            historial.add(pass2);
            return true;
        }
        return false;
    }

    public boolean validar(String pass) {
        if (pass.equals(this.password)) {
            return true;
        }
        return false;
    }

    public String getLogin() {
        return login;
    }
   
    public void ultimoAcceso() {
        ultimoAcceso = LocalDate.now();
    }

    public LocalDate getUltimoAcceso() {
        return ultimoAcceso;
    }
 
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<String> getHistorial() {
        return historial;
    }

}
