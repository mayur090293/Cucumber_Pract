Feature: CRM login

Scenario Outline: Login with valid credentials

Given User is on login page
When User enters "<username>" and "<password>"
Then Login button is clicked
Then User should be navigated to the home page
Then Close browser instance

Examples:
| username | password |
| mayurvmahagaonkar@gmail.com | Mayurm@123 |
| admin | admin@123 |

