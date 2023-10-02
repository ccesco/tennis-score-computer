# Kata

This Kata goal is to implement a simple tennis score computer.

The scoring system consist in one game, divided by points :

Each player starts a game with 0 point.
If the player wins the 1st ball, he will have 15 points. 2nd balls won : 30 points. 3rd ball won : 40points.
If a player have 40 points and wins the ball, he wins the game, however there are special rules.
If both players have 40 points the players are “deuce”.
If the game is in deuce, the winner of the ball will have advantage
If the player with advantage wins the ball he wins the game
If the player without advantage wins the ball they are back at “deuce”.
You can found more details about the rules here : (http://en.wikipedia.org/wiki/Tennis#Scoring )

Here we want you to develop a java method that will take a String as input containing the character ‘A’ or ‘B’. The character ‘A’ corresponding to “player A won the ball”, and ‘B’ corresponding to “player B won the ball”. The java method should print the score after each won ball (for example : “Player A : 15 / Player B : 30”) and print the winner of the game.

For example the following input “ABABAA” should print :

“Player A : 15 / Player B : 0”
“Player A : 15 / Player B : 15”
“Player A : 30 / Player B : 15”
“Player A : 30 / Player B : 30”
“Player A : 40 / Player B : 30”
“Player A wins the game

# Run

Compilation :
```
mvn clean install
```

Lancement :
```
docker-compose up
```

Pour changer le paramètre de lancement, modifier le Dockerfile de tennis-score-computer-application et lancer la commande :
```
docker-compose up --build
```

Sinon pour lancer avec des paramètres personnalisés 

aller dans le dossier tennis-score-computer-application et lancer : 
```
docker build . -t tennis
```

ensuite faire :
```
docker run tennis ABABA A B
```

# Choix architecture

Certain choix d'architecture peuvent être disproportionnés pour ce Kata, mais je l'ai réalisé comme si je devais mettre l'application en prod, et dans une logique d'évolution rapide et de maintenabilité facile.

Séparation du domain et de la partie applicative, dans une logique d'architecture hexagonale. Dans le futur, si on a un besoin de réutilisation du domain, c'est plus simple et pas de framework.

Dans la partie applicative, j'ai séparé la logique d'affichage (display) et de la gestion de la String pour limiter les impacts si on décide de changer le format de sortie (json par exemple).

