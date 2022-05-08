# Test Plan

**Author**: Team 1

## 1 Testing Strategy

### 1.1 Overall strategy

 Assumptions:
 Project team acknowledges the layout, design, and structure of the system
 Test case design activities to be done by QA
 Test environment will be provided eventually by development

 Unit testing: When making changes, execute tests to fix any reoccuring defects. Last unit test should ultimately have no defects. Afterwards, code is reviewed and uploaded to GitHub repo.

 Integration testing:
 All units/modules can be grouped together to be tested as a whole. If our system gets bigger than needed, type of integration is subject to change accordingly.

 System testing:
    Aspects to look into:
        1. Performance: Ensure that the software runs in a stable and reliable manner with an adequate speed.
        2. Stress: Check how well the system runs under various loads.

 Testing activities:
    1. Inspection: To ensure any critical defects in the app are gone before further testing. Will be done either by the entire group or QA alone depending on the issue.

    2. Functional testing: Ensure that the functions of the application work as intended. Provided by fed inputs and validated by output. QA

    3. Verification: Validating that every function/task is executed in a valid order and is done where nearly every scenario is considered. QA

    4. (Typically when a significant feature is implemented) Regression testing: For every mainline feature implemented in the app, a form of regression testing will be done to ensure that all of the current working functions still do their job properly. QA

### 1.2 Test Selection

Types of test cases should remain similar for all testing levels.

Possible test case selections:
(Numeric inputs only) Boundary Value : Testing the boundary values of valid and invalid partitions. What range should the input be valid?

Decision Table Testing: Test system behavior for different input combinations. Map as many input combinations as possible along with their behavior.

Open to more types of selections

### 1.3 Adequacy Criterion

For functional testing: Go through the testing multiple times.
First time for finding any major defects / code that stops the app entirely. Might have to work around some code to ensure that the tests/scripts pass through

Second time: Clean out any smaller issues/defects that remain. Remove the workaround when possible.

UAT and Exploratory: Once at minimum. Multiple times if absolutely needed


### 1.4 Bug Tracking

Any reoccurring bugs/errors/requests will be reported on the GitHub repo or from the team group chat. Should include the file that has the error and line number. Expected input and Actual input are encouraged to be reported.


### 1.5 Technology

Espresso/Barista and JUnit. The former for automative testing cases. JUnit just in case Espresso doesn't work out.

## 2 Test Cases

Signup button: Ensure that the username and password provided are valid. This includes the following criteria:
    Username has no special characters and is at least 3 characters long
    Password is atleast 5 characters long
    Assume (unless specifically stated otherwise) that Username/Email isn't already taken

|**Username**| **Password**| **Expected**| **Result** |
--- | --- | ---| ---|
|`!`||Account not created|"User must be in form of an email" -> Not created|
|`bobtheturtle@gmail.com`|`abc`|Account not created| "Password must have at least 5 characters" -> Not created|
|`testAccount1@gmail.com`|`abc123!@#`|Account created|No error -> Created|
|`testAccount2@gmail.com`|`abc`|Account not created| Account already exists for this username -> Not created|

Login button: Make sure the user account exists while the password is the same as entered from signup.
Enter the user name, then pw, check if account exists / pw valid, then get result.

|**Username**| **Password**| **Expected**| **Result**|
--- | --- | ---| ---|
|||No login|"username/email is required" -> No login|
|`testAccount1@gmail.com`||No login|"password is required" -> No login|
|`testAccount1@gmail.com`|`abc`|No login| "Invalid username/password -> No login|
|`bobtheturtle@gmail.com`|`xyz!@#`|No login| "Invalid username/password -> No login|
|`testAccount1@gmail.com`|`abc123!@#`|Login| "Login successful" -> Logs in|

Search (manual): When a user manually searches for a product, ensure that the user gets all relevant results.
User enters input in search bar -> Search within database -> Get results accordingly
|**Product*|**Expected**|
--- |---|
|"!@#"|`No results`| Same as expected |
|"Woo"|`Show products associated with Wood`| Same as expected |
|"Wood"|`Show products associated with Wood`| Same as expected |
|"laminate"|`Show products that are Laminated`| Same as expected |
|"sol"|`Show products with the type Solid`| Same as expected |
|"1000"|`No results`| Same as expected |
|"Hunter"|`No results`| Same as expected |
|"Enggineered"|`No results`| Same as expected |
