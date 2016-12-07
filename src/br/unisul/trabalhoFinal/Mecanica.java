package br.engenhariapredial;

public class Mecanica extends Automacao{

    private String objetivo;
    private String relacaoEquipNec;
    private String relacaoEletrica;
    
    @Override
    public String toString() {
        String retorno;
        
        retorno = "Automação Mecânica \n"+super.toString()+"\n"
                + "Objetivo da automação: "+this.getObjetivo()+"\n"
                + "Relação com automação eletrica: "+this.getRelacaoEletrica()+"\n"
                + "Itens necessários: "+this.getRelacaoEquipNec();
                
        return retorno;
    }

    public String getRelacaoEquipNec() {
        return relacaoEquipNec;
    }

    public void setRelacaoEquipNec(String relacaoEquipNec) {
        this.relacaoEquipNec = relacaoEquipNec;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public String getRelacaoEletrica() {
        return relacaoEletrica;
    }

    public void setRelacaoEletrica(String relacaoEletrica) {
        this.relacaoEletrica = relacaoEletrica;
    }


}
