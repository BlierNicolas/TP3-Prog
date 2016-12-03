package bn;

public class Maillon {

    private Position valeur;
    private Maillon next;

 
    public Maillon(Position valeur) {
        this.valeur = valeur;
    }


    public Position getValeur() {
        return valeur;
    }


    public void setValeur(Position valeur) {
        this.valeur = valeur;
    }


    public Maillon getNext() {
        return next;
    }


    public void setNext(Maillon next) {
        this.next = next;
    }
}
