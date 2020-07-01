BINGO-TAMBOLA Springboot application Application

APIS:

1. /api/game/create -> game_id  - POST 
2. /api/game/{game_id}/ticket/{user_name}/generate -> ticket_id - POST
3. /ticket/{ticket_id} -> return 2-D array 9*3 ticket - GET
4. /api/game/{game_id}/number/random -> pick random number for game without duplicates - GET
5. /api/game/{game_id}/numbers -> returns all numbers picked for this game until now - GET
6. /api/game/{game_id}/stats -> stats of the game {numbers drawn/no of tickets/no of users} - GET


Steps to run the application

1. ./gradlew clean build

2. docker build -t tambola-api .

3. docker-compose up
