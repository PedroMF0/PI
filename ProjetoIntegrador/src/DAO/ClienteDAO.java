/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.ClienteVO;
import persistencia.ConexaoBanco;

/**
 *
 * @author 182210051
 */
public class ClienteDAO {
    
     public void cadastrarCliente(ClienteVO cVO)throws SQLException{
        //Buscar a conexão como banco de dados
        Connection con = ConexaoBanco.getConexao();
        
        //criar objeto capaz de executar as instruções sql no banco de dados
        Statement stat = con.createStatement();
        
        try{
            //String que recebe a instrução SQL
            String sql;
            
            //Montar a instrução INSERT
            sql = "insert into cadastro (idcliente, nomecli, enderecocli, cpfcli, dtnasccli, fonecli, emailcli, senhacli)"
                    + "values(null, '"+ cVO.getNome() +"', '"
                    + cVO.getEndereco()+ "', "
                    + cVO.getCpf() + ", '"
                    + cVO.getDtNasc() + " ', '"
                    + cVO.getFone() + "', '"
                    + cVO.getEmail() + "', '" 
                    + cVO.getSenha() + "') ";
            //Executar o SQL
            stat.execute(sql);
            
        }catch (SQLException e){
            throw new SQLException("Erro ao cadastrar cliente!");
        }finally{
            con.close();
            stat.close();
        }
        
    }//fecha o método
     
    public ArrayList<ClienteVO> buscarCliente() throws SQLException{
        
        Connection con = ConexaoBanco.getConexao();
        Statement stat = con.createStatement();
        
        try{
            String sql;
            sql = "select * from cadastro";
            ResultSet rs = stat.executeQuery(sql);
            ArrayList<ClienteVO> cli = new ArrayList<>();
            while(rs.next()){
                ClienteVO c = new ClienteVO();
                c.setCodCli(rs.getLong("idcliente"));
                c.setNome(rs.getString("nomecli"));
                c.setEndereco(rs.getString("enderecocli"));
                c.setCpf(rs.getLong("cpfcli"));
                c.setDtNasc(rs.getString("dtnasccli"));
                c.setFone(rs.getString("fonecli"));
                c.setEmail(rs.getString("emailcli"));
                c.setSenha(rs.getString("senhacli"));
                
                cli.add(c);
            }//fecha o while
            return cli;
        }catch(SQLException e){
            throw new SQLException("Erro ao buscar cliente! " + e.getMessage() );
        }finally{
            con.close();
            stat.close();
        }//fim finally
   }
      
    public void deletarCliente(long codCli) throws SQLException{
        Connection con = ConexaoBanco.getConexao();
        Statement stat = con.createStatement();
        
        try{
            String sql;
            sql ="delete from cadastro where idcliente = " + codCli;
            stat.execute(sql);
            
        }catch(SQLException se){
            throw new SQLException("Erro ao deletar cliente! " + se.getMessage());
        }finally{
            con.close();
            stat.close();
        }//fim finally
        
 }
      
    public ArrayList<ClienteVO> filtrarCliente(String query) throws SQLException{
        Connection con = ConexaoBanco.getConexao();
        Statement stat = con.createStatement();
        
        try{
            String sql;
            sql = "select * from cadastro " + query;
            ResultSet rs = stat.executeQuery(sql);
            ArrayList<ClienteVO> cli = new ArrayList<>();
            while(rs.next() ){
                ClienteVO c = new ClienteVO();
                c.setCodCli(rs.getLong("idcliente"));
                c.setNome(rs.getString("nomecli"));
                c.setEndereco(rs.getString("enderecocli"));
                c.setCpf(rs.getLong("cpfcli"));
                c.setDtNasc(rs.getString("dtnasccli"));
                c.setFone(rs.getString("fonecli"));
                c.setEmail(rs.getString("emailcli"));
                c.setSenha(rs.getString("senhacli"));
                
                cli.add(c);
            }//fecha o laço while
            
            return cli;
        }catch(SQLException se){
            throw new SQLException("Erro ao filtrar cliente! " + se.getMessage() );
        }finally{
            con.close();
            stat.close();
        }
 }
    
    public void alterarCliente(ClienteVO cVO)throws SQLException {
        Connection con = ConexaoBanco.getConexao();
        Statement stat = con.createStatement();
        
        try{
            String sql;
            sql = "update cadastro set "
                    + "nomecli = ' " + cVO.getNome()+ " ', "
                    + "enderecocli = ' " + cVO.getEndereco()+ " ', "
                    + "cpfcli =  " + cVO.getCpf()+ " , "
                    + "fonecli = '" + cVO.getFone()+ " ', "
                    + "emailcli = '" + cVO.getEmail()+" ', "
                    + "dtnasccli = '" +cVO.getDtNasc()+" ', "
                    + "senhacli = '" +cVO.getSenha()+" ' "
                    + "where idcliente = " + cVO.getCodCli();
            stat.executeUpdate(sql);
        }catch(SQLException se){
            throw new SQLException("Erro ao alterar cliente! " + se.getMessage() );
        }finally{
            con.close();
            stat.close();
        }//fim do finally
 }
}
