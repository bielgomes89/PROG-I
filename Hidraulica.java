package br.unisul.trabalhoFinal;

public class Hidraulica extends Automacao {

    private String volume;
    private String relacaoEquipNec;
    private String relacaoEletrica;
    
    public String toString() {
        String retorno;
        
        retorno = "Automação Hidráulica \n"+super.toString()+"\n"
                + "Volume utilizado: "+this.getVolume()+"\n"
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


    
    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getRelacaoEletrica() {
        return relacaoEletrica;
    }

    public void setRelacaoEletrica(String relacaoEletrica) {
        this.relacaoEletrica = relacaoEletrica;
    }
}
