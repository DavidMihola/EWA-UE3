package memory;

public class MemoryCard<T> {

    private T front;
    private T back;
    private boolean isRevealed;
    private int index;

    public MemoryCard(T front, T back) {
        this.front = front;
        this.back = back;
        isRevealed = false;
    }

    public boolean isRevealed() {
        return isRevealed;
    }

    public void reveal() {
        isRevealed = true;
    }

    public void hide() {
        isRevealed = false;
    }

    public T getFront() {
        return front;
    }

    public T getBack() {
        return back;
    }

    public T getVisibleSide() {
        return (isRevealed ? getFront() : getBack());
    }

    public String toString() {
        return front.toString();
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }
}
