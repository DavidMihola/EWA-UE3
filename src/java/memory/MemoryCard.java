package memory;

public class MemoryCard<T> {

	private T content;
	private boolean revealed;

	public MemoryCard (T content) {
		this.content = content;
		revealed = false;
	}

	public boolean isRevealed() {
		return revealed;
	}

	public void reveal() {
		revealed = true;
	}

	public void hide() {
		revealed = false;
	}

	public T getContent() {
		return content;
	}

	public String toString() {
		return content.toString();
	}

}
