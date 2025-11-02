# 🧮 TP2 – Algorithmique et Complexité  
### Université de Sidi Bel Abbès – Master 1 Informatique (2025/2026)

---

## 🎯 Objectif du TP
Ce projet vise à implémenter et à comparer **deux algorithmes de tri linéaires** :
- **Tri par comptage (Counting Sort)**
- **Tri par base (Radix Sort)**

Ces algorithmes ne reposent pas sur des comparaisons d’éléments et atteignent une **complexité linéaire O(n)** dans certaines conditions.

---

## 🧠 Présentation générale

### 🔹 Tri par comptage (Counting Sort)
Le tri par comptage compte le nombre d’occurrences de chaque valeur dans le tableau, puis calcule la position finale de chaque élément à partir de ces comptages.

#### 🔧 Étapes principales :
1. Trouver la valeur maximale `k` dans le tableau.
2. Créer un tableau de comptage `C[0..k]` initialisé à zéro.
3. Compter le nombre d’occurrences de chaque valeur.
4. Cumuler les positions (chaque `C[i]` contient le nombre d’éléments ≤ i).
5. Construire le tableau trié en plaçant chaque élément à sa position correcte (de droite à gauche pour la stabilité).

#### 🧩 Exemple :
A = [4, 2, 2, 8, 3, 3, 1]
Résultat : B = [1, 2, 2, 3, 3, 4, 8]

#### ⏱️ Complexité :
- **Temps** : O(n + k)
- **Espace** : O(k)

---

### 🔹 Tri par base (Radix Sort)
Le tri par base trie les entiers chiffre par chiffre, du moins significatif (unités) au plus significatif (centaines, milliers…).
Il utilise le **tri par comptage** comme sous-procédure stable.

#### 🔧 Étapes principales :
1. Trouver le nombre ayant le plus de chiffres.
2. Pour chaque chiffre (unités, dizaines, centaines…) :
   - Appliquer un tri stable (Counting Sort) sur ce chiffre.
3. Répéter jusqu’au chiffre le plus significatif.

#### 🧩 Exemple :
A = [170, 45, 75, 90, 802, 24, 2, 66]
Résultat : [2, 24, 45, 66, 75, 90, 170, 802]

#### ⏱️ Complexité :
- **Temps** : O(d × (n + k))  
  où `d` = nombre de chiffres du plus grand nombre.
- **Espace** : O(n + k)

---

## 📂 Structure du projet
TP2-Algorithmique-TriLineaire-Java/
│
├── src/
│ ├── TriParComptage.java # Implémentation du tri par comptage
  ├── TriParSelection.java # Implémentation du tri par selection
│ └── TriParBase.java # Implémentation du tri par base (Radix Sort)
│
└── README.md


---

## 🚀 Exécution

### ▶️ Compiler :
```bash
javac src/TriParComptage.java
javac src/TriParBase.java
javac src/TriParSelection.java
```
▶️ Exécuter :
```bash
java -cp src TriParComptage
java -cp src TriParBase
```
Chaque fichier contient sa propre méthode main() et peut être exécuté indépendamment.
📊 Exemple de comparaison des temps d’exécution : 

| Taille du tableau | Counting Sort | Radix Sort |
| ----------------- | ------------- | ---------- |
| 1000 éléments     | 0.5 ms        | 0.7 ms     |
| 10 000 éléments   | 3.1 ms        | 2.9 ms     |
| 100 000 éléments  | 35 ms         | 27 ms      |

💡 Les valeurs peuvent varier selon la machine et la JVM utilisée.
Les deux algorithmes sont extrêmement rapides sur des entiers bornés.

🧑‍💻 Auteur

👤 DIB Abdelkrim Yassine Taki Eddine
🎓 Université Djillali Liabes - UDL
💻 Spécialité : Reseaux, Systemes et Securite de l'information
📅 Année universitaire : 2025/2026

🧾 Licence

Ce projet est libre d’utilisation à des fins éducatives et universitaires.
© 2025 – DIB Abdelkrim Yassine Taki Eddine. Tous droits réservés.





