package ramemulator;

public class MemoryStatus {
	private int full;
	private int allocated;
	private int free;

	public MemoryStatus(int full, int allocated, int free) {
		this.full = full;
		this.allocated = allocated;
		this.free = free;
	}

	public int getFull() {
		return this.full;
	}

	public int getAllocated() {
		return this.allocated;
	}

	public int getFree() {
		return this.free;
	}
}
