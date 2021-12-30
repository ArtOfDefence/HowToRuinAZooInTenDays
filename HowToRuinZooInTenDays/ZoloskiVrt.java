import java.util.Scanner;

class ZoloskiVrt {
private Scanner skener = new Scanner(System.in);
private Radnik[] radnici = new Radnik[20];
private Zivotinja[] zivotinje = new Zivotinja[20];
private int brojRadnika = 0;
private int brojZivotinja = 0;
private int balans = 5000;
private int trosak = 0;
private int prihod = 0;
private int dan = 1;
private boolean nahranjeni = true;
ZoloskiVrt(){
}
public String toString(){
        String r = "\nInformacije o zaposlenima";
        for (int i=0; i<brojRadnika ; i++ ) {
                r += radnici[i].toString();
        }
        String z = "\nInformacije o zivotinjama";
        for (int i=0; i<brojZivotinja; i++) {
                z += zivotinje[i].toString();
        }
        return "Trenutni dan je : " + dan + ".\nBalans zoloskog vrta je : " + balans + " RSD.\nUkupne plate radnika iznose : " + trosak + " RSD.\nPrihod zoloskog vrta je : " + prihod + " RSD." + r + z;
}
public int unesiBroj(){
        int unesenBroj = -1;
        while (!skener.hasNextInt()) {
                System.out.println("Unesite samo brojeve.");
                skener.nextLine();
        }
        unesenBroj = skener.nextInt();
        skener.nextLine();
        return unesenBroj;
}
public String unesiString(){
        String unesenString="1";
        while (unesenString.matches("[a-zA-Z]+") == false) {
                System.out.println("Unesite samo slova.");
                unesenString = skener.nextLine();
        }
        return unesenString;
}
public int pretragaKrozRadnike(){
        int indeks = -1;
        System.out.println("Unesite ID radnika kojeg trazite.");
        int id = unesiBroj();
        for (int i = 0; i < brojRadnika; i++) {
                if (radnici[i].prikaziID() == id) {
                        indeks = radnici[i].prikaziIndeks();
                }
        }
        return indeks;
}
public void zaposliRadnika(){
        System.out.println("Pokrenuli ste proces za zaposljavanje radnika...");
        if (brojRadnika>19) {
                System.out.println("Nema vise radnih mesta !!!");
        }
        else{
                System.out.println("Unesite ime radnika : ");
                String ime = unesiString().toUpperCase();
                System.out.println("Unesite prezime radnika : ");
                String prezime = unesiString().toUpperCase();
                int godiste = -1;
                while ((godiste < 1910) || (godiste > 2020)) {
                        System.out.println("Unesite godiste radnika (Izmedju 1910. i 2020.) : ");
                        godiste = unesiBroj();
                }
                String pol = "";
                while ((pol.equals("MUSKARAC") == false) && (pol.equals("ZENA") == false)) {
                        System.out.println("Unesite pol radnika (MUSKARAC ili ZENA) : ");
                        pol = unesiString().toUpperCase();
                }
                System.out.println("Unesite platu novog radnika.");
                int plata = unesiBroj();
                radnici[brojRadnika] = new Radnik(ime,prezime,godiste,pol,plata,brojRadnika);
                trosak += plata;
                System.out.println("Zaposlili ste novog radnika !!!");
                radnici[brojRadnika].toString();
                brojRadnika++;
        }
}
public void otpustiRadnika(){
        if (brojRadnika > 0) {
                System.out.println("Pokrenuli ste proces za otpustanje radnika...");
                int indeks = pretragaKrozRadnike();
                if (indeks == -1) {
                        System.out.println("Trazeni radnik nije pronadjen.");
                }else{
                        Radnik odabranRadnik = radnici[indeks];
                        trosak -= odabranRadnik.prikaziPlatu();
                        radnici[brojRadnika-1].promeniIndeks(odabranRadnik.prikaziIndeks());
                        radnici[odabranRadnik.prikaziIndeks()] = radnici[brojRadnika-1];
                        radnici[brojRadnika-1] = null;
                        brojRadnika--;
                        System.out.println("Radnik je otpusten.");
                }
        }
        else{
                System.out.println("Nemate radnika da otpustite.");
        }
}
public void povecajPlatuRadniku(){
        int indeks = pretragaKrozRadnike();
        if (indeks == -1) {
                System.out.println("Trazeni radnik nije pronadjen.");
        }else{
                System.out.println("Za koliko zelite da uvecate platu radniku? Unesite broj.");
                int povisica = unesiBroj();
                Radnik odabranRadnik = radnici[indeks];
                odabranRadnik.povecajPlatu(povisica);
                trosak +=povisica;
        }
}
public int pretragaKrozZivotinje(){
        int indeks = -1;
        System.out.println("Unesite ID zivotinje koju trazite.");
        int id = unesiBroj();
        for (int i = 0; i < brojZivotinja; i++) {
                if (zivotinje[i].prikaziID() == id) {
                        indeks = zivotinje[i].prikaziIndeks();
                }
        }
        return indeks;
}
public void kupiZivotinju(){
        System.out.println("Pokrenuli ste proces za kupovinu zivotinje....");
        if (brojRadnika <= brojZivotinja) {
                System.out.println("Nemate dovoljno radnika za ovu zivotinju, zaposlite nove radnike.");
        }
        else{
                System.out.println("Unesite ime zivotinje : ");
                String ime = unesiString().toUpperCase();
                System.out.println("Unesite tezinu zivotinje : ");
                int tezina = unesiBroj();
                String pol = "";
                while ((pol.equals("MUZJAK") == false) && (pol.equals("ZENKA") == false)) {
                        System.out.println("Unesite pol zivotinje (MUZJAK ili ZENKA) : ");
                        pol = unesiString().toUpperCase();
                }
                String vrsta = "";
                while ((vrsta.equals("TIGAR") == false) && (vrsta.equals("MEDVED") == false)) {
                        System.out.println("Unesite vrstu zivotinje (TIGAR ili MEDVED) : ");
                        vrsta = unesiString().toUpperCase();
                }
                if (vrsta.equals("TIGAR")) {
                        zivotinje[brojZivotinja] = new Tigar(ime,tezina,pol,brojZivotinja);
                }else{
                        zivotinje[brojZivotinja] = new Medved(ime,tezina,pol,brojZivotinja);
                }
                prihod += zivotinje[brojZivotinja].prikaziPrihod();
                balans -= zivotinje[brojZivotinja].prikaziCenu();
                brojZivotinja++;
        }
}
public void prodajZivotinju(){
        System.out.println("Pokrenuli ste proces za prodaju zivotinje....");
        if (brojZivotinja < 1) {
                System.out.println("Prvo kupite zivotinju pa je tek onda prodajte.");
        }else{
                int indeks = pretragaKrozZivotinje();
                if (indeks == -1) {
                        System.out.println("Trazena zivotinja nije pronadjen.");
                }else{
                        Zivotinja nadjenaZivotinja = zivotinje[indeks];
                        balans+= nadjenaZivotinja.prikaziCenu()/2;
                        prihod -= nadjenaZivotinja.prikaziPrihod();
                        zivotinje[brojZivotinja-1].promeniIndeks(nadjenaZivotinja.prikaziIndeks());
                        zivotinje[nadjenaZivotinja.prikaziIndeks()] = zivotinje[brojZivotinja-1];
                        zivotinje[brojZivotinja-1] = null;
                        brojZivotinja--;
                        System.out.println("Prodali ste zivotinju.");
                }
        }
}
public void nahraniZivotinje(){
        if (brojZivotinja > 0) {
                for(int i=0; i<brojZivotinja; i++) {
                        zivotinje[i].zvuk();
                }
                nahranjeni = true;
        }else{
                System.out.println("Nemate sta da hranite, kupite nesto prvo pa uzmite da hranite.");
        }
}
public void zavrsiDan(){
        if (nahranjeni == false && brojZivotinja > 0) {
                System.out.println("ZABORAVIO SI DA NAHRANIS ZIVOTINJE SRAMOTO JEDNA !!!");
        }
        dan+=1;
        balans+= prihod;
        balans-=trosak;
        nahranjeni = false;
        System.out.println("Zavrsili ste danasnji dan.");
}
public void igrica(){
        System.out.println("Dobro dosli u igru 'Kako unistiti zoloski vrt za 10 dana' !!!");
        while (dan!=11) {
                String komanda = "";
                while (komanda.equals("")) {
                        System.out.println("Molimo Vas unesite jednu od sledecih komandi : INFO, ZAPOSLI, OTPUSTI, POVISICA, KUPI, PRODAJ, NAHRANI, ZAVRSI");
                        komanda = skener.nextLine().toUpperCase();
                        if (komanda.equals("INFO")) {
                                System.out.println(toString());
                        }
                        else if (komanda.equals("ZAPOSLI")) {
                                zaposliRadnika();
                        }
                        else if (komanda.equals("OTPUSTI")) {
                                otpustiRadnika();
                        }
                        else if (komanda.equals("KUPI")) {
                                kupiZivotinju();
                        }
                        else if (komanda.equals("PRODAJ")) {
                                prodajZivotinju();
                        }
                        else if (komanda.equals("NAHRANI")) {
                                if (brojZivotinja > 0) {
                                        nahraniZivotinje();
                                }else{
                                        System.out.println("NEMATE ZIVOTINJE, NEMATE KOGA DA HRANITE, NABAVITE ZIVOTINJE");
                                }
                        }
                        else if (komanda.equals("ZAVRSI")) {
                                zavrsiDan();
                        }
                        else if (komanda.equals("POVISICA")) {
                                povecajPlatuRadniku();
                        }
                        else{
                                System.out.println("NISTE UNELI ISPRAVAN UNOS, PROBAJTE PONOVO !!!");
                        }
                }
        }
        System.out.println("Igrica je zavrsena, evo kako Zoloski Vrt izgleda na kraju.");
        System.out.println(toString());
        System.out.println("Pritisnite ENTER za izlazak.");
        skener.nextLine();
}
}
