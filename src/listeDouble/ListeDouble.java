package listeDouble;

public class ListeDouble {
	
	//VARIABLES
	private MaillonDouble head;
	private MaillonDouble tail;
	private int size = 0;

	/**
	 * Element at indice
	 * @param indice
	 * @return
	 * @throws Exception
	 */
	public int get(int indice) throws Exception{
		return this.getMaillonAtIndice(indice).getValue();
	}
	
	/**
	 * Supprime un element
	 * @param indice
	 * @throws Exception
	 */
	public void remove(int indice) throws Exception{
		
		//Debut de liste
		if(indice == 0){
			this.head = this.head.getNext();
			this.head.setPrevious(null);
		//Fin de liste
		}else if(indice == this.size -1){
			this.tail = this.tail.getPrevious();
			this.tail.setNext(null);
		//Milieu de liste
		}else{
			MaillonDouble previous = this.getMaillonAtIndice(indice-1);
			
			if(previous.getNext() != null){
				previous.setNext(previous.getNext().getNext());
				previous.getNext().setPrevious(previous);
			}
		}
		this.size--;
	}
	
	/**
	 * Ajoute
	 * @param value
	 */
	public void add(int value) {

		if (this.estVide()) {
			this.head = new MaillonDouble(value);
			this.tail = head;
		} else {
			this.tail.setNext(new MaillonDouble(value, this.tail));
			this.tail = this.tail.getNext();
		}

		this.size++;

	}
	
	/**
	 * estVide
	 * @return
	 */
	public boolean estVide() {
		return this.head == null;
	}
	
	/**
	 * Representation chaine de char
	 */
	public String toString(){
		
		MaillonDouble tmp = this.head;
		String strValue = "";
		
		while(tmp.getNext() != null){
			strValue += tmp.getValue() + ";";
			tmp = tmp.getNext();
		}
		
		return strValue;
		
	}
	
	/**
	 * Recupere un maillon à un indice donné
	 * @param indice
	 * @return
	 * @throws Exception
	 */
	private MaillonDouble getMaillonAtIndice(int indice) throws Exception {

		if (indice > size) {
			throw new Exception("Out of Bound");
		}
		
		MaillonDouble tmp;
		//Avant la moitié, on commence à head
		if (indice < this.size / 2) {
			
			tmp = this.head;
			for (int i = 0; i < indice; i++) {
				tmp = tmp.getNext();
			}
		//Après la moitié, on commence à tail
		} else {

			tmp = this.tail;
			for (int i = 0; i < this.size - indice; i++) {
				tmp = tmp.getPrevious();
			}
		}

		return tmp;
	}

	/**
	 * MaillonDouble
	 * @author Math
	 *
	 */
	private class MaillonDouble {

		private int value;
		private MaillonDouble next;
		private MaillonDouble previous;

		public MaillonDouble(int value, MaillonDouble previous) {
			super();
			this.value = value;
			this.previous = previous;
		}

		public MaillonDouble(int value) {
			super();
			this.value = value;
		}

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}

		public MaillonDouble getNext() {
			return next;
		}

		public void setNext(MaillonDouble next) {
			this.next = next;
		}

		public MaillonDouble getPrevious() {
			return previous;
		}

		public void setPrevious(MaillonDouble previous) {
			this.previous = previous;
		}

	}
}
