import java.util.Scanner;

class ZoloskiVrt{
  Scanner myObj = new Scanner(System.in);
  private Radnik[] radnici;
  private int brojRadnika;
  private Zivotinja[] zivotinje;
  private int brojZivotinja;
  private int balans;
  private int plateRadnika;
  private int prihodZoloskogVrta;
  private int dan;
  ZoloskiVrt(){
    radnici = new Radnik[20];
    brojRadnika = 0;
    plateRadnika = 0;
    zivotinje = new Zivotinja[20];
    dan = 1;
    balans = 5000;
  }

  public Radnik pretragaKrozRadnike(){
    Radnik b = null;
    System.out.println("Unesite ID radnika kojeg trazite.");
    int a = myObj.nextInt();
    myObj.nextLine();
    for (int i = 0; i < brojRadnika; i++){
      if (radnici[i].prikaziID() == a){
        b = radnici[i];
      }
    }
    return b;
  }

  public void zaposliRadnika(){
    System.out.println("Pokrenuli ste proces za zaposljavanje radnika...");
    System.out.println("Unesite ime radnika : ");
    String a = myObj.nextLine();
    System.out.println("Unesite prezime radnika : ");
    String b = myObj.nextLine();
    System.out.println("Unesite godiste radnika : ");
    int c = myObj.nextInt();
    myObj.nextLine();
    System.out.println("Unesite pol radnika : ");
    String d = myObj.nextLine();
    radnici[brojRadnika] = new Radnik(a,b,c,d,brojRadnika);
    plateRadnika += radnici[brojRadnika].prikaziPlatu();
    brojRadnika++;
    System.out.println(radnici[brojRadnika-1]);
  }

  public void odpustiRadnika(){
    if (brojRadnika > 0) {
      System.out.println("Pokrenuli ste proces za otpustanje radnika...");
      Radnik a = pretragaKrozRadnike();
      plateRadnika -= a.prikaziPlatu();
      radnici[brojRadnika-1].promeniIndeks(a.prikaziIndeks());
      radnici[a.prikaziIndeks()] = radnici[brojRadnika-1];
      radnici[brojRadnika-1] = null;
      brojRadnika--;
    }
    else{
      System.out.println("Nemate radnika da otpustite.");
    }
  }

  public void povecajPlatuRadniku(){
    System.out.println("Za koliko zelite da uvecate platu radniku? Unesite broj.");
    int a = myObj.nextInt();
    myObj.nextLine();
    pretragaKrozRadnike().povecajPlatu(a);
    plateRadnika +=a;
    System.out.println(radnici[1]);
  }

  public Zivotinja pretragaKrozZivotinje(){
    Zivotinja b = null;
    System.out.println("Unesite ID zivotinje koju trazite.");
    int a = myObj.nextInt();
    myObj.nextLine();
    for (int i = 0; i < brojZivotinja; i++){
      if (zivotinje[i].prikaziID() == a){
        b = zivotinje[i];
      }
    }
      return b;
  }

  public void kupiZivotinju(){
    System.out.println("Pokrenuli ste proces za kupovinu zivotinje....");
    if (brojRadnika <= brojZivotinja){
      System.out.println("Nemate dovoljno radnika za ovu zivotinju, zaposlite nove radnike.");
    }
    else{
      System.out.println("Unesite ime zivotinje : ");
      String a = myObj.nextLine();
      System.out.println("Unesite visinu zivotinje : ");
      int b = myObj.nextInt();
      System.out.println("Unesite tezinu zivotinje : ");
      int c = myObj.nextInt();
      myObj.nextLine();
      System.out.println("Unesite pol zivotinje : ");
      String d = myObj.nextLine();
      System.out.println("Unesite boju zivotinje");
      String e = myObj.nextLine();
      zivotinje[brojZivotinja] = new Zivotinja(a,b,c,d,e,brojZivotinja);
      prihodZoloskogVrta += zivotinje[brojZivotinja].prikaziPrihod();
      brojZivotinja++;
    }
  }

  public void prodajZivotinju(){
    System.out.println("Pokrenuli ste proces za prodaju zivotinje....");
    Zivotinja a = pretragaKrozZivotinje();
    balans+= a.prikaziCenu()/2;
    prihodZoloskogVrta -= a.prikaziPrihod();
    zivotinje[brojZivotinja-1].promeniIndeks(a.prikaziIndeks());
    zivotinje[a.prikaziIndeks()] = zivotinje[brojZivotinja-1];
    zivotinje[brojZivotinja-1] = null;
    brojZivotinja--;
  }

  public void nahraniZivotinje(){
    for (int i = 0; i<brojZivotinja; i++){
      zivotinje[i].nahraniZivotinju();
    }
  }

  public void zavrsiDan(){
    dan+=1;
    balans+= prihodZoloskogVrta;
    balans-=plateRadnika;
    for (int i = 0; i<brojZivotinja; i++){
      zivotinje[i].uciniZivotinjuGladnom();
    }
    System.out.println("Zavrsili ste danasnji dan.");
  }

  public void igrica(){
    System.out.println("Dobro dosli u igru 'Kako unistiti zoloski vrt za 10 dana' !!! ");
    System.out.println(dan);
    while (dan!=11){
      String a = "";
      while (a.equals("")){
        System.out.println("Molimo Vas unesite jednu od sledecih komandi : INFO, ZAPOSLI, ODPUSTI, KUPI, PRODAJ, NAHRANI, ZAVRSI");
        a = myObj.nextLine();
        System.out.println("\n");
        if (a.equals("INFO")){
          System.out.println(toString());
        }
        else if (a.equals("ZAPOSLI")){
          zaposliRadnika();
        }
        else if (a.equals("ODPUSTI")){
          odpustiRadnika();
        }
        else if (a.equals("KUPI")){
          kupiZivotinju();
        }
        else if (a.equals("PRODAJ")){
          prodajZivotinju();
        }
        else if (a.equals("NAHRANI")){
          nahraniZivotinje();
        }
        else if (a.equals("ZAVRSI")){
          zavrsiDan();
        }
        else{
          System.out.println("NISTE UNELI ISPRAVAN UNOS, PROBAJTE PONOVO !!!");
        }
      }
    }
  }

  public String toString(){
    String r = "\nInformacije o zaposlenima";
    for (int i=0;i<brojRadnika ;i++ ) {
      r += radnici[i].toString();
    }
    String z = "\nInformacije o zivotinjama";
    for (int i=0;i<brojZivotinja;i++){
      z += zivotinje[i].toString();
    }
    return "Trenutni dan je : " + dan + "\nBalans zoloskog vrta je : " + balans + "\nUkupne plate radnika iznose : " + plateRadnika + "\nPrihod zoloskog vrta je : " + prihodZoloskogVrta + r + z;
  }

}
