package oooooooo;

import java.util.Scanner;
import java.util.regex.Pattern;

public class h�ngande_av_gubbe {

	// H�r har vi asciiart ev en fullt h�ngd gubbe och listor f�r koordinaterna f�r
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

	// H�r �r alla orden som programmet slumpar mellan
	static String[] words = { "hej", "jag", "du", "�r", "tack", "och", "bra", "det", "har", "p�", "vad", "�lskar", "en",
			"dig", "till", "inte", "jag �lskar dig", "knulla", "kuk", "i", "hur", "ska", "fitta", "om", "vill", "att",
			"som", "s�t", "kan", "med", "puss", "min", "f�r", "�lskling", "din", "mycket", "kram", "var", "n�r",
			"hej d�", "ja", "vi", "snygg", "g�r", "mig", "nej", "s�", "bara", "ha", "sverige", "nu", "k�rlek", "�lska",
			"sex", "men", "hejd�", "saknar", "fan", "snart", "hora", "b�g", "god jul", "tr�tt", "f�r", "m�r", "g�",
			"vara", "fr�n", "den", "bajs", "ett", "lite", "tycker", "d�", "lagom", "snygging", "av", "s�tnos", "k�t",
			"vad g�r du", "h�lsningar", "mamma", "jag heter", "kanske", "ocks�", "holl�ndska", "glad", "bil", "kul",
			"vet", "gillar", "h�r", "sn�ll", "eller", "f�", "katt", "man", "ni", "h�st", "varf�r", "dum", "mat",
			"jag �r", "ta", "m�ste", "vars�god", "heter", "hoppas", "�l", "idag", "hund", "grattis", "du �r", "sova",
			"snopp", "�r", "tv�", "alla", "de", "flicka", "allt", "ledsen", "prata", "igen", "n�gon", "g�r", "han",
			"skit", "b�st", "dag", "god morgon", "k�r", "hus", "kyss", "holland", "se", "roligt", "stor",
			"nederl�ndska", "tjej", "het", "god natt", "bli", "f�rl�t", "sedan", "�ta", "skola", "utan", "gott", "tre",
			"skulle", "mitt", "hem", "innan", "blir", "d�r", "finns", "underbar", "komma", "inget", "kom", "god", "ful",
			"hejsan", "ingen", "bor", "trevlig", "fin", "er", "sv�rt", "hon", "barn", "svenska", "fotboll", "v�n",
			"ses", "efter", "pojke", "jul", "rolig", "vem", "vid", "j�vla", "fel", "svensk", "m�nga", "n�got", "�ka",
			"spr�k", "resa", "f�rst�r", "tror", "aldrig", "tillbaka", "nog", "bok", "r�tt", "l�get", "gott nytt �r",
			"�ven", "f�rst�", "sn�lla", "�n", "liten", "hj�rta", "sluta", "helvete", "l�ra", "h�lsa", "ord", "redan",
			"k�nner", "fyra", "visa", "ju", "kvar", "ge", "rumpa", "kompis", "l�tt", "gammal", "ordbok", "skicka",
			"hemma", "ganska", "fem", "ko", "penis", "skriva", "�nd�", "okej", "cykel", "genom", "fortfarande", "v�r",
			"goddag", "n�stan", "sov gott", "br�st", "godnatt", "sakna", "l�mna", "tr�kigt", "kille", "sexig", "elak",
			"bord", "�nskar", "fisk", "mot", "godmorgon", "r�v", "jag saknar dig", "tack s� mycket", "van", "namn",
			"fick", "kort", "full", "beh�ver", "springa", "gris", "va", "hall�", "sju", "under", "imorgon", "t�nt",
			"dator", "tar", "l�gga", "hitta", "arg", "spela", "k�nna", "tro", "�tta", "tjena", "dom", "fram", "hos",
			"vatten", "sk�l", "flytta", "sug", "d�lig", "fr�ga", "titta", "pappa", "eftersom", "dra", "l�genhet",
			"g�ng", "andra", "s�tt", "vart", "god dag", "vad heter du", "duktig", "ber�tta", "tyv�rr", "d�rf�r",
			"v�ldigt", "�t", "ser", "l�sa", "samma", "korv", "l�ngtar", "pojkv�n", "d�", "sen", "t�nker", "morgon",
			"ig�r", "bild", "godis", "gullig", "�nnu", "svart", "detta", "slicka", "du �r s�t", "svar", "vilja",
			"varje", "s�ga", "runka", "ibland", "tio", "tala", "v�nta", "kv�ll", "helg", "v�l", "byta", "nio", "slut",
			"hatar", "syster", "dock", "ost", "suga", "fast", "l�rdag", "�ver", "sol", "g�rna", "vi ses", "gilla",
			"lycka", "bror", "varit", "samlag", "k�ra", "sov", "pratar", "fredag", "tid", "j�vlar", "musik",
			"�lskar dig", "ok", "m�l", "hj�lp", "kaffe", "fint", "liv", "suger", "h�lla", "sj�lv", "svara", "urs�kta",
			"sl�", "rum", "ljus", "trevligt", "k�pa", "f�retag", "dricka", "�ker", "stad", "tr�ffa", "ny", "annars",
			"sommar", "glass", "b�t", "tillsammans", "tyst", "l�rare", "mina", "anv�nda", "stol", "jag �lskar", "sa",
			"b�sta", "hela", "f�delsedag", "fru", "ont", "skatt", "jag gillar dig", "verkligen", "hoppa", "onsdag",
			"jag vill", "lugn", "apa", "enda", "gjort", "kramar", "s�ndag", "blev", "kvinna", "aff�r", "senare", "�",
			"sjuk", "stanna", "sk�nt", "v�nner", "bo", "tur", "olika", "tr�d", "j�tte", "ditt", "mellan", "synd", "ut",
			"konstig", "sn�", "sant", "land", "ofta", "bort", "neger", "f�r att", "t�g", "utanf�r", "r�dd", "tr�kig",
			"ha det bra", "�", "s�rskilt", "dessutom", "leka", "k�r", "hade", "in", "djur", "nyfiken", "potatis",
			"middag", "lycka till", "h�r", "v�der", "semester", "h�mta", "f�nster", "b�rja", "s�ng", "d�d", "problem",
			"r�d", "m�ndag", "torsdag", "betyder", "b�da", "natt", "st�da", "orka", "tycka", "lika", "ligger",
			"f�rs�ka", "trots", "lugnt", "b�ttre", "sover", "s�g", "stj�rna", "endast", "hungrig", "pengar", "flera",
			"precis", "ingenting", "fest", "m�", "jo", "visst", "hit", "sv�r", "veta", "h�ll", "inga", "vecka", "�pple",
			"v�gg", "b�r", "medan", "huvud", "v�g", "kl�der", "dej", "h�ller", "bot", "skog", "gick", "jag har", "h�ra",
			"vit", "tycker om", "bl�", "verkar", "tjock", "arbete", "kolla", "trivs", "dem", "f�tt",
			"jag tycker om dig", "hur �r det", "jobb", "heller", "sitta", "brukar", "skratta", "spelar", "gud", "tak",
			"d�ligt", "kn�pp", "hans", "del", "ren", "jag m�r bra", "blomma", "hand", "d�rr", "vilken", "gul", "gr�ta",
			"gl�mma", "oss", "tr�na", "l�ng", "dit", "emot", "bajsa", "k�tt", "st�r", "engelska", "kunde", "dr�m",
			"�gon", "f�rutom", "�lg", "is", "annat", "k�k", "bada", "tycka om", "deras", "t�nka", "cool", "kaka", "l�t",
			"�ngel", "ensam", "v�lja", "faktiskt", "ikv�ll", "h�lsning", "h�nder", "skor", "vissa", "familj", "l�r",
			"heja", "upp", "glas", "talar", "lyssna", "stora", "tv", "denna", "sj�lvklart", "sk�n", "god kv�ll",
			"skolan", "nederl�nderna", "br�d", "mus", "gurka", "stolt", "l�cker", "sur", "tidigare", "brev", "d�da",
			"kissa", "m�te", "vila", "�ter", "inom", "b�de", "h�st", "sko", "ligga", "gifta", "best�mma", "bakom",
			"sj�", "sida", "reda", "naken", "honom", "�ger", "kukhuvud", "ringa", "gr�t", "ih�g", "�nda", "val",
			"pussar", "l�ngta", "telefon", "�mne", "flickv�n", "framf�r", "varken", "banan", "r�d", "h�ger", "det �r",
			"vanlig", "laga", "m�nniskor", "ute", "saker", "intressant", "p�sk", "f�rst", "ledig", "mj�lk", "pigg",
			"illa", "ner", "film", "mening", "enligt", "lag", "mysig", "helst", "s�tta", "tisdag", "hinna", "krama",
			"�gg", "samt", "sig", "tr�ja", "pung", "knark", "mej", "kyssa", "ist�llet", "gubbe", "s�ta", "h�ngla",
			"fika", "plats", "kung", "tidning", "allts�", "�sna", "f�rresten", "l�nge", "just", "gjorde", "brott",
			"lingon", "�lskade", "annan", "ville", "f�rut", "vin", "dansa", "n�", "bland", "k�ra", "vind", "sista",
			"kyssar", "smart", "paket", "buss", "syskon", "nummer", "mage", "m�tt", "b�ra", "tills", "st�", "snus",
			"s�tt", "haft", "l�k", "beh�va", "snabb", "adj�", "slida", "sak", "l�g", "minne", "nyss", "m�nad", "bott",
			"sticka", "tyska", "adress", "ung", "matta", "leta", "p�ron", "simma", "kyckling", "vinter", "g�tt",
			"torsk", "bjuda", "h�g", "kall", "v�nster", "knullar", "�ga", "tavla", "r�ka", "varm", "a", "borde",
			"puss och kram", "be", "alldeles", "ring", "sk�p", "l�kare", "te", "nytt", "tag", "far", "mun", "elva",
			"passa", "f�dd", "golv", "tuff", "f�re", "gissa", "betyg", "lov", "f�rg", "ej", "fet", "betala", "undrar",
			"kjol", "lycklig", "duscha", "hj�lpa", "f�rklara", "frukost", "grattis p� f�delsedagen", "hav", "ger",
			"borta", "�r du", "spel", "f�rslag", "svamp", "r�ra", "porr", "gr�s", "�nska", "vidare", "l�da", "prov",
			"b�rjar", "bryr", "toalett", "annorlunda", "kallt", "sitter", "by", "tog", "sked", "krav", "kusin",
			"g�ller", "timme", "n�jd", "�lskare", "ihop", "utbildning", "fall", "meddelande", "slyna", "bj�rn", "l�ngt",
			"tr�g", "upptagen", "ro", "kurs", "j�vel", "skynda", "sjunga", "sm�r", "s�nder", "klar", "smal", "morot",
			"tal", "b�r", "onanera", "sin", "f�rfattare", "orolig", "tusen", "avtal", "byxor", "bredvid", "studera",
			"s�ng", "choklad", "mest", "livet", "stj�rt", "fot", "�va", "ur", "vackra", "sett", "kanin", "son",
			"lexikon", "tr�ffas", "klockan", "besked", "klara", "tomte", "jobba", "stark", "l�gg", "kropp", "bulle",
			"pass", "�cklig", "papper", "dina", "person", "sk�ta", "ytterligare", "�ngest", "fara", "b�rjan", "gr�",
			"�ntligen", "rida", "forts�tta", "lektion", "spis", "perfekt", "f�rdig", "kasta", "present", "m�rk",
			"bryta", "snacka", "gata", "h�nda", "menar", "skriver", "snabbt", "leva", "s�tis", "beroende", "riktigt",
			"vore", "samtal", "dotter", "tolv", "vill du", "h�rd", "v�lkomna", "strand", "sk�r", "st�lle", "ungef�r",
			"medlem", "tr�dg�rd", "l�na", "le", "kund", "h�rs", "m�nniska", "kalla", "sugen", "luktar", "polis", "berg",
			"vilka", "l�ta", "moped", "besviken", "rad", "vi h�rs", "egentligen", "�ra", "�tminstone", "maj", "hyra",
			"tom", "tretton", "vinna", "gift", "orm", "frukt", "foto", "blyg", "helgen", "bak", "v�ska", "kopp",
			"f�rsta", "stackars", "jag hatar dig", "spara", "v�rlden", "socker", "heta", "v�ntar", "f�rra", "uppgift",
			"soffa", "genast", "f�rkyld", "sm�", "tillf�lle", "s�ker", "klart", "karta", "m�la", "lat", "trevlig helg",
			"klass", "herr", "sent", "holl�ndare", "t�", "hata", "gr�n", "penna", "brun", "mindre", "viktigt",
			"stensopp", "sk�ra", "fast�n", "l�xa", "vanligt", "varandra", "l�ser", "vackert", "bostad", "vakna" };
	static String[] uttryck = { "Allena saligg�rande ", "Ana argan list ", "Ana ugglor i mossen ", "Andefattig ",
			"Andra bullar ", "Ankdamm ", "Anno dazumal ", "Anv�nda apostlah�starna ", "Armb�ga sig fram ",
			"Av samma korn och skr� ", "Av samma skrot och korn ", "Avsked p� gr�tt papper ", "Bakom lyckta d�rrar ",
			"Bakom l�s och bom ", "Balansera p� slak lina ", "(Som) balsam f�r sj�len ", "Barka �t skogen ",
			"Barn av sin tid ", "Basunera ut ", "Be f�r sin sjuka mor ", "Befinna sig i fritt fall ",
			"Befinna sig i f�rskingringen ", "Beg�ra n�gons huvud p� ett fat ", "Behandla i n�gon med silkesvantar ",
			"Beh�lla fattningen ", "Bara toppen av ett isberg ", "Bev�pnad till t�nderna ", "Bida sin tid ",
			"Billig penning ", "Binda ris f�r egen rygg ", "Bita av n�gon ", "Bita huvudet av skammen ",
			" bita i det sura �pplet ", "Bita i gr�set ", "Bjuda med armb�gen ", "Bjuda till ", "Blek kopia ",
			"Bli bl�st p� konfekten ", "Bli vid sin l�st ", "Blommor och bin ", "Bl�sa faran �ver ",
			"Bl�sa upp till snus ", "Bollen �r rund ", "Brinna f�r n�got ", "Brinner i knutarna ", "Br�nna sina broar ",
			"Br�nna sina skepp ", "Br�nna sitt ljus i b�da �ndar ", "Br�nnvinsadvokat ", "Br�d och sk�despel ",
			"Bulla upp ", "Bygger bo i huvudet ", "Bygga broar ", "Bygga luftslott ", "Byta fot ",
			"B�de ha och �ta b�de �ta kakan och ha den kvar ", "B�de h�ngslen och livrem ", "B�ra hundhuvudet ",
			"B�ra n�got i sitt sk�te ", "B�ra syn f�r s�gen ", "Cirkeln �r sluten ", "Dansa efter n�gons pipa ",
			"Dansa p� n�gons grav ", "Dansen kring den gyllene guldkalven ", "Dark horse ", "Den dagen, den sorgen ",
			"Den fula ankungen ", "Den gubben gick inte ", "Det blev pannkaka av alltihop ", "Det ena eller det andra ",
			"Det fina i kr�ks�ngen ", "Det g�r sin gilla g�ng ", "Det g�r utf�r ", "Det knallar och g�r ",
			"Det kan du hoppa upp och s�tta dig p� ", "Det kan du skriva upp ", "Det kan jag lova ",
			"Det lackar mot jul eller det lider mot jul ", "Det man inte har i huvudet f�r man ha i benen. ",
			"Det st�r och faller med honom ", "Det t�cka k�net ", "Det vete f�glarna ", "Ditt och datt ",
			"Don efter person ", "Dra alla �ver en kam eller l�ta alla g� �ver samma kam ",
			"Dra benen efter sig eller dra p� benen ", "Dra det l�ngsta str�et ", "Dra dit pepparn v�xer ",
			"Dra det tyngsta lasset ", "Dra en lans f�r n�gon �ven bryta en lans � ",
			"Dra ett streck �ver det som varit ", "Dra i tr�darna ", "Dra ig�ng ", "Dra ihop sig ",
			"Dra l�rdom av n�got ", "Dra mig bakl�nges ", "Dra n�got gammalt �ver sig ", "Dra n�got i l�ngb�nk ",
			"Dra p� munnen ", "Dra p� trissor ", "Dra sig till minnes ", "Dra sig tillbaka ", "Dra sina f�rde ",
			"Dra sin sista suck ", "Dra sitt str� till stacken ", "Dra timmerstockar ", "Dra undan mattan f�r n�gon ",
			"Dra ut p� n�got ", "Dra ut p� tiden ", "Dra v�xlar p� n�got ", "Dra �t sv�ngremmen ", "Dra �ronen �t sig ",
			"Dragen vid n�san ", "Dras med n�got ", "Driva n�got till sin spets ",
			"Droppen som fick b�garen att rinna �ver ibland bara droppen ", "Duka under ", "Dummare �n t�get ",
			"D�rom tvista de l�rde ", "Falla i on�d ", "Falla mellan stolarna ", "Falla n�gon p� l�ppen ",
			"Falla p� eget grepp ", "Falla under radarn", "Fan och hans moster ", "Fara med osanning ",
			"Fara och flyga ", "Fara � f�rde ", "Fel ute ", "Fatta galoppen ", "Femte hjulet under vagnen ",
			"Fin i kanten ", "Fina fisken ", "Fiska i grumligt vatten ", "Fj�rilar i magen ", "Flyga i luften ",
			"Flyga som stekta sparvar in i mun ", "Flyta ovanp� ", "Fl�sa n�gon i nacken ", "Frid och fr�jd ",
			"Fritt fram ", "Fr�n ax till limpa ", "Fr�n vettet ", "Ful fisk ", "Full i fan eller full i sjutton ",
			"Full rulle ", "Fylla moppe ", "F� betalt under bordet ", "F� blod p� h�nderna ", "F� blodad tand ",
			"F� det hett om �ronen ", "F� eldavbrott[k�lla beh�vs] ", "F� en sl�ng av sleven ", "F� en syl i v�dret ",
			"F� ett kok stryk ", "F� frispel ", "F� f�r gammal ost ", "F� f�tter ", "F� gr�a h�r ", "F� kalla f�tter ",
			"F� kalla handen ", "F� kalla k�rar ", "F� korgen ", "F� napp ", "F� mothugg ", "F� nys om n�got",
			"F� n�got i sitt kn�", "F� n�got om bakfoten ", "F� n�got p� halsen ", "F� n�got p� hj�rnan ",
			"F� n�got p� r�tt k�l ", "F� n�got som pl�ster p� s�ren ", "F� n�got till livs ", "F� n�got till sk�nks ",
			"F� n�ja sig med smulorna fr�n den rikes bord ", "F� p� b�ten ", "F� p� moppe ", "F� p� tafsen ",
			"F� p� p�lsen ", "F� saker ur h�nderna ", "F� silkessn�ret ", "F� sin besk�rda del ",
			"F� sina fiskar varma ", "F� sista ordet ", "F� stora sk�lvan ", "F� st� p� tillv�xt ", "F� st�p�ls ",
			"F� svar p� tal ", "F� tala till punkt ", "F� tji ", "F� tungh�fta ", "F� upp �gonen f�r ",
			"F� vatten p� sin kvarn ", "F� veta att man lever ", "F� �ndan ur vagnen ", "F�ltet �r fritt ",
			"F�dd i farstun ", "F�dd med silversked i munnen. ", "F�lja n�gon hack i h�l ", "F�r allt sm�r i Sm�land ",
			"F�r allt vad tygen h�ller ", "F�r egen maskin ", "F�r fulla muggar ", "F�r hela slanten ",
			"F�r Kung och fosterland ", "F�ra bakom ljuset ", "F�rena nytta med n�je ", "F�rlora fattningen ",
			"F�rsta generationen skapar f�rm�genheten, andra spenderar den ", "F�rst� hur landet ligger ",
			"F�rs�ka ta ner m�nen ", "F�rvalta sitt pund ", "Gammal som gatan ", "Gamla surdegar ",
			"Gardera med kryss ", "Gator och torg ", "Ge d�lig eftersmak ", "Ge gr�nt ljus ", "Ge igen f�r gammal ost ",
			"Ge j�rnet ", "Ge n�gon en k�nga ", "Ge n�gon fria tyglar ", "Ge n�gon korgen ", "Ge sig i kast ",
			"Ge sig till att ", "Ge sig till k�nna ", "Ge sken av ", "Ge svar p� tal ", "Ge upp andan ",
			"Ge vid handen ", "Gilla l�get ", "Gjuta olja p� v�gorna ", "Glida in p� en r�kmacka ",
			"Glad som en l�rka ", "Glad s�som f�geln i morgonstunden ", " glimten i �gat ", "Gnugga axel med n�gon",
			"Gnugga genikn�larna ", "Goddag yxskaft ", "Grabbarna grus", "Grabben med choklad i ",
			"Grannens gr�s �r alltid gr�nare ", "Greppa efter ett halmstr� ", "Griller i huvudet ",
			"Gripa n�got ur luften ", "Gripa tillf�llet i flykten ", "Gr�a h�ret ", "Gr�ta blod ",
			"Gr�ta hela v�gen till banken ", "Gr�ta �ver spilld mj�lk ", "Gr�dde p� moset ", "Gr�va d�r man st�r ",
			"Gr�va ner sig i n�got ", "Gr�va ner stridsyxorna ", "Gr�va sin egen grav ", "Gr�n av avund ",
			"Gubbe med keps ", "Gudars skymning! ", "G� av f�r hackor ", "G� av stapeln ", "G� bakom knuten ",
			"G� bakom ryggen p� n�gon ", "G� bet p� n�got ", "G� bort ", "G� b�rs�rkag�ng ", "G� den breda v�gen ",
			"G� dit n�san pekar ", "G� fr�n ord till handling ", "G� f�r ", "G� f�r l�ngt ", "G� genom m�rg och ben. ",
			"G� i br�schen f�r n�got ", "G� i egna tankar ", "G� i gamla hjulsp�r ", "G� i graven ",
			"G� i n�gons fotsp�r ", "G� i putten ", "G� i spinn", "G� i st�pet ", "G� i taket ", "G� i v�ntans tider ",
			"G� in i v�ggen ", "G� loss p� ", "G� man ur huse ", "G� med h�ven ", "G� n�gon p� nerverna ",
			"G� och skrota ", "G� p� alla cylindrar ", "G� p� en mina ", "G� p� f�r h�gvarv ", "G� p� i ullstrumporna ",
			"G� p� kn�na ", "G� p� kryckor ", "G� p� pumpen ", "G� p� tomg�ng ", "G� sin egen v�g ",
			"G� sin gilla g�ng ", "G� stick i st�v med n�got ", "G� till botten med n�got ", "G� till storms mot n�got",
			"G� troll i n�got ", "G� under", "G� under jorden ", "G� under klubban ", "G� upp ett ljus f�r n�gon ",
			"G� upp i limningen ", "G� ur tiden ", "G� �t pipan ", "G� �t skogen ", "G� �ver gr�nsen", "G� �ver lik ",
			"G� �ver stock och sten ", "G� �ver �n efter vatten ", "G� �verstyr ", "G�kunge i boet ", "G�ra avb�n ",
			"G�ra en blunder ", "G�ra en fuga ", "G�ra en groda ", "G�ra en h�na av en fj�der ", "G�ra en kov�ndning ",
			"G�ra en pudel ", "G�ra en tavla ", "G�ra ett klipp ", "G�ra k�l p� n�gon ", "G�ra n�gon en bj�rntj�nst ",
			"G�ra n�gon r�ttvisa ", "G�ra ont v�rre", "G�ra rent hus ", "G�ra sig gr�n ", "G�ra sk�l f�r sitt namn",
			"G�ra slag i saken ", "G�ra slarvsylta av n�gon ", "G�ra upp r�kningen ", "Ha det v�l f�rsp�nt ",
			"Ha eld i baken ", "Ha en bulle i ugnen ", "Ha en k�pph�st ", "Ha en oplockad g�s med n�gon ",
			"Ha en r�v bakom �rat ", "Ha en skruv l�s ", "Ha ett ess i rock�rmen ", "Ha ett finger med i leken ",
			"Ha ett horn i sidan till n�gon ", "Ha ett v�lsmort munl�der ", "Ha ett r�tt �re ", "Ha god hand med ",
			"Ha gr�na fingrar ", "Ha huvudet p� skaft ", "Ha �gonen p� skaft ", "Ha huvudet under armen ",
			"Ha h�ga tankar om n�gon ", "Ha h�cken full ", "Ha k�tt p� benen ", "Ha alla ... ",
			"Ha alla bestick i l�dan[k�lla beh�vs]",
			"Ha alla h�star i stallet[k�lla beh�vs] eller Ha alla h�star hemma[k�lla beh�vs]", "Ha alla getter hemma ",
			"Ha alla indianer i kanoten[k�lla beh�vs]", "Ha alla koppar i sk�pet", "Ha alla skruvar i beh�ll[16]",
			"Ha en vass tunga", "Ha f�tt sina t�rnar ", "Ha is i magen ", "Ha kl�m p� n�got ", "Ha lite p� f�tterna ",
			"Ha l�nga fingrar ", "Ha l�nga �ron ", "Ha millimetrarna p� sin sida ", "Ha mycket innanf�r pannbenet ",
			"Ha myror i byxorna ", "Ha m�nga bollar i luften ", "Ha m�nga j�rn i elden ",
			"Ha m�nga str�ngar p� sin lyra ", "Ha nio liv ", "Ha n�got i kikaren ", "Ha n�got i ryggm�rgen ",
			"Ha n�got i sl�pt�g ", "Ha n�got i bagaget ", "Ha n�got p� tungan ", "Ha n�got som i en liten ask ",
			"Ha n�gra �r p� nacken ", "Ha n�san i v�dret ", "Ha pippi p� n�got ", "Ha p� f�tterna ",
			"Ha rent mj�l i p�sen ", "Ha r�g i ryggen ", "Ha satt sin sista potatis ", "Ha sett sina b�sta dagar ",
			"Ha sitt p� det torra ", "Ha skinn p� n�san ", "Ha spenderbyxorna p� sig ",
			"Ha s�lt sm�ret och tappat pengarna ", "Ha siktet inst�llt p� n�got ", "Ha tomtar p� loftet ",
			"Ha trumf p� hand ", "Ha tumme med n�gon ", "Ha tummen i �gat p� n�gon ", "Ha tummen mitt i handen ",
			"Ha vaknat p� fel sida ", "Ha vassa armb�gar ", "Ha vind i seglen ", "Ha �nglavakt ", "Ha �gon i nacken ",
			"Ha �gonen med sig", "Ha �verlevt sig sj�lv ", "Halka in p� ett bananskal ", "Hals �ver huvud ",
			"Hamna i bl�sv�der ", "Hamna i knipa ", "Hamna i skymundan ", "Hamna p� �verblivna kartan ",
			"Han eller hon skulle inte g�ra en fluga f�rn�r ", "Han eller hon spottar inte i glaset ",
			"Handen p� hj�rtat ... ", "Handla p� eget bev�g ", "Handsken �r kastad ", "Har man sagt A f�r man s�ga B ",
			"Har man tagit Fan i b�ten f�r man ro honom i land ", "Hatten av f�r ", "Hatt p� hatt ", "Hela baletten ",
			"Hela konkarongen ", "Hellre fria �n f�lla ", "Helt upp�t v�ggarna ", "Herre p� t�ppan ", "Het potatis ",
			"Hissen g�r inte hela v�gen upp ", "Historien upprepar sig ", "Hittep� ",
			"Hjulet snurrar men hamstern �r d�d ", "Hj�lpa n�gon p� traven ", "Hj�rtat i halsgropen ",
			"Hj�rtat p� r�tt st�lle ", "Hoppa h�gt ", "Hoppa i galen tunna ", "Hoppa upp och s�tta sig p� n�got ",
			"Hoppa ur sk�len ", "Hoppa �ver skaklarna ", "Hosta upp pengar ", "Hugga i sten ", "Hugget i sten ",
			"Hugget som stucket ", "Hur underst�r du dig? ", "Huvuden kommer att rulla ",
			"H�lla alla tr�dar i sin hand ", "H�lla fanan h�gt ", "H�lla god min ", "H�lla grytan kokande ",
			"H�lla hov", "H�lla hus ", "H�lla i rodret ", "H�lla i schack ", "H�lla l�da ", "H�lla n�gon kort ",
			"H�lla masken ", "H�lla n�gon p� halster ", "H�lla n�gon p� str�ckb�nken ", "H�lla n�gon st�ngen ",
			"H�lla n�gon bakom ryggen", "H�lla n�gon under armarna", "H�lla rumpan styv i kurvorna[k�lla beh�vs]",
			"H�lla skenet uppe ", "H�lla sig i skinnet ", "H�lla sig p� mattan ", "H�lla sig p� sin kant ",
			"H�lla st�llningarna ", "H�lla tand f�r tunga ", "H�lla tummarna f�r n�gon ", "H�lla tungan r�tt i mun ",
			"H�lla varandra om ryggen ", "H�lla �ngan uppe ", "H�lla �gonen p� n�got ", "H�lla �gonen �ppna ",
			"H�rda bud i Mellerud ", "H�lla vatten p� en g�s ", "H�lsa hem ", "H�nga ihop som ler och l�nghalm ",
			"H�nga l�pp ", "H�nga p� ... ", "H�nga p� en sk�r tr�d", "H�nga p� ett h�r", "H�nga p� g�rsg�rn ",
			"H�nga ut n�gon", "H�r blir inga barn gjorda ", "H�rtill �r jag n�dd och tvungen ", "H�g tid ",
			"H�gsta h�nset ", "H�gt i tak ", "H�ja n�gon till skyarna ", "H�ja p� �gonbrynen ",
			"H�jt �ver allt tvivel ", "H�nsg�rd ", "H�ra fr�n h�stens mun ", "I bl�sten ", "I br�drasket ",
			"I de lugnaste vatten ", "I det bl� ", "I det n�rmaste ", "I ett n�tskal ", "I godan ro ", "I grevens tid ",
			"I hatten ", "I k�lvattnet ", "I laga ordning ", "I m�ngt och mycket ", "Inga byxor av det skinnet ",
			"Inga krusiduller ", "Inte mycket att h�nga i julgranen ", "I rasande fart ", "I r�tta h�nder ",
			"I r�daste rappet ", "I sakta mak ", "I senaste laget ", "I sin glans dagar ", "I sin krafts dagar ",
			"I sina b�sta �r ", "I sinom tid ", "i sista �gonblicket ", "I sitt anletes svett ", "I stort sett ",
			"I stridens hetta ", "I svinottan ", "I s�kert f�rvar ", "I tid och otid ", "I ur och skur ",
			"Id och strid ", "Illa kvickt ", "In alles, �ven inalles ", "In genom ena �rat och ut genom andra ",
			"Ingen dans p� rosor ", "Ingen fara p� taket ", "Ingen ko p� isen ", "Inget man snyter ur n�san ",
			"Inget �vrigt att �nska ", "Inom lagens r�m�rken ", "Inte ett jota ", "Inte ett �ga torrt ",
			"Intet nytt under solen ", "Intresseklubben antecknar ", "Intresseflagg ", "I r�daste rappet ",
			"J�mf�ra �pplen och p�ron ", "Kaka p� kaka, �ven t�rta p� t�rta ", "Kalv p� gr�nbete ", "Kamma noll ",
			"Kamma hem n�got ", "Att misslyckas kapitalt ", "Kasta en blick", "Kasta ett get�ga p� n�gon ",
			"Kasta ett �ga p� n�gon ", "Kasta goda pengar efter d�liga ", "Kasta in handduken ",
			"Kasta ljus �ver n�got ", "Kasta loss ", "Kasta paj, �ven Pajkastning ", "", "Kasta pengar i sj�n",
			"Kasta pengar i sj�n ", "Kasta p�rlor f�r svin ", "Kasta sten i glashus ",
			"Kasta ut barnet med badvattnet ", "Kasta veven ", "Kasta vatten ", "Kasta yxan i sj�n ",
			"Katt bland hermelinerna ", "Katt p� hett pl�ttak ", "Katten p� r�ttan, r�ttan p� repet ... ",
			"Kattens lek med r�ttan ", "Kejsarens nya kl�der ", "Kila runt h�rnet ", "Kila vidare ",
			"Klammeri med r�ttvisan ", "Klappat och klart ", "Klara strupen ", "Klart och betalt ",
			"Klart som korvspad ", "Klen i anden ", "Klen tr�st ", "Klockrent ", "Klok som en pudel ",
			"Kl� sig i s�ck och aska ", "Kl� skott ", "Knaka i fogarna ", "Knalla och g� ", "Knappt om utrymme ",
			"Knyta Hymens band ", "Knyta n�ven i fickan ", "Knyta sig ", "Knyta till s�cken ", "Kn�pp p� n�san ",
			"Koka soppa p� en spik ", "Kokar ner till ", "Kola vippen ", "Koloss p� lerf�tter ", "Komma fr�n hj�rtat ",
			"Komma i bakvattnet ", "Komma p� efterk�lken ", "Komma p� gr�n kvist ", "Komma p� kant med n�gon ",
			"Komma p� skam", "Komma till skott med n�got ", "Komma till v�gs �nde ", "Komma undan helskinnad ",
			"Komma undan med blotta f�rskr�ckelsen ", "Komma under lupp ", "Komma ur askan i elden ", "Kors i taket ",
			"Kosta skjortan ", "Kratta manegen ", "Krossa n�gons hj�rta ", "Krypa till korset ",
			"Kryssa mellan Skylla och Karybdis ", "Kr�la i stoftet ", "Kunna f�rs�tta berg ", "Kusten �r klar ",
			"Kv�llens clou ", "Kyss Karlsson! ", "Kyss mig i arslet! ", "Kyssa sin faster att kyssa sin faster ",
			"K�nna hur vinden bl�ser ", "K�nna l�ssen p� g�ngen ", "K�nna n�gon p� pulsen ",
			"K�nna sina l�ss p� g�ngen ", "K�nna sina pappenheimare ", "K�ringen mot str�mmen ",
			"K�pa grisen i s�cken ", "K�ra n�gon p� porten ", "K�r i vind! ", "K�r s� det ryker! ",
			"K�ra huvudet i v�ggen ", "K�rd i grus ", "K�tt p� benen ", "L", "Lag och ordning ",
			"Lagens arm, lagens v�ktare ", "Lagvr�ngare ", "Lapp p� luckan ", "Larva sig ", "Le i mjugg ",
			"Leka med elden ", "Leka rommen av sig ", "Lengr�ddad ", "Leta efter en n�l i en h�stack ",
			"Leta efter n�got med ljus och lykta ", "Leva loppan ", "Leva p� hoppet", "Leva som man l�r ",
			"Leva under knapphetens stj�rna", "Leva ur hand i mun ", "Lida mot sitt slut ", "Ligga bakom ",
			"Ligga f�r f�fot ", "Ligga h�stl�ngder f�re ", "Ligga i ", "Ligga i l� ", "Ligga i selen ",
			"Ligga i startgroparna ", "Ligga i st�psleven ", "Ligga l�gt ", "Ligga n�gon i fatet ",
			"Ligga n�gon till last ", "Ligga n�gon varmt om hj�rtat ", "Ligga p� ", "Ligga p� sofflocket ",
			"Lika goda k�lsupare. ", "Lika som b�r ", "Lite h�r och var ", "Liv i luckan ", "Livet p� en pinne ",
			"Ljuga sig bl� ", "Ljuga som h�star travar ", "Ljuger s� han tror sig sj�lv ",
			"Lova guld och gr�na skogar ", "Lova runt och h�lla tunt ", "Lova vitt och brett ", "Lugn i stormen ",
			"Lugn och ro ", "Luktar pyton ", "Lusl�sa ", "Luspank ", "Luspudel ", "Lyckans ost ", "Lyfta p� f�rl�ten ",
			"Lyfta p� hatten f�r ", "Lyfta sig sj�lv i h�ret ", "Lysa med sin fr�nvaro ",
			"Lyset �r p� men det �r ingen hemma ", "L�gt h�ngande frukt", "L�ngt fr�n �ra och redlighet ",
			"L�ta barn vara barn ", "L�ta bilan falla ", "L�ta maten tysta mun ", "L�ta m�lvakten st� i m�l ",
			"L�ta n�d g� f�re r�tt ", "L�ta r�ttvisan ha sin g�ng ", "L�ta udda vara j�mnt ",
			"L�tsas som om det regnar ", "L�gg �gg! ", "L�gga alla �gg i samma korg ", "L�gga benen p� ryggen ",
			"L�gga en h�msko p� n�got ", "L�gga fingrarna emellan ", "L�gga i malp�se ", "L�gga korten p� bordet ",
			"L�gga kraft bakom orden ", "L�gga l�k p� laxen ", "L�gga locket p� ", "L�gga manken till ", "L�gga ner",
			"L�gga n�got p� hyllan ", "L�gga n�got p� is ", "L�gga n�got p� minnet ", "L�gga n�san i bl�t ",
			"L�gga orden i munnen p� n�gon ", "L�gga p� en rem ", "L�gga p� ett kol ", "L�gga rabarber p� n�got ",
			"L�gga sig ner och d� ", "L�gga sig under kniven ", "L�gga sig vinn om n�got ",
			"L�gga sista handen vid n�got ", "L�gga skorna p� hyllan ", "L�gga sordin p� st�mningen ",
			"L�gga sten p� b�rda ", "L�gga tv� str�n i kors ", "L�gga ut en snara f�r n�gon ", "L�gga ut texten ",
			"L�gga vantarna p� n�got ", "L�mna n�gon i sticket ", "L�ra n�gon mores ", "L�ra n�gon veta hut ",
			"L�sa lagen f�r n�gon ", "L�sa lusen av n�gon ", "L�sa mellan raderna ", "L�gn och f�rbannad dikt ",
			"Man mot man ", "Man m�ste l�ra sig krypa innan man kan g� ",
			"Man skall k�pa till sillen och s�lja till kr�ftorna ", "Man skall leva f�r varandra ",
			"Man skall s� med handen, inte med fulla s�cken ", "Man tager vad man haver ", "Mannaminne ",
			"Man vet vad man har men inte vad man f�r ", "Matjord i fickorna ", "Med buller och b�ng ",
			"Med byxorna nere ", "Med flaggan i topp ", "Med flinka fingrar ", "Med hull och h�r ",
			"Med m�ssan i hand ", "Med n�gons goda minne ", "Med n�san ovanf�r vattenbrynet ", "Med n�d och n�ppe ",
			"Med sanningen �verensst�mmande ", "Med varm hand ", "Medaljens baksida ", "Mellan fyra �gon ",
			"Mellan h�gg och syren ", "Mellan sk�l och v�gg ", "Mellan varven ", "Min lagvigda ", "Min tillkommande ",
			"Missa t�get ", "Mitt�t! ", "Moment 22 ", "Mota Olle i grind ", "Mumla i sk�gget ",
			"Mycket ska man h�ra innan �ronen faller av ", "Mycket skrik f�r lite ull ",
			"Mycket snack och lite verkstad ", "Mycket vatten har flutit under broarna sedan dess ",
			"Mycket v�sen f�r ingenting ", "Myndig st�mma ", "M� det b�ra eller brista ", "M�la fan p� v�ggen ",
			"M�la in sig i ett h�rn ", "M�nga h�vdingar, men f� indianer ", "M�nniskans b�sta v�n �r hunden ",
			"M�ta sitt Waterloo ", "Nu gick det upp ett ljus ", "Nu g�r skam p� torra land ",
			"Nu trillade polletten ner ", "Nu �r det klippt ", "Nu �r det kokta fl�sket stekt ", "Nu �r det k�rt ",
			"Nu �r goda r�d dyra ", "Nu �r jag ute p� ok�nt vatten ", "Nu �r m�ttet r�gat ", "N�gonting �r ruttet ",
			"N�got har sett dagens ljus ", "N�got i h�stv�g ", "N�got som katten sl�pat in ", "N�r andan faller p� ",
			"N�r det kommer till kritan ", "N�r krubban �r tom bits h�starna",
			"N�r skoputsarna fr�gar om aktietips �r det dags att s�lja ", "N�r Adam var l�nsman ",
			"N�ra en orm vid sin barm ", "N�rma sig med stormsteg ", "N�sta �r i Jerusalem ", "Odla sin k�l ",
			"Om inte om hade funnits ", "Ord st�r mot ord ", "Ord och inga visor ",
			"Ordning och reda, pengar p� freda' ", "Ormens v�g p� h�lleberget ", "Osa katt ", "Osa svavel ",
			"Osvuret �r b�st ", "Pang p� r�dbetan ", "Peka med hela handen ", "Pengar luktar inte ",
			"Peppar, peppar, ta i tr� ", "Pest eller kolera ", "Pigg som en m�rt ", "Plattan i mattan ",
			"Plocka russinen ur kakan ", "Polsk riksdag ", "Pompa och st�t ", "Praktiskt taget ", "Prata bredvid mun ",
			"Prata goja ", "Prata i nattm�ssan ", "Prata i v�dret ", "Prata i munnen p� varandra ", "Prata sm�rja ",
			"Pricken �ver i:et. ", "Privatlivets helgd ", "Puckla p� ", "Pudelns k�rna ", "P� alla fyra ",
			"P� det hela taget ", "P� en h�ft ", "P� ett br�de ", "P� fallrepet ", "P� fem r�da ", "P� G ",
			"P� gr�srotsniv� ", "P� kornet ", "P� l�pande band ", "P� l�sa boliner ", "P� m�f� ", "P� papperet ",
			"P� pickalurven ", "P� pin kiv ", "P� pricken ", "P� rak arm ", "P� sandl�deniv� ", "P� sin mammas gata ",
			"P� sin h�jd ", "P� st�ende fot ", "P� tu man hand ", "Rammelbuljong ", "Raska gossar ",
			"Regnet st�r som sp�n i backen ", "Rena rama ... ", "Rent ryskt ", "Resa ragg",
			"Resa sig som f�gel Fenix ur askan ", "Reta gallfeber p� n�gon ", "Rida ut en storm ", "Rim och reson ",
			"Rimmar illa ", "Rinna ut i sanden ", "Ris och ros ", "Rubb och stubb ", "Rulla hatt ", "Rulla p� ",
			"Rulla tummarna ", "Rund under f�tterna ", "Rundligt tilltagen summa ", "Rymma f�ltet ",
			"R�da bot p� n�got ", "R�ka i luven p� varandra ", "R�ttorna l�mnar ett sjunkande skepp ",
			"R�fst och r�ttarting ", "R�nderna g�r aldrig ur ", "R�tt skall vara r�tt ", "R�tt och riktigt ",
			"R�tta mun efter mats�cken ", "R�d tr�d ", "R�ra runt i grytan ", "R�ra upp himmel och jord ",
			"R�rd till t�rar ", "Sagt och gjort ", "Saken �r biff ", "Sakta i backarna ", "Sakta men s�kert ",
			"Satsa p� fel h�st ", "Samla i ladorna ", "Sanningens minut ", "Sans och balans ", "Sansa sig ",
			"Se en levande sj�l ", "Se f�rg torka ", "Se ljuset i tunneln ", "Se l�ngre �n n�san r�cker ",
			"Se med blida �gon p� ", "Se mellan fingrarna ", "Se om sitt hus ", "Se sp�ken mitt p� ljusa dagen ",
			"Se r�ken av ", "Se r�tt ", "Se sanningen i vit�gat ", "Se sig i m�nen efter n�got ",
			"Se skogen f�r alla tr�d ", "Se ut som sju sv�ra �r ",
			"Sedan dess har det flutit mycket vatten under broarna ", "Sedan Eldkvarn brann[k�lla beh�vs] ",
			"Sent omsider ", "Serverat som p� silverfat ", "Sila mygg och sv�lja kameler ", "Simma med str�mmen ",
			"Sin besk�rda del ", "Sin glans dagar ", "Sina n�ra och k�ra ", "Sist men inte minst ",
			"Sista spiken i kistan ", "Sitta hemma och uggla ", "Sitta h�rt �t ", "Sitta i klistret ",
			"Sitta i kn�t p� n�gon ", "Sitta i samma b�t ", "Sitta i v�ggarna ", "Sitta inne ", "Sitta och h�cka ",
			"Sitta och m�gla ", "Sitta i sm�ret ", "Sitta p� pottkanten ", "Sitta p� sina h�ga h�star ",
			"Sitta p� tv� stolar samtidigt, �ven Sitta p� dubbla stolar ", "Sitta still i b�ten ",
			"Sitta s�kert i sadeln ", "Sju sorger och �tta bedr�velser ", "Sju sv�ra �r ", "Sjunga p� sista versen ",
			"Skaka galler ", "Skaka n�got ur �rmen ", "Skam till s�gandes ", "Skapelsen ", "Skapelsens krona ",
			"Skarp penna penna ", "Skarpt l�ge ", "Ske med n�gons goda minne", "Skelett i garderoben ",
			"Skepp utan roder ", "Skilja agnarna fr�n vetet ", "Skinn p� n�san ", "Skita i det bl� sk�pet ",
			"Skitprat, Pratar skit ", "Skjuta mygg med kanoner ", "Skjuta sig sj�lv i foten ", "Sko sig ",
			"Skratta hela v�gen till banken ", "Skrida till verket ", "Skrika f�r full hals ", "Skrika i h�gan sky ",
			"Skriva n�gon p� n�san ", "Skriva under p� n�got ", "Skr�ckblandad f�rtjusning ", "Skr�da orden ",
			"Skynda l�ngsamt ", "Sk�ra pipor i vassen", "Sk�da inte en given h�st i munnen ", "Sk�mmas �gonen ur sig ",
			"Sk�rda sina frukter ", "Sk�rda offer ", "Slag under b�ltet ", "Slaven p� triumfvagnen ",
			"Slicka n�gon i arslet m", "Slira p� sanningen ", "Slit den med h�lsan! ", "Slita hund ", "Slita ont ",
			"Sluta leden ", "Sl� bl� dunster i �gonen p� n�gon ", "Sl� dank ", "Sl� dig i backen p� ",
			"Sl� d�v�rat till ", "Sl� en sjua ", "Sl� en parabel ", "Sl� ett slag f�r n�got ", "Sl� huvudet p� spiken ",
			"Sl� i taket ", "Sl� in �ppna d�rrar ", "Sl� klackarna i taket ", "Sl� knut p� sig sj�lv ",
			"Sl� lock f�r �ronen ", "Sl� mynt av n�got ", "Sl� ner sina bop�lar ", "Sl� n�gon gul och bl� ",
			"Sl� n�gon s�nder och samman ", "Sl� n�ven i bordet ", "Sl� p� stora trumman ", "Sl� p� stort ",
			"Sl� sig f�r br�stet ", "Sl� sig i slang med ", "Sl� sig s�nder och samman ", "Sl� sina p�sar ihop ",
			"Sl� tv� flugor i en sm�ll ", "Sl� vakt om n�got ", "Sl� vantarna i bordet ", "Sl�s av n�got ",
			"Sl�kten �r v�rst ", "Sl�ta �ver n�got ", "Smakar det s� kostar det ", "Smida medan j�rnet �r varmt ",
			"Sminka en p�ve ", "Smockan h�nger i luften ", "Smolk i gl�djeb�garen ", "Sm�ll p� fingrarna ",
			"Sm�rja kr�set ", "Sm�rklick p� het potatis ", "Sol ute, sol inne. Sol i hj�rta, sol i sinne ",
			"Sola sig i sin egen glans", "Som ett torrt skinn ", "Som fan l�ser Bibeln ", "Sopa golvet med n�gon ",
			"Sopa problemet under mattan ", "Sopa rent framf�r sin egen d�rr ", "Sova p� saken ",
			"Spara p� krutet inte p� krutet ", "Sparv i tranedansen ", "Spel f�r galleriet", "Spel bakom kulisserna ",
			"Spela Allan ", "Spela andrafiolen ", "Spela ett h�gt spel ", "Spela i samma division ",
			"Spela sina kort v�l ", "Spela under t�cket med n�gon ", "Spetsa �ronen ", "Spindeln i n�tet ",
			"Spotta i n�varna ", "Sprids som askan f�r vinden ", "Sprillans, sprillans ny ", "Springande punkten ",
			"Spritt spr�ngandes naken ", "Sp�nna b�gen f�r h�gt ", "Stick i st�v mot ", "Sticka huvudet i sanden ",
			"Sticka i �gonen ", "Sticka under stol med ", "Sticka ut hakan ", "Stiga �t huvudet ",
			"Stirra sig blind p� n�got ", "Stolt som en tupp ", "Storm i ett vattenglas ", "Strama tyglar ",
			"Strid p� kniven ", "Strida om p�vens sk�gg ", "Stryka med ", "Stryka n�gon medh�rs ",
			"Stryka p� f�tterna ", "Str�cka vapen ", "Str� p�rlor f�r svinen ", "Str� salt i s�ren ", "Styv i korken ",
			"Styv i nacken ", "St� f�r fiolerna ", "St� handfallen ", "St� i ljusan l�ga ", "St� i rampljuset ",
			"St� i skottgluggen ", "St� i valet och kvalet ", "St� inf�r skranket ", "St� med armarna i kors ",
			"St� med b�da f�tterna p� jorden ", "St� med m�ssan i n�ven ", "Hamna med sk�gget i brevl�dan ",
			"St� med tv� tomma h�nder ", "St� med tv�ttad hals ", "St� och v�ga ", "St� pall f�r n�got ",
			"St� p� egna ben ", "St� p� god fot med n�gon ", "St� p� n�san ", "St� p� spel ", "St� p� sig ",
			"St� p� �ronen ", "St� sitt kast ", "St� som fallen fr�n skyarna ", "St� upp i halsen ",
			"St� vid skamp�len ", "St�nga hornen av sig ", "St�nga sig blodig ", "St�lla n�gon mot v�ggen ",
			"St�lla sig i skamvr�n ", "St�lla till svars ", "St�llas i d�lig dager ", "St�mma i b�cken ",
			"St�pt i samma form ", "St�rst och v�rst i hela Bofors ", "St�ta och bl�ta n�got ", "St�ta p� patrull ",
			"St�tts och bl�tts ", "Suga p� karamellen ", "Suga p� ramarna ", "Summa summarum ", "Surfa p� n�tet ",
			"Svagaste l�nken i kedjan ", "Svansen mellan benen ", "Svarta f�ret ", "Svarte Petter ", "Svida i skinnet ",
			"Sv�rfj�llad fisk ", "Sv�lja det beska pillret ", "Sv�ra i kyrkan ", "Sv�va i ovisshet ",
			"Sv�va mellan liv och d�d ", "Sv�va p� moln ", "Sv�va p� m�let ", "Sv�va p� rosa moln ", "Syna i s�mmarna ",
			"Synd p� s� rara �rtor ", "Synda p� n�den ", "Syndabock ", "S� gott som ", "S� in i Norden ",
			"S� in i vassen ", "S� n�ra sanningen man kan komma ", "S� sant som det �r sagt ", "S� split ",
			"S� sin vildhavre ", "S� tyst att man kan h�ra en knappn�l falla ", "S�lt sm�ret och tappat pengarna ",
			"S�ga n�gon vid fotkn�larna ", "S�nt �r livet ", "S�som i en spegel ", "S�ga ifr�n p� skarpen ",
			"S�ga flaska ", "S�ker i sadeln ", "S�ker p� sin sak ", "S�kert som amen i kyrkan ",
			"S�tta bocken till tr�dg�rdsm�stare ", "S�tta en rova ", "S�tta fingret p� n�got ", "S�tta in n�dast�ten ",
			"S�tta k�ppar i hjulet ", "S�tta livet till ", "S�tta munkavle p� n�gon ",
			"S�tta myror i huvudet p� n�gon ", "S�tta ner foten ", "S�tta n�gon p� det hala ",
			"S�tta n�gon p� piedestal ", "S�tta n�gon p� plats ", "S�tta n�gon p� potta ", "S�tta n�got p� kartan ",
			"S�tta n�got p� spel ", "S�tta n�got under lupp ", "S�tta p f�r n�got ", "S�tta punkt f�r n�got ",
			"S�tta sig p� bakhasorna ", "S�tta sig p� h�ga h�star ", "S�tta sig p� tv�ren ",
			"S�tta sitt ljus under sk�ppan ", "S�tta spr�tt p� pengarna ", "S�tta till alla klutar ",
			"S�tta v�rde p� n�got ", "S�ndra och h�rska ", "Ta bladet fr�n munnen ", "Ta pucken ", "Ta den i tv�an ",
			"Ta det kallt ", "Ta det lite p� om p� ", "Ta det l�nga benet f�re ", "Ta det med en klackspark ",
			"Ta det med ro ", "Ta det piano ", "Ta det s�kra f�re det os�kra eller Ta det s�kra f�r det os�kra ",
			"Ta det vackert ", "Ta en i det andra benet ocks� ", "Ta en kula f�r n�gon ", "Ta en repa ",
			"Ta en �nde med f�rskr�ckelse ", "Ta f�r sig ", "Ta f�r stora ord i sin mun ", "Ta gift p� n�got ",
			"Ta hus i helsike ", "Ta h�jd f�r n�got ", "Ta i med h�rdhandskarna ", "Ta i med silkesvantarna ",
			"Ta i s� man spricker ", "Ta igen p� gungorna vad man f�rlorat p� karusellen ", "Ta korn p� ",
			"Ta k�l p� n�gon ", "Ta musten ur n�gon", "Ta ner skylten ", "Ta n�gon i hampan ", "Ta n�gon i �rat",
			"Ta n�got med en nypa salt ", "Ta n�got f�r givet ", "Ta om 'et fr�n b�rjan ", "Ta p� kornet ",
			"Ta saken i egna h�nder ", "Ta seden dit man kommer ", "Ta sig en funderare ", "Ta sig en styrket�r ",
			"Ta sig f�r stora friheter ", "Ta sig i kragen ", "Ta sig vatten �ver huvudet ", "Ta sin Mats ur skolan ",
			"Ta sitt f�rnuft till f�nga", "Ta skeden i vacker hand ", "Ta skruv ", "Ta steget fullt ut ",
			"Ta till storsl�ggan ", "Ta tjuren vid hornen ", "Ta ur bruk ", "Tacka sin lyckliga stj�rna ",
			"Tagen p� s�ngen ", "Tala ett annat spr�k ", "Tala f�r d�va �ron ", "Tala klarspr�k ",
			"Tala med b�nder p� b�nders vis och med de l�rde p� latin ", "Tala med kluven tunga ", "Tala till punkt ",
			"Tala ur sk�gget ", "Tappa ansiktet ", "Tappa greppet ", "Tappa hakan ", "Tappa huvudet ",
			"Tappa koncepten ", "Tappa m�lf�ret ", "Tappad bakom en vagn ", "Tiden har runnit ut ", "Tidens tand ",
			"Tids nog ", "Till det yttersta ", "Till r�ga p� allt ", "Till sista andetaget ", "Till syvende och sist ",
			"Till yttermera visso ", "Timglaset �r fullt ", "Titta f�r djupt i glaset", "Titta snett p� n�gon",
			"Tolv �l r�cker till alla ", "Tomma ord ", "Tomt i ladan", "Toppa laget ", "Trampa i klaveret ",
			"Trampa inte r�dbetor i mossen ", "Trampa p� en �m t� ", "Trampa spiken i botten ", "Trampa vatten ",
			"Tredje g�ngen gillt ", "Tretton p� dussinet ", "Trilla av pinn ", "Trolla med kn�na ",
			"Tror, det g�r man i kyrkan ", "Trycka ner i skoskaften ", "Tr�ngt om saligheten ", "Tr�ffa den r�tta ",
			"Tr�st f�r tigerhj�rtan", "Tulipanaros ", "Tummen i �gat ", "Tupp i halsen ", "Tv�tta pengar ",
			"Tv�tta sin smutsiga byk", "Tycka skjortan �r tr�ng ", "..., tyckte st�mman ",
			"Tystnaden talar f�r sig sj�lv ", "Tv� sidor av samma mynt ", "Tv� sina h�nder ", "T�r p� tand ",
			"T�rta p� t�rta ", "T�nda p� alla fyra eller T�nda p� alla cylindrar ", "T�lja guld med pennkniv ",
			"T�nka fritt �r stort, men t�nka r�tt �r st�rre ", "T�nk f�rst och tala sen ", "T�nka p� refr�ngen ",
			"T�ppa till munnen p� n�gon ", "T�rningen �r kastad ", "T�mma den bittra kalken", "Ulv i f�rakl�der ",
			"Undantaget som bekr�ftar regeln ", "Underbart �r kort ", "Upp p� koturnen ", "Uppe med tuppen ",
			"Uppfinna hjulet p� nytt ", "Ur askan i elden ", "Ur fas ", "Ur g�ngorna ", "Ur led �r tiden ", "Ur spel ",
			"Utan att darra p� manschetten ", "Utan en tr�d p� kroppen ", "Utan m�l och mening ", "Utan pardon ",
			"Utan styrfart ", "Utan �nde ", "Ute och cykla ", "Ute p� djupt vatten ", "Ute p� hal is ", "Vacker tass ",
			"Vad g�spar sk�rpan? ", "Vad �vrigt �r, �r tystnad ", "Vad v�ldet m� skapa �r vanskligt och kort ",
			"Vakta sin tunga ", "Var och en �r salig p� sin tro ", "Vara av det r�tta virket ",
			"Vara den f�rste som ... ", "Vara den som �r den ", "Vara du och bror med n�gon ", "Vara dummare �n t�get ",
			"Vara d�dens lammunge ", "Vara f�r handen ", "Vara grov i munnen ", "Vara gr�nt ", "Vara haj p� ",
			"Vara herre i sitt eget hus ", "Vara helt under isen ", "Vara het p� gr�ten ", "Vara hugget som stucket ",
			"Vara hundra p� ", "Vara h�ljt i dunkel ", "Vara i en annan v�rld ", "Vara i faggorna ", "Vara i farten",
			"Vara i hetluften ", "Vara i krokarna ", "Vara i n�gons kl�der ", "Vara i n�gons tankar ", "Vara i ropet ",
			"Vara i sin linda ", "Vara i sitt esse ", "Vara i sitt r�tta element ", "Vara i sjunde himlen ",
			"Vara ig�ng", "Vara karl f�r sin hatt ", "Vara k�rd i botten", "Vara l�tt p� foten",
			"Vara med p� ett h�rn ", "Vara med p� noterna ", "Vara med p� t�get", "Vara n�ra �gat ",
			"Vara om sig och kring sig ", "Vara p� allas l�ppar ", "Vara p� den s�kra sidan ", "Vara p� efterk�lken",
			"Vara p� fallrepet ", "Vara p� fri fot ", "Vara p� glid", "Vara p� hugget ", "Vara p� h�ret ",
			"Vara p� kanelen ", "Vara p� krigsstigen ", "Vara p� resande fot ", "Vara p� samma v�gl�ngd ",
			"Vara p� sin vakt ", "Vara p� sm�llen ", "Vara p� spr�ng", "Vara p� tapeten", "Vara p� upph�llningen ",
			"Vara p� vippen ", "Vara rakryggad eller Vara rak i ryggen ", "Vara rund under f�tterna ",
			"Vara satt p� bar backe ", "Vara sig sj�lv nog ", "Vara sig sj�lv n�rmast ", "Vara sin egen lyckas smed ",
			"Vara skarpaste kniven i l�dan[k�lla beh�vs] ", "Vara skrivet i stj�rnorna ", "Vara som gjord f�r n�got ",
			"Vara som klippt och skuren f�r n�got ", "Vara stadd vid kassa ", "Vara surrad vid masten",
			"Vara tillbaka p� ruta ett ", "Vara topp tunnor rasande ", "Vara torr bakom �ronen ",
			"Vara tu tal om n�got ", "Vara under uppsegling ", "Vara ute efter n�got", "Vara ute i kylan ",
			"Vara ute i ogjort v�der ", "Vara ute p� tunn is ", "Vara utom sig av vrede ", "Vara uppe med tuppen ",
			"Vara vid sina sinnens fulla bruk ", "Vara vid sunda v�tskor ", "Vara v�rt papperet det �r skrivet p� ",
			"Vara yr i m�ssan ", "", "Varje moln har en silverkant", "Varf�r �r allt en trasa? ",
			"Varje moln har en silverkant ", "Varken bu eller b� ", "Varken hackat eller malet ", "Varm i kl�derna ",
			"Varm om hj�rtat ", "Verkligheten �vertr�ffar dikten ", "Veta hur en slipsten ska dras ", "Veta hut ",
			"Veta vad klockan �r slagen ", "Veta var skon kl�mmer ", "Vi �r alla olika i Herrens hage ",
			"Vila p� hanen", "Vila p� sina lagrar ", "Vilja sjunka genom jorden ",
			"Vind f�r v�g eller Driva vind f�r v�g ", "Visa framf�tterna ", "Visa sig fr�n sin goda sida ",
			"Visa sig p� styva linan ", "Visa t�nderna ", "Visa var sk�pet ska st� ", "Vit vecka ", "V�cka ont blod",
			"V�dra morgonluft ", "V�ga sina ord p� guldv�g ", "V�ggarna har �ron ", "V�ltra sig i pengar ",
			"V�nda andra kinden till ", "V�nda blad ", "V�nda kappan efter vinden ", "V�nda p� klacken",
			"V�nda p� kuttingen ", "V�nda p� slantarna ", "V�nda p� steken ", "V�nda p� varje sten ",
			"V�ssa sina knivar ", "V�xa s� det knakar ", "Yr i bollen ", "Yr i m�ssan ", "ka p� en bl�sning ",
			"�ngest, �ngest �r min arvedel ", "�terf� fattningen ", "�terg� till sina r�tter ", "�t fanders ",
			"�t pipsv�ngen ", "�kta h�lft ", "�nda in i H�lsingland ", "�nda in i kaklet ",
			"�nda ut i fingerspetsarna ", "�pplet faller inte l�ngt fr�n tr�det ", "�ra den som �ras b�r ",
			"�ta n�gon ur hus och hem ", "�ta n�gon ur huset ", "�ta upp vad man sagt eller gjort ",
			"�ter allt, tycker mycket om barn ", "�ven du Brutus? ", "�ga f�r �ga, tand f�r tand ", "�gonab�j ",
			"�ppna korpgluggarna ", "�rnkoll ", "�verf�rfriskad ", "�ver huvud taget ", "�ver min d�da kropp ",
			"�ver lag ", "�verlevt sig sj�lv ", "�ver sig given " };

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		// loopen �r till f�r att man ska kunna spela igen utan att starta om koden
		while (true) {
			System.out.println("kena kompis dags att h�nga gubbe");
			System.out.println("vill tu testa supersv�ra versionen med uttryck ist�llet?");
			System.out.println("(ja) (nej)");

			// H�r slumpas ett ord eller uttryck fr�n en av listorna
			String hemligt;
			if (yesNo()) {
				hemligt = uttryck[(int) (Math.random() * uttryck.length)];
			} else {
				hemligt = words[(int) (Math.random() * words.length)];
			}

			// en sak gick fel med h�mtningen av ord och det h�r var det
			// snabbaste s�ttet f�r mig att fixa det, men inte f�r datorn
			hemligt = fixaSaken(hemligt);
			String hemligt2 = hemligt;

			// kom p� att dessa tecken kan kommit med och strular med saker och s�nt du vet
			// ting s� d�r som det g�r ofta ibland
			hemligt = hemligt.replaceAll("'", "");
			hemligt = hemligt.replaceAll(",", "");

			// H�r h�mtas en integer in som anv�nds senare
			int f�rs�k;
			System.out.println("Hur m�nga f�rs�k ska du ha?");
			do {
				System.out.println("(skriv en positiv int)");
				f�rs�k = inInt(scn.nextLine());
			} while (f�rs�k < 1);

			// Vet �r en string som just nu inneh�ller en " _" eller " " per char i hemligt

			String vet = "";
			for (int i = 0; i < hemligt.length(); i++) {
				if (hemligt.charAt(i) != ' ') {
					vet = vet.concat("_ ");
				} else {
					vet = vet.concat("  ");
				}
			}

			// asciiart �r en tom char[][] som kommer att fyllas med chars n�r ett fel svar
			// ges och sedan printas.

			char[][] asciiart = new char[8][12];

			// asciiSet metoden fyller upp asciiart tills antalet chars kvar �r samma som
			// antalet f�rs�k med hj�lp av int drag.
			// Jag vet inte om det hade varit snabbare att bara anv�nda integern f�rs�k, och
			// konvertera den till drag n�r det beh�vs

			int drag = asciix.length - f�rs�k - 1;
			for (int x = 0; x < drag; x++) {
				asciiSet(asciiart, x);
			}

			// String gissat kommer att anv�ndas nedanf�r f�r att komma ih�g anv�ndarens
			// tidigare gissningar

			String gissat = "";

			// Jag tror printaMassaTommaRader metoden f�rklarar sig sj�lv
			// Jag kanske skulle ha anv�nt den d�r konsolen ni gav oss, men det h�r funkar
			// helt okej om din sk�rm inte �r f�r h�g

			printaMassaTommaRader();

			// asciiPrint f�r att visa den fina gubben
			asciiPrint(asciiart, drag);

			while (true) {

				System.out.println(vet);
				System.out.println("Antal f�rs�k kvar: " + f�rs�k);
				System.out.println("Vill du gissa hela? (ja), (nej)");
				if (yesNo()) {
					String answer;

					// Answer metoden g�r s� att loopen bara slutar om answer blir en String med
					// endast bokst�ver.
					// inte helt n�dv�ndigt, men jag skrev det och det funkar
					do {
						System.out.println("ge mig en string med bara bokst�ver");
						answer = scn.nextLine();
					} while (!answer(answer));

					// om anv�ndaren anv�nde stora bokst�ver eller mellanslag p� b�rjan eller slutet
					// fixar fixaSaken detta
					answer = fixaSaken(answer);

					// nu kan man j�mf�ra
					if (answer.equals(hemligt)) {
						System.out.println("du gissade r�tt och vann");
						System.out.println("svaret var allts�: " + hemligt2);
						break;
					} else {
						printaMassaTommaRader();
						System.out.println("du gissade inte r�tt tyv�rr");
						drag++;
						f�rs�k--;
						asciiPrint(asciiart, drag);
					}
				} else {
					String that;

					// h�r kommer du inte ut ifr�n om svaret ligger i gissat, eller
					// svaret �r en tom rad
					// jag ville ha mera tester, men det lyckades inte av n�gon anledning
					do {
						System.out.println("Gissa p� en bokstav.");
						System.out.println("Dina tidigare gissningar �r:");
						System.out.println(gissat);
						that = scn.nextLine();
						if (that.length() == 0) {
							continue;
							
						}
						that = that.substring(0, 1);
						that = that.toUpperCase();
					} while (gissat.contains(that) || !Pattern.matches("[A-Z���]+", that.substring(0, 1)));

					// nu �r din nya char i gissat stringen
					gissat = gissat.concat(" " + that);

					// f�r att se om that finns i hemligt m�ste vi ha den i sm� bokst�ver
					that = that.toLowerCase();
					int hm = hemligt.indexOf(that);

					// om hm �r -1 betyder det att hemligt.indexOf(that) inte hittade n�got och
					// gissningen var fel
					if (hm > -1) {

						// h�r tas alla instanser av that i hemligt och l�gger till that i vet d�r de
						// finns i hemligt
						String that2 = that.toUpperCase();
						String temp = hemligt;
						do {
							vet = vet.substring(0, hm * 2) + that2 + vet.substring(hm * 2 + 1);
							temp = temp.substring(0, hm) + " " + temp.substring(hm + 1);
							hm = temp.indexOf(that);
						} while (hm > -1);

						// om vet inte l�ngre har n�gra underscores �r hemligt hittat och spelaren
						// vinner
						if (!vet.contains("_")) {
							System.out.println("n�men d�r har du ju svaret");
							System.out.println("svaret var allts�: " + hemligt2);
							break;
						}

						// annars forts�tter spelet utan att ett f�rs�k drags
						printaMassaTommaRader();
						System.out.println("n�men du gissade r�tt �nd�");
						asciiPrint(asciiart, drag);
						continue;
					}

					// om hm d� �r -1 dras ett f�rs�k och ett drag l�ggs till
					printaMassaTommaRader();
					System.out.println("du gissade fel");
					drag++;
					f�rs�k--;
					asciiPrint(asciiart, drag);
				}

				// nu i slutet av loopen ser vi om f�rs�k har n�tt 0 och breakar i s� fall
				if (f�rs�k == 0) {
					System.out.println("oj du f�rlorade, f�rs�ken tog slut");
					System.out.println("svaret var: " + hemligt2);
					break;
				}
			}

			// om anv�ndaren svarar nej breakar loopen och programmet s�jer hejd�
			System.out.println("Vill du spela igen? (ja), (nej)");
			if (!yesNo()) {
				System.out.println("hejd�");
				break;
			}
		}
		scn.close();
	}

	public static int inInt(String in) {

		// Character.getNumericValue(Char) ger -1 eller h�gre �n 9 om charen inte �r 1-9
		// I s� fall returnas -1 f�r att visa att Stringen inte �r ett heltal
		// annars s� l�ggs charen till p� r�tt plats i integern som returnas
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

		// Om drag �r mindre �n noll betyder det att anv�ndaren har valt s� m�nga f�rs�k
		// att charsen i asciiart inte r�cker till f�r varje f�rs�k
		// Det finns mer chars i ascii �n bokst�ver i alfabedet dock s� det �r ganska
		// meningsl�st
		if (drag < 0) {
			return;
		}

		// AsciiSet fixar asciiart s� att en till char l�ggs till, och sedan printas den
		asciiSet(asciiart, drag);
		for (int y = 0; y < asciiart.length; y++) {
			for (int x = 0; x < asciiart[y].length; x++) {
				System.out.print(asciiart[y][x]);
			}
			System.out.println();
		}
	}

	public static void asciiSet(char[][] asciiart, int f�rs�k) {

		// Jag s�g till att index x i asciix och asciiy (int[]) ger koordinater f�r
		// platsen d�r n�sta char som ska l�ggas till ligger i ascii (char[][])

		int cy = asciiy[f�rs�k], cx = asciix[f�rs�k];
		asciiart[cy][cx] = ascii[cy][cx];
	}

	public static boolean answer(String answer) {

		// jag hittade p� google, java metoden Pattern.matches som h�r unders�ker om
		// alla charsen i en string �r bokst�ver eller space, med ��� lagt till
		return Pattern.matches("[a-zA-Z������ ]+", answer);
	}

	public static boolean yesNo() {

		// Denna metod forts�tter i eviget om String input = scn.nextline() inte blir ja
		// eller nej
		// om input �r ja returnas true och false om input �r nej
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