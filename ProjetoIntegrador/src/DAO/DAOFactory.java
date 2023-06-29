/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author 182210051
 */
public class DAOFactory {
   
     private static ClienteDAO clienteDAO = new ClienteDAO();
     
     public static ClienteDAO getClienteDAO(){
        return clienteDAO;
    }//fecha o método

}
