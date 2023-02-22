@JsPon
Feature: JsonPlaceHolder


  Scenario Outline: Get Specific comment

    Given JsonPlaceHolder is up and running
    When Get request is sent to get a specific comment with "<id>"
    Then specific comment details with "<id>", "<name>", "<email>" is returned with statusCode of 200

    Examples:
      | id | name                                                   | email                        |
      | 3  | odio adipisci rerum aut animi                          | Nikita@garfield.biz          |
      | 6  | et fugit eligendi deleniti quidem qui sint nihil autem | Presley.Mueller@myrl.com     |
      | 10 | eaque et deleniti atque tenetur ut quo ut              | Carmen_Keeling@caroline.name |




#  @JsPon

  Scenario Outline: Create a comment

    Given JsonPlaceHolder is up and running
    When I create a new comment with details  "<postId>", "<name>", "<email>" and "<body>" using post method
    Then  details with "<postId>", "<name>","<email>" and "<body>" are returned with status code of 201

    Examples:
      | postId | name   | email               | body                                                                   |
      | 7      | Lateef | nehemiah@gmail.com  | I love it when i hear such things                                      |
      | 20     | Abram  | bleiing@hotmail.com | I feel fustrated when i dont get the help i need at times but lagadeem |
