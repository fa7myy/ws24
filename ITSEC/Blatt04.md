## Blatt 4 – Überarbeitete Lösung

### 1. Rootkits

#### a) User-Mode- und Kernel-Mode-Rootkits

**User-Mode-Rootkits:**  
Diese Rootkits operieren auf der Ebene der Anwenderprogramme (User-Mode) und greifen in der Regel auf definierte Schnittstellen zu, um beispielsweise bestimmte Prozesse oder Dateien zu verbergen. Sie manipulieren häufig Standardbefehle, die dem Benutzer zur Verfügung stehen, um ihre Spuren zu verwischen.  
*Stärken:*  
- Einfacher zu implementieren und zu installieren.  
- Geringere Systemeingriffe, was die Detektion in manchen Fällen erschweren kann.  
*Schwächen:*  
- Können von Sicherheitssoftware, die auf Kernel-Ebene arbeitet, relativ leicht erkannt werden.

**Kernel-Mode-Rootkits:**  
Diese Rootkits operieren direkt im Kernel (Systemkern) und haben dadurch weitreichenden Zugriff auf sämtliche Systemkomponenten. Sie modifizieren beispielsweise Kernel-Datenstrukturen, um zu bestimmen, welche Prozesse oder Dateien im System sichtbar sind.  
*Stärken:*  
- Sehr schwer zu entdecken, da sie tief in das Betriebssystem integriert sind.  
- Können nahezu alle Aspekte des Systems manipulieren.  
*Schwächen:*  
- Komplexere Implementierung und höhere Wahrscheinlichkeit von Systeminstabilitäten, wenn Fehler auftreten.

#### b) Unterschied zwischen Rootkits und anderer Malware (Viren, Würmer, Trojaner)

**Rootkits:**  
Dienen primär der Tarnung und Persistenz eines Angriffs. Sie werden häufig als letzte Komponente im Angriffsablauf eingesetzt, um den Angreifer im System unentdeckt zu lassen.  
**Andere Malware (Viren, Würmer, Trojaner):**  
Diese Programme dienen der Ausführung des eigentlichen Angriffs (z. B. Verbreitung, Datenexfiltration oder Zerstörung) und haben primär destruktive oder schädliche Funktionen.  
*Zusammengefasst:*  
- **Malware:** Angriffsmethoden, die schädliche Aktionen ausführen.  
- **Rootkits:** Werkzeuge zur Verschleierung und Aufrechterhaltung des Zugriffs, die häufig als „Tarnkappen“ fungieren.

#### c) Dropper-Komponente und Multistage Dropper

**Dropper-Komponente:**  
Ein Rootkit beinhaltet oft einen sogenannten Dropper, der dafür zuständig ist, die eigentliche Schadsoftware (Payload) in das Zielsystem einzuschleusen und zu installieren. Der Dropper kann zusätzlich Sicherheitsmechanismen umgehen und wird häufig als erste Phase eines Angriffs eingesetzt.

**Multistage Dropper:**  
Dies bezeichnet einen mehrstufigen Angriffsansatz, bei dem der initiale Dropper zunächst einen kleinen, unauffälligen Code (staging payload) installiert, der anschließend weiteren, umfangreicheren Schadcode nachlädt. Diese Vorgehensweise dient der Reduzierung der Wahrscheinlichkeit, dass der gesamte Schadcode beim ersten Eindringen entdeckt wird.

#### d) Anti-Forensik-Maßnahmen von Rootkits

- **Data Destruction:**  
  Diese Maßnahme zielt darauf ab, forensisch relevante Daten zu vernichten. Beispielsweise werden Logdateien oder andere Beweismittel gelöscht, um die Spur des Angriffs zu verwischen.

- **Data Concealment:**  
  Hierbei werden Angreiferprozesse, Dateien oder Systemkomponenten so versteckt, dass sie für forensische Analysen nicht oder nur schwer erkennbar sind. Dies erfolgt etwa durch Manipulation von System-APIs oder Kernel-Datenstrukturen.

- **Data Fabrication:**  
  Diese Technik besteht darin, scheinbar legitime Dateien oder Prozesse zu generieren, um die Anwesenheit von Schadsoftware zu verschleiern. Durch das Erzeugen von „Normalität“ wird versucht, die forensische Analyse zu verwirren.

---

### 2. Cross-Site-Scripting (XSS)

#### a) Varianten von XSS und Bedrohungspotential

In der Vorlesung wurden drei Varianten von Cross-Site-Scripting vorgestellt.  
Die Variante, bei der das schädliche Script auf dem Webserver gespeichert ist (Stored XSS), besitzt das höchste Bedrohungspotential, da hier der Angriff persistent ist. Jedes Mal, wenn ein Nutzer die infizierte Seite aufruft, wird das schädliche Script ausgeführt.

#### b) Schutzmaßnahmen gegen XSS

- **Eingabevalidierung:**  
  Alle Benutzereingaben werden auf unerwünschte Zeichen oder Schadcode überprüft. Hierdurch sollen schadhafte Daten erkannt und bereinigt werden, bevor sie verarbeitet werden.

- **Content Security Policy (CSP):**  
  Diese Sicherheitsrichtlinie gibt an, welche Ressourcen auf einer Webseite geladen werden dürfen. CSP schränkt so die Ausführung von nicht vertrauenswürdigem JavaScript ein und reduziert das Risiko von XSS-Angriffen.

- **HttpOnly-Flag:**  
  Dieses Flag verhindert, dass Cookies durch clientseitiges Skript (z. B. JavaScript) ausgelesen werden können. Dies mindert das Risiko von Session-Hijacking, sollte ein XSS-Angriff dennoch erfolgen.

#### c) SQL-Injection und Umgehung der Loginmaske

**Funktionsweise:**  
SQL-Injection ist eine Technik, bei der Angreifer bösartigen SQL-Code in Eingabefelder einfügen, um die Datenbankabfragen zu manipulieren. Dadurch können sie unerlaubt Informationen abrufen oder den Anmeldevorgang umgehen.

**Beispielangriff:**  
Gegeben ist folgende SQL-Abfrage zur Überprüfung der Login-Daten:

```sql
SELECT uid FROM users WHERE username = " + $username + " AND password = " + $password;
```

Um die Loginmaske zu umgehen, könnte ein Angreifer beispielsweise folgende Eingaben tätigen:

- **Username:** `admin`  
- **Password:** `" OR 1=1 --`

Dadurch wird die SQL-Abfrage folgendermaßen interpretiert:

```sql
SELECT uid FROM users WHERE username = "admin" AND password = "" OR 1=1 --";
```

Da `1=1` stets wahr ist, wird die Abfrage erfolgreich und der Account „admin“ wird kompromittiert.

#### d) Maßnahmen zur Verhinderung von SQL-Injection

**Abstrakt:**  
SQL-Injection kann verhindert werden, indem alle Eingaben des Benutzers validiert, bereinigt und als Parameter in vorbereiteten Statements (Prepared Statements) verarbeitet werden. Dies verhindert, dass bösartiger Code als Teil der SQL-Abfrage interpretiert wird.

**Konkret (Beispiel in PHP):**

```php
// Beispiel: Nutzung vorbereiteter Statements (Prepared Statements) mit PDO
$stmt = $pdo->prepare("SELECT uid FROM users WHERE username = :username AND password = :password");
$stmt->bindParam(':username', $username, PDO::PARAM_STR);
$stmt->bindParam(':password', $password, PDO::PARAM_STR);
$stmt->execute();
```

Durch diesen Ansatz werden Benutzerparameter nicht direkt in die SQL-Abfrage eingebettet, sondern sicher an die Datenbank übergeben.

---

### 3. CSRF (Cross-Site Request Forgery)

**Funktionsweise:**  
Beim CSRF-Angriff wird ein manipuliertes Element (z. B. ein Link oder ein Formular) an das Opfer geschickt. Wenn das Opfer diesen Link anklickt oder das Formular absendet, wird eine unerwünschte Anfrage an die Webseite gestellt, bei der das Opfer bereits authentifiziert ist. Dadurch kann der Angreifer Aktionen im Namen des Opfers ausführen (z. B. das Stehlen von Session-Cookies oder das Übernehmen der Sitzung).

---

### 4. Buffer-Overflow und verwandte Angriffstechniken

#### a) Buffer-Overflow

**Beschreibung:**  
Beim Buffer-Overflow wird der Speicherbereich eines Programms (typischerweise im Stack) durch übergroße Eingaben überschrieben. Dies führt dazu, dass die Rücksprungadresse (Return Address) im Stack manipuliert wird. Ein Angreifer kann dadurch den Programmfluss auf eigenen, eingeschleusten Schadcode umlenken.

#### b) Klassischer Buffer-Overflow vs. Return-to-libc

- **Klassischer Buffer-Overflow:**  
  Hier wird die Rücksprungadresse direkt überschrieben, sodass der eingeschleuste Schadcode ausgeführt wird.

- **Return-to-libc:**  
  Anstatt eigenen Code einzuschleusen, wird die Rücksprungadresse so modifiziert, dass eine Funktion aus der Standardbibliothek (libc) – beispielsweise `system()` – aufgerufen wird. Hierbei werden vorhandene, vertrauenswürdige Funktionen missbraucht, um schädliche Aktionen auszuführen.

#### c) Schutzmaßnahmen gegen Buffer-Overflow

1. **Maximale Eingabelänge festlegen:**  
   Begrenzung der zulässigen Eingabelänge verhindert, dass der Puffer überlaufen kann.

2. **Input-Sanitization:**  
   Überprüfung und Bereinigung der Benutzereingaben auf unerwünschte oder schadhafte Daten.

3. **Speicheradress-Randomisierung (ASLR):**  
   Durch die zufällige Anordnung von Speicheradressen wird es für Angreifer schwieriger, gezielt Schadcode einzuschleusen oder Rücksprungadressen zu manipulieren.

---

### Zusammenfassung

Die überarbeitete Lösung zeigt, dass Rootkits im Unterschied zu anderer Malware primär der Tarnung und Persistenz dienen. Während User-Mode-Rootkits auf der Benutzerebene operieren, bieten Kernel-Mode-Rootkits aufgrund ihrer tiefen Integration in das System einen wesentlich höheren Tarnungsgrad. Anti-Forensik-Maßnahmen wie Data Destruction, Data Concealment und Data Fabrication dienen der Verhinderung einer forensischen Aufklärung des Angriffs.

Beim Thema XSS und SQL-Injection wird deutlich, dass Angriffe durch unzureichende Eingabevalidierung und fehlerhafte Implementierung von Sicherheitsmechanismen ermöglicht werden. Moderne Schutzmaßnahmen, etwa Prepared Statements in PHP und Content Security Policies, reduzieren diese Risiken erheblich.

Ein Buffer-Overflow kann zu kritischen Systemkompromittierungen führen – sei es durch direkten Schadcode oder mittels Return-to-libc-Techniken. Hierbei sind effektive Maßnahmen wie Eingabelängenbegrenzung, Input-Sanitization und ASLR entscheidend, um die Angriffsfläche zu minimieren.

Diese integrierte Betrachtung der Angriffstechniken und Gegenmaßnahmen zeigt, wie wichtig ein ganzheitlicher Sicherheitsansatz ist, der präventive, detektive und reaktive Komponenten miteinander verknüpft.
