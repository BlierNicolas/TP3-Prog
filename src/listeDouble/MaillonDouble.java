package listeDouble;

public class MaillonDouble {
	//VARIABLES
    private MaillonDouble next;
    private MaillonDouble previous;
    private int value;

    /**
     * Constructeur
     *
     * @param valeur
     */
    public MaillonDouble(int valeur) {
        this.value = valeur;
    }

    /**
     *
     * @return
     */
    public MaillonDouble getNext() {
        return next;
    }

    /**
     *
     * @param next
     */
    public void setNext(MaillonDouble next) {
        this.next = next;
    }

    /**
     *
     * @return
     */
    public MaillonDouble getPrevious() {
        return previous;
    }

    /**
     *
     * @param previous
     */
    public void setPrevious(MaillonDouble previous) {
        this.previous = previous;
    }

    /**
     *
     * @return
     */
    public int getValue() {
        return value;
    }

    /**
     *
     * @param value
     */
    public void setValue(int value) {
        this.value = value;
    }
}
