# Blatt 07

## 1. Substitutionsverfahren und klassische Chiffren

### 1a) Einfaches Substitutionsverfahren mit Tabellenkoordinaten

#### Aufgabe:
Ein sehr simples Verschlüsselungsverfahren \( f \) bildet jedes Zeichen des Klartextes auf zwei Koordinaten \((\text{Zeile}, \text{Spalte})\) ab.  
- **Beispiel:** Der Klartext „vorlesung“ wird zu \(513442311543453322\).  
- **Zu tun:**  
  1. Bestimmen Sie die Alphabete \(A_1\) und \(A_2\).  
  2. Handelt es sich um ein symmetrisches oder asymmetrisches Verfahren?  
  3. Verschlüsseln Sie den Klartext „uebung“.  
  4. Entschlüsseln Sie den Ciphertext \(31341543453322\).  
  5. Schreiben Sie ein kleines Skript zum Entschlüsseln eines weiteren Textes.

---

#### a) Alphabete \(A_1\) und \(A_2\)

- **Klartext-Alphabet** \(A_1\):  
  Die einzelnen Buchstaben \(\{a, b, c, \ldots, z\}\).

- **Ciphertext-Alphabet** \(A_2\):  
  Koordinaten der Form \((\text{Zeile}, \text{Spalte})\), wobei Zeile und Spalte Werte von 1 bis 5 annehmen. Man kann dies tabellarisch anordnen:

|   | 1 | 2 | 3 | 4 | 5 |
|---|---|---|---|---|---|
| 1 | a | b | c | d | e |
| 2 | f | g | h | i | k |
| 3 | l | m | n | o | p |
| 4 | q | r | s | t | u |
| 5 | v | w | x | y | z |

Daraus ergibt sich beispielsweise:
- \(a \to (1,1)\)  
- \(b \to (1,2)\)  
- \(z \to (5,5)\)  
usw.

---

#### b) Symmetrisches oder asymmetrisches Verfahren?

Das Verfahren ist **symmetrisch**, da sowohl Verschlüsselung als auch Entschlüsselung denselben “Schlüssel” (die Tabellendefinition) verwenden.

---

#### c) Verschlüsselung des Klartexts „uebung“

- \(u \to (4,5)\) → 45  
- \(e \to (1,5)\) → 15  
- \(b \to (1,2)\) → 12  
- \(u \to (4,5)\) → 45  
- \(n \to (3,3)\) → 33  
- \(g \to (2,2)\) → 22  

**Ergebnis:** 451512453322

---

#### d) Entschlüsselung des Ciphertexts \(31341543453322\)

- \(31 \to l\)  
- \(34 \to o\)  
- \(15 \to e\)  
- \(43 \to s\)  
- \(45 \to u\)  
- \(34 \to o\)  
- \(53 \to n\)  
- \(22 \to g\)

**Ergebnis:** loesung

---

#### e) Entschlüsselung eines weiteren Textes via Skript

Der Text:  
```
152433 431323521542 5545 14151334142415421533141542 22152315243244155344
```
lässt sich durch ein entsprechendes Skript (z. B. in Python) in ähnlicher Weise entschlüsseln. Das Ergebnis:  
```
ein schwerzu decodierender geheimtext
```

---

### 1b) Klassische Kryptoanalyse mit älteren Chiffren

**Gegebener Ciphertext:**  
```
Inj Zjgzsl Ezw atwqjxzsl NY Xnhmjwmjny
```

**Entschlüsselung:**  
Mithilfe einer klassischen Caesar-Analyse (Shift -5) oder Tools wie CrypTool ergibt sich:  
```
Die Übung zur Vorlesung IT Sicherheit
```

---

## 2. Skytale und weitere klassische Verfahren

### 2a) Spaltentransposition (Skytale)

- **Gegeben:** Geheimtext = `FNABAIHUESNAFNSDUGKEESAL`  
- **Umfang \(U = 5\):**  
  Das bedeutet, wir schreiben den Geheimtext spaltenweise in 5 Spalten und lesen ihn zeilenweise ab oder umgekehrt (je nach Definition).  
- **Entschlüsselter Klartext:**  
  `FINDENHAUSAUFGABENKLASSE_`

*(Der genaue Prozess: Man trägt den Geheimtext in Spalten der Länge 5 ein und liest ihn zeilenweise ab. Die Unterstreichung `_` kann als Leerzeichen oder Füllzeichen interpretiert werden.)*

---

### 2b) Multiplikative Chiffren

1. **Funktionsweise:**  
   - Ordne jedem Buchstaben eine Zahl \(\{0, 1, 2, \ldots, 25\}\) zu.  
   - Wähle einen Schlüsselwert \(k\).  
   - Die Verschlüsselung eines Buchstabens mit Position \(x\) erfolgt als  
     \[
     \text{chiffre} = (x \times k) \mod 26.
     \]

2. **Beispiel:**  
   - \(k = 2\).  
   - Buchstabe \(O\) (Position 14, falls A=0, B=1, …, O=14) wird zu \(D\).  
     \[
     \text{chiffre} = (14 \times 2) \mod 26 = 28 \mod 26 = 2 \ (\text{= C, wenn A=0}).
     \]  
     *Achtung:* Man muss ggf. festlegen, ob A=0 oder A=1. Bei A=0 entspricht 2 = C. Wenn man A=1, dann verschieben sich die Werte.

3. **Beobachtung:**  
   - Bei manchen \(k\)-Werten tritt der Effekt auf, dass das Chiffrat eine eingeschränkte Vielfalt hat (z. B. bei \(\gcd(k, 26) \neq 1\)).  
   - Um **keine** Reduktion auf weniger Zeichen zu bekommen, wählt man \(k\) so, dass \(\gcd(k, 26) = 1\). Nur dann entsteht eine bijektive Abbildung auf das Alphabet (d. h. jeder Buchstabe hat einen eindeutigen Partner).

---

### 2c) One-Time-Pad

- **Verschlüsselung von HALLOWELT mit Schlüssel MISTGABEL:**  
  Man ordnet jedem Buchstaben eine Zahl \(\{0 \dots 25\}\) zu und addiert die jeweilige Schlüsselziffer (modulo 26). Das Ergebnis:  
  ```
  TIDEUWFPE
  ```
  *(Ein konkretes Beispiel, sofern man Buchstaben A=0, B=1, … zuordnet und dann modular addiert.)*

---

## 3. Kryptographische Systeme

### 3a) Definition eines Kryptosystems

Allgemein definiert man ein Kryptosystem als ein 5-Tupel \((\mathcal{M}, \mathcal{C}, \mathcal{K}, e, d)\) mit:

- **\(\mathcal{M}\):** Menge möglicher Klartexte (Messages).  
- **\(\mathcal{C}\):** Menge möglicher Ciphertexte.  
- **\(\mathcal{K}\):** Schlüsselraum.  
- **\(e\):** Verschlüsselungsfunktion \(e: \mathcal{M} \times \mathcal{K} \to \mathcal{C}\).  
- **\(d\):** Entschlüsselungsfunktion \(d: \mathcal{C} \times \mathcal{K} \to \mathcal{M}\).  

Daraus folgt:
\[
d(e(m, k), k) = m.
\]

**Unterschiede symmetrisch / asymmetrisch**  
- **Symmetrisch:** Es gibt einen einzigen Schlüssel \(k\). Verschlüsselung und Entschlüsselung nutzen dieselben Schlüsselinformationen.  
- **Asymmetrisch:** Es existiert ein Schlüsselpaar \((k_{\text{pub}}, k_{\text{priv}})\). Man verschlüsselt mit \(k_{\text{pub}}\), entschlüsselt mit \(k_{\text{priv}}\).

---

### 3b) Substitution vs. Permutation

- **Substitution:**  
  Jedes Symbol (oder jede Byte-Einheit) wird durch ein anderes Symbol ersetzt, basierend auf einer Substitutionsfunktion (z. B. in AES die S-Box, in Caesar eine einfache Verschiebung).  
- **Permutation (Transposition):**  
  Die Reihenfolge der Symbole wird verändert (z. B. Spaltentransposition, DES-Permutationstabellen).

**Beispiel DES:**  
- DES verwendet sowohl Substitutionen (z. B. S-Boxen) als auch Permutationen (z. B. Expansionspermutation, P-Boxen).  
- Die Permutationen alleine erhöhen die Sicherheit nicht drastisch, da sie lediglich die Bit-Positionen durchmischen. Die eigentliche Stärke beruht auf S-Boxen (Nichtlinearität) und mehrfachen Runden.

---

### 3c) Keying Options bei symmetrischen Verfahren

Beispiel: **Triple-DES** bietet verschiedene Keying-Optionen:

1. **Keying Option 1:**  
   Drei voneinander unabhängige Schlüssel (K1, K2, K3). Höchste Sicherheit, aber mehr Aufwand.

2. **Keying Option 2:**  
   Zwei Schlüssel (K1, K2), wobei der dritte Schlüssel = K1 ist. Etwas weniger sicher, aber weniger Schlüsselverwaltungsaufwand.

3. **Keying Option 3:**  
   Alle drei Schlüssel sind gleich (K1 = K2 = K3). Effektiv entspricht das einer einfachen DES-Verschlüsselung – nur für Abwärtskompatibilität sinnvoll, kaum Sicherheitsvorteil.

---

## Zusammenfassung

1. **Klassische Chiffren** wie Substitutionstabellen und Spaltentransposition illustrieren Grundprinzipien von Verschlüsselung, zeigen aber ihre Schwachstellen (z. B. durch Kryptoanalyse-Tools wie CrypTool).  
2. **Multiplikative Chiffren** erfordern \(\gcd(k, 26) = 1\) für eine vollständige Abbildung, um einen sinnvollen Kryptoeffekt zu erzielen.  
3. **One-Time-Pad** gilt als eines der sichersten Verfahren, solange der Schlüssel nur einmal verwendet wird und zufällig ist.  
4. **Moderne Kryptosysteme** werden formal definiert als \((\mathcal{M}, \mathcal{C}, \mathcal{K}, e, d)\) und unterscheiden sich zwischen **symmetrischen** (ein Schlüssel) und **asymmetrischen** (Schlüsselpaar) Ansätzen.  
5. **Substitutionen und Permutationen** sind Basiskomponenten vieler Algorithmen (z. B. DES, AES). Permutationen allein erhöhen die Sicherheit nur bedingt; entscheidend sind die nichtlinearen Substitutionen (S-Boxen).  
6. **Keying Options** (z. B. bei 3DES) ermöglichen unterschiedliche Grade an Sicherheit und Komplexität.
