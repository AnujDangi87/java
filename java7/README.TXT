------------------------------------------------------------------------
This is the project README file. Here, you should describe your project.
Tell the reader (someone who does not know anything about this project)
all they need to know. The comments should usually include at least:
------------------------------------------------------------------------

PROJECT TITLE:  Java Lab-7
PURPOSE OF PROJECT: Practise question/Assignment
VERSION or DATE:    19-02-2025
HOW TO START THIS PROJECT:
AUTHORS:    23MCCE16
USER INSTRUCTIONS: Please see the images to see to how to give input
                    1.Page class is used as inner class in Book class and then used as composition relationship.
                    2.Bag class have array of Book objects that store Book obects and giving him reference to Book instance through message passing this relationship is aggregation.

Comparison : 
    aggregation vs Composition :-
    1.Aggregation is used as 'whole-part' relationship we use part of a object in our other object that part can exists independently,
       aggregation have multiplicity and partial ownership
    2.Composition is used also as 'whole-part' but it has strong association and strong ownership. If owner object get destroyed than 
       the part object will also get destroyed.
    3.In Bag object if we destroy a Bag then Book can survive as whole different entity but the part of that object will get destroyed 
       so due to this real life example relationship between Bag and Book will be aggreagation because there will be multiple Book 
       object(Multiplicty in aggregation).
    4.Whereas when Book is destroyed the Page object will also get destroyed so this is a strong ownership so we use Compostion 
       relationship between Book and Page(in code i have used inner class concept to implement compostion by using inner private page class).

   
   Object vs Non-object oriented design :-
   1.Ood is useful to manage real-life problems that are difficult to manage in non-ood beacuse in real-life there is always communication 
      between objects.
   2.In the given problem Sll the sll object doesn't know what's happening behind the seen, the Node object are communicating with each other 
      using return or method passing.
   3.In new design mehtod like display() we are just saying that each node should print its own data instead of usesll doing it itself.
   4.In new Node design the deleteByValue(d) uses return and method passing to delete that node.
