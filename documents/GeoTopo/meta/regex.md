Einige RegEx-Außdrücke haben mir geholfen, die Qualität des Dokuments zu erhöhen:

```bash
grep -ni -E '\\begin{(.*?)}(\\xindex\{.*?\})+[^%]*$' *
```