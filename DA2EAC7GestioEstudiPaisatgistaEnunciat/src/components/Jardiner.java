/*
 * Classe que defineix un jardiner o jardinera. Un jardiner o jardinera es defineix 
 * pel seu NIF, nom, torn de feina i estat, és a dir, actiu si està treballant o no actiu si està 
 * de baixa o vacances.
 */
package components;

import java.util.Scanner;

/**
 *
 * @author root
 */
public class Jardiner {
    
    private final static Scanner DADES = new Scanner(System.in);
    
    private String nif;
    private String nom;
    private Torn torn;
    private boolean actiu;

    /*
     TODO CONSTRUCTOR
     Paràmetres: valors per tots els atributs de la classe menys l'atribut actiu
     Accions:
     - Assignar als atributs els valors passats com a paràmetres, menys a actiu,
     ja que quan es crea un nou jardiner o jardinera, el seu estat sempre és
     actiu, per tant li assignem verdader. I torn, ja que quan es crea un nou
     jardiner o jardinera aquest encara no té assignat cap torn, per tant li assignarem
     null.
     */

    public Jardiner(String nif, String nom) {
        this.nif = nif;
        this.nom = nom;
        this.actiu = true;
    }
    
    /*
    TODO Mètodes accessors    
     */
    
    public String getNif() {
        return nif;

    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Torn getTorn() {
        return torn;
    }

    public void setTorn(Torn torn) {
        this.torn = torn;
    }

    public boolean isActiu() {
        return actiu;
    }

    public void setActiu(boolean actiu) {
        this.actiu = actiu;
    }

    /*
    TODO
    Paràmetres: cap
    Accions:
    - Demanar a l'usuari les dades per consola per crear un nou jardiner o nova
    jardinera. Les dades a demanar són les que passem per paràmetre en el constructor.
    - També heu de tenir en compte que tant el nom pot ser una frase, per exemple,
    Francesc Xavier.
    Retorn: El nou jardiner o nova jardinera creat/da.
     */
    public static Jardiner addJardiner() {
        System.out.println("\nAñade el nombre del Jardinero: ");
        String nombre = DADES.nextLine();
        
        System.out.println("\nAñade el dni: ");
        String dni = DADES.nextLine();
        
        //System.out.println("\nEsta el usuario activo? Escribe 1 si lo esta y 0 en caso contrario.");
        //boolean activo = DADES.nextBoolean();
        
        Jardiner jardiner = new Jardiner(dni, nombre);
        
        System.out.println("El nou jardiner o nova jardinera creat/da");
        return jardiner;
    }

    /*
     TODO
     Paràmetres: cap
     Accions:
     - Demanar a l'usuari que introdueixi les noves dades de l'objecte actual
     i modificar els atributs corresponents d'aquest objecte, menys de l'atribut torn.
     - En el cas de l'atribut actiu, li heu de demanar que si el jardiner o jardinera està en 
     actiu introdueixi 1 i en cas contrari 0.
     - Li heu de mostrar a l'usuari els valors dels atributs abans de modificar-los.
     En el cas de l'atribut actiu, li heu de mostrar el missatge: "\nEl jardiner o jardinera
     està en actiu", si el jardiner o jardinera està en actiu, i en cas contrari, el missatge 
     "\nEl jardiner o jardinera no està en actiu".
     Retorn: cap
     */
    public void updateJardiner() {
        try{
            System.out.println("\nActualizar jardinero.");
            showJardiner();
            System.out.println("\nNombre nuevo jardinero/a: ");
            nom = DADES.nextLine();
            System.out.println("\nDNI nuevo jardinero/a: ");
            nif = DADES.nextLine();
        }catch(Exception e){
            System.out.println("Los datos introducidos no son correctos, revisalos.");
        }

    }

    public void showJardiner() {
        try{
            System.out.println("\nLes dades del jardiner o jardinera amb nif " + nif + " són:");
            System.out.println("\nNom: " + nom);
            torn.showTorn();
            System.out.println("\nL'estat és: ");


            if(actiu){
                System.out.println("\nEl jardiner o jardinera està en actiu");
            }else{
                System.out.println("\nEl jardiner o jardinera no està en actiu");
            }
        }catch(Exception e){
            System.out.println("El jardiner o jardinera no té assignat un torn. Si us plau, assigna-li un.1"
                    + "");
        }
        
    }
}
