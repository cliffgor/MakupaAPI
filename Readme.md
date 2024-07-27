# Getting Started

### Makupa API

This API incorporates SpringBoot Java to showcase my java skills


### Tech Stack

* Java
* Spring Boot
* MongoDB
* Send Grid
* JWT

# Makupa API User Story

## Current Features

As a user of the Makupa API, I want to:

1. Register for an account securely
    - Provide my email, username, and password
    - Receive an OTP via email for account verification

2. Verify my account
    - Enter the OTP received via email
    - Have my account marked as verified upon successful OTP entry

3. Log in to my account
    - Use my email and password to authenticate
    - Receive a JWT token for subsequent authenticated requests

4. Use the API securely
    - Include my JWT token in API requests for authentication

## Planned Features

As an administrator, I want to:

1. Access an admin dashboard
    - View all added jobs
    - See statistics of jobs added
    - Monitor user data, including login/logout times

2. Manage jobs
    - Add new jobs manually
    - Categorize jobs as remote or worldwide
    - View, edit, and delete existing jobs

3. View job statistics
    - See visual representations of job data (e.g., charts, graphs)
    - Filter statistics by category, date range, etc.

4. Manage users
    - View user account details
    - Monitor user activity (login/logout times)
    - Perform administrative actions on user accounts if necessary

As a user, I want to:

1. Access a React web interface
    - View available jobs
    - Filter jobs by category (remote, worldwide)
    - Apply for jobs through the platform

2. Receive job notifications
    - Get alerts for new jobs matching my preferences
    - Receive updates on the status of my job applications

As the system, I want to:

1. Scrape jobs from external APIs
    - Automatically fetch job listings from configured sources
    - Categorize scraped jobs as remote or worldwide
    - Update the job database with new listings regularly

2. Ensure data consistency
    - Avoid duplicate job listings
    - Update existing job listings with new information when available

3. Provide API endpoints for the React frontend
    - Serve job listings, user data, and other necessary information
    - Handle user authentication and authorization

4. Generate comprehensive logs
    - Track system activities for debugging and auditing purposes
    - Log user actions for security and analytics

## Technical Considerations

- The API is built with Java and Spring Boot
- Data is stored in MongoDB
- Email notifications are sent using SendGrid
- User authentication is handled with JWT
- Job scraping will be implemented to fetch jobs from external sources
- A React frontend will be developed to interact with the API
- Admin and user interfaces will be separate, with appropriate access controls


### Author

* [Cliff Gor](https://www.linkedin.com/in/cliff-gor/)

