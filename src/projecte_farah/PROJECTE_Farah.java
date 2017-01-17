/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecte_farah;

import java.util.Scanner;

/**
 *
 * @author Èric Garcia Reverter
 */
public class PROJECTE_Farah {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner entNum = new Scanner(System.in);
        Scanner entString = new Scanner(System.in);
        String nomPresident=null;
        int fills=0;
        boolean estaManant=false;
        double altura=0.0;        
        int menu=-1;
        boolean omplit=false;
        
        
        do {
            System.out.println("\nMenú de l'aplicació:");
            System.out.println("0. Sortir.");
            System.out.println("1. Afegir president.");
            System.out.println("2. Borrar president.");
            System.out.println("3. Modificar president.");
            System.out.println("4. Llistar president.");
            
            menu=entNum.nextInt();
            
            switch (menu) {
                case 0:
                    System.out.println("Sortint...");
                    break;
                case 1:
                    if (omplit==false) {
                        System.out.println("\nIntducció de les dades del president.");
                        System.out.format("Nom: ");
                        nomPresident=entString.nextLine();
                        System.out.format("\nNombre de fills:");
                        fills=entNum.nextInt();
                        System.out.format("\nPresideix actualment (S/N): ");
                        char c = entString.next().toUpperCase().charAt(0);
                        if (c=='S') {
                            estaManant=true;
                        }
                        if (c=='N') {
                            estaManant=false;
                        }
                        System.out.format("\nAltura: ");
                        altura=entNum.nextDouble();
                        omplit=true;
                        
                        System.out.println("Dades introduïdes correctament!!");
                    } else {
                        System.out.println("\nLes dades ja han estat introduïdes, "
                                + "si en vols posar més l'hauràs de borrar primer.");
                    }
                    break;
                case 2:
                    if (omplit==false){
                        System.out.println("\nNo hi ha cap president per borrar, si el vols borrar"
                                + "l'hauràs d'introduïr primer.");
                    } else {
                        System.out.println("\nVols veure les dades del president?(S/N)");
                        char c = entString.next().toUpperCase().charAt(0);
                        if (c=='S'){
                            System.out.println("\nDades del president:");
                            System.out.println("Nom: "+nomPresident);
                            System.out.println("Nombre de fills: "+fills);
                            if (estaManant=true) {
                                System.out.println("Presideix actualment: Sí");
                            }
                            if (estaManant=false) {
                                System.out.println("Presideix actualment: No");
                            }
                            System.out.println("Altura: "+altura);
                        }
                        System.out.println("\nVols borrar les dades?(S/N)");
                        char i = entString.next().toUpperCase().charAt(0);

                        if (i=='S'){
                            nomPresident=null;
                            fills=0;
                            estaManant=false;
                            altura=0.0;
                            omplit=false;
                            System.out.println("\nPresident borrat correctament!");                            
                        }
                        break;
                    }
                case 3:
                    System.out.println("\nVols vore el president?(S/N)");
                    char c = entString.next().toUpperCase().charAt(0);
                    
                    if (c=='S'){
                        System.out.println("\nDades del president:");
                        System.out.println("Nom: "+nomPresident);
                        System.out.println("Nombre de fills: "+fills);
                        if (estaManant=true) {
                            System.out.println("Presideix actualment: Sí");
                        }
                        if (estaManant=false) {
                            System.out.println("Presideix actualment: No");
                        }
                        System.out.println("Altura: "+altura);
                    }
                    System.out.println("\nVols modificar el president?(S/N)");
                    char i = entString.next().toUpperCase().charAt(0);

                    if (i=='S'){
                        System.out.println("\nNom: "+nomPresident);
                        System.out.println("\nVols modificar el nom?(S/N)");
                        i = entString.next().toUpperCase().charAt(0);
                        if (i=='S') {
                            System.out.format("\nNou nom:");
                            nomPresident = entString.nextLine();
                        }
                        System.out.println("\nNombre de fills: "+fills);
                        System.out.println("\nVols modificar el nombre de fills?(S/N)");
                        i = entString.next().toUpperCase().charAt(0);
                        if (i=='S') {
                            System.out.format("\nNous fills:");
                            fills = entNum.nextInt();
                        }
                        if (estaManant=true) {
                            System.out.println("Presideix actualment: Sí");
                        }
                        if (estaManant=false) {
                            System.out.println("Presideix actualment: No");
                        }
                        System.out.println("Vols modificar si presideix?(S/N)");
                        i = entString.next().toUpperCase().charAt(0);
                        if (i=='S') {
                            System.out.format("\nPresideix actualment (S/N): ");
                            i = entString.next().toUpperCase().charAt(0);
                            if (c=='S') {
                                estaManant=true;
                            }
                            if (c=='N') {
                                estaManant=false;
                            }
                        }
                        System.out.println("\nAltura: "+altura);
                        System.out.println("\nVols modificar l'altura?(S/N)");
                        i = entString.next().toUpperCase().charAt(0);
                        if (i=='S') {
                            System.out.format("\nNova altura:");
                            altura = entNum.nextInt();
                        }
                        System.out.println("President modificat correctament.");
                    break; 
                    }
                case 4:
                    if (omplit==false){
                        System.out.println("\nNo hi ha cap president per a llistar.");
                    } else {
                        System.out.println("\nDades del president:");
                        System.out.println("Nom: "+nomPresident);
                        System.out.println("Nombre de fills: "+fills);
                        if (estaManant=true) {
                            System.out.println("Presideix actualment: Sí");
                        }
                        if (estaManant=false) {
                            System.out.println("Presideix actualment: No");
                        }
                        System.out.println("Altura: "+altura);
                    }
                    break;
                
            }
        } while (menu!=0);
    }

}