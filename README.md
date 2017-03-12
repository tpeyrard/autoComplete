# autoComplete
Kata auto-complete to find up to 4 elements in a dictionary that starts with the given string.
Quickly test the program using the provided jar.
## Build
`mvn clean install`
## Run
`java -jar target/autocomplete-1.0-SNAPSHOT.jar <pattern> [path_to_dictionary]`
## Performance
First I tried to make the easier and nicer solution I could do. That's why I used Streams from Java 8.

Tested with the dictionary insane.txt (_663k words_) included in this repo. Without any optimization or warmup I get quite good results:
```
$ time java -jar autocomplete-1.0-SNAPSHOT.jar viz insane.txt
[viz, vizagapatam, vizagapatam's, vizament]

real    0m0.673s
user    0m0.000s
sys     0m0.015s
```
