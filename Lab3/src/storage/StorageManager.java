package storage;

public class StorageManager {
    private DataStorage currentStorage;

    public StorageManager() {
        // 默认使用数据库存储
        this.currentStorage = new DatabaseStorage();
    }

    public void save(String data) throws StorageException {
        try {
            currentStorage.saveData(data);
        } catch (StorageException e) {
            System.out.println(e.getMessage());
            // 数据库异常，切换到文件存储
            this.currentStorage = new FileStorage();
            currentStorage.saveData(data);
        }
    }

    public String read() throws StorageException {
        try {
            return currentStorage.readData();
        } catch (StorageException e) {
            System.out.println(e.getMessage());
            // 数据库异常，切换到文件存储
            this.currentStorage = new FileStorage();
            return currentStorage.readData();
        }
    }
}
