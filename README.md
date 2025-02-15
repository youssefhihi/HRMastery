# HR Mastery - Application Web

## Description du Projet

Ce projet vise à développer une application web de gestion des ressources humaines (RH) pour une entreprise en pleine expansion. L'ancien système de gestion basé sur des fichiers Excel est devenu obsolète et inefficace, particulièrement avec la gestion des demandes de congés et du processus de recrutement. L'objectif est donc de centraliser et d'automatiser la gestion des employés, des congés, du recrutement, et des allocations familiales afin de gagner en efficacité et en transparence.

### Contexte 

L'entreprise compte aujourd'hui environ 200 employés et fait face à plusieurs défis majeurs :
- Difficulté à suivre les demandes de congés et les conflits de planning.
- Processus de recrutement long et désorganisé, entraînant des pertes de candidats.
- Manque de visibilité sur les allocations familiales, causant de l'insatisfaction chez les employés.
- Difficulté à générer des rapports précis pour la direction.

### Solution

L'application RH permettra de résoudre ces problématiques avec un ensemble de fonctionnalités clés pour améliorer la gestion des employés, des congés, du recrutement, et des allocations familiales.

## Fonctionnalités Principales

### Gestion des employés
- **Ajout, modification et suppression des employés** : Permettre la gestion complète des informations personnelles, coordonnées, et documents administratifs des employés.
- **Visualisation des informations** : Affichage de la liste des employés avec des détails sur chaque employé (nom, poste, département, etc.).
- **Historique des modifications** : Suivi des changements apportés aux informations des employés pour audit et traçabilité.

### Recrutement
- **Création et gestion des offres d'emploi** : Créer des offres d'emploi avec des descriptions détaillées et des critères spécifiques.
- **Suivi des candidatures** : Gestion du processus de recrutement avec suivi des candidatures (reçu, en cours, rejeté, accepté).
- **Filtrage des candidatures** : Filtrer les candidatures par statut et compétences pour optimiser le processus de sélection.

### Gestion des congés
- **Demande et validation des congés** : Soumission de demandes de congés avec vérification des dates et du solde de congés disponibles.
- **Historique des congés** : Suivi des congés pris par chaque employé.
- **Notification des décisions** : Envoi d'emails pour notifier les employés de l'approbation ou du refus de leurs demandes de congés.

### Calcul des allocations familiales
- **Système de calcul automatique** : Calcul des allocations familiales en fonction du nombre d'enfants à charge et du salaire.
- **Rapport des allocations** : Génération de rapports mensuels ou trimestriels pour les employés et le service des paies.

### Reporting
- **Génération de rapports** : Rapports détaillés sur les absences, les performances, et les allocations familiales pour la prise de décisions stratégiques.
- **Tableau de bord** : Visualisation des métriques clés pour une meilleure gestion des ressources humaines.

### Notifications
- **Alertes automatiques** : Notifications par email pour les demandes de congés, les offres d'emploi, et d'autres événements importants.

## User Stories

### Gestion des employés
- En tant qu'administrateur, je veux pouvoir modifier les informations des employés et suivre les modifications pour audit et traçabilité.

### Recrutement
- En tant que recruteur, je veux pouvoir créer des offres d'emploi et suivre les candidatures en fonction de leur statut et des compétences des candidats.

### Gestion des congés
- En tant qu'employé, je veux soumettre des demandes de congé et recevoir des notifications de leur statut par email.

### Calcul des allocations familiales
- En tant qu'administrateur, je veux calculer automatiquement les allocations familiales et générer des rapports pour le service de paie.

### Reporting
- En tant qu'administrateur, je veux générer des rapports mensuels sur les absences et les allocations familiales pour une meilleure planification.

### Notifications
- En tant qu'employé, je veux recevoir des notifications lorsque ma demande de congé est traitée.

## Technologies Utilisées

- **Maven** : Gestion des dépendances.
- **Tomcat** : Serveur web pour le déploiement.
- **Servlet** : Gestion des requêtes HTTP et des actions serveur.
- **JSP & JSTL** : Génération dynamique des pages web et gestion des données.
- **Hibernate/JPA** : Interaction avec la base de données via ORM.
- **JAAS** : Authentification et autorisation des utilisateurs.
- **JUnit** : Tests unitaires pour garantir la fiabilité du système.
- **HTML/CSS/js** : Structure et design de l'interface utilisateur.

## Lien vers la présentation du projet

Pour une présentation visuelle, consultez ce lien Canva : [Présentation du Projet](https://www.canva.com/design/DAGTWnkO__Y/7xj86T2qNn8d_lR8wm4T6Q/edit?utm_content=DAGTWnkO__Y&utm_campaign=designshare&utm_medium=link2&utm_source=sharebutton).

## Lien vers le plan de projet Jira

La planification du projet est gérée via Jira, où vous pouvez consulter les tâches et les sprints : [Planification Jira](https://youssefhihi.atlassian.net/jira/software/projects/HRMAS/boards/10/backlog?epics=visible&atlOrigin=eyJpIjoiMzFmMWI5YTkzNzYyNDg2ZmJkOGJjYTBjMjA1YTBlMGQiLCJwIjoiaiJ9).

---

Développeur : [Youssef Hihi](https://github.com/youssefhihi)