Feature: PetStore API Tests

  Background:
    * url 'https://petstore.swagger.io/v2'

  Scenario: Add a pet to the store
    * def pet =
      """
      {
        "id": 0,
        "category": {
          "id": 0,
          "name": "string"
        },
        "name": "Buddy",
        "photoUrls": [
          "string"
        ],
        "tags": [
          {
            "id": 0,
            "name": "string"
          }
        ],
        "status": "available"
      }
      """

    Given path 'pet'
    And request pet
    When method post
    Then status 200
    * def petId = response.id
    * print 'created pet id is: ', petId

  Scenario: Get the pet by ID
    Given path 'pet', petId
    When method get
    Then status 200
    And match response.name == 'Buddy'
    And match response.status == 'available'

  Scenario: Update pet status to "sold" and name
    * def updatedPet =
      """
      {
        "id": 123456,  // Replace this with the actual petId obtained from the previous scenario
        "category": {
          "id": 0,
          "name": "string"
        },
        "name": "Buddy Updated",
        "photoUrls": [
          "string"
        ],
        "tags": [
          {
            "id": 0,
            "name": "string"
          }
        ],
        "status": "sold"
      }
      """

    Given path 'pet'
    And request updatedPet
    When method put
    Then status 200

  Scenario: Get pets by status "sold"
    Given path 'pet/findByStatus'
    And param status = 'sold'
    When method get
    Then status 200
    And match response[0].name == 'Buddy Updated'