package lab12;


public interface FileIO {
	void saveRecordToFile();
	boolean getRecordFromFile(int count);
	void dumpFile(int count);
	void updateRecordToFile();
}
