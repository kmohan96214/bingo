BINGO-TAMBOLA Springboot application Application

APIS:

1. /api/game/create -> game_id
2. /api/game/{game_id}/ticket/{user_name}/generate -> ticket_id
3. /ticket/{ticket_id} -> return 2-D array 9*3 ticket
4. /api/game/{game_id}/number/random -> pick random number for game without duplicates
5. /api/game/{game_id}/numbers -> returns all numbers picked for this game until now
6. /api/game/{game_id}/stats -> stats of the game {numbers drawn/no of tickets/no of users}


Steps to run the application

-- ./gradlew clean build
-- docker build -t tambola-api .
-- docker-compose up