package br.unisul.trabalhoFinal;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ControleAcoes {

    private static final ControleAcoes instancia = new ControleAcoes();
    private Eletrica eletrica;
    private Mecanica mecanica;
    private Hidraulica hidraulica;
    ArrayList<Eletrica> listEletrica = new ArrayList<>();
    ArrayList<Mecanica> listMecanica = new ArrayList<>();
    ArrayList<Hidraulica> listHidraulica = new ArrayList<>();

    private ControleAcoes() {
    }

    public static ControleAcoes getInstance() {
        return ControleAcoes.instancia;
    }

    public void menus(String opcao) {

        //Registra as automações
        if (opcao.equals("1")) {
            String automocao = JOptionPane.showInputDialog("Informe o tipo da Automação: \n"
                    + "1- Elétrica;\n"
                    + "2- Mecânica;\n"
                    + "3- Hidráulica.");
            if (automocao.equals("1")) {

                //Registra os dados e adiciona ao ArrayList.
                this.eletrica = new Eletrica();
                String[] resposta = mensagemTela("1");

                this.eletrica.setNomeAutomacao(resposta[0]);
                this.eletrica.setCodigo(this.eletrica.entradaAutomacao(this.eletrica.getNomeAutomacao()));
                this.eletrica.setTipo("Elétrica");
                this.eletrica.setRelacaoEquipFeito(resposta[1]);
                this.eletrica.setRelacaoEquipNec(resposta[2]);
                listEletrica.add(eletrica);
                JOptionPane.showMessageDialog(null, "Automação Elétrica cadastrada com sucesso!");

            } else if (automocao.equals("2")) {

                //Registra os dados e adiciona ao ArrayList.
                this.mecanica = new Mecanica();
                String[] resposta = mensagemTela("2");

                this.mecanica.setNomeAutomacao(resposta[0]);
                this.mecanica.setCodigo(this.mecanica.entradaAutomacao(this.mecanica.getNomeAutomacao()));
                this.mecanica.setTipo("Mecânica");
                this.mecanica.setObjetivo(resposta[1]);
                this.mecanica.setRelacaoEletrica(resposta[2]);
                this.mecanica.setRelacaoEquipNec(resposta[3]);
                listMecanica.add(mecanica);
                JOptionPane.showMessageDialog(null, "Automação Mecânica cadastrada com sucesso!");

            } else if (automocao.equals("3")) {

                //Registra os dados e adiciona ao ArrayList.
                this.hidraulica = new Hidraulica();
                String[] resposta = mensagemTela("3");

                this.hidraulica.setNomeAutomacao(resposta[0]);
                this.hidraulica.setCodigo((this.hidraulica.entradaAutomacao(this.mecanica.getNomeAutomacao())));
                this.hidraulica.setTipo("Hidráulica");
                this.hidraulica.setVolume(resposta[1]);
                this.hidraulica.setRelacaoEletrica(resposta[2]);
                this.hidraulica.setRelacaoEquipNec(resposta[3]);
                listHidraulica.add(hidraulica);
                JOptionPane.showMessageDialog(null, "Automoção Hidráulica cadastrada com sucesso!");
            }

        } else if (opcao.equals("2")) {

            //Lista automações elétricas
            String msg = "";
            for (int i = 0; i < listEletrica.size(); i++) {
                msg = msg + listEletrica.get(i) + "\n";
            }

            JOptionPane.showMessageDialog(null, msg);

        } else if (opcao.equals("3")) {

            //Lista automações mecânicas
            String msg = "";
            for (int i = 0; i < listMecanica.size(); i++) {
                msg = msg + listMecanica.get(i) + "\n";
            }
            JOptionPane.showMessageDialog(null, msg);

        } else if (opcao.equals("4")) {

            //Lista automações mecânicas
            String msg = "";
            for (int i = 0; i < listHidraulica.size(); i++) {
                msg = msg + listHidraulica.get(i) + "\n";
            }
            JOptionPane.showMessageDialog(null, msg);

        } else if (opcao.equals("5")) {

            //Busca a automação por nome
            String consulta = JOptionPane.showInputDialog("Digite o nome da automação a ser buscado: ");

            for (int i = 0; i < listEletrica.size(); i++) {
                if (listEletrica.get(i).getNomeAutomacao().equals(consulta)) { //Procura o nome da automação
                    JOptionPane.showMessageDialog(null, listEletrica.get(i));
                }
            }

            for (int i = 0; i < listMecanica.size(); i++) {
                if (listMecanica.get(i).getNomeAutomacao().equals(consulta)) { //Procura o nome da automação
                    JOptionPane.showMessageDialog(null, listMecanica.get(i));
                }
            }

            for (int i = 0; i < listHidraulica.size(); i++) {
                if (listHidraulica.get(i).getNomeAutomacao().equals(consulta)) { //Procura o nome da automação
                    JOptionPane.showMessageDialog(null, listHidraulica.get(i));
                }
            }
        }
    }

    public String[] mensagemTela(String tipoAutomacao) {
        String retorno[] = new String[5];

        //Cadastra o nome da automação
        retorno[0] = JOptionPane.showInputDialog("Informe o nome da Automação: ");

        if (tipoAutomacao.equals("1")) {

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

        } else if (tipoAutomacao.equals("2")) {

            //Cadastra o objetivo da automação.
            retorno[1] = JOptionPane.showInputDialog("Informe o objetivo da automação: \n"
                    + "[E]ntretenimento; \n"
                    + "[L]impeza;\n"
                    + "[A]cessibilidade.");
            
            if (retorno[1].equals("E") || retorno[1].equals("e")) {
                retorno[1] = "Entretenimento";

            } else if (retorno[1].equals("L") || retorno[1].equals("l")) {
                retorno[1] = "Limpeza";

            } else if (retorno[1].equals("A") || retorno[1].equals("a")) {
                retorno[1] = "Acessibilidade";
            }

            //Cadastra se a automação possui relação com automação Elétrica
            retorno[2] = JOptionPane.showInputDialog("Essa automação tem relação com automação elétrica? \n"
                    + "[S]im \n"
                    + "[N]ão");
            
            if (retorno[2].equals("S") || retorno[2].equals("s")) {
                retorno[2] = JOptionPane.showInputDialog("Qual a relação com Automação Elétrica?");
                
            } else if (retorno[2].equals("N") || retorno[2].equals("n")) {
                retorno[2] = "Não";
                
            }

            //Cadastro do código e descrição dos itens necessários para realizar a automatização.
            int size = Integer.parseInt(JOptionPane.showInputDialog("Informe a quantidade de itens necessários:"));
            String codigo = "";
            String descricao = "";
            retorno[3] = "\n";
            for (int i = 0; i < size; i++) {
                codigo = JOptionPane.showInputDialog("Informe o código do " + (i + 1) + "º item: ");
                descricao = JOptionPane.showInputDialog("Informe a descrição do " + (i + 1) + "º item: ");
                retorno[3] = retorno[3] + "Código: " + codigo + " | " + "Descrição: " + descricao + "\n";
            }

        } else if (tipoAutomacao.equals("3")) {

            //Cadastra o volume da automação.
            retorno[1] = JOptionPane.showInputDialog("Informe o volume utilizado: ");

            //Cadastra se a automação possui relação com automação Elétrica
            retorno[2] = JOptionPane.showInputDialog("Essa automação tem relação com automação elétrica? \n"
                    + "[S]im \n"
                    + "[N]ão");
            
            if (retorno[2].equals("S") || retorno[2].equals("s")) {
                retorno[2] = JOptionPane.showInputDialog("Qual a relação com Automação Elétrica?");
                
            } else if (retorno[2].equals("N") || retorno[2].equals("n")) {
                retorno[2] = "Não";
                
            }

            //Cadastro do código e descrição dos itens necessários para realizar a automatização.
            int size = Integer.parseInt(JOptionPane.showInputDialog("Informe a quantidade de itens necessários:"));
            String codigo = "";
            String descricao = "";
            retorno[3] = "\n";
            for (int i = 0; i < size; i++) {
                codigo = JOptionPane.showInputDialog("Informe o código do " + (i + 1) + "º item: ");
                descricao = JOptionPane.showInputDialog("Informe a descrição do " + (i + 1) + "º item: ");
                retorno[3] = retorno[3] + "Código: " + codigo + " | " + "Descrição: " + descricao + "\n";
            }

        }

        return retorno;
    }

}
