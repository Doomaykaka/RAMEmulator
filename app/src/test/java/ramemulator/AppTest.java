package ramemulator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {

	@Test
	void RAMHasARightMemorySize() {
		RAM RAMUnderTest = new RAM(12);
		int fullRAM = RAMUnderTest.getMemoryStatus().getFull();
		assertTrue(fullRAM == 12);
	}

	@Test
	void RAMHasARightAllocating() {
		RAM RAMUnderTest = new RAM(12);
		RAMUnderTest.allocateMemory(2);
		MemoryStatus memoryStatus = RAMUnderTest.getMemoryStatus();
		assertTrue(
			memoryStatus.getFull() == 12 
			&& memoryStatus.getAllocated() == 2
			&& memoryStatus.getFree() == 10
		);
	}

	@Test
	void RAMHasARightAddressAllocating() {
		RAM RAMUnderTest = new RAM(12);
		RAMUnderTest.allocateMemory(3, 6);
		MemoryStatus memoryStatus = RAMUnderTest.getMemoryStatus();
		assertTrue(
			memoryStatus.getFull() == 12 
			&& memoryStatus.getAllocated() == 3
			&& memoryStatus.getFree() == 9
		);
	}

	@Test
	void RAMHasARightFreeUpMemory() {
		RAM RAMUnderTest = new RAM(12);
		RAMUnderTest.allocateMemory(4);
		RAMUnderTest.freeUpMemory(1, 2);
		MemoryStatus memoryStatus = RAMUnderTest.getMemoryStatus();
		assertTrue(
			memoryStatus.getFull() == 12 
			&& memoryStatus.getAllocated() == 2
			&& memoryStatus.getFree() == 10
		);
	}

	@Test
	void RAMHasARightMemoryStatus() {
		RAM RAMUnderTest = new RAM(12);
		RAMUnderTest.allocateMemory(4);
		MemoryStatus memoryStatus = RAMUnderTest.getMemoryStatus();
		assertTrue(
			memoryStatus.getFull() == 12 
			&& memoryStatus.getAllocated() == 4
			&& memoryStatus.getFree() == 8
		);
	}
}
