# USE CASE: 2 Produce a city report on the city's population.

## CHARACTERISTIC INFORMATION

### Goal in Context

As a statistician, I want to produce a report that shows population data for various cities so I can present this data to the client.

### Scope

Company.

### Level

Primary task.

### Preconditions

The database contains cities population data.

### Success End Condition

A report is available for statistician to provide to the client.

### Failed End Condition

No report is produced.

### Primary Actor

Statistician.

### Trigger

A request for population information is sent to statistician.

## MAIN SUCCESS SCENARIO

1. The data analytics team have requested comprehensive reports for the client on population data for multiple cities.
2. The statistician accesses the required data using the provided SQL database as a starting point.
3. The statistician collects and captures population information for the specified cities, including data on demographics, trends, and projections.
4. The statistician uses the system to extract population data and other relevant information for the required cities.
5. The statistician generates a report for the client containing the requested information.

## EXTENSIONS

3. **Data is missing**:
 1. The statistician identifies that some data required for the report is missing from the database.
 2. The statistician informs the data analytics team of the missing data and proposes potential solutions, such as obtaining the missing data from other sources or modifying the report to exclude the missing data.
 3. The data analytics team evaluate the proposed solutions and decide on the best course of action.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: Release 1.0