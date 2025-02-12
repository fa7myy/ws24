### **Lösungsvorschläge für Übungsblatt 1 – IT-Sicherheit (WS 24/25)**  

---

## **Aufgabe 1: (T) Kategorisierung von Sicherheitsmaßnahmen**  

### **a) Unterschied zwischen technischen und organisatorischen Maßnahmen sowie zwischen präventiven, detektiven und reaktiven Maßnahmen**  

| **Kategorie** | **Definition** | **Beispiel** |
|--------------|---------------|-------------|
| **Technische Maßnahmen** | Maßnahmen, die durch Hardware oder Software implementiert werden, um Sicherheitsziele zu erreichen. | Firewalls, Verschlüsselung, Antivirensoftware |
| **Organisatorische Maßnahmen** | Sicherheitsmaßnahmen, die durch Richtlinien, Prozesse oder Schulungen umgesetzt werden. | Sicherheitsrichtlinien, Zugriffskontrollen, Security Awareness-Schulungen |

| **Maßnahmenart** | **Definition** | **Beispiel** |
|----------------|--------------|-------------|
| **Präventiv** | Maßnahmen zur Vorbeugung von Sicherheitsvorfällen. | Zugangskontrollen, Patch-Management |
| **Detektiv** | Maßnahmen zur Erkennung von Sicherheitsvorfällen. | Intrusion Detection Systems (IDS), Log-Überwachung |
| **Reaktiv** | Maßnahmen zur Eindämmung und Behebung von Sicherheitsvorfällen. | Incident Response, Wiederherstellung aus Backups |

---

### **b) Kategorisierung der Sicherheitsmaßnahmen**  

| **Sicherheitsmaßnahme** | **Kategorie** | **Begründung** |
|-------------------------|--------------|---------------|
| **Patchmanagement-Workflow** | Technisch-präventiv | Verhindert das Ausnutzen von Sicherheitslücken durch regelmäßige Updates. |
| **Host Intrusion Detection System (HIDS)** | Technisch-detektiv | Überwacht Systeme auf ungewöhnliche Aktivitäten und meldet diese. |
| **Access Control Lists (ACLs)** | Technisch-präventiv | Regelt den Zugriff auf Netzwerke und Ressourcen. |
| **Richtlinie zur Entsorgung von Datenträgern** | Organisatorisch-präventiv | Definiert, wie Daten sicher gelöscht oder vernichtet werden. |
| **Zutrittskontrolle** | Organisatorisch-präventiv | Regelt physischen Zugang zu sicherheitskritischen Bereichen. |
| **Backup** | Technisch-reaktiv | Ermöglicht Wiederherstellung nach Datenverlust. |

---

### **c) Schutzziele der Informationssicherheit (CIA) und zugehörige Maßnahmen**  

| **Sicherheitsmaßnahme** | **Schutzziel (CIA)** | **Begründung** |
|-------------------------|--------------------|--------------|
| **E-Mail-Signatur** | Integrität, Authentizität | Stellt sicher, dass der Absender authentisch ist und die Nachricht nicht verändert wurde. |
| **E-Mail-Verschlüsselung** | Vertraulichkeit | Schützt den Inhalt vor unbefugtem Zugriff. |
| **Dokumenten-Backup** | Verfügbarkeit | Ermöglicht Datenwiederherstellung nach Systemausfällen. |
| **Dokumenten-Archivierung** | Integrität, Verfügbarkeit | Langfristige Sicherstellung von Datenkonsistenz und Zugriff. |

---

## **Aufgabe 2: (T) SolarWinds**  

### **a) Ablauf der SolarWinds-Angriffsreihe**  
- Der Angriff begann mit einer Manipulation der Orion-Software von SolarWinds durch eine APT-Gruppe (mutmaßlich staatlich unterstützt).  
- Die Angreifer fügten einen bösartigen Code in ein Software-Update ein (Supply-Chain-Angriff).  
- Nach der Verteilung dieses Updates infizierten sie Systeme weltweit und konnten sich unbemerkt Zugang zu Unternehmensnetzwerken verschaffen.  

---

### **b) Schwachstellen und unentdeckte Verbreitung**  
- **Schwachstelle:** Unsichere Software-Supply-Chain, unzureichende Code-Integritätsprüfung.  
- **Verbreitung:** Automatische Updates infizierten viele Organisationen, einschließlich Regierungsbehörden.  
- **Unentdecktheit:** Nutzung legitimer IT-Management-Software als Angriffsvektor, versteckte Backdoors.  

---

### **c) Wiederherstellung des IT-Betriebs**  
- Ermittlung betroffener Systeme  
- Bereinigung der Systeme durch Neuinstallation  
- Implementierung sicherer Update-Prozesse  
- Netzwerksegmentierung zur Isolation betroffener Systeme  

---

### **d) Supply-Chain-Angriff**  
Ein Angriff, bei dem ein Angreifer ein Produkt oder eine Dienstleistung in der Lieferkette manipuliert, bevor es beim Endkunden ankommt.  

---

### **e) Präventions- & Detektionsmaßnahmen**  
- Strikte Code-Signaturen & Integritätsprüfungen  
- Zero-Trust-Ansatz für Updates  
- Threat-Hunting zur Erkennung von ungewöhnlichem Netzwerkverkehr  

---

## **Aufgabe 3: (T) ISO/IEC 27000**  

### **a) Begriffsdefinitionen**  
| **Begriff** | **Definition** |
|------------|--------------|
| **ISMS (Informationssicherheits-Managementsystem)** | Rahmenwerk zur Verwaltung von Sicherheitsrichtlinien und -prozessen. |
| **Leitlinie** | Allgemeine Vorgabe zur Informationssicherheit in einer Organisation. |
| **Asset** | Jede Ressource mit Wert für eine Organisation (z. B. Daten, Hardware). |
| **Risiko** | Möglicher Schaden durch eine Bedrohung, kombiniert mit dessen Wahrscheinlichkeit. |

---

### **b) Unterschied zwischen Richtlinie, Prozess und Verfahren**  
- **Richtlinie:** Grundsätzliche Vorgabe („Daten dürfen nur verschlüsselt gespeichert werden“).  
- **Prozess:** Allgemeiner Ablauf zur Umsetzung einer Richtlinie.  
- **Verfahren:** Konkrete Umsetzung eines Prozesses (z. B. spezifische Software zur Verschlüsselung).  

---

### **c) Deming-Zyklus und Überprüfung (Check)**  
- **Plan – Do – Check – Act (PDCA)**  
- **Check:** Audits, Penetrationstests, Log-Analysen  

---

### **d) Risikomanagement gemäß ISO/IEC 27000**  
1. **Risikoanalyse** (Identifikation & Bewertung von Bedrohungen)  
2. **Risikobewertung** (Einordnung der Risiken nach Schweregrad)  
3. **Risikobehandlung** (Reduzieren, Übertragen, Akzeptieren oder Vermeiden)  

---

### **e) Risikobehandlungsoptionen**  
- **Reduzieren:** Sicherheitsmaßnahmen ergreifen  
- **Übertragen:** Risiko an Dritte (z. B. Versicherung)  
- **Akzeptieren:** Risiko bewusst in Kauf nehmen  
- **Ignorieren ist nicht erlaubt**, da Risiken aktiv bewertet und dokumentiert werden müssen.  

---

## **Aufgabe 4: (H) Allgemeine Grundlagen der Informationssicherheit**  

### **a) Sicherheitsziele und Maßnahmen**  
| **Ziel** | **Definition** | **Maßnahme** |
|---------|--------------|--------------|
| **Vertraulichkeit** | Schutz vor unbefugtem Zugriff | Verschlüsselung |
| **Integrität** | Schutz vor Manipulation | Digitale Signaturen |
| **Verfügbarkeit** | Sicherstellen des Zugriffs | Redundante Systeme |
| **Authentizität** | Nachweis der Echtheit | Zwei-Faktor-Authentifizierung |

---

### **b) Unterschied Security vs. Safety**  
- **Security:** Schutz vor böswilligen Angriffen (z. B. Firewalls, Zugriffskontrollen).  
- **Safety:** Schutz vor unbeabsichtigten Fehlern (z. B. Notstromversorgung, Redundanzen).  

---

### **c) Bell-LaPadula-Modell**  
- **No-Read-Up:** Benutzer dürfen nur auf ihre eigene oder niedrigere Sicherheitsstufen zugreifen.  
- **No-Write-Down:** Höherstufige Benutzer dürfen keine Daten an niedrigere Stufen schreiben.  
- **Dominance Relation:** Benutzer haben nur Zugriff, wenn ihre Sicherheitsstufe die des Dokuments dominiert.  

---

## **Aufgabe 5: (H) Assets, Bedrohungen und Risiken**  

### **a) Identifikation von Assets**  
| **Primäre Assets** | **Unterstützende Assets** |
|------------------|------------------|
| Finanzdaten | Buchhaltungssoftware |
| Personaldaten | HR-Server |

---

### **b) Bedrohungen für Personaldaten**  
- Unautorisierter Zugriff  
- Datenverlust durch Hardware-Fehler  

---

### **c) Risikoanalyse**  
- **Asset:** Personaldaten  
- **Bedrohung:** Ransomware  
- **Risiko:** Verlust sensibler Daten und DSGVO-Verstöße  

---

### **d) Eliminierung des Risikos**  
- Offline-Backups mit Air-Gap-Sicherung  

---

### **e) Risiko-Modifikation**  
- Endpoint Detection & Response (EDR) zum Blockieren von Malware  

---

### **f) Reduzierte Eintrittswahrscheinlichkeit oder Auswirkung?**  
- **Maßnahme reduziert die Eintrittswahrscheinlichkeit**, indem Ransomware früh erkannt und gestoppt wird.  

### **Ist der PDCA-Zyklus ein ISMS?**  

**Nein**, der **PDCA-Zyklus** (Plan-Do-Check-Act) **ist kein ISMS (Informationssicherheits-Managementsystem)**, sondern ein **Managementprinzip** zur kontinuierlichen Verbesserung, das in vielen Bereichen angewendet wird – darunter auch in der Informationssicherheit.  

Das **ISMS (Informationssicherheits-Managementsystem)** nach **ISO/IEC 27001** ist ein Rahmenwerk zur Verwaltung und Verbesserung der Informationssicherheit in einer Organisation. **Der PDCA-Zyklus ist jedoch ein zentraler Bestandteil des ISMS**, weil er hilft, Informationssicherheitsprozesse laufend zu optimieren.  

### **Zusammenhang zwischen PDCA und ISMS**  
ISO/IEC 27001 fordert einen **kontinuierlichen Verbesserungsprozess (KVP)** für das ISMS – und dieser basiert oft auf dem **PDCA-Zyklus**.

| **PDCA-Phase** | **Bedeutung im ISMS** | **Beispiel** |
|--------------|---------------------|--------------|
| **Plan** (Planen) | Risiken analysieren, Maßnahmen planen | Risikoanalyse, Sicherheitsrichtlinien erstellen |
| **Do** (Umsetzen) | Maßnahmen implementieren | Firewall einrichten, Security-Schulungen durchführen |
| **Check** (Überprüfen) | Wirksamkeit der Maßnahmen messen | Penetrationstests, Log-Analysen, Audits |
| **Act** (Verbessern) | Verbesserungen ableiten | Anpassung der Sicherheitsrichtlinien, Einführung neuer Schutzmechanismen |
