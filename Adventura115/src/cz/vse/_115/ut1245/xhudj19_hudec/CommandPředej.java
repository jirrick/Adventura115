/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy.
 */
package cz.vse._115.ut1245.xhudj19_hudec;

import static cz.vse._115.ut1245.xhudj19_hudec.Texts.*;



/**
 * Instance třídy {@code CommandPolož} představují příkaz pro předávání předmětů
 * z tašky do inventáře ostatních osob
 *
 * @author Jiří HUDEC
 * @version 2013.01.15
 */
public class CommandPředej extends ACommand
{
    //== KONSTANTNÍ ATRIBUTY TŘÍDY =============================================
    //== PROMĚNNÉ ATRIBUTY TŘÍDY ===============================================
    //== STATICKÝ INICIALIZAČNÍ BLOK - STATICKÝ KONSTRUKTOR ====================
    //== KONSTANTNÍ ATRIBUTY INSTANCÍ ==========================================
    //== PROMĚNNÉ ATRIBUTY INSTANCÍ ============================================
    //== PŘÍSTUPOVÉ METODY VLASTNOSTÍ TŘÍDY ====================================
    //== OSTATNÍ NESOUKROMÉ METODY TŘÍDY =======================================
    //##########################################################################
    //== KONSTRUKTORY A TOVÁRNÍ METODY =========================================
    /**
     * Vytvoří příkaz
     */
    public CommandPředej()
    {
        super("Předej", "Příkaz, který předá věc z tašky určené postavě.");
    }


    //== ABSTRAKTNÍ METODY =====================================================
    //== PŘÍSTUPOVÉ METODY VLASTNOSTÍ INSTANCÍ =================================
    //== OSTATNÍ NESOUKROMÉ METODY INSTANCÍ ====================================
    /**
     * Metoda vykonávající předávání předmětů z tašky hráče do inventáře osob
     * V parametru by měly být tři položky: název příkazu (předej), předávaný
     * předmět a jméno osoby, které předmět dáváme.
     *
     * @param arguments Parametry příkazu - název příkazu, předmětu a název
     *                  osoby
     * @return Text zprávy vypsané po provedeni příkazu
     */
    @Override
    public String execute(String... arguments)
    {
        if (arguments.length < 3) {
            return nNENÍ_PŘEDMĚT_OSOBA + status();
        }

        String thingName = arguments[1];
        String personName = arguments[2];
        Bag bag = Bag.getInstance();
        Place currentPlace = Place.getCurrentPlace();
        Thing thing = bag.getObject(thingName);
        Person person = currentPlace.getPerson(personName);

        // předání objektu, pokud předmět opravdu máme a osoba je v prostoru
        if ((thing != null) && (person != null)) {
            person.add(thing);
            bag.remove(thing);
            return String.format(
                    nPŘEDAT_FORMÁT, person.getName(), thing.getName()) +
                   status();
        }
        if (thing == null) {
            return nNEMÁTE_PŘEDMĚT + status();
        }
        if (person == null) {
            return nOSOBA_NENÍ + status();
        }
        return zZANP + status();
    }


//== SOUKROMÉ A POMOCNÉ METODY TŘÍDY =======================================
//== SOUKROMÉ A POMOCNÉ METODY INSTANCÍ ====================================
//== INTERNÍ DATOVÉ TYPY ===================================================
//== TESTOVACÍ METODY A TŘÍDY ==============================================
//
//     /********************************************************************
//      * Testovací metoda.
//      */
//     public static void test()
//     {
//         CommandPolož instance = new CommandPolož();
//     }
//     /** @param args Parametry příkazového řádku - nepoužívané. */
//     public static void main(String[] args)  {  test();  }
}


