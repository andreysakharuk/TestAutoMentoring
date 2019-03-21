Feature: Check login with valid and invalid credentials

    Scenario: User can log in on Buying guide page
      When Logged out user clicks Upright link in Breadcrumbs on Model page
      Then Hero section appears on Overview page
      And Logged out user clicks Buying Guide link on Overview page
      Then Label in Hero section appears on Buying Guide page
      And User log in with valid credentials
      Then Lock near Recommended link doesn't appear on Buying Guide page

    Scenario: User unable to log in with invalid credentials on Home page
      When Logged out User opens Home page
      And User log in with invalid credentials
      Then Error page is opened

