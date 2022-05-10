Cook4U_B
Base de données MySQL

Exécutez la requête: MySQL Workbench CREATE DATABASE IF NOT EXISTS cook4uV2.
Vérifiez bien que la base cook4uV2 a bien été créée,
Partie Back

Télécharger Xampp (https://www.apachefriends.org/fr/index.html) et lancez les modules Apache et MySQL.

Sur GITHUB, copier le lien HTTPS du repository « Cook4U_B »

Via l’IDE Eclipse, nous allons maintenant clone le fichier GitHub

Connectez-vous avec l’onglet d’authentification a votre compte GitHub et ensuite laissez les options par défaut.

File  Import…  Existing Maven Projects  Sélectionnez le dossier git (par défaut C:\Users\user\git) et ensuite sélectionnez le projet Cook4U_B

Le projet apparait maintenant dans votre arborescence Eclipse, ouvrez le fichier Cook4UV2Application. Les fichiers application.properties et pom.wml contiennent les paramètre du projet (version de java, etc)

Lancez le projet, click droit sur le fichier Cook4UV2Application.java run as java application.

Dans un navigateur internet allez dans à la page : http://localhost:8086/ingredient et vous devez avoir la liste des différents ingrédients implémentés dans votre style (en format json).
