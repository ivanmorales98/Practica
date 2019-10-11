/*
 * Classe que defineix un projecte. Un projecte es defineix per un codi, NIF del
 * del client que ha encarregat el projecte, si està finalitzat o no, el pressupost 
 * i el dissenyador encarregat en desenvolupar-lo. A més, contindrà un vector de 
 * jardiners encarregats d'implementar el projecte.
 */
package principal;

import components.Dissenyador;
import components.Jardiner;
import java.util.Scanner;

/**
 *
 * @author root
 */
public class Projecte {

    private final static Scanner DADES = new Scanner(System.in);

    private int codi;
    private static int properCodi = 1; //El proper codi a assignar
    private String nifClient;
    private boolean finalitzat;
    private double pressupost;
    private Dissenyador dissenyador;
    private Jardiner[] jardiners = new Jardiner[40];
    private int posicioJardiners = 0; //Priemra posició buida del vector jardiners
    
     /*
     TODO
     CONSTRUCTOR
     Paràmetres: valors per tots els atributs de la classe menys el vector, el
     codi i finalitzat.
     Accions:
     - Assignar als atributs corresponents els valors passats com a paràmetres
     - Assignar a l'atribut codi el valor de l'atribut properCodi i actualitzar
     properCodi amb el següent codi a assignar.
     - Quan es crea un projecte aquest mai està finalitzat, per tant, assignarem
     fals a l'atribut finalitzat.
     - Quan es crea un projecte no té cap dissenyador assignat.
     */

    public Projecte(String nifClient, double pressupost) {
        this.nifClient = nifClient;
        this.pressupost = pressupost;
    }

    public int getCodi() {
        return codi;

    }

    public void setCodi(int codi) {
        this.codi = codi;
    }

    public static int getProperCodi() {
        return properCodi;
    }

    public static void setProperCodi(int properCodi) {
        Projecte.properCodi = properCodi;
    }

    public String getNifClient() {
        return nifClient;
    }

    public void setNifClient(String nifClient) {
        this.nifClient = nifClient;
    }

    public boolean isFinalitzat() {
        return finalitzat;
    }

    public void setFinalitzat(boolean finalitzat) {
        this.finalitzat = finalitzat;
    }

    public double getPressupost() {
        return pressupost;
    }

    public void setPressupost(double pressupost) {
        this.pressupost = pressupost;
    }

    public Dissenyador getDissenyador() {
        return dissenyador;
    }

    public void setDissenyador(Dissenyador dissenyador) {
        this.dissenyador = dissenyador;
    }

    public Jardiner[] getJardiners() {
        return jardiners;
    }

    public void setJardiners(Jardiner[] jardiners) {
        this.jardiners = jardiners;
    }

    public int getPosicioJardiners() {
        return posicioJardiners;
    }

    /*
    TODO Mètodes accessors    
     */
    public void setPosicioJardiners(int posicioJardiners) {
        this.posicioJardiners = posicioJardiners;
    }

    /*
    TODO
    Paràmetres: cap
    Accions:
    - Demanar a l'usuari les dades per consola per crear un nou projecte. Les dades
    a demanar són les que passem per paràmetre en el constructor.
    Retorn: El nou projecte creat.
     */
    public static Projecte addProjecte() {
        System.out.println("Añade el DNI del cliente del proyecto");
        String dni = DADES.nextLine();
        System.out.println("Quin es el pressupost del projecte?");
        Double pressupost = DADES.nextDouble();
        
        Projecte projecte = new Projecte(dni, pressupost);
        return projecte;
    }
    
    /*
    TODO
     Paràmetres: cap
     Accions:
     - Demanar a l'usuari que introdueixi les noves dades de l'objecte actual
     i modificar els atributs corresponents d'aquest objecte. En aquest cas
     només es pot modificar el NIF del client, si està finalitzat o no i el pressupost.
     - En el cas de finalitzat o no, li heu de demanar a l'usuari que si el projecte està  
     finalitzat, introdueixi 1 i en cas contrari 0.
     - Li heu de mostrar a l'usuari el valor actual dels atributs de l'objecte actual, 
     abans de modificar-los. En el cas de l'atribut finalitzat, li heu de mostrar
     el missatge: "\nEl projecte està finalitzat", si el projecte s'ha finalitzat,
     i en cas contrari, el missatge "\nEl projecte no està finalitzat".
     Retorn: cap
     */
    public void updateProjecte() {
        try{
            showProjecte();
            System.out.println("Noves dades del projecte. ");
            System.out.println("Actualitzar nif del client: ");
            nifClient = DADES.nextLine();
            System.out.println("El projecte esta finalitzat? Escriu 1 si ho està i 0 en cas contrari. ");
            int respuesta = DADES.nextInt();
            if(respuesta == 1){
                finalitzat = true;
            }else if(respuesta == 0){
                finalitzat = false;
            }else{
                System.out.println("Tienes que escribir 1 o 01");
            }
            System.out.println("Actualitzar pressupost: ");
            pressupost = DADES.nextDouble();
        }catch(Exception e){
            System.out.println(e);
        }
        
        
    }

    /*
     TODO
     Paràmetres: jardiner o jardinera a afegir
     Accions:
     - afegeix al vector jardiners del projecte actual el jardiner o jardinera
     passat/ada per paràmetre.
     - actualitza la posició del vector jardiners.
     Retorn: cap
     */
    public void addJardiner(Jardiner jardiner) {
       jardiners[posicioJardiners] = jardiner;
       posicioJardiners++;
    }

    public void showProjecte() {
        try{
            System.out.println("\nLes dades del projecte amb codi " + codi + " són:");
            System.out.println("\nNIF client: " + nifClient);
            System.out.println("\nPressupost: " + pressupost);
            dissenyador.showDissenyador();

            if(finalitzat){
                System.out.println("\nEl projecte està finalitzat");
            }else{
                System.out.println("\nEl projecte no està finalitzat");
            }

            for (int i = 0; i < posicioJardiners; i++) {
                jardiners[i].showJardiner();
            }
        }catch(Exception e){
            System.out.println("El projecte no te un Dissenyador assignat. Assigna-li un.");
        }
        
    }
    
}
