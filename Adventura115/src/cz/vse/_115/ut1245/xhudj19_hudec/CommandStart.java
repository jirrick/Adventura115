/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package cz.vse._115.ut1245.xhudj19_hudec;

import static cz.vse._115.ut1245.xhudj19_hudec.Texts.zPRÁZDNÝ_PŘÍKAZ;
import static cz.vse._115.ut1245.xhudj19_hudec.Texts.zUVÍTÁNÍ;



/**
 * Instance třídy {@code CommandStart} realizuje reakci aplikace
 * na startovací příkaz, který spouští hru.
 * Tento příkaz je možné zadat pouze tehdy, není-li hra již spuštěna.
 * Po ukončení hry jej lze ale zadat znovu a tak hru znovu odstartovat.
 *
 * @author Jiří HUDEC
 * @version 2013.01.15
 */
public class CommandStart extends ACommand
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
    public CommandStart()
    {
        super("", "Příkaz startující aplikaci");
    }


//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================
//== OTHER NON-PRIVATE INSTANCE METHODS ========================================
    /**
     * Metoda realizující reakci hry na zadání startovacího příkaz.
     *
     * @param arguments Parametry příkazu, na nich nezáleží
     * @return Text zprávy vypsané po provedeni příkazu
     */
    @Override
    public String execute(String... arguments)
    {
        Game game = Game.getInstance();
        if (game.isAlive()) {
            return zPRÁZDNÝ_PŘÍKAZ + status();
        }

        //Inicializuje příkazy, prostory i tašku
        ACommand.initializeCommands();
        Place.initializePlaces();
        Bag.getInstance().initialize();
        ConditionManager.getInstance().initialize();
        Game.getInstance().setAlive(true);
        Person.findArthurBarman();
        return zUVÍTÁNÍ + status();
    }


//== PRIVATE AND AUXILIARY CLASS METHODS =======================================
//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================
//== EMBEDDED TYPES AND INNER CLASSES ==========================================
//== TESTING CLASSES AND METHODS ===============================================
//
//    /*************************************************************************
//     * Testovací metoda.
//     */
//    public static void test()
//    {
//        ACommand inst = new ACommand();
//    }
//    /** @param args Parametry příkazového řádku - nepoužívané. */
//    public static void main(String[] args)  {  test();  }
}


