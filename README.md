Description
Repository contains test framework with next test task:

## Selenium Test Task

Implement a selenium test that executes the following steps:

1. open the check24 credit card result page under `https://finanzen.check24.de/accounts/d/kreditkarte/result.html`.
2. check whether the cookie `ppset=kreditkarte` is set in response headers.
3. click on the `weiter` button on the first of the listed products which has the number "1" on its panel (i.e. 1. Barclaycard Visa)
4. Fill in any email value and click “weiter”
5. Choose “Ich möchte als Gast fortfahren” on the opened registration form and click “weiter”
  After that a form page should appear.
6. click on the `weiter` button at the bottom of the form page. The same form page should appear with lots of error messages.
7. verify that the error messages are shown for all empty fields
8. fill in all fields with valid values, click on `weiter` button again and the next form page should appear without any error message.
9. generate a test report for the test results (optional)
