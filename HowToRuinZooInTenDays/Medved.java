class Medved extends Zivotinja{
  private String vrsta;
  private int cena;
  private int prihod;
  Medved(String ime, int visina, int tezina, String pol, String boja ){
    super(ime,visina,tezina,pol,boja);
    vrsta = "Medved";
    cena = 1000;
    prihod = 200;
  }
  public String toString(){
    return super.toString() + "\n Vrsta : " + vrsta + " }";
  }
  public String zvuk(){
    return "Medved kaze RROOO.";
  }

}
