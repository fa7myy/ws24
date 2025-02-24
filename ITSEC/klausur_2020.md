# IT Security Questions and Answers

## Multiple Choice Questions (MCQs) with Correct Answers

### **1. MD5 - Cryptographic Hash Function**
**Question:** Which of the following statements about MD5 are correct?

✅ **C:** The message to be hashed is divided into 512-bit input blocks.  
✅ **D:** It is often used when downloading larger files, such as ISO images, to verify that the downloaded file is correct.  

---

### **2. MS-CHAPv2 - Authentication Protocol**
**Question:** Which of the following statements about Microsoft's MS-CHAPv2 are correct?

✅ **C:** MS-CHAPv2 still depends on choosing a good user password.  
✅ **D:** An attacker has a way to initiate a version fallback to MS-CHAPv1.  

---

### **3. Difference Between Viruses and Worms**
**Question:** How does a virus differ from a worm?

✅ **D:** A worm is independently executable.  

---

### **4. Preventing Brute-Force Attacks**
**Question:** What security measures do companies use to prevent successful brute-force attacks on their systems and application access?

✅ **A:** Limiting the maximum login attempts per user per unit of time.  
✅ **B:** Intrusion Detection Systems.  
✅ **C:** Multi-factor authentication systems, e.g., RSA Tokens, YubiKeys.  

---

### **5. GDPR (General Data Protection Regulation)**
**Question:** Which of the following statements about GDPR are correct?

✅ **C:** Data may only be processed for specific purposes.  

---

### **6. Optical Fingerprint Sensors**
**Question:** Why are optical fingerprint sensors commonly used?

✅ **C:** They are cheaper than capacitive or ultrasonic sensors.  

---

### **7. Wired Equivalent Privacy (WEP)**
**Question:** Which statements do not apply to WEP?

✅ **A:** The initialization vector is always 64 bits long.  
✅ **C:** Either DES or AES is used to generate the bitstream.  

---

### **8. Information Security Goals Achievable with Cryptographic Methods**
**Question:** Which security objectives can be achieved through cryptographic methods?

✅ **A:** Confidentiality.  
✅ **B:** Authenticity.  
✅ **D:** Integrity.  

---

### **9. Common Vulnerability Scoring System 3 (CVSSv3)**
**Question:** Which statements about CVSSv3 are correct?

✅ **A:** It distinguishes between Base, Temporal, and Environmental metrics.  
✅ **D:** Temporal metrics help determine whether the vulnerability is only theoretical or already actively exploited.  

---

### **10. SYN Flood Attack**
**Question:** What are characteristic properties of the SYN Flood attack?

✅ **D:** The attacker establishes so many half-open connections to the target system that its resources are exhausted.  

---

### **11. Categorization of IT Attacks**
**Question:** Which of the following statements about IT attacks are correct?

✅ **A:** In addition to active attacks, there are also passive ones.  
✅ **B:** Attacks can be described using an attacker model, such as the MOM principle (Motivation - Opportunity - Means).  

---

## Open Questions with Detailed Answers

### **1. How Does a Buffer Overflow Occur and What is the Goal of a Stack-Smashing Attack?**
- A **buffer overflow** happens when a program writes more data into a buffer than it can hold, causing adjacent memory to be overwritten.
- **A Stack-Smashing Attack:**  
  - Overwrites the return address of a function on the stack.  
  - Redirects execution to attacker-controlled code (e.g., shellcode).  
  - **Goal:** Gain control over the system and execute arbitrary commands.

---

### **2. Bypassing the NX Bit in a Buffer Overflow Exploit**
- **What does the NX Bit prevent?**  
  - Prevents execution of injected shellcode in non-executable memory regions (stack/heap).
- **Bypassing Method: Return-Oriented Programming (ROP)**
  - Uses **existing code fragments (gadgets)** in executable memory.
  - Chained gadgets perform malicious operations without injecting code.

---

### **3. Steganography - Concealing Secret Messages**
- **How does it work?**  
  - Hides secret messages within media files (images, audio, video) without noticeable changes.
- **Example Attack:**  
  - Extracting hidden data from an image using **LSB (Least Significant Bit) analysis**.

---

### **4. Needham-Schroeder Protocol Replay Attack**
- **Attack Setup:**  
  - An attacker replays an old session key message to trick a server.
- **Does it succeed?**  
  - **No, if the protocol includes Nonces or the Denning-Sacco fix.**  
  - If implemented securely, **the attack is prevented.**

---

### **5. Kerberos Authentication - Authenticator Usage**
- **Who creates it?**  
  - **The client.**
- **Purpose:**  
  - Prevents **replay attacks** using timestamps.
  - Ensures the requester is **the legitimate session owner**.

---

### **6. Risk Treatment Options in ISO/IEC 27005**
1. **Risk Avoidance** – Eliminate the activity causing the risk.  
2. **Risk Reduction** – Implement security measures to mitigate risk.  
3. **Risk Transfer** – Shift risk to another party (e.g., insurance).  
4. **Risk Acceptance** – Acknowledge the risk if it's low.  

---

### **7. Residual Risk and the Role of the Risk Owner**
- **Residual Risk** = Risk remaining after mitigation.
- **Risk Owner's Role:**  
  - **Evaluate and accept/reject residual risks.**  
  - **Document and periodically reassess risks.**  

---

### **8. Measuring ISMS Effectiveness**
1. **Security Audits & Penetration Testing** – Identify vulnerabilities and remediation time.  
2. **SIEM-based Monitoring** – Track security KPIs (failed logins, response times).  

---

### **9. ISO/IEC 27000 and Continuous Improvement**
- **Key document:** **ISO/IEC 27005** (Risk Management in ISMS).
- **Goal:** Regular performance measurement and improvement.

