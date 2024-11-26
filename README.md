# Gestion de Patrimoine Immobilier en POO JAVA
## by Deo MIMPUNGU

## Description

Ce projet est une application Java de gestion de patrimoine immobilier pour une entreprise de placement de fonds. Il permet de gérer un large portefeuille de biens immobiliers, de suivre les états des locations, de gérer les transactions financières, et de faciliter la gestion des contrats avec les locataires et investisseurs. 

L'application utilise le modèle MVC (Modèle-Vue-Contrôleur) et implémente plusieurs Design Patterns pour améliorer la structure et la maintenabilité du code.

## Fonctionnalités Principales

- **Gestion des biens immobiliers** : Ajouter, modifier, et supprimer des propriétés (appartements, bureaux, commerces, etc.).
- **Gestion des locataires et des contrats** : Enregistrement des locataires et gestion des contrats de location.
- **Gestion des transactions** : Suivi des paiements de loyers, des revenus et des dépenses liées aux propriétés.
- **Visualisation du patrimoine** : Consultation de l’état global du patrimoine, incluant la valeur totale des biens et les locations en cours.
- **Notifications** : Alertes pour les fins de contrats de location, les loyers impayés, et les dépenses inhabituelles.

## Design Patterns Utilisés

1. **State Pattern** : Gestion des différents états des propriétés (disponible, louée, en maintenance).
2. **Decorator Pattern** : Ajout dynamique de fonctionnalités aux biens immobiliers (ex. : parking, piscine).
3. **Observer Pattern** : Suivi des événements importants pour notifier les parties prenantes.

## Architecture

- **Modèle (Model)** : Classes représentant les biens immobiliers, les locataires, les contrats et les transactions financières.
- **Vue (View)** : Interface graphique développée avec **JavaFX** pour la consultation des propriétés et la gestion des contrats et transactions.
- **Contrôleur (Controller)** : Coordination entre la vue et le modèle, gérant les interactions de l’utilisateur.

## Prérequis

- Java Development Kit (JDK) 17 ou supérieur
- IDE (comme IntelliJ IDEA, Eclipse, ou NetBeans)
- Bibliothèque JavaFX
- Gradle

## Installation

1. Clonez le dépôt :

   ```bash
   git clone https://github.com/mimpungu/GestionPatrimoine.git
   cd GestionPatrimoine
2. Compiler :
  
  ```bash
  ./gradlew build
  ./gradlew run

   