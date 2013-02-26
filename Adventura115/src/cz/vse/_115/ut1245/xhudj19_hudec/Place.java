package cz.vse._115.ut1245.xhudj19_hudec;
/* Kodovani UTF-8: Příliš žluťoučký kůň úpěl ďábelské ódy. */

import static cz.vse._115.ut1245.xhudj19_hudec.Texts.*;
import cz.vse.adv_framework.game_txt.IPlace;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.EnumMap;
import java.util.List;



/**
 * Instance třídy {@code Place} představují prostory ve hře.
 * Dosažení prostoru si můžeme představovat jako částečný cíl,
 * kterého se hráč ve hře snaží dosáhnout.
 *
 * @author Jiří HUDEC
 * @version 2013.01.15
 */
public enum Place implements IPlace
{
    Louka(
    "Louka nedaleko od Arturova domu, dnes mimořádně okupovaná\ntěžkou" +
    "stavební technikou.",
    new String[] {mULICE},
    HEAVY + oSTROM, HEAVY + oNÁKLAĎÁK, HEAVY + oBULDOZER, oKVĚTINA, oKÁMEN),
    Vogonská_loď("Vogonská těžební loď - vaše zkáza a zároveň záchrana.",
                 new String[] {}),
    Ulice("Zcela zapomenutá ulice zajímavá snad jen tím, zde bydlí Arthur.",
          new String[] {mHOSPODA, mZAHRADA, mLOUKA},
          HEAVY + oZNAČKA, oPATNÍK, HEAVY + oAUTO),
    Hospoda("Hospoda U Koně a podkoního. Točí zde pivo a prodávají buráky.",
            new String[] {mULICE},
            oŽIDLE, oSKLENICE, PERSON + jBARMAN + PERSON + "35"),
    Zahrada(
    "Zahrada u Arhturova domu, toho času okupovaná stavební technikou\n" +
    "snažící se mu ten dům zbourat.",
    new String[] {mULICE, mDŮM},
    HEAVY + oBULDOZER, HEAVY + oBLÁTO, oKVĚTINA, PERSON + jARTHUR + PERSON +
                                                 "024",
    PERSON + jPROSSER + PERSON + "1"),
    Dům("Arthurův dům, už tři čtvrtě roku naplánován k demolici.",
        new String[] {mZAHRADA},
        oRUČNÍK, oPANTOFLE, oKARTÁČEK, oKONVICE, oPĚTILIBROVKA, oHRNEK, oTALÍŘ,
        oSKLENICE, HEAVY + oLEDNICE),
    Zkratka("Zkratka, ze které je možno okamžitě vyhrát hru.",
        new String[] {mVOGONI});

//== CONSTANT CLASS ATTRIBUTES =================================================
    /**
     * Aktuální místnost, tj. místnost, v níž se hráč právě nachází.
     */
    private static Place currentPlace;

    //Maps
    /**
     * Počáteční sousedé jednotlivých místností.
     */
    private static final EnumMap<Place, List<Place>> initialNeighbors =
                                                     new EnumMap<>(Place.class);

    /**
     * Počáteční objekty umístěné v místnostech.
     */
    private static final EnumMap<Place, List<Thing>> initialObjects =
                                                     new EnumMap<>(Place.class);

    /**
     * Počáteční osoby umístěné v místnostech.
     */
    private static final EnumMap<Place, List<Person>> initialPersons =
                                                      new EnumMap<>(Place.class);

    //    //2D arrays
//    /** Počáteční sousedé jednotlivých místností. */
//    private static final Room[][] initialNeighbors =
//                                  new Room[values().length][];
//
//    /** Počáteční objekty umístěné v místnostech. */
//    private static final Thing[][] initialObjects =
//                                   new Thing[values().length][];

//== STATIC INITIALIZER (CLASS CONSTRUCTOR) ====================================
    /**
     * Statický konstruktor připraví statické atributy,
     * které nemohly být naplněny při konstrukci instancí,
     * protože v době vytváření instancí tyto atributy ještě neexistovaly.
     */
    static {
        initializeIntoMaps();
    }


//== CONSTANT INSTANCE ATTRIBUTES ==============================================
    /**
     * Popis prostoru.
     */
    private final String description;

    /**
     * Aktuální objekty v prostoru.
     */
    private final Collection<Thing> objects = new ArrayList<>();

    /**
     * Aktuální osoby v prostoru.
     */
    private final Collection<Person> persons = new ArrayList<>();

    /**
     * Aktuální sousedé prostoru.
     */
    private final Collection<Place> neighbors = new ArrayList<>();

//== VARIABLE INSTANCE ATTRIBUTES ==============================================
    /**
     * Názvy objektů v prostoru na počátku hry.
     */
    private String[] objectNames;

    /**
     * Názvy sousedů prostoru na počátku hry.
     */
    private String[] neighborNames;

//== CLASS GETTERS AND SETTERS =================================================
//== OTHER NON-PRIVATE CLASS METHODS ===========================================

    /**
     * Inicializuje stav všech prostorů,
     * tj. uvede všechny prostoru do stavu požadovaného na počátku hry.
     */
    public static void initializePlaces()
    {
        for (Place place : values()) {
            place.initialize();
        }
        currentPlace = Louka;
    }


    /**
     * Vrátí prostor, ve kterém se hráč právě nachází
     * <p/>
     * @return aktuální prostor
     */
    static Place getCurrentPlace()
    {
        return currentPlace;
    }


    /**
     * Nastaví prostor, ve kterém se hráč právě nachází
     * <p/>
     * @param place nastavovaný prostor
     */
    static void setCurrentPlace(Place place)
    {
        currentPlace = place;
    }


    /**
     * Vrátí kolekci odkazů na všechny prostory vystupující ve hře.
     *
     * @return Kolekce odkazů na všechny prostory vystupující ve hře
     */
    static Collection<Place> getAllPlaces()
    {
        return Arrays.asList(values());
    }


//##############################################################################
//== CONSTUCTORS AND FACTORY METHODS ===========================================
    /**
     * Vytvoří prostor se zadaným názvem, popisem a počátečními
     * sousedy a objekty.
     *
     * @param description   Popis vytvářeného prostoru
     * @param neighborNames Názvy sousedů vytvářeného prostoru při startu hry
     * @param objectNames   Názvy objektů ve vytvářeném prostoru při startu hry
     */
    private Place(String description, String[] neighborNames,
                  String... objectNames)
    {
        this.description = description;
        this.neighborNames = neighborNames;
        this.objectNames = objectNames;
    }


//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================
    /**
     * Vrátí popis prostoru, který daný prostor stručné charakterizuje.
     *
     * @return Popis daného prostoru
     */
    @Override
    public String getDescription()
    {
        return description;
    }


    /**
     * Vrátí název prostoru.
     *
     * @return Název prostoru
     */
    @Override
    public String getName()
    {
        return super.name();
    }


    /**
     * Vrátí kolekci sousedů daného prostoru, tj. kolekci prostorů,
     * do nichž je možno se z tohoto prostoru přesunout příkazem typu
     * {@link Commands.Type#MOVE Commands.Type.MOVE}.
     *
     * @return Kolekce sousedů
     */
    @Override
    public Collection<Place> getNeighbors()
    {
        return neighbors;
    }


    /**
     * Vrátí kolekci objektů nacházejících se v daném prostoru.
     *
     * @return Kolekce objektů nacházejících se v daném prostoru
     */
    @Override
    public Collection<Thing> getObjects()
    {
        return objects;
    }


    /**

     * Vrátí kolekci osob nacházejících se v daném prostoru.
     *
     * @return Kolekce osob nacházejících se v daném prostoru
     */
    Collection<Person> getPersons()
    {
        return persons;
    }


    /**
     * Vrací požadovanou věc z prostoru. Pokud věc v prostoru není vrací
     * {@code null}
     *
     * @param requestedObject Název požadovaného předmětu
     * @return Instance požadovaného předmětu nebo {@code null}
     */
    public Thing getObject(String requestedObject)
    {
        Thing result = null;
        for (Thing thingFromPlace : objects) {
            if (thingFromPlace.getName().equalsIgnoreCase(
                    requestedObject.toLowerCase())) {
                result = thingFromPlace;
            }
        }
        return result;
    }


    /**
     * Vrací požadovanou osobu z prostoru. Pokud osoba v prostoru není vrací
     * {@code null}
     *
     * @param requestedObject Název požadovaného předmětu
     * @return Instance požadovaného předmětu nebo {@code null}
     */
    public Person getPerson(String requestedObject)
    {
        Person result = null;
        for (Person personFromPlace : persons) {
            if (personFromPlace.getName().equalsIgnoreCase(
                    requestedObject.toLowerCase())) {
                result = personFromPlace;
            }
        }
        return result;
    }


    /**
     * Vrací požadovaný sousední prostor. Pokud takový soused neexistuje vrací
     * {@code null}
     *
     * @param requestedObject Název požadovaného souseda
     * @return Instance sousední místnosti nebo {@code null}
     */
    public Place getNeighbor(String requestedObject)
    {
        Place result = null;
        for (Place neighborOfPlace : neighbors) {
            if (neighborOfPlace.getName().equalsIgnoreCase(
                    requestedObject.toLowerCase())) {
                result = neighborOfPlace;
            }
        }
        return result;
    }

//== OTHER NON-PRIVATE INSTANCE METHODS ========================================

    /**
     * Odebere zadaný objekt z daného prostoru.
     *
     * @param thing Odebíraný objekt
     */
    void remove(Thing thing)
    {
        objects.remove(thing);
    }


    /**
     * Přidá zadaný objekt do daného prostoru.
     *
     * @param thing Přidávaný objekt
     */
    void add(Thing thing)
    {
        objects.add(thing);
    }


    /**
     * Odebere zadanou osobu z daného prostoru.
     *
     * @param person Odebíraná osoba
     */
    void remove(Person person)
    {
        persons.remove(person);
    }


    /**
     * Přidá zadanou osobu do daného prostoru.
     *
     * @param person Přidávaná osoba
     */
    void add(Person person)
    {
        persons.add(person);
    }

//== PRIVATE AND AUXILIARY CLASS METHODS =======================================
    //Maps

    /**
     * Inicializuje mapy,
     * v nichž jsou uloženy počáteční sousedé jednotlivých místností
     * a objekty, které se v místnostech nacházejí na počátku hry.
     */
    private static void initializeIntoMaps()
    {
        for (Place place : values()) {
            List<Place> places = new ArrayList<>(place.neighborNames.length);
            for (String name : place.neighborNames) {
                places.add(valueOf(name));
            }
            initialNeighbors.put(place, places);
            place.neighborNames = null;

            List<Thing> things = new ArrayList<>();
            List<Person> persons = new ArrayList<>();
            for (String name : place.objectNames) {
                if (name.charAt(0) == PERSON) {
                    persons.add(new Person(name));
                }
                else {
                    things.add(new Thing(name));
                }
            }
            initialObjects.put(place, things);
            initialPersons.put(place, persons);
            place.objectNames = null;
        }
    }


//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================
    /**
     * Inicializuje místnost do počátečního stavu,
     * tj. přiřadí jí počáteční sousedy a vloží do ní počáteční objekty.
     */
    private void initialize()
    {
        neighbors.clear();
        objects.clear();
        persons.clear();

        //Maps
        neighbors.addAll(initialNeighbors.get(this));
        objects.addAll(initialObjects.get(this));
        persons.addAll(initialPersons.get(this));
    }


//== EMBEDDED TYPES AND INNER CLASSES ==========================================
//== TESTING CLASSES AND METHODS ===============================================
//
//    /***************************************************************************
//     * Testovací metoda.
//     */
//    public static void test()
//    {
//    }
//    /** @param args Parametry příkazového řádku - nepoužívané. */
//    public static void main( String[] args )  {  test();  }
}


