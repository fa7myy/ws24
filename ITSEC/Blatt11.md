# Blatt 11

## Aufgabe 1: (T) OIDC

**OpenID Connect (OIDC)** implementiert eine vereinfachte Authentifizierung auf Basis des OAuth 2.0 Frameworks. Es ermöglicht die Nutzung einer zentral verwalteten digitalen Identität, die von verschiedenen Services verwendet werden kann. Weitere Informationen finden Sie z. B. unter [openid.net/connect/faq](https://openid.net/connect/faq/).

### a. Allgemeiner Ablauf der Authentifizierung mit OIDC

1. **Client-Anfrage:**  
   Der Client (z. B. eine Web- oder Mobile-Applikation) leitet den Benutzer zur Authentifizierung an den Identity Provider (IDP) weiter. Dabei wird eine Authentifizierungsanfrage (Authorization Request) mit Parametern wie Client-ID, Redirect-URI, Scope und einem optionalen Nonce gesendet.

2. **Benutzer-Authentifizierung:**  
   Der Benutzer authentifiziert sich beim Identity Provider (IDP) mittels eines Logins (z. B. Benutzername/Passwort, Multi-Faktor).

3. **Erteilung der Zustimmung:**  
   Falls erforderlich, wird der Benutzer um Zustimmung gebeten, dass der Client auf bestimmte Informationen (Scopes) zugreifen darf.

4. **Ausgabe eines Autorisierungscodes:**  
   Nach erfolgreicher Authentifizierung und Zustimmung wird der Benutzer an die angegebene Redirect-URI zurückgeleitet. Dabei wird ein Autorisierungscode (Authorization Code) übergeben.

5. **Token-Anforderung:**  
   Der Client tauscht den Autorisierungscode beim Token Endpoint des IDP gegen ein Access Token und ein ID Token aus.

6. **Validierung und Nutzung des ID Tokens:**  
   Das ID Token, das in der Regel als JSON Web Token (JWT) vorliegt, enthält Informationen über den Benutzer (Claims) und wird vom Client validiert. Das Token dient zur Authentifizierung und Identitätsbestätigung.

### b. Die zwei Hauptakteure in einer OIDC-Interaktion und deren Rollen

- **Identity Provider (IDP):**  
  - Stellt die digitale Identität des Benutzers bereit.  
  - Authentifiziert den Benutzer und gibt nach erfolgreicher Authentifizierung Autorisierungscodes bzw. Tokens aus.  
  - Verwaltet und schützt die Benutzerinformationen.

- **Relying Party (RP) / Client:**  
  - Ist der Service, der den OIDC-Mechanismus nutzt, um Benutzer zu authentifizieren.  
  - Leitet die Benutzer zur Authentifizierung an den IDP weiter.  
  - Erhält und validiert das ID Token, um sicherzustellen, dass der Benutzer authentisch ist.

### c. Aufbau eines ID Tokens

Ein ID Token ist typischerweise ein **JSON Web Token (JWT)** und besteht aus drei Teilen, die jeweils Base64Url-kodiert und durch Punkte (`.`) getrennt sind:

1. **Header:**  
   - Gibt den Typ des Tokens (JWT) und den verwendeten Signaturalgorithmus (z. B. RS256) an.
   
2. **Payload (Claims):**  
   - Enthält die Benutzerinformationen (Claims) wie `sub` (Subject, eindeutige Benutzer-ID), `name`, `email`, sowie zeitbezogene Angaben (`iat`, `exp`, `auth_time`) und optional weitere benutzerspezifische oder kontextbezogene Claims.
   
3. **Signature:**  
   - Dient zur Verifizierung der Authentizität des Tokens. Sie wird erstellt, indem der Header und Payload mit einem geheimen Schlüssel (bei symmetrischer Signatur) oder einem privaten Schlüssel (bei asymmetrischer Signatur) signiert wird.

---

## Aufgabe 2: (T) X.509

X.509-Zertifikate spielen eine zentrale Rolle in der Public Key Infrastructure (PKI) und dienen zur Identitätsüberprüfung und sicheren Kommunikation (z. B. bei TLS).

### a. Aufgabenspektrum einer Certificate Authority (CA)

Eine **Certificate Authority (CA)** hat unter anderem folgende Aufgaben:
- **Identitätsprüfung:**  
  Überprüfung und Validierung der Identität von Antragstellern (z. B. Organisationen, Server).
- **Ausstellung von Zertifikaten:**  
  Ausstellung von digitalen Zertifikaten, die den öffentlichen Schlüssel und Identitätsinformationen des Antragstellers enthalten.
- **Verwaltung von Zertifikaten:**  
  Verwaltung des Lebenszyklus der Zertifikate, einschließlich Erneuerung und Widerruf.
- **Vertrauensanker:**  
  Bereitstellung von vertrauenswürdigen Zertifikaten, die in Browsern und Betriebssystemen als vertrauenswürdig hinterlegt sind.

### b. Grundsätzliche Ansätze zum Widerruf eines Zertifikats

Es gibt mehrere Ansätze, um ein Zertifikat zu widerrufen:

1. **Certificate Revocation List (CRL):**  
   - Eine von der CA veröffentlichte Liste, auf der alle widerrufenen Zertifikate aufgeführt sind.
   - Clients laden regelmäßig die CRL herunter, um zu überprüfen, ob ein Zertifikat widerrufen wurde.

2. **Online Certificate Status Protocol (OCSP):**  
   - Ein Protokoll, bei dem der Client in Echtzeit den Status eines Zertifikats direkt beim OCSP-Responder der CA abfragt.
   - Bietet aktuellere Informationen als CRLs und reduziert die Notwendigkeit, große Listen herunterzuladen.

3. **OCSP Stapling:**  
   - Der Server liefert bei der TLS-Handshake den aktuellen OCSP-Status zusammen mit seinem Zertifikat.
   - Verbessert die Performance und reduziert die Abhängigkeit vom direkten OCSP-Abruf durch den Client.

### c. Ablauf des Online Certificate Status Protocol (OCSP)

1. **Client-Anfrage:**  
   - Beim Aufbau einer TLS-Verbindung fragt der Client (oder der Server via OCSP Stapling) den Status eines Zertifikats beim OCSP-Responder an.

2. **OCSP-Responder:**  
   - Der OCSP-Responder, der in der Regel von der CA betrieben wird, überprüft den Zertifikatsstatus in seiner Datenbank oder CRL und erstellt eine Antwort.

3. **Antwort:**  
   - Der OCSP-Responder sendet eine Antwort zurück, in der der Status des Zertifikats als `good` (gültig), `revoked` (widerrufen) oder `unknown` angegeben wird.
   - Diese Antwort wird vom Client verifiziert und fließt in die Entscheidung ein, ob die Verbindung fortgesetzt werden soll.

4. **Integration:**  
   - OCSP Stapling erlaubt dem Server, die OCSP-Antwort während des TLS-Handshakes an den Client zu übermitteln, wodurch der zusätzlichen OCSP-Abruf entfällt.

---

## Aufgabe 3: (T) Bring Your Own Device (BYOD)

**Bring Your Own Device (BYOD)** bezeichnet die Praxis, bei der Mitarbeiter:innen private Geräte (Smartphones, Laptops, Tablets) für dienstliche Zwecke nutzen. Dies kann sowohl Vorteile als auch Nachteile für beide Seiten mit sich bringen.

### a. Vorteile von BYOD

- **Kostenersparnis für das Unternehmen:**  
  Reduzierung der Investitionen in unternehmenseigene Hardware.
- **Benutzerfreundlichkeit:**  
  Mitarbeiter:innen sind oft bereits mit ihren eigenen Geräten vertraut, was die Bedienung erleichtert.
- **Flexibilität und Mobilität:**  
  Erhöhte Flexibilität und oft eine bessere Arbeitsmobilität, da Mitarbeiter:innen ihre Geräte auch außerhalb des Büros nutzen.
- **Geringerer Verwaltungsaufwand:**  
  Weniger Aufwand bei der Bereitstellung und Wartung von Hardware.
- **Motivation und Zufriedenheit:**  
  Mitarbeiter:innen können Geräte nutzen, die ihren persönlichen Präferenzen entsprechen, was die Zufriedenheit steigern kann.

### b. Nachteile von BYOD

- **Datenschutz und Sicherheitsrisiken:**  
  Sensible Unternehmensdaten könnten auf privaten Geräten gespeichert werden, die möglicherweise nicht ausreichend gesichert sind.
- **Mischung von Privat- und Arbeitsleben:**  
  Die Trennung von privaten und dienstlichen Daten kann verschwimmen, was zu Datenschutzproblemen führen kann.
- **Erhöhtes Risiko von Cyberangriffen:**  
  Private Geräte können Ziel von Angriffen werden, wodurch Unternehmensdaten gefährdet werden.
- **Eingeschränkte Kontrolle durch den Arbeitgeber:**  
  Der Arbeitgeber hat weniger Einfluss auf die Sicherheitsrichtlinien und -konfigurationen privater Geräte.
- **Compliance-Probleme:**  
  Schwierigkeiten bei der Einhaltung von gesetzlichen und regulatorischen Vorgaben im Umgang mit sensiblen Daten.

### c. Vergleich: BYOD vs. Private Nutzung dienstlicher Geräte und weitere Ansätze

#### BYOD:
- **Vorteile:**
  - Kosteneinsparungen und erhöhte Flexibilität.
  - Mitarbeiter:innen arbeiten mit vertrauter Hardware.
- **Nachteile:**
  - Geringere Kontrolle durch den Arbeitgeber.
  - Erhöhte Sicherheits- und Datenschutzrisiken.

#### Private Nutzung dienstlicher Geräte (Corporate-Owned, Personally-Enabled – COPE):
- **Vorteile:**
  - Höhere Kontrolle und standardisierte Sicherheitsrichtlinien.
  - Klare Trennung zwischen beruflicher und privater Nutzung.
- **Nachteile:**
  - Höhere Anschaffungskosten.
  - Mögliche Unzufriedenheit der Mitarbeiter:innen, da das Gerät nicht den persönlichen Vorlieben entspricht.
- **Weitere Ansätze zur Unterstützung beider Parteien:**
  - **Schulungen:** Regelmäßige Sicherheits- und Datenschutzschulungen für Mitarbeiter:innen.
  - **Firmen-VPN und Sicherheitssoftware:** Installation von firmeneigener Sicherheitssoftware, VPN-Lösungen und Mobile Device Management (MDM)-Systemen.
  - **Screen Protection und Verschlüsselung:** Einsatz von Bildschirmschutzmaßnahmen und Datenverschlüsselung auf den Geräten.
  - **Klare Policies:** Entwicklung und Durchsetzung von Richtlinien, die den sicheren Umgang mit Unternehmensdaten regeln.
