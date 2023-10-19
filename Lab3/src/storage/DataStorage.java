package storage;

public interface DataStorage {
    void saveData(String data) throws StorageException;
    String readData() throws StorageException;
}
