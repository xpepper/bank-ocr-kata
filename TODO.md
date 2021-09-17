### Findings / Insights
* each digit is a 3x3 character map


```
    _  _     _  _  _  _  _ 
  | _| _||_||_ |_   ||_||_|
  ||_  _|  | _||_|  ||_| _|

```

##  todo
* logica che estrae le entries e le passa ad un "account number parser" ?
* ha senso introdurre un oggetto `AccountNumber`
* slices: an account number is made of a single "digit" (4 lines, the last one empty), like

```
    
  |
  |

```

* AT: crearmi un file di test come esempio
* cosa faccio se ho una rappresentazione "monca" dell'account number, dove mancano delle righe?
