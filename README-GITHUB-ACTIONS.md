# AS Pocket – Build via GitHub Actions

## Étapes rapides
1. Crée un compte sur GitHub (gratuit).
2. Crée un **nouveau dépôt** (public ou privé), nom au choix.
3. Clique **"Upload files"** et dépose **tout le contenu du dossier `ASPocket/`** (ou importe le zip complet).
4. Vérifie que la branche par défaut s'appelle **main** (ou master).
5. Va dans l'onglet **Actions** du dépôt → le workflow **Android CI** démarre.
6. À la fin, clique dans le job **build**, section **Artifacts** → télécharge **ASPocket-debug-apk**.
7. Installe l'APK sur ton Android (autorise l'installation depuis cette source).

> Note : Aucun keystore n'est nécessaire pour le debug. Pour publier sur Google Play plus tard, on fera une signature "release".