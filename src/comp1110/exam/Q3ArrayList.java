package comp1110.exam;

/**
 * COMP1110 Final Exam, Question 3
 */
public class Q3ArrayList<T> {
    private static final int INITIAL_SIZE = 2;
    private static final double GROWTH_FACTOR = 1.5;

    T[] values = (T[]) new Object[INITIAL_SIZE];
    int elements = 0;

    /**
     * Add a value to the tail of the list.
     *
     * @param value The value to be added.
     */
    public void add(T value) {
        if (elements == values.length) {
            T[] temp = values;
            values = (T[]) new Object[(int) (elements * GROWTH_FACTOR)];
            for (int i = 0; i < temp.length; i++) {
                values[i] = temp[i];
            }
        }
        if (value != null) {
            values[elements++] = value;
        }
    }

    /**
     * Remove the value at the specified index from the list.
     *
     * @param index
     */
    public void remove(int index) {
        if (index >= elements || index < 0) {
            throw new IndexOutOfBoundsException ();
        }
        T[] temp = (T[]) new Object[values.length - 1];
        for (int i = 0; i < index; i++) {
            temp[i] = values[i];
        }
        for (int i = index; i < values.length - 1; i++) {
            temp[i] = values[i + 1];
        }
        values = temp;
        elements--;
    }

    /**
     * @param index
     * @return The value at the specified index.
     */
    public T get(int index) {
        if (index >= elements || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        return values[index];
    }

    /**
     * @return the current size of the list.
     */
    public int size() {
        return elements;
    }

    /**
     * Reverse the order of the elements of the list.
     */
    public void reverse() {
        if (elements <= 1) {
            return;
        }
        T temp;
        for (int i = 0; i < elements / 2; i++) {
            temp = values[i];
            values[i] = values[elements - 1 - i];
            values[elements - 1 - i] = temp;
        }
    }

    /**
     * @return A string representation of the list.
     */
    @Override
    public String toString() {
        String rtn = "";
        for (int i = 0; i < elements; i++) {
            rtn += ((i != 0) ? " " : "") + values[i];
        }
        return rtn;
    }
}
