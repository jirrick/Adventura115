/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package cz.vse._115.ut1245.xhudj19_hudec;

import static cz.vse._115.ut1245.xhudj19_hudec.Texts.*;



/**
 * Instances of class {@code CommandPrůvodce} představují speciální příkaz,
 * který přepne chování hry do režimu prohlížení vesmírné encyklopedie Stopařův
 * průvodce
 *
 * @author Jiří HUDEC
 * @version 2013.01.15
 */
public class CommandPrůvodce extends ACommand
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
     * Vytvoří příkaz. Jelikož by neměl být volán přímo, registuje se takto
     * dlouhým názvem
     */
    public CommandPrůvodce()
    {
        super("Pomocný příkaz, který by neměl jít přímo spustit",
              "Pomocný příkaz, který by neměl jít přímo spustit");
    }


//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================
//== OTHER NON-PRIVATE INSTANCE METHODS ========================================
    /**
     * Metoda realizující režim procházení encyklopedie
     * V parametru by měla být jen jedna položka - pojem, který chceme v
     * encyklopedii vyhjledat, popř. tečka (.) pro návrat zpět do hry
     *
     * @param arguments Parametry příkazu - vyhledávaný
     * @return Text zprávy vypsané po provedeni příkazu
     */
    @Override
    public String execute(String... arguments)
    {
        ConditionManager condMan = ConditionManager.getInstance();

        // ošetření prázdných vstupů
        if ((arguments == null) || (arguments.length < 1)) {
            return nPRŮVODCE_EMPTY;
        }

        // výpis jednotlivých hesel
        String objectName = arguments[0];
        String result;
        switch (objectName) {
            case "ručník":
                result = nPRŮVODCE_RUČNÍK;
                break;
            case "průvodce":
                result = nPRŮVODCE_PRŮVODCE;
                break;
            case "palec":
                result = nPRŮVODCE_PALEC;
                break;
            case "přijímač":
                result = nPRŮVODCE_PŘIJÍMAČ;
                break;
            case ".":
                condMan.setValue(Condition.HITCHHIKERS_GUIDE_ACTIVE,
                                 Boolean.FALSE);
                result = nPRŮVODCE_STOP + status();
                break;
            default:
                result = nPRŮVODCE_UNKNOWN;
                break;
        }
        return result;
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
//        HelpCommandAno inst = new HelpCommandAno();
//    }
//    /** @param args Command line arguments - not used. */
//    public static void main(String[] args)  {  test();  }
}


