package seedu.cc.storage;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;

import seedu.cc.commons.exceptions.DataLoadingException;
import seedu.cc.model.ReadOnlyUserPrefs;
import seedu.cc.model.UserPrefs;
import seedu.cc.model.ReadOnlyClinicBook;


/**
 * API of the Storage component
 */
public interface Storage extends ClinicBookStorage, UserPrefsStorage {

    @Override
    Optional<UserPrefs> readUserPrefs() throws DataLoadingException;

    @Override
    void saveUserPrefs(ReadOnlyUserPrefs userPrefs) throws IOException;

    @Override
    Path getClinicBookFilePath();

    @Override
    Optional<ReadOnlyClinicBook> readClinicBook() throws DataLoadingException;

    @Override
    void saveClinicBook(ReadOnlyClinicBook addressBook) throws IOException;

}
