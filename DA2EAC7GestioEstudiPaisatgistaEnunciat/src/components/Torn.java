/*
 * Classe que defineix un torn. Un torn es defineix pel seu codi, nom, hora d'inici
 * i hora d'acabament del torn.
 */
package components;

import java.util.Scanner;

/**
 *
 * @author root
 */
public class Torn {

    private final static Scanner DADES = new Scanner(System.in);
    
    private String codi;
    private String nom;
    private String horaInici;
    private String horaAcabament;

    /*
     TODO CONSTRUCTOR
     Paràmetres: valors per tots els atributs de la classe.
     Accions:
     - Assignar als atributs els valors passats com a paràmetres.
     */

    public Torn(String codi, String nom, String horaInici, String horaAcabament) {
        this.codi = codi;
        this.nom = nom;
        this.horaInici = horaInici;
        this.horaAcabament = horaAcabament;
    }
    

    /*
     TODO Mètodes accessors    
     */

    public String getCodi() {
        return codi;
    }

    public void setCodi(String codi) {
        this.codi = codi;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getHoraInici() {
        return horaInici;
    }

    public void setHoraInici(String horaInici) {
        this.horaInici = horaInici;
    }

    public String getHoraAcabament() {
        return horaAcabament;
    }

    public void setHoraAcabament(String horaAcabament) {
        this.horaAcabament = horaAcabament;
    }
   
    

    /*
     TODO
     Paràmetres: cap
     Accions:
     - Demanar a l'usuari les dades per consola per crear un nou torn. Les dades 
     a demanar són les que passem per paràmetre en el constructor.
     - Per assignar les hores d'inici i acabamanet del torn, heu d'utilitzar el mètode
     escaient d'aquesta classe.
     Retorn: El nou torn creat.
     */
    public static Torn addTorn() {
        System.out.println("\nCreación del turno del jardinero: ");
        
        System.out.println("\nNombre del Jardinero: ");
        String nombre = DADES.nextLine();
        
        System.out.println("\nCodigo del turno: ");
        String codigoTurno = DADES.nextLine();
        
        System.out.println("\nHora inicio del turno: ");
        String inicioTurno = DADES.nextLine();
        
        System.out.println("\nHora fin del turno: ");
        String finTurno = DADES.nextLine();
        
        Torn turno = new Torn(codigoTurno, nombre, inicioTurno, finTurno);
        return turno;
    }

    /*
     TODO
     Paràmetres: cap
     Accions:
     - Demanar a l'usuari que introdueixi les noves dades de l'objecte actual
     i modificar els atributs corresponents d'aquest objecte (Penseu com heu de
     modificar les hores d'inici i d'acabament del torn).
     - Li heu de mostrar a l'usuari els valors dels atributs abans de modificar-los.
     Retorn: cap
     */
    public void updateTorn() {
        System.out.println("\nActualizar turno: ");
        showTorn();
        System.out.println("\nActualizar codigo: ");
        codi = DADES.nextLine();
        System.out.println("\nActualizar nombre del jardinero");
        nom = DADES.nextLine();
        System.out.println("\nActualizar hora de inicio: ");
        horaInici = DADES.nextLine();
        System.out.println("\nActualizar hora de finalización: ");
        horaAcabament = DADES.nextLine();
       
        
    }

    public void showTorn() {
        System.out.println("\nLes dades del torn amb codi " + codi + " són:");
        System.out.println("\nNom: " + nom);
        System.out.println("\nHora d'inici: "+horaInici);
        System.out.println("\nHora d'acabament: "+horaAcabament);
    }

    /*
     TODO
     Paràmetres: cap
     Accions:
     - Demanar a l'usuari les dades per consola per crear les hores d'inici o acabament
     d'un torn.
     - Tant l'hora d'inici com la d'acabament, han de tenir el format "hh:mm", on
     hh és l'hora en format 24 hores i mm els minuts. Perquè es respecti el format,
     primer demanarem l'hora a l'usuari i després els minuts. El mateix mètode és
     el que haurà de crear el format correcte amb les dades introduïdes per l'usuari.
     - Heu de controlar que les hores i minuts introduïts siguin correctes. Si no 
     és així, se li tornaran a demanar a l'usuari fins que introdueixi unes dades correctes.
     Retorn: Les hores d'inici o acabament del torn.
     */
    public static String horesTorn() {
        System.out.println("\nIntroduce la hora de entrada:");
        int horaInici = DADES.nextInt();
        if(!(horaInici > 0 && horaInici <24)){
            System.out.println("\nLa hora introducida no es valida. Vuelve a introducirla: ");
            horaInici = DADES.nextInt();

        }
        System.out.println("\nMinutos de entrada: ");
        int minInici = DADES.nextInt();
        if(!(minInici >= 0 && minInici <60)){
            System.out.println("\nLa hora introducida no es valida. Vuelve a introducirla: ");
            minInici = DADES.nextInt();

        }
        
        System.out.println("\nIntroduce la hora de salida: ");
        int horaAcabament = DADES.nextInt();
        if(!(horaAcabament > 0 && horaAcabament <24)){
            System.out.println("\nLa hora introducida no es valida. Vuelve a introducirla: ");
            horaAcabament = DADES.nextInt();

        }
        System.out.println("\nMinutos de salida");
        int minAcabament = DADES.nextInt();
        if(!(minAcabament >= 0 && minAcabament <60)){
            System.out.println("\nLa hora introducida no es valida. Vuelve a introducirla: ");
            minAcabament = DADES.nextInt();

        }
        
        return "\n Hora inici: " + horaInici + ":" + minInici + ""
                + "\n Hora acabament: " + horaAcabament + ":" + minAcabament;

        
        
    }
}
