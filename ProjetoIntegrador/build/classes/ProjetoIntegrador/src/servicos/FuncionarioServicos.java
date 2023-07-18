/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicos;

import DAO.FuncDAO;
import DAO.DAOFactory;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.FuncVO;


/**
 *
 * @author 182210051
 */
public class FuncionarioServicos {
     public void cadastrarCliente(FuncVO cVO) throws SQLException{
        FuncDAO cDAO = DAOFactory.getClienteDAO();
        cDAO.cadastrarCliente(cVO);        
    }//fim do método cadastrarCliente
     
    public ArrayList<FuncVO> buscarCliente() throws SQLException{
        FuncDAO cDAO = DAOFactory.getClienteDAO();
        
        return cDAO.buscarCliente();
    }//fecha o método buscarProduto
      
    public void deletarCliente(long codcli) throws SQLException{
        FuncDAO  cDAO= DAOFactory.getClienteDAO();
        cDAO.deletarCliente(codcli);
    }//fecha o método
       
    public ArrayList<FuncVO> filtrarCliente(String query) throws SQLException{
        FuncDAO cDAO = DAOFactory.getClienteDAO();
        return cDAO.filtrarCliente(query);
    }//fecha o 
          
    public void alterarCliente(FuncVO cVO) throws SQLException{
        FuncDAO cDAO = DAOFactory.getClienteDAO();
        cDAO.alterarCliente(cVO);
    }//fecha o mé

    
}
