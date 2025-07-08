# 🎵 Songfy

Songfy is a Java-based music management application that integrates with the [Deezer API](https://developers.deezer.com/api) to allow users to search, register, and list songs and artists.

It uses **Spring Data JPA** for persistence, **Jackson** for JSON mapping, and **DTOs** to separate external data from internal models.

---

## 📦 Features

- 🔍 **Search songs** from the Deezer API using keywords
- 💾 **Register songs and artists** into a database
- 📃 **List all saved songs**
- 👤 **Filter songs by artist**
- 🎼 **Search songs containing a name**
- ⏱️ **List songs between duration range**
- 📊 **Count how many songs each artist has**
- 📈 **Sort songs by popularity (rank)**

---

## ⚙️ Technologies Used

- Java 17+
- Spring Boot
- Spring Data JPA (with Hibernate)
- Jackson (for JSON to Object mapping)
- H2 / PostgreSQL (configurable)
- Deezer API
- Maven

---

## 🧠 How It Works

When registering a song:

1. The user searches for a song name.
2. Songfy calls the Deezer API and retrieves a list of possible matches.
3. The user selects one from the list.
4. The song is mapped using custom DTOs (`SongDto`, `ArtistDto`) and converted into entities (`Song`, `Artist`).
5. Before saving, Songfy checks:
   - If the artist already exists, it reuses the artist entity.
   - If the song already exists, it avoids duplication.
6. The song and artist are saved using Spring Data JPA.

---

## ▶️ How to Run

1. Clone the repository:
   ```bash
   git clone https://github.com/seu-usuario/songfy.git
2. Build the project with Maven:
   ```bash
   mvn clean install
 4. Run the application:
    ```bash
     mvn spring-boot:run
6. Interact with the CLI via terminal menu.
    
    
