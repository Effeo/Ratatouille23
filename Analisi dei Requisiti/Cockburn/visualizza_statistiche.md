| Colonna 1 | Colonna 2 |
| --------- | --------- |
| Use case visualizza statistiche | Visualizzazione delle statistiche di vendita |
| Goal in Context | L'amministratore vuole visualizzare le statistiche di vendità del ristorante |
| Preconditions   | L'amministratore si trova nell'interfaccia di visualizzazione statistiche |
| Success End Conditions | Le statistiche vengono visualizzate con successo | 
| Failed End Conditions | Non è stato possibile visualizzare le statistiche | 
| Primary Actor | L'amministratore  | 
| Trigger | Clicca sul bottone "STATISTICHE" | 

| Description | Step | Amministratore | System |
| ----------- | ---- | -------------- | ------ |
|  | 1 | Click sul bottone "STATISTICHE" |  |
|  | 2 |  | Entri nella schermata delle statistiche |
|  | 3 | Seleziona il range desiderato |  |
|  | 9 | Clicca il bottone "CALCOLA MEDIA" |  |
|  | 10 |  | Escono le varie medie |

| Extention | Step | Amministratore | System |
| --------- | ---- | ----------- | ------ |
| Omissione di uno o più campi | 3.1 | Clicca il bottone "CALCOLA MEDIA" |  |
|  | 3.2 |  | Errore: "Non hai compilato uno o più campi!" |
| Ritorna allo step 3 |
