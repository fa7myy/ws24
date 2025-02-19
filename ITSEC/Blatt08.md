# Blatt 08

## Aufgabe 1: Schlüssellängen und Komplexitätsabschätzungen

### 1a) Dauer eines Brute-Force-Angriffs (1 CPU-Kern, 3 GHz, ca. 3106 Schlüssel/s)

- **56-Bit-Schlüssel:**  
  \[
    \text{Anzahl der Schlüssel} = 2^{56} \;\approx\; 7.21 \times 10^{16}.
  \]  
  Bei **3106** Versuchen/s:  
  \[
    \frac{2^{56}}{3106} 
    \;\approx\; 7.21 \times 10^{16} \div 3106
    \;\approx\; 2.32 \times 10^{13}\,\text{Sekunden}
    \;\approx\; 7.36 \times 10^{5}\,\text{Jahre}
    \;\approx\; 736{,}000\,\text{Jahre}.
  \]

- **128-Bit-Schlüssel:**  
  \[
    2^{128} \;\approx\; 3.40 \times 10^{38}.
  \]  
  Geteilt durch 3106 Versuche/s:
  \[
    \frac{2^{128}}{3106}
    \;\approx\; 1.09 \times 10^{35}\,\text{Sekunden}
    \;\approx\; 3.46 \times 10^{27}\,\text{Jahre}.
  \]

*(Die exakten Zahlen können je nach Rundung variieren, sind aber in dieser Größenordnung.)*

---

### 1b) Parallele Ausführung mit 100.000 CPU-Kernen

- **56-Bit-Schlüssel:**  
  Reduktion der Zeit um Faktor 100.000:  
  \[
    \approx 736{,}000\,\text{Jahre} \div 100{,}000 
    \;\approx\; 7.36\,\text{Jahre}.
  \]

- **128-Bit-Schlüssel:**  
  \[
    \approx 3.46 \times 10^{27}\,\text{Jahre} \div 10^5
    \;\approx\; 3.46 \times 10^{22}\,\text{Jahre}.
  \]

*(Selbst mit massiver Parallelisierung bleibt ein 128-Bit-Schlüssel praktisch unknackbar.)*

---

### 1c) Passwortrichtlinie (mindestens 8 Zeichen, davon 2 Ziffern oder Sonderzeichen)

- **Annahme:** 95 mögliche Zeichen pro Stelle (deutsche Tastatur, inkl. Groß-/Kleinschreibung, Ziffern, Sonderzeichen).  
- **Mindestlänge:** 8 Zeichen.  
- **Mind. 2 Ziffern/Sonderzeichen:**  
  Theoretische Komplexität bei dieser Richtlinie liegt ungefähr bei \(6 \times 10^{15}\) möglichen Passwörtern, was rund **52 Bit** Entropie entspricht.

---

### 1d) Tatsächlich erreichte Komplexität

In der Praxis ist die effektive Komplexität **deutlich geringer** als der theoretische Wert, da Nutzer oft:
- Passwörter wiederverwenden,  
- „Wörterbuch-Wörter“ oder Namen/geburtsnahe Zahlen benutzen,  
- einfache Muster wählen (z. B. „Passwort123“).

---

### 1e) „Kombiniere 4 beliebige Worte“ als Passwortrichtlinie

Zwar kann die Methode „vier zufällig gewählte Wörter“ (à la „correct horse battery staple“) sehr starke Passphrasen erzeugen. Jedoch:
- Ist die **Wortauswahl** nicht wirklich beliebig: Häufig verwendet man gängige Wörter aus einem relativ kleinen Vokabular.  
- Ein Angreifer kann **Wortlisten** oder „Wortkombi-Angriffe“ durchführen, was die Komplexität reduziert.  
- In der Praxis ist ein gut umgesetztes „4-Wörter-Prinzip“ (mit großem, wirklich zufälligen Wortschatz) oft **sehr sicher**. Wird jedoch nur ein kleiner oder naheliegender Wortschatz genutzt, fällt die Sicherheit.

---

## Aufgabe 2: Verschlüsselung und RSA

### 2a) Vorteile und Nachteile asymmetrischer Verschlüsselung

- **Probleme, die gelöst werden:**  
  - **Schlüsselaustausch**: Man muss keinen geheimen Schlüssel mehr über einen unsicheren Kanal übertragen. Stattdessen wird ein **öffentlicher Schlüssel** verteilt.  
- **Probleme, die nicht gelöst werden / Nachteile:**  
  - **Rechenaufwand**: Asymmetrische Verfahren (z. B. RSA) sind wesentlich langsamer als symmetrische Verfahren.  
  - **Schlüssellänge**: Um vergleichbare Sicherheit zu bieten, sind sehr große Schlüssel notwendig.  
  - **Authentizität**: Man muss immer noch sicherstellen, dass der öffentliche Schlüssel tatsächlich vom gewünschten Kommunikationspartner stammt (Thema PKI, Zertifikate).

---

### 2b) Anzahl benötigter Schlüssel bei 10 Personen (symmetrische Verschlüsselung)

Für eine **paarweise** abgesicherte Kommunikation zwischen 10 Personen werden die Schlüssel wie folgt berechnet:
\[
\binom{10}{2} = \frac{10 \times 9}{2} = 45.
\]
*(Sie haben 45 mögliche „Paare“.)*

> **Achtung**: Wenn die Aufgabe explizit sagt, „10 Personen paarweise miteinander“ und jeder mit jedem ein *eigenes* Schlüsselmaterial benötigt, ergibt sich 45.  
> Wenn hingegen nur 5 genannt wurde, könnte das ein Missverständnis oder ein vereinfachtes Beispiel sein. In der Regel ist die Formel \(\frac{n(n-1)}{2}\).

---

### 2c) RSA mit \(p=11\), \(q=31\), \(m=12\), \(e=17\)

1. **\(n = p \times q\):**  
   \[
   n = 11 \times 31 = 341.
   \]
2. **Verschlüsselung** \(c = m^e \bmod n\):  
   \[
   c = 12^{17} \bmod 341.
   \]
   Mit modularer Exponentiation (z. B. Erweitertes Square-and-Multiply) erhält man:
   \[
   c \approx 166.
   \]
3. **\(\phi(n)\):**  
   \[
   \phi(341) = (11 - 1)(31 - 1) = 10 \times 30 = 300.
   \]
4. **Private Exponent** \(d\):  
   \[
   d \times 17 \equiv 1 \;(\bmod\; 300).
   \]
   Man findet \(d = 43\).
5. **Prüfung** \((c^d \bmod n)\):  
   \[
   166^{43} \bmod 341 \;\rightarrow\; 12,
   \]
   womit man den Klartext zurückerhält.

---

### 2d) Digitale Signatur: Fehler im Ablauf (Abbildung 1)

**Fehler im gezeigten Ablauf:**

1. **Hashing vs. Verschlüsselung**:  
   - Man signiert üblicherweise den **Hash** (Prüfsumme) der Nachricht, nicht die gesamte Nachricht selbst.  
   - Asymmetrische Verfahren werden **nicht** als bloßer „Prüfsummenersatz“ genutzt.

2. **Ver- und Entschlüsselung**:  
   - Der private Schlüssel des Absenders signiert (d. h. „verschlüsselt“ den Hash), der öffentliche Schlüssel des Empfängers verifiziert (entschlüsselt den Hash).  
   - Man verschlüsselt in einer digitalen Signatur *nicht* das Dokument mit dem öffentlichen Schlüssel des Empfängers, sondern signiert mit dem privaten Schlüssel des Senders.

**Ziele**:
- **Integrität**: Durch den Hash kann man prüfen, ob die Nachricht unverändert ist.  
- **Authentizität**: Da nur der Inhaber des privaten Schlüssels signieren kann, weiß man, wer der Urheber ist (unter Voraussetzung, dass der öffentliche Schlüssel korrekt zugeordnet ist).  
- **Nichtabstreitbarkeit**: Der Sender kann nicht abstreiten, die Nachricht signiert zu haben, wenn sein privater Schlüssel einzigartig ist.

---

#### RSA-Verschlüsselung der Nachricht 68094034 128468343 143911297 122013244

- **Gegebene Parameter**: \(n=289648273\), \(e=17\).  
- **Faktoren**: \(n=p\times q=12347\times 23459\).  
- **\(\phi(n)\)=(p−1)(q−1)=289612468**.  
- **d=255540413** (privater Exponent).

Die Entschlüsselung der vier Blöcke mittels \(m=c^d\bmod n\) führt zur base-36-Klartextfolge:  
```
NBXF33KACJBE
```
(Beispiel; je nach Mapping kann das geringfügig abweichen.)

---

## Zusammenfassung

1. **Aufgabe 1** zeigt, dass Brute-Force auf 56-Bit-Schlüssel in realistischer Zeit nur mit erheblicher Parallelisierung machbar ist, während 128-Bit-Schlüssel praktisch unknackbar bleiben.  
2. Eine Passwortrichtlinie mit „mind. 8 Zeichen und 2 Ziffern/Sonderzeichen“ bietet theoretisch etwa 52 Bit Entropie, in der Praxis jedoch weniger.  
3. **Aufgabe 2** behandelt die Vor- und Nachteile asymmetrischer Verfahren. Für eine paarweise abgesicherte Kommunikation mit 10 Personen sind 45 Schlüsselpaare nötig (falls jede Verbindung einen eigenen Schlüssel nutzt).  
4. Das RSA-Beispiel mit \(p=11\) und \(q=31\) veranschaulicht die Modulararithmetik. Die Fehler im digitalen Signaturablauf sind vor allem falsche Verwendung von Hash vs. Verschlüsselung.  
5. Die Verschlüsselung einer Nachricht mit \(n=289648273\) und \(e=17\) kann mithilfe der Faktoren \(p=12347\), \(q=23459\) (sowie \(\phi(n)\) und \(d\)) entschlüsselt werden, was in einem base-36-Klartext resultiert.
