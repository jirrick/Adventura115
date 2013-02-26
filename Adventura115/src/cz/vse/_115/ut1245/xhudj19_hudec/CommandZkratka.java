/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package cz.vse._115.ut1245.xhudj19_hudec;

import static cz.vse._115.ut1245.xhudj19_hudec.Texts.*;



/**
 * Instances of class {@code CommandZkratka} představuje cheatovací třídu pro
 * přeskočení celé hry
 *
 * @author Jiří HUDEC
 * @version 2013.01.17
 */
public class CommandZkratka extends ACommand
{
//== CONSTANT CLASS ATTRIBUTES =================================================
//== VARIABLE CLASS ATTRIBUTES =================================================
//== STATIC INITIALIZER (CLASS CONSTRUCTOR) ====================================
//== CONSTANT INSTANCE ATTRIBUTES ==============================================
//== VARIABLE INSTANCE ATTRIBUTES ==============================================
//== CLASS GETTERS AND SETTERS =================================================
//== OTHER NON-PRIVATE CLASS METHODS ===========================================
//##############################################################################
//== CONSTUCTORS AND FACTORY METHODS ===========================================
    /**
     * Vytvoří příkaz
     */
    public CommandZkratka()
    {
        super(pZKRATKA, "Cheat");
    }


//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================
//== OTHER NON-PRIVATE INSTANCE METHODS ========================================
    /**
     * Metoda realizující přeskočení celé hry a přesun do speciálního prostoru,
     * odkud je možné rychlé vyhrání hry
     *
     * @param arguments Parametry příkazu - název příkazu
     * @return Text zprávy vypsané po provedeni příkazu
     */
    @Override
    public String execute(String... arguments)
    {
        ConditionManager condMan = ConditionManager.getInstance();
        Bag bag = Bag.getInstance();

        /* přesune Arthura z jakéhokolik prostoru do zkratkové místnosti,
         * nastaví mu inventář do požadováného stavu a nastaví příznaky
         * sledování pohybu hráče
         */
        for (Place place : Place.values()) {
            Person arthur;
            arthur = place.getPerson(jARTHUR);
            if (arthur != null) {
                if (arthur.getObject(oRUČNÍK) == null) {
                    arthur.add(new Thing(oRUČNÍK));
                }
                Place.Zkratka.add(arthur);
                place.remove(arthur);
                break;
            }
        }
        condMan.setValue(Condition.ARTHUR_CAN_FOLLOW, Boolean.TRUE);
        condMan.setValue(Condition.ARTHUR_FOLLOWS, Boolean.TRUE);


        /* uvede obsah tašky do požadovaného stavu
         */
        bag.initialize();

        // nastaví prostor na Zkratku
        Place.setCurrentPlace(Place.Zkratka);

        return zZKRATKA + status();
    }

//== PRIVATE AND AUXILIARY CLASS METHODS =======================================
//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================
//== EMBEDDED TYPES AND INNER CLASSES ==========================================
//== TESTING CLASSES AND METHODS ===============================================
//
//    /*************************************************************************
//     * Testing method.
//     */
//    public static void test()
//    {
//        CommandZkratka inst = new CommandZkratka();
//    }
//    /** @param args Command line arguments - not used. */
//    public static void main(String[] args)  {  test();  }
}


