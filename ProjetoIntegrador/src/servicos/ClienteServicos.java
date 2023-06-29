/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicos;

import DAO.ClienteDAO;
import DAO.DAOFactory;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.ClienteVO;


/**
 *
 * @author 182210051
 */
public class ClienteServicos {
     public void cadastrarCliente(ClienteVO cVO) throws SQLException{
        ClienteDAO cDAO = DAOFactory.getClienteDAO();
        cDAO.cadastrarCliente(cVO);        
    }//fim do método cadastrarCliente
     
    public ArrayList<ClienteVO> buscarCliente() throws SQLException{
        ClienteDAO cDAO = DAOFactory.getClienteDAO();
        
        return cDAO.buscarCliente();
    }//fecha o método buscarProduto
      
    public void deletarCliente(long codcli) throws SQLException{
        ClienteDAO  cDAO= DAOFactory.getClienteDAO();
        cDAO.deletarCliente(codcli);
    }//fecha o método
       
    public ArrayList<ClienteVO> filtrarCliente(String query) throws SQLException{
        ClienteDAO cDAO = DAOFactory.getClienteDAO();
        return cDAO.filtrarCliente(query);
    }//fecha o 
          
    public void alterarCliente(ClienteVO cVO) throws SQLException{
        ClienteDAO cDAO = DAOFactory.getClienteDAO();
        cDAO.alterarCliente(cVO);
    }//fecha o mé

    
}
