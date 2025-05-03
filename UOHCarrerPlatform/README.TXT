------------------------------------------------------------------------
This is the project README file. Here, you should describe your project.
Tell the reader (someone who does not know anything about this project)
all they need to know. The comments should usually include at least:
------------------------------------------------------------------------

PROJECT TITLE: UOH Carrer Platform
PURPOSE OF PROJECT: A system for students and alumni at UoH to explore career opportunities and resources.
VERSION or DATE: version-1.0 date: 15-04-2025
HOW TO START THIS PROJECT: Run UOHCarrerPlatform class main() method, password for admin is admin
AUTHORS: 23MCCE16
USER INSTRUCTIONS:
    Problem Description : I have to create a application in which college current students and
                          alumni can explore job opportunities posted by recruiters and admin can 
                          manage posts and events.
                          I have used Arraylist and HashMap to store the data of jobs and resume of
                          the students and alumni.
    
    
    Installation Instruction : Run UOHCarrerPlatform main() method to start the application after that
                               program is userDriven.
    
                          
    Class Description : 
        1. User :  Parent class which contain type of user , name and password(only for admin).
        2. Resume : Extends User Contains resume data of user(student, alumni) also contains arraylist to store
                    at present how many different jobs have been applied for along with in how many jobs
                    user have been sortlisted . As all variable fiels are private getter methods are 
                    their and toString method that tells about the user resume.
        3. Job : Extends User and contans job related data fields and two Arraylist to hold the job applicants
                resume along, second to hold sortlisted resumes.As all fields are private getters method are 
                their along with toString method.
        4. Admin : Extends User uses take username and password from user, contains Arraylist to store
                  the events happening in university, Methods such as useAdmin to use admin class.
        5. Event : Contains variable to store data related to event with toString method for description
                    of the event.
        6. Recruiter : Contains recruiterId as main Variable along with a RecruiterDataStore in which all
                       jobs posted by that recruiter contains. Along with the methods to use this recuriter
                       Class.
        7. StudentAlumni : Contains userId as Variable which contain the user which is currently 
                           using the program along with a StudentAlumniDataStore in which all
                           resume posted by different users contains. Along with the methods to use this StudentAlumni
                           Class.
        8. StudentAlumniDataStore : A dataStore class that stores Student/Alunmi with its resume in a
                                    HashMap userId as its key and resume as its value. As all variables are
                                    Private in this class it contians getters.
        9. RecruiterDataStore : Contains a static variable to count the no of recruiter that has
                                been looged yet to make their id on that count, also contain a 
                                HashMap to store recruiterId with its Arraylist jobs.
        10. UOHCarrerPlatform : Main class that controles other class and act as a bridge for other class
                                Contians method to use other class. Have to run its main() method to use
                                Carrer Platform.