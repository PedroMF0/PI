/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicos;

/**
 *
 * @author 182210051
 */
public class ServicosFactory {
    
     
    private static ClienteServicos clienteServicos = new ClienteServicos();
    
    public static ClienteServicos getClienteServicos(){
        return clienteServicos;
    }
    
}
