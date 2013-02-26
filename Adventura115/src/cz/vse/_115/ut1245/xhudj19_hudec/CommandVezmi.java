/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy.
 */
package cz.vse._115.ut1245.xhudj19_hudec;

import static cz.vse._115.ut1245.xhudj19_hudec.Texts.*;



/**
 * Instance třídy {@code CommandVezmi} představují příkaz pro převzetí předmětu
 * z inventáře jiné osoby a přenesení do hráčovy tašky
 *
 * @author Jiří HUDEC
 * @version 2013.01.15
 */
public class CommandVezmi extends ACommand
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
    public CommandVezmi()
    {
        super("Vezmi", "Příkaz, který vezme věc od postavy a uloží do tašky.");
    }


    //== ABSTRAKTNÍ METODY =====================================================
    //== PŘÍSTUPOVÉ METODY VLASTNOSTÍ INSTANCÍ =================================
    //== OSTATNÍ NESOUKROMÉ METODY INSTANCÍ ====================================
    /**
     * Metoda vykonávající předávání předmětů z inventáře osoby do hráčovy tašky
     * V parametru by měly být tři položky: název příkazu (předej), předávaný
     * předmět a jméno osoby, od které předmět bereme.
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

        // osoba v prostoru není
        Person person = currentPlace.getPerson(personName);
        if (person == null) {
            return nOSOBA_NENÍ + status();
        }

        // osoba požadovanou věc nemá
        Thing thing = person.getObject(thingName);
        if (thing == null) {
            return nOSOBA_NEMÁ_PŘEDMĚT + status();
        }

        // je v tašce místo?
        if (bag.add(thing)) {
            person.remove(thing);
            return String.format(
                    nVZÍT_FORMÁT, person.getName(), thing.getName()) +
                   status();
        }
        else {
            return zBATOH_PLNÝ + status();
        }
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
//         CommandVezmi instance = new CommandVezmi();
//     }
//     /** @param args Parametry příkazového řádku - nepoužívané. */
//     public static void main(String[] args)  {  test();  }

}


