# 🐸 Projet Frogger – Java

> Implémentation d'un jeu type **Frogger** dans le cadre du module Info211 (Licence MPI – S3)

---

## 🎮 Présentation

Ce projet a été réalisé durant l’année universitaire **2020-2021**, dans le cadre du cours **Introduction à la Programmation Orientée Objet (Info211)** à destination des étudiants en Licence MPI (Mathématiques, Physique, Informatique).

Il consiste en une **reproduction simplifiée du jeu d’arcade Frogger**, développé en **Java** de manière progressive à travers 5 étapes. Le but est de faire traverser une grenouille d’un côté à l’autre de la route, en évitant les collisions avec les voitures qui défilent.

---

## 🧱 Objectifs pédagogiques

- Mettre en œuvre les **principes de la POO en Java** :  
  ➤ Classes, objets, encapsulation, héritage, polymorphisme  
- Apprendre à **structurer un projet logiciel** en plusieurs étapes  
- Développer un jeu 2D simple avec interactions clavier  
- Pratiquer la **programmation en binôme** et la gestion de projet

---

## 🚧 Fonctionnalités implémentées

Le projet est divisé en **5 parties** progressives :

1. 🎮 Mouvement de la grenouille via les touches fléchées  
2. 🚗 Affichage des voitures et déplacement continu selon un tempo  
3. ♾️ Mode de jeu infini (scrolling ou génération continue)  
4. ⏱️ Ajout d’un **timer** pour chronométrer la partie  
5. 👥 Mode **2 joueurs**

---

## 🖥️ Technologies utilisées

- **Langage** : Java  
- **IDE recommandé** : IntelliJ IDEA  
- **Modèle de projet** : Orienté Objet, sans dépendance externe  
- **Aucune bibliothèque graphique externe** : tout est codé "from scratch"

---

## 📁 Structure du dépôt

```
ProjetIPO/
├── PARTIE1/
├── PARTIE2/
├── PARTIE3/
├── PARTIE4/
├── PARTIE5(2J)/  ← version finale à deux joueurs
├── .idea/         ← configuration IntelliJ
└── Rapport_Projet_IPO_S3.pdf
```

---

## 📝 Comment exécuter le projet

1. Cloner le projet :
```bash
git clone https://github.com/Makduv/ProjetIPO.git
```

2. Ouvrir dans IntelliJ IDEA (ou tout autre IDE Java)

3. Naviguer jusqu'à la partie souhaitée (par ex. `PARTIE5(2J)`)

4. Lancer le fichier contenant la méthode `main`

---

## 💡 Description du gameplay

> **But du jeu** : faire traverser la grenouille de la première ligne (bas) à la dernière ligne (haut), sans collision avec les voitures.

- L’écran de jeu est une grille composée de lignes :
  - 🟩 Ligne de départ (vide) contenant la grenouille
  - 🟥 Lignes intermédiaires : circulation de voitures de tailles 1 à 3
  - 🏁 Ligne d’arrivée (vide)
- Toutes les voitures d'une même ligne se déplacent dans le même sens et à la même vitesse
- Le joueur contrôle la grenouille avec les **flèches directionnelles**
- 💥 En cas de collision avec une voiture, c’est perdu !

---

## 👥 Travail en binôme

Ce projet a été mené à deux, favorisant :

- La **répartition des tâches**
- Le **travail collaboratif**
- Le **partage des connaissances**
- La **communication technique**

---

## 🧠 Compétences développées

- Java / Programmation orientée objet
- Conception de jeux 2D simples
- Travail d’équipe
- Gestion de projet (temps, itérations, livrables)

---

## 📄 Rapport

➡️ Consultez le document `Rapport_Projet_IPO_S3.pdf` pour plus de détails sur la démarche, la structure du projet, et le bilan pédagogique.
