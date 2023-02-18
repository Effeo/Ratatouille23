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
|  | 2 |  | Mostra schermata delle statistiche |
|  | 3 | Seleziona il range desiderato |  |
|  | 4 | Clicca il bottone "CALCOLA" |  |
|  | 5 |  | Mostra le medie e l'incasso complessivo |

| Extention | Step | Amministratore | System |
| --------- | ---- | ----------- | ------ |
| Omissione di uno o più campi | 4.1 | Clicca il bottone "CALCOLA" |  |
|  | 5.1 |  | Errore: "Non hai compilato uno o più campi!" |
| Ritorna allo step 3 |

| Extention | Step | Amministratore | System |
| --------- | ---- | ----------- | ------ |
| Il campo dell'inizio del range è maggiore rispetto a quello finale | 4.2 | Clicca il bottone "CALCOLA" |  |
|  | 5.2 |  | Errore: "Il range è sbagliato!" |
| Ritorna allo step 3 |

| Extention | Step | Amministratore | System |
| --------- | ---- | ----------- | ------ |
| Preme il bottone "LogOut" | 3.3 | Preme il bottone "LogOut" |  |
|  | 4.3 |  | Torna nella schermata di LogIn |

| Extention | Step | Amministratore | System |
| --------- | ---- | ----------- | ------ |
| Preme il bottone "Aggiungi piatto" | 3.4 | Preme il bottone "Aggiungi piatto" |  |
|  | 4.4 |  | Va nella schermata "Aggiungi piatto" |

| Extention | Step | Amministratore | System |
| --------- | ---- | ----------- | ------ |
| Preme il bottone "Modifica elimina cibo" | 3.5 | Preme il bottone "Modifica elimina cibo" |  |
|  | 4.5 |  | Va nella schermata "ModiFica elimina cibo" |

| Extention | Step | Amministratore | System |
| --------- | ---- | ----------- | ------ |
| Preme il bottone "Messaggi" | 3.6 | Preme il bottone "Messaggi" |  |
|  | 4.6 |  | Va nella schermata "Messaggi" |

| Extention | Step | Amministratore | System |
| --------- | ---- | ----------- | ------ |
| Preme il bottone "Crea utente" | 3.7 | Preme il bottone "Crea utente" |  |
|  | 4.7 |  | Va nella schermata "Crea utente" |
