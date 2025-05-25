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
    * print 'Created pet id is: ', petId

  Scenario: Get a pet by specific ID
    Given path 'pet', 1
    When method get
    Then status 200
    And match response.id == 1
    And match response.status == 'available'

  Scenario: Update the pet's name to "Pepito" and status to "sold"
    * def updatedPet =
      """
      {
        "id": 3,
        "category": {
          "id": 0,
          "name": "string"
        },
        "name": "Pepito",
        "photoUrls": ["string"],
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

  Scenario: Consultar la mascota modificada por estatus
    Given path 'pet/findByStatus'
    And param status = 'sold'
    When method get
    Then status 200
    * def foundPets = response
    * def updatedPet = foundPets.find(p => p.name == 'Pepito')
    * match updatedPet.name == 'Pepito'
    * match updatedPet.status == 'sold'