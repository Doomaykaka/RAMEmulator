package ramemulator;

public class App {

	public static void main(String[] args) {
		int maxMemory = 1024;
		RAM currentRAM = new RAM(maxMemory);

		currentRAM.allocateMemory(256);

		currentRAM.allocateMemory(512, 768);
		
		currentRAM.allocateMemory(257);

		currentRAM.freeUpMemory(125, 256);

		currentRAM.defragment();

		MemoryStatus info = currentRAM.getMemoryStatus();

		currentRAM.freeUpMemory();
	}
}
