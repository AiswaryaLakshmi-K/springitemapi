# Item Management REST API


## Description:-

       This is a simple Spring Boot REST API that manages items using an in-memory ArrayList (no database).

## API Endpoints

### 1. Add Item (POST)
Adds a new item to the list stored in memory.
(/items):-

body:
{
"id": 1,
"name": "Tshirt",
"description": "Cotton cloth"
}
Simillarly, i have added 5 items.

### 2. Get Item by ID (GET)
Fetches a single item based on the given ID.
(/items/{id}):-

Example:
/items/1

## Important Details
- Data is stored in memory using ArrayList.
- Data will be lost when the application restarts.
- Item name cannot be empty.

## How to Run
1. Run SampleApplication.java
2. The application will start at: http://localhost:8080
2. Open Postman and test APIs at: http://localhost:8080
