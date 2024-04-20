# candidate_poi



1. **Upload Excel File**
   This endpoint allows users to upload an Excel file containing candidate data.

**Request**
URL: POST http://localhost:9191/uploadExcellData
Request Body: Form-data
file: Excel file to be uploaded
**Response**
Success: HTTP 200 OK

2. **Get All Candidates (Sorted by Name)**
   This endpoint retrieves all candidates sorted alphabetically by their name.

**Request**
URL: GET http://localhost:9191/candidates
**Response**
Success: HTTP 200 OK
JSON Array of candidate objects, sorted by name
Error: HTTP 4xx or 5xx status codes with error details


3. **Get All Candidates (Sorted by Name Using Native Query)**
   This endpoint retrieves all candidates sorted by name using a native SQL query.

**Request**
URL: GET http://localhost:9191/candidates_n
**Response**
Success: HTTP 200 OK
JSON Array of candidate objects, sorted by name
Error: HTTP 4xx or 5xx status codes with error details

