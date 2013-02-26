/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */
package cz.vse._115.ut1245.xhudj19_hudec;



/**
 * Knihovní třída {@code Texts} slouží jako schránka na textové konstanty,
 * které se používají na různých místech programu.
 * Centralizací definic těchto textových řetězců lze nejsnadněji dosáhnout toho,
 * že texty, které mají být shodné na různých místech programu,
 * budou doopravdy shodné.
 *
 * @author Jiří HUDEC
 * @version 2013.01.15
 */
public final class Texts
{
//== CONSTANT CLASS ATTRIBUTES =================================================
    /**
     * Jméno autora programu.
     */
    public static final String AUTOR = "HUDEC Jiří";

    /**
     * Xname autora programu.
     */
    private static final String XNAME = "XHUDJ19";

    /**
     * Prefix určující, že předmět nepůjde zvednout.
     */
    public static final char HEAVY = '#';

    /**
     * Prefix určující, že se jedná o osobu.
     */
    public static final char PERSON = '@';

    /**
     * Názvy používaných prostorů - místností.
     * Prefix "m" - místo
     */
    public static final String mDŮM = "Dům",
            mZAHRADA = "Zahrada",
            mULICE = "Ulice",
            mHOSPODA = "Hospoda",
            mLOUKA = "Louka",
            mVOGONI = "Vogonská_loď",
            mZKRATKA = "Zkratka";

    /**
     * Jména používaných osob.
     * Prefix "j" - jména
     */
    public static final String jARTHUR = "Arthur",
            jBARMAN = "Barman",
            jFORD = "Ford",
            jPROSSER = "Prosser";

    /**
     * Názvy používaných objektů.
     * Prefix "o" - objekt
     */
    public static final String oRUČNÍK = "Ručník",
            oPANTOFLE = "Pantofle",
            oKARTÁČEK = "Kartáček",
            oKONVICE = "Konvice",
            oHRNEK = "Hrnek",
            oTALÍŘ = "Talíř",
            oSKLENICE = "Sklenice",
            oLEDNICE = "Lednice",
            oBULDOZER = "Buldozer",
            oBLÁTO = "Bláto",
            oZNAČKA = "Značka",
            oAUTO = "Auto",
            oPATNÍK = "Patník",
            oPIVO = "Pivo",
            oBURÁKY = "Buráky",
            oŽIDLE = "Židle",
            oSTROM = "Strom",
            oNÁKLAĎÁK = "Náklaďák",
            oKVĚTINA = "Květina",
            oKÁMEN = "Kámen",
            oPALEC = "Palec",
            oPRŮVODCE = "Průvodce",
            oPŘIJÍMAČ = "Přijímač",
            oSCÉNÁŘ = "Scénář",
            oPĚTILIBROVKA = "Pětilibrovka";

    /**
     * Názvy používaných příkazů.
     * Prefix "p" - příkaz
     */
    public static final String pHELP = "?",
            pARTHUR = "Arthur",
            pINVENTÁŘ = "Inventář",
            pJDI = "Jdi",
            pPOLOŽ = "Polož",
            pSEBER = "Seber",
            pVEZMI = "Vezmi",
            pPROMLUV = "Promluv",
            pPŘEDEJ = "Předej",
            pPOUŽIJ = "Použij",
            pKONEC = "Konec",
            pZKRATKA = "Zkratka";

    /**
     * Formát dodatku zprávy informujícího o aktuálním stavu hráče.
     * Prefix "d" - dodatek
     */
    public static final String dSOUSEDÉ = "Sousedé:  ",
            dOSOBY = "Osoby:    ",
            dPŘEDMĚTY = "Předměty: ",
            dTAŠKA = "Taška:    ",
            dFORMÁT_INFORMACE = "\n\nNacházíte se v prostoru: %s" +
                                "\n" + dSOUSEDÉ + "[%s]" +
                                "\n" + dOSOBY + "[%s]" +
                                "\n" + dPŘEDMĚTY + "[%s]" +
                                "\n" + dTAŠKA + "[%s]";

    /**
     * Texty zpráv vypisovaných v reakci na povinné příkazy.
     * Prefix "z" - zpráva
     */
    public static final String zZKRATKA =
                               "Použil(a) jste zkratku. Nyní můžete jít do" +
                               " cílového prostoru.",
            zZANP = "\nZadaná akce nebyla provedena",
            zPORADÍM = "\nChcete-li poradit, zadejte příkaz ?",
            zPRÁZDNÝ_PŘÍKAZ = "\nZadal(a) jste prázdný příkaz" + zPORADÍM,
            zNEZNÁMÝ_PŘÍKAZ = "\nTento příkaz neznám" + zPORADÍM,
            zPŘESUN = "\nPřesunul(a) jste se do prostoru: ",
            zCÍL_NEZADÁN = zZANP +
                           "\nNebyla zadán prostor, do kterého se má přejít",
            zNENÍ_CIL = zZANP + "\nDo zadaného prostoru se odsud nedá přejít: ",
            zZVEDNUTO = "\nSebral(a) jste předmět: ",
            zPOLOŽENO = "\nPoložil(a) jste předmět: ",
            zPŘEDMĚT_NEZADAN = zZANP +
                               "\nNebyl zadán předmět, s nímž mám manipulovat",
            zTĚŽKÝ_PŘEDMĚT = zZANP + "\nZadaný předmět nejde zvednout: ",
            zNENÍ_PŘEDMĚT = zZANP + "\nZadaný předmět v tašce není: ",
            zNENÍ_V_BATOHU = zZANP + "\nPředmět není v tašce: ",
            zBATOH_PLNÝ = zZANP + "\nZadaný předmět nemůžete vzít," +
                          "\ndo tašky se toho už víc nevejde.",
            zNÁPOVĚDA = "\nPříkazy, které je možno v průběhu hry zadat:" +
                        "\n============================================" +
                        "\nArthur [příkaz] - Jednoduché ovládání Arthura" +
                        "\nJdi [kam] - Přesun do určeného prostoru" +
                        "\nPolož [co] - Položí určený předmět do prostor" +
                        "\nPoužij [co] - Použije určený předmět z tašky" +
                        "\nPromluv [kdo] - Zahají rozhovor s danou osobou" +
                        "\nPředej [co] [kdo] - Předá předmět osobě" +
                        "\nSeber [co] - Zvedne předmět z prostoru" +
                        "\nVezmi [co] [kdo] - Vezme předmět od osoby" +
                        "\nZkratka - Přesune do zkratkové místnosti" +
                        "\nKonec - Ukončí hru",
            zUVÍTÁNÍ =
            "\nJmenuješ se Ford Prefect." +
            "\nJsi vesmírný stopař a terénní průzkuzmník pro" +
            "\nvesmírnou encyklopedii \"Stopařův průvodce Galaxií\"" +
            "\nuvízlý 15 let na planetě Zemi." +
            "\nDnes ráno tě vzbudilo pípání tvého senzomatického" +
            "\nsubéterového příjmače oznamující ti, že k Zemi" +
            "\nse právě blíží flotila Vogonských stavebních lodí" +
            "\ns cílem ji zničit, aby na jejím místě postavili" +
            "\nhypergalaktickou dálnici." +
            "\nJeště předtím, než použiješ svůj elektronický palec," +
            "\naby jsi stopoval některou z Vogonských lodí je čas," +
            "\naby jsi zachránil život tvému kamarádovi Arthurovi Dentovi." +
            "\nNezapomeń, že každý správný stopař musí vědět," +
            "\nkde má ručník!",
            zCELÉ_UVÍTÁNÍ = zUVÍTÁNÍ +
                            String.format(dFORMÁT_INFORMACE,
                                          mLOUKA,
                                          cat(mULICE),
                                          "",
                                          cat(oSTROM, oNÁKLAĎÁK, oBULDOZER,
                                              oKVĚTINA, oKÁMEN),
                                          cat(oPALEC, oPRŮVODCE, oPŘIJÍMAČ,
                                              oSCÉNÁŘ, oRUČNÍK,
                                              oPĚTILIBROVKA,
                                              oPĚTILIBROVKA)),
            zKONEC = "Konec hry. \nDěkujeme, že jste zkusil(a) naši hru.";

    /**
     * Texty zpráv vypisované v reakci na nepovinné příkazy.
     * Prefix "n" - nepovinná zpráva
     */
    public static final String nPOUŽIJ_PIVO = "\nVypil jsi pivo.",
            nPOUŽIJ_PIVO_NEJDE = "\nJedno pivo nech Arthurovi.",
            nPRŮVODCE_RETURN = "\n\nPro návrat do hry napiš tečku.",
            nPRŮVODCE_START = "\nOtevřel jsi vesmírnou encykolopedii " +
                              "\"Stopařův průvodce\ngalaxií\", " +
                              "ptej se na to, co tě zajímá." +
                              nPRŮVODCE_RETURN,
            nPRŮVODCE_STOP =
            "\nNashledanou příště.\nA hlavně: NEPROPADEJTE PANICE!.",
            nPRŮVODCE_UNKNOWN = "\nAčkoliv je to vysoce nepravděpodobné, " +
                                "tak \"Stopařův průvodce galaxií\" " +
                                "toto heslo nezná." +
                                nPRŮVODCE_RETURN,
            nPRŮVODCE_EMPTY = "\nNezadali jste heslo k vyhledání." +
                              nPRŮVODCE_RETURN,
            nPRŮVODCE_PRŮVODCE =
            "\nJe to kniha nejen pozoruhodná, " +
            "\nale i velmi úspešná — je úspešnejší než" +
            "\nNebeský rádce hospodynek, jde na odbyt lépe" +
            "\nnež Ješte triapadesátero, co delat pri nulové" +
            "\ngravitaci a je diskutabilnejší než trilogie" +
            "\nfilozofických trháku Úlona Kolufida Kde " +
            "\nudelal Pámbu chybu, Výber nejvetších Božích " +
            "\nomylu a Co je vlastne ten Pámbu zac?" +
            "\n\nV mnoha ležérnejších civilizacích na " +
            "\nVýchodním okraji naší Galaxie dokonce " +
            "\nStoparuv pruvodce nahradil velkou Galaktickou" +
            "\nencyklopedii jakožto zdroj veškerého vedení" +
            "\na moudrosti, nebot — ac má mnoho mezer a" +
            "\nspousta informací je pochybných nebo " +
            "\nprinejmenším hodne nepresných — má proti " +
            "\nstarší a prozaictejší prírucce dve nesporné" +
            "\nvýhody. " +
            "\nJednak je o neco levnejší, a predevším má na obálce" +
            "velký vlídný nápis:\n\n NEPROPADEJTE PANICE." + nPRŮVODCE_RETURN,
            nPRŮVODCE_PALEC =
            "\nElektronický palec slouží k stopování vesmírných lodí." +
            "\nJedná se o krátký a tlustý černý váleček s hebkým," +
            "\nmatným povrchem a několika vypínači a ciferníky na jednom konci." +
            nPRŮVODCE_RETURN,
            nPRŮVODCE_PŘIJÍMAČ =
            "\nSenzomatický subéterový přijímač zjišťuje přítomnost" +
            "\nvesmírných lodí. Bez něj by bylo stopování ve vesmíru o" +
            "\nmnoho složitější." + nPRŮVODCE_RETURN,
            nPRŮVODCE_RUČNÍK = "\nRučník je skutečně kolosálně užitečná " +
                               "součást výbavy hvězdného stopaře." +
                               "\nPředevším má značnou praktickou cenu -" +
                               " můžete se například do něj zabalit," +
                               "\naby vám nebylo zima, když poskakujete " +
                               "napříč chladnými měsíci planety Jaglan" +
                               "\nBeta.  Můžete na něm ležet na zářivých," +
                               " mramorovým pískem vystlaných plážích" +
                               "\nSantraginu V a vdechovat opojné výpary " +
                               "z jeho moří. Můžete na něm spát pod" +
                               "\nhvězdami, jež tak rudě září na planetě " +
                               "pouští, Kakrafúnu. Můžete ho použít" +
                               "\njako plachtu, až poplujete na maličkém " +
                               "voru po proudu drsné řeky Moth," +
                               "\nmůžete ho namočit pro boj zblízka, " +
                               "nebo si jím zahalit hlavu, abyste necítili" +
                               "\njedovaté pachy žravé obludy Blátotlačky " +
                               "z Traalu a nestřetli se s jejím pohledem" +
                               "\n(je to nepředstavitelně tupé zvíře, myslí " +
                               "si, že když ji nevidíte, nevidí ani" +
                               "\nona vás - blbá jak tágo, ale značně žravá)." +
                               "\nKdyž jste v úzkých, můžete jím" +
                               "\nsignalizovat o pomoc. No, a samozřejmě se " +
                               "jím také můžete utřít, pokud vám" +
                               "\npo tom všem ještě připadá dost čistý." +
                               nPRŮVODCE_RETURN,
            nPALEC =
            "\nPoužil jsi elektronický palec pro stopování vesmírných lodí." +
            "\nNěkterá by vás měla být ochotná přijmout.",
            nPŘIJÍMAČ =
            "\nSenzomatický subéterový přijímač pípá čím dál tím rychleji.\n" +
            "Vogonské lodě se pomalu, ale jistě blíží.",
            nSCÉNÁŘ =
            "\nProlistoval jsi scénář ke hře Bohem zakletý, který s sebou" +
            "\nstále nosíš, protože předstířáš, že jsi nezaměstnaný herec." +
            "\nPravděpodobně ho už nebudš potřebovat.",
            nNELZE_POUŽÍT = "\nTento předmět nelze použít",
            nARTH_INVENT = "\nArthur má v inventáři tyto předměty: ",
            nARTH_NENÍ_PŘÍIKAZ = "\nNezadali jste příkaz pro Arthura",
            nART_NEZNÁM_PŘÍIKAZ = "\nTento příkaz Arthur neumí",
            nARTHUR_NELZE =
            "\nPříkazy nejde vykonávat, když Arthur není v místnosti",
            nARTHUR_SLEDUJE = "\nArthur vás nyní následuje",
            nARTHUR_STŮJ = "\nArthur zůstane v tomto prostoru",
            nARTHUR_NEPOSLOUCHÁ = "\nArthura ještě nemůžeš řídit",
            nROZHOVOR_START = "\nZačal(a) jsi se bavit s postavou: ",
            nROZHOVOR_NEJDE = "\nTato postava se s tebou teď odmítá bavit.",
            nROZHOVOR_NENÍ = "\nPostava tohoto jména v tomto prostoru není.",
            nROZHOVOR_NIKDO =
            "\nMusíš zadat jméno postavy, se kterou se chceš bavit.",
            nNENÍ_PŘEDMĚT_OSOBA =
            "\nNebyl zadán předmět, s nímž mám manipulovat nebo osoba, " +
            "která s ním interaguje",
            nOSOBA_NENÍ = "\nTato osoba v tomto prostoru není",
            nNEMÁTE_PŘEDMĚT = "\nTento předmět v tašce nemáte",
            nOSOBA_NEMÁ_PŘEDMĚT = "\nTento předmět osoba v inventáři nemá",
            nPŘEDAT_FORMÁT = "\nPostavě %s jsi předal(a) předmět: %s",
            nVZÍT_FORMÁT = "\nOd postavy %s jsi převzal(a) předmět: %s",
            nVÝHRA = "\nGratuluji! Úspěšně jsi zachránil Arthura Denta!",
            nPROHRA = "\nTo ses moc nepředvedl, Forde." +
                      "\nNepodařilo se ti zachránit Arthura Denta",
            nCHYBÍ_ARTHUR = "\nNeopouštěj Zemi bez Arthura!",
            nCHYBÍ_RUČNÍK = "\nBez ručníku nemůžeš stopovat.",
            nCHYBÍ_PRŮVODCE = "\nNěkde jsi nechal Stopařova průvodce Galaxií.";

    /**
     * Texty rozhovorů.
     */
    public static final String[] rozhovory = {
        formátuj(jFORD, "Ahoj Arthure.") +
        formátuj(jARTHUR, "Forde, ahoj, jak se vede?") +
        formátuj(jFORD, "Fajn. Hele máš teď něco na práci?") +
        formátuj(jARTHUR, "No jenom musím ležet před všemi tad těmi " +
                          "\nbuldozery a tak dál, protože když to neudělám," +
                          "\ntak mi zbourají dům," +
                          "\nale jinak vlastně ani ne. Proč?") +
        formátuj(jFORD,
                 "Musíme si promluvit, a něčeho se napít. " +
                 "\nJe to strašně důležitý, teď hned. Zajdeme do hospody" +
                 "\nve vesnici.") +
        formátuj(jARTHUR, "Hele, copak to nechápeš?!" +
                          "\nTenhle chlap, Prosser, mi chce zbourat barák!") +
        formátuj(jFORD, "Určitě to nějak vyřešíme."),
        formátuj(jFORD, "Haló, promiňte, že ruším.") +
        formátuj(jPROSSER, "Ano, copak? Už pan Dent přišel k rozumu?") +
        formátuj(jFORD, "Mohli bychom pro danou chníli předpokládat," +
                        "\nže nepřišel? A mohli bysme předpokládat, že tady" +
                        "\nhodlá zůstat celý" +
                        "\nden? Takže vaši lidé tu budou celý den postávat a" +
                        "\nnedělat nic?") +
        formátuj(jPROSSER, "Mno, to by mohlo být...") +
        formátuj(jFORD,
                 "No a když jste se s tím už jednou smířil," +
                 "\ntak vlastně pana Denta nepotřebujete, aby tady celou" +
                 "\ndobu" +
                 "\nležel, ne?") +
        formátuj(jPROSSER, "Cože?") +
        formátuj(jFORD,
                 "Vy ho tu vlastně nepotřebujete. Takže kdybyste" +
                 "\nbyl ochoten přistoupit na to, že tady v podstatě je," +
                 "\nmohl bych si" +
                 "\ns ním odskočit na půlhodinku do hospody. Co vy na to?") +
        formátuj(jPROSSER, "Zní to docela rozumně...") +
        formátuj(jFORD, "Takže kdybyste laskavě šel sem a tady si lehl" +
                        "\nmísto pana Denta, aby někdo ležel před těmi" +
                        "buldozery.") +
        formátuj(jPROSSER, "Cože?") +
        formátuj(jFORD, "Je to uplně jednoduché. Můj klient, pan Dent," +
                        "\nříká, že se tu přestane válet v blátě výhradně pod" +
                        "\npodmínkou, že ho vystřídáte."),
        formátuj(jFORD, "Tak dělej, vstávej, ať si tam může lehnout.") +
        formátuj(jARTHUR, "Už vstávám.") +
        formátuj(jFORD, "A ne abyste tady zatím panu Dentovi poťouchle" +
                        "\nzbourali dům, když bude pryč, jasný?") +
        formátuj(jPROSSER, "Pomyšlení na něco takového ještě ani" +
                           "\nnezačalo uvažovat o pouhé možnosti vstoupit" +
                           "\nmi na mysl.") +
        formátuj(jARTHUR, "Dá se mu vůbgec věřit?") +
        formátuj(jFORD, "Já osobně bych mu důvěřoval až do konce světa.") +
        formátuj(jARTHUR, "To znamená jak asi dlouho?") +
        formátuj(jFORD, "Asi tak dvanáct minut. Tak pojď honem," +
                        "\npotřebuju se napít."),
        formátuj(jFORD,
                 "Dva kousky hořkého, ale rychle, bude konec světa.") +
        formátuj(jBARMAN, "Myslíte, pane? Máme na to dnes hezky." +
                          "\nPůjdete odpoledne na fotbal?") +
        formátuj(jFORD, "Ne, nemá to smysl.") +
        formátuj(jBARMAN, "Copak, to si myslíte, že Arsenal nemá šanci?") +
        formátuj(jFORD, "Nene, prostě jenom bude konec světa.") +
        formátuj(jBARMAN, "To by se Arsenalu náramně hodilo."),
        formátuj(jFORD, "Dělej, pij, máš tu pivo.") +
        formátuj(jARTHUR, "Pivo? Jen tak v poledne? A proč?") +
        formátuj(jFORD, "Uvolňuje svalový tonus, budeš to potřebovat") +
        formátuj(jARTHUR, "Udělal jsem dneska něco špatně," +
                          "\nnebo byl svět vždycky takovýhle, a já to" +
                          "\njenom neviděl?") +
        formátuj(jFORD, "Tak dobře, pokusím se ti to vysvětlit." +
                        "\nJak bys reagoval, kdybych ti řekl, že nejsem z" +
                        "\nGuildfordu, ale z jedné malé planetky kdesi" +
                        "\nv okolí Betelgeuze?") +
        formátuj(jARTHUR, "Nevím. Myslíš, že je pravděpodobné, že něco" +
                          "\ntakového řekneš?") +
        formátuj(jFORD, "Tohle nemá cenu. Dopij to. Bude konec světa.") +
        formátuj(jARTHUR, "Dneska je určitě čtvrtek. " +
                          "\nJá ty čtvrtky prostě nezvládám.") +
        formátuj(jFORD, "Máš s sebou ručník?") +
        formátuj(jARTHUR, "Cože? Proč? Ne... Měl bych ho snad mít?"),
        formátuj(jFORD, "Poprosil bych o balíček buráků.") +
        formátuj(jBARMAN, "Momentíček...") +
        formátuj(jARTHUR, "Co je to za hluk?") +
        formátuj(jFORD, "Neboj, ještě nezačli.") +
        formátuj(jARTHUR, "Zaplať Pánbu.") +
        formátuj(jFORD, "To asi jenom boří tvůj dům..") +
        formátuj(jARTHUR, "Proboha! Taky že jo! Boří mi dům!\n" +
                          "Co sakra dělám v hospodě?") +
        formátuj(jFORD, "V tomhle stádiu už je to jedno. Jen je nech," +
                        "\nať si užijou trochu legrace.") +
        formátuj(jBARMAN, "28 pencí, kdybyste byl tak laskav.") +
        formátuj(jARTHUR, "Legrace? Legrace! Nechte toho, vy vandalové!") +
        formátuj(jBARMAN, "Myslíte to vážně, pane, že bude konec světa?") +
        formátuj(jFORD, "Ano, odhaduju to tak na dvě minuty.") +
        formátuj(jBARMAN, "A můžeme s tím něco udělat?") +
        formátuj(jFORD, "Ne, to ne.")
    };


//== VARIABLE CLASS ATTRIBUTES =================================================
//== STATIC INITIALIZER (CLASS CONSTRUCTOR) ====================================
//== CONSTANT INSTANCE ATTRIBUTES ==============================================
//== VARIABLE INSTANCE ATTRIBUTES ==============================================
//== CLASS GETTERS AND SETTERS =================================================
//== OTHER NON-PRIVATE CLASS METHODS ===========================================
    /**
     * Vrátí řetězec obsahující zadané názvy oddělené čárkami.
     *
     * @param názvy Názvy, které je třeba sloučit
     * @return Výsledný řetězec ze sloučených zadaných názvů
     */
    public static String cat(String... názvy)
    {
        if (názvy.length == 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder(názvy[0]);
        for (int i = 1; i < názvy.length; i++) {
            stringBuilder.append(", ").append(názvy[i]);
        }
        return stringBuilder.toString();
    }


    /**
     * Vytvoří jednu položku rozhovoru
     *
     * @param osoba Jméno osoby
     * @param fráze Její promluva
     * @return Výsledný řetězec
     */
    static String formátuj(String osoba, String fráze)
    {
        return String.format("\n%s: „%s“", osoba, fráze);
    }


//##############################################################################
//== CONSTUCTORS AND FACTORY METHODS ===========================================
    /**
     * Soukromý konstruktor zabraňující vytvoření instance.
     */
    private Texts()
    {
    }


//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================
//== OTHER NON-PRIVATE INSTANCE METHODS ========================================
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
//        Texts inst = new Texts();
//    }
//    /** @param args Parametry příkazového řádku - nepoužívané. */
//    public static void main( String[] args )  {  test();  }
}


