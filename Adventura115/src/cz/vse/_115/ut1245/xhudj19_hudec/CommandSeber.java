/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package cz.vse._115.ut1245.xhudj19_hudec;

import static cz.vse._115.ut1245.xhudj19_hudec.Texts.*;



/**
 * Instance třídy {@code CommandSeber} představují příkazy
 * realizující standardní přesun objektu z prostoru do tašky.
 *
 * @author Jiří HUDEC
 * @version 2013.01.15
 */
public class CommandSeber extends ACommand
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
    public CommandSeber()
    {
        super("Seber", "Příkaz pro zvednutí předmětu z prostoru");
    }


//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================
//== OTHER NON-PRIVATE INSTANCE METHODS ========================================
    /**
     * Metoda realizující reakci hry na zadání příkazu
     * pro standardní přesun objektu z prostoru do batohu.
     * V parametru by měly být dvě položky: název příkazu
     * a název přesouvaného objektu.
     *
     * @param arguments Parametry příkazu - název příkazu a přesouvaného objektu
     * @return Text zprávy vypsané po provedeni příkazu
     */
    @Override
    public String execute(String... arguments)
    {
        if (arguments.length < 2) {
            return zPŘEDMĚT_NEZADAN + status();
        }
        String thingName = arguments[1];
        Place currentPlace = Place.getCurrentPlace();
        Thing thing = currentPlace.getObject(thingName);

        // předmět v prostoru není
        if (thing == null) {
            return zNENÍ_PŘEDMĚT + thingName + status();
        }

        // předmět je moc těžký
        if (thing.getWeight() > 1) {
            return zTĚŽKÝ_PŘEDMĚT + thing.getName() + status();
        }

        // je v tašce místo?
        if (Bag.getInstance().add(thing)) {
            currentPlace.remove(thing);
            return zZVEDNUTO + thing.getName() + status();
        }
        else {
            return zBATOH_PLNÝ + thing.getName() + status();
        }
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
//        CommandSeber inst = new CommandSeber();
//    }
//    /** @param args Command line arguments - not used. */
//    public static void main(String[] args)  {  test();  }
}


