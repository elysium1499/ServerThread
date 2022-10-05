Consideriamo un sistema di gestione di eventi (es concerti, conferenze, ecc).
Si vuole definire una classe Java per garantire l’accesso thread-safe ad una classe Java con metodi per gestire eventi e posti disponibili.

In particolare utilizzando i monitor di sincronizzazione di Java, la classe EVENTI deve fornire:
• un metodo “Crea(Nome,Posti)” per aggiungere un nuovo evento e i relativi posti disponibili solo se non esiste già un evento con lo stesso nome;
• un metodo “Aggiungi(Nome,Posti)” per aggiungere nuovi posti ad un determinato evento;
• un metodo “Prenota(Nome,Posti)” per prenotare posti per un dato evento, il metodo deve essere bloccante se non ci sono abbastanza posti;
• un metodo “ListaEventi” per visualizzare su console eventi e posti ancora disponibili;
• un metodo “Chiudi(Nome)” che cancella l’evento e sblocca tutti i clienti in attesa di posti;

Assumiamo che ogni richiesta relativa ad eventi sia eseguita da thread (es. un handler di gestione di richieste che arrivano ad un server di qualche tipo) e che diversi utenti possano richiedere di inserire eventi o prenotare posti anche simultaneamente.

Il server deve avere architettura multithreaded basata su ServerSocket su TCP.

E' stato associato al programma una GUI minimale per visualizzare la lista degli eventi e inviare le richieste di prenotazione tramite un thread di tipo UTENTE.
Lo stesso per un thread ADMIN per eseguire la sequenza crea, aggiungi, chiudi, prenota.