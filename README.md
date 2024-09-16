README - Application JavaFX de gestion des stations Vélib de Paris
Description du projet
Cette application permet de consulter en temps réel les stations Vélib disponibles à Paris, en s'appuyant sur une interface graphique développée avec JavaFX. Elle se connecte à la base de données de la ville de Paris via leur API OpenData. L'utilisateur peut lister les stations libres et filtrer ces listes en fonction de différents critères.

Fonctionnalités principales
Affichage en temps réel des stations Vélib disponibles et de leurs informations (nombre de vélos, emplacement, etc.).
Filtrage dynamique des stations : possibilité de filtrer par nombre de vélos disponibles, localisation, etc.
Interface graphique intuitive et facile à utiliser, développée avec JavaFX et Scene Builder.
Structure du projet
Le projet est développé en Java dans l'IDE Eclipse. L'interface utilisateur est construite avec JavaFX et modélisée avec Scene Builder.

Principales classes/modules :
Main.java : Point d'entrée de l'application.
StationController.java : Contrôleur qui gère l'interface et les interactions utilisateur.
StationService.java : Service qui se connecte à l'API de la ville de Paris pour récupérer les données des stations en temps réel.
Station.java : Modèle représentant une station Vélib avec ses attributs (nombre de vélos, emplacement, etc.).
Configuration et installation
Prérequis
Java 11 ou version ultérieure
Eclipse IDE avec le plugin e(fx)clipse pour le support JavaFX
Scene Builder pour la conception de l'interface graphique
Connexion internet pour récupérer les données de l'API
Installation
Cloner ce dépôt GitHub :

bash
Copier le code
git clone https://github.com/votre-depot/application-velib-javafx.git
Ouvrir le projet dans Eclipse :

Importez le projet en tant que "Projet Maven existant" dans Eclipse.
Assurez-vous que JavaFX est correctement configuré.
Configurer les dépendances :

Ajouter les librairies JavaFX à votre projet.
Configurer les appels à l'API de la ville de Paris en vérifiant les URL et les clés d'API dans les fichiers de configuration.
Lancer l'application :

Exécutez la classe Main.java depuis Eclipse pour démarrer l'application.
API utilisée
L'application se connecte à l'API OpenData de la ville de Paris :

Documentation API : https://opendata.paris.fr/pages/home/
Point d'accès pour les données des stations Vélib : /api/records/1.0/search/?dataset=velib-disponibilite-en-temps-reel
Utilisation
Une fois l'application lancée :

La fenêtre principale s'affiche avec la liste des stations Vélib disponibles en temps réel.
Utilisez les options de filtrage pour sélectionner les stations selon vos préférences (nombre de vélos, emplacement, etc.).
Les résultats seront mis à jour automatiquement selon les données reçues de l'API.
Ressources utilisées
Outils logiciels :
Java avec Eclipse comme IDE.
JavaFX pour la construction de l'interface graphique.
Scene Builder pour la conception visuelle de l'interface.
API OpenData de Paris pour la récupération des données en temps réel des stations Vélib.
Documentation :
Documentation JavaFX : https://openjfx.io/
Documentation de l'API OpenData : https://opendata.paris.fr/pages/home/
