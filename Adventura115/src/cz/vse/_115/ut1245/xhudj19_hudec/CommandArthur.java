/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package cz.vse._115.ut1245.xhudj19_hudec;

import static cz.vse._115.ut1245.xhudj19_hudec.Texts.*;



/**
 * Instances of class {@code CommandArthur} představuje třídu umožňující hráči
 * (Fordovi Prefectovi) ovládat postavu Arthura
 *
 * @author Jiří HUDEC
 * @version 2013.01.15
 */
public class CommandArthur extends ACommand
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
    public CommandArthur()
    {
        super("Arthur", "Příkaz pro jednoduché ovládání Arthura");
    }


//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================
//== OTHER NON-PRIVATE INSTANCE METHODS ========================================
    /**
     * Metoda realizující ovládání postavy Arthura Denta
     * V parametru by měly být dvě položky: název příkazu (arthur)
     * a pokyn pro něj (stůj, následuj, inventář).
     *
     * @param arguments Parametry příkazu - název příkazu a povelu
     * @return Text zprávy vypsané po provedeni příkazu
     */
    @Override
    public String execute(String... arguments)
    {
        if (arguments.length < 2) {
            return nARTH_NENÍ_PŘÍIKAZ + status();
        }

        ConditionManager condMan = ConditionManager.getInstance();
        String command = arguments[1];

        //Najití arthura v prostoru
        Person arthur = Place.getCurrentPlace().getPerson(jARTHUR);
        if (arthur == null) {
            return nARTHUR_NELZE + status();
        }

        //Povely, které umí arthur vykonat
        String result;
        if (condMan.getValue(Condition.ARTHUR_CAN_FOLLOW)) {
            switch (command) {
                case "inventář":
                    result = nARTH_INVENT +
                             toCommaSeparatedString(arthur.getObjects());
                    break;
                case "následuj":
                    result = nARTHUR_SLEDUJE;
                    condMan.setValue(Condition.ARTHUR_FOLLOWS,
                                     Boolean.TRUE);
                    break;
                case "stůj":
                    result = nARTHUR_STŮJ;
                    condMan.setValue(Condition.ARTHUR_FOLLOWS,
                                     Boolean.FALSE);
                    break;
                default:
                    result = nART_NEZNÁM_PŘÍIKAZ;
                    break;
            }
        }
        else {
            result = nARTHUR_NEPOSLOUCHÁ;
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
//        CommandArthur inst = new CommandArthur();
//    }
//    /** @param args Command line arguments - not used. */
//    public static void main(String[] args)  {  test();  }
}


