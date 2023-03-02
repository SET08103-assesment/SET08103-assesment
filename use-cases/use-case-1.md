# USE CASE: 1 Produce a country report on the country's population.

## CHARACTERISTIC INFORMATION

### Goal in Context

As a statistician, I want to produce a report that shows population data for various countries so I can present this data to the stakeholders.

### Scope

Company.

### Level

Primary task.

### Preconditions

The database contains countries population data.

### Success End Condition

A report is available for statistician to provide to stakeholders.

### Failed End Condition

No report is produced.

### Primary Actor

Statistician.

### Trigger

A request for population information is sent to statistician.

## MAIN SUCCESS SCENARIO

1. The stakeholders have requested comprehensive reports on population data for multiple countries.
2. The statistician accesses the required data using the provided SQL database as a starting point.
3. The statistician collects and captures population information for the specified countries, including data on demographics, trends, and projections.
4. The statistician uses the system to extract population data and other relevant information for the required countries.
5. The statistician generates a report containing the requested information and shares it with stakeholders for review and analysis.

## EXTENSIONS

3. **Data is missing**:
  1. The statistician identifies that some data required for the report is missing from the database.
  2. The statistician informs stakeholders of the missing data and proposes potential solutions, such as obtaining the missing data from other sources or modifying the report to exclude the missing data.
  3. Stakeholders evaluate the proposed solutions and decide on the best course of action.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: Release 1.0