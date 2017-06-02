/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhointegrado;
/**
 *
 * @author matheus
 */
public class No {
    
    private String nome;
    private String codigo;

    
    public No(String nome, String codigo){
        
        this.nome = nome;
        this.codigo = codigo;
        
    }
    
    public No(){};

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }


}

