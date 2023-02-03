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
|  | 1 |  | Mostra il menù e le opzioni di chiudere il conto o di scaricare in pdf |
|  | 2 | Sceglie di chiudere il conto | |
|  | 3 | | Chiude il conto |
|  | 4 | | Aggiorna il database |
| Subvariation | Step | User action | System |
| ------------ | ---- | ----------- | ------ |
|  | 2.1 | Sceglie di scaricare il pdf del conto per quel tavolo | |
|  | 2.2 | | Scarica il PDF |

