Wesley Reynolds

SortKeysByASCValue:
This report expects another report as input. It maps the values of the input to the keys of the input. The reduction just emits what it was given. Thus, this report just swaps keys and values, sorting on what was inputed as a value.

Report 1:
./gradlew run --args="Report01 input_access_log/ out_report01_temp/"
./gradlew run --args="SortKeysByASCValue out_report01_temp/ out_report01"
This report maps the URL path in the given value to the integer 1. The report then reduces to count the number of 1's associated with the given key (URL).
After running the SortKeysByASCValue report with Report 1 as the input, the result is "Requests count for each URL path, sorted by request count (ascending)".

Report 2:
./gradlew run --args="Report02 input_access_log/ out_report02/"
The report maps the HTTP response code in the given value to the integer 1. The report then reduces to count the number of 1's associated with the given key (HTTP response code).

Report 3:
./gradlew run --args="Report03 input_access_log/ out_report03/"
If the IPv4 address in the given value matches the hard coded IPv4 address, then the report maps the IPv4 address to the bytes sent. The report then reduces to sum the values associated with the given key (IPv4 address).

Report 4:
./gradlew run --args="Report04 input_access_log/ out_report04_temp/"
./gradlew run --args="SortKeysByASCValue out_report04_temp/ out_report04/"
If the URL in the given value matches the hard coded URL, then the report maps the IPv4 address to the integer 1. The report then reduces to sum the values associated with the given key (IPv4 address).
After running the SortKeysByASCValue report with Report 4 as the input, the result is "Based on a given URL (hard coded), compute a request count for each client (hostname or IPv4) who accessed that URL, sorted by request count (ascending)".

Report 5:
./gradlew run --args="Report05 input_access_log/ out_report05/"
This report maps the (year, month) tuple to the integer 1. The report then reduces to sum the values associated with the given key ((year, month) tuple), and emits (month, year, requestCount).

Report 6:
./gradlew run --args="Report06 input_access_log/ out_report06_temp/"
./gradlew run --args="SortKeysByASCValue out_report06_temp/ out_report06/"
This report maps the (year, month, day) tuple to the integer 1. The report then reduces to sum the values associated with the given key ((year, month, day) tuple), and emits (day, month, year, requestCount).
After running the SortKeysByASCValue report with Report 6 as the input, the result is "For each calendar day that appears in the file, return total bytes sent. Sort by total bytes in ascending order".
