### **Aufgabe 1: (T) Zutrittskontrolle**

#### **a) Verschiedene Formen und Einsatzorte der Zutrittskontrolle**
Die Zutrittskontrolle umfasst eine Vielzahl von Verfahren, die in verschiedenen Kontexten eingesetzt werden, um den Zugang zu bestimmten Bereichen oder Ressourcen zu regulieren.

| **Einsatzort** | **Besonderheiten** |
|--------------|----------------|
| **„Die Tür“ an einem Club** | Manuelle Kontrolle durch Türsteher, oft auf subjektiver Basis (z. B. Dresscode, Verhalten, Gästeliste) |
| **Einlass beim LMU Erstifest „Unser erstes Mal“** | Eventticket oder Registrierung erforderlich, Kontrolle durch Ordner oder Scanner |
| **Ausweiskontrolle vor der IT-Sec-Klausur** | Identitätsprüfung durch Studierendenausweis, Prüfungsaufsicht stellt Übereinstimmung sicher |
| **Betreten der eigenen Wohnung** | Authentifizierung durch Schlüssel, biometrische Zugangssysteme oder Smart Locks |

**Unterschiede:**
- Clubs haben subjektive Kriterien (z. B. äußeres Erscheinungsbild), während Universitätsprüfungen auf eine formale Identitätsüberprüfung setzen.
- Öffentliche Events wie das Erstifest setzen oft auf Ticketkontrollen, während private Wohnungen oft physische Schlüssel oder digitale Zugangssysteme nutzen.
- Sicherheitslevel variiert je nach Kontext: Während Clubs und Events eher auf oberflächliche Kontrollen setzen, sind Zutrittskontrollen zu geschützten Bereichen (z. B. IT-Sicherheitsräume) oft strikter und mit mehrstufigen Prüfungen verbunden.

#### **b) (Teil-)Ziele der Zutrittskontrolle**
Die Zutrittskontrolle verfolgt mehrere Ziele, die je nach Einsatzbereich variieren:

1. **Sicherstellung der Authentizität**: Überprüfung, ob die zugangsberechtigte Person tatsächlich die ist, die sie vorgibt zu sein.
2. **Schutz sensibler Bereiche**: Verhindern, dass unautorisierte Personen Zugriff auf geschützte Räume oder Informationen erhalten.
3. **Verhinderung von Missbrauch**: Beispielsweise durch Identitätsdiebstahl oder unerlaubtes Vordringen in gesicherte Bereiche.
4. **Regulierung der Kapazität**: Kontrolle der Anzahl von Personen, die sich in einem bestimmten Bereich aufhalten dürfen (z. B. Brandschutzgrenzen).
5. **Erhöhung der physischen Sicherheit**: Verhinderung von Gefahren wie Diebstahl, Vandalismus oder Angriffen.

#### **c) Verfahrensschritte der Zutrittskontrolle**
Zutrittskontrollen bestehen aus mehreren Schritten:

1. **Identifikation**: Die Person gibt sich zu erkennen (z. B. durch einen Ausweis, ein Ticket oder biometrische Merkmale).
2. **Authentifikation**: Überprüfung der angegebenen Identität durch ein Authentifizierungsmerkmal (z. B. Passwort, biometrische Merkmale, Chipkarte).
3. **Autorisierung**: Entscheidung, ob die Person tatsächlich zutrittsberechtigt ist.
4. **Zutrittserlaubnis oder -verweigerung**: Falls die Authentifizierung erfolgreich ist, wird der Zugang gewährt (z. B. Tür öffnet sich, Schranke hebt sich).
5. **Protokollierung (optional)**: In sensiblen Bereichen (z. B. Serverräume, Hochsicherheitsbereiche) wird der Zugang protokolliert.

#### **d) Fehler und Angriffe auf die Zutrittskontrolle**
Potenzielle Schwachstellen, die Angreifer ausnutzen könnten:

| **Fehlerart** | **Möglicher Angriff** |
|--------------|------------------|
| **Schwache Authentifikation** | Nutzung von leicht zu fälschenden Ausweisen oder schlecht gesicherten Zugangscodes |
| **Social Engineering** | Manipulation von Sicherheitspersonal oder Systemen (z. B. Vortäuschen einer vergessenen Zutrittskarte) |
| **Tailgating/Piggybacking** | Unautorisierte Personen folgen autorisierten Nutzern durch eine Tür, bevor diese sich schließt |
| **Technische Angriffe** | Hacken von Zutrittskarten (z. B. durch Cloning von RFID-Karten) oder Ausnutzen von Sicherheitslücken |
| **Physische Manipulation** | Einsatz von Dietrichen oder Gewalt gegen mechanische Schließsysteme |

#### **e) Technische, bauliche und organisatorische Hilfsmittel zur Verstärkung der Zutrittskontrolle**
Zur Verbesserung der Zutrittskontrolle können verschiedene Maßnahmen ergriffen werden:

- **Technische Maßnahmen**:
  - RFID- und Chipkarten mit verschlüsselter Kommunikation
  - Biometrische Zugangssysteme (Fingerabdruck, Gesichtserkennung)
  - Zwei-Faktor-Authentifizierung (z. B. PIN + Fingerabdruck)

- **Bauliche Maßnahmen**:
  - Schleusensysteme, Drehkreuze
  - Sicherheitszonen mit mehrfachen Kontrollpunkten
  - Kameras zur Überwachung und Identifikation

- **Organisatorische Maßnahmen**:
  - Schulung von Personal zur Erkennung von Social-Engineering-Angriffen
  - Strenge Zutrittsrichtlinien und regelmäßige Kontrolle
  - Temporäre Zutrittsrechte für Gäste mit klar definierten Bedingungen

#### **f) Diskussion**
1. **Rolle eines „vertrauenswürdigen Dritten“**:
   - Ein vertrauenswürdiger Dritter (z. B. ein Identitätsprovider oder eine externe Zertifizierungsstelle) kann helfen, Identitätsnachweise zu validieren. Beispielsweise könnte eine IT-Sicherheitsklausur durch eine Online-Authentifizierungsplattform überprüft werden.
   - In der Praxis könnten vertrauenswürdige Dritte als digitale Identitätsanbieter (z. B. die „BundID“ oder Unternehmen wie Verimi) fungieren.

2. **Mitgliedsausweis eines Sportclubs**:
   - Der Mitgliedsausweis eines Sportclubs ist eine einfache Form der Zutrittskontrolle, die jedoch leicht zu umgehen ist (z. B. durch Weitergabe des Ausweises an Nicht-Mitglieder).
   - Sicherere Alternativen wären personengebundene RFID-Karten oder digitale Lösungen mit App-basierten Zugangscodes.

Fazit: Zutrittskontrolle ist ein komplexes, sicherheitskritisches Thema, das je nach Kontext unterschiedliche Maßnahmen erfordert. Die Kombination aus technischen, organisatorischen und baulichen Sicherheitsvorkehrungen kann dazu beitragen, eine zuverlässige Kontrolle zu gewährleisten.


### **Aufgabe 3: (T) Cyber Security Buzzword Bingo**  
Die folgenden Begriffe sind zentrale Konzepte in der IT-Sicherheit. Sie lassen sich grob in verschiedene Kategorien einteilen: Bedrohungen, Sicherheitsstrategien, Angriffs- und Verteidigungstechniken sowie organisatorische Maßnahmen.

---

### **1. Bedrohungen & Angriffe**  
Diese Begriffe beschreiben Bedrohungen und Angriffsvektoren in der IT-Sicherheit.

| **Buzzword** | **Erklärung** |
|-------------|--------------|
| **Cyber Threat** | Eine potenzielle Gefahr für IT-Systeme, Daten oder Netzwerke durch Angriffe oder Schwachstellen. |
| **Botnet** | Ein Netzwerk kompromittierter Computer („Zombies“), die von einem Angreifer ferngesteuert werden, um DDoS-Angriffe, Spam oder Malware-Verbreitung durchzuführen. |
| **Ransomware** | Eine Art von Malware, die Daten verschlüsselt und ein Lösegeld für die Entschlüsselung fordert. |
| **Exploit** | Eine gezielte Ausnutzung von Sicherheitslücken, um ein System zu kompromittieren. |
| **APT (Advanced Persistent Threat)** | Eine hochentwickelte, lang andauernde Cyberbedrohung, oft von staatlich unterstützten Gruppen durchgeführt. |
| **Malware** | Überbegriff für schädliche Software wie Viren, Würmer, Trojaner oder Ransomware. |
| **C2 / C&C (Command & Control)** | Ein Server, über den Angreifer Malware oder Botnets fernsteuern. |
| **TTP (Tactics, Techniques, and Procedures)** | Beschreibt die Methoden, die Angreifer für Cyberangriffe nutzen. |
| **Recon (Reconnaissance)** | Aufklärungsphase eines Angriffs, in der Informationen über das Ziel gesammelt werden. |

---

### **2. Sicherheitsstrategien & Verteidigungsmaßnahmen**  
Diese Begriffe beschreiben Konzepte und Technologien zur Abwehr von Bedrohungen.

| **Buzzword** | **Erklärung** |
|-------------|--------------|
| **Zero Trust** | Sicherheitskonzept, bei dem kein Nutzer oder Gerät automatisch vertraut wird – jeder Zugriff muss geprüft werden. |
| **Red & Blue Team** | Red Team simuliert Angreifer, Blue Team verteidigt Systeme. Purple Team kombiniert beide Ansätze zur Verbesserung der Sicherheit. |
| **Kill Chain** | Modell zur Beschreibung von Angriffsphasen – von der Aufklärung bis zur Aktion. |
| **Sandbox** | Eine isolierte Umgebung, um verdächtige Dateien auszuführen, ohne das eigentliche System zu gefährden. |
| **NGFW (Next-Generation Firewall)** | Moderne Firewall mit erweiterten Sicherheitsfunktionen wie DPI (Deep Packet Inspection) oder Intrusion Prevention. |
| **SIEM (Security Information and Event Management)** | Zentrale Plattform zur Erfassung, Analyse und Korrelation sicherheitsrelevanter Ereignisse (Logs, Alarme). |

---

### **3. Organisatorische & administrative Sicherheitsmaßnahmen**  
Diese Begriffe beziehen sich auf Sicherheitsrichtlinien, Normen und Awareness-Konzepte.

| **Buzzword** | **Erklärung** |
|-------------|--------------|
| **NIST (National Institute of Standards and Technology)** | US-Behörde, die Sicherheitsrichtlinien und Standards (z. B. das NIST Cybersecurity Framework) entwickelt. |
| **Allow- & Blocklist** | Listen zur Kontrolle, welche Anwendungen, IPs oder Domains erlaubt oder blockiert sind. |
| **Perimeter Security** | Klassische Netzwerksicherheitsstrategie, die sich auf äußere Schutzmaßnahmen wie Firewalls konzentriert. |
| **Security Awareness** | Schulungen und Maßnahmen, um Nutzer für IT-Sicherheit zu sensibilisieren. |
| **SOC (Security Operations Center)** | Ein Team oder eine Abteilung, die für die Überwachung und Reaktion auf Sicherheitsvorfälle verantwortlich ist. |

---

### **4. Sonstige Begriffe**  
Diese Begriffe sind entweder allgemeine Konzepte oder ironische Anspielungen auf übermäßigen Gebrauch von Buzzwords.

| **Buzzword** | **Erklärung** |
|-------------|--------------|
| **Hacker** | Jemand, der Systeme manipuliert – kann ethisch (White Hat), böswillig (Black Hat) oder irgendwo dazwischen (Grey Hat) agieren. |
| **Logs** | Protokolldaten, die Systemaktivitäten erfassen – essenziell für forensische Analysen und Intrusion Detection. |

---
