/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package cz.vse._115.ut1245.xhudj19_hudec;

import static cz.vse._115.ut1245.xhudj19_hudec.Texts.*;
import java.util.Arrays;
import java.util.Date;
import java.util.EnumMap;



/**
 * Instance třídy {@code ConditionManager} udržuje a vyhodnocuje podmínky
 * pro vykonávání akcí ve hře.
 * Hra, jakožto knižní adaptace, vyžaduje dodržení striktního postupu, což
 * vyžaduje velké množství podmínek. Pro zvýšení přehlednosti jsou proto
 * odděleny od hlavní herní logiky.
 *
 * @author Jiří HUDEC
 * @version 2013.01.15
 */
public final class ConditionManager
{
//== CONSTANT CLASS ATTRIBUTES =================================================
    /**
     * Jediná instance manažeru.
     */
    private static final ConditionManager condMan =
                                          new ConditionManager();

//== VARIABLE CLASS ATTRIBUTES =================================================
//== STATIC INITIALIZER (CLASS CONSTRUCTOR) ====================================
//== CONSTANT INSTANCE ATTRIBUTES ==============================================
    /**
     * Délka časovače do zničení země v sekundách
     */
    final static int END_OF_EARTH_TIMER = 120;

//== VARIABLE INSTANCE ATTRIBUTES ==============================================
    /**
     * Pole indikátorů, zda je možná vykonat rozhovor
     */
    private boolean[] dialogue_possible = new boolean[7];

    /**
     * Pole indikátorů, zda už byl rozhovor vykonán
     */
    private boolean[] dialogue_done = new boolean[7];

    /**
     * Mapa udržující hodnotu podmínek (intance třídy Condition)
     */
    private EnumMap<Condition, Boolean> conditions = new EnumMap<>(
            Condition.class);

    /**
     * Indikátor, zda hráč ještě může zadávat příkazy
     */
    private boolean canDoNextMove;

    /**
     * Počet tahů do konce světa
     */
    private int roundsLeft;

    /**
     * Reálný čas, kdy byl spuštěn odpočet konce světa
     */
    private Date timeOfActivation;


    //== CLASS GETTERS AND SETTERS =================================================
//== OTHER NON-PRIVATE CLASS METHODS ===========================================
//##############################################################################
//== CONSTUCTORS AND FACTORY METHODS ===========================================
    /**
     * Vrátí odkaz na jedináčka - jedinou existující instanci třídy.
     *
     * @return Odkaz na jedináčka
     */
    public static ConditionManager getInstance()
    {
        return condMan;
    }


    /**
     * Vytvoří instanci jedináčka.
     */
    private ConditionManager()
    {
        initialize();
    }


//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================
    /**
     * Vrátí počet možných kol, před ukončením hry.
     *
     * @return počet kol do konce hry
     */
    public int getRoundsLeft()
    {
        return roundsLeft;
    }


    /**
     * Vrátí počet sekund, před ukončením hry.
     *
     * @return sekund do konce hry
     */
    public int getTimeLeft()
    {
        return 120 - ((int) Math.abs((new Date().getTime() / 1000) -
                                     (timeOfActivation.getTime() / 1000)));
    }


    /**
     * Indikátor, zda se může vykonat další krok hry.
     *
     * @return Pokud se může vykonat další krok vrátí {@code true},
     *         jinak {@code false}
     */
    public boolean getCanDoNextMove()
    {
        return canDoNextMove;
    }


    /**
     * Vrátí hodnotu požadováné podmínky
     *
     * @return pravdivost požadované podmínky
     */
    public boolean getValue(Condition condition)
    {
        return conditions.get(condition);
    }


    /**
     * Nastaví hodnotu požadováné podmínky
     *
     * @param condition název nastavované podmínky
     * @param value     hodnota nastavované podmínky
     */
    public void setValue(Condition condition, boolean value)
    {
        conditions.put(condition, value);
    }


    /**
     * Může se provést rozhovor?
     *
     * @param dialogue číslo rozhovoru
     * @return pravdivost požadované podmínky
     */
    public boolean isDialoguePossible(int dialogue)
    {
        return dialogue_possible[dialogue];
    }


    /**
     * Rozhovor se provedl
     *
     * @param dialogue číslo rozhovoru
     */
    public void setDialogueDone(int dialogue)
    {
        dialogue_done[dialogue] = true;
    }


//== OTHER NON-PRIVATE INSTANCE METHODS ========================================
    /**
     * Inicializuje manažer podmínek do výchozího stavu
     */
    public void initialize()
    {
        for (Condition condition : Condition.values()) {
            conditions.put(condition, Boolean.FALSE);
        }
        Arrays.fill(dialogue_done, Boolean.FALSE);
        Arrays.fill(dialogue_possible, Boolean.FALSE);
        dialogue_possible[0] = true;
        roundsLeft = 16;
        canDoNextMove = true;
        timeOfActivation = null;
    }


    /**
     * Vyhodnocení podmínek po zadání dalšího příkazu.
     * Výsledek lze získat getterem {@code canDoNextMove()}.
     *
     */
    public void evaluateNextRound()
    {
        evaluateAfterDialogues();
        evaluateCanBuy(Condition.FORD_CAN_BUY_BEERS, oPIVO);
        evaluateDialogueE();
        evaluateCanBuy(Condition.FORD_CAN_BUY_NUTS, oBURÁKY);
        evaluateStartCountdown();
        evaluateStartTimer();
        canDoNextMove = !evaluateEarthDestruction();
    }


//== PRIVATE AND AUXILIARY CLASS METHODS =======================================
//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================
    /**
     * Vyhodnotí podmínky u rozhovorů po jejich provedení.
     */
    private void evaluateAfterDialogues()
    {
        for (int i = 0; i < 6; i++) {
            // rozhovor byl nedávno proveden - jsou nastaveny oba indikátory
            if (dialogue_done[i] && dialogue_possible[i]) {
                // univerzální akce - odemknutá dalšího rozhovoru
                dialogue_possible[i] = false;
                dialogue_possible[i + 1] = true;
                switch (i) {
                    // speciální akce po rozhovoru C
                    case 2:
                        setValue(Condition.ARTHUR_CAN_FOLLOW, Boolean.TRUE);
                        setValue(Condition.ARTHUR_FOLLOWS, Boolean.TRUE);
                        break;
                    // speciální akce po rozhovoru D
                    case 3:
                        setValue(Condition.FORD_CAN_BUY_BEERS, Boolean.TRUE);
                        dialogue_possible[4] = false;
                        break;
                    // speciální akce po rozhovoru E
                    case 4:
                        Person arthur = Person.getArthur();
                        Thing beer = arthur.getObject(oPIVO);
                        arthur.remove(beer);
                        break;
                    // speciální akce po rozhovoru F
                    case 5:
                        setValue(Condition.FORD_CAN_BUY_NUTS, Boolean.TRUE);
                        break;
                }
            }
        }
    }


    /**
     * Vyhodnotí, zda se může spustit rozhovor E.
     */
    private void evaluateDialogueE()
    {
        if ((dialogue_done[3]) &&
            getValue(Condition.FORD_DRANK_BEER) &&
            (Person.getArthur().getObject(oPIVO) != null)) {
            dialogue_possible[4] = true;
        }
    }


    /**
     * Vyhodnotí, zda může Ford kouit piva / buráky. Pokud ano, tak barman si
     * schová peníze a přidá požadované přesměty do inventáře
     *
     * @param cond Vyhodnocovaná podmínka
     * @param name Nakupovaný předmět
     */
    private void evaluateCanBuy(Condition cond, String name)
    {
        if (getValue(cond) &&
            (Person.getBarman().getObject(oPĚTILIBROVKA) != null)) {
            Person barman = Person.getBarman();
            Thing money = barman.getObject(oPĚTILIBROVKA);
            barman.remove(money);
            barman.add(new Thing(name));
            //piva se musejí přidat dvě
            if (name.equalsIgnoreCase(oPIVO)) {
                barman.add(new Thing(name));
            }
            condMan.setValue(cond, Boolean.FALSE);
        }
    }


    /**
     * Vyhodnotí, zda se spustí odpočet kol do konce hry.
     */
    private void evaluateStartCountdown()
    {
        if ((dialogue_done[5]) &&
            !getValue(Condition.TURN_COUNTDOWN_RUNNING) &&
            (Bag.getInstance().getObject(oBURÁKY) != null)) {
            setValue(Condition.TURN_COUNTDOWN_RUNNING, Boolean.TRUE);
        }
    }


    /**
     * Vyhodnotí, zda se spustí odpočet času do konce hry.
     */
    private void evaluateStartTimer()
    {
        if (getValue(Condition.TURN_COUNTDOWN_RUNNING) &&
            (Place.getCurrentPlace().getName().equalsIgnoreCase(mLOUKA))) {
            setValue(Condition.TIMER_RUNNING, Boolean.TRUE);
            timeOfActivation = new Date();
        }
    }


    /**
     * Vyhodnotí, zda země byla zničena.
     *
     * @return Vrací {@code true} pokud země byla zničena,
     *         {@code false} pokud ještě ne.
     */
    private boolean evaluateEarthDestruction()
    {
        // konec země počítadlem příkazů
        if (getValue(Condition.TURN_COUNTDOWN_RUNNING)) {
            if (roundsLeft >= 1) {
                roundsLeft--;
            }
            else {
                return true;
            }
        }
        //konec země časovačem
        if (getValue(Condition.TIMER_RUNNING)) {
            // počet sekund od zapnutí časovače
            int secondsDiff = (int) Math.
                    abs((new Date().getTime() / 1000) -
                        (timeOfActivation.getTime() / 1000));
            if (secondsDiff > END_OF_EARTH_TIMER) {
                return true; //země byla zničena
            }
        }
        return false;
    }


}


