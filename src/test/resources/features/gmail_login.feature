Feature: Gmail Login
  As a Gmail user
  I want to login to Gmail
  To use email services

  Background:
    Given The user was on the Gmail Login page

  @SuccessfulLogin
  Scenario: SuccessfulLogin
    When He enters his correct username and password
      | username              | password |
      | estest.0021@gmail.com | Test2021 |
    Then The user should access his inbox


  @InvalidUsername
  Scenario Outline: Invalid username
    When He enters a invalid <username>
    Then The user should see the error <message>
    Examples:
      | username               | message                                                    |
      | estest.0021@gmail.com# | Ingresa un número de teléfono o correo electrónico válidos |
      | esta~cuenta~no~existe  | No pudimos encontrar tu Cuenta de Google                   |
      | @gmail.com             | Ingresa un número de teléfono o correo electrónico válidos |
      | **                     | No pudimos encontrar tu Cuenta de Google                   |

  @InvalidPassword
  Scenario Outline: Invalid password
    When He enters his correct estest0021@gmail.com and invalid <password>
    Then The user should see the incorrect password error La contraseña es incorrecta
    Examples:
      | password |
      | test2021 |