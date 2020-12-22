Feature: naurki automation

@TC1 @ValidCredentials
  Scenario: Naukri Login With Valid Credentials
    Given landing on naukri home page "https://www.naukri.com/"
    Then click on login button
    When enter username
    |uname|%dinesh.amineni93@gmail.com%|
    And enter password
    |pwd|%System20#%|
    Then click on submit button
        #And ignore if alert is present
        And mouse hover to the My Naurki tab
    Then click on logout 
    And quit the browser
    
@TC2 @InvalidCase
Scenario: Naukri Login With Invalid Credentials
    Given landing on naukri home page "https://www.naukri.com/"
    Then click on login button
    When enter username
    |uname|dummy@gmail.com|
    And enter password
    |pwd|welcome|
    Then click on submit button
    And verify the error message
    And quit the browser

@TC3 @UploadResume
 Scenario: Uploading Resume in Naukri
    Given landing on naukri home page "https://www.naukri.com/"
    Then click on login button
    When enter username
    |uname|%dinesh.amineni93@gmail.com%|
    And enter password
    |pwd|System20#|
    Then click on submit button
        #And ignore if alert is present
    And click on update profile
    Then uploading the CV document
    And mouse hover to the My Naurki tab
    Then click on logout 
    And quit the browser
 
 @TC4 @DeleteResume
 
 Scenario: Delete The Resume In Naukri
    Given landing on naukri home page "https://www.naukri.com/"
		#|url|https://www.naukri.com/|
    Then click on login button
    When enter username
    |uname|%dinesh.amineni93@gmail.com%|
    And enter password
    |pwd|System20#|
    Then click on submit button
        #And ignore if alert is present
    And click on update profile
    And delete the resume
    And mouse hover to the My Naurki tab
    Then click on logout 
    And quit the browser
    

	@TC5  @E2ECase
  Scenario: Naukri E2E Test Case
    Given landing on naukri home page "https://www.naukri.com/"
		#|url|https://www.naukri.com/|
    Then click on login button
    When enter username
    |uname|%dinesh.amineni93@gmail.com%|
    And enter password
    |pwd|System20#|
    Then click on submit button
    #And ignore if alert is present
    And click on update profile
    Then uploading the CV document
    And delete the resume
    And mouse hover to the My Naurki tab
    Then click on logout 
    And quit the browser
