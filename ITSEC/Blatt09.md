# Blatt 09

## Aufgabe 1: Kryptographische Hashfunktionen

### 1a) Eigenschaften von (kryptographischen) Hashfunktionen

1. **Abbildung großer Eingabemenge auf feste Ausgabelänge**  
   - Eine Hashfunktion \(H\) nimmt Eingaben beliebiger Länge an und erzeugt einen Output (Hash) fester Länge (z. B. 256 Bit bei SHA-256).  
   - Da die Eingabemenge sehr viel größer ist als der endliche Ausgaberaum, existieren unweigerlich Kollisionen (unterschiedliche Eingaben mit demselben Hash).

2. **Einwegfunktion (keine leicht berechenbare Inverse)**  
   - Aus dem Hash \(H(m)\) sollte es praktisch nicht möglich sein, auf den ursprünglichen Input \(m\) zurückzuschließen.

3. **Kollisionsresistenz** (bei kryptographischen Hashfunktionen)  
   - Es soll sehr aufwendig sein, zwei verschiedene Eingaben \(m_1 \neq m_2\) zu finden, die denselben Hash \(H(m_1) = H(m_2)\) liefern.

4. **Vorabbildresistenz** (Preimage-Resistance)  
   - Gegeben ein Hashwert \(h\), ist es schwierig, ein \(m\) zu finden, sodass \(H(m) = h\).

5. **Zweites Vorabbildresistenz** (Second Preimage Resistance)  
   - Ist \(m_1\) bekannt, so soll es schwierig sein, ein anderes \(m_2 \neq m_1\) zu finden, für das \(H(m_1) = H(m_2)\).

*(Punkte 3–5 sind besonders für kryptographische Hashfunktionen essenziell.)*

---

### 1b) Zwei Einsatzszenarien für (kryptographische) Hashfunktionen

1. **Integritätsprüfung (Prüfsumme)**  
   - Dateien oder Programme werden gehasht. Der Hash wird separat veröffentlicht, sodass Nutzer überprüfen können, ob ihre Datei unverändert ist (z. B. nach einem Download).

2. **Passwortspeicherung**  
   - Anstatt Passwörter im Klartext abzulegen, speichert man nur deren Hash. Bei einer Anmeldung wird das eingegebene Passwort gehasht und mit dem gespeicherten Wert verglichen.

---

### 1c) Kollisionsresistenz

- **Definition:** Eine Hashfunktion ist kollisionsresistent, wenn es praktisch unmachbar ist, zwei unterschiedliche Eingaben \(m_1 \neq m_2\) zu finden, sodass \(H(m_1) = H(m_2)\).  
- Diese Eigenschaft ist entscheidend, um Manipulationen oder gezielte „Fake“-Dokumente (mit demselben Hash) zu verhindern.

---

## Aufgabe 2: Salz und Pfeffer (Passwortspeicherung)

Man kann Passwörter auf verschiedene Weisen speichern, jeweils mit unterschiedlichen Vor- und Nachteilen. Typische Fragen dabei: **Wie werden Passwörter in der Datenbank abgelegt? Was sieht ein Angreifer bei einem Leak? Was kann er damit anstellen?**

### 2a) Passwort im Klartext

- **Funktionsweise:**  
  - Die Anwendung speichert das Passwort einfach so, wie es der Nutzer eingegeben hat. Keine Hash- oder Verschlüsselungsmaßnahmen.  
- **Was sieht ein Angreifer im Leak?**  
  - Den **reinen Klartext**.  
- **Risiko:**  
  - Angreifer können die Passwörter sofort verwenden oder weiterverkaufen. Häufig verwenden Nutzer dasselbe Passwort in mehreren Diensten ⇒ direkter Zugang zu weiteren Accounts.

---

### 2b) Passwort nur als Hash

- **Funktionsweise:**  
  - Das Passwort wird gehasht (z. B. SHA-256) und nur der Hash in der Datenbank gespeichert.  
  - Beim Login wird das eingegebene Passwort erneut gehasht und mit dem gespeicherten Hash verglichen.  
- **Was sieht ein Angreifer?**  
  - Nur den Hashwert (z. B. Hex-String).  
- **Risiko:**  
  - Ohne Salt können Rainbow-Table-Angriffe sehr effektiv sein.  
  - Angreifer kann Wörterbuch-/Brute-Force-Angriffe gegen den Hash durchführen.

---

### 2c) Passwort als salted Hash

- **Funktionsweise:**  
  - Zusätzlich zum Passwort wird ein **Salt** (zufällige Zeichenkette) generiert und zusammen mit dem Passwort gehasht:  
    \[
    \text{saltedHash} = H(\text{Salt} \,\|\, \text{Passwort}).
    \]  
  - Der Salt wird (typischerweise) in Klartext zusammen mit dem Hash gespeichert.  
- **Was sieht ein Angreifer?**  
  - Den Salt und den Hash.  
- **Vorteil:**  
  - Rainbow-Table-Angriffe sind praktisch nutzlos, da jeder Hash einen anderen Salt hat.  
  - Ein Angreifer muss jedes Passwort individuell brute-forcen.

---

### 2d) Passwort als peppered salted Hash

- **Funktionsweise („Pepper“):**  
  - Zusätzlich zum Salt wird ein „Pepper“ verwendet, der **nicht** in der Datenbank, sondern an einem separaten, gesicherten Ort (z. B. Konfigurationsdatei, HSM) aufbewahrt wird.  
  - Das Passwort wird gehasht mit Salt + Pepper:  
    \[
    H(\text{Pepper} \,\|\, \text{Salt} \,\|\, \text{Passwort}).
    \]  
- **Was sieht ein Angreifer im Leak?**  
  - Nur Salt und Hash, aber **nicht** den Pepper (falls dieser getrennt lagert).  
- **Vorteil:**  
  - Selbst wenn die Datenbank geleakt wird, kann der Angreifer nicht sofort mit dem Pepper rechnen. Er bräuchte Zugriff auf das zweite System, um die Hashes erfolgreich zu brechen.

---

## Aufgabe 3: Post Quantum Cryptography

### 3a) Mosca’s Inequality – was ist das Problem?

- **Mosca’s Inequality** besagt grob, dass, wenn wir annehmen, dass (a) ein Angreifer Daten für \(x\) Jahre geheim halten muss und (b) wir \(y\) Jahre für den Wechsel zu quantensicheren Verfahren benötigen, und (c) ein Quantencomputer in \(z\) Jahren verfügbar sein wird, dann sollte \(x + y\) kleiner sein als \(z\). Sonst kann ein Angreifer die Kommunikation aufzeichnen und **nachträglich** entschlüsseln, sobald er Zugriff auf einen leistungsfähigen Quantencomputer hat.  
- **Kurz:** Wir müssen rechtzeitig auf Post-Quantum-Kryptographie umsteigen, damit abgehörte Daten nicht später entschlüsselt werden.

---

### 3b) Bedrohung durch Quantencomputer für Kryptosysteme

- **Asymmetrische Kryptosysteme** (RSA, ECC):  
  - Shor’s Algorithmus kann große Zahlen faktorisieren (RSA) bzw. das diskrete Logarithmusproblem (ECC) effizient lösen. → Asymmetrische Systeme wären massiv gefährdet.  
- **Symmetrische Verfahren**:  
  - Grover’s Algorithmus reduziert den effektiven Schlüsselraum von \(2^n\) auf \(2^{n/2}\). Man braucht also größere Schlüssel, z. B. 256 Bit anstatt 128 Bit.  
- **Hashfunktionen**:  
  - Grover’s Algorithmus halbiert ebenfalls die effektive Sicherheitsstufe, sodass z. B. SHA-256 ungefähr 128-Bit-Sicherheit bietet.

Nicht alle Algorithmen sind gleichermaßen betroffen. Moderne Hashfunktionen und symmetrische Verfahren lassen sich durch größere Schlüssellängen „quantensicher“ machen, während aktuelle RSA- und ECC-Systeme durch Shor’s Algorithmus vollständig kompromittiert werden könnten.

---

### 3c) Speicherung von Ciphertexten durch staatliche Institutionen

- **Problem:**  
  - Angenommen, ein Angreifer (z. B. Geheimdienst) speichert heute verschlüsselte Daten. In einigen Jahren könnte er mit einem Quantencomputer die asymmetrischen Schlüssel brechen und die Daten entschlüsseln.  
  - Das ist besonders kritisch, wenn die Daten sehr lange geheim bleiben müssen (z. B. medizinische oder militärische Informationen).  
- **Lösung:**  
  - Rechtzeitig auf Post-Quantum-Verfahren (z. B. lattice-based Kryptographie) umsteigen.  
  - Wenn Daten jetzt abgefangen werden, sollen sie auch in Zukunft nicht entschlüsselbar sein.

---

## Zusammenfassung

1. **Hashfunktionen** haben wesentliche Eigenschaften wie feste Ausgabelänge, Einwegcharakter und Kollisionsresistenz. Sie werden u. a. zur Integritätsprüfung und zur Passwortspeicherung eingesetzt.  
2. **Passwortspeicherung** kann im Klartext, als (salted) Hash oder mit zusätzlichem Pepper erfolgen. Letztere Varianten erhöhen die Sicherheit deutlich, da Brute-Force-Angriffe erschwert werden.  
3. **Quantencomputer** bedrohen vor allem asymmetrische Kryptoverfahren durch Shor’s Algorithmus, während symmetrische Verfahren und Hashfunktionen durch Grover’s Algorithmus „nur“ eine Halbierung des Schlüsselraums erfahren.  
4. **Langfristige Vertraulichkeit** ist in Gefahr, wenn staatliche Stellen heute Ciphertexte speichern und diese in Zukunft mit Quantencomputern entschlüsseln. Post-Quantum-Kryptographie soll diesem Szenario vorbeugen.
