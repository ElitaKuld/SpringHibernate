package com.example.springhibernate.KompisRESTAPI;

import com.example.springhibernate.BookRESTAPI.Book;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class KompisController {

    private final KompisRepository repo;

    public KompisController(KompisRepository repo) {
        this.repo = repo;
    }

    //curl http://localhost:8080/kompisar/add -H "Content-Type:application/json" -d "{\"namn\":\"Robin\", \"adress\": \"Sherwood Forest 10\", \"telefonnummer\": \"762654897\"}" -v
    @PostMapping("kompisar/add")
    public List<Kompis> addKompis(@RequestBody Kompis kompis){
        repo.save(kompis);
        return repo.findAll();
    }

    @RequestMapping("kompisar")
    public List<Kompis> getAllKompisar(){
        return repo.findAll();
    }

    @RequestMapping("kompisar/{id}/delete")
    public List<Kompis> deleteKompisById(@PathVariable long id){
        repo.deleteById(id);
        return repo.findAll();
    }
}

/*
Uppgift 1a – Skapa projekt med stöd för databas
Skapa ett nytt IntelliJ-projekt.
• Välj Spring Initializr
• Se till att Gradle och Java är valt
• Välj Developer Tools -> Spring Boot DevTools
• Välj Developer Tools -> Lombok
• Välj “Web” -> “Spring Web”
• Välj “SQL” -> “Spring Data JPA”
• Välj “SQL” -> “MySQL Driver”
• Lägg projektet på ett bra ställe och döp det till nåt fint
*/

/*
Uppgift 1b – Skapa och konfigurera databas
Fortsätt på ovanstående uppgift:
• Skapa en ny databas (du behöver inte skapa några tabeller)
• Skapa en användare till databasen
• Skriv in databasens url, ditt nya användarnamn och lösenord i application.properties-filen i
IntelliJ.
*/

/*
Uppgift 1c – Skapa en Entitet
• I IntelliJ, skapa 3 kod-mappar så att allt är snyggt och prydligt
• Models
• Controllers
• Repos

• Skapa sedan en POJO Kompis.java
• Kompis ska minst ha:
• Id
• Namn
• Adress
• Mobilnummer
• Låt Kompis bli en Entity och sätt ut alla annoteringar som behövs.
• Skapa getters och setters, eller använd Lombok.
*/

/*
Uppgift 1d – Skapa repository
• Skapa ett repository till din Kompis-klass.
*/

/*
Uppgift 1e – Skapa en Controller-klass + addKompis-metod
• Skapa en klass KompisController
• Skriv en metod för att spara ner Kompisar till databasen
• Tänk på att lägga till alla annoteringar som behövs
• Tänk även på att routingen ska vara rimlig
*/

/*
Uppgift 1f – Skapa en findAllKompis-metod
• Skriv även en metod för att läsa ut alla kompisar ur databasen
• Kolla att det funkar genom att anropa metoden från en browser.
*/

/*
Uppgift 1g – Skapa en deleteKompis-metod
• Skapa en metod för att radera en kompis från databasen
• Ge en lämplig inparameter för att kunna genomföra raderingen
• Kolla att det funkar genom att anropa metoden från en browser
 */