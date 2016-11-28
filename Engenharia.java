package br.unisul.trabalhoFinal;

import javax.swing.JOptionPane;

public class Engenharia {
    public static void main(String[] args) {
        String opc;
        do{
             opc = JOptionPane.showInputDialog("Informe:\n"
                    + "1- Registrar Automação \n"
                    + "2- Lista automações elétricas \n"
                    + "3- Lista automações mecânicas \n"
                    + "4- Lista automações hidráulicas \n"
                    + "5- Busca a automação por nome \n"
                    + "99- Sair");
            if (!opc.equals("99")) {
                ControleAcoes singleton = ControleAcoes.getInstance();
                singleton.menus(opc);
            }
                
        }while(!opc.equals("99"));
    }
}
