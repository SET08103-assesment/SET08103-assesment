# USE CASE: 3 Produce a capital city report on the capital's population.

## CHARACTERISTIC INFORMATION

### Goal in Context

As a statistician, I want to produce a report that shows population data for various capitals so I can analyse the statistics.

### Scope

Company.

### Level

Primary task.

### Preconditions

The database contains capitals population data.

### Success End Condition

A report is available for statistician to analyse the statistics.

### Failed End Condition

No report is produced.

### Primary Actor

Statistician.

### Trigger

A request for population information analyse is sent to statistician.

## MAIN SUCCESS SCENARIO

1. The data analytics team have requested comprehensive reports and analyse on population data for multiple capitals.
2. The statistician accesses the required data using the provided SQL database as a starting point.
3. The statistician collects and captures population information for the specified capitals, including data on demographics, trends, and projections.
4. The statistician uses the system to extract population data and other relevant information for the required capitals.
5. The statistician generates a report for analyse containing the requested information.

## EXTENSIONS

3. **Data is missing**:
 1. The statistician identifies that some data required for the report is missing from the database.
 2. The statistician informs the data analytics team of the missing data and proposes potential solutions, such as obtaining the missing data from other sources or modifying the report to exclude the missing data.
 3. The data analytics team evaluate the proposed solutions and decide on the best course of action.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: Release 1.0