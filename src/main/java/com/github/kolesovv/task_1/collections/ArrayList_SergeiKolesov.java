package com.github.kolesovv.task_1.collections;

import com.github.kolesovv.task_1.util.QuickSort;

import java.util.Arrays;
import java.util.Comparator;

public class ArrayList_SergeiKolesov<E> implements IntensiveList<E> {

    private static final int DEFAULT_CAPACITY = 10;
    private Object[] array;
    private int count = 0;
    private int size = 0;
    private boolean isSorted = false;

    public ArrayList_SergeiKolesov() {
        array = new Object[DEFAULT_CAPACITY];
    }

    public ArrayList_SergeiKolesov(int initialCapacity) {
        if (initialCapacity >= 0) {
            array = new Object[initialCapacity];
        } else {
            throw new IllegalArgumentException("Illegal capacity: " + initialCapacity);
        }
    }

    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements in this list
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Appends the specified element to the end of this list.
     *
     * @param element element to be appended to this list
     */
    @Override
    public void add(E element) {
        add(count, element);
    }

    /**
     * Inserts the specified element at the specified position in this
     * list. Shifts the element currently at that position (if any) and
     * any subsequent elements to the right (adds one to their indices).
     *
     * @param index   index at which the specified element is to be inserted
     * @param element element to be inserted
     */
    @Override
    public void add(int index, E element) {
        checkIndex(index);
        if (array.length == size) {
            array = grow();
        }
        Object[] copyOfRange = Arrays.copyOfRange(array, index, size);
        array[index++] = element;
        for (Object o : copyOfRange) {
            array[index++] = o;
        }
        isSorted = false;
        size++;
        count++;
    }

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index index of the element to return
     * @return the element at the specified position in this list
     */
    @Override
    public E get(int index) {
        checkIndex(index);
        return (E) array[index];
    }

    /**
     * Replaces the element at the specified position in this list with
     * the specified element.
     *
     * @param index   index of the element to replace
     * @param element element to be stored at the specified position
     * @return the element previously at the specified position
     */
    @Override
    public E set(int index, E element) {
        checkIndex(index);
        E oldValue = (E) array[index];
        array[index] = element;
        isSorted = false;
        return oldValue;
    }

    /**
     * Removes the element at the specified position in this list.
     * Shifts any subsequent elements to the left (subtracts one from their
     * indices).
     *
     * @param index the index of the element to be removed
     * @return the element that was removed from the list
     */
    @Override
    public E remove(int index) {
        checkIndex(index);
        E oldValue = (E) array[index];
        for (int i = index; i < array.length - 1; i++) {
            array[i] = array[i + 1];
        }
        count--;
        isSorted = false;
        return oldValue;
    }

    /**
     * Removes all of the elements from this list. The list will
     * be empty after this call returns.
     */
    @Override
    public void clear() {
        array = new Object[DEFAULT_CAPACITY];
        count = 0;
        size = 0;
    }

    @Override
    public void quickSort(Comparator<E> comparator) {
        if (!isSorted) {
            QuickSort.sort((E[]) array, 0, size - 1, comparator);
            isSorted = true;
        }
    }

    @Override
    public boolean isSorted() {
        return isSorted;
    }

    @Override
    public void split(int size) {
        if (size >= 0 && this.size > size) {
            array = Arrays.copyOf(array, size);
            this.size = size;
            count = size;
        } else {
            throw new IllegalArgumentException("Incorrect size: " + size);
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOfRange(array, 0, count));
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ArrayList_SergeiKolesov<?> that)) return false;
        return Arrays.equals(that.array, array);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(array);
    }

    private E[] grow() {
        int capacity = (size * 3) / 2 + 1;
        return (E[]) Arrays.copyOf(array, capacity);
    }

    /**
     * @param index
     * @throws IndexOutOfBoundsException if index is out of bound
     */
    public void checkIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bound: " + index);
        }
    }
}
