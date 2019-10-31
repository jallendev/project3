# project3

## Problem Solving Approach

For this project, I worked mostly from the output sample specified in the project requirements. To accomplish the project requirements I built 6 classes:

 - <code>DateTimeOne</code>: This class fulfills the requirements of section 1, printing different dates and times.
 - <code>DateTimeTwo</code>: This class takes a more macro approach and makes comaprisons between years and days of months.
 - <code>MesoAsciiCal</code>: This class simply calculates an ascii average of a station based on the project guidelines.
 - <code>MesoEquivalent</code>: This class finds stations with an average equal to the current station and makes a list.
 - <code>MesoLexicographical</code>: This class sorts the list from MesoEquivalent lexicographically.
 - <code>DateSortingUsingAlgorithm</code>: This class sorts dates using a bubble sort algorithm I implemented myself.

These classes are used as applicable by the <code>Main</code> class in order to output all data in the format required by the project guidelines.

## Description of Methods and Variables

### <code>DateTimeOne</code>

### Variables

- <code>ZonedDateTime</code> objects: 4 objects holding the <code>ZonedDateTime</code> values now, GMT, BST, and CST respectively.
- <code>DateTimeFormatter</code> objects: 4 objects holding various output formats for the project guidelines.
- timeZonesMap: A <code>HashMap<String, String></code> containing the 5 time zones required by the project guidelines.

### Methods

#### <code>int getValueOfSecond()</code>

Uses the base <code>ZonedDateTime</code> to acquire the current second on the server clock. Prints a <code>String</code> in the format <code>The value of Second now: " + now.getSecond()</code>

#### <code>void dateTimeNow()</code>

Gets the current time from the <code>now</code> object. <code>now</code> is reinstantiated in case the server just slept for 5 seconds. Prints an output <code>String</code> in the format <code>Current Date/Time: " + nowDateFormatter.format(now)</code>

#### <code>void sleepForFiveSec()</code>

Uses the default Java system interface api to sleep the server for 5 seconds.

#### <code>void dateTimeOfOtherCity()</code>

Prints <code>ZonedDateTime</code> objects using the <code>DateTimeFormatter</code> object otherCityFormatter.

#### <code>void dateTimeDifferentZone()</code>

Same as <code>void dateTimeOfOtherCity()</code>, but stores the dates in a <code>HashMap</code> and prints in a slightly different format.

#### <code>void timeZoneHashMap()</code>

Add some arbitrary time zones, print, sort, format, and print again. See method comments for more details.

### <code>DateTimeTwo</code>

### Variables

- datesFile: A <code>HashMap<LocalDate, Integer></code> to hold the values of dates read from Dates.txt.
- originalOrderFile: A <code>LinkedHashMap<LocalDate, Integer></code> to hold the values of dates read from Dates.txt in sorted order.
- hashMapFormatter: Another <code>DateTimeFormatter</code> to make sure output is the way the pdf wants it.

### Methods

#### <code>public void daysOfCurrentMonth()</code>

Figures out which days are TENTH and EIGHTEENTH in the current month

#### <code>public void daysOfAnyMonth(int month, int year)</code>

Similar to the method above, but now the user gets to choose the month and year. The QA engineer will choose something like <code>S*&#$*&%&@</code> because thay like breaking the hard work of programmers.

#### <code>public void compareYear()</code>

This method figures out whether the year is a leap year, and what the date difference is.

#### <code>public void dateHashMap()</code>

Prints the HashMap before sorting

#### <code>public void dateHashMapSorted()</code>

Sorts the HashMap and displays in the same manner

#### <code>private void readDatesFile()</code>

It does what it says

### <code>MesoAsciiCal</code>

### Variables

- stID: a <code>String</code> that holds <code>this</code> station ID.

### Methods

#### <code>public MesoAsciiCal(MesoStation mesoStation)</code>

Extracts station ID from given <code>MesoStation</code> and assigns it to the class variable.

#### <code>int calAverage()</code>

Calculates an Ascii average based on a first average and second average. The first average is calculated based on <code>this</code> stationID. The second average is calculated based on a fixed <code>String</code>: "NRMN". These are then averaged to form the return value.

### <code>MesoEquivalent</code>

### Variables

- <code>private final int INITIAL_STATION_SIZE</code>: The beginning capacity of the stations array.
- <code>private final String FILENAME</code>: The filepath for the Mesonet.txt file. May need to be changed depending on relative working directory.
- <code>private final String STATION_COLUMN_HEADER</code>: The fileReader looks for this column header to begin reading in station IDs.
- <code>private String[] stations</code>: An array to hold station IDs read from the Mesonet.txt file. Initialized with a value of 10.
- <code>private String stID</code>: The stID <code>String</code> holds the code for the station given by the Driver class to use for execution.

### Methods

#### <code>public MesoEquivalent(String stId)</code>

Intializes variables and begans the process of reading the Mesonet.txt file.

#### <code>public HashMap<String, Integer> calAsciiEqual()</code>
 
Find the stations with an ascii Average equal to the current station and return them.

#### <code>private void readFile()</code>

Reads the Mesonet.txt file and inputs the results into the stations array. See code comments for detailed implementation explanation. Basic summary:

 - Uses try-catch block to mitigate IOExceptions thrown.
 - Reads file utilizing BufferedReader object.
 - Uses Scanner to acquire the first token from each line.
 - Begins reading upon finding the STID header.

#### <code>private String[] expandStations()</code>

Expands the stations array with 10 extra slots. Returns the expanded array with values copied from the stations array.

### <code>MesoLexicographical</code>

### Variables

- asciiVal: a <code>HashMap<String, Integer></code> that holds the given values to sort lexically.
 
### Methods

#### <code>public MesoLexicographical(HashMap<String, Integer> asciiVal)</code>

Assigns stations to asciiVal and begans <code>sortedMap()</code>

#### <code>Map<String, Integer> sortedMap(HashMap<String, Integer> unsorted)</code>

Takes and unsorted <code>HashMap</code> and returns a sorted <code>LinkedHashMap</code>.

### <code>DateSortingUsingAlgorithm</code>

### Variables

- <code>private HashMap<LocalDate, Integer> sortingDates</code>: Holds the original dates from the SortingDates.txt file.
- <code>private LinkedHashMap<LocalDate, Integer> ascendingOrder</code>: Holds the dates sorted in ascending order.
- <code>private LinkedHashMap<LocalDate, Integer> descendingOrder</code>: Holds the dates sorted in descending order.
 
### Methods

#### <code>public DateSortingUsingAlgorithm()</code>

Sorts the data sets using helper methods and stores the data in <code>HashMaps</code> above.

#### <code>public void dateHashMapSortedDescending()</code>

Prints descendingOrder.

#### <code>public void dateHashMapSorted()</code>

Prints ascendingOrder.

#### <code>private void readSortingDatesFile()</code>

Reads the file while trimming the dates to ensure no whitespace is taken.

#### <code>private ArrayList<LocalDate> reverse(ArrayList<LocalDate> dates)</code>

Reverses the given <code>ArrayList</code> without using <code>Collections</code>.

#### <code>private ArrayList<LocalDate> bubbleSort(ArrayList<LocalDate> dates)</code>

A basic implementation of the standard bubble sort algorithm. Bubble sort has a worst case and average complexity of <code>O(n<sup>2</sup>)</code>.

## Code Analysis

For this implementation, I focused on reusability. Given that many of our project descriptions have been similar, I wanted to make sure code could be reused in the future for different purposes to save unneccessary time and work. Hence, I used several helper methods in a lot of the classes to compartmentalize code features. As far as the question at the end of Main: my times between the two date sorting methods should be roughly similar each time it is run, as they both simply output the dates and do not sort them.
