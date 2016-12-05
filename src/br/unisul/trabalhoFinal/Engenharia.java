package br.unisul.trabalhoFinal;

import javax.swing.JOptionPane;

public class Engenharia {
    public static void main(String[] args) {
        String opc;
        do{
             opc = JOptionPane.showInputDialog("Informe:\n"
                    + "1- Registrar Automação \n"
                    + "2- Lista automações\n"
                    + "3- Busca a automação por nome \n"
                    + "99- Sair");
            if (!opc.equals("99")) {
                ControleAcoes singleton = ControleAcoes.getInstance();
                singleton.menus(opc);
            }
                
        }while(!opc.equals("99"));
    }
}
