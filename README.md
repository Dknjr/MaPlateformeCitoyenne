<h1>Ma Plateforme Citoyenne — premier prototype de Citizen</h1>

<p>
  <img alt="React" src="https://img.shields.io/badge/React-18-20232A?logo=react&logoColor=61DAFB">
  <img alt="Expo" src="https://img.shields.io/badge/Expo-50-000020?logo=expo&logoColor=white">
  <img alt="Java" src="https://img.shields.io/badge/Java-21-ED8B00?logo=openjdk&logoColor=white">
  <img alt="Spring Boot" src="https://img.shields.io/badge/Spring%20Boot-3.2-6DB33F?logo=springboot&logoColor=white">
  <img alt="MySQL" src="https://img.shields.io/badge/MySQL-8-4479A1?logo=mysql&logoColor=white">
</p>

Première version (mars 2024) d'une plateforme de **signalements et de demandes citoyennes** pour une mairie.
Ce prototype a servi à poser le modèle de données et l'API avant le projet final, **[Citizen](https://github.com/Dknjr/MMR-Citizen-App)**, réalisé pour la Mairie du Golfe 1 (Lomé) et soutenu comme mémoire de licence.

*First prototype (March 2024) of a platform for citizens to report issues and send requests to their town hall. It laid the groundwork, data model and REST API, for the final project, [Citizen](https://github.com/Dknjr/MMR-Citizen-App).*

---

## Ce que contient le dépôt

```
MaPlateformeCitoyenne/           # Front-end (React + Expo web)
├── App.js                       # Routes : connexion, accueil, signalement, tableau de bord…
└── src/
    ├── components/              # SignIn, SignUp, Sidebar, champs et boutons
    └── pages/                   # Home, Report, Dashboard, Messages, Settings

MaPlateformeCitoyenne_Backend/   # API REST (Spring Boot)
└── src/main/java/com/defictech/AlertCommune/
    ├── model/                   # Utilisateur, Incident, Requete, Commentaire, Notification
    ├── dao/                     # Repositories JPA
    ├── service/                 # Logique métier
    └── controller/              # Endpoints REST
```

## L'API

Chaque ressource expose un CRUD complet (`POST`, `GET`, `GET /{id}`, `PUT /{id}`, `DELETE /{id}`) :

| Ressource | Route |
|---|---|
| Utilisateurs | `/api/utilisateur` |
| Incidents (signalements) | `/api/incident` |
| Requêtes (demandes) | `/api/requete` |
| Commentaires | `/api/commentaire` |
| Notifications | `/api/notification` |

## Lancer le projet

**Backend** (Java 21, MySQL avec une base `alertcom`) :

```bash
cd MaPlateformeCitoyenne_Backend
# renseigner l'URL, l'utilisateur et le mot de passe MySQL dans src/main/resources/application.properties
./mvnw spring-boot:run        # API sur http://localhost:8086
```

**Front-end** :

```bash
cd MaPlateformeCitoyenne
npm install
npx expo start --web
```

## Et ensuite ?

Ce prototype a évolué vers **Citizen** : application mobile Expo / React Native, back-office web pour les agents, API sécurisée par JWT, notifications et suivi des dossiers.
👉 [Voir le projet Citizen](https://github.com/Dknjr/MMR-Citizen-App)

## Auteur

**Erminio Dorkenoo**, étudiant en MSc Intelligence Artificielle à l'ECE Paris.
[LinkedIn](https://www.linkedin.com/in/erminio-dorkenoo-21458a232) · [erminiodorkenoo@gmail.com](mailto:erminiodorkenoo@gmail.com)
