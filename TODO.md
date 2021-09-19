#  TODO list

* [R] Should a `Report` object be used instead of a plain list of `String`s?
* [R] `ReportWriter#format` has to know that has to FIRST ask for illegible numbers and ONLY THEN check for validity (a form of "temporal coupling")...
  - is there a better way of doing this?

## Findings / Insights
* each digit is a 3x3 character map

```
    _  _     _  _  _  _  _ 
  | _| _||_||_ |_   ||_||_|
  ||_  _|  | _||_|  ||_| _|

```

