@all
Feature: contact tests
  Find information on the Contact page

  Scenario: open wave-access site
    Given page "google.com" is opened
    When set "Search" field value to "wave-access"
    Then run a search
    And click the result link "wave-access.com"

  Scenario: open Contact page and check information exist
    When click "Contact" link in navigation menu
    Then check that current URL is "https://www.wave-access.com/public_en/contacts.aspx"
    And check that text exists on the page
      | Want us to connect with you? |
      | Our Offices                  |
      | Rochester, United Kingdom    |
      | +44 7770 395633              |
      | www.wave-access.uk           |