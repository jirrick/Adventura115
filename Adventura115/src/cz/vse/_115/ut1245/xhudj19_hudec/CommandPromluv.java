package cz.vse._115.ut1245.xhudj19_hudec;

/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy.
 */
import static cz.vse._115.ut1245.xhudj19_hudec.Texts.*;



/**
 * Instance třídy {@code CommandPromluv} představují třídu vykonávající
 * rozhovory s postavami ve hře. Předem připravený rozhovor se provede, pouze
 * pokud jsou splněny podmínky pro jeho vykonání. Osoby se tedy odmítají bavit,
 * dokud se neprovede činnost spínající rozhovor
 *
 * @author Jiří HUDEC
 * @version 2013.01.15
 */
public class CommandPromluv extends ACommand
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
     * Vytvoří příkaz pro vykonávání rozhovorů.
     */
    public CommandPromluv()
    {
        super("promluv",
              "Pokusí se o rozhovor s danou postavou");
    }


    //== ABSTRAKTNÍ METODY =====================================================
    //== PŘÍSTUPOVÉ METODY VLASTNOSTÍ INSTANCÍ =================================
    //== OSTATNÍ NESOUKROMÉ METODY INSTANCÍ ====================================
    /**
     * Metoda vykonávající rozhovory ve hře
     * V parametru by měly být dvě položky: název příkazu (promluv)
     * a jméno osoby, se kterou se má mluvit.
     *
     * @param arguments Parametry příkazu - název příkazu a název osoby
     * @return Text zprávy vypsané po provedeni příkazu
     */
    @Override
    public String execute(String... arguments)
    {
        if (arguments.length < 2) {
            return nROZHOVOR_NIKDO + status();
        }

        ConditionManager condMan = ConditionManager.getInstance();
        Place currentPlace = Place.getCurrentPlace();
        Person person = currentPlace.getPerson(arguments[1]);

        // požadovaná osoba není v prostoru
        if (person == null) {
            return nROZHOVOR_NENÍ + status();
        }

        // projde všechny možné rozhovory osoby a provede ten vykonatelný
        for (int dialogue : person.getDialogues()) {
            if (condMan.isDialoguePossible(dialogue)) {
                condMan.setDialogueDone(dialogue);
                return nROZHOVOR_START + person.getName() + rozhovory[dialogue] +
                       status();
            }
        }

        return nROZHOVOR_NEJDE + status();
    }


//    == SOUKROMÉ A POMOCNÉ METODY TŘÍDY =======================================
//    == SOUKROMÉ A POMOCNÉ METODY INSTANCÍ ====================================
//    == INTERNÍ DATOVÉ TYPY ===================================================
//    == TESTOVACÍ METODY A TŘÍDY ==============================================
//
//         /********************************************************************
//          * Testovací metoda.
//          */
//         public static void test()
//         {
//             CommandPromluv instance = new CommandPromluv();
//         }
//         /** @param args Parametry příkazového řádku - nepoužívané. */
//         public static void main(String[] args)  {  test();  }
}


