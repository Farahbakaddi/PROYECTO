/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecte;

import java.util.Scanner;

/**
 *
 * @author alumne FARAH
 */
public class ProjecteJava {

    //Número de caselles màxim de l'array
    private static final int MAX_PRESIDENT = 10;
    //Array on guardarem la informació dels President
    private static President[] array = new President[MAX_PRESIDENT];
    //Opció triada per l'usuari
    private static int opcio;
    //Scanner general per evitar l'excepció NoSuchElementException 
    
    public static Scanner ent = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        inicialitzarVariables();
        do {
            demanarOpcio();
            tractarOpcio();

        } while (!opcioFinal());
        tractamentFinal();

    }

    public static void tractamentFinal() {
        //Tanco l'scanner general abans de sortir de l'aplicació
        ent.close();
    }

    public static void inicialitzarVariables() {

        //Inicialitzem l'array en nous presidents sense dades
        for (int i = 0; i < array.length; i++) {
            array[i] = new President();
            array[i].setOmplit(false);
        }
    }

    public static void demanarOpcio() {
        Scanner ent = new Scanner(System.in);

        System.out.println("\n\nMenú de l'aplicació.");
        System.out.println("0. Sortir.");
        System.out.println("1. Introduïr President.");
        System.out.println("2. Modificar President.");
        System.out.println("3. Borrar President.");
        System.out.println("4. Llistar Presidents.");
        System.out.println("5. Recuperar President borrat.");

        opcio = ent.skip("[\r\n]*").nextInt();

    }

    public static void tractarOpcio() {

        switch (opcio) {
            case 0:                             //0. Sortir
                System.out.println("Adéu!!");
                break;
            case 1:                             //1. Introduïr President
                introduirPresident();
                break;
            case 2:                             //2. Modificar President
                modificarPresident();
                break;
            case 3:                              //3. Borrar President
                borrarPresident();
                break;
            case 4:                              //4. Llistar Presidents
                llistarPresidents();
                break;
            case 5:                             //5. Recuperar President borrat
                recuperarPresident();
                break;
            default:
                System.out.println("\nOpció incorrecta!!");
        }

    }

    public static boolean opcioFinal() {
        return opcio == 0;
    }

    public static void introduirPresident() {
        Scanner ent = new Scanner(System.in);

        //Primer recorrem l'array fins trobar una casella no omplida o arribar al seu final
        int i;
        for (i = 0; i < array.length && array[i].isOmplit(); i++);
        //Si no hem arribat al final és per que hem trobat una casella buida (no omplida)
        if (i < array.length) {
            System.out.print("\nNom:");
            array[i].setNomPresident(ent.skip("[\r\n]*").nextLine());
            System.out.print("nombre de fills:");
            array[i].setFills(ent.skip("[\r\n]*").nextInt());
            System.out.print("Altura:");
            array[i].setAltura(ent.skip("[\r\n]*").nextDouble());
            System.out.print("Presideix actualment (S/N): ");

            boolean lletra1 = false;
            char c;
            do {
                c = ent.next().toUpperCase().charAt(0);
                if (c == 'N' || c == 'S') {
                    lletra1 = true;
                } else {
                    System.out.println("Has eligido una lletra que no se puede poner  ");
                    System.out.println("Por favor elige la letra 'S' o 'N'");
                }

            } while (!lletra1);
            if (c == 's') {
                array[i].setEstaManant(true);

            }
            if (c == 'n') {

                array[i].setEstaManant(false);

            }
            array[i].setOmplit(true);
        }
    }

    public static void modificarPresident() {
        Scanner ent = new Scanner(System.in);
        //Primer recorrem l'array buscant caselles omplides i preguntant quina volem modificar
        char siNo = 'N';
        int cont = 1, i;
        for (i = 0; i < array.length; i++) {
            if (array[i].isOmplit()) {
                System.out.format("\nPresident %d:\n", cont++);
                System.out.println(array[i].toString());
                do {
                    System.out.println("\nVols modificar el President (S/N) o finalitzar la cerca (F)?:");
                    siNo = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0); //usem toUpperCase() que traduix el text introduït per l'usuari a majúscules, 
                    //per tant només haurem de tractar les lletres majúscules
                } while (siNo != 'S' && siNo != 'N' && siNo != 'F');
            }
            if (siNo == 'F' || siNo == 'S') {
                break;
            }
        }
        //Si l'usuari ha contestat que sí és que ha triat un President per modificar    
        if (siNo == 'S') {

            System.out.println("\nNom: " + array[i].getNomPresident());
            do {
                System.out.println("\nVols modificar el nom?(S/N):");
                siNo = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0);
            } while (siNo != 'S' && siNo != 'N');
            if (siNo == 'S') {
                System.out.print("Nou nom: ");
                array[i].setNomPresident(ent.skip("[\r\n]*").nextLine());
            }
            
            System.out.println("\nnombre de fills: " + array[i].getFills());
            System.out.println("vols modificar els fills?");
            while (siNo != 'S' && siNo != 'N');
            if (siNo == 'S') {
                System.out.print("Quants fills te ara?: ");
                array[i].setFills(ent.skip("[\r\n]*").nextInt());
            }while (siNo != 'S' && siNo != 'N');
            if (siNo == 'N'){
            System.out.println("\nnombre de fills: " + array[i].getFills());}
            
            System.out.println("\nAltura: " + array[i].getAltura());
            do {
                System.out.println("\nVols modificar L'altura?(S/N):");
                siNo = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0);

            } while (siNo != 'S' && siNo != 'N');
            
            if (siNo == 'S') {
                System.out.print("Nova altura actualizada.: ");
                array[i].setAltura(ent.skip("[\r\n]*").nextDouble());
            }
            
            System.out.println((array[i].isEstaManant()?"Sí":"No")+" presideix actualment.");
            do {
                System.out.println("\n Vols canviar-ho?(S/N):");
                siNo = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0);
            } while (siNo != 'S' && siNo != 'N');
            if (siNo == 'S') {
                array[i].setEstaManant(!array[i].isEstaManant());
                
            }

            System.out.println("President  modificat correctament.");

        } else {
            System.out.println("\nNo hi ha President per modificar, o no n'has triat cap per modificar.");
        }
        ent.close();
    }

    public static void borrarPresident() {
        //Variables locals
        President p = null;
        Scanner ent = new Scanner(System.in);
        char siNo = 'N';
        int i;
        for (i = 0; i < array.length && siNo != 'F'; i++) {
            p = array[i];
            if (p.isOmplit()) {
                System.out.println(p);
                do {
                    System.out.println("\nVols borrar el President(S/N) o finalitzar la cerca (F)?:");
                    siNo = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0); //usem toUpperCase() que traduix el text introduït per l'usuari a majúscules, 
                    //per tant només haurem de tractar les lletres majúscules
                } while (siNo != 'S' && siNo != 'N' && siNo != 'F');
            }
            if (siNo == 'S') {
                break;
            }
        }

        if (siNo == 'S') {
            p.setOmplit(false);
            System.out.println("President borrat correctament.");

        } else {
            System.out.println("\nNo s'ha borrat cap President.");
        }
    }

    public static void llistarPresidents() {
        Scanner ent = new Scanner(System.in);

        boolean algun = false;
        char siNo = 'S';
        int i;
        for (i = 0; i < array.length; i++) {
            President p = array[i];
            if (p.isOmplit()) {
                algun = true;
                System.out.println(p);
                do {
                    System.out.println("\nVols vore més President(S/N)?:");
                    siNo = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0); //usem toUpperCase() que traduix el text introduït per l'usuari a majúscules, 
                    //per tant només haurem de tractar les lletres majúscules
                } while (siNo != 'S' && siNo != 'N');
            }
            if (siNo == 'N') {
                break;
            }
        }
        if (!algun) {
            System.out.println("\nNo hi ha President per mostrar, si vols, primer crea'n.");
        }
    }

    public static void recuperarPresident() {
        Scanner ent = new Scanner(System.in);
        //Primer recorrem l'array buscant caselles buides i preguntant quina volem recuperar
        char siNo = 'N';
        int cont = 0, i;
        for (i = 0; i < array.length && siNo != 'S' && siNo != 'F'; i++) {
            if (!array[i].isOmplit()) {
                System.out.format("\nPresident %d:\n", ++cont);
                System.out.println(array[i].toString());
                do {
                    System.out.println("\nVols recuperar el President(S/N) o finalitzar la cerca (F)?:");
                    siNo = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0); //usem toUpperCase() que traduix el text introduït per l'usuari a majúscules, 
                    //per tant només haurem de tractar les lletres majúscules
                } while (siNo != 'S' && siNo != 'N' && siNo != 'F');
            }
            if (siNo == 'S') {
                break;
            }
        }
        //Si l'usuari ha contestat que sí és que ha triat un President per modificar    
        if (siNo == 'S') {
            array[i].setOmplit(true);
            System.out.println("President recuperat correctament.");
        } else if (cont == 0) {
            System.out.println("No hi ha Presidents per recuperat.");
        } else {
            System.out.println("President no recuperat.");
        }

    }
}

