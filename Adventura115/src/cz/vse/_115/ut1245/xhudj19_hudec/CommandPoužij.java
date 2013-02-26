/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package cz.vse._115.ut1245.xhudj19_hudec;

import static cz.vse._115.ut1245.xhudj19_hudec.Texts.*;



/**
 * Instances of class {@code CommandPouzij} představuje třídu umožňující hráči
 * použít vybrané předměty z jeho tašky, nepočítá s použití předmětů v prostoru.
 *
 * @author Jiří HUDEC
 * @version 2013.01.15
 */
public class CommandPoužij extends ACommand
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
    public CommandPoužij()
    {
        super("Použij", "Příkaz, který použije vybranou věc");

    }


//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================
//== OTHER NON-PRIVATE INSTANCE METHODS ========================================
    /**
     * Metoda realizující používání objektů z tašky
     * V parametru by měly být dvě položky: název příkazu (použij)
     * a předmět k použití.
     *
     * @param arguments Parametry příkazu - název příkazu a název předmětu
     * @return Text zprávy vypsané po provedeni příkazu
     */
    @Override
    public String execute(String... arguments)
    {
        ConditionManager condMan = ConditionManager.getInstance();
        if (arguments.length < 2) {
            return zPŘEDMĚT_NEZADAN + status();
        }

        String objectName = arguments[1];
        Bag bag = Bag.getInstance();
        Place currentPlace = Place.getCurrentPlace();
        Thing thing = bag.getObject(objectName);
        String result;

        // jednotlivé předměty umožňující použití
        if (thing == null) {
            result = zNENÍ_V_BATOHU;
        }
        else {
            result = nNELZE_POUŽÍT;
            switch (objectName) {
                case "průvodce":
                    condMan.setValue(
                            Condition.HITCHHIKERS_GUIDE_ACTIVE, Boolean.TRUE);
                    result = nPRŮVODCE_START;
                    break;
                case "pivo":
                    if (condMan.getValue(Condition.FORD_DRANK_BEER)) {
                        result = nPOUŽIJ_PIVO_NEJDE;
                    }
                    else {
                        result = nPOUŽIJ_PIVO;
                        bag.remove(thing);
                        condMan.setValue(
                                Condition.FORD_DRANK_BEER, Boolean.TRUE);
                    }
                    break;
                case "přijímač":
                    result = nPŘIJÍMAČ;
                    break;
                case "scénář":
                    result = nSCÉNÁŘ;
                    break;
                case "palec":
                    if (condMan.getValue(Condition.TIMER_RUNNING)) {
                        result = nPALEC;
                        currentPlace.getNeighbors().add(Place.Vogonská_loď);
                    }
                    break;
                default:
                    break;
            }
        }
        return result + status();
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
//        CommandPouzij inst = new CommandPouzij();
//    }
//    /** @param args Command line arguments - not used. */
//    public static void main(String[] args)  {  test();  }

}


