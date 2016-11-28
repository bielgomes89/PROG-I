package br.unisul.trabalhoFinal;

import java.util.Random;

public abstract class Automacao implements TipoAutomacao{

    private String nomeAutomacao;
    private String tipo;
    private String codigo;
    
    @Override
    public String entradaAutomacao(String nome){
        this.setNomeAutomacao(nomeAutomacao);
        Random num = new Random();
        int Codigo = num.nextInt();
        this.codigo = (Codigo<0)?((Codigo*-1)+""):(Codigo+"");
        return this.codigo;
    }
    
    public String toString(){
        String retorno;
        
        retorno = "Código: " +this.getCodigo()+"\n"
                + "Nome da automação: " +this.getNomeAutomacao()+"\n"
                + "Tipo da automação: " +this.getTipo();
        
        return retorno;
    }

    public String getNomeAutomacao() {
        return nomeAutomacao;
    }

    public void setNomeAutomacao(String nomeAutomacao) {
        this.nomeAutomacao = nomeAutomacao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
