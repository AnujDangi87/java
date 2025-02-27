------------------------------------------------------------------------
This is the project README file. Here, you should describe your project.
Tell the reader (someone who does not know anything about this project)
all they need to know. The comments should usually include at least:
------------------------------------------------------------------------

PROJECT TITLE:  Java Lab-8
PURPOSE OF PROJECT: Practise question/Assignment
VERSION or DATE:    26-02-2025
HOW TO START THIS PROJECT:
AUTHORS:    23MCCE16
USER INSTRUCTIONS: Please see the images to see to how to give input
                    
Observation : 

Task 1 :-
        Part A:
        1.We can access public, default, and protected variable from inherited class A.Protected give inheritance public access.
            We can't access private directly we have to use a getter or setter.
        2.We can't access private vaiable in Inherited class also and even outside it.
        3.If we declare some variable that already decleared in Parent class and redeclare it with same name then the parent class variable will 
            get hidden and if you want to use that you have to use "super" keyword and for same class use "this" keyword.
        4.If i change the value of inherited variable then I can't access previous parent value even with super keyword.

        Part B:
        1.Classes Constructor executes in a hieraracy oreder, first it will executes parent/grandparent(hieraracy of parents) Constructor it will
            search for default constructor and if there is not then it will go to other argument constructor we have to give argument to parent 
            class constructor using super keywored(super(argument);) in that parent child.
        2.After executing parent it will go to child and this order continues until last child constructor is executed.
    
        Part C:
        1.When we override a method in child class the overrided method will take nearest value as its value ex. if a = 5 in parent and a = 8 in
            child then the overrided mehtod will use a = 8 as its value.
        2.If we want to use parent method that we overrided in child we have to use "super.method()" keyword.
