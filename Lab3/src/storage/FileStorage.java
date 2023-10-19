package storage;

public class FileStorage implements DataStorage {
    @Override
    public void saveData(String data) throws StorageException {
        try {
            // 实现保存到文件的逻辑
            System.out.println("Save data to file.");
        } catch (Exception e) {
            throw new StorageException("Failed to save data to file", e);
        }
    }

    @Override
    public String readData() throws StorageException {
        try {
            // 实现从文件读取的逻辑
            System.out.println("Read data from file.");
            return null;
        } catch (Exception e) {
            throw new StorageException("Failed to read data from file", e);
        }
    }
}
