package storage;

public class Tester {
    public static class StorageTester {

        public static void main(String[] args) throws StorageException {
            TestFileStorage();
            TestDatabaseStorage();
        }

        public static void TestFileStorage() throws StorageException {
            FileStorage fileStorage = new FileStorage();
            fileStorage.readData();
            fileStorage.saveData("Test data");
            fileStorage.readData();
        }

        public static void TestDatabaseStorage() throws StorageException {
            DatabaseStorage databaseStorage = new DatabaseStorage();
            databaseStorage.readData();
            databaseStorage.saveData("Test data");
            databaseStorage.readData();
        }
    }

    public static class StorageManagerTester {

        public static void main(String[] args) throws StorageException {
            TestStorageManager();
        }

        public static void TestStorageManager() throws StorageException {
            StorageManager storageManager = new StorageManager();
            storageManager.read();
            storageManager.save("New data");
            storageManager.read();
        }
    }
}
