Library Management System (Java 17, Spring Boot 3.1.4)
----------------------------------------------------

How to run:
1. Ensure JDK 17 is installed and selected in Eclipse or set JAVA_HOME to JDK17.
2. Extract this ZIP and import into Eclipse: File → Import → Existing Maven Projects → select folder.
3. Wait for Maven to download dependencies.
4. Run the application: Right-click project → Run As → Spring Boot App (or `mvn spring-boot:run` in terminal).
5. API endpoints:
   - GET  /api/books
   - GET  /api/books/available
   - POST /api/books  (body: JSON Book)
   - GET  /api/members
   - POST /api/members (body: JSON Member)
   - POST /api/loans/loan  (body: {"bookId":1,"memberId":1})
   - POST /api/loans/return/{loanId}
   - GET  /api/loans/member/{memberId}

H2 console: http://localhost:8080/h2-console (JDBC URL: jdbc:h2:mem:librarydb, user sa, no password)
