Feature: Create new company

Scenario: Create new company with valid details.
 
 Given User is on CRM login page
 When User enters CRM username and password
 | mayurvmahagaonkar@gmail.com | Mayurm@123 |
 
 Then User clicks on login button
 Then User should land on home page
 Then User clicks on Companies menu in left panel
 Then User clicks New button
 Then User enters "Zap"
 Then User changes access to private 
 Then User inputs mobile and home number
 Then User selects Status
 Then User uploads image
 Then User saves the company details
 