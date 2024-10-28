# Gestion de Centre de Formation - API REST

## Contexte du Projet

Un centre de formation souhaite digitaliser la gestion de ses formations via une API REST. Cette plateforme permet de gérer les apprenants, les formateurs, les formations, ainsi que les classes. L'application suit une architecture RESTful pour offrir un accès standardisé aux données.

## Fonctionnalités Principales

- **Gestion des Apprenants** : Inscription, modification, suppression, et affichage (un ou plusieurs).
- **Gestion des Formateurs** : Création, modification, suppression, et affichage (un ou plusieurs).
- **Gestion des Formations** : Planification, modification, suppression, et affichage (un ou plusieurs).
- **Gestion des Classes** : Création, modification, suppression, et affichage (un ou plusieurs).

## Structure des Entités Principales

- **Apprenant** : `nom`, `prénom`, `email`, `niveau`, `formation`, `classe`
- **Formateur** : `nom`, `prénom`, `email`, `specialite`, `formation`, `classe`
- **Classe** : `nom`, `numSalle`
- **Formation** : `titre`, `niveau`, `prerequis`, `capaciteMin`, `capaciteMax`, `dateDebut`, `dateFin`, `formateur`, `apprenants`, `statut` (PLANIFIEE, EN_COURS, TERMINEE, ANNULEE)

## Architecture de l'Application

- **Entités** : Définies avec JPA et validation.
- **Repositories** : Utilisent `JpaRepository` pour l'accès aux données.
- **Services** : Logique métier pour chaque entité.
- **Controllers** : Fournissent les endpoints REST.
- **Exceptions** : Gestion centralisée des erreurs.
- **Utilitaire** : Classes utilitaires pour le projet.
- **Tests** : Tests unitaires et d'intégration.

## Technologies Utilisées

### Backend
- **Spring Boot**
  - Initialisation du projet via Spring Initializer.
  - Configuration via `application.properties`.
  - Profils (`dev`, `prod`) :
    - `application-dev.properties` pour l'environnement de développement.
    - `application-prod.properties` pour l'environnement de production.
  - Utilisation des annotations pour IoC et DI.

- **Spring Data JPA**
  - Repositories utilisant `JpaRepository`.
  - Méthodes de recherche personnalisées avec `@Query` et `@Param`.
  - Implémentation de la pagination.

- **REST API**
  - Endpoints CRUD pour chaque entité.
  - Utilisation de Swagger pour la documentation de l'API.
  - Tests via Postman et/ou Swagger.

- **Gestion des Exceptions**
  - Classes spécifiques pour gérer les erreurs.

### Bases de Données
- **H2** : Utilisé en développement (`dev`).
- **PostgreSQL** : Utilisé en production (`prod`).

### Autres
- **Java 8** : Lambda expressions, Stream API, Java Time API, Optional.
- **Maven** : Gestion des dépendances.
- **JUnit et Mockito** : Pour les tests unitaires et d'intégration.
- **JaCoCo** : Pour la couverture du code.
- **Lombok** : Réduction de code boilerplate.
- **Logger** : Système de logging avec SLF4J.

## Design Patterns Utilisés

- **Repository Pattern** : Gestion des entités via Spring Data JPA.
- **Singleton** : Utilisé dans certaines classes de service ou d'utilitaires.

## Fonctionnalités Spécifiques

- **CRUD Complet** : Création, lecture, mise à jour et suppression de chaque entité.
- **Validation** : Utilisation d'annotations de validation (`@NotNull`, `@Valid`, etc.) pour garantir la cohérence des données.
- **Spring Scopes** : Utilisation de Singleton et Prototype selon les besoins.
- **Swagger** : Documentation interactive de l'API.
- **Logging** : Utilisation d'un système de journalisation pour le suivi des activités de l'application.

## Instructions de Déploiement



1. **Clonez le projet** :
   ```bash
   git clone https://github.com/JavaAura/WALID_SAIFI_S3_B2_Formation
   cd  WALID_SAIFI_S3_B2_Formation
