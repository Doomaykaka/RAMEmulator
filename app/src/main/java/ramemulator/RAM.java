package ramemulator;

import java.util.ArrayList;
import java.util.List;

public class RAM {
	private List<Integer> memory;
	private int maxMemory;

	public RAM(int maxFreeMemory) {
		try {
			if (maxFreeMemory <= 0) {
				throw new MemoryException("Bad memory size");
			}

			maxMemory = maxFreeMemory;

			memory = new ArrayList<Integer>();
			for (int cell = 0; cell < maxFreeMemory; cell++) {
				memory.add(null);
			}
		} catch (MemoryException e) {
			System.err.println(e.getMessage());
		}
	}

	public int allocateMemory(int size) {
		int placeAddress = -1;
		
		try {
			if (size <= 0) {
				throw new MemoryException("Bad memory size");
			}

			int placeSize = 0;
			for (int currentAddress = 0; currentAddress < maxMemory; currentAddress++) {
				if (memory.get(currentAddress) == null) {
					if (placeSize == 0) {
						placeAddress = currentAddress;
					}
					placeSize++;
				} else {
					placeSize = 0;
					placeAddress = -1;
				}

				if (placeSize >= size) {
					break;
				}

			}

			if ((placeAddress != -1) && (placeSize >= size)) {
				int allocatedCells = 0;
				for (int currentAddress = placeAddress; currentAddress < size; currentAddress++) {
					memory.set(currentAddress, 0);
				}
			} else {
				throw new MemoryException("Not enought memory");
			}
		} catch (MemoryException e) {
			System.err.println(e.getMessage());
		}
		
		return placeAddress;
	}

	public int allocateMemory(int startAddress, int endAddress) {
		int placeAddress = -1;
		
		try {
			validateAddress(startAddress, endAddress);

			for (int currentAddress = startAddress; currentAddress < endAddress; currentAddress++) {
				if (memory.get(currentAddress) != null) {
					throw new MemoryException("Memory part in use");
				}
				memory.set(currentAddress, 0);
			}
			
			placeAddress = startAddress;
		} catch (MemoryException e) {
			System.err.println(e.getMessage());
		}
		
		return placeAddress;
	}

	public void freeUpMemory(int startAddress, int endAddress) {
		try {
			validateAddress(startAddress, endAddress);

			for (int currentAddress = startAddress; currentAddress <= endAddress; currentAddress++) {
				memory.set(currentAddress, null);
			}
		} catch (MemoryException e) {
			System.err.println(e.getMessage());
		}
	}

	public MemoryStatus getMemoryStatus() {
		int allocated = 0;

		for (int currentAddress = 0; currentAddress < maxMemory; currentAddress++) {
			if (memory.get(currentAddress) != null) {
				allocated++;
			}
		}

		return new MemoryStatus(maxMemory, allocated, maxMemory - allocated);
	}

	public void freeUpMemory() {
		for (int currentAddress = 0; currentAddress < maxMemory; currentAddress++) {
			memory.set(currentAddress, null);
		}
	}

	public void defragment() {
		int firstFreeCell = -1; // does not exist

		for (int currentAddress = 0; currentAddress < maxMemory; currentAddress++) {
			if ((memory.get(currentAddress) == null) && (firstFreeCell == -1)) {
				firstFreeCell = currentAddress;
			}
			if ((memory.get(currentAddress) != null) && (firstFreeCell != -1)) {
				memory.set(firstFreeCell, memory.get(currentAddress));
				memory.set(currentAddress, null);
				firstFreeCell++;
			}

		}

	}
	
	protected void validateAddress(int startAddress, int endAddress) throws MemoryException{
		if (
				startAddress < 0 
				|| endAddress < 0 
				|| endAddress < startAddress
				|| endAddress > maxMemory - 1
			) {
				throw new MemoryException("Bad memory address");
			}
	}
}
