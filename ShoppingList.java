/**
 * @author YINGJIN CUI
 * @version 1.0 since 2020-03
 *
 *          Student name: Fernanda Garcia Completion date: 11/17
 *
 *          ShoppingList.txt: the template file of ShoppingList.java Student
 *          tasks: implement tasks #1, #2 and #3 as specified in this file
 */

public class ShoppingList {
	private Item[] list;
	private int numberOfItems;

	public ShoppingList(int initialSize) {
		list = new Item[initialSize];
	}

	public void insert(Item item) {

		// *** Student task #1 ***

		/*
		 * Requirements:
		 * 
		 * 1. if null item is not allowed: do nothing if null 2. if the list is full,
		 * double the array size-dynamic array allocation 3. No duplicated items-all
		 * items' names must be unique. If an item with the same name already exists in
		 * the list, simply add quantity to the existing item in the list 4. insert the
		 * item to the array to maintain sorted-items are sorted based on item names.
		 *** 
		 * Enter your code below ***
		 */
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

		// *** Student task #2 ***

		/*
		 * Requirements:
		 * 
		 * 1. If item not found(item name), display the item does not exists in the list
		 * otherwise, remove the item from the list. 2. Hint: You do need to shift all
		 * items after removed one.
		 *** 
		 * Enter your code below ***
		 */
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
		// *** Student task #3 ***

		/*
		 * Requirements:
		 * 
		 * 1. If item not found(item name), display the item does not exists in the list
		 * otherwise, remove the item from the list. 2. Hint: You do need to shift all
		 * items after removed one.
		 *** 
		 * Enter your code below ***
		 */

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
