/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package cz.vse._115.ut1245.xhudj19_hudec;

import static cz.vse._115.ut1245.xhudj19_hudec.Texts.PERSON;
import cz.vse.adv_framework.game_txt.INamed;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;



/**
 * Instances of class {@code Person} představují osoby ve hře. Od objektů se
 * liší tím, že mohou mít svůj inventář a pochopitelně nejdou vložit do tašky
 *
 * @author Jiří HUDEC
 * @version 2013.01.15
 */
public class Person implements INamed
{
//== CONSTANT CLASS ATTRIBUTES =================================================
//== VARIABLE CLASS ATTRIBUTES ================================================
    /**
     * Statický odkaz na postavu Arthura (aby nebylo nutné prohledávat dokola
     * všechny prostory, pokud je potřeba provést zásah do jeho inventáře)
     */
    private static Person arthur = null;

    /**
     * Statický odkaz na postavu barmana (aby nebylo nutné prohledávat dokola
     * všechny prostory, pokud je potřeba provést zásah do jeho inventáře)
     */
    private static Person barman = null;

//== STATIC INITIALIZER (CLASS CONSTRUCTOR) ====================================
//== CONSTANT INSTANCE ATTRIBUTES ==============================================
    /**
     * Seznam čísel rozhovorů, který daná osoba umí vyslovit
     */
    private List<Integer> dialogues = new ArrayList<>();

    /**
     * Název osoby.
     */
    private final String name;

    /**
     * Předměty vlastněné danou osobou.
     */
    private final Collection<Thing> objects = new ArrayList<>();

//== VARIABLE INSTANCE ATTRIBUTES ==============================================
//== CLASS GETTERS AND SETTERS =================================================

    /**
     * Vrátí odkaz na postavu Arthura pro potřeby zásahů do hry mimo hráčův
     * vstup
     * <p/>
     * @return odkaz na Arhura
     */
    public static Person getArthur()
    {
        return arthur;
    }


    /**
     * Vrátí odkaz na postavu barmana pro potřeby zásahů do hry mimo hráčův
     * vstup
     * <p/>
     * @return odkaz na barmana
     */
    public static Person getBarman()
    {
        return barman;
    }

//== OTHER NON-PRIVATE CLASS METHODS ===========================================

    /**
     * Po nainicialozování všech prostor najde instance postav Arthur a barman,
     * aby už je nebylo nutné znovu hledat
     */
    public static void findArthurBarman()
    {
        for (Place place : Place.values()) {
            Person temp;

            temp = place.getPerson("Arthur");
            if (temp != null) {
                arthur = temp;
            }

            temp = place.getPerson("Barman");
            if (temp != null) {
                barman = temp;
            }
        }
    }

//##############################################################################
//== CONSTUCTORS AND FACTORY METHODS ===========================================

    /**
     * Vytvoří novou osobu se zadaným názvem
     * Jméno musí být ve tvaru:
     * "delimiter""seznam možných rozhovorů""delimiter""název osoby"
     * (např. @123@Test)
     *
     * @param name Název vytvářené osoby
     */
    public Person(String name)
    {
        String[] input = name.split((String.valueOf(PERSON)));
        if (input.length > 2) {
            // input[0] by mělo být prázdné
            this.name = input[1];
            char[] dialog = input[2].toCharArray();
            for (char d : dialog) {
                if ((d >= '0') && (d <= '9')) {
                    dialogues.add(Character.getNumericValue(d));
                }
            }
        }
        else {
            this.name = name.substring(1);
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
     * Vrátí kolekci možných rozhovorů.
     *
     * @return Kolekce možných rozhovorů
     */
    public Collection<Integer> getDialogues()
    {
        return dialogues;
    }


    /**
     * Vrátí kolekci objektů nacházejících se v inventáři postavy.
     *
     * @return Kolekce objektů nacházejících se v inventáři postavy
     */
    public Collection<Thing> getObjects()
    {
        return objects;
    }


    /**
     * Vloží osobě předmět do inventáře
     *
     * @param thing vkládaný předmět
     */
    public void add(Thing thing)
    {
        objects.add(thing);
    }


    /**
     * Odebere osobě předmět z inventáře
     *
     * @param thing odebíraný předmět
     */
    public void remove(Thing thing)
    {
        objects.remove(thing);
    }


    /**
     * Vybere oředmět z inventáře dané osoby
     *
     * @param requestedObject vybraný předmět
     * @return instance vybraného předmětu
     */
    Thing getObject(String requestedObject)
    {
        Thing result = null;
        for (Thing thingFromBag : objects) {
            if (thingFromBag.getName().equalsIgnoreCase(
                    requestedObject.toLowerCase())) {
                result = thingFromBag;
            }
        }
        return result;
    }

//== OTHER NON-PRIVATE INSTANCE METHODS ========================================
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
//        Person inst = new Person();
//    }
//    /** @param args Command line arguments - not used. */
//    public static void main(String[] args)  {  test();  }
}


