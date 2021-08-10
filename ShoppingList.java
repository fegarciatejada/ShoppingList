

public class ShoppingList {
	private Item[] list;
	private int numberOfItems;

	public ShoppingList(int initialSize) {
		list = new Item[initialSize];
	}

	public void insert(Item item) {

	
		if (this.isFull())
			this.doubling();

		// nulls aren't allowed so only add item if not null
		if (item != null) {

			// item doesn't exist -> add item
			if (this.indexOf(item) == -1)
				list[numberOfItems++] = item;

			// item exists -> add quantity to the existing item
			else {
				int i = this.indexOf(item.getName());
				int qnt = list[i].getQuantity();
				list[i].setQuantity(qnt + item.getQuantity());
			}
		}
		for (int i = 0; i < numberOfItems; i++) {
			for (int j = 0; j < numberOfItems; j++) {
				if (list[i].compareTo(list[j]) < 0) {
					
					Item hold = list[i];
					list[i] = list[j];
					list[j] = hold;
				}
			}

		}
	}

	public void remove(Item item) {

		
		int index = indexOf(item);
		if (index == -1)
			System.out.println("The item does not exists in the list.");
		else {
			for (int i = index; i < numberOfItems; i++)
				list[i] = list[i + 1];

			numberOfItems--; // to decrease
		}
	}

	public void remove(String name) {
		

		int index = indexOf(name);
		if (index == -1)
			System.out.println("The item does not exists in the list.");
		else {
			for (int i = index; i < numberOfItems; i++)
				list[i] = list[i + 1];

			numberOfItems--; // to decrease
		}

	}

	private void doubling() {

		Item[] tmp = new Item[list.length * 2];
		for (int i = 0; i < list.length; i++) {
			tmp[i] = list[i];
		}
		list = tmp;
	}

	public int indexOf(Item item) {

		for (int i = 0; i < numberOfItems; i++) {
			if (list[i].compareTo(item) == 0)
				return i;
		}
		return -1;
	}

	public int indexOf(String name) {

		name = name.toLowerCase();
		for (int i = 0; i < numberOfItems; i++) {
			if (list[i].getName().toLowerCase().compareTo(name) == 0)
				return i;
		}
		return -1;
	}

	public boolean isFull() {
		return numberOfItems == list.length;
	}

	public boolean isEmpty() {
		return numberOfItems == 0;
	}

	public int size() {
		return numberOfItems;
	}

	public void printNames() {
		System.out.print("[");
		for (int i = 0; i < numberOfItems; i++) {
			System.out.print(list[i].getName());
			if (i < numberOfItems - 1)
				System.out.print(", ");
		}
		System.out.println("]");
	}

	public void print() {
		for (int i = 0; i < numberOfItems; i++) {
			System.out.println((i + 1) + ". " + list[i].toString());
		}
	}
}
