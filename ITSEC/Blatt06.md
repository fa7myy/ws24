# Blatt 06

## 1. DSGVO und personenbezogene Daten

### a) Grundsätze der Verarbeitung personenbezogener Daten gemäß DSGVO

Die DSGVO schreibt folgende wesentliche Grundsätze vor:

- **Rechtmäßigkeit, Verarbeitung nach Treu und Glauben, Transparenz:**  
  Die betroffenen Personen müssen über den Zweck, die Art und Dauer der Datenverarbeitung informiert werden.

- **Zweckbindung:**  
  Personenbezogene Daten dürfen nur für festgelegte, eindeutige und legitime Zwecke erhoben und nicht in einer mit diesen Zwecken unvereinbaren Weise weiterverarbeitet werden.

- **Datenminimierung:**  
  Es dürfen nur solche Daten verarbeitet werden, die für den jeweiligen Zweck erforderlich sind.

- **Richtigkeit:**  
  Die Daten müssen sachlich richtig und erforderlichenfalls auf dem neuesten Stand sein.

- **Speicherbegrenzung:**  
  Daten dürfen nur so lange gespeichert werden, wie es für den Verarbeitungszweck notwendig ist.

- **Integrität und Vertraulichkeit (Sicherheit):**  
  Es müssen angemessene technische und organisatorische Maßnahmen getroffen werden, um die Sicherheit der Daten zu gewährleisten.

- **Rechenschaftspflicht:**  
  Der Verantwortliche muss jederzeit in der Lage sein, die Einhaltung der DSGVO nachzuweisen.

Zusätzlich haben Betroffene das Recht, der Verarbeitung zu widersprechen und in vielen Fällen die Löschung bzw. Korrektur ihrer Daten zu verlangen.

---

### b) Verarbeitungstätigkeit und organisatorische Verpflichtungen

**Verarbeitungstätigkeit** umfasst alle Vorgänge im Zusammenhang mit der Erhebung, Speicherung, Nutzung, Übermittlung und Löschung personenbezogener Daten. Organisationen sind verpflichtet:
- Ein Verzeichnis der Verarbeitungstätigkeiten zu führen, in dem sie dokumentieren, welche Daten zu welchen Zwecken verarbeitet werden.
- Transparente Informationen über die Datenverarbeitung bereitzustellen, sodass Betroffene nachvollziehen können, welche Daten erhoben und wie sie genutzt werden.

---

### c) Datenschutzfolgenabschätzung (DSFA)

Eine **Datenschutzfolgenabschätzung** ist ein Verfahren zur systematischen Analyse und Bewertung der Risiken, die eine geplante Datenverarbeitung für die Rechte und Freiheiten der betroffenen Personen mit sich bringen kann. Eine DSFA ist erforderlich, wenn die Datenverarbeitung voraussichtlich ein hohes Risiko birgt – etwa bei umfangreichen, systematischen oder sensiblen Datenverarbeitungen. Ziel ist es, frühzeitig angemessene technische und organisatorische Maßnahmen zu definieren, um diese Risiken zu minimieren.

---

### d) Maßnahmen bei einer Datenpanne

Im Falle einer Datenpanne sind folgende Schritte erforderlich:
- **Unverzügliche Benachrichtigung der zuständigen Datenschutzaufsichtsbehörde:**  
  Die Meldung muss – sofern möglich – innerhalb von 72 Stunden erfolgen.
- **Benachrichtigung der betroffenen Personen:**  
  Falls ein hohes Risiko für deren Rechte und Freiheiten besteht.
- **Interne Untersuchung und Behebung:**  
  Vorhandene Notfallpläne und Prozesse sollten zur Schadensbegrenzung aktiviert werden.

---

## 2. Videoüberwachung in bayerischen Behörden

### a) Rechtsgrundlage (Grundsatz der Rechtmäßigkeit)

Für die Einführung von Videoüberwachung in bayerischen Behörden stützt man sich auf das Bayerische Datenschutzgesetz (BayDSG). Die Maßnahmen müssen rechtmäßig, verhältnismäßig und transparent erfolgen. Ergänzend gelten die allgemeinen Betroffenenrechte (Informations-, Auskunfts- und Löschungsrecht sowie das Recht auf Datenübertragbarkeit).

---

### b) Beispielhafte Beschreibung einer Verarbeitungstätigkeit für Videoüberwachung

Eine exemplarische Beschreibung könnte wie folgt lauten:

„Die Einrichtung betreibt eine automatisierte Videoüberwachung zur Gewährleistung der Sicherheit und des Schutzes der behördlichen Infrastruktur. Dabei werden Videodaten kontinuierlich erfasst, gespeichert und nur für die Analyse von sicherheitsrelevanten Ereignissen genutzt. Die Daten werden auf Servern innerhalb der Einrichtung temporär gespeichert und nach Ablauf eines definierten Zeitraums gelöscht, sofern keine Sicherheitsvorfälle vorliegen. Zugriffe auf die Aufzeichnungen sind ausschließlich autorisiertem Personal vorbehalten.“

---

### c) Datenschutzfolgenabschätzung (DSFA) für Videoüberwachung

Da Videoüberwachung ein hohes Risiko für die Rechte und Freiheiten der Betroffenen birgt, ist eine DSFA zwingend erforderlich. Dabei müssen unter anderem folgende Maßnahmen umgesetzt werden:
- **Datenschutzfreundliche Voreinstellungen:** Minimierung der erfassten Daten und regelmäßige Löschung.
- **Technische und organisatorische Maßnahmen:** Beispielsweise Pseudonymisierung, Zugangsbeschränkungen und Verschlüsselung der Daten.
- **Führen eines Verzeichnisses der Verarbeitungstätigkeiten:** Detaillierte Dokumentation der Erfassungs- und Verarbeitungsprozesse.

---

### d) Vorgehen bei einem Sicherheitsvorfall bei Videoaufzeichnungen

Bei Bekanntwerden, dass Videoaufzeichnungen unbefugt über das Internet zugänglich waren, ist Folgendes zu tun:
- **Sofortige Meldung an die zuständige Aufsichtsbehörde:**  
  Gemäß Meldepflicht der DSGVO.
- **Informierung der betroffenen Personen:**  
  Falls deren Rechte und Freiheiten beeinträchtigt wurden.
- **Einleitung von Sofortmaßnahmen:**  
  Überprüfung und Anpassung der Sicherheitsvorkehrungen, um weitere Zugriffe zu verhindern.
- **Dokumentation und Analyse des Vorfalls:**  
  Zur abschließenden Evaluierung und Vermeidung zukünftiger Risiken.

---

## 3. Excel-Datei „ITSec-gesperrt.xlsm“

### a) Formel in Feld A1

Die in Zelle A1 enthaltene Formel lautet:
```excel
=SUM(C1:C6)/20
```

---

### b) Makro in der Excel-Datei

Der in der Datei enthaltene VBA-Code (Makro) ist wie folgt:
```vba
REM  *****  BASIC  *****
Sub Main
End Sub
```

---

### c) Möglichkeiten, um ohne Kennwort Kenntnis an gesperrte Formeln/Makros zu gelangen

Drei mögliche Methoden (im Rahmen einer akademischen Diskussion) sind:
1. **Brute-Force- oder Dictionary-Attacken:**  
   Angreifer können versuchen, das Passwort durch automatisierte Wiederholung gängiger Passwörter zu erraten.
2. **Ausnutzung von Schwächen in der Implementierung:**  
   Aufgrund bekannter Schwächen in Microsoft Excels Schutzmechanismus können Tools oder Skripte eingesetzt werden, die den Passwortschutz umgehen (z. B. durch XML-Manipulation der Datei).
3. **Verwendung von Drittanbieter-Tools:**  
   Es existieren diverse spezialisierte Programme, die den Schutz durch bekannte Exploits in der Excel-Verschlüsselung umgehen können.

> **Hinweis:** Diese Methoden dienen hier ausschließlich der wissenschaftlichen Analyse und Diskussion von Schwachstellen. Die Anwendung ohne entsprechende Berechtigung ist ungesetzlich.

---

### d) Geeignete Implementierung eines Passwortschutzes

Um den Passwortschutz in Excel zu verbessern, sollten folgende Maßnahmen erwogen werden:
- **Starke Verschlüsselung:**  
  Moderne Office-Versionen bieten die Möglichkeit, Dateien mit AES-256 zu verschlüsseln, was den Schutz erheblich verbessert.
- **Digitale Signaturen:**  
  Durch den Einsatz digitaler Signaturen kann die Integrität und Authentizität der Datei sichergestellt werden.
- **Mehrschichtiger Schutz:**  
  Zusätzlich zum Passwortschutz sollten Zugriffsrechte, Benutzerrollen und Netzwerkzugriffsregeln implementiert werden, um den Schutz zu vertiefen.
- **Regelmäßige Updates und Patches:**  
  Die Aktualisierung der Software schließt bekannte Schwachstellen in den Schutzmechanismen.

---

## 4. Steganographie in Bildern

### a) Einbetten einer Nachricht mit Steghide

- **Vorgehen:**  
  Mit dem Tool Steghide können Nachrichten in Bilddateien eingebettet werden. Beispiel:  
  ```bash
  steghide embed -cf rot.jpg -ef geheim.txt
  ```
  Hinweis: Für „rot.jpg“ kann es Einschränkungen geben, wenn das Cover-Bild zu klein ist („cover-image too short“). Bei den Dateien „bunt.jpg“ und „kariert.jpg“ wurde das Einbetten erfolgreich durchgeführt.

### b) Extraktion der versteckten Nachrichten

Die eingebetteten Nachrichten lassen sich mit Steghide extrahieren:
```bash
steghide extract -sf bunt.jpg
steghide extract -sf kariert.jpg
```
*„done“ – die Extraktion wurde erfolgreich durchgeführt.*

### c) Vergleich der Histogramme

Beim Vergleich der Histogramme von Bildern mit und ohne eingebettete Nachricht kann Folgendes auffallen:
- **Leichte Veränderungen in der Farbverteilung:**  
  Insbesondere in den niederwertigen Bits, die zur Einbettung verwendet werden, können minimale Unterschiede sichtbar sein.
- **Erhöhtes Rauschen:**  
  Die eingebettete Information kann das Rauschverhalten im Bild leicht verändern, was durch einen Vergleich der Histogramme sichtbar wird.

### d) Techniken zur Einbettung von Nachrichten in Bildern

Zu den gängigen Techniken gehören:
- **LSB (Least Significant Bit) Insertion:**  
  Die niederwertigen Bits der Pixel werden verändert.
- **DCT-Koeffizienten-Modifikation:**  
  Vor allem in JPEG-Bildern werden die diskreten Kosinustransformationskoeffizienten verändert.
- **Spread Spectrum:**  
  Die Information wird über das gesamte Bild verteilt, was die Robustheit erhöht.

### e) Robustheit eingebetteter Nachrichten gegenüber Bildveränderungen

Die Robustheit variiert je nach Technik:
- **LSB-Insertion:**  
  Diese Methode ist relativ anfällig gegenüber Kompression, Skalierung oder anderen Bildbearbeitungen.
- **Techniken im Frequenzbereich (z. B. DCT-Modifikation):**  
  Diese sind in der Regel robuster gegenüber nachträglichen Veränderungen, können jedoch bei starker Bearbeitung oder Neukodierung ebenfalls beeinträchtigt werden.

---

# Zusammenfassung

Die überarbeiteten Lösungen verdeutlichen:
- Die DSGVO definiert klare Prinzipien für die Verarbeitung personenbezogener Daten und verpflichtet Organisationen zur Transparenz und Dokumentation.
- Bei Videoüberwachung in öffentlichen Einrichtungen sind rechtliche Grundlagen (etwa BayDSG) und eine DSFA essenziell, um die Rechte der Betroffenen zu schützen.
- Die Excel-Datei „ITSec-gesperrt.xlsm“ illustriert Schwächen in den implementierten Passwortschutzmechanismen, was durch bekannte Umgehungsmethoden (Brute-Force, XML-Manipulation, spezialisierte Tools) ausgenutzt werden kann. Verbesserungen sollten moderne Verschlüsselungsalgorithmen und zusätzliche Sicherheitsmaßnahmen umfassen.
- In der Steganographie wird das Einbetten und Extrahieren von Nachrichten in Bildern anhand von Tools wie Steghide demonstriert, wobei Veränderungen im Histogramm als Hinweis auf eine versteckte Nachricht dienen können. Verschiedene Techniken bieten unterschiedliche Grade an Robustheit.

Diese Antworten bieten eine umfassende, fundierte Grundlage für das Verständnis der relevanten Themen im Kontext der IT-Sicherheit und der damit verbundenen rechtlichen Rahmenbedingungen.
