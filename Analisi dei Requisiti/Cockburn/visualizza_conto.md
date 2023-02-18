| Colonna 1 | Colonna 2 |
| --------- | --------- |
| Use case visualizza conto | Visualizzazione e chiusura del conto  di un tavolo in PDF |
| Goal in Context           | Un supervisore vuole visualizzare il conto di un tavolo oppure vuole chiudere un conto |
| Preconditions             | Il supervisore ha selezionato dal menù la voce "TAVOLI" |
| Success End Conditions    | La visualizzazione del conto è avvenuta con successo o chiude il conto correttamente | 
| Failed End Conditions     | E' avvenuto un errore durante la visualizzazione del conto o durante la chiusura del conto | 
| Primary Actor             | Un supervisore  | 
| Trigger                   | Click sul tavolo di cui si vuole vedere il conto | 

| Description | Step | Supervisore | System |
| ----------- | ---- | ----------- | ------ |
|  | 1 | Preme il bottone "Conti" |  |
|  | 2 |  | Mostra i tavoli e il conto del primo tavolo |
|  | 3 | Clicca sul tavolo che vuole visualizzare |  |
|  | 4 |  | Mostra il conto del tavolo selezionato |
|  | 5 | Sceglie di chiudere il conto | |
|  | 6 | | Chiude il conto |
|  | 7 | | Aggiorna il database |
|  | 8 | | Scarica il PDF |

| Subvariation | Step | Supervisore | System |
| ------------ | ---- | ----------- | ------ |
| Vuole scaricare il pdf | 5.1 | Sceglie di scaricare il pdf del conto per quel tavolo | |
|  | 6.1 | | Scarica il PDF |

| Extention | Step | Amministratore | System |
| --------- | ---- | ----------- | ------ |
| Preme il bottone "LogOut" | 3.2 | Preme il bottone "LogOut" |  |
|  | 4.2 |  | Torna nella schermata di LogIn |

| Extention | Step | Amministratore | System |
| --------- | ---- | ----------- | ------ |
| Preme il bottone "Aggiungi piatto" | 3.3 | Preme il bottone "Aggiungi piatto" |  |
|  | 4.3 |  | Va nella schermata "Aggiungi piatto" |

| Extention | Step | Amministratore | System |
| --------- | ---- | ----------- | ------ |
| Preme il bottone "Modifica elimina cibo" | 3.4 | Preme il bottone "Modifica elimina cibo" |  |
|  | 4.4 |  | Va nella schermata "ModiFica elimina cibo" |

| Extention | Step | Amministratore | System |
| --------- | ---- | ----------- | ------ |
| Preme il bottone "Messaggi" | 3.5 | Preme il bottone "Messaggi" |  |
|  | 4.5 |  | Va nella schermata "Messaggi" |
