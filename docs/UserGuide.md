# User Guide

## 1. Create Patient Record

**What it does:**  
Adds a new patient record to the system.

**Command Format:**  
`add-patient n/NAME ic/NRIC a/AGE p/PHONE_NUMBER`


**Example Commands:**  
`add-patient n/Jane Doe ic/0123456A a/45 e/janedoe@example.com`

**Acceptable Values:**
- **NAME:** Alphabetic characters and spaces only
- **NRIC:** 8-16 Alphanumeric characters
- **AGE:** Integer values between 0 and 120
- **PHONE_NUMBER:** 8-12 digits integer

**Expected Output (Success):**  
CLI: A new entry appears in the list of patients.  
Message: "Successfully added patient: [Patient Details]"

**Expected Output (Failure):**
- Message: "Invalid input. Please enter a valid name."
- Message: "Invalid input. Please enter a valid NRIC (8-16 alphanumeric characters)."
- Message: "Invalid input. Age should be between 0 to 120"
- Message: "Invalid input. Please enter a valid phone number."

---
