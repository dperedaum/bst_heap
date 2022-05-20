package heap;

public class MyHeapImpl<T extends Comparable<T>> implements MyHeap<T> {

    private T[] values;

    private int indexNextElement = 0;

    private boolean isHeapMax;

    public MyHeapImpl(T[] values, boolean isHeapMax) {
        this.values = values;
        this.isHeapMax = isHeapMax;
    }

    @Override
    public void insert(T value) {
        values[indexNextElement] = value;
        int elementIndex = indexNextElement;
        indexNextElement++;

        int fatherIndex = getFatherIndex(elementIndex);

        while(value.compareTo(this.values[fatherIndex]) > 0 &&
                elementIndex != 0) {

            // hacer permutacion
            // bajo el padre a donde esta el hijo
            values[elementIndex] = this.values[fatherIndex];
            // subo al hijo
            values[fatherIndex] = value;

            elementIndex = fatherIndex;
            fatherIndex = getFatherIndex(elementIndex);
    }



    }

    private int getFatherIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }

    private int getLeftChildIndex(int fatherIndex) {

        return 2 * fatherIndex + 1;
    }

    private int getRightChildIndex(int fatherIndex) {

        return 2 * fatherIndex + 2;
    }

    @Override
    public T delete() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }
}
