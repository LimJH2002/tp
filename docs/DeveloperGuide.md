# Developer Guide for CareCentral

## Product Scope

### Target User Profile

- **Age:** 25-60 years
- **Occupation:** Healthcare professionals including doctors, nurses, and medical practitioners
- **Tech Comfort:** Regular smartphone and app user, seeks digital solutions to streamline work
- **Needs:** Efficiently manage patient records, timely appointment reminders, and a seamless referral process

### Problem Addressed

CareCentral tackles the complexities healthcare professionals face in organizing patient records, ensuring timely appointments, and coordinating referral processes. By centralizing these tasks, it promotes a more streamlined and efficient medical practice, enabling better patient care and reduced administrative burdens.

### Value Proposition

Streamline medical practice with CareCentral, designed for healthcare professionals. Seamlessly manage patient records, ensure punctual appointments, and coordinate referrals. Elevate patient care while reducing administrative tasks, all in one intuitive platform.

## User Stories

### Doctor

- As a doctor (Age: 30-60), I can easily create, access, and edit patient records on my smartphone app to provide accurate and efficient care during patient visits.
- As a doctor, I can share and edit surgical notes and post-operative care instructions with my patients through the app, ensuring they have all the necessary information.
- As a doctor, I can securely store patient therapy notes in the app, ensuring confidentiality and continuity of care.
- As a doctor (Age: 30-60), I want to schedule, reschedule, and cancel appointments on the app to manage my day-to-day practice schedule efficiently and reduce no-shows.
- As a doctor (Age: 30-60), I can send a patient referral to a specialist using the app so that the referred professional has immediate access to necessary patient data, ensuring smooth continuation of care.
- As a doctor (Age: 30-60), I want to prescribe medications directly through the app, so that pharmacies can promptly prepare medicines and patients receive timely notifications.
- As a doctor (Age: 30-60), I can view patient feedback and reviews about their visit, enabling me to continuously improve my service and better meet their needs.

## Use Cases

### Must Have

1. **Create New Patient Records**
    - **MSS (Main Success Scenario):**
        1. Doctor chooses to create a new patient record.
        2. App prompts for the patient's details.
        3. Doctor enters the required information.
        4. App saves the new patient record.
        5. Doctor views the updated list of patient records.

2. **View All Existing Patient Records**
    - **MSS:**
        1. Doctor chooses to view all patient records.
        2. App displays the list of all patient records.

3. **View One Patient Record**
    - **MSS:**
        1. Doctor searches for a specific patient record.
        2. App displays the patient's record.

4. **Delete Patient Record**
    - **MSS:**
        1. Doctor selects a patient record to delete.
        2. App deletes the selected record.
        3. Doctor views the updated list of patient records.

### Nice to Have

1. **Delete Confirmation**
    - **MSS:**
        1. Doctor selects a patient record to delete.
        2. App prompts for confirmation.
        3. Doctor confirms the deletion.
        4. App deletes the selected record.

2. **View All Appointments**
    - **MSS:**
        1. Doctor chooses to view all appointments.
        2. App displays the list of all appointments.

3. **Edit Patient Record/Appointment**
    - **MSS:**
        1. Doctor selects a patient record or appointment to edit.
        2. App prompts for the new information.
        3. Doctor enters the updated information.
        4. App saves the changes.

### Luxury to Have

1. **Share Patient Record**
    - **MSS:**
        1. Doctor selects a patient record to share.
        2. App prompts for the recipient's details.
        3. Doctor enters the recipient's information.
        4. App shares the selected record with the recipient.

2. **Prescribe Medications**
    - **MSS:**
        1. Doctor selects a patient to prescribe medication.
        2. App prompts for the medication details.
        3. Doctor enters the required information.
        4. App sends the prescription to the pharmacy and notifies the patient.

3. **Refer to Specialist**
    - **MSS:**
        1. Doctor selects a patient to refer to a specialist.
        2. App prompts for the specialist's and patient's details.
        3. Doctor enters the required information.
        4. App sends the referral to the specialist.

4. **View Feedback and Reviews**
    - **MSS:**
        1. Doctor chooses to view feedback and reviews.
        2. App displays the list of all feedback and reviews.

## Non-Functional Requirements

1. **Performance Requirements:** The app should be able to handle up to 500 patient records without significant performance degradation.
2. **Security Requirements:** All patient data must be stored securely to ensure confidentiality and privacy.
3. **Usability Requirements:** The app should be user-friendly, with a clean and intuitive CLI interface that can be easily navigated by healthcare professionals.
4. **Compatibility Requirements:** The app should be compatible with both iOS and Android devices, ensuring accessibility for a wide range of users.

### Glossary

- **App:** Refers to the CareCentral application.
- **Healthcare Professional:** A user who is a certified medical practitioner, including doctors, nurses, 
- and other medical staff.
- **Patient Record:** A digital file within the app containing all relevant information about a patient, including 
- medical history, prescriptions, and appointment records.
- **User:** Refers to the healthcare professionals using the CareCentral app.
