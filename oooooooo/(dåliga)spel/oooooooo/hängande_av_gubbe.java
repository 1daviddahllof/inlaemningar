package oooooooo;

import java.util.Scanner;
import java.util.regex.Pattern;

public class hängande_av_gubbe {

	// Här har vi asciiart ev en fullt hängd gubbe och listor för koordinaterna för
	// varje char i ordning som de ska visas
	static char[][] ascii = { { ' ', ' ', ' ', '_', '_', '_', '_', '_', '_', '_', '_', ' ', ' ' },
			{ ' ', ' ', '|', '/', ' ', ' ', ' ', ' ', ' ', ' ', '|' },
			{ ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', '(', '_', ')' },
			{ ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', 'L', '|', '/' },
			{ ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|' },
			{ ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', '/', ' ', 'L' }, { ' ', ' ', '|' },
			{ '_', '_', '|', '_', '_', '_' } };
	static int[] asciix = { 0, 1, 2, 3, 4, 5, 2, 2, 2, 2, 2, 2, 3, 3, 4, 5, 6, 7, 8, 9, 10, 9, 10, 11, 9, 10, 11, 10, 9,
			11 };
	static int[] asciiy = { 7, 7, 7, 7, 7, 7, 6, 5, 4, 3, 2, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 2, 2, 2, 3, 3, 3, 4, 5, 5,
			5 };

	// Här är alla orden som programmet slumpar mellan
	static String[] words = { "hej", "jag", "du", "är", "tack", "och", "bra", "det", "har", "på", "vad", "älskar", "en",
			"dig", "till", "inte", "jag älskar dig", "knulla", "kuk", "i", "hur", "ska", "fitta", "om", "vill", "att",
			"som", "söt", "kan", "med", "puss", "min", "för", "älskling", "din", "mycket", "kram", "var", "när",
			"hej då", "ja", "vi", "snygg", "gör", "mig", "nej", "så", "bara", "ha", "sverige", "nu", "kärlek", "älska",
			"sex", "men", "hejdå", "saknar", "fan", "snart", "hora", "bög", "god jul", "trött", "får", "mår", "gå",
			"vara", "från", "den", "bajs", "ett", "lite", "tycker", "då", "lagom", "snygging", "av", "sötnos", "kåt",
			"vad gör du", "hälsningar", "mamma", "jag heter", "kanske", "också", "holländska", "glad", "bil", "kul",
			"vet", "gillar", "här", "snäll", "eller", "få", "katt", "man", "ni", "häst", "varför", "dum", "mat",
			"jag är", "ta", "måste", "varsågod", "heter", "hoppas", "öl", "idag", "hund", "grattis", "du är", "sova",
			"snopp", "år", "två", "alla", "de", "flicka", "allt", "ledsen", "prata", "igen", "någon", "går", "han",
			"skit", "bäst", "dag", "god morgon", "kär", "hus", "kyss", "holland", "se", "roligt", "stor",
			"nederländska", "tjej", "het", "god natt", "bli", "förlåt", "sedan", "äta", "skola", "utan", "gott", "tre",
			"skulle", "mitt", "hem", "innan", "blir", "där", "finns", "underbar", "komma", "inget", "kom", "god", "ful",
			"hejsan", "ingen", "bor", "trevlig", "fin", "er", "svårt", "hon", "barn", "svenska", "fotboll", "vän",
			"ses", "efter", "pojke", "jul", "rolig", "vem", "vid", "jävla", "fel", "svensk", "många", "något", "åka",
			"språk", "resa", "förstår", "tror", "aldrig", "tillbaka", "nog", "bok", "rätt", "läget", "gott nytt år",
			"även", "förstå", "snälla", "än", "liten", "hjärta", "sluta", "helvete", "lära", "hälsa", "ord", "redan",
			"känner", "fyra", "visa", "ju", "kvar", "ge", "rumpa", "kompis", "lätt", "gammal", "ordbok", "skicka",
			"hemma", "ganska", "fem", "ko", "penis", "skriva", "ändå", "okej", "cykel", "genom", "fortfarande", "vår",
			"goddag", "nästan", "sov gott", "bröst", "godnatt", "sakna", "lämna", "tråkigt", "kille", "sexig", "elak",
			"bord", "önskar", "fisk", "mot", "godmorgon", "röv", "jag saknar dig", "tack så mycket", "van", "namn",
			"fick", "kort", "full", "behöver", "springa", "gris", "va", "hallå", "sju", "under", "imorgon", "tönt",
			"dator", "tar", "lägga", "hitta", "arg", "spela", "känna", "tro", "åtta", "tjena", "dom", "fram", "hos",
			"vatten", "skål", "flytta", "sug", "dålig", "fråga", "titta", "pappa", "eftersom", "dra", "lägenhet",
			"gång", "andra", "sätt", "vart", "god dag", "vad heter du", "duktig", "berätta", "tyvärr", "därför",
			"väldigt", "åt", "ser", "läsa", "samma", "korv", "längtar", "pojkvän", "dö", "sen", "tänker", "morgon",
			"igår", "bild", "godis", "gullig", "ännu", "svart", "detta", "slicka", "du är söt", "svar", "vilja",
			"varje", "säga", "runka", "ibland", "tio", "tala", "vänta", "kväll", "helg", "väl", "byta", "nio", "slut",
			"hatar", "syster", "dock", "ost", "suga", "fast", "lördag", "över", "sol", "gärna", "vi ses", "gilla",
			"lycka", "bror", "varit", "samlag", "kära", "sov", "pratar", "fredag", "tid", "jävlar", "musik",
			"älskar dig", "ok", "mål", "hjälp", "kaffe", "fint", "liv", "suger", "hålla", "själv", "svara", "ursäkta",
			"slå", "rum", "ljus", "trevligt", "köpa", "företag", "dricka", "åker", "stad", "träffa", "ny", "annars",
			"sommar", "glass", "båt", "tillsammans", "tyst", "lärare", "mina", "använda", "stol", "jag älskar", "sa",
			"bästa", "hela", "födelsedag", "fru", "ont", "skatt", "jag gillar dig", "verkligen", "hoppa", "onsdag",
			"jag vill", "lugn", "apa", "enda", "gjort", "kramar", "söndag", "blev", "kvinna", "affär", "senare", "ö",
			"sjuk", "stanna", "skönt", "vänner", "bo", "tur", "olika", "träd", "jätte", "ditt", "mellan", "synd", "ut",
			"konstig", "snö", "sant", "land", "ofta", "bort", "neger", "för att", "tåg", "utanför", "rädd", "tråkig",
			"ha det bra", "å", "särskilt", "dessutom", "leka", "kör", "hade", "in", "djur", "nyfiken", "potatis",
			"middag", "lycka till", "hår", "väder", "semester", "hämta", "fönster", "börja", "säng", "död", "problem",
			"röd", "måndag", "torsdag", "betyder", "båda", "natt", "städa", "orka", "tycka", "lika", "ligger",
			"försöka", "trots", "lugnt", "bättre", "sover", "såg", "stjärna", "endast", "hungrig", "pengar", "flera",
			"precis", "ingenting", "fest", "må", "jo", "visst", "hit", "svår", "veta", "håll", "inga", "vecka", "äpple",
			"vägg", "bör", "medan", "huvud", "väg", "kläder", "dej", "håller", "bot", "skog", "gick", "jag har", "höra",
			"vit", "tycker om", "blå", "verkar", "tjock", "arbete", "kolla", "trivs", "dem", "fått",
			"jag tycker om dig", "hur är det", "jobb", "heller", "sitta", "brukar", "skratta", "spelar", "gud", "tak",
			"dåligt", "knäpp", "hans", "del", "ren", "jag mår bra", "blomma", "hand", "dörr", "vilken", "gul", "gråta",
			"glömma", "oss", "träna", "lång", "dit", "emot", "bajsa", "kött", "står", "engelska", "kunde", "dröm",
			"ögon", "förutom", "älg", "is", "annat", "kök", "bada", "tycka om", "deras", "tänka", "cool", "kaka", "låt",
			"ängel", "ensam", "välja", "faktiskt", "ikväll", "hälsning", "händer", "skor", "vissa", "familj", "lär",
			"heja", "upp", "glas", "talar", "lyssna", "stora", "tv", "denna", "självklart", "skön", "god kväll",
			"skolan", "nederländerna", "bröd", "mus", "gurka", "stolt", "läcker", "sur", "tidigare", "brev", "döda",
			"kissa", "möte", "vila", "äter", "inom", "både", "höst", "sko", "ligga", "gifta", "bestämma", "bakom",
			"sjö", "sida", "reda", "naken", "honom", "äger", "kukhuvud", "ringa", "gröt", "ihåg", "ända", "val",
			"pussar", "längta", "telefon", "ämne", "flickvän", "framför", "varken", "banan", "råd", "höger", "det är",
			"vanlig", "laga", "människor", "ute", "saker", "intressant", "påsk", "först", "ledig", "mjölk", "pigg",
			"illa", "ner", "film", "mening", "enligt", "lag", "mysig", "helst", "sätta", "tisdag", "hinna", "krama",
			"ägg", "samt", "sig", "tröja", "pung", "knark", "mej", "kyssa", "istället", "gubbe", "söta", "hångla",
			"fika", "plats", "kung", "tidning", "alltså", "åsna", "förresten", "länge", "just", "gjorde", "brott",
			"lingon", "älskade", "annan", "ville", "förut", "vin", "dansa", "nå", "bland", "köra", "vind", "sista",
			"kyssar", "smart", "paket", "buss", "syskon", "nummer", "mage", "mätt", "bära", "tills", "stå", "snus",
			"sött", "haft", "lök", "behöva", "snabb", "adjö", "slida", "sak", "låg", "minne", "nyss", "månad", "bott",
			"sticka", "tyska", "adress", "ung", "matta", "leta", "päron", "simma", "kyckling", "vinter", "gått",
			"torsk", "bjuda", "hög", "kall", "vänster", "knullar", "öga", "tavla", "röka", "varm", "a", "borde",
			"puss och kram", "be", "alldeles", "ring", "skåp", "läkare", "te", "nytt", "tag", "far", "mun", "elva",
			"passa", "född", "golv", "tuff", "före", "gissa", "betyg", "lov", "färg", "ej", "fet", "betala", "undrar",
			"kjol", "lycklig", "duscha", "hjälpa", "förklara", "frukost", "grattis på födelsedagen", "hav", "ger",
			"borta", "är du", "spel", "förslag", "svamp", "röra", "porr", "gräs", "önska", "vidare", "låda", "prov",
			"börjar", "bryr", "toalett", "annorlunda", "kallt", "sitter", "by", "tog", "sked", "krav", "kusin",
			"gäller", "timme", "nöjd", "älskare", "ihop", "utbildning", "fall", "meddelande", "slyna", "björn", "långt",
			"trög", "upptagen", "ro", "kurs", "jävel", "skynda", "sjunga", "smör", "sönder", "klar", "smal", "morot",
			"tal", "bär", "onanera", "sin", "författare", "orolig", "tusen", "avtal", "byxor", "bredvid", "studera",
			"sång", "choklad", "mest", "livet", "stjärt", "fot", "öva", "ur", "vackra", "sett", "kanin", "son",
			"lexikon", "träffas", "klockan", "besked", "klara", "tomte", "jobba", "stark", "lägg", "kropp", "bulle",
			"pass", "äcklig", "papper", "dina", "person", "sköta", "ytterligare", "ångest", "fara", "början", "grå",
			"äntligen", "rida", "fortsätta", "lektion", "spis", "perfekt", "färdig", "kasta", "present", "mörk",
			"bryta", "snacka", "gata", "hända", "menar", "skriver", "snabbt", "leva", "sötis", "beroende", "riktigt",
			"vore", "samtal", "dotter", "tolv", "vill du", "hård", "välkomna", "strand", "skär", "ställe", "ungefär",
			"medlem", "trädgård", "låna", "le", "kund", "hörs", "människa", "kalla", "sugen", "luktar", "polis", "berg",
			"vilka", "låta", "moped", "besviken", "rad", "vi hörs", "egentligen", "öra", "åtminstone", "maj", "hyra",
			"tom", "tretton", "vinna", "gift", "orm", "frukt", "foto", "blyg", "helgen", "bak", "väska", "kopp",
			"första", "stackars", "jag hatar dig", "spara", "världen", "socker", "heta", "väntar", "förra", "uppgift",
			"soffa", "genast", "förkyld", "små", "tillfälle", "säker", "klart", "karta", "måla", "lat", "trevlig helg",
			"klass", "herr", "sent", "holländare", "tå", "hata", "grön", "penna", "brun", "mindre", "viktigt",
			"stensopp", "skära", "fastän", "läxa", "vanligt", "varandra", "läser", "vackert", "bostad", "vakna" };
	static String[] uttryck = { "Allena saliggörande ", "Ana argan list ", "Ana ugglor i mossen ", "Andefattig ",
			"Andra bullar ", "Ankdamm ", "Anno dazumal ", "Använda apostlahästarna ", "Armbåga sig fram ",
			"Av samma korn och skrå ", "Av samma skrot och korn ", "Avsked på grått papper ", "Bakom lyckta dörrar ",
			"Bakom lås och bom ", "Balansera på slak lina ", "(Som) balsam för själen ", "Barka åt skogen ",
			"Barn av sin tid ", "Basunera ut ", "Be för sin sjuka mor ", "Befinna sig i fritt fall ",
			"Befinna sig i förskingringen ", "Begära någons huvud på ett fat ", "Behandla i någon med silkesvantar ",
			"Behålla fattningen ", "Bara toppen av ett isberg ", "Beväpnad till tänderna ", "Bida sin tid ",
			"Billig penning ", "Binda ris för egen rygg ", "Bita av någon ", "Bita huvudet av skammen ",
			" bita i det sura äpplet ", "Bita i gräset ", "Bjuda med armbågen ", "Bjuda till ", "Blek kopia ",
			"Bli blåst på konfekten ", "Bli vid sin läst ", "Blommor och bin ", "Blåsa faran över ",
			"Blåsa upp till snus ", "Bollen är rund ", "Brinna för något ", "Brinner i knutarna ", "Bränna sina broar ",
			"Bränna sina skepp ", "Bränna sitt ljus i båda ändar ", "Brännvinsadvokat ", "Bröd och skådespel ",
			"Bulla upp ", "Bygger bo i huvudet ", "Bygga broar ", "Bygga luftslott ", "Byta fot ",
			"Både ha och äta både äta kakan och ha den kvar ", "Både hängslen och livrem ", "Bära hundhuvudet ",
			"Bära något i sitt sköte ", "Bära syn för sägen ", "Cirkeln är sluten ", "Dansa efter någons pipa ",
			"Dansa på någons grav ", "Dansen kring den gyllene guldkalven ", "Dark horse ", "Den dagen, den sorgen ",
			"Den fula ankungen ", "Den gubben gick inte ", "Det blev pannkaka av alltihop ", "Det ena eller det andra ",
			"Det fina i kråksången ", "Det går sin gilla gång ", "Det går utför ", "Det knallar och går ",
			"Det kan du hoppa upp och sätta dig på ", "Det kan du skriva upp ", "Det kan jag lova ",
			"Det lackar mot jul eller det lider mot jul ", "Det man inte har i huvudet får man ha i benen. ",
			"Det står och faller med honom ", "Det täcka könet ", "Det vete fåglarna ", "Ditt och datt ",
			"Don efter person ", "Dra alla över en kam eller låta alla gå över samma kam ",
			"Dra benen efter sig eller dra på benen ", "Dra det längsta strået ", "Dra dit pepparn växer ",
			"Dra det tyngsta lasset ", "Dra en lans för någon även bryta en lans … ",
			"Dra ett streck över det som varit ", "Dra i trådarna ", "Dra igång ", "Dra ihop sig ",
			"Dra lärdom av något ", "Dra mig baklänges ", "Dra något gammalt över sig ", "Dra något i långbänk ",
			"Dra på munnen ", "Dra på trissor ", "Dra sig till minnes ", "Dra sig tillbaka ", "Dra sina färde ",
			"Dra sin sista suck ", "Dra sitt strå till stacken ", "Dra timmerstockar ", "Dra undan mattan för någon ",
			"Dra ut på något ", "Dra ut på tiden ", "Dra växlar på något ", "Dra åt svångremmen ", "Dra öronen åt sig ",
			"Dragen vid näsan ", "Dras med något ", "Driva något till sin spets ",
			"Droppen som fick bägaren att rinna över ibland bara droppen ", "Duka under ", "Dummare än tåget ",
			"Därom tvista de lärde ", "Falla i onåd ", "Falla mellan stolarna ", "Falla någon på läppen ",
			"Falla på eget grepp ", "Falla under radarn", "Fan och hans moster ", "Fara med osanning ",
			"Fara och flyga ", "Fara å färde ", "Fel ute ", "Fatta galoppen ", "Femte hjulet under vagnen ",
			"Fin i kanten ", "Fina fisken ", "Fiska i grumligt vatten ", "Fjärilar i magen ", "Flyga i luften ",
			"Flyga som stekta sparvar in i mun ", "Flyta ovanpå ", "Flåsa någon i nacken ", "Frid och fröjd ",
			"Fritt fram ", "Från ax till limpa ", "Från vettet ", "Ful fisk ", "Full i fan eller full i sjutton ",
			"Full rulle ", "Fylla moppe ", "Få betalt under bordet ", "Få blod på händerna ", "Få blodad tand ",
			"Få det hett om öronen ", "Få eldavbrott[källa behövs] ", "Få en släng av sleven ", "Få en syl i vädret ",
			"Få ett kok stryk ", "Få frispel ", "Få för gammal ost ", "Få fötter ", "Få gråa hår ", "Få kalla fötter ",
			"Få kalla handen ", "Få kalla kårar ", "Få korgen ", "Få napp ", "Få mothugg ", "Få nys om något",
			"Få något i sitt knä", "Få något om bakfoten ", "Få något på halsen ", "Få något på hjärnan ",
			"Få något på rätt köl ", "Få något som plåster på såren ", "Få något till livs ", "Få något till skänks ",
			"Få nöja sig med smulorna från den rikes bord ", "Få på båten ", "Få på moppe ", "Få på tafsen ",
			"Få på pälsen ", "Få saker ur händerna ", "Få silkessnöret ", "Få sin beskärda del ",
			"Få sina fiskar varma ", "Få sista ordet ", "Få stora skälvan ", "Få stå på tillväxt ", "Få ståpäls ",
			"Få svar på tal ", "Få tala till punkt ", "Få tji ", "Få tunghäfta ", "Få upp ögonen för ",
			"Få vatten på sin kvarn ", "Få veta att man lever ", "Få ändan ur vagnen ", "Fältet är fritt ",
			"Född i farstun ", "Född med silversked i munnen. ", "Följa någon hack i häl ", "För allt smör i Småland ",
			"För allt vad tygen håller ", "För egen maskin ", "För fulla muggar ", "För hela slanten ",
			"För Kung och fosterland ", "Föra bakom ljuset ", "Förena nytta med nöje ", "Förlora fattningen ",
			"Första generationen skapar förmögenheten, andra spenderar den ", "Förstå hur landet ligger ",
			"Försöka ta ner månen ", "Förvalta sitt pund ", "Gammal som gatan ", "Gamla surdegar ",
			"Gardera med kryss ", "Gator och torg ", "Ge dålig eftersmak ", "Ge grönt ljus ", "Ge igen för gammal ost ",
			"Ge järnet ", "Ge någon en känga ", "Ge någon fria tyglar ", "Ge någon korgen ", "Ge sig i kast ",
			"Ge sig till att ", "Ge sig till känna ", "Ge sken av ", "Ge svar på tal ", "Ge upp andan ",
			"Ge vid handen ", "Gilla läget ", "Gjuta olja på vågorna ", "Glida in på en räkmacka ",
			"Glad som en lärka ", "Glad såsom fågeln i morgonstunden ", " glimten i ögat ", "Gnugga axel med någon",
			"Gnugga geniknölarna ", "Goddag yxskaft ", "Grabbarna grus", "Grabben med choklad i ",
			"Grannens gräs är alltid grönare ", "Greppa efter ett halmstrå ", "Griller i huvudet ",
			"Gripa något ur luften ", "Gripa tillfället i flykten ", "Gråa håret ", "Gråta blod ",
			"Gråta hela vägen till banken ", "Gråta över spilld mjölk ", "Grädde på moset ", "Gräva där man står ",
			"Gräva ner sig i något ", "Gräva ner stridsyxorna ", "Gräva sin egen grav ", "Grön av avund ",
			"Gubbe med keps ", "Gudars skymning! ", "Gå av för hackor ", "Gå av stapeln ", "Gå bakom knuten ",
			"Gå bakom ryggen på någon ", "Gå bet på något ", "Gå bort ", "Gå bärsärkagång ", "Gå den breda vägen ",
			"Gå dit näsan pekar ", "Gå från ord till handling ", "Gå för ", "Gå för långt ", "Gå genom märg och ben. ",
			"Gå i bräschen för något ", "Gå i egna tankar ", "Gå i gamla hjulspår ", "Gå i graven ",
			"Gå i någons fotspår ", "Gå i putten ", "Gå i spinn", "Gå i stöpet ", "Gå i taket ", "Gå i väntans tider ",
			"Gå in i väggen ", "Gå loss på ", "Gå man ur huse ", "Gå med håven ", "Gå någon på nerverna ",
			"Gå och skrota ", "Gå på alla cylindrar ", "Gå på en mina ", "Gå på för högvarv ", "Gå på i ullstrumporna ",
			"Gå på knäna ", "Gå på kryckor ", "Gå på pumpen ", "Gå på tomgång ", "Gå sin egen väg ",
			"Gå sin gilla gång ", "Gå stick i stäv med något ", "Gå till botten med något ", "Gå till storms mot något",
			"Gå troll i något ", "Gå under", "Gå under jorden ", "Gå under klubban ", "Gå upp ett ljus för någon ",
			"Gå upp i limningen ", "Gå ur tiden ", "Gå åt pipan ", "Gå åt skogen ", "Gå över gränsen", "Gå över lik ",
			"Gå över stock och sten ", "Gå över ån efter vatten ", "Gå överstyr ", "Gökunge i boet ", "Göra avbön ",
			"Göra en blunder ", "Göra en fuga ", "Göra en groda ", "Göra en höna av en fjäder ", "Göra en kovändning ",
			"Göra en pudel ", "Göra en tavla ", "Göra ett klipp ", "Göra kål på någon ", "Göra någon en björntjänst ",
			"Göra någon rättvisa ", "Göra ont värre", "Göra rent hus ", "Göra sig grön ", "Göra skäl för sitt namn",
			"Göra slag i saken ", "Göra slarvsylta av någon ", "Göra upp räkningen ", "Ha det väl förspänt ",
			"Ha eld i baken ", "Ha en bulle i ugnen ", "Ha en käpphäst ", "Ha en oplockad gås med någon ",
			"Ha en räv bakom örat ", "Ha en skruv lös ", "Ha ett ess i rockärmen ", "Ha ett finger med i leken ",
			"Ha ett horn i sidan till någon ", "Ha ett välsmort munläder ", "Ha ett rött öre ", "Ha god hand med ",
			"Ha gröna fingrar ", "Ha huvudet på skaft ", "Ha ögonen på skaft ", "Ha huvudet under armen ",
			"Ha höga tankar om någon ", "Ha häcken full ", "Ha kött på benen ", "Ha alla ... ",
			"Ha alla bestick i lådan[källa behövs]",
			"Ha alla hästar i stallet[källa behövs] eller Ha alla hästar hemma[källa behövs]", "Ha alla getter hemma ",
			"Ha alla indianer i kanoten[källa behövs]", "Ha alla koppar i skåpet", "Ha alla skruvar i behåll[16]",
			"Ha en vass tunga", "Ha fått sina törnar ", "Ha is i magen ", "Ha kläm på något ", "Ha lite på fötterna ",
			"Ha långa fingrar ", "Ha långa öron ", "Ha millimetrarna på sin sida ", "Ha mycket innanför pannbenet ",
			"Ha myror i byxorna ", "Ha många bollar i luften ", "Ha många järn i elden ",
			"Ha många strängar på sin lyra ", "Ha nio liv ", "Ha något i kikaren ", "Ha något i ryggmärgen ",
			"Ha något i släptåg ", "Ha något i bagaget ", "Ha något på tungan ", "Ha något som i en liten ask ",
			"Ha några år på nacken ", "Ha näsan i vädret ", "Ha pippi på något ", "Ha på fötterna ",
			"Ha rent mjöl i påsen ", "Ha råg i ryggen ", "Ha satt sin sista potatis ", "Ha sett sina bästa dagar ",
			"Ha sitt på det torra ", "Ha skinn på näsan ", "Ha spenderbyxorna på sig ",
			"Ha sålt smöret och tappat pengarna ", "Ha siktet inställt på något ", "Ha tomtar på loftet ",
			"Ha trumf på hand ", "Ha tumme med någon ", "Ha tummen i ögat på någon ", "Ha tummen mitt i handen ",
			"Ha vaknat på fel sida ", "Ha vassa armbågar ", "Ha vind i seglen ", "Ha änglavakt ", "Ha ögon i nacken ",
			"Ha ögonen med sig", "Ha överlevt sig själv ", "Halka in på ett bananskal ", "Hals över huvud ",
			"Hamna i blåsväder ", "Hamna i knipa ", "Hamna i skymundan ", "Hamna på överblivna kartan ",
			"Han eller hon skulle inte göra en fluga förnär ", "Han eller hon spottar inte i glaset ",
			"Handen på hjärtat ... ", "Handla på eget bevåg ", "Handsken är kastad ", "Har man sagt A får man säga B ",
			"Har man tagit Fan i båten får man ro honom i land ", "Hatten av för ", "Hatt på hatt ", "Hela baletten ",
			"Hela konkarongen ", "Hellre fria än fälla ", "Helt uppåt väggarna ", "Herre på täppan ", "Het potatis ",
			"Hissen går inte hela vägen upp ", "Historien upprepar sig ", "Hittepå ",
			"Hjulet snurrar men hamstern är död ", "Hjälpa någon på traven ", "Hjärtat i halsgropen ",
			"Hjärtat på rätt ställe ", "Hoppa högt ", "Hoppa i galen tunna ", "Hoppa upp och sätta sig på något ",
			"Hoppa ur skålen ", "Hoppa över skaklarna ", "Hosta upp pengar ", "Hugga i sten ", "Hugget i sten ",
			"Hugget som stucket ", "Hur understår du dig? ", "Huvuden kommer att rulla ",
			"Hålla alla trådar i sin hand ", "Hålla fanan högt ", "Hålla god min ", "Hålla grytan kokande ",
			"Hålla hov", "Hålla hus ", "Hålla i rodret ", "Hålla i schack ", "Hålla låda ", "Hålla någon kort ",
			"Hålla masken ", "Hålla någon på halster ", "Hålla någon på sträckbänken ", "Hålla någon stången ",
			"Hålla någon bakom ryggen", "Hålla någon under armarna", "Hålla rumpan styv i kurvorna[källa behövs]",
			"Hålla skenet uppe ", "Hålla sig i skinnet ", "Hålla sig på mattan ", "Hålla sig på sin kant ",
			"Hålla ställningarna ", "Hålla tand för tunga ", "Hålla tummarna för någon ", "Hålla tungan rätt i mun ",
			"Hålla varandra om ryggen ", "Hålla ångan uppe ", "Hålla ögonen på något ", "Hålla ögonen öppna ",
			"Hårda bud i Mellerud ", "Hälla vatten på en gås ", "Hälsa hem ", "Hänga ihop som ler och långhalm ",
			"Hänga läpp ", "Hänga på ... ", "Hänga på en skör tråd", "Hänga på ett hår", "Hänga på gärsgårn ",
			"Hänga ut någon", "Här blir inga barn gjorda ", "Härtill är jag nödd och tvungen ", "Hög tid ",
			"Högsta hönset ", "Högt i tak ", "Höja någon till skyarna ", "Höja på ögonbrynen ",
			"Höjt över allt tvivel ", "Hönsgård ", "Höra från hästens mun ", "I blåsten ", "I brådrasket ",
			"I de lugnaste vatten ", "I det blå ", "I det närmaste ", "I ett nötskal ", "I godan ro ", "I grevens tid ",
			"I hatten ", "I kölvattnet ", "I laga ordning ", "I mångt och mycket ", "Inga byxor av det skinnet ",
			"Inga krusiduller ", "Inte mycket att hänga i julgranen ", "I rasande fart ", "I rätta händer ",
			"I rödaste rappet ", "I sakta mak ", "I senaste laget ", "I sin glans dagar ", "I sin krafts dagar ",
			"I sina bästa år ", "I sinom tid ", "i sista ögonblicket ", "I sitt anletes svett ", "I stort sett ",
			"I stridens hetta ", "I svinottan ", "I säkert förvar ", "I tid och otid ", "I ur och skur ",
			"Id och strid ", "Illa kvickt ", "In alles, även inalles ", "In genom ena örat och ut genom andra ",
			"Ingen dans på rosor ", "Ingen fara på taket ", "Ingen ko på isen ", "Inget man snyter ur näsan ",
			"Inget övrigt att önska ", "Inom lagens råmärken ", "Inte ett jota ", "Inte ett öga torrt ",
			"Intet nytt under solen ", "Intresseklubben antecknar ", "Intresseflagg ", "I rödaste rappet ",
			"Jämföra äpplen och päron ", "Kaka på kaka, även tårta på tårta ", "Kalv på grönbete ", "Kamma noll ",
			"Kamma hem något ", "Att misslyckas kapitalt ", "Kasta en blick", "Kasta ett getöga på någon ",
			"Kasta ett öga på någon ", "Kasta goda pengar efter dåliga ", "Kasta in handduken ",
			"Kasta ljus över något ", "Kasta loss ", "Kasta paj, även Pajkastning ", "", "Kasta pengar i sjön",
			"Kasta pengar i sjön ", "Kasta pärlor för svin ", "Kasta sten i glashus ",
			"Kasta ut barnet med badvattnet ", "Kasta veven ", "Kasta vatten ", "Kasta yxan i sjön ",
			"Katt bland hermelinerna ", "Katt på hett plåttak ", "Katten på råttan, råttan på repet ... ",
			"Kattens lek med råttan ", "Kejsarens nya kläder ", "Kila runt hörnet ", "Kila vidare ",
			"Klammeri med rättvisan ", "Klappat och klart ", "Klara strupen ", "Klart och betalt ",
			"Klart som korvspad ", "Klen i anden ", "Klen tröst ", "Klockrent ", "Klok som en pudel ",
			"Klä sig i säck och aska ", "Klä skott ", "Knaka i fogarna ", "Knalla och gå ", "Knappt om utrymme ",
			"Knyta Hymens band ", "Knyta näven i fickan ", "Knyta sig ", "Knyta till säcken ", "Knäpp på näsan ",
			"Koka soppa på en spik ", "Kokar ner till ", "Kola vippen ", "Koloss på lerfötter ", "Komma från hjärtat ",
			"Komma i bakvattnet ", "Komma på efterkälken ", "Komma på grön kvist ", "Komma på kant med någon ",
			"Komma på skam", "Komma till skott med något ", "Komma till vägs ände ", "Komma undan helskinnad ",
			"Komma undan med blotta förskräckelsen ", "Komma under lupp ", "Komma ur askan i elden ", "Kors i taket ",
			"Kosta skjortan ", "Kratta manegen ", "Krossa någons hjärta ", "Krypa till korset ",
			"Kryssa mellan Skylla och Karybdis ", "Kräla i stoftet ", "Kunna försätta berg ", "Kusten är klar ",
			"Kvällens clou ", "Kyss Karlsson! ", "Kyss mig i arslet! ", "Kyssa sin faster att kyssa sin faster ",
			"Känna hur vinden blåser ", "Känna lössen på gången ", "Känna någon på pulsen ",
			"Känna sina löss på gången ", "Känna sina pappenheimare ", "Käringen mot strömmen ",
			"Köpa grisen i säcken ", "Köra någon på porten ", "Kör i vind! ", "Kör så det ryker! ",
			"Köra huvudet i väggen ", "Körd i grus ", "Kött på benen ", "L", "Lag och ordning ",
			"Lagens arm, lagens väktare ", "Lagvrängare ", "Lapp på luckan ", "Larva sig ", "Le i mjugg ",
			"Leka med elden ", "Leka rommen av sig ", "Lengräddad ", "Leta efter en nål i en höstack ",
			"Leta efter något med ljus och lykta ", "Leva loppan ", "Leva på hoppet", "Leva som man lär ",
			"Leva under knapphetens stjärna", "Leva ur hand i mun ", "Lida mot sitt slut ", "Ligga bakom ",
			"Ligga för fäfot ", "Ligga hästlängder före ", "Ligga i ", "Ligga i lä ", "Ligga i selen ",
			"Ligga i startgroparna ", "Ligga i stöpsleven ", "Ligga lågt ", "Ligga någon i fatet ",
			"Ligga någon till last ", "Ligga någon varmt om hjärtat ", "Ligga på ", "Ligga på sofflocket ",
			"Lika goda kålsupare. ", "Lika som bär ", "Lite här och var ", "Liv i luckan ", "Livet på en pinne ",
			"Ljuga sig blå ", "Ljuga som hästar travar ", "Ljuger så han tror sig själv ",
			"Lova guld och gröna skogar ", "Lova runt och hålla tunt ", "Lova vitt och brett ", "Lugn i stormen ",
			"Lugn och ro ", "Luktar pyton ", "Lusläsa ", "Luspank ", "Luspudel ", "Lyckans ost ", "Lyfta på förlåten ",
			"Lyfta på hatten för ", "Lyfta sig själv i håret ", "Lysa med sin frånvaro ",
			"Lyset är på men det är ingen hemma ", "Lågt hängande frukt", "Långt från ära och redlighet ",
			"Låta barn vara barn ", "Låta bilan falla ", "Låta maten tysta mun ", "Låta målvakten stå i mål ",
			"Låta nåd gå före rätt ", "Låta rättvisan ha sin gång ", "Låta udda vara jämnt ",
			"Låtsas som om det regnar ", "Lägg ägg! ", "Lägga alla ägg i samma korg ", "Lägga benen på ryggen ",
			"Lägga en hämsko på något ", "Lägga fingrarna emellan ", "Lägga i malpåse ", "Lägga korten på bordet ",
			"Lägga kraft bakom orden ", "Lägga lök på laxen ", "Lägga locket på ", "Lägga manken till ", "Lägga ner",
			"Lägga något på hyllan ", "Lägga något på is ", "Lägga något på minnet ", "Lägga näsan i blöt ",
			"Lägga orden i munnen på någon ", "Lägga på en rem ", "Lägga på ett kol ", "Lägga rabarber på något ",
			"Lägga sig ner och dö ", "Lägga sig under kniven ", "Lägga sig vinn om något ",
			"Lägga sista handen vid något ", "Lägga skorna på hyllan ", "Lägga sordin på stämningen ",
			"Lägga sten på börda ", "Lägga två strån i kors ", "Lägga ut en snara för någon ", "Lägga ut texten ",
			"Lägga vantarna på något ", "Lämna någon i sticket ", "Lära någon mores ", "Lära någon veta hut ",
			"Läsa lagen för någon ", "Läsa lusen av någon ", "Läsa mellan raderna ", "Lögn och förbannad dikt ",
			"Man mot man ", "Man måste lära sig krypa innan man kan gå ",
			"Man skall köpa till sillen och sälja till kräftorna ", "Man skall leva för varandra ",
			"Man skall så med handen, inte med fulla säcken ", "Man tager vad man haver ", "Mannaminne ",
			"Man vet vad man har men inte vad man får ", "Matjord i fickorna ", "Med buller och bång ",
			"Med byxorna nere ", "Med flaggan i topp ", "Med flinka fingrar ", "Med hull och hår ",
			"Med mössan i hand ", "Med någons goda minne ", "Med näsan ovanför vattenbrynet ", "Med nöd och näppe ",
			"Med sanningen överensstämmande ", "Med varm hand ", "Medaljens baksida ", "Mellan fyra ögon ",
			"Mellan hägg och syren ", "Mellan skål och vägg ", "Mellan varven ", "Min lagvigda ", "Min tillkommande ",
			"Missa tåget ", "Mittåt! ", "Moment 22 ", "Mota Olle i grind ", "Mumla i skägget ",
			"Mycket ska man höra innan öronen faller av ", "Mycket skrik för lite ull ",
			"Mycket snack och lite verkstad ", "Mycket vatten har flutit under broarna sedan dess ",
			"Mycket väsen för ingenting ", "Myndig stämma ", "Må det bära eller brista ", "Måla fan på väggen ",
			"Måla in sig i ett hörn ", "Många hövdingar, men få indianer ", "Människans bästa vän är hunden ",
			"Möta sitt Waterloo ", "Nu gick det upp ett ljus ", "Nu går skam på torra land ",
			"Nu trillade polletten ner ", "Nu är det klippt ", "Nu är det kokta fläsket stekt ", "Nu är det kört ",
			"Nu är goda råd dyra ", "Nu är jag ute på okänt vatten ", "Nu är måttet rågat ", "Någonting är ruttet ",
			"Något har sett dagens ljus ", "Något i hästväg ", "Något som katten släpat in ", "När andan faller på ",
			"När det kommer till kritan ", "När krubban är tom bits hästarna",
			"När skoputsarna frågar om aktietips är det dags att sälja ", "När Adam var länsman ",
			"Nära en orm vid sin barm ", "Närma sig med stormsteg ", "Nästa år i Jerusalem ", "Odla sin kål ",
			"Om inte om hade funnits ", "Ord står mot ord ", "Ord och inga visor ",
			"Ordning och reda, pengar på freda' ", "Ormens väg på hälleberget ", "Osa katt ", "Osa svavel ",
			"Osvuret är bäst ", "Pang på rödbetan ", "Peka med hela handen ", "Pengar luktar inte ",
			"Peppar, peppar, ta i trä ", "Pest eller kolera ", "Pigg som en mört ", "Plattan i mattan ",
			"Plocka russinen ur kakan ", "Polsk riksdag ", "Pompa och ståt ", "Praktiskt taget ", "Prata bredvid mun ",
			"Prata goja ", "Prata i nattmössan ", "Prata i vädret ", "Prata i munnen på varandra ", "Prata smörja ",
			"Pricken över i:et. ", "Privatlivets helgd ", "Puckla på ", "Pudelns kärna ", "På alla fyra ",
			"På det hela taget ", "På en höft ", "På ett bräde ", "På fallrepet ", "På fem röda ", "På G ",
			"På gräsrotsnivå ", "På kornet ", "På löpande band ", "På lösa boliner ", "På måfå ", "På papperet ",
			"På pickalurven ", "På pin kiv ", "På pricken ", "På rak arm ", "På sandlådenivå ", "På sin mammas gata ",
			"På sin höjd ", "På stående fot ", "På tu man hand ", "Rammelbuljong ", "Raska gossar ",
			"Regnet står som spön i backen ", "Rena rama ... ", "Rent ryskt ", "Resa ragg",
			"Resa sig som fågel Fenix ur askan ", "Reta gallfeber på någon ", "Rida ut en storm ", "Rim och reson ",
			"Rimmar illa ", "Rinna ut i sanden ", "Ris och ros ", "Rubb och stubb ", "Rulla hatt ", "Rulla på ",
			"Rulla tummarna ", "Rund under fötterna ", "Rundligt tilltagen summa ", "Rymma fältet ",
			"Råda bot på något ", "Råka i luven på varandra ", "Råttorna lämnar ett sjunkande skepp ",
			"Räfst och rättarting ", "Ränderna går aldrig ur ", "Rätt skall vara rätt ", "Rätt och riktigt ",
			"Rätta mun efter matsäcken ", "Röd tråd ", "Röra runt i grytan ", "Röra upp himmel och jord ",
			"Rörd till tårar ", "Sagt och gjort ", "Saken är biff ", "Sakta i backarna ", "Sakta men säkert ",
			"Satsa på fel häst ", "Samla i ladorna ", "Sanningens minut ", "Sans och balans ", "Sansa sig ",
			"Se en levande själ ", "Se färg torka ", "Se ljuset i tunneln ", "Se längre än näsan räcker ",
			"Se med blida ögon på ", "Se mellan fingrarna ", "Se om sitt hus ", "Se spöken mitt på ljusa dagen ",
			"Se röken av ", "Se rött ", "Se sanningen i vitögat ", "Se sig i månen efter något ",
			"Se skogen för alla träd ", "Se ut som sju svåra år ",
			"Sedan dess har det flutit mycket vatten under broarna ", "Sedan Eldkvarn brann[källa behövs] ",
			"Sent omsider ", "Serverat som på silverfat ", "Sila mygg och svälja kameler ", "Simma med strömmen ",
			"Sin beskärda del ", "Sin glans dagar ", "Sina nära och kära ", "Sist men inte minst ",
			"Sista spiken i kistan ", "Sitta hemma och uggla ", "Sitta hårt åt ", "Sitta i klistret ",
			"Sitta i knät på någon ", "Sitta i samma båt ", "Sitta i väggarna ", "Sitta inne ", "Sitta och häcka ",
			"Sitta och mögla ", "Sitta i smöret ", "Sitta på pottkanten ", "Sitta på sina höga hästar ",
			"Sitta på två stolar samtidigt, även Sitta på dubbla stolar ", "Sitta still i båten ",
			"Sitta säkert i sadeln ", "Sju sorger och åtta bedrövelser ", "Sju svåra år ", "Sjunga på sista versen ",
			"Skaka galler ", "Skaka något ur ärmen ", "Skam till sägandes ", "Skapelsen ", "Skapelsens krona ",
			"Skarp penna penna ", "Skarpt läge ", "Ske med någons goda minne", "Skelett i garderoben ",
			"Skepp utan roder ", "Skilja agnarna från vetet ", "Skinn på näsan ", "Skita i det blå skåpet ",
			"Skitprat, Pratar skit ", "Skjuta mygg med kanoner ", "Skjuta sig själv i foten ", "Sko sig ",
			"Skratta hela vägen till banken ", "Skrida till verket ", "Skrika för full hals ", "Skrika i högan sky ",
			"Skriva någon på näsan ", "Skriva under på något ", "Skräckblandad förtjusning ", "Skräda orden ",
			"Skynda långsamt ", "Skära pipor i vassen", "Skåda inte en given häst i munnen ", "Skämmas ögonen ur sig ",
			"Skörda sina frukter ", "Skörda offer ", "Slag under bältet ", "Slaven på triumfvagnen ",
			"Slicka någon i arslet m", "Slira på sanningen ", "Slit den med hälsan! ", "Slita hund ", "Slita ont ",
			"Sluta leden ", "Slå blå dunster i ögonen på någon ", "Slå dank ", "Slå dig i backen på ",
			"Slå dövörat till ", "Slå en sjua ", "Slå en parabel ", "Slå ett slag för något ", "Slå huvudet på spiken ",
			"Slå i taket ", "Slå in öppna dörrar ", "Slå klackarna i taket ", "Slå knut på sig själv ",
			"Slå lock för öronen ", "Slå mynt av något ", "Slå ner sina bopålar ", "Slå någon gul och blå ",
			"Slå någon sönder och samman ", "Slå näven i bordet ", "Slå på stora trumman ", "Slå på stort ",
			"Slå sig för bröstet ", "Slå sig i slang med ", "Slå sig sönder och samman ", "Slå sina påsar ihop ",
			"Slå två flugor i en smäll ", "Slå vakt om något ", "Slå vantarna i bordet ", "Slås av något ",
			"Släkten är värst ", "Släta över något ", "Smakar det så kostar det ", "Smida medan järnet är varmt ",
			"Sminka en påve ", "Smockan hänger i luften ", "Smolk i glädjebägaren ", "Smäll på fingrarna ",
			"Smörja kråset ", "Smörklick på het potatis ", "Sol ute, sol inne. Sol i hjärta, sol i sinne ",
			"Sola sig i sin egen glans", "Som ett torrt skinn ", "Som fan läser Bibeln ", "Sopa golvet med någon ",
			"Sopa problemet under mattan ", "Sopa rent framför sin egen dörr ", "Sova på saken ",
			"Spara på krutet inte på krutet ", "Sparv i tranedansen ", "Spel för galleriet", "Spel bakom kulisserna ",
			"Spela Allan ", "Spela andrafiolen ", "Spela ett högt spel ", "Spela i samma division ",
			"Spela sina kort väl ", "Spela under täcket med någon ", "Spetsa öronen ", "Spindeln i nätet ",
			"Spotta i nävarna ", "Sprids som askan för vinden ", "Sprillans, sprillans ny ", "Springande punkten ",
			"Spritt språngandes naken ", "Spänna bågen för högt ", "Stick i stäv mot ", "Sticka huvudet i sanden ",
			"Sticka i ögonen ", "Sticka under stol med ", "Sticka ut hakan ", "Stiga åt huvudet ",
			"Stirra sig blind på något ", "Stolt som en tupp ", "Storm i ett vattenglas ", "Strama tyglar ",
			"Strid på kniven ", "Strida om påvens skägg ", "Stryka med ", "Stryka någon medhårs ",
			"Stryka på fötterna ", "Sträcka vapen ", "Strö pärlor för svinen ", "Strö salt i såren ", "Styv i korken ",
			"Styv i nacken ", "Stå för fiolerna ", "Stå handfallen ", "Stå i ljusan låga ", "Stå i rampljuset ",
			"Stå i skottgluggen ", "Stå i valet och kvalet ", "Stå inför skranket ", "Stå med armarna i kors ",
			"Stå med båda fötterna på jorden ", "Stå med mössan i näven ", "Hamna med skägget i brevlådan ",
			"Stå med två tomma händer ", "Stå med tvättad hals ", "Stå och väga ", "Stå pall för något ",
			"Stå på egna ben ", "Stå på god fot med någon ", "Stå på näsan ", "Stå på spel ", "Stå på sig ",
			"Stå på öronen ", "Stå sitt kast ", "Stå som fallen från skyarna ", "Stå upp i halsen ",
			"Stå vid skampålen ", "Stånga hornen av sig ", "Stånga sig blodig ", "Ställa någon mot väggen ",
			"Ställa sig i skamvrån ", "Ställa till svars ", "Ställas i dålig dager ", "Stämma i bäcken ",
			"Stöpt i samma form ", "Störst och värst i hela Bofors ", "Stöta och blöta något ", "Stöta på patrull ",
			"Stötts och blötts ", "Suga på karamellen ", "Suga på ramarna ", "Summa summarum ", "Surfa på nätet ",
			"Svagaste länken i kedjan ", "Svansen mellan benen ", "Svarta fåret ", "Svarte Petter ", "Svida i skinnet ",
			"Svårfjällad fisk ", "Svälja det beska pillret ", "Svära i kyrkan ", "Sväva i ovisshet ",
			"Sväva mellan liv och död ", "Sväva på moln ", "Sväva på målet ", "Sväva på rosa moln ", "Syna i sömmarna ",
			"Synd på så rara ärtor ", "Synda på nåden ", "Syndabock ", "Så gott som ", "Så in i Norden ",
			"Så in i vassen ", "Så nära sanningen man kan komma ", "Så sant som det är sagt ", "Så split ",
			"Så sin vildhavre ", "Så tyst att man kan höra en knappnål falla ", "Sålt smöret och tappat pengarna ",
			"Såga någon vid fotknölarna ", "Sånt är livet ", "Såsom i en spegel ", "Säga ifrån på skarpen ",
			"Säga flaska ", "Säker i sadeln ", "Säker på sin sak ", "Säkert som amen i kyrkan ",
			"Sätta bocken till trädgårdsmästare ", "Sätta en rova ", "Sätta fingret på något ", "Sätta in nådastöten ",
			"Sätta käppar i hjulet ", "Sätta livet till ", "Sätta munkavle på någon ",
			"Sätta myror i huvudet på någon ", "Sätta ner foten ", "Sätta någon på det hala ",
			"Sätta någon på piedestal ", "Sätta någon på plats ", "Sätta någon på potta ", "Sätta något på kartan ",
			"Sätta något på spel ", "Sätta något under lupp ", "Sätta p för något ", "Sätta punkt för något ",
			"Sätta sig på bakhasorna ", "Sätta sig på höga hästar ", "Sätta sig på tvären ",
			"Sätta sitt ljus under skäppan ", "Sätta sprätt på pengarna ", "Sätta till alla klutar ",
			"Sätta värde på något ", "Söndra och härska ", "Ta bladet från munnen ", "Ta pucken ", "Ta den i tvåan ",
			"Ta det kallt ", "Ta det lite pö om pö ", "Ta det långa benet före ", "Ta det med en klackspark ",
			"Ta det med ro ", "Ta det piano ", "Ta det säkra före det osäkra eller Ta det säkra för det osäkra ",
			"Ta det vackert ", "Ta en i det andra benet också ", "Ta en kula för någon ", "Ta en repa ",
			"Ta en ände med förskräckelse ", "Ta för sig ", "Ta för stora ord i sin mun ", "Ta gift på något ",
			"Ta hus i helsike ", "Ta höjd för något ", "Ta i med hårdhandskarna ", "Ta i med silkesvantarna ",
			"Ta i så man spricker ", "Ta igen på gungorna vad man förlorat på karusellen ", "Ta korn på ",
			"Ta kål på någon ", "Ta musten ur någon", "Ta ner skylten ", "Ta någon i hampan ", "Ta någon i örat",
			"Ta något med en nypa salt ", "Ta något för givet ", "Ta om 'et från början ", "Ta på kornet ",
			"Ta saken i egna händer ", "Ta seden dit man kommer ", "Ta sig en funderare ", "Ta sig en styrketår ",
			"Ta sig för stora friheter ", "Ta sig i kragen ", "Ta sig vatten över huvudet ", "Ta sin Mats ur skolan ",
			"Ta sitt förnuft till fånga", "Ta skeden i vacker hand ", "Ta skruv ", "Ta steget fullt ut ",
			"Ta till storsläggan ", "Ta tjuren vid hornen ", "Ta ur bruk ", "Tacka sin lyckliga stjärna ",
			"Tagen på sängen ", "Tala ett annat språk ", "Tala för döva öron ", "Tala klarspråk ",
			"Tala med bönder på bönders vis och med de lärde på latin ", "Tala med kluven tunga ", "Tala till punkt ",
			"Tala ur skägget ", "Tappa ansiktet ", "Tappa greppet ", "Tappa hakan ", "Tappa huvudet ",
			"Tappa koncepten ", "Tappa målföret ", "Tappad bakom en vagn ", "Tiden har runnit ut ", "Tidens tand ",
			"Tids nog ", "Till det yttersta ", "Till råga på allt ", "Till sista andetaget ", "Till syvende och sist ",
			"Till yttermera visso ", "Timglaset är fullt ", "Titta för djupt i glaset", "Titta snett på någon",
			"Tolv öl räcker till alla ", "Tomma ord ", "Tomt i ladan", "Toppa laget ", "Trampa i klaveret ",
			"Trampa inte rödbetor i mossen ", "Trampa på en öm tå ", "Trampa spiken i botten ", "Trampa vatten ",
			"Tredje gången gillt ", "Tretton på dussinet ", "Trilla av pinn ", "Trolla med knäna ",
			"Tror, det gör man i kyrkan ", "Trycka ner i skoskaften ", "Trångt om saligheten ", "Träffa den rätta ",
			"Tröst för tigerhjärtan", "Tulipanaros ", "Tummen i ögat ", "Tupp i halsen ", "Tvätta pengar ",
			"Tvätta sin smutsiga byk", "Tycka skjortan är trång ", "..., tyckte stämman ",
			"Tystnaden talar för sig själv ", "Två sidor av samma mynt ", "Två sina händer ", "Tår på tand ",
			"Tårta på tårta ", "Tända på alla fyra eller Tända på alla cylindrar ", "Tälja guld med pennkniv ",
			"Tänka fritt är stort, men tänka rätt är större ", "Tänk först och tala sen ", "Tänka på refrängen ",
			"Täppa till munnen på någon ", "Tärningen är kastad ", "Tömma den bittra kalken", "Ulv i fårakläder ",
			"Undantaget som bekräftar regeln ", "Underbart är kort ", "Upp på koturnen ", "Uppe med tuppen ",
			"Uppfinna hjulet på nytt ", "Ur askan i elden ", "Ur fas ", "Ur gängorna ", "Ur led är tiden ", "Ur spel ",
			"Utan att darra på manschetten ", "Utan en tråd på kroppen ", "Utan mål och mening ", "Utan pardon ",
			"Utan styrfart ", "Utan ände ", "Ute och cykla ", "Ute på djupt vatten ", "Ute på hal is ", "Vacker tass ",
			"Vad gäspar skårpan? ", "Vad övrigt är, är tystnad ", "Vad våldet må skapa är vanskligt och kort ",
			"Vakta sin tunga ", "Var och en är salig på sin tro ", "Vara av det rätta virket ",
			"Vara den förste som ... ", "Vara den som är den ", "Vara du och bror med någon ", "Vara dummare än tåget ",
			"Vara dödens lammunge ", "Vara för handen ", "Vara grov i munnen ", "Vara grönt ", "Vara haj på ",
			"Vara herre i sitt eget hus ", "Vara helt under isen ", "Vara het på gröten ", "Vara hugget som stucket ",
			"Vara hundra på ", "Vara höljt i dunkel ", "Vara i en annan värld ", "Vara i faggorna ", "Vara i farten",
			"Vara i hetluften ", "Vara i krokarna ", "Vara i någons kläder ", "Vara i någons tankar ", "Vara i ropet ",
			"Vara i sin linda ", "Vara i sitt esse ", "Vara i sitt rätta element ", "Vara i sjunde himlen ",
			"Vara igång", "Vara karl för sin hatt ", "Vara körd i botten", "Vara lätt på foten",
			"Vara med på ett hörn ", "Vara med på noterna ", "Vara med på tåget", "Vara nära ögat ",
			"Vara om sig och kring sig ", "Vara på allas läppar ", "Vara på den säkra sidan ", "Vara på efterkälken",
			"Vara på fallrepet ", "Vara på fri fot ", "Vara på glid", "Vara på hugget ", "Vara på håret ",
			"Vara på kanelen ", "Vara på krigsstigen ", "Vara på resande fot ", "Vara på samma våglängd ",
			"Vara på sin vakt ", "Vara på smällen ", "Vara på språng", "Vara på tapeten", "Vara på upphällningen ",
			"Vara på vippen ", "Vara rakryggad eller Vara rak i ryggen ", "Vara rund under fötterna ",
			"Vara satt på bar backe ", "Vara sig själv nog ", "Vara sig själv närmast ", "Vara sin egen lyckas smed ",
			"Vara skarpaste kniven i lådan[källa behövs] ", "Vara skrivet i stjärnorna ", "Vara som gjord för något ",
			"Vara som klippt och skuren för något ", "Vara stadd vid kassa ", "Vara surrad vid masten",
			"Vara tillbaka på ruta ett ", "Vara topp tunnor rasande ", "Vara torr bakom öronen ",
			"Vara tu tal om något ", "Vara under uppsegling ", "Vara ute efter något", "Vara ute i kylan ",
			"Vara ute i ogjort väder ", "Vara ute på tunn is ", "Vara utom sig av vrede ", "Vara uppe med tuppen ",
			"Vara vid sina sinnens fulla bruk ", "Vara vid sunda vätskor ", "Vara värt papperet det är skrivet på ",
			"Vara yr i mössan ", "", "Varje moln har en silverkant", "Varför är allt en trasa? ",
			"Varje moln har en silverkant ", "Varken bu eller bä ", "Varken hackat eller malet ", "Varm i kläderna ",
			"Varm om hjärtat ", "Verkligheten överträffar dikten ", "Veta hur en slipsten ska dras ", "Veta hut ",
			"Veta vad klockan är slagen ", "Veta var skon klämmer ", "Vi är alla olika i Herrens hage ",
			"Vila på hanen", "Vila på sina lagrar ", "Vilja sjunka genom jorden ",
			"Vind för våg eller Driva vind för våg ", "Visa framfötterna ", "Visa sig från sin goda sida ",
			"Visa sig på styva linan ", "Visa tänderna ", "Visa var skåpet ska stå ", "Vit vecka ", "Väcka ont blod",
			"Vädra morgonluft ", "Väga sina ord på guldvåg ", "Väggarna har öron ", "Vältra sig i pengar ",
			"Vända andra kinden till ", "Vända blad ", "Vända kappan efter vinden ", "Vända på klacken",
			"Vända på kuttingen ", "Vända på slantarna ", "Vända på steken ", "Vända på varje sten ",
			"Vässa sina knivar ", "Växa så det knakar ", "Yr i bollen ", "Yr i mössan ", "ka på en blåsning ",
			"ångest, ångest är min arvedel ", "återfå fattningen ", "återgå till sina rötter ", "åt fanders ",
			"åt pipsvängen ", "äkta hälft ", "ända in i Hälsingland ", "ända in i kaklet ",
			"ända ut i fingerspetsarna ", "äpplet faller inte långt från trädet ", "ära den som äras bör ",
			"äta någon ur hus och hem ", "äta någon ur huset ", "äta upp vad man sagt eller gjort ",
			"äter allt, tycker mycket om barn ", "även du Brutus? ", "öga för öga, tand för tand ", "ögonaböj ",
			"öppna korpgluggarna ", "örnkoll ", "överförfriskad ", "över huvud taget ", "över min döda kropp ",
			"över lag ", "överlevt sig själv ", "över sig given " };

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		// loopen är till för att man ska kunna spela igen utan att starta om koden
		while (true) {
			System.out.println("kena kompis dags att hänga gubbe");
			System.out.println("vill tu testa supersvåra versionen med uttryck istället?");
			System.out.println("(ja) (nej)");

			// Här slumpas ett ord eller uttryck från en av listorna
			String hemligt;
			if (yesNo()) {
				hemligt = uttryck[(int) (Math.random() * uttryck.length)];
			} else {
				hemligt = words[(int) (Math.random() * words.length)];
			}

			// en sak gick fel med hämtningen av ord och det här var det
			// snabbaste sättet för mig att fixa det, men inte för datorn
			hemligt = fixaSaken(hemligt);
			String hemligt2 = hemligt;

			// kom på att dessa tecken kan kommit med och strular med saker och sånt du vet
			// ting så där som det gör ofta ibland
			hemligt = hemligt.replaceAll("'", "");
			hemligt = hemligt.replaceAll(",", "");

			// Här hämtas en integer in som används senare
			int försök;
			System.out.println("Hur många försök ska du ha?");
			do {
				System.out.println("(skriv en positiv int)");
				försök = inInt(scn.nextLine());
			} while (försök < 1);

			// Vet är en string som just nu innehåller en " _" eller " " per char i hemligt

			String vet = "";
			for (int i = 0; i < hemligt.length(); i++) {
				if (hemligt.charAt(i) != ' ') {
					vet = vet.concat("_ ");
				} else {
					vet = vet.concat("  ");
				}
			}

			// asciiart är en tom char[][] som kommer att fyllas med chars när ett fel svar
			// ges och sedan printas.

			char[][] asciiart = new char[8][12];

			// asciiSet metoden fyller upp asciiart tills antalet chars kvar är samma som
			// antalet försök med hjälp av int drag.
			// Jag vet inte om det hade varit snabbare att bara använda integern försök, och
			// konvertera den till drag när det behövs

			int drag = asciix.length - försök - 1;
			for (int x = 0; x < drag; x++) {
				asciiSet(asciiart, x);
			}

			// String gissat kommer att användas nedanför för att komma ihåg användarens
			// tidigare gissningar

			String gissat = "";

			// Jag tror printaMassaTommaRader metoden förklarar sig själv
			// Jag kanske skulle ha använt den där konsolen ni gav oss, men det här funkar
			// helt okej om din skärm inte är för hög

			printaMassaTommaRader();

			// asciiPrint för att visa den fina gubben
			asciiPrint(asciiart, drag);

			while (true) {

				System.out.println(vet);
				System.out.println("Antal försök kvar: " + försök);
				System.out.println("Vill du gissa hela? (ja), (nej)");
				if (yesNo()) {
					String answer;

					// Answer metoden gör så att loopen bara slutar om answer blir en String med
					// endast bokstäver.
					// inte helt nödvändigt, men jag skrev det och det funkar
					do {
						System.out.println("ge mig en string med bara bokstäver");
						answer = scn.nextLine();
					} while (!answer(answer));

					// om användaren använde stora bokstäver eller mellanslag på början eller slutet
					// fixar fixaSaken detta
					answer = fixaSaken(answer);

					// nu kan man jämföra
					if (answer.equals(hemligt)) {
						System.out.println("du gissade rätt och vann");
						System.out.println("svaret var alltså: " + hemligt2);
						break;
					} else {
						printaMassaTommaRader();
						System.out.println("du gissade inte rätt tyvärr");
						drag++;
						försök--;
						asciiPrint(asciiart, drag);
					}
				} else {
					String that;

					// här kommer du inte ut ifrån om svaret ligger i gissat, eller
					// svaret är en tom rad
					// jag ville ha mera tester, men det lyckades inte av någon anledning
					do {
						System.out.println("Gissa på en bokstav.");
						System.out.println("Dina tidigare gissningar är:");
						System.out.println(gissat);
						that = scn.nextLine();
						if (that.length() == 0) {
							continue;
							
						}
						that = that.substring(0, 1);
						that = that.toUpperCase();
					} while (gissat.contains(that) || !Pattern.matches("[A-ZÅÄÖ]+", that.substring(0, 1)));

					// nu är din nya char i gissat stringen
					gissat = gissat.concat(" " + that);

					// för att se om that finns i hemligt måste vi ha den i små bokstäver
					that = that.toLowerCase();
					int hm = hemligt.indexOf(that);

					// om hm är -1 betyder det att hemligt.indexOf(that) inte hittade något och
					// gissningen var fel
					if (hm > -1) {

						// här tas alla instanser av that i hemligt och lägger till that i vet där de
						// finns i hemligt
						String that2 = that.toUpperCase();
						String temp = hemligt;
						do {
							vet = vet.substring(0, hm * 2) + that2 + vet.substring(hm * 2 + 1);
							temp = temp.substring(0, hm) + " " + temp.substring(hm + 1);
							hm = temp.indexOf(that);
						} while (hm > -1);

						// om vet inte längre har några underscores är hemligt hittat och spelaren
						// vinner
						if (!vet.contains("_")) {
							System.out.println("nämen där har du ju svaret");
							System.out.println("svaret var alltså: " + hemligt2);
							break;
						}

						// annars fortsätter spelet utan att ett försök drags
						printaMassaTommaRader();
						System.out.println("nämen du gissade rätt ändå");
						asciiPrint(asciiart, drag);
						continue;
					}

					// om hm då är -1 dras ett försök och ett drag läggs till
					printaMassaTommaRader();
					System.out.println("du gissade fel");
					drag++;
					försök--;
					asciiPrint(asciiart, drag);
				}

				// nu i slutet av loopen ser vi om försök har nått 0 och breakar i så fall
				if (försök == 0) {
					System.out.println("oj du förlorade, försöken tog slut");
					System.out.println("svaret var: " + hemligt2);
					break;
				}
			}

			// om användaren svarar nej breakar loopen och programmet säjer hejdå
			System.out.println("Vill du spela igen? (ja), (nej)");
			if (!yesNo()) {
				System.out.println("hejdå");
				break;
			}
		}
		scn.close();
	}

	public static int inInt(String in) {

		// Character.getNumericValue(Char) ger -1 eller högre än 9 om charen inte är 1-9
		// I så fall returnas -1 för att visa att Stringen inte är ett heltal
		// annars så läggs charen till på rätt plats i integern som returnas
		int out = 0;
		for (int i = 0; i < in.length(); i++) {
			int p = Character.getNumericValue(in.charAt(i));
			if (p > 9 || p == -1) {
				return -1;
			} else {
				out += (int) Math.pow(10, in.length() - 1 - i) * p;
			}
		}
		return out;
	}

	public static void asciiPrint(char[][] asciiart, int drag) {

		// Om drag är mindre än noll betyder det att användaren har valt så många försök
		// att charsen i asciiart inte räcker till för varje försök
		// Det finns mer chars i ascii än bokstäver i alfabedet dock så det är ganska
		// meningslöst
		if (drag < 0) {
			return;
		}

		// AsciiSet fixar asciiart så att en till char läggs till, och sedan printas den
		asciiSet(asciiart, drag);
		for (int y = 0; y < asciiart.length; y++) {
			for (int x = 0; x < asciiart[y].length; x++) {
				System.out.print(asciiart[y][x]);
			}
			System.out.println();
		}
	}

	public static void asciiSet(char[][] asciiart, int försök) {

		// Jag såg till att index x i asciix och asciiy (int[]) ger koordinater för
		// platsen där nästa char som ska läggas till ligger i ascii (char[][])

		int cy = asciiy[försök], cx = asciix[försök];
		asciiart[cy][cx] = ascii[cy][cx];
	}

	public static boolean answer(String answer) {

		// jag hittade på google, java metoden Pattern.matches som här undersöker om
		// alla charsen i en string är bokstäver eller space, med äåö lagt till
		return Pattern.matches("[a-zA-ZåäöÅÄÖ ]+", answer);
	}

	public static boolean yesNo() {

		// Denna metod fortsätter i eviget om String input = scn.nextline() inte blir ja
		// eller nej
		// om input är ja returnas true och false om input är nej
		Scanner scn = new Scanner(System.in);
		String input;
		while (true) {
			input = scn.nextLine();
			input = input.toLowerCase();
			if (answer(input)) {
				if (input.equals("ja")) {
					System.out.println("du svarade ja");
					return true;
				} else if (input.equals("nej")) {
					System.out.println("du svarade nej");
					return false;
				}
			}
			System.out.println("du skrev lite fel");
		}
	}

	public static void printaMassaTommaRader() {

		// denna metod skriver 28 tomma rader
		for (int y = 0; y < 28; y++) {
			System.out.println();
		}
	}

	public static String fixaSaken(String hemligt) {
		hemligt = hemligt.toLowerCase();
		while (hemligt.charAt(0) == ' ') {
			hemligt = hemligt.substring(1);
		}
		while (hemligt.charAt(hemligt.length() - 1) == ' ') {
			hemligt = hemligt.substring(0, hemligt.length() - 1);
		}
		return hemligt;
	}
}