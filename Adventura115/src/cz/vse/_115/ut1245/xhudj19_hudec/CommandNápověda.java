/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package cz.vse._115.ut1245.xhudj19_hudec;

import static cz.vse._115.ut1245.xhudj19_hudec.Texts.zNÁPOVĚDA;



/**
 * Instances of class {@code CommandNápověda} představuje třídu obsluhující
 * zobrazení nápovědy
 *
 * @author Jiří HUDEC
 * @version 2013.01.15
 */
public class CommandNápověda extends ACommand
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
    public CommandNápověda()
    {
        super("?", "Příkaz zobrazující nápovědu");
    }


//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================
//== OTHER NON-PRIVATE INSTANCE METHODS ========================================
    /**
     * Metoda realizující nápovědu. Parametry nepoužívá.
     *
     * @param arguments nepoužívané parametry
     * @return Text zprávy vypsané po provedeni příkazu
     */
    @Override
    public String execute(String... arguments)
    {
        return zNÁPOVĚDA + status();
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
//        CommandNápověda inst = new CommandNápověda();
//    }
//    /** @param args Command line arguments - not used. */
//    public static void main(String[] args)  {  test();  }
}


