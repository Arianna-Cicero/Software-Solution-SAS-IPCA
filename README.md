# 🏬 IPCA Social Store — Applied Project (LESI-PL)

## 📘 Project Overview
The **IPCA Social Store** project was developed as part of the **Applied Project (LESI-PL)** course at the Polytechnic Institute of Cávado and Ave (IPCA).  
It aims to digitalize and optimize the management of the **Social Store**, a solidarity initiative that collects, organizes, and distributes essential goods — such as food, personal hygiene, and cleaning products — to students facing economic and social vulnerability.

Currently, the store’s management is performed manually through spreadsheets or paper records, which limits efficiency, data accuracy, and traceability.  
To address this, the project proposes an **integrated digital system** composed of:

- 📱 A **mobile application** for internal use by **SAS-IPCA staff**, enabling inventory, donations, and delivery management.  
- 💻 A **public website**, providing the academic community with real-time stock information, donation options, and campaign updates.

The goal is to modernize the Social Store’s operations by providing a transparent, efficient, and scalable software solution that improves both **management efficiency** and **social impact**.

---

## 🚀 Objectives
- **Digitalize and automate** the Social Store’s operations, reducing manual work.  
- **Provide full traceability** of donations and distributions.  
- **Optimize inventory management** with automatic stock updates.  
- **Enable transparency and engagement** through a public website.  
- **Prioritize near-expiry products** to minimize waste.  
- **Improve communication** between staff, donors, and beneficiaries.  

---

## 🧩 System Architecture
The system is divided into two main modules connected to a centralized cloud database:

### 1. Mobile Application (Internal Use)
- Developed with **Kotlin**
- Built for Android (and potentially iOS)
- Features:
  - Beneficiary management  
  - Stock registration and categorization  
  - Scheduling of delivery appointments  
  - Product expiration alerts and reports  
  - Automatic stock updates after each delivery  

### 2. Public Website
- Built with **React**
- Real-time integration with the backend
- Features:
  - Visual dashboard of stock by category (e.g., food, hygiene, cleaning)
  - Detailed product availability view
  - Donation information and campaign announcements  

### 3. Backend and Database
- Backend: **Ktor** (Kotlin server framework)  
- Database: **PostgreSQL**  
- ORM: **Exposed** (Kotlin SQL framework)  
- Authentication: Firebase (optional)
- REST API for communication between mobile app, website, and database

---

## 🛠️ Technologies Used
| Category | Technology |
|-----------|-------------|
| Programming Language | Kotlin |
| Backend Framework | Ktor |
| Database | PostgreSQL |
| ORM | Exposed |
| Frontend | React |
| Version Control | Git & GitHub |
| Project Management | Jira |
| Collaboration Tools | Microsoft Teams, WhatsApp |
| Hosting | Firebase / Vercel (proposed) |

---

## 🧠 Team Structure
| Role | Member | Responsibilities |
|------|---------|------------------|
| **Project Manager** | Guilherme Souza | Task organization, Jira management |
| **Software Architect** | Arianna Cicero | System architecture, requirement analysis |
| **Backend Developer** | Arianna Cicero, Guilherme Souza, Kizzy Silveira | API design, database integration |
| **Frontend (Mobile & Web)** | Arianna Cicero, Guilherme Souza, Kizzy Silveira | UI/UX and client-side development |
| **Database Manager** | Arianna Cicero | Database design and management |
| **Tester / QA** | Kizzy Silveira | Testing, validation, and usability reports |

---

## 📅 Project Timeline
| Phase | Main Deliverables |
|-------|---------|------------------|
| **Phase 1 — Planning** | Context definition, business objectives, feasibility study |
| **Phase 2 — Analysis** | Use cases, ER diagrams, system requirements |
| **Phase 3 — Development** | Mockups, initial implementation, prototype testing |

---

## 🔒 Functional & Non-Functional Requirements

### Functional
- RF001: User authentication and role-based access  
- RF011: Beneficiary management (CRUD)  
- RF012: Inventory management with product categorization  
- RF014: Support scheduling and delivery control  
- RF018: Expiration alerts and report generation  
- RF021: Real-time stock visualization on the website  

### Non-Functional
- RNF001: Response time under 3 seconds  
- RNF012: Secure authentication and encrypted passwords  
- RNF021: Intuitive interface for users of all technical levels  
- RNF031: 99% uptime during business hours  
- RNF041: Android 10+ compatibility  

---

## 🧩 System Highlights
- **Modular and scalable architecture**
- **Real-time data synchronization**
- **Role-based user access and secure authentication**
- **Offline-ready mobile application (optional)**
- **Full transparency and traceability of donations**

---

## 💡 Expected Impact
- Reduce administrative workload by over **50%**
- Increase **transparency** and **trust** in social aid distribution
- Provide **accurate stock data** and **automatic reporting**
- Encourage **community engagement** and participation

---

## 👩‍💻 Development Team
- **Arianna Cicero** 
- **Guilherme Souza** 
- **Kizzy Silveira** 

---

## 📄 License
This project is an **academic work** developed for the **Polytechnic Institute of Cávado and Ave (IPCA)**.  
It is intended for **educational and non-commercial use**.

---

> “Technology is best when it brings people together — and solidarity is its most powerful purpose.” 💙
