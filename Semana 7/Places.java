import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Classe de exemplo para o Guiao de iteradores
 * 
 * @author LabP
 *
 */
public class Places implements Iterable<Integer> {

	/**
	 * Define os valores possiveis para os lugares
	 * 
	 * @author LabP
	 *
	 */
	public enum POSITIONS {
		AVAILABLE, OCCUPY
	}

	// Posicoes existentes
	private POSITIONS[] elems;

	/**
	 * Inicializa um novo objeto
	 * 
	 * @param size
	 * @requires size > 0
	 */
	public Places(int size) {
		elems = new POSITIONS[size];
	}

	/**
	 * Ocupar um dado lugar
	 * 
	 * @param place
	 *            O numero do lugar
	 * @requires available(place)
	 */
	public void occupy(int place) {
		elems[place] = Places.POSITIONS.OCCUPY;
	}

	/**
	 * Desocupar um dado lugar
	 * 
	 * @param place
	 *            O numero do lugar
	 * @requires occupy(place)
	 */
	public void available(int place) {
		elems[place] = Places.POSITIONS.AVAILABLE;
	}

	/**
	 * O iterador associado a este objeto, que itera sobre os lugares ocupados
	 * 
	 * @return Todos os lugares ocupados
	 */
	public Iterator<Integer> iterator() {
		return new PlaceIterator();
	}

	/**
	 * Classe que representa um iterador de lugares ocupados
	 * 
	 * @author LabP
	 */
	private class PlaceIterator implements Iterator<Integer> {

		private int index;

		/**
		 * Construtor
		 */
		private PlaceIterator() {
			index = -1;
		}

		/**
		 * Qual o proximo lugar ocupado?
		 * 
		 * @return O proximo lugar ocupado; se não existir retorna null
		 */
		private Integer nextOccupy() {
			Integer next = index + 1;
			boolean found = false;
			while (!found && next < elems.length) {
				// verifica se é uma posição ocupada
				if (elems[next] == Places.POSITIONS.OCCUPY) {
					found = true;
				} else {
					// avança o index até encontrar posição ocupada.
					next++;
				}
			}
			if (!found) {
				next = null;
			}
			return next;
		}

		/**
		 * Retorna o proximo lugar ocupado, se existir, e atualiza o estado do iterador
		 * 
		 * @throws NoSuchElementException
		 *             se nao existir mais nenhum lugar ocupado
		 */
		public Integer next() {

			Integer next = nextOccupy();

			if (next != null) {
				index = next;
				return next;
			} else {
				throw new NoSuchElementException();
			}

		}

		/**
		 * Existe mais algum lugar ocupado?
		 */
		public boolean hasNext() {
			return nextOccupy() != null;
		}
	}

}
