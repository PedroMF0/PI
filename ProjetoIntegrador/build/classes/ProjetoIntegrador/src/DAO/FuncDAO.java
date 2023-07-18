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
import modelo.FuncVO;
import persistencia.ConexaoBanco;

/**
 *
 * @author 182210051
 */
public class FuncDAO {
    
     public void cadastrarCliente(FuncVO cVO)throws SQLException{
        //Buscar a conexão como banco de dados
        Connection con = ConexaoBanco.getConexao();
        
        //criar objeto capaz de executar as instruções sql no banco de dados
        Statement stat = con.createStatement();
        
        try{
            //String que recebe a instrução SQL
            String sql;
            
            //Montar a instrução INSERT
            sql = "insert into cadastrofunc (idfunc, nomefunc, enderecofunc, cpffunc, dtnascfunc, fonefunc, emailfunc, senhafunc)"
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
            throw new SQLException("Erro ao cadastrar funcionário!");
        }finally{
            con.close();
            stat.close();
        }
        
    }//fecha o método
     
    public ArrayList<FuncVO> buscarCliente() throws SQLException{
        
        Connection con = ConexaoBanco.getConexao();
        Statement stat = con.createStatement();
        
        try{
            String sql;
            sql = "select * from cadastrofunc";
            ResultSet rs = stat.executeQuery(sql);
            ArrayList<FuncVO> cli = new ArrayList<>();
            while(rs.next()){
                FuncVO c = new FuncVO();
                c.setCodCli(rs.getLong("idfunc"));
                c.setNome(rs.getString("nomefunc"));
                c.setEndereco(rs.getString("enderecofunc"));
                c.setCpf(rs.getLong("cpffunc"));
                c.setDtNasc(rs.getString("dtnascfunc"));
                c.setFone(rs.getString("fonefunc"));
                c.setEmail(rs.getString("emailfunc"));
                c.setSenha(rs.getString("senhafunc"));
                
                cli.add(c);
            }//fecha o while
            return cli;
        }catch(SQLException e){
            throw new SQLException("Erro ao buscar funcionário! " + e.getMessage() );
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
            sql ="delete from cadastrofunc where idfunc = " + codCli;
            stat.execute(sql);
            
        }catch(SQLException se){
            throw new SQLException("Erro ao deletar funcionário! " + se.getMessage());
        }finally{
            con.close();
            stat.close();
        }//fim finally
        
 }
      
    public ArrayList<FuncVO> filtrarCliente(String query) throws SQLException{
        Connection con = ConexaoBanco.getConexao();
        Statement stat = con.createStatement();
        
        try{
            String sql;
            sql = "select * from cadastrofunc " + query;
            ResultSet rs = stat.executeQuery(sql);
            ArrayList<FuncVO> cli = new ArrayList<>();
            while(rs.next() ){
                FuncVO c = new FuncVO();
                c.setCodCli(rs.getLong("idfunc"));
                c.setNome(rs.getString("nomefunc"));
                c.setEndereco(rs.getString("enderecofunc"));
                c.setCpf(rs.getLong("cpffunc"));
                c.setDtNasc(rs.getString("dtnascfunc"));
                c.setFone(rs.getString("fonefunc"));
                c.setEmail(rs.getString("emailfunc"));
                c.setSenha(rs.getString("senhafunc"));
                
                cli.add(c);
            }//fecha o laço while
            
            return cli;
        }catch(SQLException se){
            throw new SQLException("Erro ao filtrar funcionário! " + se.getMessage() );
        }finally{
            con.close();
            stat.close();
        }
 }
    
    public void alterarCliente(FuncVO cVO)throws SQLException {
        Connection con = ConexaoBanco.getConexao();
        Statement stat = con.createStatement();
        
        try{
            String sql;
            sql = "update cadastrofunc set "
                    + "nomefunc = ' " + cVO.getNome()+ " ', "
                    + "enderecofunc = ' " + cVO.getEndereco()+ " ', "
                    + "cpffunc =  " + cVO.getCpf()+ " , "
                    + "dtnascfunc = '" +cVO.getDtNasc()+" ', "
                    + "fonefunc = '" + cVO.getFone()+ " ', "
                    + "emailfunc = '" + cVO.getEmail()+" ', "
                    + "senhafunc = '" +cVO.getSenha()+" ' "
                    + "where idfunc = " + cVO.getCodCli();
            stat.executeUpdate(sql);
        }catch(SQLException se){
            throw new SQLException("Erro ao alterar funcionário! " + se.getMessage() );
        }finally{
            con.close();
            stat.close();
        }//fim do finally
 }
}
