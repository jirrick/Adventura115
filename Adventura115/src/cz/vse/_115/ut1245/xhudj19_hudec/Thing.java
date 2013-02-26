package cz.vse._115.ut1245.xhudj19_hudec;
/* Kodovani UTF-8: Příliš žluťoučký kůň úpěl ďábelské ódy. */

import static cz.vse._115.ut1245.xhudj19_hudec.Texts.HEAVY;
import cz.vse.adv_framework.game_txt.INamed;
import cz.vse.adv_framework.game_txt.IObject;



/**
 * Instance třídy {@code Something} přestavují objekty v místnostech.
 *
 * @author Jiří HUDEC
 * @version 2013.01.15
 */
public class Thing implements IObject, INamed
{
//== CONSTANT CLASS ATTRIBUTES =================================================
//== VARIABLE CLASS ATTRIBUTES =================================================
//== STATIC INITIALIZER (CLASS CONSTRUCTOR) ====================================
//== CONSTANT INSTANCE ATTRIBUTES ==============================================
    /**
     * Název objektu.
     */
    private final String name;

    /**
     * Váha objektu. U nezvednutelných objektů
     * musí být větší než kapacita batohu.
     */
    private final int weight;

//== VARIABLE INSTANCE ATTRIBUTES ==============================================
//== CLASS GETTERS AND SETTERS =================================================
//== OTHER NON-PRIVATE CLASS METHODS ===========================================

//##############################################################################
//== CONSTUCTORS AND FACTORY METHODS ===========================================
    /*
     * Vytvoří nový objekt se zadaným názvem
     * a vahou odvozenou od prvního znaku názvu.
     *
     * @param name Název vytvářeného objektu
     */
    public Thing(String name)
    {
        if (name.charAt(0) == HEAVY) {
            this.name = name.substring(1);
            this.weight = Integer.MAX_VALUE;
        }
        else {
            this.name = name;
            this.weight = 1;
        }
    }


//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================
    /**
     * Vrátí název dané instance.
     *
     * @return Název instance
     */
    @Override
    public String getName()
    {
        return name;
    }


    /**
     * Vrátí váhu objektu, resp. charakteristiku jí odpovídající.
     * Objekty, které není možno zvednout, vrací -1.
     *
     * @return Váha objektu nebo hodnota -1 charakterizující,
     *         že daný objekt není možno zvednou a umístit do batohu.
     */
    @Override
    public int getWeight()
    {
        return weight;
    }


//== OTHER NON-PRIVATE INSTANCE METHODS ========================================
//== PRIVATE AND AUXILIARY CLASS METHODS =======================================
//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================
//== EMBEDDED TYPES AND INNER CLASSES ==========================================
//== TESTING CLASSES AND METHODS ===============================================
//
//    /***************************************************************************
//     * Testovací metoda.
//     */
//    public static void test()
//    {
//        Thing inst = new Thing();
//    }
//    /** @param args Parametry příkazového řádku - nepoužívané. */
//    public static void main( String[] args )  {  test();  }
}


