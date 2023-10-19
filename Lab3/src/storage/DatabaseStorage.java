package storage;

public class DatabaseStorage implements DataStorage {
    @Override
    public void saveData(String data) throws StorageException {
        try {
            // 实现保存到数据库的逻辑
            System.out.println("Save data to database.");
            // throw new StorageException("Test save Exception from database.");
        } catch (Exception e) {
            throw new StorageException("Failed to save data to database.", e);
        }
    }

    @Override
    public String readData() throws StorageException {
        try {
            // 实现从数据库读取的逻辑
            System.out.println("Read data from database.");
            // throw new StorageException("Test read Exception from database.");
            return null;
        } catch (Exception e) {
            throw new StorageException("Failed to read data from database.", e);
        }
    }
}
