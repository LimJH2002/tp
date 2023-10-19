package seedu.cc.storage;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;
import java.util.logging.Logger;

import seedu.cc.commons.core.LogsCenter;
import seedu.cc.commons.exceptions.DataLoadingException;
import seedu.cc.model.ReadOnlyUserPrefs;
import seedu.cc.model.UserPrefs;
import seedu.cc.model.ReadOnlyClinicBook;


/**
 * Manages storage of AddressBook data in local storage.
 */
public class StorageManager implements Storage {

    private static final Logger logger = LogsCenter.getLogger(StorageManager.class);
    private ClinicBookStorage clinicBookStorage;
    private UserPrefsStorage userPrefsStorage;

    /**
     * Creates a {@code StorageManager} with the given {@code AddressBookStorage} and {@code UserPrefStorage}.
     */
    public StorageManager(ClinicBookStorage clinicBookStorage, UserPrefsStorage userPrefsStorage) {
        this.clinicBookStorage = clinicBookStorage;
        this.userPrefsStorage = userPrefsStorage;
    }

    // ================ UserPrefs methods ==============================
    @Override
    public Path getUserPrefsFilePath() {
        return userPrefsStorage.getUserPrefsFilePath();
    }

    @Override
    public Optional<UserPrefs> readUserPrefs() throws DataLoadingException {
        return userPrefsStorage.readUserPrefs();
    }

    @Override
    public void saveUserPrefs(ReadOnlyUserPrefs userPrefs) throws IOException {
        userPrefsStorage.saveUserPrefs(userPrefs);
    }


    // ================ AddressBook methods ==============================

    @Override
    public Path getClinicBookFilePath() {
        return clinicBookStorage.getClinicBookFilePath();
    }

    @Override
    public Optional<ReadOnlyClinicBook> readClinicBook() throws DataLoadingException {
        return readClinicBook(clinicBookStorage.getClinicBookFilePath());
    }

    @Override
    public Optional<ReadOnlyClinicBook> readClinicBook(Path filePath) throws DataLoadingException {
        logger.fine("Attempting to read data from file: " + filePath);
        return clinicBookStorage.readClinicBook(filePath);
    }

    @Override
    public void saveClinicBook(ReadOnlyClinicBook clinicBook) throws IOException {
        saveClinicBook(clinicBook, clinicBookStorage.getClinicBookFilePath());
    }

    @Override
    public void saveClinicBook(ReadOnlyClinicBook addressBook, Path filePath) throws IOException {
        logger.fine("Attempting to write to data file: " + filePath);
        clinicBookStorage.saveClinicBook(addressBook, filePath);
    }

}
