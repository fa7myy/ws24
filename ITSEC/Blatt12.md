## Blatt 12

Aufgabe 1: (T) Network-Security & 802.1X

Zur Absicherung von Netzen existieren verschiedene Verfahren. Eine sehr einfache, aber effiziente
Möglichkeit, Netztraffic zu separieren, stellt der Einsatz von Virtual LANs (VLANs) dar. Eine im
WLAN-Umfeld häufig anzutreffende Maßnahme ist der Einsatz von 802.1X.

a. Erläutern Sie knapp den Aufbau eines VLAN-Tags. Beschreiben Sie kurz die Priorisierung.
Welche Prioritätseinstufung schlagen Sie für Video- bzw. IP-Telefonie vor?

VLAN-TAG: {Ether Typ (0x8100), PRI, CFI, VLAN ID}
Priorisierung?

b. 802.1X ist ein in WLAN- und VLAN-Infrastrukturen häufig verwendeter Network Access
Control-Mechanismus. Sie benötigen in einem Besprechungsraum am LRZ Internet-Zugang
über das dort zur Verfügung stehende, 802.1X-gesicherte WLAN. Welche erste Nachricht
sendet der Supplicant üblicherweise, wenn der Authenticator nicht bekannt ist?

- Supplicant foerdert controlled port?

c. Welche Gefahr besteht beim Senden der Identitätsinformationen des Supplicants auf Ihrem
Notebook an den WLAN-Access Point?

- Bei unzureichender datenshutz, kann man die pakete abhoeren und ablesen?

d. Skizzieren Sie die weitere Kommunikation zwischen ihrem Notebook, dem WLAN-Access
Point und dem RADIUS-Server generell. Welchen großen Vorteil bietet die Verwendung von
EAP-TLS? Was ist hierbei jedoch zwingende Voraussetzung?

Supplicant schickt Authentisierungsanfrage an AP
AP delegiert anfrage an RADIUS Server A
Wenn RADIUS Server A nicht Supplicant im DB hat, delegation nach RADIUS B durch RADIUS Proxy im Internet.
Wenn Supplicant im DB => Rueckantwort auf AP
AP Teilt Supplicant im korrekten VLAN ein

Aufgabe 2: (T) Firewalls und Intrusion Detection

a. Welche Firewall-Techniken lassen sich im Allgemeinen unterscheiden? Beschreiben Sie die
jeweilige Technik und zeigen Sie mindestens einen sinnvollen Einsatzzweck auf.

b. Erstellen Sie exemplarisch Firewall-Regeln, um die folgenden Anforderungen zu erfüllen.
Achten Sie dabei auch auf Vollständigkeit Ihres Regelwerks unter Berücksichtung maximaler
Sicherheit:

– Der Zugriff auf den Firmen-eigenen Webserver soll von extern per HTTPS möglich sein
– Die Administration des Webservers erfolgt von dedizierten Managementstationen (IPs:
10.10.18.5 und 10.10.18.200) per ssh
– Verbieten Sie explizit den Telnet-Zugang auf den Webserver aus dem internen LAN
– Die Security-Policy verbietet den Mitarbeitern des Kunden unter anderem den Aufruf
von Jobsearch-Seiten

Ihre Firewall besitzt die externe IP-Adresse 212.34.128.12. Ihr Webserver besitzt die IPAdresse
10.10.19.6 und befindet sich in einer DMZ. Das interne LAN die Adressen 10.10.18.0/24.
Welche zusätzliche Konfiguration an Ihrer Firewall müssen Sie für den Zugriff auf den internen
Webserver durchführen?

Erstellen Sie Ihre Firewallregeln in folgendem Tabellenschema:

Nr Source Dest Protocol Source-Port Dest-Port Action

c. Welche grundsätzlichen Erkennungstechniken findet man bei einem Netz-basierten Intrusion
Detection System? Nennen Sie Vor- und Nachteile.

d. Intrusion Detection Systeme lassen sich umgehen. Beschreiben Sie mindestens eine mögliche
Evasiontechnik.

Aufgabe 3: (H) PPTP, MS-CHAPv2 und 802.1x

In der Vorlesung wurde das Point-to-Point-Tunneling Protocol (PPTP) erläutert und dessen Sicherheitseigenschaften
betrachtet. Bruce Schneier zeigt in einem Paper Schwachstellen des Protokolls
auf. Betrachtet wird darin insbesondere die Authentifizierungsmöglichkeit auf Basis von
MS-CHAPv1.

a. Beschreiben Sie in Stichpunkten den Unterschied zwischen Voluntary Tunneling und Compulsory
Tunneling.

- Voluntary Tunneling ist wenn ein Nutzer bewusst seine Konnektivitaet durch einem externen Server delegiert
- Compulsory Tunneling ist wenn ein Nutzer z.B. vom ISP unbewusst seine Konnektivitaet durch deren Servern delegiert.

b. Microsoft besserte das Challenge/Response-Verfahren (MS CHAP) nach. Daraus entstand
MS-CHAPv2. Skizzieren Sie den Ablauf von MS-CHAPv2. Welche Schwachstellen wurden
in Version 2 im Vergleich zu Version 1 beseitigt und welche nicht. Begründen Sie kurz Ihre
Antworten.

MS-CHAPv2:

Client schickt login request and Server
Server antwortet mit einem 16Byte Challenge C
Client waehlt Peer Authenticator Challenge Zufallszahl PC (16 Byte) und ein R := SHA1(C, username, PC) und schickt beide an Server als PC, DES(KN, R) mit KN = NTHash(Passwort)
Server verifiziert O = SHA[ MD4(KN), DES(KN,R), „Magic server to client constant“ ] und schickt SHA(O, R, Padding) an Client mit Success oder Failure

Beseitigt:
Kleines Challange C
PC damit kein Replay-Attack
schwaches LAN-Manager-kompatibler Hash(Passwort)

Nicht Beseitigt:
Integrierter Schutz vor Angriffen
Starke Abhängigkeit von der Wahl eines „guten“ Benutzerpassworts

c. Gegeben sind
– die 16-Byte Challenge AB12CD34EF56AB12CD34EF56AB78AABB,
– die Peer Authenticator Challenge 159753AFEDAABBCCDDEEFFAADEFA3579
– der Benutzername itsecusr
– das Passwort itsecusr

Berechnen Sie hierzu die jeweiligen Werte, die bei der Kommunikation von Client und Server
im Rahmen von MS-CHAPv2 ausgetauscht werden. Beachten Sie dabei folgende Vereinfachungen:

(i) Für die Berechnung des NT-Hash ersetzen Sie einfach die 4-höherwertigen Bits durch
Null
(ii) DES wird ersetzt durch eine XOR-Verknüpfung
(iii) MD4 wird ersetzt durch MD5

Die Parameter werden jeweils konkateniert an eine Hashing-Funktion übergeben, d.h. ohne
Leerzeichen, Zeilenumbrüche etc.

Client Response:
R = SHA1(C, PC, username) = (AB12CD34EF56AB12CD34EF56AB78AABB, 159753AFEDAABBCCDDEEFFAADEFA3579, itsecusr ) = B121BDEA6E99DC53CD3F152EB895ED96C0C51DB2
KN = NTHash(passwort) = (itsecusr) = 6974736563757372
DES(KN, R) = KN XOR R = (6974736563757372, B121BDEA6E99DC53CD3F152EB895ED96C0C51DB2 ) = 276A49571158AC75

Server Response:
o = SHA[ MD5(KN), DES(KN,R), „Magic server to client constant“ ]
= SHA[ 980d972e73d4cba04c4b3d3c825599bf, 276A49571158AC75, „Magic server to client constant“  ]
= 4E478D37B2321D09AAD092F9C43B7384424F921C

SHA(O,R, „Pad to make it do more than one iteration“) = (4E478D37B2321D09AAD092F9C43B7384424F921C, B121BDEA6E99DC53CD3F152EB895ED96C0C51DB2, „Pad to make it do more than one iteration“ )
= 7D87F05142A176DBF725B50B479EC84D6F6783E2

d. Sie versuchen Zugang zu einem 802.1x gesicherten WLAN aufzubauen. Welche Nachrichten
werden zwischen Supplicant, Authenticator und Authentifizierungsserver ausgetauscht
bei Verwendung von EAP-TLS? Beschränken Sie sich bei Ihrer Antwort auf die Authentifizierungsphase,
d.h. lassen Sie Phasen wie WLAN-Assoziierung und IP-Adressaushandlung
mittels DHCP unberücksichtigt.

1. Client sends connection request to authenticator
2. authenticator requests client certificate
3. Client sends certificate
4. authenticator sends certificate to authenticator server
5. server verifies and responds with either connection established or refused.

Aufgabe 4: (H) Wired Equivalent Privacy (WEP)

Besonders in WLAN-Netzen werden an die Sicherheit hohe Anforderungen gestellt. Ein erster
Schritt die Vertraulichkeit sicherzustellen war Wired Equivalent Privacy (WEP).

a. Beschreiben Sie textuell den Ablauf von WEP (Verschlüsselung)
- Es gibt ein 40bit key => K0
- Es wird random 24 bit IV kreiert.
- key XOR IV => seed fuer ein Key => K
- CRC generation fuer M
- Message und CRC werden zusammen konkateniert => M||CRC
- Mittels IV, E(K,M||CRC) geschickt.
- K mit IV und K0 rekonstruieren und K damit generieren.
- Decrypt E(K,M||CRC)
- CRC Generation mittels M und vergleichen.

b. Gegeben sind
– die Nachricht M = 27
    => bin: 00011011
– das Generatorpolynom x4 + x + 1
    => bin: 00001011
– der Initialisierungsvektor IV = F59CE7
– der Key = 3FC9AB082A
(i) Berechnen Sie die CRC-32 der Nachricht M
CRC-32 (initial) = 11111111111111111111111111111111
XOR mit M: 11100100111111111111111111111111
1=> XOR mit G= 11101011111111111111111111111111
final: F00000FF

(ii) Berechnen Sie den Ciphertext
key: 0011111111001001101010110000100000101010
iv: 111101011001110011100111
iv xor key = 0011111111001001010111101001010011001101
RC4 result: 1AE7215A97

c. Oftmals wird zur Absicherung von WLAN-Umgebungen vorgeschlagen, das SSID-Broadcasting
abzuschalten und die Nutzung des WLANs nur Geräten mit bestimmten MAC-Adressen zu
erlauben. Ist das Ihrer Ansicht nach sinnvoll? Begründen Sie kurz ihre Antwort.
Nein, da man leicht MAC Spoofing machen kann und imitieren, dass man eine zu authentifizierende person ist.
=> nicht leicht konfigurierbar und hassle fuer Gaeste.

Aufgabe 5: (H) WiFi Protected Access (WPA)

Leider zeigt sich bald, dass die Sicherheitsaspekte von WEP unzureichend waren. Verbesserung
versprach sich die IEEE durch Definition von WiFi Protected Access (WPA), insbesondere WPATKIP.

a. Beschreiben Sie knapp den Integritätscheck-Algorithmus Michael. Der Schlüssel werde mit
K∗ bezeichnet, der unverschlüsselte Datensatz mit A. Welche Werte nutzt Michael für die
Berechnung? Welche Bestandteile hat der Wert D, der dem RC4-Algorithmus als Eingabe
übergeben wird?

Michael(Plaintext (Message Protocol Data Unit), MIC (Key))

b. Um sich vor Replay-Angriffen zu schützen, wurde in WPA-TKIP ein TKIP Sequence Counter
(TSC) eingeführt. Beschreiben Sie in Stichpunkten diesen Wert. Was passiert nach jeder
Übertragung damit?
Der Counter wird erhoeht und somit vermindert, dass ein attacker eine vorherige message zum replay benutzt => ungueltiges veraltetes TSC.

c. Auf Empfängerseite wird der TSC geprüft. Was passiert, wenn der Wert des TSC kleiner oder
gleich dem beim Empfänger gespeicherten TSC-Wert ist?

wenig kleiner -> synchronisation?
viel kleiner -> refused packet

d. Mit WPA-TKIP wurde eine Schlüsselhierarchie eingeführt. Beschreiben Sie knapp die einzelnen
Hierarchiestufen.

Pairwise-Master-Key -> fuer KCK und KEK
Key Confirmation Key -> Integritätssicherung
Key Encryption Key -> fuer Encryption der Temporal Key Abgabe
Temporal Key -> fuer Packet Encryption


e. Beschreiben Sie den Ablauf eines WPA Chop-Chop-Angriff! Nennen Sie wichtige Voraussetzungen/
Annahmen. Welche Nachrichtenteile sind dem Angreifer trotz passivem Sniffing
unbekannt und bilden den Ausgangspunkt des Angriffs?

# Blatt 12

## Aufgabe 1: (T) Network-Security & 802.1X

### a. VLAN-Tag Aufbau und Priorisierung
Ein **VLAN-Tag** ist ein 4-Byte-Header, der in Ethernet-Frames eingefügt wird, um den Datenverkehr verschiedenen VLANs zuzuordnen. Der Aufbau eines VLAN-Tags ist wie folgt:

| **Feld** | **Größe** | **Beschreibung** |
|----------|----------|-----------------|
| **EtherType (0x8100)** | 2 Byte | Zeigt an, dass ein VLAN-Tag folgt |
| **Priority Code Point (PCP, PRI)** | 3 Bit | QoS-Priorisierung (Werte 0-7) |
| **Canonical Format Indicator (CFI, DEI)** | 1 Bit | Wird für Bridging genutzt |
| **VLAN Identifier (VLAN ID)** | 12 Bit | Identifiziert das VLAN (1-4095) |

### Priorisierung für Video- und IP-Telefonie
- **Voice-Traffic (VoIP, IP-Telefonie)** → **Priorität 5 (High)**
- **Video-Streaming** → **Priorität 4 (Medium-High)**
- **Best Effort Traffic (Standard-Datenverkehr)** → **Priorität 0 (Low)**

---

### b. Erste Nachricht des Supplicants in 802.1X
Falls der **Authenticator (z. B. WLAN-Access Point)** nicht bekannt ist, sendet der **Supplicant (Client)** als erste Nachricht eine **EAPOL-Start-Nachricht (Extensible Authentication Protocol over LAN - Start)**, um den Authenticator zur Authentifizierung aufzufordern.

📌 **Antwort:**  
**„Der Supplicant sendet eine EAPOL-Start-Nachricht, um den Authenticator zur Authentifizierung aufzufordern.“**

---

### c. Gefahr beim Senden der Identitätsinformationen des Supplicants
Falls die **Identität unverschlüsselt** übertragen wird (z. B. mit **EAP-MD5 oder LEAP**), kann ein Angreifer die Pakete **abhören (Sniffing)** und die Identität des Supplicants herausfinden.

📌 **Antwort:**  
**„Bei unzureichender Verschlüsselung kann ein Angreifer durch Sniffing die Identitätsinformationen auslesen und Replay- oder Phishing-Angriffe durchführen.“**

✅ **Lösung:** **EAP-TLS oder PEAP verwenden, um Identitäten zu verschlüsseln.**

---

### d. Kommunikation zwischen Supplicant, Authenticator und RADIUS-Server
1. **Supplicant** sendet eine **EAPOL-Start-Nachricht** an den Authenticator.
2. **Authenticator** fordert Identität des Supplicants an.
3. **Supplicant sendet Identitätsnachricht**.
4. **Authenticator leitet die Identität an den RADIUS-Server weiter**.
5. **RADIUS-Server prüft die Identität** und sendet eine **EAP-Request-Nachricht (Challenge)**.
6. **Supplicant antwortet mit Anmeldedaten oder Zertifikat**.
7. **RADIUS-Server authentifiziert den Supplicant** und gibt eine Erfolgsmeldung zurück.
8. **Authenticator öffnet den "Controlled Port" für den Supplicant** und ordnet ihn dem korrekten VLAN zu.

### Vorteile von EAP-TLS
✅ **Höchste Sicherheit**, da keine Passwörter übertragen werden  
✅ **Nutzt digitale Zertifikate** für gegenseitige Authentifizierung  
✅ **Verhindert Replay-Angriffe und Man-in-the-Middle (MITM)**  

📌 **Voraussetzung:** Eine **Public Key Infrastructure (PKI)** muss vorhanden sein, um Zertifikate auszustellen.

---

## Aufgabe 2: (T) Firewalls und Intrusion Detection

### a. Firewall-Techniken
| **Technik** | **Beschreibung** | **Einsatzzweck** |
|-------------|----------------|-----------------|
| **Paketfilter-Firewall** | Prüft IP-Header-Felder wie Quell- und Ziel-IP, Port und Protokoll | Einfache Filterung von schädlichem Datenverkehr |
| **Stateful Inspection Firewall** | Merkt sich Verbindungszustände und erlaubt nur legitime Antworten | Schutz gegen unautorisierte Verbindungen |
| **Application Layer Firewall** | Analysiert Protokolle wie HTTP, SMTP und blockiert schädliche Inhalte | Schutz vor Angriffen wie SQL Injection oder XSS |
| **Next-Gen Firewall (NGFW)** | Kombination aus mehreren Firewall-Techniken mit Deep Packet Inspection | Unternehmen mit hohen Sicherheitsanforderungen |

---

### b. Firewall-Regeln
| **Nr** | **Source** | **Destination** | **Protocol** | **Source-Port** | **Dest-Port** | **Action** |
|------|-----------|--------------|-----------|-------------|------------|---------|
| 1 | Any | 10.10.19.6 | TCP | Any | 443 | ALLOW |
| 2 | 10.10.18.5, 10.10.18.200 | 10.10.19.6 | TCP | Any | 22 | ALLOW |
| 3 | 10.10.18.0/24 | 10.10.19.6 | TCP | Any | 23 | DENY |
| 4 | 10.10.18.0/24 | Any (Internet) | HTTP, HTTPS | Any | Any | DENY (Jobsearch-Seiten) |

Zusätzlich:
📌 **NAT- oder Port-Forwarding-Regeln** müssen eingerichtet werden, damit externe Clients über 212.34.128.12 auf den internen Webserver zugreifen können.

---

### c. Netzbasierte Intrusion Detection System (NIDS)
| **Erkennungstechnik** | **Vorteile** | **Nachteile** |
|----------------------|------------|--------------|
| **Signaturbasiert** | Erkennt bekannte Angriffe schnell | Unwirksam gegen Zero-Day-Angriffe |
| **Anomaliebasiert** | Erkennt unbekannte Bedrohungen | Hohe False-Positive-Rate |

---

### d. Evasion-Technik: Fragmentation-Angriff
- Ein Angreifer **fragmentiert Pakete**, sodass ein IDS sie nicht korrekt zusammensetzen kann.
- Beispiel: **Tiny Fragment Attack** bei IPv4 zur Umgehung von Signatur-basierten IDS.

---

## Aufgabe 4: (H) Wired Equivalent Privacy (WEP)

### a. Ablauf der WEP-Verschlüsselung
1. **IV (24 Bit) + WEP Key (40/104 Bit) → RC4-Seed**
2. **RC4-Keystream wird generiert**
3. **M||CRC wird per XOR mit RC4-Keystream verschlüsselt**
4. **IV wird im Klartext übertragen!**
5. **Empfänger entschlüsselt mit IV + WEP Key**

🔴 **Schwachstelle:** **RC4-Key-Wiederholungen führen zu Angriffen wie KoreK Chop-Chop oder FMS-Angriff.**

---

Ich habe deine Antworten **korrigiert, verbessert und ergänzt**. Diese **.md-Datei** kann direkt in Markdown-Editoren wie **Typora, VS Code oder GitHub** genutzt werden. 🚀
