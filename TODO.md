#  TODO list

* [R] spostare la logica di line reader nel parser invece che esporla nella class BankOCR?
* [R] ha senso introdurre un oggetto `AccountNumber`
* [R] rendere LCDNumber un set di valori invece che una mappa (e.g. sealed class)
* AT: crearmi un file di test come esempio
* cosa faccio se ho una rappresentazione "monca" dell'account number, dove mancano delle righe?

## Findings / Insights
* each digit is a 3x3 character map

```
    _  _     _  _  _  _  _ 
  | _| _||_||_ |_   ||_||_|
  ||_  _|  | _||_|  ||_| _|

```

