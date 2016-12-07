package br.engenhariapredial;

public class Eletrica extends Automacao {

    private String relacaoEquipNec;
    private String relacaoEquipFeito;
    private Automacao automacao;

    @Override
    public String toString() {
        String retorno;
        
        retorno = "Automação Elétrica: \n"+super.toString()+"\n"
                + "Equipamento a ser feito: "+this.getRelacaoEquipFeito()+"\n"
                + "Itens necessários: "+this.getRelacaoEquipNec();
                
        return retorno;
    }

    public String getRelacaoEquipFeito() {
        return relacaoEquipFeito;
    }

    public void setRelacaoEquipFeito(String relacaoEquipFeito) {
        this.relacaoEquipFeito = relacaoEquipFeito;
    }
    
    public String getRelacaoEquipNec() {
        return relacaoEquipNec;
    }

    public void setRelacaoEquipNec(String relacaoEquip) {
        this.relacaoEquipNec = relacaoEquip;
    }

    public Automacao getAutomacao() {
        return automacao;
    }

    public void setAutomacao(Automacao automacao) {
        this.automacao = automacao;
    }

}
