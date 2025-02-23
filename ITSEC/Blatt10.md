# Blatt 10

## Aufgabe 2: (T) Authentisierung & Needham-Schröder

In der Vorlesung wurden verschiedene Varianten zur Authentisierung bei Verwendung symmetrischer, asymmetrischer Verschlüsselungsverfahren und Hash-Funktionen diskutiert. Außerdem wurde das Authentisierungsprotokoll Needham-Schröder unter Verwendung eines symmetrischen Verschlüsselungsverfahrens erläutert.

### a. Verwendung von Nonce in der symmetrischen Needham-Schröder-Variante

In der symmetrischen Variante des Needham-Schröder-Protokolls wird ein **Nonce** (eine einmalig verwendete Zufallszahl) eingesetzt, um **Frische und Einmaligkeit** der Nachrichten sicherzustellen.

**Zweck:**
- Verhindern von Replay-Angriffen, indem sichergestellt wird, dass jede Authentisierungsanfrage einzigartig ist.
- Der Nonce dient als Herausforderung, die vom Kommunikationspartner beantwortet werden muss, um zu bestätigen, dass er aktiv an der Sitzung teilnimmt und nicht eine wiederholte Nachricht eines früheren Angriffs vorliegt.

### b. Replay-Schwäche bei bekanntem Session-Key und deren Behebung

**Problem:**

Bei der symmetrischen Variante des Needham-Schröder-Protokolls besteht eine bekannte Schwäche gegenüber Replay-Angriffen, wenn der Session-Key kompromittiert oder bekannt wird.

**Szenario:**
- Ein Angreifer, der den Session-Key kennt, kann aufgezeichnete Nachrichten (z. B. Authentisierungsnachrichten) erneut abspielen, sodass der Empfänger diese als gültig interpretiert, da der Schlüssel korrekt ist.

**Behebung:**

- **Erhöhung der Nachrichtenfrische:**
  - Der Einsatz von zeitbasierten Komponenten (wie Timestamps) oder die Verwendung von sequenziellen Nummern zusätzlich zum Nonce kann verhindern, dass alte Nachrichten wiederverwendet werden.
  
- **Beispiel:**
  - Ergänzen des Protokolls um einen Zeitstempel, der vom Empfänger geprüft wird. Nachrichten, deren Zeitstempel außerhalb eines vorgegebenen Fensters liegen, werden verworfen.
  
- **Ergebnis:**
  - So wird sichergestellt, dass jede Nachricht nur einmalig akzeptiert wird, selbst wenn der Session-Key dem Angreifer bekannt sein sollte.

### c. Nachrichtenfluss im Needham-Schröder-Protokoll (asymmetrische Verschlüsselung)

**Voraussetzungen:**
- Den Kommunikationspartnern sei der öffentliche Schlüssel **KT** von Trent T bekannt.
- Trent kennt andererseits die öffentlichen Schlüssel aller Beteiligten (**KA** für Alice, **KB** für Bob).

**Nachrichtenfluss:**

1. **Alice schickt Trent:** `{ A, B }`
2. **Trent schickt Alice:** `K_t_priv{B, KB}`
3. **Bob schickt Trent:** `{ B, A }` und bekommt `K_t_priv{ A, KA}`
4. **Alice schickt Bob:** `KB{A, N_a}`
5. **Bob schickt Alice:** `KA{ N_b, N_a}`

---

## Aufgabe 3: Kerberos

Kerberos ist ein weit verbreitetes Authentisierungsprotokoll, das auf einem zentralen **Key Distribution Center (KDC)** basiert, welches wiederum in einen **Authentication Server (AS)** und einen **Ticket Granting Server (TGS)** unterteilt ist.

### a. Anmeldung und erste Nachricht

**Szenario:**
- Sie loggen sich um 08:00 Uhr mit Ihrem Nutzernamen `bsp26395` und Passwort `3z!fG7qiT` ein.

**Zielkomponente:**
- Die Anmeldedaten werden an den **Authentication Server (AS)** des Kerberos-KDC übermittelt.

**Aufbau der Nachricht:**

- **Inhalt:**
  - Benutzername (`bsp26395`)
  - Zeitstempel (um 08:00 Uhr)
  
- **Prozess:**
  - Das Passwort wird nicht direkt übertragen, sondern dient zur Ableitung eines geheimen Schlüssels, mit dem der AS später Nachrichten verschlüsselt.
  
- **Nachrichtentyp:**
  - Eine Authentifizierungsanfrage, in der der Client um ein **Ticket Granting Ticket (TGT)** bittet.

### b. Antwort des Authentication Servers

**Verwendeter Schlüssel:**
- Die Antwort wird mit einem Schlüssel verschlüsselt, der aus Ihrem Passwort (`bsp26395 / 3z!fG7qiT`) abgeleitet wird.

**Inhalt der Antwort:**
- Das **Ticket Granting Ticket (TGT)**, das zur Anforderung weiterer Service-Tickets beim TGS verwendet wird.
- Ein temporärer **Session-Key**, der zur Sicherung der Kommunikation zwischen Ihnen und dem TGS dient.
- Möglicherweise weitere Parameter wie Gültigkeitsdauer und ein Zeitstempel.

### c. Druckanforderung über Kerberos

**Zielkomponente:**
- Für den Zugriff auf den Print-Server muss zunächst ein **Service-Ticket** für den Druckdienst eingeholt werden. Dies erfolgt über den **Ticket Granting Server (TGS)**.

**Aufbau der Druck-Anfrage:**

- **An die TGS:**  
  Die Druck-Anfrage enthält:
  - Ihren Benutzernamen
  - Den Namen bzw. die Kennung des Druckdienstes/Servers
  - Das zuvor erhaltene TGT
  - Einen Zeitstempel zur Verhinderung von Replay-Angriffen

**Inhalt der Antwort des TGS:**
- Ein **Service-Ticket**, das speziell für die Authentisierung beim Print-Server ausgestellt ist.
- Ein weiterer **Session-Key**, der die Kommunikation zwischen Ihnen und dem Print-Server absichert.

### d. Schritte bis zum Ausdruck des Dokuments

1. **Erhalt des Service-Tickets:**
   - Nach erfolgreicher Anfrage beim TGS erhalten Sie das Service-Ticket für den Druckdienst.
2. **Verbindungsaufbau mit dem Print-Server:**
   - Sie senden an den Print-Server Ihre Anfrage, wobei Sie das Service-Ticket und den zugehörigen Session-Key zur Authentifizierung verwenden.
3. **Authentifizierung beim Print-Server:**
   - Der Print-Server überprüft das Service-Ticket und die zugehörige Authentizität der Anfrage.
4. **Übermittlung des Druckauftrags:**
   - Nach erfolgreicher Authentisierung senden Sie Ihren Druckauftrag (das Dokument) verschlüsselt mit dem Session-Key an den Print-Server.
5. **Druckausführung:**
   - Der Print-Server bestätigt den Erhalt und führt den Druckauftrag aus. Eine abschließende Bestätigung wird an Sie zurückgesendet.

---

## Aufgabe 4: Biometrie

### a. Eigenschaften eines zur Authentisierung geeigneten biometrischen Merkmals

Mindestens fünf zentrale Eigenschaften sind:

- **Einzigartigkeit:**  
  Das Merkmal muss von Person zu Person deutlich unterscheidbar sein.
- **Permanenz:**  
  Das Merkmal sollte über die Zeit stabil und nicht leicht veränderbar sein.
- **Erfassbarkeit:**  
  Es muss technisch einfach und zuverlässig messbar sein.
- **Akzeptanz:**  
  Die Nutzer sollten bereit sein, das Merkmal für Authentisierungszwecke zu verwenden.
- **Fälschungssicherheit:**  
  Das Merkmal sollte schwer zu kopieren oder zu fälschen sein.

Weitere Eigenschaften können beispielsweise geringe Fehlerraten (geringe False Acceptance Rate und False Rejection Rate) umfassen.

### b. Allgemeine Vorgehensweise bei biometrischen Systemen

1. **Enrollment (Registrierung):**
   - Erfassung des biometrischen Merkmals (z. B. Fingerabdruck, Iris-Scan)
   - Extraktion charakteristischer Merkmale und Erstellung eines biometrischen Templates
   - Sichere Speicherung des Templates (lokal oder zentral)
2. **Authentisierung (Verifikation):**
   - Erneute Erfassung des biometrischen Merkmals während des Logins oder Zugriffs
   - Vergleich des neuen Messwertes mit dem gespeicherten Template mittels eines Matching-Algorithmus
   - Entscheidung über die Authentizität basierend auf einem vordefinierten Ähnlichkeitsmaß

### c. Angriffsmöglichkeiten und Gegenmaßnahmen im biometrischen System

**Angriffsvektoren:**

- **Spoofing:**  
  Fälschung von biometrischen Daten (z. B. Nutzung von Fingerabdruckabdrücken oder Fotos)  
  *Gegenmaßnahme:* Einsatz von Liveness-Detection (Prüfung von Vitalparametern, z. B. Puls oder Temperatur)
- **Replay-Angriffe:**  
  Abfangen und Wiederverwenden von übertragenen biometrischen Daten  
  *Gegenmaßnahme:* Verwendung von zeitlich begrenzten Tokens oder Challenge-Response-Mechanismen
- **Sensor-Manipulation:**  
  Manipulation oder Ersetzung des Erfassungsgeräts  
  *Gegenmaßnahme:* Physische Sicherheitsmaßnahmen und regelmäßige Integritätsprüfungen der Hardware
- **Datenbankangriffe:**  
  Diebstahl oder Manipulation der gespeicherten biometrischen Templates  
  *Gegenmaßnahme:* Verschlüsselung der Templates und Einsatz von sicheren, dezentralen Speichersystemen
- **Man-in-the-Middle-Angriffe:**  
  Abfangen der Kommunikationskanäle zwischen Sensor und Authentisierungssystem  
  *Gegenmaßnahme:* Einsatz von Ende-zu-Ende-Verschlüsselung und Authentizitätsprüfungen der Kommunikationspartner

---

## Aufgabe 5: Authentisierung & One-Time Passwords

### a. Weitere Kategorien und Beispielverfahren

Neben der Wissenskategorie (Passwörter) lassen sich folgende Kategorien unterscheiden:

#### Besitz (Possession)
- **Beispiele:**  
  Hardware-Token (z. B. RSA SecurID), Smartcards, One-Time Password (OTP) Generatoren
- **Vorteile:**  
  Erzeugt ein dynamisches, schwer zu erratendes Token; bei Verlust kann der Token schnell gesperrt werden.
- **Nachteile:**  
  Geräte können verloren gehen oder gestohlen werden; zusätzliche Hardware ist erforderlich.

#### Inhärenz (Biometrie)
- **Beispiele:**  
  Fingerabdruck-, Iris-, Gesichtserkennungssysteme
- **Vorteile:**  
  Benutzer müssen sich nichts merken; schwer zu kopieren, wenn Liveness-Detection vorhanden ist.
- **Nachteile:**  
  Datenschutzbedenken; biometrische Merkmale können sich ändern oder durch Verletzungen beeinflusst werden; Falschablehnungsraten.

#### Verhalten (Behavioral)
- **Beispiele:**  
  Tastaturanschlagsmuster, Mausbewegungen, Sprachmuster
- **Vorteile:**  
  Schwer zu imitieren; kann passiv im Hintergrund überwacht werden.
- **Nachteile:**  
  Hohe Variabilität; erfordert umfangreiche Trainingsdaten und adaptive Algorithmen; möglicherweise höhere Fehlerraten.

### b. Analyse eines Angriffs bei unverschlüsselter Übertragung von Passwörtern

**Szenario:**  
Eine Web-Applikation überträgt Passwörter im Klartext. Ein Angreifer (Mallet) snifft den gesamten Netzwerkverkehr und kann so die Zugangsdaten für spätere Anmeldungen verwenden.

**Wahrscheinlichster Angriffstyp:**

- **Replay-Angriff:**
  - **Begründung:**  
    Der Angreifer erfasst die unverschlüsselten Zugangsdaten und kann diese exakt wiederverwenden, da sie unverändert im Netzwerk übertragen wurden.

**Erklärung der übrigen Angriffstypen:**

- **Brute-Force-Angriff:**  
  Dabei werden systematisch alle möglichen Kombinationen ausprobiert. Dieser Angriffstyp setzt allerdings voraus, dass der Angreifer keinen direkten Zugang zu bereits abgehörten Zugangsdaten hat, sondern nur die Möglichkeit, selbst viele Versuche durchzuführen.

- **Wörterbuch-Angriff:**  
  Hierbei wird versucht, Passwörter anhand einer vorgefertigten Liste häufig genutzter Passwörter zu erraten. Auch dies erfordert, dass die Passwörter nicht direkt abgefangen wurden.

- **Social Engineering:**  
  Bei dieser Methode werden Benutzer dazu gebracht, ihre Zugangsdaten unbewusst preiszugeben (z. B. durch Phishing). Dies erfolgt nicht durch technisches Abhören, sondern durch Manipulation des Benutzers.
