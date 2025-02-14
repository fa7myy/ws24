## Blatt 05

### Aufgabe 1: Social Engineering

#### a) Vorgehensweise beim Phishing und Unterschiede der Varianten

Phishing stellt eine der häufigsten und in der Praxis erfolgreichen Techniken im Bereich des Social Engineerings dar. Bei dieser Methode versucht der Angreifer, durch gefälschte E-Mails, Webseiten oder Nachrichten sensible Informationen (z. B. Zugangsdaten) von Opfern zu erlangen. Dabei werden häufig vertrauenswürdige Absender und professionelle Layouts genutzt, um die Echtheit der Kommunikation vorzutäuschen.

- **Clone Phishing:**  
  Hierbei wird eine legitime, bereits versendete E-Mail exakt kopiert – inklusive Layout und Inhalt – und anschließend manipuliert, um schädliche Links oder Anhänge einzufügen. Das Opfer erhält somit eine nahezu identische Kopie einer echten E-Mail, wodurch der Betrug besonders schwer zu erkennen ist.

- **Spear Phishing:**  
  Diese Methode richtet sich gezielt an einzelne Personen oder eine kleine Gruppe von Personen. Der Angreifer nutzt hierbei personalisierte Informationen (z. B. Kenntnisse über das Privatleben oder die berufliche Situation), um das Vertrauen des Opfers zu gewinnen und die Wahrscheinlichkeit der Interaktion zu erhöhen.

- **Whaling:**  
  Beim Whaling werden Führungskräfte oder andere hochrangige Personen (z. B. CEOs) als Ziel ausgewählt. Da diese Personen oft über weitreichende Zugriffsrechte verfügen, ist der Erfolg eines Angriffs in dieser Kategorie besonders gefährlich für ein Unternehmen.

---

#### b) Charakteristische Merkmale einer Phishing-E-Mail

Damit ein Phishing-Angriff erfolgreich ist und das Ziel – das Erlangen sensibler Informationen – erreicht wird, sollte eine Phishing-E-Mail idealerweise folgende Eigenschaften aufweisen:

1. **Fehlerfreie Rechtschreibung und Grammatik:**  
   Eine einwandfreie sprachliche Darstellung erhöht die Glaubwürdigkeit der Nachricht.

2. **Authentische Absenderadresse oder Domain:**  
   Eine E-Mail-Adresse, die vertrauenswürdig und professionell wirkt, unterstützt den Eindruck, dass es sich um eine offizielle Mitteilung handelt.

3. **Professionelles Layout und Gestaltung:**  
   Die E-Mail sollte optisch ansprechend sein und dem Corporate Design des angeblichen Absenders entsprechen.

4. **Vermeidung von Spam-Indikatoren:**  
   Der Einsatz von Techniken, die verhindern, dass die E-Mail im Spam-Ordner landet, sowie der Verweis auf „saubere“ Webseiten (etwa durch exakte Kopien legitimer Seiten), tragen zur Erfolgswahrscheinlichkeit bei.

---

#### c) Aufbau eines Security Awareness Programms

Ein wirkungsvolles Security Awareness Programm zielt darauf ab, Mitarbeiterinnen und Mitarbeiter im Unternehmen kontinuierlich zu sensibilisieren und so das Risiko von Social Engineering Angriffen zu minimieren. Wichtige Schritte beim Aufbau eines solchen Programms sind:

1. **Systematische Schulungen:**  
   Regelmäßige Trainings und Workshops, in denen aktuelle Angriffstechniken und Gegenmaßnahmen erläutert werden.

2. **Simulation von Phishing-Angriffen:**  
   Durch kontrollierte Phishing-Kampagnen (mit Einwilligung) können reale Angriffsszenarien nachgestellt werden, um das Verhalten der Mitarbeiter zu testen und zu verbessern.

3. **Etablierung von klaren Richtlinien und Policies:**  
   Vorgaben zur Nutzung von IT-Systemen und zur Verarbeitung sensibler Daten sollten klar formuliert und regelmäßig aktualisiert werden.

4. **Kontinuierliche Evaluation und Anpassung:**  
   Feedback der Teilnehmer sowie regelmäßige Erfolgskontrollen helfen dabei, das Programm stetig zu verbessern und an aktuelle Bedrohungslagen anzupassen.

---

#### d) Rechtliche Rahmenbedingungen im Kontext von Social Engineering

**a) Problematische Aspekte des §202c StGB aus BITKOM-Sicht:**  
Der Branchenverband BITKOM begrüßt grundsätzlich die Regelung des §202c StGB, sieht jedoch Probleme bei einer zu strikten (wörtlichen) Anwendung. Insbesondere besteht die Sorge, dass selbst unbedachte oder aus Versehen erfolgte Handlungen, die keine tatsächliche Gefährdung der IT-Sicherheit darstellen, unter diese Vorschrift fallen könnten.

**b) Das dreistufige Bewertungsschema des BITKOM-Leitfadens:**  
Der Leitfaden unterteilt die Bewertung in drei Stufen, um den tatsächlichen Strafrahmen im Umgang mit Software zu definieren. Dabei wird zunächst ermittelt, ob eine Handlung die Schutzgüter der IT-Sicherheit beeinträchtigt. Anschließend erfolgt eine Bewertung der Schwere der Beeinträchtigung und schließlich wird entschieden, ob und in welchem Umfang strafrechtliche Konsequenzen drohen.

**c) Anwendung des Bewertungsschemas:**  
- **Passwort-Cracker:**  
  Hier liegt in der Regel eine klare Gefährdung vor, wenn der Cracker dazu verwendet wird, unautorisiert Zugang zu Systemen zu erlangen.
- **Schwachstellenscanner:**  
  Diese Software kann je nach Einsatzkontext sowohl zur Verbesserung der IT-Sicherheit als auch für missbräuchliche Zwecke verwendet werden. Die Bewertung hängt von der Absicht und dem Kontext ab.
- **Code-Analyse-Werkzeug:**  
  In der Regel wird ein solches Werkzeug im Rahmen der Qualitätssicherung und Sicherheitsüberprüfung eingesetzt. Eine strafrechtliche Bewertung erfolgt erst dann, wenn das Werkzeug missbräuchlich verwendet wird.

---

### Aufgabe 3: Pentesting

#### a) Ziele und Risiken von Penetrationstests

**Ziele:**  
Penetrationstests (Pen-Tests) dienen dazu, die Sicherheit eines Systems zu überprüfen, indem kontrolliert versucht wird, in das System einzudringen. Dadurch können Schwachstellen identifiziert und Maßnahmen zur Verbesserung der IT-Sicherheit abgeleitet werden.

**Risiken:**  
- **Systeminstabilität oder -ausfall:**  
  Bei einem Test kann es durch unvorhergesehene Seiteneffekte zu Systemausfällen oder Datenverlusten kommen.
- **Unbeabsichtigte Störungen:**  
  Es besteht die Gefahr, dass durch den Test reale Geschäftsprozesse gestört werden.

---

#### b) Eigenschaften und Qualifikationen eines Penetrationstesters

Ein effektiver Penetrationstester sollte über umfassende technische Kenntnisse, praktische Erfahrung im Bereich der IT-Sicherheit und fundierte Programmierkenntnisse verfügen. Zudem sind analytisches Denken, Kreativität und die Fähigkeit zur detaillierten Dokumentation von Angriffen entscheidend.

---

#### c) Erkenntnisse aus Pen-Test-Ergebnissen

Penetrationstests liefern wertvolle Informationen über die tatsächliche Sicherheit eines Systems. Sie helfen dabei, Schwachstellen zu identifizieren und konkrete Verbesserungsvorschläge zu entwickeln. Die Ergebnisse eines Pen-Tests sind somit eine sinnvolle Grundlage, um das Sicherheitsniveau zu erhöhen und zukünftige Angriffe zu verhindern.

---

#### d) Unterschiede zwischen Penetrationstests und Vulnerability Scans

- **Penetrationstests:**  
  Diese Tests simulieren einen aktiven Angriff auf ein System, um Schwachstellen auszunutzen und die Effektivität von Sicherheitsmaßnahmen zu prüfen.
- **Vulnerability Scans:**  
  Hierbei handelt es sich um automatisierte Überprüfungen, die Schwachstellen (z. B. veraltete Softwareversionen) identifizieren, ohne dass ein tatsächlicher Angriff erfolgt.

---

#### e) Blackbox- vs. Whitebox-Tests

- **Blackbox-Tests:**  
  Bei diesen Tests erhält der Tester keinerlei Informationen über das Zielsystem. Dadurch werden reale Angriffsszenarien möglichst authentisch nachgestellt.
- **Whitebox-Tests:**  
  Hierbei wird dem Tester umfassend Wissen über die Systemarchitektur und Quellcodes zur Verfügung gestellt. Dies ermöglicht eine detaillierte Analyse der Sicherheitsmechanismen.

**Anwendungsfälle:**  
- **Blackbox:** Wenn ein realitätsnahes Angriffsszenario simuliert werden soll.  
- **Whitebox:** Zur umfassenden Überprüfung der internen Sicherheitsmechanismen eines Systems.

---

#### f) Social Engineering im Kontext von Penetrationstests

Angriffe im Bereich Social Engineering richten sich primär gegen die Benutzer und nicht direkt gegen technische Systeme.

**a) Fünf gängige Angriffstechniken:**  
1. **Phishing**  
2. **Shoulder Surfing**  
3. **Baiting**  
4. **Pretexting**  
5. **Tailgating**

**b) Erfolgsversprechende Techniken in Abhängigkeit von der Zielsetzung:**  
- **Phishing:** Geeignet zur Gewinnung von Zugangsdaten.  
- **Shoulder Surfing:** Effektiv zum Ausspähen von Passwörtern.  
- **Baiting:** Kann zur Entwendung sensibler Informationen genutzt werden.  
- **Pretexting:** Erlaubt die gezielte Beschaffung vertraulicher Daten.  
- **Tailgating:** Dient zur Erlangung physischen Zutritts.

**c) Maßnahmen aus Unternehmenssicht und im Alltag:**  
- **Unternehmen:**  
  - Regelmäßige Schulungen und Sensibilisierungsprogramme.  
  - Etablierung strikter Richtlinien zur Nutzung von IT-Systemen (z. B. bei mobiler Nutzung).  
  - Technische Maßnahmen, wie z. B. Spam-Filter und Sicherheitslösungen zur Überprüfung eingehender E-Mails.
- **Potenzielle Opfer:**  
  - Überprüfung von E-Mail-Inhalten auf verdächtige Merkmale.  
  - Verwendung von Sichtschutzfolien, um Shoulder Surfing zu verhindern.  
  - Vorsicht beim Umgang mit fremden USB-Sticks.  
  - Kontrolle des Zutritts zu Betriebsräumen durch Sicherheitsvorkehrungen.

---

#### g) Hacker-Typologien und Ablauf eines Penetrationstests

**a) Unterschied zwischen Ethical- (White-Hat) und Black-Hat-Hackern:**  
- **White-Hat-Hacker:** Personen, die ihre Kenntnisse im Bereich IT-Sicherheit zum Schutz und zur Verbesserung der Systemsicherheit einsetzen.  
- **Black-Hat-Hacker:** Personen, die ihre Fähigkeiten zu kriminellen Zwecken oder zur Ausnutzung von Sicherheitslücken einsetzen.  
- **Definition "Hacker":**  
  Ein Hacker ist eine Person, die über umfangreiche Kenntnisse in der Manipulation und Analyse technischer Systeme verfügt.

**b) Ablauf eines Penetrationstests anhand des 5-Phasen-Modells (BSI):**  
1. **Vorbereitung:** Planung und Absprache der Testziele und -grenzen.  
2. **Informationsbeschaffung:** Sammeln von Informationen über das Zielsystem.  
3. **Angriff:** Durchführung der Angriffssimulation und Ausnutzung identifizierter Schwachstellen.  
4. **Dokumentation:** Detaillierte Aufzeichnung der Vorgehensweise und Ergebnisse.  
5. **Abschluss:** Zusammenfassung der Erkenntnisse und Empfehlung von Gegenmaßnahmen.

**c) Klassifizierung von Penetrationstests:**  
Die Tests werden nach Umfang, Zielsetzung und Informationszugang klassifiziert. Das BSI unterscheidet etwa zwischen Blackbox-, Graybox- und Whitebox-Tests, wobei die Detailtiefe und das Vorwissen des Testers variieren.

**d) Auswirkungen von Social Engineering im Rahmen eines Penetrationstests:**  
Der Einsatz von Social Engineering kann negative psychologische Effekte auf Mitarbeiter haben, beispielsweise:
- Erhöhtes Misstrauen innerhalb des Teams, wenn Einzelfälle öffentlich werden.
- Schuldgefühle oder Stress, wenn Mitarbeiter das Gefühl haben, ihre Sicherheitsrichtlinien nicht eingehalten zu haben.

**e) Unterschied zwischen Port-Scan und Schwachstellenscan:**  
- **Port-Scan:**  
  Dient der Ermittlung offener Ports in einem System, um potenzielle Angriffspunkte zu identifizieren.
- **Schwachstellenscan:**  
  Analysiert das System auf bekannte Sicherheitslücken (z. B. veraltete Softwareversionen und damit verbundene Exploits).

---

## Zusammenfassung

Die überarbeitete Lösung zu Blatt 05 zeigt, dass Social Engineering – insbesondere in Form von Phishing (mit Varianten wie Clone Phishing, Spear Phishing und Whaling) – eine der effektivsten Methoden ist, um sensible Informationen zu erlangen. Ein gut durchdachtes Security Awareness Programm, das regelmäßige Schulungen und Simulationen umfasst, ist dabei ein zentrales Element zum Schutz vor solchen Angriffen.

Im Bereich des Pentestings liegt der Schwerpunkt auf der realistischen Überprüfung der Systemsicherheit. Penetrationstests liefern wichtige Erkenntnisse zur Identifikation von Schwachstellen, bergen jedoch auch Risiken, die durch sorgfältige Planung und qualifiziertes Personal minimiert werden müssen. Die Unterscheidung zwischen aktiven Pen-Tests und passiven Vulnerability Scans sowie zwischen Blackbox- und Whitebox-Tests ermöglicht eine differenzierte Herangehensweise an die Sicherheitsüberprüfung.

Abschließend wird deutlich, dass sowohl technische als auch organisatorische Maßnahmen – von Input-Sanitization und Prepared Statements bis hin zu kontinuierlichen Schulungen und klaren Richtlinien – notwendig sind, um die Sicherheit in einem dynamischen Bedrohungsumfeld nachhaltig zu gewährleisten.
