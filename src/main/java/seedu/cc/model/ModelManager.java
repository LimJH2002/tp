package seedu.cc.model;

import static java.util.Objects.requireNonNull;
import static seedu.cc.commons.util.CollectionUtil.requireAllNonNull;

import java.nio.file.Path;
import java.util.function.Predicate;
import java.util.logging.Logger;

import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import seedu.cc.commons.core.GuiSettings;
import seedu.cc.commons.core.LogsCenter;
import seedu.cc.model.patient.Patient;

/**
 * Represents the in-memory model of the clinic book data.
 */
public class ModelManager implements Model {
    private static final Logger logger = LogsCenter.getLogger(ModelManager.class);

    private final ClinicBook clinicBook;
    private final UserPrefs newUserPrefs;
    private final FilteredList<Patient> filteredPatients;

    /**
     * Initializes a NewModelManager with the given clinicBook and userPrefs.
     */
    public ModelManager(ReadOnlyClinicBook clinicBook, ReadOnlyUserPrefs userPrefs) {
        requireAllNonNull(clinicBook, userPrefs);

        logger.fine("Initializing with clinic book: " + clinicBook + " and user prefs " + userPrefs);

        this.clinicBook = new ClinicBook(clinicBook);
        this.newUserPrefs = new UserPrefs(userPrefs);
        this.filteredPatients = new FilteredList<>(this.clinicBook.getPatientList());
    }

    public ModelManager() {
        this(new ClinicBook(), new UserPrefs());
    }

    //=========== UserPrefs ==================================================================================

    @Override
    public void setUserPrefs(ReadOnlyUserPrefs userPrefs) {
        requireNonNull(userPrefs);
        this.newUserPrefs.resetData(userPrefs);
    }

    @Override
    public ReadOnlyUserPrefs getUserPrefs() {
        return newUserPrefs;
    }

    @Override
    public GuiSettings getGuiSettings() {
        return newUserPrefs.getGuiSettings();
    }

    @Override
    public void setGuiSettings(GuiSettings guiSettings) {
        requireNonNull(guiSettings);
        newUserPrefs.setGuiSettings(guiSettings);
    }

    @Override
    public Path getClinicBookFilePath() {
        return newUserPrefs.getClinicBookFilePath();
    }

    @Override
    public void setClinicBookFilePath(Path clinicBookFilePath) {
        requireNonNull(clinicBookFilePath);
        newUserPrefs.setClinicBookFilePath(clinicBookFilePath);
    }

    //=========== AddressBook ================================================================================

    @Override
    public void setClinicBook(ReadOnlyClinicBook clinicBook) {
        this.clinicBook.resetData(clinicBook);
    }

    @Override
    public ReadOnlyClinicBook getClinicBook() {
        return this.clinicBook;
    }

    @Override
    public boolean hasPatient(Patient patient) {
        requireNonNull(patient);
        return clinicBook.hasPatient(patient);
    }

    @Override
    public void deletePatient(Patient target) {
        clinicBook.removePatient(target);
    }

    @Override
    public void addPatient(Patient patient) {
        clinicBook.addPatient(patient);
        updateFilteredPatientList(PREDICATE_SHOW_ALL_PERSONS);
    }

    @Override
    public void setPatient(Patient target, Patient editedPatient) {
        requireAllNonNull(target, editedPatient);

        clinicBook.setPatient(target, editedPatient);
    }

    //=========== Filtered Person List Accessors =============================================================

    /**
     * Returns an unmodifiable view of the list of {@code Patient} backed by the internal list of
     * {@code versionedAddressBook}
     */
    @Override
    public ObservableList<Patient> getFilteredPatientList() {
        return filteredPatients;
    }

    @Override
    public void updateFilteredPatientList(Predicate<Patient> predicate) {
        requireNonNull(predicate);
        filteredPatients.setPredicate(predicate);
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof ModelManager)) {
            return false;
        }

        ModelManager otherModelManager = (ModelManager) other;
        return clinicBook.equals(otherModelManager.clinicBook)
                && newUserPrefs.equals(otherModelManager.newUserPrefs)
                && filteredPatients.equals(otherModelManager.filteredPatients);
    }

}
