# KisanHub
Build a complete Android Native mobile application (Java or Kotlin) named **KisanHub**.  
The app helps farmers manage farms, incomes, and expenses **offline on their device**.  
The app must be professional, farmer-friendly, mobile-first, and follow modern Material Design 3 UI.  

---

### Technical Requirements:
- Language: Java (preferred) or Kotlin  
- Minimum SDK: 24  
- Target SDK: latest stable  
- Architecture: MVVM or Repository pattern  
- Database: SQLite (Room ORM recommended)  
- Offline-first, no server/cloud  
- Use Material Components (Material3)  
- RecyclerView for lists  
- ConstraintLayout for layouts  
- Theming with farmer-friendly colors (green = profit, red = loss, brown = neutral)  
- App name: **KisanHub**  
- Package: `com.kisanhub`  

---

### Core Features:

#### 1. Authentication (Signup/Login)
- First launch shows Signup/Login screen.  
- Fields: Username, Password (MaterialTextInputLayout).  
- Local SQLite Users table for storing credentials.  
- Simple validation & error messages.  

#### 2. Profile Page
- Displays farmer’s name, profile image, and greeting.  
- Shows combined statistics:  
  - Total number of farms  
  - Total income, expenses, and net profit/loss  
- Button to go to farms list.  

#### 3. Home – Farms List
- Toolbar with title "My Farms".  
- FloatingActionButton (+) to add new farm.  
- RecyclerView list of farms:  
  - Farm name  
  - Profit/Loss (green/red)  
- Long press → option to edit/delete farm.  

#### 4. Farm Details
- Show farm name and financial summary (income, expenses, profit/loss).  
- FAB to add a new transaction.  
- RecyclerView for all transactions:  
  - Icon (income = trending_up, expense = trending_down)  
  - Description  
  - Amount  
  - Date/time  
- Filters: Show only income / only expenses / all.  

#### 5. Add Transaction
- Form with:  
  - Amount  
  - Description  
  - Category (Seeds, Labour, Fertilizer, Transport, Irrigation, Others)  
  - Type: Income / Expense (Radio buttons)  
  - Date picker (default: today)  
- Save to SQLite Transactions table.  

---

### Additional Features:

#### 📊 Dashboard & Reports
- Graphs/Charts (Bar chart or Pie chart) for farm expenses vs incomes.  
- Show profit/loss trends by month or farm.  

#### 🔔 Reminders & Notifications
- Allow farmers to set reminders for payments or harvest dates.  
- Use Android local notifications.  

#### 🔍 Search & Filter
- Search transactions by keyword.  
- Filter by category (e.g., only Fertilizer expenses).  

#### 📂 Data Backup/Restore (Local)
- Export database to `.db` file (saved in Downloads).  
- Import database to restore.  

#### 🌐 Language Support
- Multi-language support (English, Hindi, Marathi, etc.).  
- Store strings in `strings.xml` for easy localization.  

#### 🎨 UI Enhancements
- Dark mode support.  
- Farmer-friendly icons (tractor, crops, water drop, money).  
- Rounded MaterialCardViews for all list items.  

---

### Database Design (SQLite – Room)

1. **Users Table**  
   - id (PK)  
   - username  
   - password  

2. **Farms Table**  
   - id (PK)  
   - userId (FK → Users.id)  
   - name  

3. **Transactions Table**  
   - id (PK)  
   - farmId (FK → Farms.id)  
   - amount  
   - description  
   - category (Seeds, Labour, Fertilizer, Irrigation, Transport, Others, Income)  
   - type (income/expense)  
   - date (timestamp)  

4. **Reminders Table** (optional)  
   - id (PK)  
   - farmId  
   - title  
   - dueDate  
   - isDone (boolean)  

---

### Deliverables:
- Full Android Studio project with:  
  - `app/src/main/java/com/kisanhub/` containing all Activities, ViewModels, Repositories, DB classes  
  - `res/layout/` XMLs (Auth, Profile, Farms List, Farm Details, Add Transaction, Dashboard)  
  - `res/values/colors.xml`, `themes.xml`, `strings.xml` with consistent theme  
  - `AndroidManifest.xml` with exported activities set correctly  
  - Gradle setup with `namespace "com.kisanhub"`  

---

### Extra Polishing:
- Snackbar/Toast for actions (farm added, transaction saved, login success).  
- Profit values shown in **green bold**, losses in **red bold**.  
- Modern Material toolbar with navigation.  
- Use icons from `material-icons-extended`.  
- Smooth navigation transitions between activities.  
