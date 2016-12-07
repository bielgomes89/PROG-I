package br.engenhariapredial;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ControleAcoes {

    private static final ControleAcoes instancia = new ControleAcoes();
    private Eletrica eletrica;
    private Mecanica mecanica;
    private Hidraulica hidraulica;
    private final ArrayList<Automacao> listAutomacao = new ArrayList<>();

    private ControleAcoes() {
    }

    public static ControleAcoes getInstance() {
        return ControleAcoes.instancia;
    }

    public void menus(String opcao, String tipo) {

        //Registra as automações
        switch (opcao) {
            case "1":
               
                switch (tipo) {
                    case "1": {
                        //Registra os dados e adiciona ao ArrayList.
                        this.eletrica = new Eletrica();
                        String[] resposta = mensagemTela("1");
                        this.eletrica.setNomeAutomacao(resposta[0]);
                        this.eletrica.setCodigo(this.eletrica.entradaAutomacao(this.eletrica.getNomeAutomacao()));
                        this.eletrica.setTipo("Elétrica");
                        this.eletrica.setRelacaoEquipFeito(resposta[1]);
                        this.eletrica.setRelacaoEquipNec(resposta[2]);
                        listAutomacao.add(eletrica);
                        JOptionPane.showMessageDialog(null, "Automação Elétrica cadastrada com sucesso!");
                        
                        break;
                    }
                    case "2": {
                        //Registra os dados e adiciona ao ArrayList.
                        this.mecanica = new Mecanica();
                        String[] resposta = mensagemTela("2");
                        this.mecanica.setNomeAutomacao(resposta[0]);
                        this.mecanica.setCodigo(this.mecanica.entradaAutomacao(this.mecanica.getNomeAutomacao()));
                        this.mecanica.setTipo("Mecânica");
                        this.mecanica.setObjetivo(resposta[1]);
                        this.mecanica.setRelacaoEletrica(resposta[2]);
                        this.mecanica.setRelacaoEquipNec(resposta[3]);
                        listAutomacao.add(mecanica);
                        JOptionPane.showMessageDialog(null, "Automação Mecânica cadastrada com sucesso!");
                        
                        break;
                    }
                    case "3": {
                        //Registra os dados e adiciona ao ArrayList.
                        this.hidraulica = new Hidraulica();
                        String[] resposta = mensagemTela("3");
                        this.hidraulica.setNomeAutomacao(resposta[0]);
                        this.hidraulica.setCodigo((this.hidraulica.entradaAutomacao(this.mecanica.getNomeAutomacao())));
                        this.hidraulica.setTipo("Hidráulica");
                        this.hidraulica.setVolume(resposta[1]);
                        this.hidraulica.setRelacaoEletrica(resposta[2]);
                        this.hidraulica.setRelacaoEquipNec(resposta[3]);
                        listAutomacao.add(hidraulica);
                        JOptionPane.showMessageDialog(null, "Automoção Hidráulica cadastrada com sucesso!");
                        
                        break;
                    }
                }

                break;

            case "2":
                switch (tipo) {
                    case "1": {
                        //Lista automações elétricas
                        String msg = "";
                        for (int i = 0; i < listAutomacao.size(); i++) {
                            if (listAutomacao.get(i).getTipo().equals("Elétrica")) {
                                msg = msg + listAutomacao.get(i) + "\n";
                            }
                        }
                        
                        if("".equals(msg)) {                            
                            JOptionPane.showMessageDialog(null, "Não existem automações a serem listadas!");
                            
                        } else {
                            JOptionPane.showMessageDialog(null, msg);
                            
                        }
                        
                        break;
                    }

                    case "2": {
                        //Lista automações mecânicas
                        String msg = "";
                        for (int i = 0; i < listAutomacao.size(); i++) {
                            if (listAutomacao.get(i).getTipo().equals("Mecânica")) {
                                msg = msg + listAutomacao.get(i) + "\n";
                            }
                        }
                        
                        if("".equals(msg)) {                            
                            JOptionPane.showMessageDialog(null, "Não existem automações a serem listadas!");
                            
                        } else {
                            JOptionPane.showMessageDialog(null, msg);
                            
                        }
                        
                        break;
                    }

                    case "3": {
                        //Lista automações
                        String msg = "";
                        for (int i = 0; i < listAutomacao.size(); i++) {
                            if (listAutomacao.get(i).getTipo().equals("Hidráulica")) {
                                msg = msg + listAutomacao.get(i) + "\n";
                            }
                        }
                        
                        if("".equals(msg)) {                            
                            JOptionPane.showMessageDialog(null, "Não existem automações a serem listadas!");
                            
                        } else {
                            JOptionPane.showMessageDialog(null, msg);
                            
                        }
                        
                        break;
                    }
                }

                break;

            case "3":

                //Busca a automação por nome
                String consulta = JOptionPane.showInputDialog("Digite o nome da automação a ser buscado: ");
                Automacao msg = null;

                for (int i = 0; i < listAutomacao.size(); i++) {
                    if (listAutomacao.get(i).getNomeAutomacao().equals(consulta)) { //Procura o nome da automação
                        msg = listAutomacao.get(i);
                        JOptionPane.showMessageDialog(null, msg);
                        
                    }
                }
                
                if( msg == null) {
                    JOptionPane.showMessageDialog(null, "Nome da automação incorreto!");
                }

                break;

            default:
                

        }
    }

    public String[] mensagemTela(String tipoAutomacao) {
        String retorno[] = new String[5];

        //Cadastra o nome da automação
        retorno[0] = JOptionPane.showInputDialog("Informe o nome da Automação: ");
        switch (tipoAutomacao) {

            //Cadastro automação elétrica
            case "1": {

                //Cadastra o nome do equipamento que vai ser realizado a automatização elétrica.
                retorno[1] = JOptionPane.showInputDialog("Informe o equipamento que será feito:");

                //Cadastro do código e descrição dos itens necessários para realizar a automatização.
                int size = Integer.parseInt(JOptionPane.showInputDialog("Informe a quantidade de itens necessários:"));
                String codigo = "";
                String descricao = "";
                retorno[2] = "\n";
                for (int i = 0; i < size; i++) {
                    codigo = JOptionPane.showInputDialog("Informe o código do " + (i + 1) + "º item: ");
                    descricao = JOptionPane.showInputDialog("Informe a descrição do " + (i + 1) + "º item: ");
                    retorno[2] = retorno[2] + "Código: " + codigo + " | " + "Descrição: " + descricao + "\n";
                }
                break;

            }

            //Cadastro automação Mecânica
            case "2": {

                //Cadastra o objetivo da automação.
                retorno[1] = JOptionPane.showInputDialog("Informe o objetivo da automação: \n"
                        + "[E]ntretenimento; \n"
                        + "[L]impeza;\n"
                        + "[A]cessibilidade.");

                switch (retorno[1]) {

                    case "E":
                    case "e":
                        retorno[1] = "Entretenimento";
                        break;

                    case "L":
                    case "l":
                        retorno[1] = "Limpeza";
                        break;

                    case "A":
                    case "a":
                        retorno[1] = "Acessibilidade";
                        break;

                }

                retorno[2] = JOptionPane.showInputDialog("Essa automação tem relação com automação elétrica? \n"
                        + "[S]im \n"
                        + "[N]ão");

                switch (retorno[2]) {

                    case "S":
                    case "s":
                        retorno[2] = JOptionPane.showInputDialog("Qual a relação com Automação Elétrica?");
                        break;

                    case "N":
                    case "n":
                        retorno[2] = "Não";
                        break;

                }

                int size = Integer.parseInt(JOptionPane.showInputDialog("Informe a quantidade de itens necessários:"));
                String codigo = "";
                String descricao = "";
                retorno[3] = "\n";
                for (int i = 0; i < size; i++) {
                    codigo = JOptionPane.showInputDialog("Informe o código do " + (i + 1) + "º item: ");
                    descricao = JOptionPane.showInputDialog("Informe a descrição do " + (i + 1) + "º item: ");
                    retorno[3] = retorno[3] + "Código: " + codigo + " | " + "Descrição: " + descricao + "\n";
                }

                break;
            }

            //Cadastro automação hidráulica
            case "3": {

                //Cadastra o volume da automação.
                retorno[1] = JOptionPane.showInputDialog("Informe o volume utilizado: ");

                //Cadastra se a automação possui relação com automação Elétrica
                retorno[2] = JOptionPane.showInputDialog("Essa automação tem relação com automação elétrica? \n"
                        + "[S]im \n"
                        + "[N]ão");

                switch (retorno[2]) {
                    case "S":
                    case "s":
                        retorno[2] = JOptionPane.showInputDialog("Qual a relação com Automação Elétrica?");
                        break;

                    case "N":
                    case "n":
                        retorno[2] = "Não";
                        break;

                }

                int size = Integer.parseInt(JOptionPane.showInputDialog("Informe a quantidade de itens necessários:"));
                String codigo = "";
                String descricao = "";
                retorno[3] = "\n";
                for (int i = 0; i < size; i++) {
                    codigo = JOptionPane.showInputDialog("Informe o código do " + (i + 1) + "º item: ");
                    descricao = JOptionPane.showInputDialog("Informe a descrição do " + (i + 1) + "º item: ");
                    retorno[3] = retorno[3] + "Código: " + codigo + " | " + "Descrição: " + descricao + "\n";
                }

                break;

            }
        }

        return retorno;
    }

}
